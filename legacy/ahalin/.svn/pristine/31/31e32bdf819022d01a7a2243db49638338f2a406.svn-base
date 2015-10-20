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
 * Overview:	This class represent the budget of the service.
 * 				Budget are mutables.
 * 
 */

@Entity
@Table(name="budget")
public class Budget
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="NBudget", nullable = false)
	private Integer id_budget;
	
	@Column(name="Montant")
	private Integer montant;
	
	@Column(name="Date")
	private String date;
	
	@Column(name="Comment")
	private String comment;
	
	
	// Constructors
	
	/**
	 * Create a new Budget object with default values
	 *  
	 */
	public Budget()
	{
		this.id_budget = new Integer(0);
		this.montant = new Integer(0);
		this.date = new String();
		this.comment = new String();
	}
	
	
	/**
	 * Create a new Budget object with specified values.
	 * 
	 * @param id_budget id number of the budget.
	 * @param montant	amount of the budget.
	 * @param date		date the budget was available.
	 * @param comment	facultative comment on the budget.
	 */
	public Budget(Integer id_budget, Integer montant, String date, String comment)
	{
		this.id_budget = id_budget;
		this.montant = montant;
		this.date = date;
		this.comment = comment;
	}
	
	// Getters methods
	
	/**
	 * Return the id number of the budget.
	 * 
	 * @return	id number of the budget.
	 */
	public Integer getIdBudget()
	{
		return id_budget;
	}
	
	
	/**
	 * Return the amount of the budget.
	 *  
	 * @return amount of the budget
	 */
	public Integer getMontant()
	{
		return montant;
	}
	
	
	/**
	 * Return the date of availability of the budget
	 * 
	 * @return date of availability of the budget.
	 */
	public String getDate()
	{
		return date;
	}
	
	
	/**
	 * Return the comment of the budget.
	 * 
	 * @return comment of the budget
	 */
	public String getComment()
	{
		return comment;
	}
	
	// Setter methods
	
	/**
	 * Modifies the id number of the budget
	 * 
	 * @param id_budget	id number of the budget.
	 */
	public void setIdBudget(Integer id_budget)
	{
		this.id_budget = id_budget;
	}
	
	
	/**
	 * Modifies the amount of the budget
	 * 
	 * @param montant amount of the budget
	 */
	public void setMontant(Integer montant)
	{
		this.montant = montant;
	}
	
	
	/**
	 * Modifies the date of availability of the budget.
	 * 
	 * @param date date of avalability of the budget.
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	
	
	/**
	 * Modifies the comment of the budget.
	 * 
	 * @param comment comment on the budget.
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	// Other methods
	
	/**
	 * Describe the differents components of the budget.
	 * 
	 * @return the differents components of the budget.
	 * @Override 
	 */
	public String toString()
	{
		return "Budget : id_budget = " + id_budget + "," 
				+ " montant = " + montant + ","
				+ " date = " + date + ","
				+ " comment = " + comment ;
	}
}