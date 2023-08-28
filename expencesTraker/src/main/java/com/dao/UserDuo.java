package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.User;
import com.mysql.cj.Query;

public class UserDuo {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public UserDuo(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public boolean saveUser(User user) {
		boolean f = false;
		try {
			session=factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			if(tx!=null) {
				f=false;
				e.printStackTrace();
			}
		}
		return f;
		
	}
  public User login(String email, String password) {
	  User user = null;
	  session = factory.openSession();
	   org.hibernate.Query query =  session.createQuery("from User where email=:em and password=:ps");
	   query.setParameter("em", email);
	   query.setParameter("ps", password);
	   user=(User)query.uniqueResult();
	   
	   
	   
	  
	  
	  return user;
	  
  }
	

}
