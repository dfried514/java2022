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
    <title>Dojos and Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Dojos and Ninjas</h1>
	<form action="/getDojo" method="post">
		<label for="dojo">Select Dojo:</label>
    	<select name="dojo">
    		<c:forEach var="oneDojo" items="${dojos}">
				<option value="${oneDojo.id}">
					<c:out value="${oneDojo.location}"/>
				</option>
    		</c:forEach>
    	</select>
   		<input type="submit"/>
    </form>
    <p><a href="/dojos/new">New Dojo</a></p>
    <p><a href="/ninjas/new">New Ninja</a></p>
</body>
</html>
