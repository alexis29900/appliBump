package com.book.formulaires;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.book.entities.Livre;

/**
 * @author Axel Halin
 * 
 * Overview:	This class represents the form use to confirm
 * 				data about the book to order.
 * 				This form contains the same data as the Livre
 * 				entity.
 */
public class formulaireLivre
{
	// Fields of the form.
	private static final String CHAMP_ISBN10 = "isbn10";
	private static final String CHAMP_ISBN13 = "isbn13";
	private static final String CHAMP_TITRE = "titre";
	private static final String CHAMP_AUTEURS = "auteurs";
	private static final String CHAMP_EDITEUR = "editeur";
	private static final String CHAMP_URL = "url";
	
	// Result of the submission (succes or failure).
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
	
	
	/**
	 * Verifies if the isbn10 number entered is a valid one.
	 * 	
	 * @param isbn	isbn number to verify.
	 * @throws Exception if an invalid isbn10 number is entered.
	 */
	private void validationISBN10(String isbn) throws Exception
	{
		if (isbn != null)
		{
			if (isbn.length() != 10)
			{
				throw new Exception("Le numéro d'isbn10 doit contenir 10 caractères.");
			}
		}
		else
		{
			throw new Exception ("Veuillez saisisr le numéro d'isbn10.");
		}
	}
	
	
	/**
	 * Verifies if the isbn13 number entered is a valid one.
	 * 	
	 * @param isbn	isbn number to verify.
	 * @throws Exception if an invalid isbn13 number is entered.
	 */
	private void validationISBN13(String isbn) throws Exception
	{
		if (isbn != null)
		{
			if (isbn.length() != 13 )
			{
				throw new Exception("Le numéro d'isbn13 doit contenir 13 caractères.");
			}
		}
		else
		{
			throw new Exception ("Veuillez saisisr le numéro d'isbn13.");
		}
	}
	
	
	/**
	 * Verifies if the title entered is a valid one.
	 * 
	 * @param titre	Title to verify.
	 * @throws Exception	if an invalid title is entered.
	 */
	private void validationTitre(String titre) throws Exception
	{
		if (titre != null)
		{
			if (titre.length() < 5)
			{
				throw new Exception("Le titre du livre doit contenir au moins 5 caractères");
			}
		}
		else
		{
			throw new Exception ("Veuillez saisir le titre du livre.");
		}
	}
	
	
	/**
	 * Verifies if the name(s) of the author(s) entered is (are) valid one(s).
	 * 
	 * @param auteurs	Name(s) of the author(s) to verify.
	 * @throws Exception	if an invalid string is entered.
	 */
	private void validationAuteurs(String auteurs) throws Exception
	{
		if (auteurs != null)
		{
			if (auteurs.length() < 5)
			{
				throw new Exception("Le nom du (des) auteurs doit contenir au moins 5 caractères");
			}
		}
		else
		{
			throw new Exception ("Veuillez saisir le nom du (des) auteur(s)");
		}
	}
	
	
	/**
	 * Verifies if the name of the publisher entered is a valid one.
	 * 
	 * @param editeur	Name of the publisher to verify.
	 * @throws Exception	if an invalid name is entered.
	 */
	private void validationEditeur(String editeur) throws Exception
	{
		if (editeur != null)
		{
			if (editeur.length() < 5)
			{
				throw new Exception("Le nom de l'éditeur doit contenir au moins 5 caractères");
			}
		}
		else
		{
			throw new Exception("Veuillez saisir le nom de l'éditeur");
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
	 * Create a new Livre with the values of the fields of the form, if they are valids.
	 * 
	 * @param request	Request containing the form.
	 * @return	the Livre searched by the user.
	 */
	public Livre confirmerLivre(HttpServletRequest request)
	{
		String isbn10 = getValeurChamp(request, CHAMP_ISBN10);
		String isbn13 = getValeurChamp(request, CHAMP_ISBN13);
		String titre = getValeurChamp(request, CHAMP_TITRE);
		String auteurs = getValeurChamp(request, CHAMP_AUTEURS);
		String editeur = getValeurChamp(request, CHAMP_EDITEUR);
		String url = getValeurChamp(request, CHAMP_URL);
		
		Livre livre = new Livre();
		
		// Isbn10 verification.
		try
		{
			validationISBN10(isbn10);
			livre.setIsbn10(isbn10);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_ISBN10, e.getMessage());
		}
			
		// Isbn13 verification
		try
		{
			validationISBN13(isbn13);
			livre.setIsbn13(isbn13);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_ISBN13, e.getMessage());
		}
				
		// Title verification
		try
		{
			validationTitre(titre);
			livre.setTitre(titre);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_TITRE, e.getMessage());
		}
		
		// Author(s) verification
		try
		{
			validationAuteurs(auteurs);
			livre.setAuteurs(auteurs);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_AUTEURS, e.getMessage());
		}
		
		//Publisher verification
		try
		{
			validationEditeur(editeur);
			livre.setEditeur(editeur);
		}
		catch (Exception e)
		{
			setErreur(CHAMP_EDITEUR, e.getMessage());
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