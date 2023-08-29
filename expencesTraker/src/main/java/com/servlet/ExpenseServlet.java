package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpensesDao;
import com.db.HibernateConfig;
import com.entity.Expense;

/**
 * Servlet implementation class ExpenseServlet
 */
public class ExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		Expense expense = new Expense(title, date, time, price, description);
		ExpensesDao dao= new ExpensesDao(HibernateConfig.getSessionFactory());
		boolean f = dao.saveExpense(expense);
		HttpSession session = request.getSession();
		
		if (f) {
			session.setAttribute("msg", "Expences added sucessfully");
			response.sendRedirect("add_expense.jsp");
			
			
		} else {
			session.setAttribute("msg", "something went wrong try again");

		}
	}

}
