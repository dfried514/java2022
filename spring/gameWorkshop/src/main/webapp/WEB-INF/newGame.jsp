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
	<title>Create New Game</title>
</head>
<body>
	<h1>New Game</h1>
	<form:form action="/games/new" method="post" modelAttribute="game">
    	<form:errors path="name"/>
    	<form:label path="name">Name:</form:label>
  		<form:input type="text" path="name"/>
       	<br><br>
      	
      	<form:errors path="genre"/>
    	<form:label path="genre">Genre:</form:label>
  		<form:input type="text" path="genre"/>
       	<br><br>
      	
      	<form:errors path="description"/>
      	<form:label path="description">Description:</form:label>
		<form:textarea path="description" rows="4" cols="50"></form:textarea>
		<form:input type="hidden" path="user" value="${user.id}"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
    </form:form>
    <p><a href="/home">dashboard</a></p>
</body>
</html>