package com.example.blogpost.Repository;

import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findPostsByUser(User user);
}
