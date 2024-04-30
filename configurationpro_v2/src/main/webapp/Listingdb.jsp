<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listings</title>
</head>
<body>
    <h1>List of Listings</h1>
    <table border="1">
        <tr>
            <th>ListingID</th>
            <th>CityID</th>
            <th>CategoryID</th>
            <th>AgentID</th>
            <th>Bedrooms</th>
            <th>Bathrooms</th>
            <th>Square Footage</th>
            <th>Price</th>
        </tr>
        <c:forEach var="listing" items="${listings}">
            <tr>
                <td><c:out value="${listing.listingId}"/></td>
                <td><c:out value="${listing.cityId}"/></td>
                <td><c:out value="${listing.categoryId}"/></td>
                <td><c:out value="${listing.agentId}"/></td>
                <td><c:out value="${listing.bedrooms}"/></td>
                <td><c:out value="${listing.bathrooms}"/></td>
                <td><c:out value="${listing.squareFootage}"/></td>
                <td><c:out value="${listing.price}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>