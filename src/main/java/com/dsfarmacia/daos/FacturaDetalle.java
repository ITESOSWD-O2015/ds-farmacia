package com.dsfarmacia.daos;

import com.dsfarmacia.beans.BeanFactura;
import com.dsfarmacia.beans.BeanFacturaDetalle;

public interface FacturaDetalle {
	
	public BeanFacturaDetalle save(BeanFacturaDetalle b);
	void close();

}
