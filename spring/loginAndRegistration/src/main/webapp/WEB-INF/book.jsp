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
	<title>Read Share</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<c:choose>
		<c:when test="${user.id == book.user.id}">	
			<h3>
				You read <c:out value="${book.title}"/> 
				by <c:out value="${book.author}"/>
			</h3>
			<h3>Here are your thoughts:</h3>
		</c:when>
		<c:otherwise>
			<h3>
				<c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/>
				by <c:out value="${book.author}"/>
			</h3>
			<h3>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<p><c:out value="${book.thoughts}"/><p>
	<hr>
	<c:if test="${user.id == book.user.id}">
		<form action="/books/edit/${book.id}" method="get">
			<input type="submit" value="edit"/>
		</form>
	</c:if>
	<p><a href="/books">back to the shelves</a>
</body>
</html>