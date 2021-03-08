<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>

body{
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: url('bg1.jpg') no-repeat;
	background-size: cover;
		
	
}
.box{
	width: 300px;
	padding: 40px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	background: #191919;
	text-align: center;
}
.box h1{
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}
.box input[type="text"],.box input[type="password"]
{
	border: 0;
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 10px;
	width: 200px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;


}
.box input[type="text"]:focus,.box input[type="password"]:focus{
	width: 280px;
	border-color: #2ecc71;

}
.box input[type="submit"]{
	border:0;
	background: none;
	display: block;
	margin:20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;

}
.box input[type="signup"]{
	border:0;
	background: none;
	display: block;
	margin:20px auto;
	text-align: center;
	border: 2px solid #3498db;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;

}

}
.box input[type="submit"]:hover{
	background:#2ecc71;
	
}
a{
text-decoration:none;
}



</style>
</head>
<body>
<form  class="box" action="PatientLogin" method="get">
<h1>Login</h1>
<input type="text" name="username" placeholder="username">	

<input type="password" name="password" placeholder="password">

<input type="submit" name="submit" value="Login">
<a href="signup.jsp">Signup</a>
</form>

</body>
</html>