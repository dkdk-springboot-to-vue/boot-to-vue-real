package com.ssafy.mvc.attraction.service;

import java.util.List;

import com.ssafy.mvc.attraction.dto.AttractionDto;
import com.ssafy.mvc.attraction.dto.GugunDto;
import com.ssafy.mvc.attraction.dto.SidoDto;

public interface AttractionService {
	List<AttractionDto> getAttractionList(int gugun_code, int sido_code);
	List<SidoDto> getSidoList();
	List<GugunDto> getGugunList(int gungu_code);
	List<GugunDto> getGugunAll();
}
