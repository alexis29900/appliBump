package com.book.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entities.Budget;
import com.book.entities.Commande;
import com.book.entities.Detail;
import com.book.hibernate.HibernateUtils;

/**
 * @author Axel Halin
 * 
 * Overview: 	This servlet handles the displaying of all commands
 * 				of the service.
 */

@SuppressWarnings("serial")
public class gestion extends HttpServlet
{
	// Vue
	public static final String VUE1 = "/WEB-INF/gestion.jsp";
	// Attributes
	public static final String ATT_LISTECOMMANDES = "listeCommandes";
	public static final String ATT_LISTECLIENTS = "listeClients";
	public static final String ATT_LISTEDETAILS = "listeDetails";
	public static final String ATT_LISTESPECIFICITES = "listeSpecificites";
	public static final String ATT_LISTELIVRES = "listeLivres";
	public static final String ATTENTE = "attente";
	public static final String BUDGET = "budget";
	
	/**
	 * Return the remaining of the budget.
	 * 
	 * @return	remaining of the budget.
	 */
	@SuppressWarnings("rawtypes")
	private Integer gestionBudget()
	{
		List listeBudget = HibernateUtils.selectAll("Budget");
		List listeDetail = HibernateUtils.selectAll("Detail");
		List listeCommande = HibernateUtils.selectAll("Commande");
		Budget courrant = new Budget();
		Detail detail = new Detail();
		Commande commande = new Commande();
		Integer somme = new Integer(0);
		
		for (int i=0; i<listeBudget.size(); i++)
		{
			courrant = (Budget) listeBudget.get(i);
			somme = somme + courrant.getMontant();
		}
		
		for (int j=0; j<listeCommande.size(); j++)
		{
			commande = (Commande) listeCommande.get(j);
			
			if (commande.getValide() == true)
			{
				for (int i=0; i<listeDetail.size(); i++)
				{
					detail = (Detail) listeDetail.get(i);
					if (detail.getIdDetail().intValue() == commande.getIdDetail().intValue())
					{
						somme = somme - detail.getPrix();
					}
				}
			}	
		}
		return somme;
	}
	
	
	/**
	 * Treatment of http Get request.
	 * 
	 * @Override
	 */
	@SuppressWarnings("rawtypes")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List listeCommandes = HibernateUtils.selectAll("Commande");
		System.out.println("begin");
		System.out.println(listeCommandes);
		System.out.println("end");
		List listeClients = HibernateUtils.selectAll("Client");
		List listeDetails = HibernateUtils.selectAll("Detail");
		List listeSpecificites = HibernateUtils.selectAll("Specificite");
		List listeLivres = HibernateUtils.selectAll("Livre");
		Integer budget = gestionBudget();
		
		request.getSession().setAttribute(ATT_LISTECOMMANDES, listeCommandes);
		request.getSession().setAttribute(ATT_LISTECLIENTS, listeClients);
		request.getSession().setAttribute(ATT_LISTEDETAILS, listeDetails);
		request.getSession().setAttribute(ATT_LISTESPECIFICITES, listeSpecificites);
		request.getSession().setAttribute(ATT_LISTELIVRES, listeLivres);
		request.getSession().setAttribute(ATTENTE, "En attente");
		request.getSession().setAttribute(BUDGET, budget);
		
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
