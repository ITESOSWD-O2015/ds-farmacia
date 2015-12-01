package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanFactura;


public interface Factura {
		
	public BeanFactura get();
	public BeanFactura save(BeanFactura b);
	void close();
}
