<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Données de la commande</title>
		<link type="text/css" rel="stylesheet" href="style/accueil.css" />
		<link type="text/css" rel="stylesheet" href="style/form.css" />
	</head>

	<body>
		<div class="container">
			<header>
				<a href="accueil">
					<img src="images/UNamur.jpg" alt="" width="150" height="150" id="Insert_logo" style="background-color: #C6D580; display: block;" />
				</a>
			</header>

			<div class="sidebar1">
				<ul class="nav">
					<li><a href="livre">Nouvelle Commande</a></li>
					<li><a href="gestion">Gestion des commandes</a></li>
					<li><a href="budget">Gestion du budget</a></li>
				</ul>
			</div>

			<article class="content">
				<h1>Validation de la commande</h1>

				<section>
					<form method="post" action="commande">

						<p>
							Veuillez saisir les données relatives à votre commande, s’il
							vous plaît.
						</p>

						<%-- Données personnelles --%>
						<fieldset>
							<legend> Données Personnelles</legend>

							<%-- Création du champ Nom --%>
							<label for="nom"> Nom </label>
							<input type="text" id="nom" name="nom" value="" />
							<span class="erreur"> ${form_cli.erreurs['nom']}</span>
							<br />
							
							<%-- Création du champ Prénom --%>
							<label for="prenom"> Prénom </label>
							<input type="text" id="prenom" name="prenom" value="" />
							<span class="erreur"> ${form_cli.erreurs['prenom']}</span>
							<br />
							
							<%-- Création du champ Email --%>
							<label for="email"> Email </label>
							<input type="text" id="email" name="email" value="" />
							<span class="erreur"> ${form_cli.erreurs['email']}</span>
							<br />
						</fieldset>
						
						<%-- Données du Livre --%>
						<fieldset>
							<legend> Détail de la commande </legend>
				
							<%-- Création du champ Quantité --%>
							<label for="quantite"> Quantité d'exemplaires souhaitée </label>
							<input type="text" id="quantite" name="quantite" value="" />
							<span class="erreur"> ${form_detail.erreurs['quantite']}</span>
							<br />
							<br />
									
							<%-- Création du champ Cote BUMP --%>
							<label for="coteBump"> Cote BUMP</label>
							<input type="text" id="coteBump" name="coteBump" value="" />
							<label for="info"> <a href="http://www.info.fundp.ac.be/~ven/cote_bump/cote_bump.html"> liste disponible ici </a> </label>
							<span class="erreur"> ${form_detail.erreurs['coteBump']}</span>
							<br />
							<br />
							<br />
								
							<%-- Création du champ Prix --%>
							<label for="prix"> Prix approximatif (borne supérieure)</label>
							<input type="text" id="prix" name="prix" value="" />
							<span class="erreur"> ${form_detail.erreurs['prix']}</span>
							<br />
							<br />
						</fieldset>
							
						<fieldset>
							<legend> Spécificités de la commande </legend>
							
							<%-- Création du champ Urgent --%>
							<label for="urgent"> Urgent </label>
							<input type="checkbox" id="urgent" name="urgent" value="" />
							<br />
							<br />
							
							<%-- Création du champ Type --%>
							<label for="type"> Statut de la commande </label>
							<p>
								<input type="radio" id="type" name="type" value="Commande BUMP" />
								Livre à commander par la BUMP <br />
							</p>
						
							<p>
								<span class="marge">
								<input type="radio" id="type" name="type" value="Entrer note frais" />
								J'ai déjà acheté le livre, et je demande la clémence du responsable pour rentrer la note de frais correspondante. <br />
								</span>
							</p>
						
							<p>
								<span class="marge">
								<input type="radio" id="type" name="type" value="Demander autorisation" />
								Je veux acheter le livre moi-même et en demande l'autorisation. <br />
								</span> 
							</p>
							<span class="erreur"> ${form_spec.erreurs['type']}</span>
							<br />
						
						
							<%-- Création du champ Destination --%>
							<label for="destination"> Destination de la commande </label>
							<SELECT name="destination">
								<OPTION> Faculté
								<OPTION> BUMP
								<OPTION> Les deux
							</SELECT>
							<br />
							<br />
							
							<%-- Bouton de confirmation --%>
							<input type="submit" value="Valider" class="sansLabel" />
							<br />
						</fieldset>
					</form>
				</section>
			</article>

			<aside>
				<h4>Flux RSS</h4>
				<p>
					Ici sera repris le flux rss et on pourra rajouter d'autre
					informations si nécessaire.
				</p>
			</aside>

			<footer>
				<p>
					Si vous rencontrez un problème avec la plateforme, merci de contacter : email ici
				</p>

				<address>Contenu d'adresse</address>
			</footer>
		</div>
	</body>
</html>