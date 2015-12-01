package com.dsfarmacia.controllers;

import com.dsfarmacia.beans.BeanReceta;

import com.dsfarmacia.daos.RecetaDao;

public class RecetaController {
	
	  private static RecetaController ctrl;
	  
	  public static BeanReceta save(BeanReceta bean) { // El metodo recibe el bean del metodo POST
		    RecetaDao dao = new RecetaDao(); //Se instancia el dao
		    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
		  }
	  
	  public static RecetaController getController() {   
		    //Metodo que envia el controlador al servicio REST
		    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
		      ctrl = new RecetaController();
		    }
		    return ctrl;
		  }
	
	

}
