package com.example.blogpost.Controller;

import com.example.blogpost.DTO.PostDto;
import com.example.blogpost.Model.Comment;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Service.CommentService;
import com.example.blogpost.Service.PostService;
import com.example.blogpost.payload.ApiResponse;
import com.example.blogpost.payload.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/allPosts")
    public ResponseEntity<List<Post>> allPosts(){
        List<Post> posts = postService.getAllPosts();
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE,"success");
        return new ResponseEntity<>(posts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id]")
    public ResponseEntity<Post> getPostById(@PathVariable(value="id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PostMapping("/save/{userId}")
    public ResponseEntity<Post> savePost(@RequestBody PostDto postDto, @PathVariable(name = "userId") long id){
        Post post = postService.addPost(postDto.getPost(), postDto.getTitle(),id);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(name = "id") long id,@RequestBody PostDto post){
        Post edittedPost = postService.getPostById(id);
        edittedPost.setContent(post.getPost());
        edittedPost.setTitle(post.getTitle());
        postService.updatePost(edittedPost);
        return new ResponseEntity<>(edittedPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(value = "id") long id){
        postService.removePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/comment/{id}/{userId}")
    public ResponseEntity<Comment> addCommentToPost(@Valid @PathVariable(name = "id") long postId, @PathVariable(name="userId") long userId, @RequestBody CommentRequest commentRequest){
        Comment comment = commentService.addCommentToPost(commentRequest,postId,userId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

}
