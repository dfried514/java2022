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
    <title><c:out value="${dorm.name}"/></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1><c:out value="${dorm.name}"/> Students</h1>
	<c:if test="${dorm.students.size() > 0}">
		<table>
			<thead>
				<tr>
					<th>Student</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="student" items="${dorm.students}">
					<tr>
						<td>
							<c:out value="${student.name}"/>
						</td>
						<td><a href="/dorms/removeStudent/${dorm.id}/${student.id}">Remove</a></td>
					</tr>
	    		</c:forEach> 		
			</tbody>
		</table>
	</c:if>
	<form action="/dorms/addStudent/${dorm.id}" method="post">
       	<label for="studentId">Students:</label>
    	<select name="studentId">
    		<c:forEach var="oneStudent" items="${students}">
    			<option value="${oneStudent.id}">
    				<c:out value="${oneStudent.name}"/>&nbsp;
    				<c:if test="${oneStudent.dorm != null}">
						(<c:out value="${oneStudent.dorm.name}"/>)
					</c:if>
    			</option>
	    	</c:forEach> 	
    	</select>
       	<br><br>
		<input type="submit" value="Add Student"/>
    </form>
    <br>
    <p><a href="/dorms">Dashboard</a></p>
</body>
</html>
