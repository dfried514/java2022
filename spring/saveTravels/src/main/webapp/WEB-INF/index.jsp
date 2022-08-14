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
	<title>Expenses</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body>
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td><c:out value="${expense.name}"/></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>
						<fmt:setLocale value="en_US"/>
						<fmt:formatNumber type="currency" value="${expense.amount}"/>
					</td>
				</tr>
    		</c:forEach> 		
		</tbody>
	</table>
	<h2>Add an expense:</h2>
	<form:form action="/expenses/processForm" method="post" modelAttribute="expense">
    	<form:label path="name">Expense Name:</form:label>
    	<form:errors class="errorMessage" path="name"/>
  		<form:input type="text" path="name"/>
       	<br><br>
      	<form:label path="vendor">Vendor:</form:label>
      	<form:errors class="errorMessage" path="vendor"/>
      	<form:input type="text" path="vendor"/>
      	<br><br>
      	<form:label path="amount">Amount:</form:label>
      	<form:errors class="errorMessage" path="amount"/>
      	<form:input type="number" step="0.01" path="amount"/>
      	<br><br>
      	<form:label path="description">Description:</form:label>
      	<form:errors class="errorMessage" path="description"/>
		<form:textarea path="description" rows="4" cols="50"></form:textarea>
		<br><br>
		<input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
