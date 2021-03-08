<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], input[type=password] {
	width: 400px;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 50px;
	margin: 8px 10px;
	border: none;
	cursor: pointer;
	width: 200px;
}

button:hover {
	opacity: 0.8;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}
</style>
</head>
<body>
	<form:form action="addbook" method="post" modelAttribute="book">

		<form:hidden path = "id" value = "${book.id}" />
		<table>
			<tr>
				<td>Enter isbn:</td>
				<td><form:input path="isbn" readOnly="readonly" /></td>
			</tr>

			<tr>
				<td>Enter title:</td>
				<td><form:input path="title" readOnly="readonly" /></td>
			</tr>

			<tr>
				<td>Enter author:</td>
				<td><form:input path="author" readOnly="readonly" /></td>
			</tr>

			<tr>
				<td>Enter pub date:</td>
				<td><form:input path="pubDate" readOnly="readonly" /></td>
			</tr>

			<tr>
				<td>Enter price:</td>
				<td><form:input path="price" /></td>
			</tr>
			
			<tr>
				<td>Select book type</td>
				<td><form:select path="bookType" items="${booktypes}"></form:select> </td>
			</tr>

			<tr>
				<td><input type="submit" value="update book" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>

