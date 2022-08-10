<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
	<h1>Fruits</h1>
	<c:forEach var="item" items="${fruits}">
        <p><c:out value="${item.name}"></c:out>     $<c:out value="${item.price}"></c:out></p>
    </c:forEach>
</body>
</html>