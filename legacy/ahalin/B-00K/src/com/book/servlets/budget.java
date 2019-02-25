package com.book.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.hibernate.HibernateUtils;
import com.book.entities.Budget;
import com.book.hibernate.H2Budget;
import com.book.hibernate.H2Livre;
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
	public static final String ATT_BUDGET = "budget";
	public static final String ATT_BUDGET_ARRAY = "budgetA";
	/**
	 * Treatment of http Get request.
	 * 
	 * @Override
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		H2Budget b=new H2Budget();
		Budget h=b.getLastBudget();
		request.getSession().setAttribute(ATT_BUDGET, h);
		System.out.println(b.getLastBudget());
		List i= HibernateUtils.selectAll("Budget");
		request.getSession().setAttribute(ATT_BUDGET_ARRAY, i);
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
		Budget budget = new Budget(2,montant, "00", "None");
		String a = request.getParameter("budget");
		H2Budget b=new H2Budget();
		b.insertBudget(budget);
		
		this.getServletContext().getRequestDispatcher(VUE1).forward(request,response);
	}
}
