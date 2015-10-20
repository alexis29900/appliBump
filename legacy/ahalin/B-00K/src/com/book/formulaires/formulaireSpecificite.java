package com.book.formulaires;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.entities.Specificite;

/**
 * @author Axel Halin
 * 
 * Overview: 	This class represents the form used
 * 				to retrieve specificity data of the command
 * 				(type,destination and urgency).
 */
public class formulaireSpecificite
{
	// Fields of the form
	private static final String CHAMP_TYPE = "type";
	private static final String CHAMP_DESTINATION = "destination";
	private static final String CHAMP_URGENCE = "urgence";
	
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
	
	
	// Validation of the fields
	
	/**
	 * Return whether the order is urgent or not depending on the choice in the form.
	 * 	
	 * @param urgent	value of the field "Urgent" of the form.
	 * @return	True if the command is urgent, False otherwise.
	 */
	private Boolean validationUrgence(String urgent)
	{
		Boolean returnValue = false;
		if (urgent == null)
		{
			returnValue = false;
		}
		else
		{
			returnValue = true;
		}
		
		return returnValue;
	}
	
	
	/**
	 * Verifies if the price entered is a correct one.
	 * 
	 * @param quantite	price of books in the order.
	 * @throws Exception	if the price entered is null.
	 */
	private void validationType(String type) throws Exception
	{
		if (type == null)
		{
			throw new Exception("Veuillez choisir une des options.");
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
	 * Create a new Specificite with the values of the fields of the form.
	 * 
	 * @param request	Request containing the form.
	 * @return	Specificite object representing the specificities of the command.
	 */
	public Specificite inscrireSpecificite (HttpServletRequest request)
	{
		String destination = request.getParameter(CHAMP_DESTINATION);
		String urgence = request.getParameter(CHAMP_URGENCE);
		
		Specificite specificite = new Specificite();
		
		try
		{
			String type = request.getParameter(CHAMP_TYPE);
			validationType(type);
			specificite.setType(type);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_TYPE, e.getMessage());
		}
		
		specificite.setDestination(destination);
		specificite.setUrgence(validationUrgence(urgence));
		
		if (erreurs.isEmpty())
		{
			resultat = "Succès de l'inscription";
		}
		else
		{
			resultat = "Échec de l'inscription";
		}
		
		return specificite;
	}	
}