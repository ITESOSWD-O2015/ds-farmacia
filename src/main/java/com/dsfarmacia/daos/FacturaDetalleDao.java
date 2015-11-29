package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dsfarmacia.beans.BeanFacturaDetalle;
import com.dsfarmacia.db.Conexion;

public class FacturaDetalleDao {
	 private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;
	  
	  public BeanFacturaDetalle save(BeanFacturaDetalle bean) {
		    PreparedStatement ps;
		    
		    
		    
		    System.out.println(bean.toString());
		    try {
		      String sql = " insert into dbo.TicketDetalle values (?,?,?,?,?);";
		      // Setup the connection with the DB
		      connect = Conexion.getConnection();

		      // Statements allow to issue SQL queries to the database
		      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		      
		     		      
		      ps.setInt(1, bean.getTicketId());
		      ps.setInt(2, bean.getProductId());
		      ps.setDouble(3, bean.getPrecioventa());
		      ps.setInt(4, bean.getCantidad());
		      ps.setDouble(5, bean.getTotal());
		 
		      // Result set get the result of the SQL query
		      ps.execute();

		      ResultSet rs = ps.getGeneratedKeys();
		      int generatedKey = 0;
		      if (rs.next()) {
		        generatedKey = rs.getInt(1);
		      }
		      bean.setTicketId_d(generatedKey);
		      return bean;

		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      close();
		    }
		    return null;
		  }
	  
		  // You need to close the resultSet
		  private void close() {
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
