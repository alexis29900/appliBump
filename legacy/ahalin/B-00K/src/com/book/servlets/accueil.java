package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.hibernate.HibernateUtils;


/**
 * @author Axel Halin
 * 
 * Overview: 	This servlet handles access to the main page
 * 				of the platform. 
 */
@SuppressWarnings("serial")
public class accueil extends HttpServlet
{
	// Vue
	public static final String VUE1 = "/WEB-INF/accueil.jsp";

	
	/**
	 * Treatment of http Get request.
	 * 
	 * @Override
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
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
		this.getServletContext().getRequestDispatcher(VUE1).forward(request,response);
	}
}
