<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Locations List</title>
</head>
<body>
<p style="color: crimson">${msg}</p>
<h2>Locations</h2>
<div class="main">
    <table>
        <tr>
            <th>id</th>
            <th>Code</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <c:forEach items="${locations}" var="location">
            <tr>
                <td>${location.id}</td>
                <td>${location.code}</td>
                <td>${location.name}</td>
                <td>${location.type}</td>
                <td><a href="deleteLocations?id=${location.id}">Delete</a></td>
                <td><a href="updateLocation?id=${location.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="showCreate">Add Location</a>
</div>
</body>
</html>