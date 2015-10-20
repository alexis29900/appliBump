package com.book.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Axel Halin	
 * 
 * Overview:	This class represents the Books of the service.
 * 				Livre are mutables.
 */

@Entity
@Table(name="livre")
public class Livre
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NLivre")
	private Integer id_livre;
	
	@Column(name="Isbn10") 
	private String isbn10;
	
	@Column(name="Isbn13") 
	private String isbn13;
	
	@Column(name="Titre")
	private String titre;
	
	@Column(name="Auteur")
	private String auteurs;
	
	@Column(name="Editeur")
	private String editeur;
	
	@Column(name="Url")
	private String url;
	
	// Constructors
	
	/**
	 * Constructs the Object Livre with new String values.
	 */
	public Livre()
	{
		this.id_livre = new Integer(0);
		this.isbn10 = new String();
		this.isbn13 = new String();
		this.titre = new String();
		this.auteurs = new String();
		this.editeur = new String();
		this.url = new String();
	}
	
	
	/**
	 * Constructs the Object Livre with parameters values.
	 * 
	 * @param id_livre	id number of the book
	 * @param isbn10	isbn of the book (10 characters).
	 * @param isbn13	isbn of the book (13 characters).
	 * @param titre		title of the book.
	 * @param auteurs	author(s) of the book.
	 * @param editeur	publisher of the book.
	 * @param url		Url of a commercant site where to find the book.
	 */
	public Livre(Integer id_livre, String isbn10, String isbn13, String titre, String auteurs, String editeur, String url)
	{
		this.id_livre = id_livre;
		this.isbn10 = isbn10;
		this.isbn13 = isbn13;
		this.titre = titre;
		this.auteurs = auteurs;
		this.editeur = editeur;
		this.url = url;
	}
	
	
	// Getters methods
	
	/**
	 * Return the id number of the book.
	 * 
	 * @return id number of the book.
	 */
	public Integer getIdLivre()
	{
		return id_livre;
	}
	
	
	/**
	 * Return the ISBN10 number of the book.
	 * 
	 * @return	the isbn number or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getIsbn10()
	{
		return isbn10;
	}
	
	
	/**
	 * Return the ISBN13 number of the book.
	 * 
	 * @return	the isbn number or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getIsbn13()
	{
		return isbn13;
	}
	
	
	/**
	 * Return the title of the book.
	 * 
	 * @return	the title of the book or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getTitre()
	{
		return titre;
	}
	
	
	/**
	 * Return the name(s) of the author(s) of the book.
	 * 
	 * @return	the author(s) of the book or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getAuteurs()
	{
		return auteurs;
	}
	
	
	/**
	 * Return the publisher of the book.
	 *  
	 * @return	the publisher of the book or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getEditeur()
	{
		return editeur;
	}
	
	
	/**
	 * Return the url of the book on a commercial website.
	 * 
	 * @return	the url of the book or <code> null </code>.
	 * @see	java.lang.String
	 */
	public String getUrl()
	{
		return url;
	}
	
	
	// Setters methods
	
	/**
	 * Modifies the id number of the book.
	 * 
	 * @param id_livre	the id number of the book.
	 */
	public void setIdLivre(Integer id_livre)
	{
		this.id_livre = id_livre;
	}
	
	
	/**
	 * Modifies the ISBN10 of the book.
	 * 
	 * @param isbn10	the isbn10 number of the book.
	 * @pre	isbn10	isbn10.length() == 10 || isbn10.length() == 0
	 */
	public void setIsbn10 (String isbn10)
	{
		assert isbn10.length() == 10 || isbn10.length() == 0 : "Length of isbn10 must be 10 characters";
		this.isbn10 = isbn10;
	}
	
	
	/**
	 * Modifies the ISBN13 of the book.
	 *  
	 * @param isbn13	the isbn13 number of the book.
	 * @pre	isbn13	isbn13.length() == 13 || isbn13.length() == 0
	 */
	public void setIsbn13 (String isbn13)
	{
		assert isbn13.length() == 13 || isbn13.length() == 0 : "Length of isbn13 must be 13 characters";
		this.isbn13 = isbn13;
	}
	
	
	/**
	 * Modifies the title of the book.
	 * 
	 * @param titre	the title of the book.
	 */
	public void setTitre (String titre)
	{
		this.titre = titre;
	}
	
	
	/**
	 * Modifies the name(s) of the author(s) of the book.
	 * 
	 * @param auteurs	the name(s) of the author(s).
	 */
	public void setAuteurs (String auteurs)
	{
		this.auteurs = auteurs;
	}
	
	
	/**
	 * Modifies the name of the publisher of the book.
	 * 
	 * @param editeur	the publisher of the book.
	 */
	public void setEditeur (String editeur)
	{
		this.editeur = editeur;
	}
	
	
	/**
	 * Modifies the url of the book on a commercial website.
	 * 
	 * @param url	the url of the book
	 */
	public void setUrl (String url)
	{
		this.url = url;
	}
	
	
	// Other methods
	
	/**
	 * Describe the differents components of the book.
	 * 
	 * @return the differents components of the book.
	 * @Override 
	 */
	public String toString()
	{
		return "Livre : id_livre = " + id_livre + ","
				+ " isbn10 = " + isbn10 + ","
				+ " isbn13 = " + isbn13 + ","
				+ " titre = " + titre + ","
				+ " auteur(s) = " + auteurs + ","
				+ " editeur = " + editeur + ","
				+ " url = " + url ;
	}	
}