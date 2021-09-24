package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Enums.AccountStatus;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.UserService;
import com.example.blogpost.exceptions.BlogApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User saveUser(User user) {
        if (user.getEmail() == null) {
            throw new BlogApiException("The email already exists");
        } else {
            user.setAccountStatus(AccountStatus.ACTIVE);
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(long id) throws InterruptedException {
       User user = userRepository.getById(id);
       user.setAccountStatus(AccountStatus.DELETED);
       //removeUserBySchedule();
//       if (user.getAccountStatus().equals(AccountStatus.DELETED)){
//           userRepository.delete(user);
//        }

        userRepository.save(user);

    }

    @Scheduled(fixedDelay = 100000)
    @Override
    public void removeUserBySchedule() throws InterruptedException {
        log.info("I am waiting for 1min before executing");
        TimeUnit.MINUTES.sleep(1);
        List<User> users = userRepository.findByAccountStatus(AccountStatus.DELETED);
        userRepository.deleteAll(users);
    }

    @Override
    public User restoreUserAccount(long id) {
        User user = userRepository.getById(id);
        if (user.getAccountStatus().equals(AccountStatus.DELETED)) {
            user.setAccountStatus(AccountStatus.ACTIVE);
            return userRepository.save(user);
        }
        return user;
    }
}
