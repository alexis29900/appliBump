package com.book.formulaires;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.entities.Livre;

/**
 * @author Axel Halin
 * 
 * Overview:	This class represents the form
 * 				used to retrieve Isbn number of the book
 * 				of the command.
 */

public class formulaireIsbn
{
	// Fields of the form.
	private static final String CHAMP_ISBN = "isbn";
	private static final String CHAMP_URL = "url";
	
	// Result of the submission (succes or failure).
	private String resultat;
	
	// Map of occurred error(s).
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
	
	
	/**
	 * Verifies if the isbn number entered is a valid one.
	 * 	
	 * @param isbn	isbn number to verify.
	 * @throws Exception if an invalid isbn number is entered.
	 */
	private void validationISBN(String isbn) throws Exception
	{
		if (isbn != null)
		{
			if (isbn.length() != 10 && isbn.length() != 13)
			{
				throw new Exception("Le numéro d'isbn doit contenir 10 ou 13 caractères.");
			}
		}
		else
		{
			throw new Exception ("Veuillez saisisr le numéro d'isbn.");
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
	 * Uses the values of the fields of the form to create a new Livre if the values are validated by validationISBN.
	 * 	
	 * @param request	Request containing the differents fields. 
	 * @return	a new Livre with the values of the fields or an empty one.
	 * @see	#validationISBN(String isbn)
	 * @see	com.book.entities.Livre
	 * @see javax.servlet.http.HttpServletRequest
	 */
	public Livre inscrireLivre(HttpServletRequest request)
	{
		String isbn = getValeurChamp(request, CHAMP_ISBN);
		String url = getValeurChamp(request, CHAMP_URL);
		
		Livre livre = new Livre();
		
		try
		{
			validationISBN(isbn);
			if (isbn.length() == 10)
			{
				livre.setIsbn10(isbn);
			}
			else
			{
				livre.setIsbn13(isbn);			
			}
		}
		catch (Exception e)
		{
			setErreur(CHAMP_ISBN, e.getMessage());
		}
		
		livre.setUrl(url);
		
		if (erreurs.isEmpty())
		{
			resultat = "Succès de l'inscription.";
		}
		else
		{
			resultat = "Échec de l'inscription.";
		}
		
		return livre;
	}
}