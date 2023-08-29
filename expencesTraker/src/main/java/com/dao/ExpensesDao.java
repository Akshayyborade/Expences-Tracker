package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Expense;

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

}
