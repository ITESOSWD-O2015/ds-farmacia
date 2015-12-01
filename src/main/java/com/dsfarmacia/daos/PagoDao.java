package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.beans.BeanPago;
import com.dsfarmacia.db.Conexion;

public class PagoDao implements Pago {
	
	  private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;
	  
	  public List<BeanPago> get() {

		    List<BeanPago> list = new ArrayList<BeanPago>();
		    try {
		      // Setup the connection with the DB
		      connect = Conexion.getConnection();

		      // Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      // Result set get the result of the SQL query
		      resultSet = statement.executeQuery("select * from dbo.Pago");

		      while (resultSet.next()) {
		    	BeanPago bean = new BeanPago();
		    	bean.setPagoId(resultSet.getInt(1));
		    	bean.setPagoNombre(resultSet.getString(2));
		       
		        list.add(bean);
		      }
		      System.out.println(list);
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      close();
		    }
		    return list;
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
