package com.dsfarmacia.controllers;


import com.dsfarmacia.beans.BeanProveedor;
import com.dsfarmacia.daos.ProveedorDao;

import java.util.List;


public class ProveedorController {
  private static ProveedorController ctrl;
  //En caso se quiera agregar un producto, el controlador manda a llamar el dao de guardar.
  public static BeanProveedor save(BeanProveedor bean) { // El metodo recibe el bean del metodo POST
    ProveedorDao dao = new ProveedorDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }
  
  /**.
  * @param bean proveedor
  * @return verification
  */
  public BeanProveedor update(BeanProveedor bean) {
    // El metodo recibe el bean del metodo PUT
    ProveedorDao dao = new ProveedorDao(); //Se instancia el dao//Se instancia el dao
    return dao.update(bean); 
    // Se le envia el bean al metodo de update para actualizar los datos en la BD
  }
  
  public List<BeanProveedor> getList() { // El metodo recibe el bean del metodo GET
    ProveedorDao dao = new ProveedorDao(); //Se instancia el dao//Se instancia el dao
    return dao.get(); // Se retorna una lista con todos los productos de la BD
  }
  
  public boolean delete(String id) {  // El metodo recibe el bean del metodo GET
    ProveedorDao dao = new ProveedorDao(); //Se instancia el dao//Se instancia el dao
    return dao.delete(id); //Se le envia el id del producto a eliminar al DAO.
  }

  /**.
  * @return controller
  */
  public static ProveedorController getController() {   
    //Metodo que envia el controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new ProveedorController();
    }
    return ctrl;
  }
  
}
