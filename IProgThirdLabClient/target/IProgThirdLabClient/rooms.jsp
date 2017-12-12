<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rooms List</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<h1 align="center">
		<a href="/IProgThirdLabClient/add">Add room</a>
	</h1>

	<table>
		<thead>
			<tr>
				<th>Room's info</th>
				<th>Client's info</th>
				<th>Rate info</th>
				<th>Driver info</th>
				<th>Car info</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rooms}" var="room">
				<tr>
					<th>
						<p>
							ID:
							<c:out value="${room.id}"></c:out>
						</p>
						<p>
							Launch point:
							<c:out value="${room.launch}"></c:out>
						</p>
						<p>
							Destination point:
							<c:out value="${room.destination}"></c:out>
						</p>
						<p>
							Status:
							<c:out value="${room.status}"></c:out>
						</p>
						<p>
							Date:
							<c:out value="${room.preroom.date}"></c:out>
						</p>
						<p>
							Time:
							<c:out value="${room.preroom.time}"></c:out>
						</p>
						<p>
							Cost:
							<c:out value="${room.cost}"></c:out>
						</p>
						<p>
							Smokes?
							<c:out value="${room.smoking}"></c:out>
						</p>
						<p>
							Conditioner?
							<c:out value="${room.conditioner}"></c:out>
						</p>
					</th>
					<th>
						<p>
							Telephone:
							<c:out value="${room.client.telephone}"></c:out>
						</p>
						<p>
							Blacklist:
							<c:out value="${room.client.blacklist}"></c:out>
						</p>
					</th>
					<th>
						<p>
							Name:
							<c:out value="${room.rate.name}"></c:out>
						</p>
						<p>
							Description:
							<c:out value="${room.rate.description}"></c:out>
						</p>
						<p>
							Initial cost:
							<c:out value="${room.rate.initialCost}"></c:out>
						</p>
						<p>
							In town kilometer cost:
							<c:out value="${room.rate.intownKilometerCost}"></c:out>
						</p>
						<p>
							Out Town kilometer cost:
							<c:out value="${room.rate.outtownKilometerCost}"></c:out>
						</p>
						<p>
							Minimal rate kilometers:
							<c:out value="${room.rate.minimalKilometers}"></c:out>
						</p>
					</th>
					<th>
						<p>
							Name:
							<c:out value="${room.driver.name}"></c:out>
						</p>
						<p>
							Surname:
							<c:out value="${room.driver.surname}"></c:out>
						</p>
						<p>
							Passport:
							<c:out value="${room.driver.passport}"></c:out>
						</p>
					</th>
					<th>
						<p>
							Mark:
							<c:out value="${room.car.foreignMark}"></c:out>
							<c:out value="${room.car.domesticMark}"></c:out>
						</p>
						<p>
							Model:
							<c:out value="${room.car.identificationalInformation.model}"></c:out>
						</p>
						<p>
							Numbers:
							<c:out value="${room.car.identificationalInformation.numbers}"></c:out>
						</p>
						<p>
							Conditioner:
							<c:out
								value="${room.car.identificationalInformation.conditioner}"></c:out>
						</p>
					</th>
					<th><a
						href="/ITPOILab3Client/edit?id=<c:out value="${room.id}"/>">Update</a>
						<a href="/ITPOILab3Client/delete?id=<c:out value="${room.id}"/>">Delete</a>
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>