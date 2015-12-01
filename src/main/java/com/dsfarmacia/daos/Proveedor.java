package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanProveedor;

public interface Proveedor {
		
	public boolean delete(String id);
	public BeanProveedor update(BeanProveedor bean);
	public List<BeanProveedor> get();
	public BeanProveedor save(BeanProveedor bean);
	void close();
}
