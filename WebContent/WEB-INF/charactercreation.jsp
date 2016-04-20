<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
<title>Character Creation</title>
</head>
<body>
Hier komt character creation!

<form:form class="form-horizontal" method="post" modelAttribute="Player">
  <div class="form-group">
    <label for="inputUsername3" class="col-sm-2 control-label">Character Name</label>
    <div class="col-sm-10">
      <form:input path="name" type="text" class="form-control" name="playername" id="inputEmail3" placeholder="Character Name"/>
      <form:errors path="name"/><br>
    </div>
  </div>
  <table>
	<tr>
		<td>Sex :</td>
			<td><form:radiobutton path="sex" value="M" />Male <form:radiobutton
				path="sex" value="F" />Female</td>
		<td><form:errors path="sex"/></td>
	</tr>
  </table>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Create Character</button>
    </div>
  </div>
</form:form>
</body>
</html>