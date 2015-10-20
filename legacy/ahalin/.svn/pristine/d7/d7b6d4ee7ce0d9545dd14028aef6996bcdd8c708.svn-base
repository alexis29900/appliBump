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
 * Overview:	This class represent the details of a command.
 * 				Detail are mutables.
 * 
 */

@Entity
@Table(name="detail")
public class Detail
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NDetail")
	private Integer id_detail;
	
	@Column(name="NLivre")
	private Integer id_livre;
	
	@Column(name="Quantite")
	private Integer quantite;
	
	@Column(name="CoteBump")
	private String coteBump;
	
	@Column(name="Prix")
	private Integer prix;
	
	// Constructors
	
	/**
	 * Create a new Detail object with default values.
	 * 
	 */
	public Detail()
	{
		this.id_detail = new Integer(0);
		this.id_livre = new Integer(0);
		this.quantite = new Integer(0);
		this.coteBump = new String();
		this.prix = new Integer(0);
	}
	
	
	/**
	 * Create a new Detail object with specified values.
	 * 
	 * @param id_detail		id number of the detail.
	 * @param id_commande	id number of the command.
	 * @param id_livre		id number of the book.
	 * @param quantite		quantity of book wanted.
	 * @param coteBump		number of the type of book in the library.
	 * @param prix			price of the command.
	 */
	public Detail(Integer id_detail, Integer id_livre, Integer quantite, String coteBump, Integer prix)
	{
		this.id_detail = id_detail;
		this.id_livre = id_livre;
		this.quantite = quantite;
		this.coteBump = coteBump;
		this.prix = prix;
	}
	
	// Getters methods
	
	/**
	 * Return the id number of the detail.
	 * 
	 * @return	id number of the detail.
	 */
	public Integer getIdDetail()
	{
		return id_detail;
	}
	
	
	/**
	 * Return the id number of the book.
	 * 
	 * @return	id number of the book.
	 */
	public Integer getIdLivre()
	{
		return id_livre;
	}
	
	
	/**
	 * Return the quantity of book wanted.
	 * 
	 * @return	quantity of book.
	 */
	public Integer getQuantite()
	{
		return quantite;
	}
	
	
	/**
	 * Return the category of book (the number of the category in the library)
	 * 
	 * @return	number of the category of the book.
	 */
	public String getCoteBump()
	{
		return coteBump;
	}
	
	
	/**
	 * Return the price of the command.
	 * 
	 * @return price of the command.
	 */
	public Integer getPrix()
	{
		return prix;
	}
	
	// Setters methods
	
	/**
	 * Modifies the id number of the detail.
	 * 
	 * @param id_detail	id number of the detail.
	 */
	public void setIdDetail(Integer id_detail)
	{
		this.id_detail = id_detail;
	}
	
	
	/**
	 * Modifies the id number of the book.
	 * 
	 * @param id_livre	id number of the book.
	 */
	public void setIdLivre(Integer id_livre)
	{
		this.id_livre = id_livre;
	}
	
	
	/**
	 * Modifies the quantity of book wanted.
	 * 
	 * @param quantite	quantity of book.
	 */
	public void setQuantite(Integer quantite)
	{
		this.quantite = quantite;
	}
	
	
	/**
	 * Modifies the number of the category of the book.
	 * 
	 * @param coteBump	number of the category of the book.
	 */
	public void setCoteBump(String coteBump)
	{
		this.coteBump = coteBump;
	}
	
	/**
	 * Modifies the price of the command.
	 * 
	 * @param prix price of the command.
	 */
	public void setPrix(Integer prix)
	{
		this.prix = prix;
	}
	
	// Other methods
	
	/**
	 * Describe the differents components of the detail.
	 * 
	 * @return the differents components of the detail.
	 * @Override 
	 */
	public String toString()
	{
		return "Detail : id_detail = " + id_detail + ","
				+ " id_livre = " + id_livre + ","
				+ " quantite = " + quantite + ","
				+ " cote Bump = " + coteBump;
	}
}