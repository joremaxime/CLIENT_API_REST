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
					<input type="hidden" name="codeCommuneINSEE" value="${ villeFrance.getCodeCommuneINSEE() }">
					<div class="form-row">
					    <div class="form-group col-md-6">
				        	<label for="nomCommune">Nom commune</label>
					    	<input type="text" class="form-control form-control-lg" id="nomCommune" name="nomCommune" placeholder="Nom commune" value="${ villeFrance.getNomCommune() }">
					    </div>
					    <div class="form-group col-md-6">
					    	<label for="codePostal">Code postal</label>
					    	<input type="text" class="form-control form-control-lg" id="codePostal" name="codePostal" placeholder="Code postal" value="${ villeFrance.getCodePostal() }">
					    </div>
					</div>
					<div class="form-row">
					    <div class="form-group col-md-6">
				        	<label for="libelleAcheminement">Libellé acheminement</label>
					    	<input type="text" class="form-control form-control-lg" id="libelleAcheminement" name="libelleAcheminement" placeholder="Libellé Acheminement" value="${ villeFrance.getLibelleAcheminement() }">
					    </div>
					    <div class="form-group col-md-6">
					    	<label for="ligne5">Ligne 5</label>
					    	<input type="text" class="form-control form-control-lg" id="ligne5" name="ligne5" placeholder="Ligne 5" value="${ villeFrance.getLigne5() }">
					    </div>
					</div>
					<div class="form-row">
					    <div class="form-group col-md-6">
				        	<label for="latitude">Latitude</label>
					    	<input type="text" class="form-control form-control-lg" id="latitude" name="latitude" placeholder="Latitude" value="${ villeFrance.getLatitude() }">
					    </div>
					    <div class="form-group col-md-6">
					    	<label for="longitude">Longitude</label>
					    	<input type="text" class="form-control form-control-lg" id="longitude" name="longitude" placeholder="Longitude" value="${ villeFrance.getLongitude() }">
					    </div>
					</div>
					
					<div class="row justify-content-center mt-4">
						<button type="submit" class="btn btn-primary btn-lg">Enregistrer les modifications</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>