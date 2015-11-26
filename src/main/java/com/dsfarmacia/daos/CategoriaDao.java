package com.dsfarmacia.daos;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.db.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CategoriaDao {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;

  /**.
  * @param id id item
  * @return true if categoria= cat
  */
  public boolean delete(String id) {
    PreparedStatement ps;
    try {
      String sql = "DELETE FROM dbo.Categoria WHERE IDCategoria = ?";
      // Setup the connection with the DB
      connect = Conexion.getConnection();
      // Statements allow to issue SQL queries to the database
      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      ps.setInt(1, Integer.parseInt(id));
      // Result set get the result of the SQL query
      return ps.execute();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return false;
  }


  /**.
  * @param bean update
  * @return update success
  */
  public BeanCategoria update(BeanCategoria bean) {
    PreparedStatement pses;
    try {
      String sql = "UPDATE dbo.Categoria SET Nombre = ? Where IDCategoria = ?";

      // Setup the connection with the DB
      connect = Conexion.getConnection();
      // Statements allow to issue SQL queries to the database
      pses = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      pses.setString(1, bean.getCategorianombre());
      pses.setInt(2, bean.getCategoriaId());
      // Result set get the result of the SQL query

      pses.execute();
      ResultSet rs = pses.getGeneratedKeys();

      @SuppressWarnings("unused")
      int generatedKey = 0;
      if (rs.next()) {
        generatedKey = rs.getInt(1);
      }
      //bean.setId(generatedKey);
      return bean;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return bean;
  }


  /**.
  * @return list cat
  */
  public List<BeanCategoria> get() {

    List<BeanCategoria> list = new ArrayList<BeanCategoria>();
    try {
      // Setup the connection with the DB
      connect = Conexion.getConnection();

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("select * from dbo.Categoria");

      while (resultSet.next()) {
        BeanCategoria beancat = new BeanCategoria();
        beancat.setCategoriaId(resultSet.getInt(1));
        beancat.setCategorianombre(resultSet.getString(2));
        list.add(beancat);
      }
      System.out.println(list);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return list;
  }

  /**.
  * @param bean bean
  * @return categirua
  */
  public BeanCategoria save(BeanCategoria bean) {
    PreparedStatement ps;
    try {
      String sql = "insert into dbo.Categoria values (?)";
      // Setup the connection with the DB
      connect = Conexion.getConnection();

      // Statements allow to issue SQL queries to the database
      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      ps.setString(1, bean.getCategorianombre());
      // Result set get the result of the SQL query
      ps.execute();

      ResultSet rs = ps.getGeneratedKeys();
      int generatedKey = 0;
      if (rs.next()) {
        generatedKey = rs.getInt(1);
      }
      bean.setCategoriaId(generatedKey);
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
