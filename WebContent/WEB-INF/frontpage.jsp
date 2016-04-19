<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dark Fantasy</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<h2 class="col-sm-offset-2">Dark Fantasy</h2>
<h4 class="col-sm-offset-2">The Ultimate Zoo Experience!</h4>

<p class="col-sm-offset-2">Please login:</p>
<form:form class="form-horizontal" method="post" modelAttribute="Account">
  <div class="form-group">
    <label for="inputUsername3" class="col-sm-2 control-label">Username</label>
    <div class="col-sm-10">
      <form:input path="username" type="text" class="form-control" name="username" id="inputEmail3" placeholder="Username"/>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <form:input path="password" type="password" class="form-control" name="password" id="inputPassword3" placeholder="Password"/>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button><br>
      <form:errors path="username"/><br>
    </div>
  </div>
</form:form>

<p class="col-sm-offset-2">Don't have an account yet?</p>
<p class="col-sm-offset-2"><a href="<c:url value="/register"/>">Register here!</a></p>

</body>
</html>