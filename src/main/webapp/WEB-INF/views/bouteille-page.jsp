<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<%--<script type='text/javascript' src="<c:url value="/resources/js/app.js" />"></script> --%>
	<link href="<c:url value="/resources/css/perfect-scrollbar.css" />" rel="stylesheet">

	<script type='text/javascript' src="<c:url value="/resources/js/perfect-scrollbar.min.js" />"></script>

	<script type='text/javascript' src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
	<script type='text/javascript' src="<c:url value="/resources/js/script.js" />"></script>
		
	<script type="text/javascript" >
	$(document).ready(function(){
		loadImgRep("<c:url value="/resources/img/" />");
		afficherBouteille(${id});
		var ps = new PerfectScrollbar('#informationsBouteille');
	});
	</script>
</head>

<body>

<div id="bouteille">
	<h1 id="nom"></h1>
	<div id="informationsBouteille">
		<ul>
			<li>Origine : <span id="origine"></span></li>
			<li>Année : <span id="annee"></span></li>
		</ul>
	</div>
	<div id="image"></div>
   <button>Modifier la bouteille</button>
</div>

</body>

</html>



