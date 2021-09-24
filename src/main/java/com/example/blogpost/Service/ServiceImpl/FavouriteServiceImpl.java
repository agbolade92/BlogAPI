package com.example.blogpost.Service.ServiceImpl;

import com.example.blogpost.Model.Favourite;
import com.example.blogpost.Model.Post;
import com.example.blogpost.Model.User;
import com.example.blogpost.Repository.FavouriteRepository;
import com.example.blogpost.Repository.PostRepository;
import com.example.blogpost.Repository.UserRepository;
import com.example.blogpost.Service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Favourite> getAllFavouriteById(long favouriteId) {
        Favourite favourite = favouriteRepository.findById(favouriteId).get();
        List<Favourite> listOfFavourite = new ArrayList<>();
        listOfFavourite.add(favourite);
        return listOfFavourite;
    }

    @Override
    public Favourite addToFavourite(long postId, long id) {
        Favourite saveFavourite = new Favourite();
    User user = userRepository.getById(id);
    Post post = postRepository.getById(postId);
    Optional<Favourite> favouriteOptional = favouriteRepository.findFavouriteByUser(user);
      if(favouriteOptional.isEmpty()){
          Favourite favourite = new Favourite();
          favourite.setUser(user);
          List<Post> listOfPost = new ArrayList<>();
          listOfPost.add(post);
          favourite.setFavouritePost(listOfPost);
          saveFavourite = favouriteRepository.save(favourite);
      } else{
          List<Post> listOfPost = favouriteOptional.get().getFavouritePost();
          listOfPost.add(post);
          favouriteOptional.get().setFavouritePost(listOfPost);
          saveFavourite = favouriteRepository.save(favouriteOptional.get());
      }
        return saveFavourite;
    }

    @Override
    public void removeFromFavourite(long id, long postId) {
        Favourite favourite = favouriteRepository.getById(id);
        List<Post> listOfFavourite = favourite.getFavouritePost();
        Post post = postRepository.getById(postId);
        for(Post onePost:listOfFavourite){
            if(onePost.equals(post)){
                listOfFavourite.remove(post);
                favourite.setFavouritePost(listOfFavourite);
                favouriteRepository.save(favourite);
            }
        }
    }
}
