<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Counter</title>
</head>
<body>
	<h1>Welcome User!</h1>
	<form action="/your_server/reset">
		<input type=submit value="Reset Counter">
	</form>
</body>
</html>