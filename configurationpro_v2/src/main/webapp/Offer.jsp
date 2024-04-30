<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Offer Types</title>
</head>
<body>
    <h1>List of Offer Types</h1>
    <table border="1">
        <tr>
            <th>Offer Type ID</th>
            <th>Offer Type Name</th>
            <th>Discount Percentage</th>
        </tr>
        <c:forEach var="offerType" items="${offerTypes}">
            <tr>
                <td><c:out value="${offerType.offerTypeId}"/></td>
                <td><c:out value="${offerType.offerTypeName}"/></td>
                <td><c:out value="${offerType.discountPercentage}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>