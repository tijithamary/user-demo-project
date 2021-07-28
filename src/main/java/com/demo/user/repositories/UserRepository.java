package com.demo.user.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.user.dataobjects.User;


@Repository
public class UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean login(String username, String password) {

		Session session = this.sessionFactory.openSession();
		Query<?> query = session.createQuery("select u from User u where u.username = :user and u.password = :pass");
		query.setParameter("user", username);
		query.setParameter("pass", password);
		User u = (User)query.uniqueResult();
		
		return u != null;
	}
	
	public int createUser(User user) {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = (int)session.save(user);
		transaction.commit();
		
		return id;
	}
	

}
