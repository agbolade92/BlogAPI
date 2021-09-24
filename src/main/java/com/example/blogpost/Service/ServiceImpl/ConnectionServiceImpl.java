package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Model.Connection;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.ConnectionRepository;
import com.example.blogpost.Repository.PostRepository;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.ConnectionService;
import com.example.blogpost.exceptions.BlogApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionServiceImpl implements ConnectionService {

   @Autowired
   private ConnectionRepository connectionRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private PostRepository postRepository;

    @Override
    public Connection addUserToConnection(long userId, long id) {
        User connectionUser = userRepository.getById(id);
        User  user = userRepository.getById(userId);
        //Boolean status;
        Optional<Connection> connectionOptional = connectionRepository.findByUserAndConnectionUsers(user,connectionUser);
        if(connectionOptional.isEmpty()){
            Connection connection = new Connection();
            connection.setConnectionUsers(connectionUser);
            connection.setUser(user);
            return connectionRepository.save(connection);
        }else{
            throw new BlogApiException("this user has been connected to this user");
        }
    }

    @Override
    public List<Post> displayPostByConnection(long userId) {
        User user = userRepository.getById(userId);
        List<Connection> connection = connectionRepository.findConnectionsByUser(user);
        List<Post> listOfPosts = new ArrayList<>();
        if(!connection.isEmpty()){
            for(Connection userConnection:connection){
                User user1 = userConnection.getConnectionUsers();
                List<Post> posts  = postRepository.findPostsByUser(user1);
                listOfPosts.addAll(posts);
            }
        }
        return listOfPosts;
    }
}
