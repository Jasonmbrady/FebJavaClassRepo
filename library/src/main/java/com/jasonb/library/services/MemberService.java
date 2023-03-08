package com.jasonb.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jasonb.library.models.Member;
import com.jasonb.library.repositories.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepo;
	
	public Member create(Member m) {
		return memberRepo.save(m);
	}
	
	public List<Member> findAll(){
		return memberRepo.findAll();
	}
	
	public Member findById(Long id) {
		Optional<Member> optMember = memberRepo.findById(id);
		if (optMember.isEmpty()) {
			return null;
		}
		return optMember.get();
	}
	

}
