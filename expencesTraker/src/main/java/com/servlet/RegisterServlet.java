package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.UserDuo;
import com.db.HibernateConfig;
import com.entity.User;

// ...

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
	  private SessionFactory sessionFactory;

	    @Override
	    public void init() throws ServletException {
	        // Initialize the SessionFactory here
	        sessionFactory = HibernateConfig.getSessionFactory();
	    }

    // Inject the SessionFactory using your preferred method (e.g., Spring, CDI, or manually)

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String about = req.getParameter("about");
        User user = new User(fullName, email, password, about);
        UserDuo dao = new UserDuo(HibernateConfig.getSessionFactory());
       Boolean f= dao.saveUser(user);
       HttpSession sessionReq= req.getSession();
       if(f) {
    	   sessionReq.setAttribute("msg", "Register Sucessfully");
    	   //System.out.println("Register Sucessfully");
    	   resp.sendRedirect("resister.jsp");
       }else {
    	   sessionReq.setAttribute("msg", "User already exist");
    	   //System.out.println("Register Error");
    	   resp.sendRedirect("resister.jsp");
       }
       
    }
}
