package com.ssafy.mvc.board.dto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	
	private List<ReplyDto> replies = new ArrayList<ReplyDto>();
	
	

	public BoardDto() {
		super();
	}

	public BoardDto(int articleNo, String userId, String subject, String content, int hit, String registerTime,
			List<ReplyDto> replies) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.registerTime = registerTime;
		this.replies = replies;
	}

	public List<ReplyDto> getReplies() {
		return replies;
	}

	public void setReplies(List<ReplyDto> replies) {
		this.replies = replies;
	}
	

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", subject=" + subject + ", content="
				+ content + ", hit=" + hit + ", registerTime=" + registerTime + ", replies=" + replies + "]";
	}

	

}
