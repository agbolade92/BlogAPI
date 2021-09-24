package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Model.Comment;
import com.example.blogpost.Model.LikeAndUnlike;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.CommentRepository;
import com.example.blogpost.Repository.LikeAndUnlikeRepository;
import com.example.blogpost.Repository.PostRepository;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.LikeAndUnlikeService;
import com.example.blogpost.Service.UserService;
import com.example.blogpost.exceptions.BlogApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeAndUnlikeServiceImpl implements LikeAndUnlikeService {

    @Autowired
    private LikeAndUnlikeRepository likeAndUnlikeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean likeAndUnlikePost(long postId, long userId) {
        Post post = postRepository.getById(postId);
        User user = userRepository.getById(userId);
        Boolean status;

        if (user == null) {
            throw new BlogApiException(HttpStatus.NO_CONTENT, "User not found");
        } else if (post == null) {
            throw new BlogApiException(HttpStatus.NO_CONTENT, "Post not found");
        } else {
            Optional<LikeAndUnlike> likeAndUnlikeOptional = likeAndUnlikeRepository.findLikeAndUnlikeByUserAndPost(user, post);
            if (likeAndUnlikeOptional.isPresent()) {
                likeAndUnlikeRepository.delete(likeAndUnlikeOptional.get());
                status = false;
            } else {
                LikeAndUnlike likeAndUnlike = new LikeAndUnlike();
                likeAndUnlike.setPost(post);
                likeAndUnlike.setUser(user);
                likeAndUnlikeRepository.save(likeAndUnlike);
                status = true;
            }
        }

        return status;
    }

    @Override
    public Boolean likeAndUnlikeComment(long commentId, long userId) {
        Comment comment = commentRepository.getById(commentId);
        User user = userRepository.getById(userId);
        Boolean status;
        if(user == null){
            throw new BlogApiException(HttpStatus.NO_CONTENT,"user not found");
        } else if(comment == null){
            throw new BlogApiException(HttpStatus.NO_CONTENT,"Comment does not exist");
        } else {
            Optional<LikeAndUnlike> likeAndUnlikeOptional = likeAndUnlikeRepository.findLikeAndUnlikeByUserAndComment(user,comment);
            if(likeAndUnlikeOptional.isPresent()){
                likeAndUnlikeRepository.delete(likeAndUnlikeOptional.get());
                status = false;
            } else{
                LikeAndUnlike likeAndUnlike = new LikeAndUnlike();
                likeAndUnlike.setComment(comment);
                likeAndUnlike.setUser(user);
                status= true;
                likeAndUnlikeRepository.save(likeAndUnlike);
            }
        }
        return status;
    }
}
