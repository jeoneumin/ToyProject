package com.spring.test2.dto;

public class Member {
	
	
	String memberId;
	String userName;
	String pw;
	String answer;
	String manageValue;
	
	public Member() {
		
	}
	
	public Member(String memberId, String userName, String pw, String answer, String manageValue) {
		// TODO Auto-generated constructor stub
		this.memberId = memberId;
		this.userName = userName;
		this.pw = pw;
		this.answer = answer;
		this.manageValue = manageValue;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getManageValue() {
		return manageValue;
	}

	public void setManageValue(String manageValue) {
		this.manageValue = manageValue;
	}
	
	
	
}
