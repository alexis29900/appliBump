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
public class USER
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable = false)
	private Integer id;
	
	@Column(name="user")
	private String user;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	// Constructors
	
	/**
	 * Create a new Budget object with default values
	 *  
	 */
	public USER()
	{
		this.id = new Integer(0);
		this.user = new String();
		this.password = new String();
		this.phone = new String();
		this.email = new String();
	}
	
	
	/**
	 * Create a new Budget object with specified values.
	 * 
	 * @param id_budget id number of the budget.
	 * @param montant	amount of the budget.
	 * @param date		date the budget was available.
	 * @param comment	facultative comment on the budget.
	 */

	// Getters methods
	
	/**
	 * Return the id number of the budget.
	 * 
	 * @return	id number of the budget.
	 */
	
	
	// Setter methods
	
	/**
	 * Modifies the id number of the budget
	 * 
	 * @param id_budget	id number of the budget.
	 */

	
	
	/**
	 * Modifies the amount of the budget
	 * 
	 * @param montant amount of the budget
	 */

	
	/**
	 * Modifies the date of availability of the budget.
	 * 
	 * @param date date of avalability of the budget.
	 */

	
	
	/**
	 * Modifies the comment of the budget.
	 * 
	 * @param comment comment on the budget.
	 */

	
	// Other methods
	
	/**
	 * Describe the differents components of the budget.
	 * 
	 * @return the differents components of the budget.
	 * @Override 
	 */
	public String toString()
	{
		return "Budget : id_budget = " + id + "," 
				+ " montant = " + user + ","
				+ " date = " + password + ","
				+ " comment = " + email ;
	}
}