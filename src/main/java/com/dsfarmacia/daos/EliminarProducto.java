package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.dsfarmacia.db.Conexion;

public class EliminarProducto {
	
	
	 public static boolean eliminarProducto(String id){
	  
	  int id2= Integer.parseInt(id);
	  boolean agregado=false;
	  
	  try {
	   Conexion c = new Conexion();
	   c.crearConexion();
	   Connection con= c.getConexioN(); 
	   
	   if(con!=null){
	    Statement st;
	    String sql;
	    st = con.createStatement();
	    sql ="delete from dbo.Producto where IDProducto =" +id2+ "";
	    System.out.println(sql);
	    st.executeUpdate(sql);
	    agregado=true;
	    st.close();
	   }
	   c.cerrarConexion();
	  } catch (SQLException e) {
		  
	   agregado=false;
	   e.printStackTrace();
	  }
	  return agregado;
	  
	 }
	 
	 
}