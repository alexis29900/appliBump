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
 * Overview:	This class represent the specificity of a command.
 * 				Specificite are mutables.
 * 
 */

@Entity
@Table(name="specificite")
public class Specificite
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NSpec")
	private Integer id_spec;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Urgence")
	private Boolean urgence;
	
	// Constructors
	
	/**
	 * Create a new Specificite object with default values.
	 * 
	 */
	public Specificite()
	{
		this.id_spec = new Integer(0);
		this.type = new String();
		this.destination = new String();
		this.urgence = new Boolean(false);
	}
	
	
	/**
	 * Create a new Specificite object with specified values.
	 * 
	 * @param id_spec		id number of the specificite.
	 * @param id_commande	id number of the command.
	 * @param type			type of the command.
	 * @param destination	destination of the command.
	 * @param urgence		urgency of the command.
	 */
	public Specificite(Integer id_spec, String type, String destination, Boolean urgence)
	{
		this.id_spec = id_spec;
		this.type = type;
		this.destination = destination;
		this.urgence = urgence;
	}
	
	// Getters methods
	
	/**
	 * Return the id number of the specificity.
	 * 
	 * @return	id number of the specificity.
	 */
	public Integer getIdSpec()
	{
		return id_spec;
	}
	
	
	/**
	 * Return the type of the command.
	 * 
	 * @return	type of the command.
	 */
	public String getType()
	{
		return type;
	}
	
	
	/**
	 * Return the destination of the command.
	 * 
	 * @return	destination of the command.
	 */
	public String getDestination()
	{
		return destination;
	}
	
	
	/**
	 * Return the urgency of the command.
	 * 
	 * @return	urgency of the command.
	 */
	public Boolean getUrgence()
	{
		return urgence;
	}
	
	// Setters methods
	
	/**
	 * Modifies the id number of the specificity.
	 * 
	 * @param id_spec	id number of the specificity.
	 */
	public void setIdSpec(Integer id_spec)
	{
		this.id_spec = id_spec;
	}
	
	
	/**
	 * Modifies the type of the command.
	 * 
	 * @param type	type of the command.
	 */
	public void setType(String type)
	{
		this.type = type;
	}
	
	
	/**
	 * Modifies the destination of the command.
	 * 
	 * @param destination	destination of the command.
	 */
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	
	/**
	 * Modifies the urgency of the command.
	 * 
	 * @param urgence	urgency of the command.
	 */
	public void setUrgence(Boolean urgence)
	{
		this.urgence = urgence;
	}
	
	// Other methods
	
	/**
	 * Describe the differents components of the specificity.
	 * 
	 * @return the differents components of the specificity.
	 * @Override 
	 */
	public String toString()
	{
		return "Specifite : id_specifite = " + id_spec + ","
				+ " type = " + type + ","
				+ " destination = " + destination + ","
				+ " urgence = " + urgence;
	}
}