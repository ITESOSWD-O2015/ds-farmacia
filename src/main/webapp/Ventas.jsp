<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dsfarmacia.daos.Ventas"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Checklogin.jsp" %>
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
<%int filter=  Integer.parseInt(request.getParameter("filter"));%>
 <%int orderby=  Integer.parseInt(request.getParameter("orderby"));%>
 <%String input= request.getParameter("input");%>

	<%
		
		Ventas v1 = new Ventas();
		ResultSet resultset;
		resultset = v1.connect(filter,orderby,input);
		while (resultset.next()) {
	%>
	
	<TABLE BORDER="1">
		<TR>
			<TH>ID</TH>
			<TH>Name</TH>
		</TR>
		<TR>
			<TD><%=resultset.getString("IDTicket")%></TD>
			<TD><%=resultset.getString("Descripcion")%></TD>
			<TD><%=resultset.getString("Precion")%></TD>
			<TD><%=resultset.getString("Precio")%></TD>
			<TD><%=resultset.getString("Importe")%></TD>
			<TD><%=resultset.getString("Nombre")%></TD>
			
		</TR>
	</TABLE>
	<%

		}
		v1.closeconection();
	%>
</body>
</html>