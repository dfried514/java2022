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
	<title>Create New TV Show</title>
</head>
<body>
	<h1>Create a New TV Show</h1>
	<form:form action="/shows/new" method="post" modelAttribute="show">
    	<form:errors path="title"/>
    	<form:label path="title">Title:</form:label>
  		<form:input type="text" path="title"/>
       	<br><br>
      	
      	<form:errors path="network"/>
    	<form:label path="network">Network:</form:label>
  		<form:input type="text" path="network"/>
       	<br><br>
      	
      	<form:errors path="description"/>
      	<form:label path="description">Description:</form:label>
		<form:textarea path="description" rows="4" cols="50"></form:textarea>
		<form:input type="hidden" path="creator" value="${user.id}"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
    </form:form>
    <br>
    <form action="/shows/cancel" method="post">
    	<input type="submit" value="Cancel"/>
    </form>
</body>
</html>