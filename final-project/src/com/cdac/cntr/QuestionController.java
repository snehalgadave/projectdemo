package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.cdac.dto.Question;
import com.cdac.dto.User;

import com.cdac.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/prep_question_add_form.htm",method = RequestMethod.GET)
	public String prepQuestionAddForm(ModelMap map) {
		map.put("question", new Question());
		return "question_add_form";
	}
	
	@RequestMapping(value = "/question_add.htm",method = RequestMethod.POST)
	public String questionAdd(Question question,HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		question.setUserId(userId); 
		questionService.addQuestion(question);
		return "home";
	}
	
	
	@RequestMapping(value = "/question_list.htm",method = RequestMethod.GET)
	public String allQuestions(ModelMap map,HttpSession session) {
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Question> li = questionService.selectAll(userId);
		map.put("queList", li);
		return "question_list";
	}
	
	@RequestMapping(value = "/question_delete.htm",method = RequestMethod.GET)
	public String questionDelete(@RequestParam int queId,ModelMap map,HttpSession session) {
		
		questionService.removeQuestion(queId); 
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		List<Question> li = questionService.selectAll(userId);
		map.put("queList", li);
		return "question_list";  
	}
	
	
	@RequestMapping(value = "/question_update_form.htm",method = RequestMethod.GET)
	public String questionUpdateForm(@RequestParam int queId,ModelMap map) {
		
		Question que = questionService.findQuestion(queId);
		map.put("question", que);
		
		return "question_update_form";
	}
	
	@RequestMapping(value = "/question_update.htm",method = RequestMethod.POST)
	public String questionUpdate(Question question,ModelMap map,HttpSession session) {
		
		int userId = ((User)session.getAttribute("user")).getUserId();
		question.setUserId(userId);
		questionService.modifyQuestion(question);
			
		List<Question> li = questionService.selectAll(userId);
		map.put("queList", li);
		return "question_list";
	}
	
	

}
