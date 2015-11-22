package com.dsfarmacia.beans;

public class BeanCategoria {
	
	private int categoriaId;
	private String categorianombre;
	
	
	public int getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	
	public String getCategorianombre() {
		return categorianombre;
	}
	public void setCategorianombre(String categorianombre) {
		this.categorianombre = categorianombre;
	}
	@Override
	public String toString() {
		return "BeanCategoria [categoriaId=" + categoriaId + ", categorianombre=" + categorianombre + "]";
	}
	
	

}
