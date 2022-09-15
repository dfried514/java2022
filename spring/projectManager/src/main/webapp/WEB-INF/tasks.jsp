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
	<title>Project Tasks</title>
</head>
<body>
	<h1>Project: <c:out value="${project.title}"/></h1>
	<h3>Project Lead: <c:out value="${project.leadUser.firstName}"/></h3>
	<form:form action="/projects/tasks/${project.id}" method="post" modelAttribute="task">
		<form:errors path="description"/>
      	<form:label path="description">Add a task ticket:</form:label>
		<form:textarea path="description" rows="4" cols="50"></form:textarea>
		<form:input type="hidden" path="user" value="${user.id}"/>
		<form:input type="hidden" path="project" value="${project.id}"/>
		<input type="submit" value="Submit"/>
  	</form:form>
	<br>
	<c:forEach var="task" items="${project.tasks}">
		<p>
			Added by <c:out value="${task.user.firstName}"/> 
			at <fmt:formatDate pattern="h:mma MM dd" value="${task.createdAt}"/>
		</p>
		<p><c:out value="${task.description}"/></p>		
    </c:forEach> 		
	<p><a href="/dashboard">Back to Dashboard</a>	
</body>
</html>