package com.book.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.book.entities.Budget;

import java.text.SimpleDateFormat;  
import java.util.Date;  
public class H2User {
	public static List getBudget()
	{
		Connection connection = null;
		Statement statement = null;
		List<Budget> liste=null;
		try
		{

        	Session s = HibernateUtils.getSession();

    		Query query = s.createQuery("FROM Budget"); 
    		
    		liste = query.list();
    		for (Budget e : liste) {
    			System.out.println(e.toString());
    		}
    		

    		return liste;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
return liste;
		
		
	}
	public static Budget getLastBudget()
	{
		Budget b=null;
		
		try
		{

        	Session s = HibernateUtils.getSession();

    		Query query = s.createQuery("select montant FROM Budget order by id desc limit 1"); 
    		
    		List liste = query.list();
    		b=new Budget();
    		b.setMontant((Integer) liste.get(0));
    		

       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return b;
	}
	
	public static void insertBudget(Budget budget)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();  
			
			Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k;IFEXISTS=TRUE", "root", "root");  
            statement = connection.createStatement();  
            statement.executeUpdate("insert into budget (Montant,Date) values ("+budget.getMontant().toString() + ",'" +date.toString()+"')");
            
       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
