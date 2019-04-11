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
					<h2 class="text-white">Calculer une distance</h2>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row mb-5">
				<div class="col text-center">
					<h4 class="mb-5"><em>Choisissez deux communes et calculez la distance qui les sépare !</em></h4>
				
					<form method="POST" action="Distances">
						<div class="form-row">
							<div class="form-group col-md-6">
	      						<label for="villeA">Ville A</label>
	      						<select id="villeA" name="villeA" class="form-control form-control-lg" required>
							        <option disabled selected value> -- choisissez une ville -- </option>
							        <c:forEach items="${ villesFrance }" var="villeFrance">
							        	<c:choose>
							        		<c:when test="${ displayDistance eq 'true' }">
							        			<option value="<c:out value="${ villeFrance.getCodeCommuneINSEE() }" />" <c:if test="${ villeFranceA.getCodeCommuneINSEE().equals(villeFrance.getCodeCommuneINSEE()) }">selected</c:if>>${ villeFrance.getNomCommune() } (${ villeFrance.getCodePostal() })</option>
							        		</c:when>
							        		<c:otherwise>
							        			<option value="<c:out value="${ villeFrance.getCodeCommuneINSEE() }" />">${ villeFrance.getNomCommune() } (${ villeFrance.getCodePostal() })</option>
							        		</c:otherwise>
							        	</c:choose>
									</c:forEach>
						      	</select>
	    					</div>
	    					<div class="form-group col-md-6">
	      						<label for="villeB">Ville B</label>
	      						<select id="villeB" name="villeB" class="form-control form-control-lg" required>
							        <option disabled selected value> -- choisissez une ville -- </option>
							        <c:forEach items="${ villesFrance }" var="villeFrance">
							        	<c:choose>
							        		<c:when test="${ displayDistance eq 'true' }">
							        			<option value="<c:out value="${ villeFrance.getCodeCommuneINSEE() }" />" <c:if test="${ villeFranceB.getCodeCommuneINSEE().equals(villeFrance.getCodeCommuneINSEE()) }">selected</c:if>>${ villeFrance.getNomCommune() } (${ villeFrance.getCodePostal() })</option>
							        		</c:when>
							        		<c:otherwise>
							        			<option value="<c:out value="${ villeFrance.getCodeCommuneINSEE() }" />">${ villeFrance.getNomCommune() } (${ villeFrance.getCodePostal() })</option>
							        		</c:otherwise>
							        	</c:choose>
									</c:forEach>
						      	</select>
	    					</div>
	    				</div>
	    				<div class="row justify-content-center mt-3">
   							<button type="submit" class="btn btn-primary btn-lg">Calculer</button>
   						</div>
					</form>
				</div>
			</div>
			
			<c:if test="${ displayDistance eq 'true' }">
				<div class="row justify-content-center">
					<div class="col-4 text-center">
						<div class="card">
						  	<div class="card-body">
						    	<h1 class="text-primary">${ distance } km</h1>
						  	</div>
						</div>
					</div>
				</div>
			</c:if>
		</div>
		
	</body>
	
	<script src="Resources/js/jquery-3.3.1.min.js"></script>
	<script src="Resources/js/bootstrap.min.js"></script>
</html>