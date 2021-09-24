package com.example.blogpost.Service;

import com.example.blogpost.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUserName(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email,String password);
    User saveUser(User user);
    List<User> getAllUsers();
    void deleteUserById(long id) throws InterruptedException;
    void removeUserBySchedule() throws InterruptedException;
    User restoreUserAccount(long id);
}
