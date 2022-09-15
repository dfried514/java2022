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
	<title>TV Shows Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}"/></h1>
	<c:if test = "${shows.size() > 0}">
	<h3>TV Shows:</h3>
	<table>
		<thead>
			<tr>
				<th>Show</th>
				<th>Network</th>
				<th>Average Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="show" items="${shows}" varStatus="status">
				<tr>
					<td><a href="/shows/${show.id}"><c:out value="${show.title}"/></a></td>
					<td><c:out value="${show.network}"/></td>
					<td><c:out value="${averageRatings[status.index]}"/></td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	<br>
	</c:if>
	<br>
	<form action="/shows/create" method="post">
		<input type="submit" value="Add a Show"/>
	</form>
	<p><a href="/logout">logout</a></p>
</body>
</html>