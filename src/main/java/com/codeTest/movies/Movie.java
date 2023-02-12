package com.codeTest.movies;

import java.util.List;

public class Movie {

    private String title;
    private String duration;
    private List<String> actors;
    private List<Integer> watchlist;
    private List<Integer> favorites;
    private List<Rating> ratings;

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public List<String> getActors() {
        return actors;
    }

    public List<Integer> getWatchlist() {
        return watchlist;
    }

    public List<Integer> getFavorites() {
        return favorites;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
}
