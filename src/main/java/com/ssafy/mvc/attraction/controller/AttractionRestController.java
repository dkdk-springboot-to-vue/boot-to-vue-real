package com.ssafy.mvc.attraction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.attraction.dto.AttractionDto;
import com.ssafy.mvc.attraction.dto.GugunDto;
import com.ssafy.mvc.attraction.dto.SidoDto;
import com.ssafy.mvc.attraction.service.AttractionService;
import com.ssafy.mvc.member.dto.MemberDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/restattr")
public class AttractionRestController {
	private AttractionService service;

	@Autowired
	public AttractionRestController(@Qualifier(value = "AttractionServiceMapperImpl") AttractionService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("")
	public ResponseEntity<?> map(){
		List<SidoDto> sidoList = service.getSidoList();
		
		return new ResponseEntity<List<SidoDto>>(sidoList, HttpStatus.CREATED);
	}
	
	@GetMapping("/gugun/{sido_code}")
	public ResponseEntity<List<GugunDto>> gugun(@PathVariable("sido_code") int sido_code){
		List<GugunDto> gugunList = service.getGugunList(sido_code);
		return new ResponseEntity<>(gugunList, HttpStatus.OK);
	}
	
	@PostMapping("/mapview")
	public ResponseEntity<?> getAttrList(@RequestBody AttractionDto dto) {
		int gugun = dto.getGugun_code();
		int sido = dto.getSido_code();
		List<AttractionDto> attractionList = service.getAttractionList(gugun, sido);
		return new ResponseEntity<List<AttractionDto>>(attractionList, HttpStatus.CREATED);
	}
	
}
