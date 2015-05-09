<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" title="css" href="css/helloWorld.css"/>
</head>
<body id="body">
<div id="header">Send out greeting:</div>
<div id="content">
    <ul>
        <li>${greeting}</li>
    </ul>
</div>
<div id="footer">
    Version: ${project.version}
</div>
</body>
</html>