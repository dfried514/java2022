<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Date</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script type="text/javascript" src="/js/app.js"></script>
	</head>
<body onLoad="alertPageName('date')">
	<p class="date">
		The date is: <fmt:formatDate type="date" value="${date}" pattern="EEEE, 'the' d 'of' MMMM, yyyy"/>
	</p>
</body>
</html>