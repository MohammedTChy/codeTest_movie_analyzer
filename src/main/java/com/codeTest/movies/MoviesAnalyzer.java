package com.codeTest.movies;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;


public class MoviesAnalyzer {

    public MoviesAnalyzer(List<Movie> movies, List<User> users) {
        this.movies = movies;
        this.users = users;
    }

    private final List<Movie> movies;
    private final List<User> users;

    public List<String> topFavouriteMoviesAmongFriends(int userId) {
        // Find the friends of the given user
        List<Integer> friends = new ArrayList<>();
        for (User user : users) {
            if (user.getUserId() == userId) {
                friends = user.getFriends();
                break;
            }
        }
    
        // Create a map to store the number of times each movie is favorited by the friends
        Map<String, Integer> movieFavorites = new HashMap<>();
        for (Movie movie : movies) {
            for (Integer friend : friends) {
                if (movie.getFavorites().contains(friend)) {
                    if (movieFavorites.containsKey(movie.getTitle())) {
                        movieFavorites.put(movie.getTitle(), movieFavorites.get(movie.getTitle()) + 1);
                    } else {
                        movieFavorites.put(movie.getTitle(), 1);
                    }
                }
            }
        }
    
        // Sort the movies by the number of times they are favorited, then alphabetically
        List<String> topMovies = new ArrayList<>(movieFavorites.keySet());
        topMovies.sort((a, b) -> {
            int compare = Integer.compare(movieFavorites.get(b), movieFavorites.get(a));
            if (compare == 0) {
                return a.compareTo(b);
            }
            return compare;
        });
    
        // Return the top 3 movies
        return topMovies.subList(0, Math.min(3, topMovies.size()));
    }
    
}
