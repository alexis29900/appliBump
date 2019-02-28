<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html5>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de validation</title>
<link type="text/css" rel="stylesheet" href="style/form.css" />
<link type="text/css" rel="stylesheet" href="style/accueil.css" />
		<link type="text/css" rel="stylesheet" href="style/accueil.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>

<body>



<header >
		<a href="accueil"> <img
						src="images/UNamur.jpg" alt="" width="180" height="180"
						id="Insert_logo"
						style="background-color: #C6D580; display: block;" />
				</a>
</header>
		<div  class="sidebar1">
	

			<ul class="nav flex-column" style="background-color: #C6D580;">


				<li class="nav-item"><a class="nav-link" href="livre">Nouvelle commande</a></li>
				<li class="nav-item"><a class="nav-link" href="gestion">Gestion des Commande</a></li>
				<li class="nav-item"><a class="nav-link " href="budget">Gestion du budget</a></li>
			</ul>
		</div>

		<article class="content">

		<h1>Validation du livre</h1>

		<section>

		<form method="post" action="validation">

			<p>Veuillez confirmer les données relatives à votre livre, s’il
				vous plaît.</p>

			<%-- Données du Livre --%>
			<fieldset>

				<%-- Création du champ isbn10 --%>
				<label for="isbn10"> N° ISBN 10 </label> <input type="text"
					id="isbn10" name="isbn10" value="${livre.isbn10}" size="30"
					maxlength="10" /> <span class="erreur">
					${form.erreurs['isbn10']}</span> <br />


				<%-- Création du champ isbn13 --%>
				<label for="isbn13"> N° ISBN13 </label> <input type="text"
					id="isbn13" name="isbn13" value="${livre.isbn13}" size="30"
					maxlength="13" /> <span class="erreur">
					${form.erreurs['isbn13']}</span> <br />


				<%-- Création du champ titre --%>
				<label for="titre"> Titre du livre </label> <input type="text"
					id="titre" name="titre" value="${livre.titre}" size="30" /> <span
					class="erreur"> ${form.erreurs['titre']}</span> <br />


				<%-- Création du champ auteur(s) --%>
				<label for="auteurs"> Auteur(s) du livre </label> <input type="text"
					id="auteurs" name="auteurs" value="${livre.auteurs}" size="30" />
				<span class="erreur"> ${form.erreurs['auteurs']}</span> <br />


				<%-- Création du champ editeur --%>
				<label for="editeur"> Editeur du livre </label> <input type="text"
					id="editeur" name="editeur" value="${livre.editeur}" size="30" />
				<span class="erreur"> ${form.erreurs['editeur']}</span> <br />


				<%-- Création du champ url --%>
				<label for="url"> Url du livre sur un site commercial </label> <input
					type="text" id="url" name="url" value="${livre.url}" size="30" />
				<span class="erreur"> ${form.erreurs['url']}</span> <br /> <br />

				<%-- Bouton de confirmation --%>
				<input type="submit" value="Valider" class="sansLabel" /> <br />

			</fieldset>

		</form>

		</section> </article>

		<aside>
		<h4>Flux RSS</h4>
		<p>Ici sera repris le flux rss et on pourra rajouter d'autre
			informations si nécessaire.</p>
		</aside>

		<footer>
		<p>
			Si vous rencontrez un problème avec la plateforme, merci de contacter :
		</p>

		<address>Contenu d'adresse</address>
		</footer>
	</div>
</body>

</html>