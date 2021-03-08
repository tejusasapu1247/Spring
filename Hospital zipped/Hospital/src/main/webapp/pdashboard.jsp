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
<%
	List<String> details=(List<String>) pageContext.getAttribute("details");
for(String d : details) {
	out.println(d);
}

	%>
<%-- <table border="1">
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
        <c:forEach items="${details}" var="record">
            <tr>
                <td><c:out value=" ${record.Name}"></c:out></td>
                <td>${record.Email}</td>
                <td>${record.Phone}</td>
                <td>${record.Disease}</td>
                <td>${record.UserName}</td>
            </tr>
        </c:forEach>
</tbody>
</table> --%>
	
</body>
</html>