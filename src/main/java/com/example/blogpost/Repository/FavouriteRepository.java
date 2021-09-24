package com.example.blogpost.Repository;

import com.example.blogpost.Model.Favourite;
import com.example.blogpost.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavouriteRepository extends JpaRepository<Favourite,Long> {
    Optional<Favourite> findFavouriteByUser(User user);
    Favourite findFavouritesById(Long id);
}
