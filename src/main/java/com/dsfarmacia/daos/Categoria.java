package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanCategoria;


public interface Categoria {

	public boolean delete(String t);
	public BeanCategoria update(BeanCategoria b);
	public List<BeanCategoria> get();
	public BeanCategoria save(BeanCategoria b);
	void close();
	
}
