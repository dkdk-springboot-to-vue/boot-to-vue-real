package com.ssafy.mvc.member.dto;

public class MemberDto {
	String userId;
	String userName;
	String userPass;
	String userJoinDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	
	
	public MemberDto() {
		super();
	}
	
	public MemberDto(String userId, String userName, String userPass, String userJoinDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userJoinDate = userJoinDate;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPass=" + userPass + ", userJoinDate="
				+ userJoinDate + "]";
	}
	
	
}
