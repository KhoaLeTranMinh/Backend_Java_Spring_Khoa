package com.backend_springboot.demo.Repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend_springboot.demo.Model.Movie;
import com.backend_springboot.demo.Model.User;

public interface FavoriteMoviesInterface {
    final Map<User, List<Movie>> userFavoritesMap = new HashMap<>();

    void addToFavoriteList(User user, Movie movie);

    void addMovie(Movie movie, List<Movie> currentList);

    void removeMovie(User user, Movie movie);

    void printUserWithFavorites(User user);

    Map<User, List<Movie>> getUserFavoritesMap();
}
