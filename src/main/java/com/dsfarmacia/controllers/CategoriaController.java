package com.dsfarmacia.controllers;

import java.util.List;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.daos.CategoriaDao;


public class CategoriaController {
	
	private static CategoriaController ctrl;
	
	//En caso se quiera agregar un producto, el controlador manda a llamar el dao de guardar.
	public static BeanCategoria save(BeanCategoria bean){ // El metodo recibe el bean del metodo POST
		CategoriaDao dao = new CategoriaDao(); //Se instancia el dao
		return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
	}
	
	public BeanCategoria update(BeanCategoria bean){ // El metodo recibe el bean del metodo PUT
		CategoriaDao dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
		return dao.update(bean); // Se le envia el bean al metodo de update para actualizar los datos en la BD
	}
	
	public List<BeanCategoria> getList(){ // El metodo recibe el bean del metodo GET
		CategoriaDao dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
		return dao.get(); // Se retorna una lista con todos los productos de la BD
	}
	
	public boolean delete(String id){  // El metodo recibe el bean del metodo GET
		CategoriaDao dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
		return dao.delete(id); //Se le envia el id del producto a eliminar al DAO.
	}
	
	public static CategoriaController getController(){ //Metodo que envia el controlador al servicio REST
		if(ctrl==null){ //En caso de que no exista el controlador, se instancia.
			ctrl = new CategoriaController();
		}
		return ctrl;
	}


}
