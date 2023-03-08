package com.jasonb.library.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jasonb.library.models.Book;
import com.jasonb.library.models.Member;
import com.jasonb.library.services.BookService;
import com.jasonb.library.services.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired 
	private MemberService memberServ;
	@Autowired
	private BookService bookServ;
	
	@GetMapping("/new")
	public String newMember(@ModelAttribute("member") Member newMember) {
		
		return "newMember.jsp";
	}
	
	@PostMapping("/new")
	public String createMember(@Valid @ModelAttribute("member") Member newMember, BindingResult result) {
		if (result.hasErrors()) {
			return "newMember.jsp";
		}
		memberServ.create(newMember);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showMember(@PathVariable("id") Long id, Model model) {
		model.addAttribute("member", memberServ.findById(id));
		model.addAttribute("allBooks", bookServ.findAll());
		return "viewUser.jsp";
	}
	
	@PostMapping("/{id}/checkout")
	public String checkout(@PathVariable("id") Long memberId, @RequestParam(value="book") Long bookId) {
		Member member = memberServ.findById(memberId);
		Book book = bookServ.findOneById(bookId);
		book.setMember(member);
		bookServ.save(book);
		return "redirect:/member/" + member.getId();
	}

}
