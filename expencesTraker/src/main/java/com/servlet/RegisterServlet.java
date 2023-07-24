package com.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        
        // Create a new session and transaction
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        // Save the user entity
        session.save(user);
        
        // Execute native SQL to set the storage engine
        String sql = "ALTER TABLE user_details ENGINE = MyISAM";
        session.createSQLQuery(sql).executeUpdate();
        
        // Commit the transaction and close the session
        transaction.commit();
        session.close();
    }
}
