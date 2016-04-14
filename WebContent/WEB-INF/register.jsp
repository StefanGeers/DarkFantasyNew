<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>
<form:form method="post">
		<p>
			<label for=user>Username: </label><input type="text" name="username"><br>
			<label for=pwd>Password:</label><input type="password" name="password"><br>
			<input type="submit" value="Create Account">
		</p>
	</form:form>
</body>
</html>