<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cities List</title>
</head>
<body>
    <h1>List of Cities</h1>
    <table border="1">
        <tr>
            <th>CityID</th>
            <th>CityName</th>
        </tr>
        <c:forEach var="city" items="${cities}">
            <tr>
                <td><c:out value="${city.cityId}"/></td>
                <td><c:out value="${city.cityName}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>