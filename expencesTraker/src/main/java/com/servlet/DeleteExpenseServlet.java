package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpensesDao;
import com.db.HibernateConfig;

/**
 * Servlet implementation class DeleteExpenseServlet
 */
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		int id = Integer.parseInt(request.getParameter("id"));
		ExpensesDao dao = new ExpensesDao(HibernateConfig.getSessionFactory());
		boolean f= dao.deleteExpense(id);
		HttpSession session = request.getSession();
		if (f) {
			session.setAttribute("msg", "Expense deleted Sucessfully");
			response.sendRedirect("home/view_expense.jsp");
			
		}else {
			session.setAttribute("msg", "Something Went Wrong");
			response.sendRedirect("home/view_expense.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
