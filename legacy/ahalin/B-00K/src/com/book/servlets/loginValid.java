package com.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
public class loginValid extends HttpServlet{

	private final String userID = "admin";
	private final String password = "password";
	private final String VUE1="/WEB-INF/logon.jsp";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.println(user);
		System.out.println(pwd);
		if(userID.equals(user) && password.equals(pwd)){
			System.out.println("ok");
			HttpSession session = request.getSession();
			session.setAttribute("user", "admin");
			session.setAttribute("userRole","admin");
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);

			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("/B-00K/acceuil");
		}else{
			System.out.println("ko");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/logon.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}

}