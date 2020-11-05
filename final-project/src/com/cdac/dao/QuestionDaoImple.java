package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.cdac.dto.Question;

@Repository
public class QuestionDaoImple implements QuestionDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public void insertQuestion(Question question) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(question);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public void deleteQuestion(int queId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Question(queId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}

	@Override
	public Question selectQuestion(int queId) {
		Question question = hibernateTemplate.execute(new HibernateCallback<Question>() {

			@Override
			public Question doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Question qu = (Question)session.get(Question.class, queId);
				tr.commit();
				session.flush();
				session.close();
				return qu;
			}
			
		});
		return question;
	
	}

	@Override
	public void updateQuestion(Question question) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				
                session.update(question);
				
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
		
	}

	@Override
	public List<Question> selectAll(int userId) {
		
		List<Question> queList = hibernateTemplate.execute(new HibernateCallback<List<Question>>() {

			@Override
			public List<Question> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Question where userId = ?");
				q.setInteger(0, userId);
				List<Question> li = q.list();
				System.out.println(li); 
				tr.commit();
				session.flush();
				session.close();
				return li;
			}
			
		});
		return queList;
		
		
	}

}
