<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Language</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body>
	<h1>Edit Language</h1>
	<form:form action="/languages/${language.id}" method="put" modelAttribute="language">
    	<form:label path="name">Name:</form:label>
    	<form:errors class="errorMessage" path="name"/>
  		<form:input type="text" path="name"/>
       	<br><br>
      	<form:label path="creator">Creator:</form:label>
      	<form:errors class="errorMessage" path="creator"/>
      	<form:input type="text" path="creator"/>
      	<br><br>
      	<form:label path="currentVersion">Version:</form:label>
      	<form:errors class="errorMessage" path="currentVersion"/>
      	<form:input type="text" path="currentVersion"/>
      	<br><br>
		<input type="submit" value="Submit"/>
    </form:form>
    <p><a href="/languages/delete/${language.id}">delete</a></p>
    <p><a href="/languages">Dashboard</a></p>
</body>
</html>
