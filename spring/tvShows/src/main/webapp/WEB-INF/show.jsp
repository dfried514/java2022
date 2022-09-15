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
	<title>TV Show</title>
</head>
<body>
	<h1><c:out value="${show.title}"/></h1>
	<p>Posted By:  <c:out value="${show.creator.name}"/></p>
	<p>Network:  <c:out value="${show.network}"/></p>
	<p>Description:  <c:out value="${show.description}"/></p>
	<br>
	<c:if test="${show.creator.id == user.id}">
		<form action="/shows/edit/${show.id}" method = "get">
			<input type="submit" value="Edit"/>
		</form>
	</c:if>
	<hr>
	
	<table>
		<thead>
			<tr>
				<th>User</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rating" items="${ratings}">
				<tr>
					<td><c:out value="${rating.user.name}"/></td>
					<td><c:out value="${rating.value}"/></td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	<br>
	<c:if test="${ratingsShowAndUser.size() == 0}">
	    <form:form action="/shows/addRating/${show.id}" method="post" modelAttribute="rating">
	    	<form:errors path="value"/>
	    	<form:label path="value">Leave a Rating:</form:label>
	  		<form:input type="number" min="1" max="5" step="1" path="value"/>
			<form:input type="hidden" path="user" value="${user.id}"/>
			<form:input type="hidden" path="show" value="${show.id}"/>	
			<input type="submit" value="Rate"/>
	    </form:form>
    </c:if>
    
    
	<p><a href="/shows">Back to Dashboard</a>	
</body>
</html>