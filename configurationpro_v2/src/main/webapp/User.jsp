<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
	<h1>User List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Registration Date</th>
				<th>Phone Number</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.username}</td>
					<td>${user.email}</td>
					<td>${user.registrationDate}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>