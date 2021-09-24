package com.example.blogpost.Controller;

import com.example.blogpost.Model.Favourite;
import com.example.blogpost.Service.FavouriteService;
import com.example.blogpost.Service.PostService;
import com.example.blogpost.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favourite")
public class FavouriteController {

    @Autowired
    private PostService postService;

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/getFAvouritePost/{favouriteId}")
    public ResponseEntity<List<Favourite>> getAllFavouritePost(@PathVariable(name = "favId") long id){
        List<Favourite> favouritePosts = favouriteService.getAllFavouriteById(id);
        return new ResponseEntity<>(favouritePosts, HttpStatus.OK);
    }

    @PostMapping("/addToFavourite/{id}/save/{userId}")
    public ApiResponse addToFavourite(@PathVariable(name = "id") long postId,@PathVariable(name = "userId") long userId){
        favouriteService.addToFavourite(postId, userId);
        return new ApiResponse(Boolean.TRUE,"You successfully added the post to favourite");
    }

    @PostMapping("/removeFromFavourite/{id}/delete/{postId}")
    public ApiResponse removeFromFavourite(@PathVariable(name = "id") long favId,@PathVariable(name = "postId") long postId){
        favouriteService.removeFromFavourite(favId, postId);
        return new ApiResponse(Boolean.TRUE,"Post successfully removed from favourites");
    }
}
