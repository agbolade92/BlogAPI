package com.example.blogpost.Model;

import com.example.blogpost.Enums.AccountStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    @Length(min=5, message="*Your username must be least 5 characters")
    private String userName;
    @Length(min = 5,message = "*Your password must be least 5 characters")
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    @OneToOne
    private Connection connection;
    @OneToMany
    private List<Post> posts;
    @OneToOne
    private Favourite favourite;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    public User(Long id, String firstName, String lastName, String userName, String password, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
