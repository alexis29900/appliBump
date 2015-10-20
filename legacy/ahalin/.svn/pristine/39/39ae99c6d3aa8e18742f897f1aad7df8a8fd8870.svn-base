package com.book.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.book.hibernate.HibernateUtils;
import com.book.entities.Commande;

/**
 * @author Axel Halin
 * 
 * Overview: 	This class provides database related
 * 				methods to use on object Commande. 
 */
public class BDDCommande
{
	/**
	 * Return a command found by using its primary key in the database (id number)
	 * 
	 * @param id_commande id number of the command to find.
	 * @return	the command corresponding to the id number specified.
	 */
	@SuppressWarnings("rawtypes")
	public static Commande idToCommand(Integer id_commande)
	{
		Commande commande = new Commande();
		
		List listeCommandes = HibernateUtils.selectAll("Commande");
		for (int i=0; i < listeCommandes.size(); i++)
		{
			commande = (Commande) listeCommandes.get(i);
			if (commande.getIdCommande().equals(id_commande))
			{
				return commande;
			}
		}
		
		return commande;
	}
	
	
	/**
	 * Update the column valide of a command (which id number is given) in the database.
	 * 
	 * @param identifiant id number of the command.
	 * @param valeur new value of valeur to put in the database.
	 * @param commande command to update.
	 */
	public static void updateCommandeValide(Integer identifiant, Boolean valeur, Commande commande)
	{
		Session s = HibernateUtils.getSession();
		
		Transaction t = s.beginTransaction();
		
		// Save the object
		s.update(commande);
		
		t.commit();
		
		Query query = s.createQuery("update Commande c set valide = :valeur where c.id_commande = :identifiant");
		
		query.setParameter("valeur",valeur);
		query.setParameter("identifiant", identifiant);
		
		query.executeUpdate();

	}
	
	
	/**
	 * Update the column Etat of a command (which id number is given) in the database.
	 * 
	 * @param identifiant	id number of the command.
	 * @param etat new value of etat to put in the database.
	 * @param commande command to update.
	 */
	public static void updateCommandeEtat(Integer identifiant, String etat, Commande commande)
	{
		Session s = HibernateUtils.getSession();

		Transaction t = s.beginTransaction();
		
		// Save the object
		s.update(commande);
		
		t.commit();
		
		
		Query query = s.createQuery("update Commande c set etat = :etat where c.id_commande = :identifiant");
		
		query.setParameter("etat", etat);
		query.setParameter("identifiant", identifiant);
		
		query.executeUpdate();
		s.close();
	}
}