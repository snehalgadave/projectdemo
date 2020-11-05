package com.cdac.service;

import java.util.List;

import com.cdac.dto.Question;

public interface QuestionService {
	
	void addQuestion(Question question);
	void removeQuestion(int queId);
	Question findQuestion(int queId);
	void modifyQuestion(Question question);
	List<Question> selectAll(int userId);

}
