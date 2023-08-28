package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
        // Retrieve user inputs from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Validate inputs, check against database, and perform sign-in logic
        // ...
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Load the JDBC driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expences_db", "username", "password");
        } catch (Exception e) {
            // Handle exceptions
        }
        

      
	}

}
