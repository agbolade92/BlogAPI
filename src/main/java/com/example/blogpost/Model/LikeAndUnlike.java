package com.example.blogpost.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeAndUnlike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private Post post;
    @OneToOne
    private User user;
    @ManyToOne
    private Comment comment;
}
