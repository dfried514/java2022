package com.friedman.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friedman.lookify.models.Song;
import com.friedman.lookify.services.LookifyService;

@Controller
public class LookifyController {

		@Autowired
		LookifyService lookifyService;
		
		@GetMapping("/")
		public String index() {
			return "index.jsp";
		}
		@GetMapping("/dashboard") 
		public String dashboard(Model model) {
			List<Song> songs = lookifyService.allSongs();
			model.addAttribute("songs", songs);
			return "dashboard.jsp";
		}
		@GetMapping("songs/new")
		public String newSong(@ModelAttribute("song") Song song) {
			return "new.jsp";
		}
		@GetMapping("/songs/{id}")
		public String show(@PathVariable("id") Long id, Model model) {
			Song song = lookifyService.findSong(id);
			model.addAttribute("song", song);
			return "show.jsp";
		}
		@GetMapping("/search/{artist}")
		public String songsByArtist(@PathVariable("artist") String artist, Model model) {
			List<Song> songs = lookifyService.allSongsByArtistContaining(artist);
			model.addAttribute("songs", songs);
			return "songList.jsp";
		}
		@GetMapping("/search/topTen")
		public String topTen(Model model) {
			List<Song> songs = lookifyService.top10SongsOrderedByRating();
			model.addAttribute("songs", songs);
			return "topTen.jsp";
		}
		@PostMapping("/search") 
		public String processSearch(Model model, @RequestParam(value="artist") String artist) {
			List<Song> songs = lookifyService.allSongsByArtistContaining(artist);
			model.addAttribute("songs", songs);
			model.addAttribute("artist", artist);
			return "songList.jsp";
		}
		@PostMapping("/songs")
		public String createSong(Model model, @Valid @ModelAttribute("song") Song song,
				BindingResult result) {
			if (result.hasErrors()) 
				return "new.jsp";
			else {
				lookifyService.createSong(song);
				return "redirect:/dashboard";
			}
		}
		@RequestMapping("/songs/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			lookifyService.deleteSong(id);
			return "redirect:/dashboard";
		}
}
