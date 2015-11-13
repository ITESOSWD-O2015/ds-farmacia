package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.db.Conexion;

public class AgregarProducto {
	
	
	 public static boolean agregarProducto(BeanProducto usuario){
		 
	  boolean agregado=false;
	  
	  try {
	   Conexion c = new Conexion();
	   c.crearConexion();
	   Connection con= c.getConexioN(); 
	   
	   if(con!=null){
	    Statement st;
	    st = con.createStatement();
	    st.executeUpdate("INSERT INTO Producto VALUES ('"+usuario.getiD()+"','"+usuario.getDescripcion()+"',"+usuario.getPrecio()+",'"+usuario.getCantidad()+"','"+usuario.getIva()+"','"+usuario.getCaducidad()+"')");
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