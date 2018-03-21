package com.inkarkapen.lookify.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import com.inkarkapen.lookify.models.Song;
import com.inkarkapen.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private static LookifyRepository lookifyRepo;
	public LookifyService(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}
	public List<Song> showAll(){
		return lookifyRepo.findAll();
	}
	public void addSong(@Valid Song song) {
		lookifyRepo.save(song);
	}
	public void deleteSong(Long id) {
		lookifyRepo.deleteById(id);
	}
	public Song findOne(Long id) {
		return lookifyRepo.findById(id).orElse(null);
	}
	public List<Song> searchByArtist(String artist){
		return lookifyRepo.findByArtist(artist);
	}
	public List<Song> topSongs(){
		return lookifyRepo.findTop10ByOrderByRatingDesc();
	}
}
