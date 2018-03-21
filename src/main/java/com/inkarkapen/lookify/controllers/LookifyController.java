package com.inkarkapen.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inkarkapen.lookify.models.Song;
import com.inkarkapen.lookify.services.LookifyService;



@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("song", new Song());
		List<Song> songs = lookifyService.showAll();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	@RequestMapping("/new")
	public String newSong(Model model) {
		model.addAttribute("song", new Song());
		return "new.jsp";
	}
	
	@PostMapping("/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(!result.hasErrors()) {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
		return "new.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/songs/{id}")
	public String showOne(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", lookifyService.findOne(id));
		return "song.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam(value = "search", required = true) String artist) {
		return "redirect:/search/"+artist;
	}
	@RequestMapping("/search/{artist}")
	public String searchByArtist(@PathVariable("artist") String artist, Model model) {
		List<Song> artistSongs = lookifyService.searchByArtist(artist);
		model.addAttribute("songs", artistSongs);
		return "search.jsp";
	}
	@RequestMapping("/search/")
	public String searchByNullArtist(Model model) {
		List<Song> artistSongs = lookifyService.showAll();
		model.addAttribute("songs", artistSongs);
		return "search.jsp";
	}
	@RequestMapping("/topSongs")
	public String topSongs(Model model) {
		List<Song> topSongs = lookifyService.topSongs();
		model.addAttribute("songs", topSongs);
		return "top.jsp";
	}
}
