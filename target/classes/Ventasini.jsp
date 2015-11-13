<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Checklogin.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="Logout.jsp">Logout</a>
<a href="pass.html">forgot your password?</a>
<form action="Ventas.jsp" method="POST">

<br />
Orderby
<input type="radio" name="orderby" value=1>Total<br>
<input type="radio" name="orderby" value=2> Date<br>
<input type="radio" name="orderby" value=3> Medicine<br>
<br />
Filter
<input type="radio" name="filter" value=1> User<br>
<input type="radio" name="filter" value=2> Medicine<br>
<br />
Input: <input type="text" name="input">
<input type="submit" value="Submit" />
</form>
</body>
</html>