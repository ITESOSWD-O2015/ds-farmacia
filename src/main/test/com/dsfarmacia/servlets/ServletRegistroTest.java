package com.dsfarmacia.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ServletRegistroTest {
	
	private String id, descripcion, precio, cantidad, iva, caducidad;
	
	@Before
	public void setUp(){
		id = "0";
		descripcion="nada";
		precio="0";
		cantidad = "0";
		iva = "0";
		caducidad="0000-00-00";
	}
	
	
	@Test
	public void testServlet(){
		HttpServletRequest request = mock(HttpServletRequest.class);    
	    
	    when(request.getParameter("id")).thenReturn("28");
	    id=request.getParameter("id");
	    assertEquals(id, "28");
	    
	    when(request.getParameter("descripcion")).thenReturn("Paracetamol");
	    descripcion=request.getParameter("descripcion");
	    assertEquals(descripcion, "Paracetamol");
	    
	    when(request.getParameter("precio")).thenReturn("19.50");
	    precio=request.getParameter("precio");
	    assertEquals(precio, "19.50");
	    
	    when(request.getParameter("cantidad")).thenReturn("3");
	    cantidad=request.getParameter("cantidad");
	    assertEquals(cantidad, "3");
	    
	    
	    when(request.getParameter("iva")).thenReturn("4.50");
	    iva = request.getParameter("iva");
	    assertEquals(iva, "4.50");
	    
	    when(request.getParameter("caducidad")).thenReturn("2012-10-09");
	    caducidad = request.getParameter("caducidad");
	    assertEquals(caducidad, "2012-10-09");
	    
	    
	    
	    
	    
	}
	  

}
