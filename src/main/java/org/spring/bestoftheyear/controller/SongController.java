package org.spring.bestoftheyear.controller;

import org.spring.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String songs(Model model) {
        List<Song> songList = getBestSongs();

        model.addAttribute("songList", songList);

        return "songs";

    }

    @GetMapping("/{id}")
    public String songs(@PathVariable("id") int songId, Model model) {

        List<Song> songList = getBestSongs();

        for(Song s : songList) {

            model.addAttribute("song", s);

        }
        return "song-detail";
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Felicità"));
        songs.add(new Song(2, "50 special"));
        songs.add(new Song(3, "L'amour Toujours"));
        songs.add(new Song(4, "Bla Bla Bla"));
        return songs;
    }
}
