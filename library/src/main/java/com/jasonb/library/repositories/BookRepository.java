package com.jasonb.library.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.library.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

	@Override
	public List<Book> findAll();
}
