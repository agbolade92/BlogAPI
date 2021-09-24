package com.example.blogpost.Repository;

import com.example.blogpost.Model.Connection;
import com.example.blogpost.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection,Long> {
    List<Connection> findConnectionsByUser(User user);
    Optional<Connection> findByUserAndConnectionUsers(User user,User connectionUser);
}
