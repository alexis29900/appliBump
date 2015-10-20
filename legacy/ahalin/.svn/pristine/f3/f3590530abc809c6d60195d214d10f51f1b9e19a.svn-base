package com.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entities.Livre;
import com.book.hibernate.BDDExist;
import com.book.hibernate.HibernateUtils;
import com.book.mail.Mail;
import com.book.entities.Client;
import com.book.entities.Commande;
import com.book.entities.Detail;
import com.book.entities.Specificite;
import com.book.formulaires.formulaireDetail;
import com.book.formulaires.formulaireSpecificite;
import com.book.formulaires.formulaireClient;


/**
 * @author Axel Halin
 *
 * Overview:	This servlet handles the acces to the
 * 				command page and the storing of that 
 * 				command in the database.
 */

@SuppressWarnings("serial")
public class commande extends HttpServlet
{
	// Vues (pages to link)
	public static final String VUE1 = "/WEB-INF/accueil.jsp";
	public static final String VUE2 = "/WEB-INF/commande.jsp";
	// Attributes of the request
	public static final String ATT_CLIENT = "client";
	public static final String ATT_DETAIL = "detail";
	public static final String ATT_SPEC = "specificite";
	public static final String ATT_FORMCLI = "form_cli";
	public static final String ATT_FORMSPEC = "form_spec";
	public static final String ATT_FORMDETAIL = "form_detail";
	
	// Database handling
	
	/**
	 * Handle the database by adding the command and the client (if he doesn't exist).
	 * 
	 * @param commande	Command to store in the database.
	 * @param client	Client to store in the database (or to find in it).
	 * @param request	Request in treatment.
	 */
	private void gestionBDD(Commande commande, Client client, Detail detail, Specificite specificite, HttpServletRequest request)
	{
		// Check if client already in database.
		if (BDDExist.clientAlreadyExist(client) == false)
		{	
			// Insert if not.
			HibernateUtils.insert(client);
		}
		commande.setIdClient(client.getIdClient());
		
		// Insert detail et spec
		HibernateUtils.insert(detail);
		commande.setIdDetail(detail.getIdDetail());

		HibernateUtils.insert(specificite);
		commande.setIdSpecificite(specificite.getIdSpec());

		// Insert Commande
		HibernateUtils.insert(commande);
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
		// Retrieving data from the form
		formulaireDetail formDetail = new formulaireDetail();
		Detail detail = formDetail.inscrireDetail(request);
		
		formulaireSpecificite formSpec = new formulaireSpecificite();
		Specificite specificite = formSpec.inscrireSpecificite(request);
		
		formulaireClient formClient = new formulaireClient();
		Client client = formClient.inscrireClient(request);
		
		Commande commande = new Commande();
		commande.setEtat("En attente");
		commande.setValide(false);
		
		Livre livre = (Livre) request.getSession().getAttribute("livre");
		detail.setIdLivre(livre.getIdLivre());
		
		// Redirection.
		request.getSession().setAttribute(ATT_FORMDETAIL, formDetail);
		request.getSession().setAttribute(ATT_FORMSPEC, formSpec);		
		request.getSession().setAttribute(ATT_FORMCLI, formClient);
		request.getSession().setAttribute(ATT_DETAIL, detail);
		request.getSession().setAttribute(ATT_SPEC, specificite);
		request.getSession().setAttribute(ATT_CLIENT, client);
		
		
		if (formDetail.getErreurs().isEmpty() && formClient.getErreurs().isEmpty() && formSpec.getErreurs().isEmpty() )
		{
			// Database handling.
			gestionBDD(commande,client,detail,specificite,request);
			
			// Notification of the person in charge of the service and the client.
			Mail.nouvelleCommande(commande,livre,client,detail,specificite);
			Mail.nouvelleCommandeClient(commande, livre, client, detail, specificite);
			
			this.getServletContext().getRequestDispatcher(VUE1).forward(request,response);
		}
		else
		{
			this.getServletContext().getRequestDispatcher(VUE2).forward(request,response);
		}
	}
}