package com.ssafy.mvc.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.member.dto.MemberDto;
import com.ssafy.mvc.member.repository.MemberRepository;

@Service("MemberServiceMapperImpl")
public class MemberServiceMapperImpl implements MemberService {

	private MemberRepository repo;
	
	@Autowired
	public MemberServiceMapperImpl(MemberRepository repo) throws Exception{
		super();
		this.repo = repo;
	}

	@Override
	public void register(MemberDto dto) throws Exception{
		repo.register(dto);
	}

	@Override
	public void update(MemberDto dto) throws Exception{
		// TODO Auto-generated method stub
		repo.update(dto);
	}

	@Override
	public void delete(String id) throws Exception{
		repo.delete(id);
		
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception{
		// TODO Auto-generated method stub
		return repo.login(dto);
	}

	@Override
	public String findPw(String id) throws Exception{
		// TODO Auto-generated method stub
		return repo.findPw(id);
	}

	@Override
	public List<MemberDto> listMember() throws Exception{
		// TODO Auto-generated method stub
		return repo.listMember();
	}

}
