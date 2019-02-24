package com.book.mail;
 
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import com.book.entities.Commande;
import com.book.entities.Client;
import com.book.entities.Livre;
import com.book.entities.Detail;
import com.book.entities.Specificite;

/**
 * @author Axel Halin
 *
 * Overview:	This class handles all the e-mail interaction
 * 				( sending notification to the client, the person
 * 				in charge,...)
 */
public class Mail
{
	// Data of email notification.
	public static final String FROM = "bumpbibli@gmail.com";
	public static final String RECIPIENT = "bumpbibli@gmail.com";
	public static final String SUBJECT = "[B-00K] Nouvelle Commande";
	
	
	/**
	 * Get a session for the sending of an email.
	 * (require a Gmail account)
	 * 
	 * @return	A session for the sending of an email.
	 */
	private static Session getSession()
	{
		// Username and password of gmail account.
		final String username = "bumpbibli@gmail.com";
		final String password = "Indianhunk01";
 
		// Properties of the session.
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  };
		
		Session session = Session.getInstance(props, authenticator);

		return session;
	}
	
	
	/**
	 * Return the body of the email to send
	 * (all informations about the command)
	 * 
	 * @param commande		command in treatment
	 * @param livre			book ordered	
	 * @param client		client of the command
	 * @param detail		detail of the command
	 * @param specificite	specificity of the command
	 * @return
	 */
	private static String setBody(Commande commande, Livre livre, Client client, Detail detail, Specificite specificite)
	{
		return new String("Bonjour,"
				+ "\n\n Une nouvelle commande vient d'être enregistrée."
				+ "\n En voici les données:"
				+ "\n\n Données de la commande: "
				+ "\n Numéro de commande: " + commande.getIdCommande()
				+ "\n Numéro de client: " + commande.getIdClient()
				+ "\n Numéro de détail: " + commande.getIdDetail()
				+ "\n Numéro de spécificité: " + commande.getIdSpecificite()
				+ "\n Etat: " + commande.getEtat()
				+ "\n Valide: " + commande.getValide()
				+ "\n\n Détail de la commande: "
				+ "\n Numéro de détail: " + detail.getIdDetail()
				+ "\n Numéro de livre: " + detail.getIdLivre()
				+ "\n Quantité souhaitée: " + detail.getQuantite()
				+ "\n Cote BUMP: " + detail.getCoteBump()
				+ "\n\n Spécificité de la commande: "
				+ "\n Numéro de spécificité: " + specificite.getIdSpec()
				+ "\n Type: " + specificite.getType()
				+ "\n Destination: " + specificite.getDestination()
				+ "\n Urgence: " + specificite.getUrgence()
				+ "\n\n Données du client:"
				+ "\n Numéro de client: " + client.getIdClient()
				+ "\n Nom du client: " + client.getNom()
				+ "\n Prénom du client: " + client.getPrenom()
				+ "\n Email du client: " + client.getEmail()
				+ "\n\n Données du livre: "
				+ "\n Isbn10: " + livre.getIsbn10()
				+ "\n Isbn13: " + livre.getIsbn13()
				+ "\n Titre: " + livre.getTitre()
				+ "\n Auteur(s): " + livre.getAuteurs()
				+ "\n Editeur: " + livre.getEditeur()
				+ "\n Url: " + livre.getUrl()
				);
	}
	
	private static String setBodyClient(Commande commande, Livre livre, Client client, Detail detail, Specificite specificite)
	{
		return "Bonjour ! \n"
				+ "Votre commande a bien été enregistrée, en voici le détail : \n"
				+ "\n\n Données de la commande: "
				+ "\n Numéro de commande: " + commande.getIdCommande()
				+ "\n Numéro de client: " + commande.getIdClient()
				+ "\n Numéro de détail: " + commande.getIdDetail()
				+ "\n Numéro de spécificité: " + commande.getIdSpecificite()
				+ "\n Etat: " + commande.getEtat()
				+ "\n Valide: " + commande.getValide()
				+ "\n\n Détail de la commande: "
				+ "\n Numéro de détail: " + detail.getIdDetail()
				+ "\n Numéro de livre: " + detail.getIdLivre()
				+ "\n Quantité souhaitée: " + detail.getQuantite()
				+ "\n Cote BUMP: " + detail.getCoteBump()
				+ "\n\n Spécificité de la commande: "
				+ "\n Numéro de spécificité: " + specificite.getIdSpec()
				+ "\n Type: " + specificite.getType()
				+ "\n Destination: " + specificite.getDestination()
				+ "\n Urgence: " + specificite.getUrgence()
				+ "\n\n Données du client:"
				+ "\n Numéro de client: " + client.getIdClient()
				+ "\n Nom du client: " + client.getNom()
				+ "\n Prénom du client: " + client.getPrenom()
				+ "\n Email du client: " + client.getEmail()
				+ "\n\n Données du livre: "
				+ "\n Isbn10: " + livre.getIsbn10()
				+ "\n Isbn13: " + livre.getIsbn13()
				+ "\n Titre: " + livre.getTitre()
				+ "\n Auteur(s): " + livre.getAuteurs()
				+ "\n Editeur: " + livre.getEditeur()
				+ "\n Url: " + livre.getUrl();
	}

	
	
	/**
	 * Send a message regarding a specified command.
	 * 
	 * @param commande	command in treatment
	 * @param livre		book of the command
	 * @param client	client of the command
	 * @param detail	detail of the command
	 * @param specificite	specificity of the command
	 * @throws RuntimeException if the mail cannot be sent
	 */
	public static void nouvelleCommande(Commande commande, Livre livre, Client client, Detail detail, Specificite specificite) throws RuntimeException
	{
		Session session = getSession();
		try
		{
			MimeMessage message = new MimeMessage(session);
			String body = setBody(commande, livre, client, detail, specificite);
		
			message.setFrom(new InternetAddress(FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT));
			message.setSubject("Nouvelle commande");
			message.setText(body,"UTF-8");
			Transport.send(message); 
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	public static void nouvelleCommandeClient(Commande commande, Livre livre, Client client, Detail detail, Specificite specificite) throws RuntimeException
	{
		Session session = getSession();
		try
		{
			MimeMessage message = new MimeMessage(session);
			String body = setBodyClient(commande,livre,client,detail,specificite);
			
			message.setFrom(new InternetAddress(FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(client.getEmail()));
			message.setSubject("Commande enregistrée");
			message.setText(body,"UTF-8");
			Transport.send(message); 
		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
}