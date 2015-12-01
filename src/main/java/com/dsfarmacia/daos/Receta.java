package com.dsfarmacia.daos;

import com.dsfarmacia.beans.BeanReceta;

public interface Receta {
	  public BeanReceta save(BeanReceta bean) ;
	  void close();

}
