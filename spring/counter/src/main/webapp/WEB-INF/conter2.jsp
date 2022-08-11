<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conter</title>
</head>
<body>
	<p>You have visited "http://your_server" <c:out value="${count}"/> times.</p>
	<p><a href="/your_server">Test another visit?</a>
</body>
</html>