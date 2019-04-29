<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="eseo.dwic.beans.VilleFrance" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Villes de France | Distances</title>
		
		<link rel="stylesheet" type="text/css" href="Resources/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="Resources/css/style.css" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	</head>
	<body>
		<div class="container-fluid py-4 mb-5 bg-primary" id="header">
			<div class="row align-items-center">
				<div class="col-3 text-center">
					<a href="index.html" class="btn btn-outline-light"><i class="fas fa-chevron-left mr-3"></i>Retour</a>
				</div>
				<div class="col-6 text-center">
					<h2 class="text-white">Liste des villes</h2>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row justify-content-between">
				<div <c:if test="${ offset <= 0 }">style="visibility: hidden;"</c:if>>
					<form method="POST" action="ListeVilles">
						<input type="hidden" name="offset" value="${ offset - 20 }" />
						<button type="submit" class="btn btn-outline-primary"><i class="fas fa-chevron-left mr-3"></i>Villes Précédentes</button>
					</form>
				</div>
				<div <c:if test="${ villesFrance.size() < 20 }">style="visibility: hidden;"</c:if>>
					<form method="POST" action="ListeVilles">
						<input type="hidden" name="offset" value="${ offset + 20 }" />
						<button type="submit" class="btn btn-outline-primary">Pages Suivantes<i class="fas fa-chevron-right ml-3"></i></button>
					</form>
				</div>
			</div>
			
			<div class="row mt-3 justify-content-center">
				<a href="AjouterVille" class="btn btn-primary">Ajouter une ville</a> 
			</div>
			
			<div class="row mt-5">
				<table class="table table-hover">
					<thead>
				    	<tr>
				      		<th scope="col">Code commune INSEE</th>
				      		<th scope="col">Nom commune</th>
				      		<th scope="col">Code Postal</th>
				      		<th scope="col">Météo</th>
				      		<th scope="col"></th>
				    	</tr>
				  	</thead>
					<tbody>
						<c:forEach items="${ villesFrance }" var="villeFrance">
							<tr>
								<th class="align-middle" scope="row">${ villeFrance.getCodeCommuneINSEE() }</th>
							    <td class="align-middle">${ villeFrance.getNomCommune() }</td>
							    <td class="align-middle">${ villeFrance.getCodePostal() }</td>
							    <td class="align-middle">${ villeFrance.getTemperature() } °C <img src="<c:out value="${ villeFrance.getWeather() }" />" title="<c:out value="${ villeFrance.getWeatherDescription() }" />" /></td>
							    <td class="align-middle">
							    	<form method="POST" action="ModifierVille">
							    		<input type="hidden" name="codeCommuneINSEE" value="${ villeFrance.getCodeCommuneINSEE() }" />
							    		<button type="submit" class="btn btn-outline-warning"><i class="fas fa-edit"></i></button>
							    	</form>
							    	<form method="POST" action="SupprimerVille">
							    		<input type="hidden" name="codeCommuneINSEE" value="${ villeFrance.getCodeCommuneINSEE() }" />
							    		<button type="submit" class="btn btn-outline-danger"><i class="fas fa-trash"></i></button>
							    	</form>
							    </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>