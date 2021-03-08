<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient HOME page</title>
</head>
<body>
<marquee behavior="scroll" style="color: purple;">
<blink><i>Welcome to VIRTUSA online hospital Management</i></blink>
</marquee>
<%String name=(String)request.getAttribute("key"); %>
<h2 align="center" style="margin: 50px;">WElCOME ${name}!!!</h2>

</body>
</html>