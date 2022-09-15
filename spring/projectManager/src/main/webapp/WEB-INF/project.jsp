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
	<title>Project Details</title>
</head>
<body>
	<h1>Project Details</h1>
	<p>Project:  <c:out value="${project.title}"/></p>
	<p>Description:  <c:out value="${project.description}"/></p>
	<p>Due Date:  <fmt:formatDate pattern="M/dd/yyyy" value="${project.dueDate}"/></p>
	<p><a href="/projects/tasks/${project.id}">See tasks</a></p>
	<br>
	<form action="/projects/delete/${project.id}" method="post">
		<input type="submit" value="Delete"/>
	</form>
	<br>
	<p><a href="/dashboard">Back to Dashboard</a>	
</body>
</html>