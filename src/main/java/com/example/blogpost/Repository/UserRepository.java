package com.example.blogpost.Repository;

import com.example.blogpost.Enums.AccountStatus;
import com.example.blogpost.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUserName(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email,String password);
    List<User> findByAccountStatus(AccountStatus accountStatus);
}
