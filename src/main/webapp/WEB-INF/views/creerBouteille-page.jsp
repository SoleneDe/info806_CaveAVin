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
    $("#formulaire").submit(function(){
        alert("Test");
        creerBouteille();
    });
    </script>
    
</head>

<body>

<div>

    <h1>Test pour créer une bouteille</h1>
    
    <form id="formulaire" >
        <input type="text" name="nom" placeholder="Nom"/>
        <input type="text" name="region" placeholder="Région"/>
        <input type="text" name="annee" placeholder="Année"/>
        <input type="text" name="photo" placeholder="Photo"/>
        
        <input type="submit" value="Submit"/>
    </form>

</div>

</body>

</html>



