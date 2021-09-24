package com.example.blogpost.Repository;

import com.example.blogpost.Model.Comment;
import com.example.blogpost.Model.LikeAndUnlike;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeAndUnlikeRepository extends JpaRepository<LikeAndUnlike,Long> {
    Optional<LikeAndUnlike> findLikeAndUnlikeByUserAndComment(User user, Comment comment);
    Optional<LikeAndUnlike> findLikeAndUnlikeByUserAndPost(User user, Post post);
}
