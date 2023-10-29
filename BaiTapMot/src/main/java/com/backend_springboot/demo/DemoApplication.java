package com.backend_springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.backend_springboot.demo.Model.Movie;
import com.backend_springboot.demo.Model.User;
import com.backend_springboot.demo.Repositories.InMemoryFavoriteMoviesInterface;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		User user = new User(0, "Khoa", 20);
		User user2 = new User(1, "Minh", 25);
		Movie movie = new Movie(0, "Steins Gate");
		Movie movie2 = new Movie(1, "Your Name");
		Movie movie3 = new Movie(2, "Your Lie in April");
		InMemoryFavoriteMoviesInterface favoriteMovies = new InMemoryFavoriteMoviesInterface();
		favoriteMovies.addToFavoriteList(user, movie);
		favoriteMovies.addToFavoriteList(user, movie2);
		favoriteMovies.addToFavoriteList(user2, movie);
		favoriteMovies.addToFavoriteList(user2, movie2);
		favoriteMovies.addToFavoriteList(user2, movie3);
		favoriteMovies.removeMovie(user2, movie);
		favoriteMovies.printUserWithFavorites(user);
		favoriteMovies.printUserWithFavorites(user2);
		System.out.println(favoriteMovies.getUserFavoritesMap());
	}

}
