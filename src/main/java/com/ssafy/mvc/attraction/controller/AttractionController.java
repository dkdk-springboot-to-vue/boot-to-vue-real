package com.ssafy.mvc.attraction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.attraction.dto.AttractionDto;
import com.ssafy.mvc.attraction.dto.GugunDto;
import com.ssafy.mvc.attraction.dto.SidoDto;
import com.ssafy.mvc.attraction.service.AttractionService;

@Controller
@RequestMapping("/attr")
public class AttractionController {

	private AttractionService service;

	@Autowired
	public AttractionController(@Qualifier(value = "AttractionServiceMapperImpl") AttractionService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("")
	public ModelAndView map(ModelAndView mav){
		List<SidoDto> sidoList = service.getSidoList();
		mav.addObject("sidoList", sidoList);
		mav.setViewName("attraction/map");
		return mav;
	}
	
	@GetMapping("/gugun/{sido_code}")
	public ResponseEntity<List<GugunDto>> gugun(@PathVariable("sido_code") int sido_code){
		List<GugunDto> gugunList = service.getGugunList(sido_code);
		return new ResponseEntity<>(gugunList, HttpStatus.OK);
	}
	
	@PostMapping("/mapview")
	public ModelAndView getAttrList(ModelAndView mav, int gugun, int sido) {
		List<AttractionDto> attractionList = service.getAttractionList(gugun, sido);
		mav.addObject("attractionList", attractionList);
		mav.setViewName("attraction/kakaomap");
		return mav;
	}
	
}
