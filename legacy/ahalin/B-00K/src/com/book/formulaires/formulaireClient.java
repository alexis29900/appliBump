package com.book.formulaires;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.entities.Client;

/**
 * @author Axel Halin
 * 
 * Overview:	This class represents the form used to
 * 				register the client of a command.
 *
 */
public class formulaireClient
{
	// Fields of the form.
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_EMAIL = "email";

	// Result of the submission (succes or failiure).
	private String resultat;
	
	// Map of occured error(s)
	private Map<String, String> erreurs = new HashMap<String, String>();

	
	/**
	 * Get the result of the attempted submission.
	 * 
	 * @return	result of the form.
	 */
	public String getResultat()
	{
		return resultat;
	}
	
	
	/**
	 * Get the error(s) the occured during the submission of the form.
	 * 	
	 * @return a Map of errors.
	 * @see	java.util.HashMap
	 */
	public Map<String, String> getErreurs()
	{
		return erreurs;
	}
	
	
	// Fields validation.
	
	/**
	 * Verifies if the name entered is longer than 2 characters.
	 * 
	 * @param nom	name (of the client) to verify.
	 * @throws Exception	if the name entered is shorter than 2 characters.
	 */
	private void validationNom(String nom) throws Exception
	{
		if (nom != null)
		{
			if (nom.length() < 2)
			{
				throw new Exception("Votre nom doit contenir au moins 2 caractères");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir votre nom, s'il vous plaît.");
		}
	}
	
	
	/**
	 * Verifies if the firstname entered is longer than 2 characters.
	 * 	
	 * @param prenom		firstname (of the client) to verify.
	 * @throws Exception	if the firstname entered is shorter than 2 characters.
	 */
	private void validationPrenom(String prenom) throws Exception
	{
		if (prenom != null)
		{
			if (prenom.length() < 2)
			{
				throw new Exception("Votre prénom doit contenir au moins 2 caractères.");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir votre prénom, s'il vous plait.");
		}
	}
	
	
	/**
	 * Verifies if the email adress entered is a valid one (syntactically)
	 * 	
	 * @param email		email (of the client) to verify.
	 * @throws Exception	if the email adress doesn't match the style of typical adresses.
	 */
	private void validationEmail (String email) throws Exception
	{
		if (email != null)
		{
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) )
			{
				throw new Exception("Veuillez saisir une adresse mail valide.");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir votre adresse mail, s'il vous plait.");
		}
	}
	

	/**
	 * Put the field where an error occured and an explanation message in the Map of errors.
	 * 	
	 * @param champ		Field where the error occured.
	 * @param message	Explanation of the error.
	 * @see	java.util.HashMap
	 */
	private void setErreur(String champ, String message)
	{
		erreurs.put(champ, message);
	}
	
	
	/**
	 * Get the value entered in a specific field of the request (the form).
	 * 	
	 * @param request	Request in which the differents fields are contained.
	 * @param nomChamp	Name of the field from which the value has to be retrieved.
	 * @return	the value of the field or <code> null </code>.
	 * @see	javax.servlet.http.HttpServletRequest
	 */
	private String getValeurChamp(HttpServletRequest request, String nomChamp)
	{
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0)
		{
			return null;
		}
		else
		{
			return valeur;
		}
	}
	
	
	/**
	 * Create a new Client with the values of the fields of the form, if they are valids.
	 * 
	 * @param request	Request containing the form.
	 * @return	Client object representing the customer.
	 */
	public Client inscrireClient(HttpServletRequest request)
	{		
		Client client = new Client();
		
		// Name validation.
		try
		{
			String nom = getValeurChamp(request, CHAMP_NOM);
			validationNom(nom);
			client.setNom(nom);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_NOM,e.getMessage());
		}
		
		// Firstname validation
		try
		{
			String prenom = getValeurChamp(request, CHAMP_PRENOM);
			validationPrenom(prenom);
			client.setPrenom(prenom);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_PRENOM, e.getMessage());
		}
		
		// Email validation
		try
		{
			String email = getValeurChamp(request, CHAMP_EMAIL);
			validationEmail(email);
			client.setEmail(email);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		
		
		if (erreurs.isEmpty())
		{
			resultat = "Succès de l'inscription.";
		}
		else
		{
			resultat = "Échec de l'inscription.";
		}
		
		return client;
	}
}
