package com.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;
import com.entity.User;
import com.mysql.cj.Query;

import antlr.collections.List;

public class ExpensesDao {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public ExpensesDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	public boolean saveExpense(Expense ex) {
		boolean f = false;
		try {
			session=factory.openSession();
			tx = session.beginTransaction();
			session.save(ex);
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
	public java.util.List<Expense> viewExpense(User user){
		java.util.List<Expense> list = new ArrayList<Expense>();
		try {
			session = factory.openSession();
			org.hibernate.Query query = session.createQuery("from Expense where user =: us");
			query.setParameter("us", user);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	public Expense getExpense(int id) {
		Expense ex = null;
		try {
			session = factory.openSession();
			org.hibernate.Query query = session.createQuery("from Expense where id =:id");
			query.setParameter("id", id);
			ex=(Expense) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ex;
		
	}
	public boolean updateExpense(Expense ex) {
		boolean f = false;
		try {
			session=factory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(ex);;
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
	public boolean deleteExpense(int id) {
		boolean f= false;
		try {
			session=factory.openSession();
			tx = session.beginTransaction();
			Expense ex = session.get(Expense.class, id);
			
			session.delete(ex);
			tx.commit();
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
		
	}

}
