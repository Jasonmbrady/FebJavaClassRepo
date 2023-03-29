package com.jasonb.luricslab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jasonb.luricslab.models.Song;
import com.jasonb.luricslab.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
	
	public Song findById(Long id) {
		Optional<Song> optSong = songRepo.findById(id);
		if (optSong.isEmpty()) {
			return null;
		} else {
			return optSong.get();
		}
	}
	
	public Song save(Song s) {
		return songRepo.save(s);
	}
	
	public List<Song> findAll(){
		return songRepo.findAll();
	}
	
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
	
	public Song newSong(Song s, BindingResult result) {
		Optional<Song> optSong = songRepo.findByTitle(s.getTitle());
		if (optSong.isPresent()) {
			result.rejectValue("title", null, "That title is already taken!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return s;
	}
}
