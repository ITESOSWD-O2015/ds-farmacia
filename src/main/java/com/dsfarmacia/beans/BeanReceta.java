package com.dsfarmacia.beans;

public class BeanReceta {
	
	private int recetaId;
	private int cedulaProfesional;
	private String nombreDoctor;
	private String fecha;
	private int productId;
	private String sproduct;
	
	public int getRecetaId() {
		return recetaId;
	}
	public void setRecetaId(int recetaId) {
		this.recetaId = recetaId;
	}
	public int getCedulaProfesional() {
		return cedulaProfesional;
	}
	public void setCedulaProfesional(int cedulaProfesional) {
		this.cedulaProfesional = cedulaProfesional;
	}
	public String getNombreDoctor() {
		return nombreDoctor;
	}
	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "BeanReceta [recetaId=" + recetaId + ", cedulaProfesional=" + cedulaProfesional + ", nombreDoctor="
				+ nombreDoctor + ", fecha=" + fecha + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getSproduct() {
		return sproduct;
	}
	public void setSproduct(String sproduct) {
		this.sproduct = sproduct;
	}
	


}
