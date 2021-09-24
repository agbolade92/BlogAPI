package com.example.blogpost.Service;

import com.example.blogpost.Model.Comment;
import com.example.blogpost.payload.CommentRequest;
import io.swagger.annotations.ApiResponse;

public interface CommentService {
    Comment addCommentToPost(CommentRequest commentRequest, Long postId, Long userId);
    Comment getComment(Long postId,long id);
    Comment updateComment(long postId, CommentRequest commentRequest,long userId);
    ApiResponse deleteComment(long postId,long id,long userId);
}
