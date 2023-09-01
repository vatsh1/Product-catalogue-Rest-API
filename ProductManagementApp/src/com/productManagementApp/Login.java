package com.productManagementApp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		LoginDao dao = new LoginDao();
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		LoginCredentials lg = new LoginCredentials();
		
		String uname = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		lg.setUsername(uname);
		lg.setPassword(pwd);
		try {
			if(dao.check(uname)) {
				HttpSession session1 = req.getSession();
				if(dao.verifyAuthentication(uname, pwd)) {
					/*PrintWriter out = res.getWriter();
					out.println("Hello "+lg.getUsername());*/
					session1.setAttribute("user",uname);
					res.sendRedirect("product.jsp");
				}
				else {
					session1.setAttribute("var", "Username Already Exist! <br> username and password doesn't match!");
					res.sendRedirect("index.jsp");
				}
				
			}
			else {
				session.save(lg);
				transaction.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
