package com.jasonb.loginreg.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.loginreg.models.Comment;
import com.jasonb.loginreg.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo;

	public Comment save(Comment c) {
		return commentRepo.save(c);
	}
	
	public Comment findById(Long id) {
		Optional<Comment> optComment = commentRepo.findById(id);
		if (optComment.isEmpty()) {
			return null;
		} else {
			return optComment.get();
		}
	}
	
	public void delete(Long id) {
		commentRepo.deleteById(id);
	}
}
