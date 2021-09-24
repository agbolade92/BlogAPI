package com.example.blogpost.Controller;

import com.example.blogpost.DTO.UserDto;
import com.example.blogpost.Model.User;
import com.example.blogpost.Service.UserService;
import com.example.blogpost.payload.ApiResponse;
import com.example.blogpost.payload.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody UserProfile user){
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return new ResponseEntity<>(userService.saveUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ApiResponse userLogin(@Valid @RequestBody UserDto userLogin){
        Optional<User> user = userService.findUserByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        if(user.isPresent()){
            return new ApiResponse(Boolean.TRUE,"You are logged in as user",user);
        } else {
            return new ApiResponse("user not found", HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteUserAccount(@PathVariable(name = "id") long id) throws InterruptedException {
        userService.deleteUserById(id);
        return new ApiResponse("This User will be deleted after one minute", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<User> restoreUserAccount(@PathVariable(name = "id") long id){
        User user = userService.restoreUserAccount(id);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }

}
