package com.backend_springboot.demo.Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.backend_springboot.demo.Model.Movie;
import com.backend_springboot.demo.Model.User;

public class InMemoryFavoriteMoviesInterface implements FavoriteMoviesInterface {
    private final Map<User, List<Movie>> userFavoritesMap = new HashMap<>();

    public void addToFavoriteList(User user, Movie movie) {

        if (!userFavoritesMap.containsKey(user)) {
            List<Movie> initialList = new ArrayList<>(Arrays.asList(movie));
            userFavoritesMap.put(user, initialList);
            return;
        }

        List<Movie> currenList = userFavoritesMap.get(user);

        addMovie(movie, currenList);
        userFavoritesMap.put(user, currenList);
    }

    public void addMovie(Movie movie, List<Movie> currentList) {
        currentList.add(movie);
    }

    public void removeMovie(User user, Movie movie) {
        List<Movie> currentList = userFavoritesMap.get(user);
        if (currentList.contains(movie)) {
            currentList.remove(movie);
        }
    }

    public void printUserWithFavorites(User user) {
        System.out.print(user.getName() + "'s favorites movies are: [");
        for (Movie movie : userFavoritesMap.get(user)) {
            System.out.print(movie.getTitle() + ",");
        }
        System.out.print("]\n");
    }

    public Map<User, List<Movie>> getUserFavoritesMap() {
        return this.userFavoritesMap;
    }

}