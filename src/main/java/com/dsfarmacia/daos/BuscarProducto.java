package com.dsfarmacia.daos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.db.Conexion;

public class BuscarProducto {
	
	public static BeanProducto consultarProducto(String descripcion){
		BeanProducto bproducto=null;
		try{
			 Conexion c = new Conexion();
			 c.crearConexion();
			Connection con=c.getConexioN();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from dbo.Producto where descripcion ='"+descripcion+"'");
			while(rs.next()){
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				bproducto=new BeanProducto(rs.getString(1), rs.getString(2), rs.getInt(3)+"", rs.getString(4),  rs.getString(5), rs.getString(6));
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return bproducto;
	}

}
