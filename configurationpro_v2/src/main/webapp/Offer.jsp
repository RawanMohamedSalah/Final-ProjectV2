<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Offers</title>
</head>
<body>
    <h1>List of Offers</h1>
    <table border="1">
        <tr>
            <th>Offer ID</th>
            <th>Description</th>
        </tr>
        <c:forEach var="offer" items="${offers}">
            <tr>
                <td><c:out value="${offer.offerId}"/></td>
                <td><c:out value="${offer.offerDescription}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>