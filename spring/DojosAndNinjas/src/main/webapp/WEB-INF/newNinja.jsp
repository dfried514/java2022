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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    	<form:label path="firstName">First Name:</form:label>
    	<form:errors class="errorMessage" path="firstName"/>
  		<form:input type="text" path="firstName"/>
       	<br><br>
       	<form:label path="lastName">Last Name:</form:label>
    	<form:errors class="errorMessage" path="lastName"/>
  		<form:input type="text" path="lastName"/>
       	<br><br>
       	<form:label path="age">Age:</form:label>
    	<form:errors class="errorMessage" path="age"/>
  		<form:input type="number" min="0" step="1" path="age"/>
       	<br><br>
       	<form:label path="dojo">Select Dojo:</form:label>
    	<form:select path="dojo">
    		<c:forEach var="oneDojo" items="${dojos}">
    			<form:option value="${oneDojo.id}">
    				<c:out value="${oneDojo.location}"/>
    			</form:option>
	    	</c:forEach> 	
    	</form:select>
       	<br><br>
		<input type="submit" value="Create"/>
    </form:form>
    <p><a href="/">Home</a></p>
</body>
</html>
