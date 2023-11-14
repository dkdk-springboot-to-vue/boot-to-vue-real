package com.ssafy.mvc.board.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ReplyDto {
	private int replyNo;
	private int articleNo;
	private String replyContent;
	private String userId;
	
}
