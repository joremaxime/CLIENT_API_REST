<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Villes de France | Modifier une ville</title>
		
		<link rel="stylesheet" type="text/css" href="Resources/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="Resources/css/style.css" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	</head>
	<body>
		<div class="container-fluid py-4 mb-5 bg-primary" id="header">
			<div class="row align-items-center">
				<div class="col-3 text-center">
					<a href="ListeVilles" class="btn btn-outline-light"><i class="fas fa-chevron-left mr-3"></i>Retour</a>
				</div>
				<div class="col-6 text-center">
					<h2 class="text-white">Modifier une ville</h2>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row justify-content-center">
				<form action="ModifierVille" method="POST">
					
				</form>
			</div>
		</div>
	</body>
</html>