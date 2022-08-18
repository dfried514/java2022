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
	<title>Lookify!</title>
</head>
<body>
	<form action="/search" method="post">
		<label for="artist">Search Artist:  </label>
    	<input type="text" name="artist"/>
   		<input type="submit" value="Search Artist"/>
    </form>
	<h1>Songs</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="song" items="${songs}">
				<tr>
					<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/songs/delete/${song.id}">delete</a></td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	<p><a href="/songs/new">Add New Song</a></p>
	<p><a href="/search/topTen">Top Ten Songs</a></p>
</body>
</html>
