package com.dsfarmacia.controllers;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.daos.ProductoDao;

import java.util.List;

public class ProductController {
  private static ProductController ctrl;
  //En caso se quiera agregar un producto, el controlador manda a llamar el dao de guardar.
  /**.
  * @param bean bean
  * @return producto
  */
  public static BeanProducto saveProduct(BeanProducto bean) {   
    // El metodo recibe el bean del metodo POST
    ProductoDao dao = new ProductoDao(); //Se instancia el dao
    return dao.save(bean); // Se le envia el bean al metodo de save para guardar los datos en la BD
  }
  
  /**.
  * @param bean bean 
  * @return producto
  */
  public BeanProducto updateProduct(BeanProducto bean) {
    // El metodo recibe el bean del metodo PUT
    ProductoDao dao = new ProductoDao(); //Se instancia el dao//Se instancia el dao
    return dao.update(bean); 
    // Se le envia el bean al metodo de update para actualizar los datos en la BD
  }
  
  /**.
  * @return product list
  */
  public List<BeanProducto> getList() {
    // El metodo recibe el bean del metodo GET
    ProductoDao dao = new ProductoDao(); //Se instancia el dao//Se instancia el dao
    return dao.get(); // Se retorna una lista con todos los productos de la BD
  }
  
  /**.
  * @param id id prod
  * @return success
  */
  public boolean delete(String id) {  
    // El metodo recibe el bean del metodo GET
    ProductoDao dao = new ProductoDao(); //Se instancia el dao//Se instancia el dao
    return dao.delete(id); //Se le envia el id del producto a eliminar al DAO.
  
  }
  /**.
  * @return product
  */
  public static ProductController getController() {
    //Metodo que envia el controlador al servicio REST
    if (ctrl == null) { //En caso de que no exista el controlador, se instancia.
      ctrl = new ProductController();
    }
    return ctrl;
  }

}
