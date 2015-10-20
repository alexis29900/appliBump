package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entities.Livre;
import com.book.formulaires.formulaireLivre;
import com.book.hibernate.BDDExist;
import com.book.hibernate.H2Livre;
import com.book.hibernate.HibernateUtils;


/**
 * @author Axel Halin
 * 
 * Overview: 	This servlet handles the confirmation form 
 * 				of the book.
 */

@SuppressWarnings("serial")
public class validation extends HttpServlet
{
	// Vues (pages to link)
	public static final String VUE1 = "/WEB-INF/validation.jsp";
	public static final String VUE2 = "/WEB-INF/commande.jsp";
	// Attributes of the request
	public static final String ATT_LIVRE = "livre";
	public static final String ATT_FORM = "form";
	
	
	// Database handling
	
	/**
	 * Determines if the book is already in the database; insert it if not.
	 * 
	 * @param livre Book to check the presence in the database.
	 */
	private void gestionBDD(Livre livre)
	{
		// If book isn't in database
		if ( !BDDExist.livreAlreadyExist(livre) )
		{	
			// Insert it.
			//HibernateUtils.insert(livre);
			H2Livre.insertLivre(livre);
			HibernateUtils.numeroLivre(livre);
		}
		// Else update NLivre
		else
		{
			HibernateUtils.numeroLivre(livre);
		}
	}
	
	
	// Main methods
	
	/**
	 * Treatment of http Get request.
	 * 
	 * @Override
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}
	
	
	/**
	 * Treatment of http Post request.
	 * 
	 * @Override
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Takes input data from form.
		formulaireLivre form = new formulaireLivre();
		Livre livre = form.confirmerLivre(request);
		
		System.out.println("Livre a rentrer : " + livre.toString());

		//HibernateUtils.initDB(livre);
		gestionBDD(livre);
		System.out.println(livre.toString());
		request.getSession().setAttribute(ATT_FORM, form);
		request.getSession().setAttribute(ATT_LIVRE, livre);
				
		if (form.getErreurs().isEmpty() )
		{
			this.getServletContext().getRequestDispatcher(VUE2).forward(request,response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher(VUE1).forward(request,response);
		}
	}
}