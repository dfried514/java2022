<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Details</title>
</head>
<body>
	<h1>Language Details</h1>
	<p>Name:  <c:out value="${language.name}"/></p>
	<p>Creator:  <c:out value="${language.creator}"/></p>
	<p>Version:  <c:out value="${language.currentVersion}"/></p>
	<p><a href="/languages/edit/${language.id}">Edit</a></p>
	<p><a href="/languages/delete/${language.id}">Delete</a></p>
	<p><a href="/languages">Dashboard</a></p>
</body>
</html>