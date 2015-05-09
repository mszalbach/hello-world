<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" title="css" href="css/helloWorld.css"/>
</head>
<body id="body">
<div id="header">Choose one:</div>
<div id="content">
    <ul>
        <li><a href='helloServlet'>Hello World!</a></li>
        <li><a href='helloServlet?name=Joe!'>Hello Joe!</a></li>
    </ul>
</div>
<div id="footer">
    Version: ${project.version}
</div>
</body>
</html>
