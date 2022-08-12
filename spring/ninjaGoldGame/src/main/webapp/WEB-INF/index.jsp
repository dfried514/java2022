<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h2>Your Gold:  <c:out value="${gold}"/></h2>
	<form action="/Gold/reset" method="post">
		<input type="submit" value="Reset">
	</form>
	<br>
	<div class="containter">
		<div class="item">
			<h3>Farm</h3>
			<h4>(earns 10-20 gold)</h4>
			<form action="/Gold/processForm" method="post">
				<input type="hidden" name="farm" value="farm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="item">
			<h3>Cave</h3>
			<h4>(earns 5-10 gold)</h4>
			<form action="/Gold/processForm" method="post">
				<input type="hidden" name="cave" value="cave">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="item">
			<h3>House</h3>
			<h4>(earns 2-5 gold)</h4>
			<form action="/Gold/processForm" method="post">
				<input type="hidden" name="house" value="house">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="item">
			<h3>Spa</h3>
			<h4>(takes 5-20 gold)</h4>
			<form action="/Gold/processForm" method="post">
				<input type="hidden" name="spa" value="spa">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		
		<div class="item">
			<h3>Quest</h3>
			<h4>(earns/takes 0-50 gold)</h4>
			<form action="/Gold/processForm" method="post">
				<input type="hidden" name="quest" value="quest">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
	</div>
	<h2>Activities:</h2>
	<c:forEach var="activity" items="${activities}">
  			<c:if test="${activity.gold ge 0}">
  				<c:if test="${activity.location eq 'quest'}">
   					<p class="positiveActivity">
    					You completed a <c:out value="${activity.location}"/>
    					and earned <c:out value="${activity.gold}"/>.
    					(<fmt:formatDate type="date" value="${activity.date}" pattern="MMMM d yyyy h:mm a"/>)
    				</p>
				</c:if>
				<c:if test="${activity.location ne 'quest'}">
   					<p class="positiveActivity">
    					You entered a <c:out value="${activity.location}"/>
    					and earned <c:out value="${activity.gold}"/>.
    					(<fmt:formatDate type="date" value="${activity.date}" pattern="MMMM d yyyy h:mm a"/>)
    				</p>
				</c:if>
  			</c:if>
  			<c:if test="${activity.gold lt 0}">
  				<c:if test="${activity.location eq 'quest'}">
   					<p class="negativeActivity">
    					You failed a <c:out value="${activity.location}"/>
    					and lost <c:out value="${activity.gold}"/> Ouch.
    					(<fmt:formatDate type="date" value="${activity.date}" pattern="MMMM d yyyy h:mm a"/>)
    				</p>
				</c:if>
    			<c:if test="${activity.location eq 'spa'}">
   					<p class="negativeActivity">
    					You entered a <c:out value="${activity.location}"/>
    					and lost <c:out value="${activity.gold}"/> Ouch.
    					(<fmt:formatDate type="date" value="${activity.date}" pattern="MMMM d yyyy h:mm a"/>)
    				</p>
				</c:if>
  			</c:if>
    </c:forEach>
</body>
</html>