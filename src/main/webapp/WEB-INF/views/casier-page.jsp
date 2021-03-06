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
        afficherCasier(${id});
        
        $("#btnModifQte").click(function(){
            modifQteDansCasier(${id});
        });
        
        $("#btnSuppr").click(function(){
            supprCasier(${id});
        });
    });

    
    </script>
</head>

<body>

<div>

    <h1>Test pour afficher le casier</h1>
    <div id="casier"></div>
    
    <input type="text" id="bouteille" name="bouteille" placeholder="idBouteille"/>
    <input type="number" id="qteInit" value="1">
    <input type="button" value="Valider changement bouteilles" id="btnModifQte"/>
    
    <input type="button" value="Supprimer" id="btnSuppr"/>
    <div id="result"></div>


</div>

</body>

</html>



