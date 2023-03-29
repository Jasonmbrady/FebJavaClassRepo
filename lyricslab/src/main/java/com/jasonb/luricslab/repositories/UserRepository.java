package com.jasonb.luricslab.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.luricslab.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByEmail(String email);
}
