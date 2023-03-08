package com.jasonb.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.library.models.Book;
import com.jasonb.library.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> findAll(){
		return bookRepo.findAll();
	}
	
	public Book save(Book b) {
		return bookRepo.save(b);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
	public Book findOneById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	public Book update(Book b) {
//		return bookRepo.save(b);
//	}
}
