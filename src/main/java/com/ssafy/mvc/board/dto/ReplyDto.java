package com.ssafy.mvc.board.dto;

import org.springframework.stereotype.Component;

public class ReplyDto {
	private int replyNo;
	private int articleNo;
	private String replyCotent;
	private String userId;
	public ReplyDto() {}
	public ReplyDto(String replyCotent, String userId) {
		super();
		this.replyCotent = replyCotent;
		this.userId = userId;
	}
	
	public ReplyDto(int articleNo, String replyCotent, String userId) {
		super();
		this.articleNo = articleNo;
		this.replyCotent = replyCotent;
		this.userId = userId;
	}


	public ReplyDto(int replyNo, int articleNo, String replyCotent, String userId) {
		super();
		this.replyNo = replyNo;
		this.articleNo = articleNo;
		this.replyCotent = replyCotent;
		this.userId = userId;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public int getArticleNo() {
		return articleNo;
	}


	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}


	public String getReplyCotent() {
		return replyCotent;
	}


	public void setReplyCotent(String replyCotent) {
		this.replyCotent = replyCotent;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
