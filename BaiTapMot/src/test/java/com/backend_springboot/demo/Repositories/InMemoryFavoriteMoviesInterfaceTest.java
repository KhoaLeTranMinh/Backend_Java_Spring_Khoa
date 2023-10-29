package com.backend_springboot.demo.Repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.backend_springboot.demo.Model.Movie;
import com.backend_springboot.demo.Model.User;

public class InMemoryFavoriteMoviesInterfaceTest {
    private InMemoryFavoriteMoviesInterface mockFavoriteMoviesObject;

    private static User user;
    private static Movie movie;
    private static Movie movie2;

    @BeforeEach
    public void BeforeEach() {
        mockFavoriteMoviesObject = new InMemoryFavoriteMoviesInterface();
    }

    @BeforeAll
    public static void BeforeAll() {
        user = mock(User.class);
        movie = mock(Movie.class);
        movie2 = mock(Movie.class);
    }

    @Test
    void testAddMoviesToListReturnsCorrectMap() {
        // each test case is done seperately. mockFavoriteMoviesObject seems to be
        // static, but it actually got reinstalled
        mockFavoriteMoviesObject.addToFavoriteList(user, movie);
        mockFavoriteMoviesObject.addToFavoriteList(user, movie2);

        List<Movie> expectedList = new ArrayList<Movie>();
        expectedList.add(movie);
        expectedList.add(movie2);

        Map<User, List<Movie>> expectedMap = new HashMap<>();
        expectedMap.put(user, expectedList);

        assertEquals(expectedMap, mockFavoriteMoviesObject.getUserFavoritesMap());

    }

    @Test
    void testRemoveMovie() {
        mockFavoriteMoviesObject.addToFavoriteList(user, movie);
        mockFavoriteMoviesObject.addToFavoriteList(user, movie2);
        mockFavoriteMoviesObject.removeMovie(user, movie);

        // testMap = InMemoryFavoriteMoviesInterface.getUserFavoritesMap();
        List<Movie> expectedList = new ArrayList<Movie>();
        expectedList.add(movie2);
        Map<User, List<Movie>> expectedMap = new HashMap<>();
        expectedMap.put(user, expectedList);
        assertEquals(expectedMap, mockFavoriteMoviesObject.getUserFavoritesMap());
    }
}
