package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Model.Comment;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.CommentRepository;
import com.example.blogpost.Repository.PostRepository;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.CommentService;
import com.example.blogpost.exceptions.BlogApiException;
import com.example.blogpost.payload.CommentRequest;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addCommentToPost(CommentRequest commentRequest, Long postId, Long userId) {
        Post post = postRepository.getById(postId);
        User user = userRepository.getById(userId);
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setContent(commentRequest.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Long postId, long id) {
        Post post = postRepository.getById(postId);
        Comment comment = commentRepository.getById(id);
        if(comment.getPost().getId().equals(post.getId())){
        return comment;
        } throw new BlogApiException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
    }

    @Override
    public Comment updateComment(long postId, CommentRequest commentRequest, long userId) {
        return null;
    }

    @Override
    public ApiResponse deleteComment(long postId, long id, long userId) {
        return null;
    }
}
