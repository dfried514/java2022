<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Details</title>
</head>
<body>
	<h1>Expense Details</h1>
	<p>Expense Name:  <c:out value="${expense.name}"/></p>
	<p>Expense Description:  <c:out value="${expense.description}"/></p>
	<p>Vendor:  <c:out value="${expense.vendor}"/></p>
	<p>Amount spent:  
		<fmt:setLocale value="en_US"/>
		<fmt:formatNumber type="currency" value="${expense.amount}"/>
	</p>
	<p><a href="/expenses">Go back</a></p>
</body>
</html>