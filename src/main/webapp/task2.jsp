<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Task 2 page</title>
</head>
<body>
<jsp:include page="resources/snippets/header.html"/>
<div class="wrapper">
    <br>
    <div class="container">
        <h1>Task 2 results:</h1>
        <table>
            <tr>
                <th>Company</th>
                <th>Products</th>
            </tr>
            <c:forEach var="t" items="${task2Results}">
                <tr>
                    <td>${t.company}"</td>
                    <td>${t.count}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
