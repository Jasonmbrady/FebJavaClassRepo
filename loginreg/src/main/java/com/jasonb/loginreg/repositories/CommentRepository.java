package com.jasonb.loginreg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.loginreg.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

	
}
