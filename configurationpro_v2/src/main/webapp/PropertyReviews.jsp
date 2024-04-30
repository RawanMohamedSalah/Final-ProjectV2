<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Property Reviews</title>
</head>
<body>
    <h1>List of Property Reviews</h1>
    <table border="1">
        <tr>
            <th>Reviewer Name</th>
            <th>Rating</th>
            <th>Comment</th>
        </tr>
        <c:forEach var="review" items="${reviews}">
            <tr>
                <td><c:out value="${review.reviewerName}"/></td>
                <td><c:out value="${review.rating}"/></td>
                <td><c:out value="${review.comment}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>