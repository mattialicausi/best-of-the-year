package org.spring.bestoftheyear.controller;

import org.spring.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movies(Model model) {
        List<Movie> movieList = getBestMovies();

        model.addAttribute("movieList", movieList);

        return "movies";

    }

    @GetMapping("/{id}")
    public String movies(@PathVariable("id") int movieId, Model model) {

        List<Movie> movieList = getBestMovies();

        for (Movie m : movieList) {

            if (m.getId() == movieId) {

                model.addAttribute("movie", m);

            }
        }
        return "movie-detail";
    }

    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "The walf of wall street"));
        movies.add(new Movie(2, "Thruman show"));
        movies.add(new Movie(3, "Thruman show"));
        movies.add(new Movie(4, "Thruman show"));
        return movies;
    }
}
