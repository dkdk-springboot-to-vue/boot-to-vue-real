package com.ssafy.mvc.attraction.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.mvc.attraction.dto.AttractionDto;
import com.ssafy.mvc.attraction.dto.GugunDto;
import com.ssafy.mvc.attraction.dto.SidoDto;

@Mapper
public interface AttractionRepository {
	List<AttractionDto> getAttractionList(@Param("gugun_code") int gugun_code, @Param("sido_code") int sido_code);
	List<SidoDto> getSidoList();
	List<GugunDto> getGugunList(int gungu_code);
	List<GugunDto> getGugunAll();
}
