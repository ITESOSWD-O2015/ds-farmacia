package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dsfarmacia.beans.BeanFactura;
import com.dsfarmacia.db.Conexion;

public class FacturaDao {
	
	 private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;

	  /**.
	  * @return list cat
	  */
	  public BeanFactura get() {

		  BeanFactura bean = new BeanFactura();
	    try {
	      // Setup the connection with the DB
	      connect = Conexion.getConnection();

	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // Result set get the result of the SQL query
	      resultSet = statement.executeQuery("select TOP 1 * from dbo.Ticket ORDER BY IDTicket DESC");
	      	
	      while (resultSet.next()) {
	      	System.out.println("EL ID del ticket es"+ resultSet.getInt(1));
	        bean.setFacturaId(resultSet.getInt(1));
	        bean.setFecha(resultSet.getString(2));
	        bean.setIva(resultSet.getDouble(3));
	        bean.setPagoId(resultSet.getInt(4));
	        bean.setSubtotal(resultSet.getDouble(5));
	        bean.setTotal(resultSet.getDouble(6));
	      }
	      
	      System.out.println(bean);
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      close();
	    }
	    return bean;
	  }

	  /**.
	  * @param bean bean
	  * @return categirua
	  */
	  public BeanFactura save(BeanFactura bean) {
	    PreparedStatement ps;
	    try {
	      String sql = "insert into dbo.Ticket values ((SELECT CONVERT(date, getdate())), ?, ?, ?, "
	      		+ "(select p.IDPago from  dbo.Pago p where ? = p.TipoPago ))";
	      // Setup the connection with the DB
	      connect = Conexion.getConnection();

	      // Statements allow to issue SQL queries to the database
	      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

	      ps.setDouble(1, bean.getSubtotal());
	      ps.setDouble(2, bean.getIva());
	      ps.setDouble(3, bean.getTotal());
	      ps.setString(4, bean.getSpago());
	      // Result set get the result of the SQL query
	      ps.execute();

	      ResultSet rs = ps.getGeneratedKeys();
	      int generatedKey = 0;
	      if (rs.next()) {
	        generatedKey = rs.getInt(1);
	      }
	      bean.setFacturaId(generatedKey);
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
