package com.jasonb.luricslab.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.luricslab.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	public List<Song> findAll();
}
