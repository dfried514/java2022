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
	<title>Project Manager Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName}"/></h1>
	<c:if test = "${uninvolvedProjects.size() > 0}">
	<h3>All Projects:</h3>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${uninvolvedProjects}">
				<tr>
					<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td><c:out value="${project.leadUser.firstName}"/></td>
					<td>
						<fmt:formatDate pattern="MM dd" value="${project.dueDate}"/>
					</td>
					<td><a href="/projects/${project.id}/addUser/${user.id}">Join team</a></td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	</c:if>
	<c:if test = "${involvedProjects.size() > 0}">
	<h3>Your Projects:</h3>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${involvedProjects}">
				<tr>
					<td><a href="/projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td><c:out value="${project.leadUser.firstName}"/></td>
					<td>
						<fmt:formatDate pattern="MM dd" value="${project.dueDate}"/>
					</td>
					<td>
						<c:choose>
							<c:when test="${user.id == project.leadUser.id}">
								<a href="/projects/edit/${project.id}">edit</a>
							</c:when>
							<c:otherwise>
								<a href="/projects/${project.id}/removeUser/${user.id}">Leave team</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	</c:if>
	<p><a href="/projects/new">+ new project</a></p>
	<p><a href="/logout">logout</a></p>
</body>
</html>