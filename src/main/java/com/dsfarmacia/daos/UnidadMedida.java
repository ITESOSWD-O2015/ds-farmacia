package com.dsfarmacia.daos;

import java.util.List;

import com.dsfarmacia.beans.BeanUnidadMedida;

public interface UnidadMedida {
	
	public boolean delete(String id);
	public BeanUnidadMedida update(BeanUnidadMedida bean);
	public List<BeanUnidadMedida> get();
	public BeanUnidadMedida save(BeanUnidadMedida bean);
	void close();

}
