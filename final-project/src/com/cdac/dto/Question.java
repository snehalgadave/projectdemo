package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Question {
	
	@Id
	@Column(name = "que_id")
	@GeneratedValue
	private int queId;
	
	
	private String subject;
	private String question;
	
	@Column(name = "user_id")
	private int userId;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int queId) {
		super();
		this.queId = queId;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
