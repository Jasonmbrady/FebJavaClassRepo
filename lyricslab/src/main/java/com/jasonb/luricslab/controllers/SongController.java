package com.jasonb.luricslab.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jasonb.luricslab.models.Song;
import com.jasonb.luricslab.models.User;
import com.jasonb.luricslab.services.SongService;
import com.jasonb.luricslab.services.UserService;
@Controller
@RequestMapping("/song")
public class SongController {
	@Autowired
	private SongService songServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/new")
	public String newSong(@ModelAttribute("song") Song song) {
		
		return "newSong.jsp";
	}
	
	@PostMapping("/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result, HttpSession session) {
		Song newSong = songServ.newSong(song, result);
		if(newSong == null) {
			return "newSong.jsp";
		}
		User user = userServ.findById((Long) session.getAttribute("userId"));
		newSong.setSubmittedBy(user);
		songServ.save(newSong);
		return "redirect:/home";
				
	}
	
	@GetMapping("/{id}")
	public String viewSong(Model model, @PathVariable("id") Long id) {
		
		Song song = songServ.findById(id);
		ArrayList<User> collaborators = new ArrayList<User>();
		for(User oneUser : song.getCollaborators()) {
			if (!collaborators.contains(oneUser)) {
				collaborators.add(oneUser);
			}
		}
		model.addAttribute("collabList", collaborators);
		model.addAttribute("song", song);
		return "viewSong.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String editSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songServ.findById(id));
		return "editSong.jsp";
	}
	
	@PutMapping("/{songId}/edit")
	public String updateSong(@Valid @ModelAttribute("song") Song song, BindingResult result, @PathVariable("songId") Long songId, @RequestParam(name="newLyrics") String newLyrics, HttpSession session) {
		if (result.hasErrors()) {
			return "editSong.jsp";
		}
		song.setId(songId);
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		List<User> collabList = song.getCollaborators();
		collabList.add(user);
		song.setCollaborators(collabList);	
//		Song thisSong = songServ.findById(songId);
//		song.setSubmittedBy(thisSong.getSubmittedBy());
		newLyrics = "/" + newLyrics;
		song.setLyrics(song.getLyrics() + newLyrics);
		songServ.save(song);
		return "redirect:/song/" + songId;
	}
	
	@DeleteMapping("/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songServ.delete(id);
		return "redirect:/home";
	}
	
}
