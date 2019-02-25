package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.hibernate.HibernateUtils;
import com.book.entities.Budget;

/**
 * @author Axel Halin
 * 
 * Overview: 	This servlet handles access to the main page
 * 				of the platform. 
 */
@SuppressWarnings("serial")
public class budget extends HttpServlet
{
	// Vue
	public static final String VUE1 = "/WEB-INF/budget.jsp";
	public static final String VUE2 = "/WEB-INF/accueil.jsp";
	
	/**
	 * Treatment of http Get request.
	 * 
	 * @Override
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		System.out.println("get request");
		HibernateUtils.initDB();
			this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
		}
	
	
	/**
	 * Treatment of http Post request.
	 * 
	 * @Override
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Integer montant=Integer.parseInt(request.getParameter("budget"));
		Budget budget = new Budget(1,montant, "00", "None");
		System.out.println(budget.toString());
		System.out.println("post request");
		String a = request.getParameter("budget");
		System.out.println(a.toString());
		this.getServletContext().getRequestDispatcher(VUE2).forward(request,response);
	}
}
