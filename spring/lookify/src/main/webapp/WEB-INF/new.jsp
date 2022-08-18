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
<title>Add Song</title>
</head>
<body>
	<h1>Add a Song:</h1>
	<form:form action="/songs" method="post" modelAttribute="song">
    	<form:label path="title">Title:</form:label>
    	<form:errors class="errorMessage" path="title"/>
  		<form:input type="text" path="title"/>
       	<br><br>
      	<form:label path="artist">Artist:</form:label>
      	<form:errors class="errorMessage" path="artist"/>
      	<form:input type="text" path="artist"/>
      	<br><br>
      	<form:label path="rating">Rating:</form:label>
      	<form:errors class="errorMessage" path="rating"/>
		<form:input type="number" min="1" max="10" step="1" path="rating"/>
		<br><br>
		<input type="submit" value="Add Song"/>
    </form:form>
    <p><a href="/dashboard">Dashboard</a></p>
</body>
</html>