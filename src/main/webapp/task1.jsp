<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Task 1 page</title>
</head>
<body>
    <jsp:include page="resources/snippets/header.html"/>
    <div class="wrapper">
        <div class="input">
            <form class="filter" action="task1" method="post">
                <h3>Add company name below</h3>
                <input type="text" id="filter" name="filter">
                <br><br>
                <input type="submit" value="Filter">
            </form>
        </div>
        <br>
        <div class="container">
            <h1>Task 1 results:</h1>
            <table>
                <tr>
                    <th>Product</th>
                    <th>Company</th>
                </tr>
                <c:forEach var="t" items="${task1Results}">
                    <tr>
                        <td>${t.productName}</td>
                        <td>${t.companyName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
    </div>
</body>
</html>
