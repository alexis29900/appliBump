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
 * Overview:	This class represent the Clients of the service.
 * 				Client are mutables.
 */

@Entity
@Table(name="client")
public class Client
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NCli", nullable = false)
	private Integer id_client;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Prenom")
	private String prenom;
	
	@Column(name="Email")
	private String email;
	
	// Constructs
	
	/**
	 * Create a new Client Object with defaut values.
	 */
	public Client()
	{
		this.id_client = new Integer(0);
		this.nom = new String();
		this.prenom = new String();
		this.email = new String();
	}
	
	
	/**
	 * Create a new Client Object whith parameters values.
	 * 	
	 * @param id_client	id number of the client.
	 * @param nom		name of the client.
	 * @param prenom	firstname of the client.
	 * @param email		email of the client.
	 */
	public Client (Integer id_client, String nom, String prenom, String email)
	{
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	
	// Getters methods
	
	/**
	 * Return the id number of the client.
	 * 
	 * @return	id number of the client.
	 */
	public Integer getIdClient()
	{
		return id_client;
	}
	
	
	/**
	 * Return the name of the client.
	 * 	
	 * @return	name of the client.
	 */
	public String getNom()
	{
		return nom;
	}
	
	
	/**
	 * Return the firstname of the client.
	 * 	
	 * @return	firstname of the client.
	 */
	public String getPrenom()
	{
		return prenom;
	}
	
	
	/**
	 * Return the email of the client.
	 * 	
	 * @return	email of the client.
	 */
	public String getEmail()
	{
		return email;
	}
	
	
	// Setters methods
	
	/**
	 * Modifies the id number of the client.
	 * 
	 * @param id_client	id number of the client.
	 */
	public void setIdClient(Integer id_client)
	{
		this.id_client = id_client;
	}
	
	
	/**
	 * Modifies the name of the client.
	 * 	
	 * @param nom	name of the client.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	
	/**
	 * Modifies the firstname of the client.
	 * 	
	 * @param prenom	firstname of the client.
	 */
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	
	/**
	 * Modifies the email adress of the client.
	 * 
	 * @param email	email of the client.
	 */	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	// Other methods
	
	/**
	 * Describe the differents components of the client.
	 * 
	 * @return the differents components of the client.
	 * @Override 
	 */
	public String toString()
	{
		return "Client : Nom = " + nom + ","
				+ " Prénom = " + prenom + ","
				+ " Email = " + email + " ] ";
	}	
}