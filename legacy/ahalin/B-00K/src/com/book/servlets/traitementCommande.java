package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entities.Commande;
import com.book.hibernate.BDDCommande;

@SuppressWarnings("serial")
public class traitementCommande extends HttpServlet
{
	// Vue
	public static final String VUE1 = "/B-00K/gestion";

	
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
		// Retrieving the button pressed and the command to update.
		Integer id_commande = Integer.parseInt(request.getParameter("aTraite"));
		String decision = request.getParameter("decision");
		
		// Retrieving the command to handle.
		Commande commande = BDDCommande.idToCommand(id_commande);
		
		
		if (decision.equals("ok"))
		{
			commande.setEtat("Validee");
			commande.setValide(true);
			BDDCommande.updateCommandeValide(commande.getIdCommande(), true,commande);
			BDDCommande.updateCommandeEtat(commande.getIdCommande(), "Validee", commande);
		}
		else
		{
			commande.setEtat("Refusee");
			commande.setValide(false);
			BDDCommande.updateCommandeValide(commande.getIdCommande(), false,commande);
			BDDCommande.updateCommandeEtat(commande.getIdCommande(), "Refusee", commande);
		}
		
		response.sendRedirect(VUE1);
	}
}