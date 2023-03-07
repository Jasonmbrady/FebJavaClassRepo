package com.jasonb.library.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jasonb.library.models.Book;
import com.jasonb.library.services.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(Model model) {
		// retrieve all books from DB
		List<Book> allBooks = bookServ.findAll();
		// Store list in model
		model.addAttribute("allBooks", allBooks);
		return "index.jsp";
	}
	
	@GetMapping("/book/new")
	public String newBook(@ModelAttribute("newBook") Book newBook) {
//		model.addAttribute("newBook", new Book());
		return "newBook.jsp";
	}
	
	@PostMapping("/book/new")
	public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		bookServ.create(newBook);
		return "redirect:/";
	}
	

	@RequestMapping(value="/book/{id}", method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/book/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.findOneById(id));
		return "editBook.jsp";
	}
	
	@PutMapping("/book/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		book.setId(id);
		bookServ.update(book);
		return "redirect:/";
	}
//	@GetMapping("/book/{id}/delete")
//	public String deleteBook(@PathVariable("id") Long id) {
//		bookServ.delete(id);
//		return "redirect:/";
//	}
}
