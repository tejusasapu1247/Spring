<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Disease</th>
				<th>UserName</th>	
			</tr>
		</thead>
		<tbody>
        <c:forEach items="${record}" var="record">
            <tr>
                <td>${record.name}</td>
                <td>${record.email}</td>
                <td>${record.phone}</td>
                <td>${record.disease}</td>
                <td>${record.userName}</td>
            </tr>
        </c:forEach> 
</tbody>
</table>
</body>
</html>