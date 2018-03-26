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
        $("#btnCreer").click(function(){
            console.log("Click");
            creerBouteille();
        });
    });
    </script>
    
</head>

<body>

<div>

    <h1>Test pour créer une bouteille</h1>
    
    <form>
        <input type="text" id="nom" name="nom" placeholder="Nom"/>
        <input type="text" id="region" name="region" placeholder="Région"/>
        <input type="text" id="annee" name="annee" placeholder="Année"/>
        <input type="text" id="photo" name="photo" placeholder="Photo"/>
        
        <input type="button" value="Submit" id="btnCreer"/>
    </form>
    
    <div id="result"></div>

</div>

</body>

</html>



