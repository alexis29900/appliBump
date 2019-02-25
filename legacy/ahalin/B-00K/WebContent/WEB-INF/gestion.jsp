<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
		<title>Gestion des commandes</title>
		<link type="text/css" rel="stylesheet" href="style/accueil.css" />
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
					<li> <a href="livre"> Nouvelle Commande </a> </li>
					<li> <a href="gestion">Gestion des commandes</a></li>
					<li> <a href="budget">Gestion du budget</a></li>
				</ul>
			</div>

			<article class="content">
				<h1>Gestion des commandes</h1>
				<section>
				
					<TABLE BORDER="1" >  
		
						<%-- Print the titles of the columns --%>
						<TR>	
 							<TH> NCom </TH> 
 							<TH> Nom Client </TH>
 							<TH> Prenom Client</TH> 
 							<TH> Type </TH>
 							<TH> Destination </TH>
 							<TH> Urgence </TH> 
 							<TH> Valide </TH>
 							<TH> Etat </TH>
 							<TH> Titre Livre </TH> 
 							<TH> Quantite </TH>
 							
 							
						</TR> 
		

						<%-- Print the data --%>
						<c:forEach var="commande" items="${listeCommandes}">
							<TR> 	
								<td> <c:out value="${commande.getIdCommande() }"/> </td>
							
								<%-- Customer data --%>
								<c:forEach var="client" items="${listeClients}"> 
   			    					<c:if test="${ client.getIdClient() == commande.getIdClient() }">
										<td> <c:out value="${client.getNom()}"/> 	</td>
										<td> <c:out value="${client.getPrenom()}"/> </td>
									</c:if>
								</c:forEach>
						
								<%-- Specificity data --%>
								<c:forEach var="specificite" items="${listeSpecificites}">
									<c:if test="${specificite.getIdSpec() == commande.getIdSpecificite() }">
										<td> <c:out value="${specificite.getType()}"/> </td>
										<td> <c:out value="${specificite.getDestination()}"/> </td>
										<td> <c:out value="${specificite.getUrgence()}"/> </td>
									</c:if>
								</c:forEach>
								
								<td> <c:out value="${commande.getValide()}"/> </td>
      							<td> <c:out value="${commande.getEtat() }"/> </td>
      						
								
								<%-- Detail data --%>
								<c:forEach var="detail" items="${listeDetails}">
									<c:if test="${detail.getIdDetail() == commande.getIdDetail() }">
							
										<%-- Book data --%>
										<c:forEach var="livre" items="${listeLivres}">
											<c:if test="${livre.getIdLivre() == detail.getIdLivre()}">
												<td> <c:out value="${livre.getTitre()}"/> </td>
											</c:if>	
										</c:forEach>
							
										<td> <c:out value="${detail.getQuantite()}"/>  </td>
									
									
										<c:if test="${budget - detail.getPrix() >= 0}">

											<c:if test="${commande.getEtat().equals(attente)}">
									      		<td>									
													<form method="post" action="traitementCommande">
														<fieldset>
															<input type="hidden" id="aTraite" name="aTraite" value="${commande.getIdCommande()}" />
															<input type="submit" class="validerCommande" name="decision" id="decision" value="ok" height="25px" width="25px" />
															<input type="submit" class="refuserCommande" name="decision" id="decision" value="ko" height="50px" width="50px" />
														</fieldset>
													</form>
									  			</td>
											</c:if>
  										</c:if>
									</c:if>
								</c:forEach>
      					
  							</TR>
						</c:forEach>
				</TABLE>
			</section>
		</article>
		</div>
	</body>
</html>