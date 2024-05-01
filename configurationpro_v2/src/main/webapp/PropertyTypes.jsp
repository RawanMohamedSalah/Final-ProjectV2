<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Property Types</title>
</head>
<body>
    <h1>List of Property Types</h1>
    <table border="1">
        <tr>
            <th>Type ID</th>
            <th>Type Name</th>
        </tr>
        <c:forEach var="propertyType" items="${propertyTypes}">
            <tr>
                <td><c:out value="${propertyType.propertyTypeId}"/></td>
                <td><c:out value="${propertyType.propertyTypeName}"/></td>
            </tr>
        </c:forEach>
    </table>
    <p>${errorMessage}</p>
</body>
</html>