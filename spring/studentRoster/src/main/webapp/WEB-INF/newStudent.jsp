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
    <title>New Student</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>New Student</h1>
	<form:form action="/students/new" method="post" modelAttribute="student">
    	<form:label path="name">Name:</form:label>
    	<form:errors class="errorMessage" path="name"/>
  		<form:input type="text" path="name"/>
       	<br><br>
       	<form:label path="dorm">Select Dorm:</form:label>
    	<form:select path="dorm">
    		<c:forEach var="oneDorm" items="${dorms}">
    			<form:option value="${oneDorm.id}">
    				<c:out value="${oneDorm.name}"/>
    			</form:option>
	    	</c:forEach> 	
    	</form:select>
       	<br><br>
		<input type="submit" value="Add Student"/>
    </form:form>
    <p><a href="/dorms">Dashboard</a></p>
</body>
</html>
