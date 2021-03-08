<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new customer</title>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="book">
	<form:hidden path="id" value="0"/>
	<table>
		<tr>
			<td>Enter name</td>
			<td><form:input path="isbn"/></td>
		</tr>
		<tr>
			<td>Enter address</td>
			<td><form:input path="title"/></td>
		</tr>
		<tr>
			<td>Enter company</td>
			<td><form:input path="author"/> </td>
		</tr>
		
	</table>
</form:form>
</body>
</html>