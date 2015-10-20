package com.book.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.book.entities.Livre;


/**
 * @author Axel Halin
 * Overview:	This class regroup utilities methods
 * 				used to manage the database.
 */
public class H2Livre
{
	
	public static void insertLivre(Livre livre)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k;IFEXISTS=TRUE", "root", "root");  
            statement = connection.createStatement();  
            statement.executeUpdate("insert into livre values (" + livre.getIdLivre() + ",'" + livre.getIsbn10() + "','" + livre.getIsbn13() + "','" + livre.getTitre() + "','" + livre.getAuteurs() + "','" + livre.getEditeur() + "','" + livre.getUrl() + "')");
       
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
