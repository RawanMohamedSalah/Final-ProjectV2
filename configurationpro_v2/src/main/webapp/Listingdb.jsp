<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
	<title>Listing</title>
</head>
<body>
    <h1>Listings</h1>
	<table border="1">
		<tr>
			<th>Listing ID</th>
			<th>City ID</th>
			<th>Category ID</th>
			<th>Agent ID</th>
			<th>Offer ID</th>
			<th>Type ID</th>
			<th>Documents ID</th>
			<th>Bedrooms</th>
			<th>Bathrooms</th>
			<th>Square Footage</th>
			<th>Price</th>
		</tr>
		<c:forEach var="listing" items="${listings}">
		<tr>
			<td>${listing.listing_id}</td>
			<td>${listing.city_id}</td>
			<td>${listing.category_id}</td>
			<td>${listing.agent_id}</td>
			<td>${listing.offer_id}</td>
			<td>${listing.type_id}</td>
			<td>${listing.documents_id}</td>
			<td>${listing.bedrooms}</td>
			<td>${listing.bathrooms}</td>
			<td>${listing.square_footage}</td>
			<td>${listing.price}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>