package com.dsfarmacia.controllers;

import com.dsfarmacia.beans.BeanUnidadMedida;
import com.dsfarmacia.daos.UnidadMedidaDao;

import java.util.List;

public class UnidadMedidaController {
  private static UnidadMedidaController ctrl;
  //En caso se quiera agregar un producto, el controlador manda a llamar el dao de guardar.
  /**.
  * @param bean unidad medida
  * @return save
  */
  public static BeanUnidadMedida save(BeanUnidadMedida bean) { 
    // El metodo recibe el bean del metodo POST
    UnidadMedidaDao dao = new UnidadMedidaDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }
  
  /**.
  * @param bean update
  * @return update
  */
  public BeanUnidadMedida update(BeanUnidadMedida bean) {
    // El metodo recibe el bean del metodo PUT
    UnidadMedidaDao dao = new UnidadMedidaDao(); //Se instancia el dao//Se instancia el dao
    return dao.update(bean); 
    // Se le envia el bean al metodo de update para actualizar los datos en la BD
  }
  
  public List<BeanUnidadMedida> getList() { // El metodo recibe el bean del metodo GET
    UnidadMedidaDao dao = new UnidadMedidaDao(); //Se instancia el dao//Se instancia el dao
    return dao.get(); // Se retorna una lista con todos los productos de la BD
  }

  public boolean delete(String id) {  // El metodo recibe el bean del metodo GET
    UnidadMedidaDao dao = new UnidadMedidaDao(); //Se instancia el dao//Se instancia el dao
    return dao.delete(id); //Se le envia el id del producto a eliminar al DAO.
  }
  
  /**.
  * @return controller
  */
  public static UnidadMedidaController getController() { 
    //Metodo que envia el controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new UnidadMedidaController();
    }
    return ctrl;
  }
}
