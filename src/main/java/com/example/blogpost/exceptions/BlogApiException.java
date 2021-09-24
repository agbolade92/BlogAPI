package com.example.blogpost.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@NoArgsConstructor
public class BlogApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BlogApiException(HttpStatus status, String message){
        super();
        this.status = status;
        this.message = message;
    }

    public BlogApiException(String message){
        this.message = message;
    }
}
