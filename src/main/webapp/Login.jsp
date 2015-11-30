<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dsfarmacia.daos.SingletonLogin"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
	SingletonLogin.getInstance();
	%>
<%
if(session.getAttribute( "Name" )!=null)
response.sendRedirect("Welcome.jsp"); %>
	<ul>
<li><p><b>First Name:</b>
   <%String user= request.getParameter("Username");%>
</p></li>
<li><p><b>Last  Name:</b>
   <%String pass= request.getParameter("Password");%>
</p></li>
</ul>
	<%String salida=SingletonLogin.getInstance().connect(user, pass);
	%>
	<%=salida %>
	<a href="Loginini.jsp">Try again?</a>
<%
   String name = request.getParameter( "User" );
   session.setAttribute( "Name", user );
   session.setAttribute( "ID", SingletonLogin.getInstance().getiduser() );
   session.setAttribute( "Category", SingletonLogin.getInstance().getcategory() );
   session.setAttribute( "lastDate", SingletonLogin.getInstance().getCurrentDate());
   String redirectURL = "Welcome.jsp";
   if(salida.contains("Connection Stablished")){
	   response.sendRedirect(redirectURL); 
   }
   else{
	   session.invalidate();
   }
%>

</body>
</html>

