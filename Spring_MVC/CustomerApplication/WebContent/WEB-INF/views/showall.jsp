<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hcl bookstore app</title>
<style type="text/css">
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

td {
	background-color: rgba(255, 0, 255, 0.3)
}

tr:nth-child(even) {
	background-color: rgba(0, 255, 0, 0.3);
}

tr:nth-child(odd) {
	background-color: hsl(120, 100%, 75%);
}

.table {
	color: black; /* Blue text color */
	border: 10px solid currentcolor; /* Blue border color */
}
</style>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>company</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.Company}</td>
                
                <td><a href="updatecustomer?id=${customer.id}">update customer</a></td>
                <td><a href="deletecustomer?id=${customer.id}">delete customer</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="addcustomer">addcustomer</a>
</body>
</html>