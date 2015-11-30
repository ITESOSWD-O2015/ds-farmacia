<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.dsfarmacia.daos.UpdateUserC"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
UpdateUserC user1=new UpdateUserC();
user1.updateCategory(request.getParameter( "ID" ).toString(), request.getParameter( "category" ).toString());
user1.updateactivation(request.getParameter( "ID" ).toString(), request.getParameter( "active" ).toString());
response.sendRedirect("UpdateUser.jsp");
%>
</body>
</html>