<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Character Creation</title>
</head>
<body>
Hier komt character creation!

<form:form method="post">
		<p>
			<label for=player>Character Name: </label><input type="text" name="charactername"><br>
			<input type="submit" value="Create Character">
		</p>
	</form:form>
</body>
</html>