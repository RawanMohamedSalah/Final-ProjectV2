<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Documents Title</title>
</head>
<body>
    <h1>Documents</h1>
    <table border="1">
        <tr>
		<th>Document ID</th>
		<th>Document Name</th>
		<th>Document Description</th>
		<th>Document Image</th>
		</tr>
        <c:forEach var="document" items="${documents}">
		  <tr>
		<td><c:out value="${document.Documents_id}"/></td>
		<td><c:out value="${document.Documents_name}"/></td>
		<td><c:out value="${document.Documents_description}"/></td>
		<td><c:out value="${document.Documents_image}"/></td>
		</tr>
		</c:forEach>
    </table>
</body>
</html>


