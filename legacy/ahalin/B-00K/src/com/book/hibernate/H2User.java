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
	public static List getUser()
	{
		Connection connection = null;
		Statement statement = null;
		List<Budget> liste=null;
		try
		{

        	Session s = HibernateUtils.getSession();

    		Query query = s.createQuery("FROM USER"); 
    		
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

	
	public static void insertUser(String username,String password,String phone,String email)
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
            statement.execute("create table if not exists USER(id int(11) not null auto_increment, password varchar(1000),email varchar(1000), phone varchar(1000))");
            statement.executeUpdate("insert into USER (user,password,phone,email) values ('"+username.toString() + "','" +password+"','"+phone+"','"+email+"')");
            
       
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
