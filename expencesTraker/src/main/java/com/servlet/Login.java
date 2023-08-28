package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.dao.UserDuo;
import com.db.HibernateConfig;
import com.entity.User;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDuo userDuo = new UserDuo(HibernateConfig.getSessionFactory());
		User user = userDuo.login(email, password);
		HttpSession session = request.getSession();
		if (user==null) {
			session.setAttribute("msg", "invalid Email and Password");
			response.sendRedirect("login.jsp");
			
			
		} else {
			response.sendRedirect("home/user.jsp");
			

		}
	}

}
