package com.jasonb.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.loginreg.models.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long>{
	

}
