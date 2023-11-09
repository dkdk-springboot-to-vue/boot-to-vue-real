package com.ssafy.mvc.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.ssafy.mvc.member.dto.MemberDto;

@Mapper
public interface MemberRepository {
	// 회원가입
	public void register(MemberDto dto) throws Exception;
	// 회원수정
	public void update(MemberDto dto) throws Exception;
	// 모든 회원조회
	public List<MemberDto> listMember() throws Exception;
	// 회원탈퇴
	public void delete(String id) throws Exception;
	// 로그인
	public MemberDto login(MemberDto dto) throws Exception;
	// 로그아웃 -> 컨트롤러에서 구현 
	// 비밀번호 찾기 
	public String findPw(String id) throws Exception;
}
