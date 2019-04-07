<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Task 4 page</title>
</head>
<body>
    <jsp:include page="resources/snippets/header.html"/>
    <div class="wrapper">
        <br>
        <div class="container">
            <h1>Task 4 results:</h1>
            <table>
                <tr>
                    <th>Company</th>
                    <th>Order ids</th>
                </tr>
                <c:forEach var="t" items="${task4Results}">
                    <tr>
                        <td>${t.company}"</td>
                        <td><c:forEach var="order" items="${t.orderIds}"> ${order},</c:forEach></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
