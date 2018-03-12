<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <title>Les casiers</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <%--<script type='text/javascript' src="<c:url value="/resources/js/app.js" />"></script> --%>

    <link href="<c:url value="/resources/css/perfect-scrollbar.css" />" rel="stylesheet">

    <script type='text/javascript' src="<c:url value="/resources/js/perfect-scrollbar.min.js" />"></script>
    <script type='text/javascript' src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
    <script type='text/javascript' src="<c:url value="/resources/js/script.js" />"></script>
    
    <script type="text/javascript" >
    $(document).ready(function(){
        afficherCasiers();
        var ps = new PerfectScrollbar('#casiers');
    });
    </script>
</head>

<body>

<div>

    <h1>Casiers existants :</h1>
    <div id="casiers"></div>

</div>

</body>

</html>



