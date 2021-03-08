<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updating the book</title>
</head>
<body>
	<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td>Enter ISBN:</td>
				<td><form:input path="isbn" readonly="true"></form:input></td>
			</tr>
			<tr>
				<td>Enter Title:</td>
				<td><form:input path="title" readonly="true"></form:input></td>
			</tr>
			<tr>
				<td>Enter author:</td>
				<td><form:input path="author" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter pub Date:</td>
				<td><form:input path="publicationDate" readonly="true" /></td>
			</tr>
			<tr>
				<td>Enter price:</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
			<td><input type="submit"/></td>
			</tr>

		</table>
	</form:form>
</body>
</html>