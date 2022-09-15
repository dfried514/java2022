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
	<title>Game Details</title>
</head>
<body>
	<h1><c:out value="${game.name}"/></h1>
	<p>Name:  <c:out value="${game.name}"/></p>
	<p>Developer:  <c:out value="${game.user.name}"/></p>
	<p>Description:  <c:out value="${game.description}"/></p>
	<br>
	<c:if test="${user.id == game.user.id}">
		<p><a href='/games/edit/${game.id}'>edit</a></p>
		<p><a href='/games/delete/${game.id}'>>delete</a></p>
	</c:if>
	<br>
	<p><a href="/home">dashboard</a>
	<br>
	<h3>Add Game Mechanic:</h3>

</body>
</html>