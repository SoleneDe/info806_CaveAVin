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
        afficherBouteilles();
    });
    
    </script>
</head>

<body>

<div>

    <h1>Test pour afficher les bouteilles</h1>
    <div id="listeBout"></div>
    
    <button type="button" id="btnCreate" onclick="location.href = '/creer/bouteilles';">Créer une bouteille</button>

</div>

</body>

</html>



