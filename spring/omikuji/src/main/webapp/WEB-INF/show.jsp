<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Here's your Omikuji!</h1>
	<span>
		In <c:out value="${luckyNumber}"/> years, you will live in <c:out value="${city}"/>
		with <c:out value="${person}"/> as your room mate, <c:out value="${hobby}"/> for a living.
		The next time you see a <c:out value="${livingType}"/>, you will have good luck.
		Also, <c:out value="${message}"/>
	</span>
	<p><a href="/omikuji">Go Back</a></p>
</body>
</html>