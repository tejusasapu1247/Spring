<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
<style type="text/css">
	
body{
	background: url('bg2.jpg') no-repeat;
	background-size: cover;
	font-family: Arial;

}
.wrap
{
	max-width: 350px;
	border-radius: 20px;
	margin: auto;
	background: rgba(0,0,0,0.8);
	box-sizing: border-box;
	padding: 40px;
	color: #fff;
	margin-top: 100px;
}
h1{
	text-align: center;

}

input[type=text],input[type=password]
{
	width: 100%;
	box-sizing: border-box;
	padding: 12px 5px;
	background: rgba(0,0,0,0.10);
	outline: none;
	border:none;
	color: white;
	border-bottom: 1px dotted #fff;
	border-radius: 5px;
	margin: 5px;
	font-weight: bold;
}


input[type=submit]
{
	width: 100%;
	box-sizing: border-box;
	padding: 10px 0;
	margin-top: 30px;
	outline: none;
	border: none;
	background: #60adde;
	opacity: 0.7;
	border-radius: 20px;
	font-size: 20px;
	color: #fff;
}
input[type=submit]:hover
{
	background: #003366;
	opacity: 0.7;
}



</style>
</head>
<body>
<div class="wrap">
	<h1>Sign Up</h1>
	<form action="Registration" method="get">
		<input type="text" name="rname" placeholder="name" required>
		<input type="text" name="remail" placeholder="email" required>
		<input type="text" name="rphone number" placeholder="phone number" required>
		<input type="text" name="disease" placeholder="disease" required>
		
		<input type="text" name="rusername" placeholder="username" required>
		<input type="password" name="rpassword" placeholder="password" required>
		<input type="password" name="rcpassword" placeholder="confirm password" required>
		
		<input type="submit" name="" value="submit">



	</form>


</div>


</body>
</html>