package com.ssafy.mvc.board.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	
	private List<ReplyDto> replies = new ArrayList<ReplyDto>();
}
