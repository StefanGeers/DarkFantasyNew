<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
<title>Map</title>
</head>
<body>

<menu>



Menu:
<button>Charactersheet</button>

Inventory
Map

</menu>

Welcome to the map!


<img src="resources\fantasy_forest.png" usemap = "#forestmap" style="width:100%;height:100%;">

<map name = "forestmap">
		<area shape = "circle" coords="275,150,30" alt = "ruins" href="venus.htm">
		<area shape="rect" coords="40%,40%, 100%, 100%" alt="lake" href="login.htm">
</map>

</body>
</html>