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
 * Overview:	This class represent the commands of the service.
 * 				Commande are mutables.
 * 
 */

@Entity
@Table(name="commande")
public class Commande
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NCom") 
	private Integer id_commande;
	
	@Column(name="NCli")
	private Integer id_client;
	
	@Column(name="NDetail")
	private Integer id_detail;
	
	@Column(name="NSpec")
	private Integer id_specificite;
	
	@Column(name="Etat")
	private String etat;
	
	@Column(name="Valide")
	private Boolean valide;
	
	// Constructors
	
	/**
	 * Create a new Commande Object with defaut values.
	 */
	public Commande()
	{
		this.id_commande = new Integer(0);
		this.id_client = new Integer(0);
		this.id_detail = new Integer(0);
		this.id_specificite = new Integer(0);
		this.etat = new String();
		this.valide = new Boolean(false);
	}
	
	
	/**
	 * Create a new Commande with specified values.
	 * 
	 * @param id_commande		id number of the command.
	 * @param id_client			id number of the client of the command.
	 * @param id_detail			id number of the detail of the command.
	 * @param id_specificite	id number of the specificity of the command
	 * @param etat				state of the command.
	 * @param valide			validity of the command (granted, denied)
	 */
	public Commande(Integer id_commande, Integer id_client, Integer id_detail, Integer id_specificite, String etat, Boolean valide)
	{
		this.id_commande = id_commande;
		this.id_client = id_client;
		this.id_detail = id_detail;
		this.id_specificite = id_specificite;
		this.etat = etat;
		this.valide = valide;
	}
	
		
	// Getters methods
	
	/**
	 * Return the id number of the command.
	 * 
	 * @return	the id number of the command.
	 */
	public Integer getIdCommande()
	{
		return id_commande;
	}
	
	
	/**
	 * Return the id number of the client.
	 * 
	 * @return	the id number of the client.
	 */	
	public Integer getIdClient()
	{
		return id_client;
	}
	
	
	/**
	 * Return the id number of the detail.
	 * 
	 * @return	id number of the detail of the command.
	 */
	public Integer getIdDetail()
	{
		return id_detail;
	}
	
	
	/**
	 * Return the id number of the specificite.
	 * 
	 * @return	id number of the specificite of the command.
	 */
	public Integer getIdSpecificite()
	{
		return id_specificite;
	}
	
	
	/**
	 * Return the state of the command.
	 * 
	 * @return	state of the command.
	 */
	public String getEtat()
	{
		return etat;
	}
	
	
	/**
	 * Return the validity of the command.
	 * 
	 * @return	validity of the command.
	 */
	public Boolean getValide()
	{
		return valide;
	}
	

	
	// Setters methods
	
	/**
	 * Modifies the id of the command.
	 * 
	 * @param id_commande	id of the command.
	 */
	public void setIdCommande(Integer id_commande)
	{
		this.id_commande = id_commande;
	}
	
	
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
	 * Modifies the id number of the detail of the command.
	 * 
	 * @param id_detail	id number of the detail of the command.
	 */
	public void setIdDetail(Integer id_detail)
	{
		this.id_detail = id_detail;
	}
	
	
	/**
	 * Modifies the id number of the specificite of the command.
	 * 
	 * @param id_specificite id number of the specificite of the command.
	 */
	public void setIdSpecificite(Integer id_specificite)
	{
		this.id_specificite = id_specificite;
	}
	
	
	/**
	 * Modifies the state of the command.
	 * 
	 * @param etat state of the command.
	 */
	public void setEtat(String etat)
	{
		this.etat = etat;
	}
	
	
	/**
	 * Modifies the validity of the command.
	 * 
	 * @param valide validity of the command.
	 */
	public void setValide(Boolean valide)
	{
		this.valide = valide;
	}
	
	// Other methods
	
	/**
	 * Describe the differents components of the command.
	 * 
	 * @return the differents components of the command.
	 * @Override 
	 */
	public String toString()
	{
		return "Commande : id_commande = " + id_commande + ","
				+ " id_client " + id_client + "," 
				+ " id_detail " + id_detail + ","
				+ " id_specificite " + id_specificite + ","
				+ " etat " + etat + ","
				+ " valide " + valide;
	}
}