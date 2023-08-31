package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDuo;
import com.db.HibernateConfig;
import com.entity.User;

/**
 * Servlet implementation class EditProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
		   String fullName = request.getParameter("fullName");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String about = request.getParameter("about");
	        User user = new User(fullName, email, password, about);
	        UserDuo dao = new UserDuo(HibernateConfig.getSessionFactory());
	       Boolean f= dao.updateUser(user);
	       HttpSession sessionReq= request.getSession();
	       if(f) {
	    	   sessionReq.setAttribute("msg", "Profile Saved..");
	    	   //System.out.println("Register Sucessfully");
	    	   response.sendRedirect("home/user_profile.jsp");
	       }else {
	    	   sessionReq.setAttribute("msg", "something went Wrong");
	    	   //System.out.println("Register Error");
	    	   response.sendRedirect("home/user_profile.jsp");
	       }
	}

}
