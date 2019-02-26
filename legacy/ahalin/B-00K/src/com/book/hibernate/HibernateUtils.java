package com.book.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.book.entities.Livre;


/**
 * @author Axel Halin
 * Overview:	This class regroup utilities methods
 * 				used to manage the database.
 */
public class HibernateUtils
{
	private static final SessionFactory sessionFactory;
	
	// Create a unique instance of the SessionFactory from hibernate.cfg.xml
	static
	{
		try
		{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch (HibernateException ex)
		{
			throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
		}
	}

	
	/**
	 * Get a hibernate session to the database.
	 * 
	 * @return	Hibernate session.
	 * @throws HibernateException Indicates a problem opening the session; pretty rare here. 
	 */
	public static Session getSession() throws HibernateException
	{
		return sessionFactory.openSession();
	}
	
	
	/**
	 * Take an object and insert it in the database.
	 * 
	 * @param object	the object to insert in the database.
	 */
	public static void insert(Object object)
	{
		// Get a Hibernate session.
		Session s = HibernateUtils.getSession();

		Transaction t = s.beginTransaction();
		
		// Save the object
		s.save(object);
		
		t.commit();
		s.close();
	}

	
	/**
	 * Get all the elements present in a table into a list.
	 * 
	 * @param table	Table of the database to select from. 
	 * @return	A list containing all elements of the table specified in argument.
	 */
	@SuppressWarnings("rawtypes")
	public static List selectAll (String table)
	{
		Session s = HibernateUtils.getSession();
		Query query = s.createQuery("FROM " + table); 
		
		List liste = query.list();
		
		s.close();
		return liste;
	}
	
	
	/**
	 * Return the id number of a book present in the database.
	 * 	
	 * @param livre	book to find in the database.
	 */
	@SuppressWarnings("rawtypes")
	public static void numeroLivre(Livre livre)
	{
		Boolean trouve = new Boolean(false);
		if (BDDExist.livreAlreadyExist(livre) == true)
		{	
			// Get all clients
			List listeLivres = HibernateUtils.selectAll("Livre");
	
			for (int i=0; i<listeLivres.size() && !trouve; i++)
			{
				Livre courrant = new Livre();

				courrant = (Livre) listeLivres.get(i);
				if (courrant.getIsbn13().equals(livre.getIsbn13()))
				{
					livre.setIdLivre(courrant.getIdLivre());
					trouve = true;
				}
			}
		}
	}
	
	
	/**
	 * Create the schema of the database if it doesn't already exists
	 * 
	 */
	public static void initDB()
	{
		createTableBudget();
		createTableClient();
		createTableLivre();
		createTableSpecificite();
		createTableDetail();
		createTableCommande();		
	}
	
	
	private static void createTableBudget()
	{
		Connection connection = null;  
        Statement statement = null;  
        
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists budget(NBudget int(11) not null auto_increment, Montant int(11) not null, Date varchar(255) not null, Comment varchar(45), Primary Key (NBudget))");    
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
	
	private static void createTableLivre()
	{
		Connection connection = null;  
        Statement statement = null;  
        
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists livre(NLivre int not null auto_increment, Isbn10 varchar(255) not null, Isbn13 varchar(255) not null, Titre varchar(255) not null, Auteur varchar(255) not null, Editeur varchar(255) not null, Url varchar(255) not null, Primary Key (NLivre), Unique Key (Isbn10), Unique Key (Isbn13))");
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
	
	
	private static void createTableClient()
	{
		Connection connection = null;  
        Statement statement = null;  
        
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists client(Ncli int(11) not null auto_increment,Nom varchar(45) not null, Prenom varchar(45) not null,Email varchar(45) not null, Primary Key (NCli))");
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
	
	
	private static void createTableSpecificite()
	{
		Connection connection = null;  
        Statement statement = null;  
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists specificite(NSpec int(11) not null auto_increment, Type varchar(45) not null, Destination varchar(45) not null,Urgence tinyint(1) not null, Primary Key (NSpec) )");
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
	

	private static void createTableDetail()
	{
		Connection connection = null;  
        Statement statement = null;  
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists detail(NDetail int(11) not null auto_increment, NLivre int(11) not null, Quantite int(11) not null, CoteBump varchar(45) not null, Prix int(11) not null, Primary Key (NDetail), constraint `Detail-Livre` FOREIGN KEY (`NLivre`) REFERENCES `livre` (`NLivre`) ON DELETE NO ACTION ON UPDATE NO ACTION )");
            statement.execute("create table if not exists USER(id int(11) not null auto_increment, password varchar(1000),email varchar(1000), phone varchar(1000))");

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
	
	private static void createTableCommande()
	{
		Connection connection = null;  
        Statement statement = null;  
        try
        {  
        	Class.forName("org.h2.Driver");  
        	connection = DriverManager.getConnection("jdbc:h2:~/bdd_b00k", "root", "root");  
            statement = connection.createStatement();  
            statement.execute("create table if not exists commande (NCom int(11) not null auto_increment, NCli int(11) not null, NDetail int(11) not null, NSpec int(11) not null, Etat varchar(45) not null, Valide tinyint(1) not null, Primary Key (NCom), constraint `Commande-Client` FOREIGN KEY (NCli) REFERENCES `client` (`NCli`) ON DELETE NO ACTION ON UPDATE NO ACTION, constraint `Commande-Detail` FOREIGN KEY (NDetail) REFERENCES `detail` (`NDetail`) ON DELETE NO ACTION ON UPDATE NO ACTION,  constraint `Commande-Specificite` FOREIGN KEY (NSpec) REFERENCES `specificite` (`NSpec`) ON DELETE NO ACTION ON UPDATE NO ACTION)");
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