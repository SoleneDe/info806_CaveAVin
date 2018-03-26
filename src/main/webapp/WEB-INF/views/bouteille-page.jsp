<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <%--<script type='text/javascript' src="<c:url value="/resources/js/app.js" />"></script> --%>

    <script type='text/javascript' src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script type='text/javascript' src="<c:url value="/resources/js/script.js" />"></script>
        
    <script type="text/javascript" >
    $(document).ready(function(){
        loadImgRep("<c:url value="/resources/img/" />");
        afficherBouteille(${id});
        
        $("#btnSuppr").click(function(){
            supprBouteille(${id});
        });
        
        $("#btnModif").click(function(){
            modifBouteille(${id});
        });
    });

    
    </script>
</head>

<body>

<div>

    <h1>Test pour afficher la bouteille</h1>
    <div id="bout"></div>
    
    <form>
        <input type="text" id="nom" name="nom" placeholder="Nom"/>
        <input type="text" id="region" name="region" placeholder="Région"/>
        <input type="text" id="annee" name="annee" placeholder="Année"/>
        <input type="text" id="photo" name="photo" placeholder="Photo"/>
        
        <input type="button" value="Modifier" id="btnModif"/>
    </form>
    
    <input type="button" value="Supprimer" id="btnSuppr"/>
    <div id="result"></div>

</div>

</body>

</html>



