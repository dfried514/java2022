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
<title>Read Share</title>
</head>
<body>
	<h1>Book Club</h1>
	<h3>A place for friends to share thoughts on books.</h3>
	<h1>Register</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
    	<form:label path="userName">User Name:</form:label>
    	<form:errors path="userName"/>
  		<form:input type="text" path="userName"/>
       	<br><br>
      	
      	<form:label path="email">Email:</form:label>
      	<form:errors path="email"/>
      	<form:input type="email" path="email"/>
      	<br><br>
      	
      	<legend>Enter your operating system:</legend>
 		<form:errors path="operatingSystem"/>
    	<form:radiobutton path="operatingSystem" value="ios"/>IOS&nbsp;
      	<form:radiobutton path="operatingSystem" value="windows"/>Windows&nbsp;
      	<form:radiobutton path="operatingSystem" value="linux"/>Linux&nbsp;
      	<br><br>
      	  	
      	<legend>Enter your interests:</legend>
 		<form:errors path="interests"/>
    	<form:checkbox path="interests" value="cooking"/>Cooking&nbsp;
      	<form:checkbox path="interests" value="running"/>Running&nbsp;
    	<form:checkbox path="interests" value="poker"/>Poker&nbsp;
    	<form:checkbox path="interests" value="movies"/>Movies&nbsp;
     	<br><br>

      	<form:label path="description">Description:</form:label>
      	<form:errors path="description"/>
		<form:textarea path="description" rows="4" cols="50"></form:textarea>
		<br><br>
      	
      	<form:label path="job">Enter your job:</form:label>
      	<form:select path="job">
      		<form:option value="engineer" label="Engineer"/>
      		<form:option value="cashier" label="Cashier"/>
      		<form:option value="driver" label="Driver"/>
      		<form:option value="student" label="Student"/>
      	</form:select>
      	<br><br>
      	
      	<form:label path="birthdate">Enter Birth Date:</form:label>
      	<form:errors path="birthdate"/>
      	<form:input type="date" path="birthdate"/>
      	<br><br>
      	
      	<form:label path="password">Password:</form:label>
      	<form:errors path="password"/>
      	<form:input type="password" path="password"/>
      	<br><br>
      	
      	<form:label path="confirm">Password:</form:label>
      	<form:errors class="errorMessage" path="confirm"/>
      	<form:input type="password" path="confirm"/>
      	<br><br>
    
		<input type="submit" value="Submit"/>
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
      	
      	<input type="submit" value="Submit"/>
    </form:form>
</body>
</html>