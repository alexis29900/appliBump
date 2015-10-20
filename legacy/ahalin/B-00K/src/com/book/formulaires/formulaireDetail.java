package com.book.formulaires;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.entities.Detail;

/**
 * @author Axel Halin
 *
 * Overview:	This class represents the form
 * 				used to retrieve the details
 * 				data of a command.
 */
public class formulaireDetail
{
	// Fields of the form
	private static final String CHAMP_QTE = "quantite";
	private static final String CHAMP_COTE = "coteBump";
	private static final String CHAMP_PRIX = "prix";
	
	// Result of the submission (succes or failiure)
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
	
	
	// Validations of the differents fields.
	
	/**
	 * Verifies if the quantity entered is a correct one.
	 * 
	 * @param quantite	quantity of books in the order.
	 * @throws Exception	if the quantity entered is a Integer <= 0 or if no value is entered.
	 */
	private void validationQuantite(Integer quantite) throws Exception
	{
		if (quantite != null)
		{
			if (quantite <= 0)
			{
				throw new Exception("La quantite doit être positive.");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir une quantite.");
		}
	}
	
	
	/**
	 * Verifies if the number of the category is valid (regarding its length)
	 * 
	 * @param coteBump		number of the category of the book.
	 * @throws Exception	if the String is null or consists of 1 char
	 */
	private void validationCoteBump(String coteBump) throws Exception
	{
		if (coteBump != null)
		{
			if (coteBump.length() < 2)
			{
				throw new Exception("Veuillez saisir une cote valide");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir la cote bump");
		}

	}
	
	
	/**
	 * Verifies if the price entered is a correct one.
	 * 
	 * @param quantite	price of books in the order.
	 * @throws Exception	if the price entered is null.
	 */
	private void validationPrix(Integer prix) throws Exception
	{
		if (prix == null)
		{
			throw new Exception("Veuillez saisir un prix.");
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
	 * Create a new Detail with values of the fields of the form, if they are valids.
	 * 
	 * @param request	Request containing the form.
	 * @return	Detail object representing the details of the command(Quantity and category).
	 */
	public Detail inscrireDetail (HttpServletRequest request)
	{
		Detail detail = new Detail();
		
		try
		{
			Integer quantite = Integer.parseInt(getValeurChamp(request, CHAMP_QTE));
			validationQuantite(quantite);
			detail.setQuantite(quantite);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_QTE, e.getMessage());
		}
		
		try
		{
			String coteBump = getValeurChamp(request,CHAMP_COTE);
			validationCoteBump(coteBump);
			detail.setCoteBump(coteBump);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_COTE, e.getMessage());
		}
		
		try
		{
			Integer prix = Integer.parseInt(getValeurChamp(request, CHAMP_PRIX));
			validationPrix(prix);
			detail.setPrix(prix);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_PRIX, e.getMessage());
		}
	
	
		if (erreurs.isEmpty()) resultat = "Succès de l'inscription";
		else resultat = "Échec de l'inscription";
		
		return detail;
	}		
}