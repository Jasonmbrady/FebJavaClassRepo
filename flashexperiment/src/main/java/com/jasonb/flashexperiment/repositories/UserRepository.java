package com.jasonb.flashexperiment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.flashexperiment.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public List<User> findAll();
	public Optional<User> findByEmail(String email);
}
