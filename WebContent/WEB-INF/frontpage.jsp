<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dark Fantasy</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
</head>
<body><h2>Dark Fantasy</h2>
<h4>The Ultimate Zoo Experience!</h4>

<p>Please login:</p>
<form method=post>
<label for=user>Username: </label><input type=text name=user><br>
<label for=pwd>Password:</label><input type=password name=pwd ><br>
<input type=submit value="Submit">

<p>Don't have an account yet?</p>
<p><a href="<c:url value="/register"/>">Register here!</a></p>
</form>
</body>
</html>