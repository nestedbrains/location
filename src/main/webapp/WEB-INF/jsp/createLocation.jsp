<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="locationSave" method="post">
<pre>
    ID: <input type="text" name="id">
     code: <input type="text" name="code">
    name: <input type="text" name="name">
    type: Urban <input type="radio" name="type" value="URBAN">
    Rural <input type="radio" name="type" value="RURAL">

    <input type="submit" value="Save">
    </pre>
</form>
${msg}
<br>

<a href="displayLocations">View All</a>
</body>
</html>