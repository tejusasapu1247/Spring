<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Books</title>
<style type="text/css">
	.error {
		color: red;
	}
</style>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	
	<table>
			<tr>
				<td><form:hidden path = "id" value = "0" /></td>
			</tr>
			<tr>
				<td>Enter isbn:</td>
				<td><form:input path="isbn" /><form:errors path="isbn" class="error"></form:errors> </td>
			</tr>

			<tr>
				<td>Enter title:</td>
				<td><form:input path="title" /><form:errors path="title" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter author:</td>
				<td><form:input path="author"  /><form:errors path="author" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter pub date:</td>
				<td><form:input path="pubDate" /><form:errors path="pubDate" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter price:</td>
				<td><form:input path="price" /><form:errors path="price" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Select book type</td>
				<td><form:select path="bookType" items="${booktypes}"></form:select><form:errors path="bookType" class="error"></form:errors> </td>
			</tr>

			<tr>
				<td><input type="submit" value="add book" /></td>
			</tr>
		</table>
	
</form:form>
</body>
</html>