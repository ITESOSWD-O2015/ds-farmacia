<%@page import="com.dsfarmacia.beans.BeanProducto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Usuario</title>
</head>
<body>
<% BeanProducto bproducto=(BeanProducto)request.getAttribute("bproducto"); %>
<div align="center">
<table>
<tr>
<td>iD:</td>
<td><input type="text" size="20" name="id" value="<%= bproducto.getProductId()%>"></td>
</tr>
<tr>
<td>Descripcion:</td>
<td><input type="text" size="20" name="descripcion" value="<%= bproducto.getProductoNombre()%>"></td>
</tr>
<tr>
<td>Precio:</td>
<td><input type="text" size="20" name="precio" value="<%= bproducto.getPrecioVenta() %>"></td>
</tr>
<tr>
<td>Cantidad:</td>
<td><input type="text" size="20" name="cantidad" value="<%= bproducto.getCantidad() %>"></td>
</tr>
<tr>
<td>IVA:</td>
<td><input type="text" size="20" name="iva" value="<%= bproducto.getIva() %>"></td>
</tr>
<tr>
<td>Fecha de caducidad:</td>
<td><input type="text" size="20" name="caducidad" value="<%= bproducto.getFechaCaducicad() %>"></td>
</tr>
</table>
</div>
</body>
</html>
