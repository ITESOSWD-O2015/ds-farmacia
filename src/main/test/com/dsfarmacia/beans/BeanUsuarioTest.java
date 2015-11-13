package com.dsfarmacia.beans;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dsfarmacia.beans.BeanProducto;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

public class BeanUsuarioTest {
	
	 BeanProducto bean;
	 private String iD, descripcion, precio, cantidad, iva, caducidad;
	 
	 @Before
	 public void setUp(){
		 bean = mock(BeanProducto.class);
		 iD = "0";
		 descripcion="nada";
		 precio="0";
		 cantidad = "0";
		 iva = "0";
		 caducidad="0000-00-00";
		 
	 }
	 
	 //Test para el iD del producto
	 @Test
	 public void setiDTest(){
		 bean.setiD("10");
		 verify(bean).setiD("10");
	 }
	 	
	 @Test
	 public void getiDTest(){
		when(bean.getiD()).thenReturn("14");
		 iD = bean.getiD();
		 assertEquals(iD,"14");
		 
	 }
	 
	 //Test para la descripcion del producto
	 @Test
	 public void setDescripcionTest(){
		 bean.setDescripcion("Paracetamol");
		 verify(bean).setDescripcion("Paracetamol");
	 }
	 	
	 @Test
	 public void getDescripcionTest(){
		when(bean.getDescripcion()).thenReturn("Paracetamol");
		descripcion = bean.getDescripcion();
		assertEquals(descripcion, "Paracetamol");
		 
	 }
	 
	 //Test para el precio del producto
	 @Test
	 public void setPrecioTest(){
		 bean.setPrecio("10");
		 verify(bean).setPrecio("10");
	 }
	 	
	 @Test
	 public void getPrecioTest(){
		when(bean.getPrecio()).thenReturn("10");
		precio = bean.getPrecio();
		assertEquals(precio, "10");
		 
	 }
	 
	//Test para la cantidad del producto
		 @Test
		 public void setCantidadTest(){
			 bean.setCantidad("2");
			 verify(bean).setCantidad("2");
		 }
		 	
		 @Test
		 public void getCantidadTest(){
			when(bean.getCantidad()).thenReturn("2");
			cantidad = bean.getCantidad();
			assertEquals(cantidad, "2");
		 }
		 
	//Test para el impuesto del producto
		 @Test
		 public void setIvaTest(){
			 bean.setIva("1.50");
			 verify(bean).setIva("1.50");
		 }
		 	
		 @Test
		 public void getIvaTest(){
			when(bean.getIva()).thenReturn("1.50");
			iva = bean.getIva();
			assertEquals(iva, "1.50");
		 }
		 
		//Test para la fecha de caducidad
		 @Test
		 public void setFechaCaducidadTest(){
			 bean.setCaducidad("2011-04-04");
			 verify(bean).setCaducidad("2011-04-04");
		 }
		 	
		 @Test
		 public void getFechaCaducidadTest(){
			when(bean.getCaducidad()).thenReturn("2011-04-04");
			caducidad = bean.getCaducidad();
			assertEquals(caducidad, "2011-04-04");
		 }

}
