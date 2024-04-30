<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categories List</title>
</head>
<body>
    <h1>List of Categories</h1>
    <table border="1">
        <tr>
            <th>CategoryID</th>
            <th>CategoryName</th>

        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td><c:out value="${category.categoryId}"/></td>
                <td><c:out value="${category.categoryName}"/></td>
              
            </tr>
        </c:forEach>
    </table>
</body>
</html>