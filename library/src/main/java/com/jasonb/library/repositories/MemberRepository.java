package com.jasonb.library.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonb.library.models.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long>{
	public List<Member> findAll();

}
