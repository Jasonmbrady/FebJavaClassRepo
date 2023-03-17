package com.jasonb.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.loginreg.models.Topping;

@Repository
public interface ToppingRepository extends CrudRepository<Topping, Long>{

	public List<Topping> findAll();
}
