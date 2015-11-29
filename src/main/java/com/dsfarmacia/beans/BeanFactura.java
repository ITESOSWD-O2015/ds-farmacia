package com.dsfarmacia.beans;

public class BeanFactura {
	
	private int facturaId;
	private String fecha;
	private double subtotal;
	private double iva;
	private double total;
	private int pagoId;
	private String spago;
	private int cantidad;
	
	public int getFacturaId() {
		return facturaId;
	}
	public void setFacturaId(int facturaId) {
		this.facturaId = facturaId;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getPagoId() {
		return pagoId;
	}
	public void setPagoId(int pagoId) {
		this.pagoId = pagoId;
	}
	public String getSpago() {
		return spago;
	}
	public void setSpago(String spago) {
		this.spago = spago;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
