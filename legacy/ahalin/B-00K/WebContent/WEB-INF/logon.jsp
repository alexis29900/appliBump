<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link type="text/css" rel="stylesheet" href="style/accueil.css" />
	</head>
	
	<body>
	<form method=post action="loginValid">
		<input type="text" id="user" name="user" value="" size="20" maxlength="20" /> 
		<input type="text" id="pwd" name="isbn" value="" size="20" maxlength="20" /> 
		<input type="submit" value="Valider" class="sansLabel" />
	</form>
		
	</body>
</html>