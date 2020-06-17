package com.shopping.common;

public class UserInfo {
	public UserInfo(String username, String password, String email, String phone, String question, String answer) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.question = question;
		this.answer = answer;
	}
	public String username;
	public String password;
	public String email;
	public String phone;
	public String question;
	public String answer;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}