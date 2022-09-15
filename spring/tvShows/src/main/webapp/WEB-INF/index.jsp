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
<title>TV Shows</title>
</head>
<body>
	<h1>TV Shows Database</h1>
	<h1>Register</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
    	<form:label path="name">Name:</form:label>
    	<form:errors path="name"/>
  		<form:input type="text" path="name"/>
       	<br><br>
      	
      	<form:label path="email">Email:</form:label>
      	<form:errors path="email"/>
      	<form:input type="email" path="email"/>
      	<br><br>
      	
      	<form:label path="password">Password:</form:label>
      	<form:errors path="password"/>
      	<form:input type="password" path="password"/>
      	<br><br>
      	
      	<form:label path="confirm">Confirm PW:</form:label>
      	<form:errors class="errorMessage" path="confirm"/>
      	<form:input type="password" path="confirm"/>
      	<br><br>
    
		<input type="submit" value="Register"/>
    </form:form>
    
    <h1>Log in</h1>
    <form:form action="/login" method="post" modelAttribute="newLogin">
    	<form:label path="email">Email:</form:label>
    	<form:errors path="email"/>
  		<form:input type="email" path="email"/>
       	<br><br>
      	
      	<form:label path="password">Password:</form:label>
      	<form:errors path="password"/>
      	<form:input type="password" path="password"/>
      	<br><br>
      	
      	<input type="submit" value="Login"/>
    </form:form>
</body>
</html>