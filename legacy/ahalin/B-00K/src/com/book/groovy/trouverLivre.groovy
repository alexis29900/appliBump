package com.book.groovy

import com.book.entities.Livre;
import groovy.json.JsonSlurper


/**
 * @author Axel Halin
 * Overview:	This groovy class regroup all groovy scripts
 * 				used to find data from the book (using differents
 * 				API).
 */
class trouverLivre
{
	
	/**
	 * Uses different API to find data on a book from isbn number.
	 * 
	 * @param isbn	isbn10 or isbn13 of the book to find.
	 * @return	all the data of the book as defined in com.book.entities.Livre
	 */
	public static Livre rechercheGlobale (String isbn)
	{
		def found = false
		def Livre livre = new Livre()
		def nbrSites = 2
		def i = 1
		
		while(i <= nbrSites && found == false)
		{
			switch(i)
			{
				case 1:	livre = trouverISBNDB(isbn)
						break
						
				case 2: livre = trouverWorldCat(isbn)
						break
				
				default: break
			}
			
			if (bookFound(livre) == true )
			{
				found = true
			}
			
			i++
		}
		
		return livre
	}
	
	// API Methods
	
	/**
	 * Search data about a book, which isbn number is given, with isbndb.com API.
	 * 
	 * @param isbn	isbn number of the book to find.
	 * @return	data about the book which isbn number is given.
	 * @see groovy.util.XmlSlurper
	 */
	public static Livre trouverISBNDB (String isbn)
	{
		def  baseURL = "https://api.isbndb.com/book/"
		def  ACCESS_KEY = "hSaxMghEkuydI5zm9ULa3tnDigXaOcl7hnjGg8cc"
		def completeUrl=baseURL+isbn
def connection = new URL(completeUrl)
        .openConnection() as HttpURLConnection

// set some headers
connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
connection.setRequestProperty( 'X-API-KEY', 'hSaxMghEkuydI5zm9ULa3tnDigXaOcl7hnjGg8cc' )
def response=connection.inputStream.text
def jsonSlurper = new JsonSlurper()
println(response)
def object = jsonSlurper.parseText(response)
// get the response code - automatically sends the request
	def newBook = new Livre(isbn10: object.book.isbn,
								isbn13: object.book.isbn13,
								titre: object.book.title,
								auteurs:object.book.authors,
								editeur: object.book.publisher,
								url: new String())
					
		return newBook
	} 
	
	
	/**
	 * Search data about a book, which isbn number is given, with WorldCat API.
	 * 
	 * @param isbn	isbn number of the book to find.
	 * @return	data about the book which isbn number is given.
	 */
	public static Livre trouverWorldCat(String isbn)
	{
		def Url = "http://xisbn.worldcat.org/webservices/xid/isbn/${isbn}?method=getMetadata&format=xml&fl=*"
		
		def apiResponse = new URL(Url).text
		def xmlSlurper = new XmlSlurper()
		def parsedXml = xmlSlurper.parseText(apiResponse)
		
		def newBook = new Livre(isbn10: new String(),
								isbn13: parsedXml.isbn,
								titre: 		parsedXml.isbn.@title,
								auteurs: 	parsedXml.isbn.@author,
								editeur: 	parsedXml.isbn.@publisher,
								url: new String() 	)
		return newBook
	}
	
		
	/**
	 * Determines whether all fields of the Livre have been found.
	 * 
	 * @param livre	Book to test.
	 * @return	True if all field of the book have been found; False otherwise.
	 */
	private static Boolean bookFound (Livre livre)
	{
		def trouve = true
		
		if ( livre.getIsbn10() == null || livre.getIsbn10().length() == 0) trouve = false
		if ( livre.getIsbn13() == null || livre.getIsbn13().length() == 0) trouve = false
		if ( livre.getTitre() == null || livre.getTitre().length() == 0) trouve = false
		if ( livre.getAuteurs() == null || livre.getAuteurs().length() == 0) trouve = false
		if ( livre.getEditeur() == null || livre.getEditeur().length() == 0) trouve = false
		
		return trouve
	}

}