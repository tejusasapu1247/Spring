<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>searchnig for a book</title>
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
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<table>

<thead>
	<tr>
	<th>id</th>
	<th>isbn</th>
	<th>title</th>
	<th>author</th>
	<th>pubDate</th>
	<th>book type</th>
	<th>price</th>
	</tr>
</thead>
<tbody>
            <tr>
                <td>${SearchedBook.id}</td>
                <td>${SearchedBook.isbn}</td>
                <td>${SearchedBook.title}</td>
                <td>${SearchedBook.author}</td>
                <td><fmt:formatDate  pattern="dd/MM/yyyy" value="${SearchedBook.pubDate}"/></td>
                <td>${SearchedBook.price}</td>
                 <td>${SearchedBook.bookType}</td>
            </tr>
    </tbody>
	
</table>
</body>

</html>