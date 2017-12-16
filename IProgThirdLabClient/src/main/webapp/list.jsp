<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of books</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<c:choose>
 	<c:when test="${empty rooms}">
		<h2>No rooms found</h2>
 	</c:when>
	<c:otherwise>
	<table class="brd">
	<thead class="tabhead">
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="right"/>
		<colcolgroup class="right"/>
		<colcolgroup class="left"/>
		<tr>
			<th class="brd">ID</th>
			<th class="brd">Rentors</th>
			<th class="brd">Price</th>
			<th class="brd">Stars</th>
			<th class="brd">Staff amount</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="room" items="${rooms}">
		<tr>
			<td class="brd">${room.id}</td>
			<td class="brd">
			<ul>
			<c:forEach var="renter" items="${room.rented}">
				<li>${renter.name}</li>
			</c:forEach>
			</ul>
			</td>
			<td class="brd">${room.price}</td>
			<td class="brd right">${room.stars}</td>
			<td class="brd right">${room.staffamount}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</c:otherwise>
	</c:choose>
</body>
</html>