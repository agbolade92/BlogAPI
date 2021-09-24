package com.example.blogpost.DTO;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private long id;
}
