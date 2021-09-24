package com.example.blogpost.Controller;

import com.example.blogpost.Model.Post;
import com.example.blogpost.Service.ConnectionService;
import com.example.blogpost.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/connection")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/{mainId}/{id}")
    public ApiResponse connectionHandler(@PathVariable(name = "mainId") long userId, @PathVariable(name = "id") long id){
        connectionService.addUserToConnection(userId, id);
        return new ApiResponse(Boolean.TRUE,"This user has been added to connection");
    }

    @GetMapping("/list/{id}")
    public ApiResponse displayPostsByConnection(@PathVariable(name="id") long id){
        List<Post> connectionPosts = connectionService.displayPostByConnection(id);
        if(!connectionPosts.isEmpty()){
            return new ApiResponse(HttpStatus.ACCEPTED,connectionPosts);
        }else{
            return new ApiResponse("There is no post available", HttpStatus.NO_CONTENT);
        }
    }

}
