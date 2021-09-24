package com.example.blogpost.Service;

import com.example.blogpost.Model.Connection;
import com.example.blogpost.Model.Post;

import java.util.List;

public interface ConnectionService {
    Connection addUserToConnection(long userId, long id);
    List<Post> displayPostByConnection(long userId);
}
