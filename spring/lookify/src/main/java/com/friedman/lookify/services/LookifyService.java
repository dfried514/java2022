package com.friedman.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.friedman.lookify.models.Song;
import com.friedman.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {

	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	public List<Song> allSongs() {
		return lookifyRepository.findAll();
	}
	public List<Song> allSongsByArtistContaining(String infix) {
		return lookifyRepository.findByArtistContaining(infix);
	}
	public List<Song> top10SongsOrderedByRating() {
		return lookifyRepository.findTop10ByOrderByRatingDesc();
	}
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	public Song createSong(Song song) {
		return lookifyRepository.save(song);
	}
	public Song updateSong(Long id, Song song) {
		Optional<Song> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) {
			song.setId(id);
			return lookifyRepository.save(song);
		} else {
			return null;
		}
	}
	public void deleteSong(Long id) {
		lookifyRepository.deleteById(id);
	}
}

