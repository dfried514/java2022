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
	<title>Book Share</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body>
	<h1>Add a Book to Your Shelf!</h1>
	<form:form action="/books/new" method="post" modelAttribute="book">
    	<form:label path="title">Title:</form:label>
    	<form:errors path="title"/>
  		<form:input type="text" path="title"/>
       	<br><br>
      	<form:label path="author">Author:</form:label>
      	<form:errors path="author"/>
      	<form:input type="text" path="author"/>
      	<br><br>
      	<form:label path="thoughts">My thoughts:</form:label>
      	<form:errors path="thoughts"/>
		<form:textarea path="thoughts" rows="4" cols="50"></form:textarea>
		<form:input type="hidden" path="user" value="${user.id}"/>
		<br><br>
		<input type="submit" value="Submit"/>
    </form:form>
    <p><a href="/books">back to the shelves</a>
</body>
</html>