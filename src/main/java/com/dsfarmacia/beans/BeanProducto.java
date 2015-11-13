package com.dsfarmacia.beans;

public class BeanProducto {
	 
	 private String iD;
	 private String descripcion;
	 private String precio;
	 private String cantidad;
	 private String iVA;
	 private String fechaCaducicad;
	 
	 public BeanProducto(String id, String descripcion, String precio, String cantidad, String iva, String caducidad) {
		super();
		this.iD = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.iVA = iva;
		this.fechaCaducicad = caducidad;
		}
	 
	 public String getiD() {
	  return iD;
	 }
	 public void setiD(String id) {
	  this.iD = id;
	 }
	 public String getDescripcion() {
	  return descripcion;
	 }
	 public void setDescripcion(String descripcion) {
	  this.descripcion = descripcion;
	 }
	 public String getPrecio() {
	  return precio;
	 }
	 public void setPrecio(String precio) {
	  this.precio = precio;
	 }
	 public String getCantidad() {
	  return cantidad;
	 }
	 public void setCantidad(String cantidad) {
	  this.cantidad = cantidad;
	 }
	 public String getIva() {
	  return iVA;
	 }
	 public void setIva(String iva) {
	  this.iVA = iva;
	 }
	 public String getCaducidad() {
	  return fechaCaducicad;
	 }
	 public void setCaducidad(String caducidad) {
	  this.fechaCaducicad = caducidad;
	 }
	 
	}