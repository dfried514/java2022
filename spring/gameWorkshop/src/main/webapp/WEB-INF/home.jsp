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
	<title>Game Workshop Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}"/></h1>
	<c:if test = "${games.size() > 0}">
		<h3>Current Games:</h3>
		<h3>Game</h3>
		<hr>
		<c:forEach var="game" items="${games}">
			<p><a href="/games/${game.id}"><c:out value="${game.name}"/></a></p>
			<p>Genre:  <c:out value="${game.genre}"/></p>
		</c:forEach> 		
	</c:if>
	<form action="/games/create" method="post">
		<input type="submit" value="Create New Game"/>
	</form>
	<p><a href="/logout">logout</a></p>
</body>
</html>