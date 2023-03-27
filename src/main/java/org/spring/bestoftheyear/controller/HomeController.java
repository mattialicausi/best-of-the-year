package org.spring.bestoftheyear.controller;

import org.spring.bestoftheyear.model.Movie;
import org.spring.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Model model, @RequestParam(name = "name", required = true) String nameQueryString) {

        model.addAttribute("name", nameQueryString);
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movieList = getBestMovies();

        String movie = "";
        for (Movie m : movieList) {
            movie += m.getTitle() + ", ";

        }

        model.addAttribute("movies", movie);

        return "movies";

    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songList = getBestSongs();

        String song = "";
        for (Song s : songList) {
            song += s.getTitle() + ", ";

        }

        model.addAttribute("songs", song);

        return "songs";

    }

    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(5, "The walf of wall street"));
        movies.add(new Movie(1, "Thruman show"));
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(5, "alallal"));
        songs.add(new Song(1, "gggg"));
        return songs;
    }

}
