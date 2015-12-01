package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.dsfarmacia.beans.BeanReceta;
import com.dsfarmacia.db.Conexion;

public class RecetaDao implements Receta{
	
	 private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;
	  
	  public BeanReceta save(BeanReceta bean) {
		    PreparedStatement ps;
		    try {
		      String sql = "insert into dbo.Receta values (?,(SELECT CONVERT(date, getdate())), (select p.IDProducto from dbo.Producto  p where p.Descripcion = ?), ?)";
		      // Setup the connection with the DB
		      connect = Conexion.getConnection();

		      // Statements allow to issue SQL queries to the database
		      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		      
		      ps.setInt(1, bean.getCedulaProfesional());
		      ps.setString(2, bean.getSproduct());
		      ps.setString(3, bean.getNombreDoctor());
		     
		           // Result set get the result of the SQL query
		      ps.execute();

		      ResultSet rs = ps.getGeneratedKeys();
		      int generatedKey = 0;
		      if (rs.next()) {
		        generatedKey = rs.getInt(1);
		      }
		      bean.setRecetaId(generatedKey);
		      return bean;

		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      close();
		    }
		    return null;
		  }
		  // You need to close the resultSet
		  public void close() {
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }
		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }


}
