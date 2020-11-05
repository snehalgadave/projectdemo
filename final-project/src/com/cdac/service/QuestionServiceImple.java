package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.QuestionDao;
import com.cdac.dto.Question;

@Service
public class QuestionServiceImple implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;


	@Override
	public void addQuestion(Question question) {
		questionDao.insertQuestion(question);
		
	}

	@Override
	public void removeQuestion(int queId) {
		
		questionDao.deleteQuestion(queId);
		
	}

	@Override
	public Question findQuestion(int queId) {
		return questionDao.selectQuestion(queId);
	}

	@Override
	public void modifyQuestion(Question question) {
		
		questionDao.updateQuestion(question);
	}

	@Override
	public List<Question> selectAll(int userId) {
		
		return questionDao.selectAll(userId);
	}

	
}
