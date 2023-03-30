package com.jasonb.apizza.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.apizza.models.Pizza;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Long>{

	public List<Pizza> findAll();
}
