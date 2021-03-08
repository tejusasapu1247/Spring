<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all books</title>

<style>
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

tr:nth-child(even) {
  background-color: #dddddd;
}

.links a {
  background-color: #4CAF50;
  text-decoration: none;
  text-align: center;
  color: white;
  float:left;
  padding: 14px 25px;
  margin: 8px 10px;
  border: none;
  cursor: pointer;
  width: 200px;
}


.links > a:hover {
  opacity: 0.8;
}

h2 {
	color:red;
	
}

</style>
</head>
<body>
<br>
<h2>Welcome</h2> <br>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>
		<th>id</th>
		<th>isbn</th>
		<th>title</th>
		<th>author</th>
		<th>publish date</th>
		<th>price</th>
		<th>Type</th>
		<th>Delete</th>
		<th>Update</th>
		
	</tr>
	<c:forEach var="book" items="${books}">
	
	<tr>
		<td>${book.id}</td>
		<td>${book.isbn}</td>
		<td><c:out value="${book.title}"></c:out> </td>
		<td><c:out value="${book.author}"></c:out> </td>
		<td><c:out value="${book.pubDate}"></c:out> </td>
		<td><c:out value="${book.price}"></c:out> </td>
		<td><c:out value="${book.bookType}"></c:out> </td>
		<td><a href="deletebook?id=${book.id}">delete book</a></td>
		<td><a href="updatebook?id=${book.id}">update book</a></td>
		
	</tr>
	</c:forEach>
</table>
<a href="addbook">add book</a>
</body>
</html>