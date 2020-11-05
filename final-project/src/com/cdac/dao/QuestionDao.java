package com.cdac.dao;


import java.util.List;
import com.cdac.dto.Question;

public interface QuestionDao {
	
	void insertQuestion(Question question);
	void deleteQuestion(int queId);
	Question selectQuestion(int queId);
	void updateQuestion(Question question);
	List<Question> selectAll(int userId);

}
