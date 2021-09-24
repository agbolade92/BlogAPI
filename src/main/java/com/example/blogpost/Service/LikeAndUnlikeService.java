package com.example.blogpost.Service;

public interface LikeAndUnlikeService {
    Boolean likeAndUnlikePost(long postId,long userId);
    Boolean likeAndUnlikeComment(long commentId,long userId);
}
