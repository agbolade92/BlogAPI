package com.example.blogpost.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private long postCount;
}
