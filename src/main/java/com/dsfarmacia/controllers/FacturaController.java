package com.dsfarmacia.controllers;

import java.util.List;

import com.dsfarmacia.beans.BeanFactura;

import com.dsfarmacia.daos.FacturaDao;

public class FacturaController {
	
private static FacturaController ctrl;

public static BeanFactura save(BeanFactura bean) { // El metodo recibe el bean del metodo POST
    FacturaDao dao = new FacturaDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }

public BeanFactura getList() { // El metodo recibe el bean del metodo GET
	FacturaDao dao = new FacturaDao(); //Se instancia el dao//Se instancia el dao
    return dao.get(); // Se retorna una lista con todos los productos de la BD
  }
  
public static FacturaController getController() { //Metodo que envia el 
    //controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new FacturaController();
    }
    return ctrl;
  }
	  
	  
}
