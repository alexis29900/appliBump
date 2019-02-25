package com.book.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.book.entities.Budget;


public class H2Budget {
	public static Budget[] getBudget()
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{

        	Session s = HibernateUtils.getSession();

    		Query query = s.createQuery("FROM Budget"); 
    		
    		List<Budget> liste = query.list();
    		for (Budget e : liste) {
    			System.out.println(e.toString());
    		}
    		
    		return null;
       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
		
	}
	public static Budget getLastBudget()
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{

        	Session s = HibernateUtils.getSession();

    		Query query = s.createQuery("select montant FROM Budget order by id desc limit 1"); 
    		
    		List liste = query.list();
    		Budget b=new Budget();
    		b.setMontant((Integer) liste.get(0));
    		return b;

       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void insertBudget(Budget budget)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			
			Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k;IFEXISTS=TRUE", "root", "root");  
            statement = connection.createStatement();  
            statement.executeUpdate("insert into budget (Montant,Date) values ("+budget.getMontant().toString() + ",'" + budget.getDate().toString()+"')");
            
       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
