package com.book.hibernate;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.book.entities.Client;
import com.book.entities.Commande;
import com.book.entities.Detail;
import com.book.entities.Livre;
import com.book.entities.Specificite;


/**
 * @author Axel Halin
 * Overview:	This class regroup methods testing the presence of
 * 				a Object in a specific table of the database.
 */
public class BDDExist
{
	/**
	 * Checks whether a client is present in the database or not.
	 * 
	 * @param client	client to check if present.
	 * @return	True if client is in the database, False otherwise
	 */
	public static Boolean clientAlreadyExist(Client client)
	{
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("From Client where NCli = :id");
		query.setParameter("id",client.getIdClient());
		
		Object object = new Object();
		try 
		{
			object = query.uniqueResult();
		}
		catch (NonUniqueResultException e)
		{
			return true;
		}
		
		session.close();
		
		if (object == null) return false;
		else return true;
	}
	
	/**
	 * Checks whether a command is in the database or not.
	 * 
	 * @param commande	command to check if present.
	 * @return	True if commande is in the database, False otherwise.
	 */
	public static Boolean commandeAlreadyExist(Commande commande)
	{
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("From Commande where NCom = :id");
		query.setParameter("id",commande.getIdCommande());
		
		Object object = new Object();
		try 
		{
			object = query.uniqueResult();
		}
		catch (NonUniqueResultException e)
		{
			return true;
		}
		
		session.close();
		
		if (object == null) return false;
		else return true;
	}
	
	/**
	 * Checks whether a detail is in the database or not.
	 * 
	 * @param detail	detail to check if present.
	 * @return	True if detail is in the database, False otherwise.
	 */
	public static Boolean detailAlreadyExist(Detail detail)
	{
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("From Detail where NDetail = :id");
		query.setParameter("id",detail.getIdDetail());
		
		Object object = new Object();
		try 
		{
			object = query.uniqueResult();
		}
		catch (NonUniqueResultException e)
		{
			return true;
		}
		
		session.close();
		
		if (object == null) return false;
		else return true;
	}
	
	
	/**
	 * Checks whether a book is in the database or not.
	 * 
	 * @param livre	book to check if present.
	 * @return	True if livre is in the database, False otherwise.
	 */
	public static Boolean livreAlreadyExist(Livre livre)
	{
		Session s = HibernateUtils.getSession();
		
		Query q = s.createQuery("From Livre where Isbn13 = :id");
		q.setParameter("id", livre.getIsbn13());
		
		Object o = new Object();
		try
		{
			o = q.uniqueResult();
		}
		catch (NonUniqueResultException e)
		{
			// If more than one
			return true;
		}
		
		s.close();
		
		if (o == null) return false;
		else return true;
	}
	
	/**
	 * Checks whether a specificite is in the database or not.
	 * 
	 * @param specificite specificity to check if present.
	 * @return	True if specificite is in the database, False otherwise.
	 */
	public static Boolean specificiteAlreadyExist(Specificite specificite)
	{
		Session session = HibernateUtils.getSession();
		
		Query query = session.createQuery("From Specificite where NSpec = :id");
		query.setParameter("id",specificite.getIdSpec());
		
		Object object = new Object();
		try 
		{
			object = query.uniqueResult();
		}
		catch (NonUniqueResultException e)
		{
			return true;
		}
		
		session.close();
		
		if (object == null) return false;
		else return true;
	}
}