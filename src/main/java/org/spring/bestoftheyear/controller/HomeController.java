package org.spring.bestoftheyear.controller;

import org.spring.bestoftheyear.model.Movie;
import org.spring.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        movie = movie.substring(0, movie.length() -1);
        model.addAttribute("movies", movie);

        return "movies";

    }

    @GetMapping("/movie/{id}")
    public String movies(@PathVariable("id") int movieId, Model model) {

        List<Movie> movieList = getBestMovies();

        for(Movie m : movieList) {
            if(m.getId() == movieId) {
                model.addAttribute("movie", m.getTitle());

                break;
            }
        }
        return "movies";
    }

    @GetMapping("/song/{id}")
    public String songs(@PathVariable("id") int songId, Model model) {

        List<Song> songList = getBestSongs();

        for(Song s : songList) {
            if(s.getId() == songId) {
                model.addAttribute("song", s.getTitle());

                break;
            }
        }
        return "songs";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songList = getBestSongs();

        String song = "";
        for (Song s : songList) {
            song += s.getTitle() + ", ";

        }

        song = song.substring(0, song.length() -1);
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
