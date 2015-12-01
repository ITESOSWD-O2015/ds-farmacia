package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanPago;

public interface Pago {
		
	public List<BeanPago> get();
	void close();
}
