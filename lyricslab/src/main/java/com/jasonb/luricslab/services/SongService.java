package com.jasonb.luricslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.luricslab.repositories.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository songRepo;
}
