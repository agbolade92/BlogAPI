package com.example.blogpost.Service;

import com.example.blogpost.Model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post addPost(String content,String title,Long UserId);
    void removePost(Long id);
    void updatePost(Post post);
}
