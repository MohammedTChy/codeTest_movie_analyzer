package com.codeTest.movies;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoviesAnalyzerTest {

    private List<Movie> movies;
    private List<User> users;

    @Before
    public void setUp() throws Exception {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Movie>>(){}.getType();
        Type usersListType = new TypeToken<ArrayList<User>>(){}.getType();

        movies = gson.fromJson(new FileReader(Paths.get(MoviesAnalyzerTest.class.getResource("/movies.json").toURI()).toFile()), listType);
        users = gson.fromJson(new FileReader(Paths.get(MoviesAnalyzerTest.class.getResource("/users.json").toURI()).toFile()), usersListType);
    }

    @Test(timeout = 1000)
    public void shouldReturnTop3ForFirstUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(15291);

        //then
        assertThat(titles).isEqualTo(Lists.newArrayList("Pulp Fiction", "The Godfather", "Schindler's List"));
    }

    @Test(timeout = 1000)
    public void shouldReturnTop3ForSecondUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(7001);

        //then
        assertThat(titles).isEqualTo(Lists.newArrayList("Pulp Fiction", "Schindler's List", "The Godfather"));
    }
    @Test(timeout = 1000)
    public void shouldReturnTop3ForThirdUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(51417);

        //then
        assertThat(titles).isEqualTo(Lists.newArrayList("The Dark Knight", "The Godfather", "The Shawshank Redemption"));
    }
    @Test(timeout = 1000)
    public void shouldReturnTop3ForFourthUser() {
        //given
        MoviesAnalyzer moviesAnalyzer = new MoviesAnalyzer(movies, users);

        //when
        List<String> titles = moviesAnalyzer.topFavouriteMoviesAmongFriends(62289);

        //then
        assertThat(titles).isEqualTo(Lists.newArrayList("The Dark Knight", "The Godfather", "Pulp Fiction"));
    }
}
