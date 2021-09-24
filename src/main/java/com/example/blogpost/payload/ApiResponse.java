package com.example.blogpost.payload;

import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Data
@JsonPropertyOrder({
        "success",
        "message"
})
public class ApiResponse implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private HttpStatus status;
    @JsonProperty
    private Optional<User> user;
    @JsonProperty
    private List<Post> posts;

    public ApiResponse(){

    }

    public ApiResponse(Boolean success, String message){
        this.success = success;
        this.message = message;

    }

    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ApiResponse(Boolean success, String message, Optional<User> user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public ApiResponse(HttpStatus status, List<Post> posts) {
        this.status = status;
        this.posts = posts;
    }

    public ApiResponse(Boolean success, String message, HttpStatus status){
        this.success = success;
        this.message = message;
        this.status = status;

    }
}
