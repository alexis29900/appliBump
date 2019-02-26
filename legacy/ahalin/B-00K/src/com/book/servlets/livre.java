package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entities.Livre;
import com.book.formulaires.formulaireIsbn;
import com.book.groovy.trouverLivre;

/**
 * @author Axel Halin
 * 
 * Overview:	Servlet used to find the book you're looking for.
 */
@SuppressWarnings("serial")
public class livre extends HttpServlet
{
	// Vues (pages to link)
	public static final String VUE1 = "/WEB-INF/livre.jsp";
	public static final String VUE2 = "/WEB-INF/validation.jsp";
	// Attributes of the request
	public static final String ATT_LIVRE = "livre";
	public static final String ATT_FORM = "form";
		
		
	/**
	 * Determines the isbn number given (10 or 13) of the book and finds his data.
	 * 
	 * @param livre Book to find (at least one isbn number is not null)
	 */
	private Livre gestionLivre(Livre livre)
	{
		// Ajout fonction recherche BDD avant recherche WEB
		
		String url = livre.getUrl();

		// Determines what isbn number is used to find the book.		
		if (livre.getIsbn10().length() == 10)
		{
			livre = trouverLivre.rechercheGlobale(livre.getIsbn10());
		}
		else if (livre.getIsbn13().length() == 13)
		{
			livre = trouverLivre.rechercheGlobale(livre.getIsbn13());
		}
		livre.setUrl(url);
		
		return livre;
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
		// get request parameters for userID and password
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.println(user);
		System.out.println(pwd);
		// Takes input data from form.
		formulaireIsbn form = new formulaireIsbn();
		Livre livre = form.inscrireLivre(request);

		// Looking for the book.
		livre = gestionLivre(livre);

		// Redirecting
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