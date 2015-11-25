package com.dsfarmacia.beans;

public class BeanProducto {
	 
	 private int productId;
	 private String productonombre;
	 private double preciounitario;
	 private double precioventa;
	 private int cantidad;
	 private double iva;
	 private String fechacaducidad;
	 private String proveedornombre;
	 private int proveedor;
	 private String categorianombre;
	 private int categoria;
	 private String unidadmedidanombre;
	 private int unidadmedida;
	 
	 
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductoNombre() {
		return productonombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productonombre = productoNombre;
	}
	public double getPrecioUnitario() {
		return preciounitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.preciounitario = precioUnitario;
	}
	public double getPrecioVenta() {
		return precioventa;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioventa = precioVenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public String getFechaCaducicad() {
		return fechacaducidad;
	}
	public void setFechaCaducicad(String fechaCaducicad) {
		this.fechacaducidad = fechaCaducicad;
	}
	public String getProveedorNombre() {
		return proveedornombre;
	}
	public void setProveedorNombre(String proveedorNombre) {
		this.proveedornombre = proveedorNombre;
	}
	public int getProveedor() {
		return proveedor;
	}
	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	public String getCategoriaNombre() {
		return categorianombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		this.categorianombre = categoriaNombre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getUnidadmedidaNombre() {
		return unidadmedidanombre;
	}
	public void setUnidadmedidaNombre(String unidadmedidaNombre) {
		this.unidadmedidanombre = unidadmedidaNombre;
	}
	public int getUnidadmedida() {
		return unidadmedida;
	}
	public void setUnidadmedida(int unidadmedida) {
		this.unidadmedida = unidadmedida;
	}
	
	@Override
	public String toString() {
		return "BeanProducto [productId=" + productId + ", productoNombre=" + productonombre + ", precioUnitario="
				+ preciounitario + ", precioVenta=" + precioventa + ", cantidad=" + cantidad + ", iva=" + iva
				+ ", fechaCaducicad=" + fechacaducidad + ", proveedorNombre=" + proveedornombre + ", categoriaNombre="
				+ categorianombre + ", unidadmedidaNombre=" + unidadmedidanombre + "]";
	}
	 
	 
	
	
	}