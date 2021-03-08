<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update customer</title>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="customer">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Enter name</td>
			<td><form:input path="name" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter address</td>
			<td><form:input path="address" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter compant</td>
			<td><form:input path="company" readonly="true"/> </td>
		</tr>
	
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>