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

        String song = "";
        for (Song s : songList) {
            song += s.getTitle() + ", ";

        }

        song = song.substring(0, song.length() -2);
        model.addAttribute("songs", song);

        return "songs";

    }

    @GetMapping("/{id}")
    public String songs(@PathVariable("id") int songId, Model model) {

        List<Song> songList = getBestSongs();

        for(Song s : songList) {

            if(s.getId() == songId) {

                model.addAttribute("song", s);

            }
        }
        return "song-detail";
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "alallal"));
        songs.add(new Song(2, "gggg"));
        return songs;
    }
}
