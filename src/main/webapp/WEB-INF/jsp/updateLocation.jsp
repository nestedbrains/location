<!doctype html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update </title>
</head>
<body>
<form action="updateLoc" method="post">
<pre>
    ID: <input type="text" name="id" value="${location.id}" >
    code: <input type="text" name="code" value=${location.code}>
    name: <input type="text" name="name" value=${location.name}>
    type: Urban <input type="radio" name="type" value="URBAN" ${location.type == 'URBAN' ?'checked' :''}>
    Rural <input type="radio" name="type" value="RURAL" ${location.type == 'RURAL' ?'checked' :''}>

    <input type="submit" value="Save">
    </pre>
</form>
${msg}
<br>

<a href="displayLocations">View All</a>
</body>
</html>