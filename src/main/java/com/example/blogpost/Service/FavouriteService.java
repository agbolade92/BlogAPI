package com.example.blogpost.Service;

import com.example.blogpost.Model.Favourite;

import java.util.List;

public interface FavouriteService {
    List<Favourite> getAllFavouriteById(long favouriteId);
    Favourite addToFavourite(long postId, long id);
    void removeFromFavourite(long id,long postId);
}
