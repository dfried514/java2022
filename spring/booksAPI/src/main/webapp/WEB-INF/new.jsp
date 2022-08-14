<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/books/processForm" method="post">
    	<label for="title">Enter title:</label>
  		<input type="text" name="title">
       	<br><br>
      	<label for="language">Enter language:</label>
      	<input type="text" name="language">
      	<br><br>
      	<label for="numberOfPages">Enter number of pages:</label>
      	<input type="number" name="numberOfPages">
      	<br><br>
      	<label for="description">Enter description:</label>
		<textarea name="description" rows="4" cols="50"></textarea>
		<br><br>
		<input type="submit" value="Submit Book">
    </form>
</body>
</html>
