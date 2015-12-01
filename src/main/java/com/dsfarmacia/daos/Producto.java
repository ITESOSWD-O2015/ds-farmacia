package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanProducto;

public interface Producto {

	public boolean delete(String t);
	public BeanProducto update(BeanProducto b);
	public List<BeanProducto> get();
	public BeanProducto save(BeanProducto b);
	void close();
	
	
}
