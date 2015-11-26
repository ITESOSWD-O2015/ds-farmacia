package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class EliminarProducto {
  /**.
  * @param id id producto
  * @return data
  */
  public static boolean eliminarProducto(String id) {
    int id2 = Integer.parseInt(id);
    boolean agregado = false;
    try {
      Conexion conection = new Conexion();
      conection.crearConexion();
      Connection con = conection.getConexioN(); 
      if (con != null) {
        Statement st;
        String sql;
        st = con.createStatement();
        sql = "delete from dbo.Producto where IDProducto =" + id2 + "";
        System.out.println(sql);
        st.executeUpdate(sql);
        agregado = true;
        st.close();
      }
      conection.cerrarConexion();
    } catch (SQLException e) {
      agregado = false;
      e.printStackTrace();
    }
    return agregado;
  }  
}