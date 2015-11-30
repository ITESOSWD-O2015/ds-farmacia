<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dsfarmacia.daos.UpdateUserC"%>
    <%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="Checklogin.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Logout.jsp">Logout</a>
<%
UpdateUserC user1=new UpdateUserC();
ResultSet resultset;
resultset = user1.getusers();
while (resultset.next()) {
%>
<TABLE BORDER="1">
        <TR>
            <TH>ID</TH>
            <TH>Name</TH>
        </TR>
        <TR>
            <TD><%=resultset.getString("User")%></TD>
            
<TD><form action="Setuser.jsp" method="POST">

<br />

<input type="hidden" name="ID" value=<%=resultset.getString("ID")%>>
<input type="radio" name="category" value=1 checked="checked">Normal<br>
<input type="radio" name="category" value=2> Crew<br>
<input type="radio" name="category" value=3> Admin<br>
<br />
<input type="radio" name="active" value=1 checked="checked"> Active<br>
<input type="radio" name="active" value=2> Inactive<br>
<br />
<input type="submit" value="Submit" />
</form>

</TD>
            
        </TR>
    </TABLE>
        <%

        }
user1.closecon();
    %>
</body>
</html>
