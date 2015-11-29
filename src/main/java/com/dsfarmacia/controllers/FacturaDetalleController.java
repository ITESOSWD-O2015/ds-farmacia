package com.dsfarmacia.controllers;

import com.dsfarmacia.beans.BeanFactura;
import com.dsfarmacia.beans.BeanFacturaDetalle;
import com.dsfarmacia.daos.FacturaDao;
import com.dsfarmacia.daos.FacturaDetalleDao;

public class FacturaDetalleController {
	
	private static FacturaDetalleController ctrl;
	

public static BeanFacturaDetalle save(BeanFacturaDetalle bean) { // El metodo recibe el bean del metodo POST
    FacturaDetalleDao dao = new FacturaDetalleDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }

public static FacturaDetalleController getController() { //Metodo que envia el 
    //controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new FacturaDetalleController();
    }
    return ctrl;
  }


}
