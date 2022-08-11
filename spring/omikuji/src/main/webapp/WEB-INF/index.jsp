<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
    <form action="/omikuji/processForm" method="post">
    	<label for="luckyNunber">Pick any number from 5 to 25:</label>
  		<input type="number" name="luckyNumber" min="5" max="25">
       	<br><br>
      	<label for="city">Enter the name of any city:</label>
      	<input type="text" name="city">
      	<br><br>
      	<label for="person">Enter the name of any real person:</label>
      	<input type="text" name="person">
      	<br><br>
      	<label for="hobby">Enter professional endeavor or hobby:</label>
      	<input type="text" name="hobby">
      	<br><br>
      	<label for="livingType">Enter any type of living there:</label>
      	<input type="text" name="livingType">
      	<br><br>
      	<label for="message">Say something nice to someone:</label>
		<textarea name="message" rows="4" cols="50"></textarea>
		<br>
		<p>Send and show a friend.</p>
		<input type="submit" value="Send">
    </form>
</body>
</html>