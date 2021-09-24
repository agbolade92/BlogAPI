package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.PostRepository;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post addPost(String content, String title, Long UserId) {
        Post post = new Post();
        User user = userRepository.findById(UserId).get();
        LocalDateTime timeCreated = LocalDateTime.now();
        post.setContent(content);
        post.setTitle(title);
        post.setTimeCreated(timeCreated);
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public void removePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }
}
