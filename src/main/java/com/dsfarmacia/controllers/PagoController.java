package com.dsfarmacia.controllers;

import java.util.List;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.beans.BeanPago;
import com.dsfarmacia.daos.CategoriaDao;
import com.dsfarmacia.daos.Pago;
import com.dsfarmacia.daos.PagoDao;

public class PagoController {
	
	private static PagoController ctrl;
	
	 public List<BeanPago> getList() { // El metodo recibe el bean del metodo GET
		    Pago dao = new PagoDao(); //Se instancia el dao//Se instancia el dao
		    return dao.get(); // Se retorna una lista con todos los productos de la BD
		  }
	 
	  /**.
	  * @return PagoController
	  */
	  public static PagoController getController() { //Metodo que envia el 
	    //controlador al servicio REST
	    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
	      ctrl = new PagoController();
	    }
	    return ctrl;
	  }

}
