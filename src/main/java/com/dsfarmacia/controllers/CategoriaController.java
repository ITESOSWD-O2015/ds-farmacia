package com.dsfarmacia.controllers;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.daos.Categoria;
import com.dsfarmacia.daos.CategoriaDao;

import java.util.List;

public class CategoriaController {

  private static CategoriaController ctrl;
  //En caso se quiera agregar un producto, el controlador manda a llamar el dao de guardar.
  public static BeanCategoria save(BeanCategoria bean) { // El metodo recibe el bean del metodo POST
    Categoria dao = new CategoriaDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }
  
  /**.
  * @param bean get data 
  * @return BeanCategoria
  */
  public BeanCategoria update(BeanCategoria bean) { // El metodo recibe el bean del metodo PUT
    Categoria dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
    return dao.update(bean); // Se le envia el bean al metodo de update 
    //para actualizar los datos en la BD
  }
  
  public List<BeanCategoria> getList() { // El metodo recibe el bean del metodo GET
    Categoria dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
    return dao.get(); // Se retorna una lista con todos los productos de la BD
  }
  
  public boolean delete(String id) {  // El metodo recibe el bean del metodo GET
    Categoria dao = new CategoriaDao(); //Se instancia el dao//Se instancia el dao
    return dao.delete(id); //Se le envia el id del producto a eliminar al DAO.
  }
  
  /**.
  * @return CategoriaController
  */
  public static CategoriaController getController() { //Metodo que envia el 
    //controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new CategoriaController();
    }
    return ctrl;
  }
}
