package com.ssafy.mvc.attraction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.attraction.dto.AttractionDto;
import com.ssafy.mvc.attraction.dto.GugunDto;
import com.ssafy.mvc.attraction.dto.SidoDto;
import com.ssafy.mvc.attraction.repository.AttractionRepository;

@Service("AttractionServiceMapperImpl")
public class AttractionServiceMapperImpl implements AttractionService {

	private AttractionRepository repo;
	
	@Autowired
	public AttractionServiceMapperImpl(AttractionRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<AttractionDto> getAttractionList(int gugun_code, int sido_code) {
		// TODO Auto-generated method stub
		return repo.getAttractionList(gugun_code, sido_code);
	}

	@Override
	public List<SidoDto> getSidoList() {
		// TODO Auto-generated method stub
		return repo.getSidoList();
	}

	@Override
	public List<GugunDto> getGugunList(int gungu_code) {
		// TODO Auto-generated method stub
		return repo.getGugunList(gungu_code);
	}

	@Override
	public List<GugunDto> getGugunAll() {
		// TODO Auto-generated method stub
		return repo.getGugunAll();
	}




}
