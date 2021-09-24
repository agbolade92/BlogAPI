//package com.example.blogpost;
//
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//
//
//import com.example.blogpost.Model.User;
//import com.example.blogpost.Repository.UserRepository;
//import com.example.blogpost.Service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//
//
//@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("test")
//public class UserTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//    private List<User> userList;
//    private String uri = "/api/v1/users";
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserService userService;
//
//
////    @Test
////    void testRegisterUser(){
////        final User user = new User(1L, "Tom","Jerry","Tomjerry","123456","tomjerry@gmail.com");
////        given(userRepository.save(user)).willReturn(user);
////        when(userRepository.save(user)).then(invocation -> invocation.getArguments(0));
////    }
//}
