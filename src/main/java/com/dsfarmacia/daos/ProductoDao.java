package com.dsfarmacia.daos;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.db.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProductoDao implements Producto {
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  
  /**.
  * @param id data
  * @return delete success
  */
  public boolean delete(String id) {
    PreparedStatement ps;
    try {
      String sql = "DELETE FROM dbo.Producto WHERE IDProducto = ?";
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
  * @param bean data
  * @return data
  */
  public BeanProducto update(BeanProducto bean) {
    PreparedStatement ps;
    try {
      String sql = "UPDATE dbo.Producto SET Descripcion = ?, PrecioVenta= ?, PrecioUnitario = ?,"
          + " IVA = ?, Existencia = ?, " + "FechaCaducidad = ?,  IDProveedor = "
          + "(select p.IDProveedor from  dbo.Proveedor p where ? = p.Nombre ), "
          + "IDCategoria= (select c.IDCategoria from  dbo.Categoria c where ? = c.Nombre ), "
          + "IDUnidadMedida= (select m.IDUnidadMedida from  dbo.UnidadMedida m where ? "
          + "= m.Nombre ) Where IDProducto = ?";
      // Setup the connection with the DB
      connect = Conexion.getConnection();
      // Statements allow to issue SQL queries to the database
      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, bean.getProductoNombre());
      ps.setDouble(2, bean.getPrecioVenta());
      ps.setDouble(3, bean.getPrecioUnitario());
      ps.setDouble(4, bean.getIva());
      ps.setInt(5, bean.getCantidad());
      ps.setString(6, bean.getFechaCaducicad());
      ps.setString(7, bean.getProveedorNombre());
      ps.setString(8, bean.getCategoriaNombre());
      ps.setString(9, bean.getUnidadmedidaNombre());
      ps.setInt(10, bean.getProductId());
      // Result set get the result of the SQL query
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
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
  * @return result set
  */
  public List<BeanProducto> get() {
    List<BeanProducto> list = new ArrayList<BeanProducto>();
    try {
      // Setup the connection with the DB
      connect = Conexion.getConnection();
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement.executeQuery("select p.IDProducto, "
      + "p.Descripcion, p.PrecioVenta, p.PrecioUnitario,"
      + " p.IVA, p.Existencia, p.FechaCaducidad, pr.Nombre, c.Nombre, u.Nombre from Producto p,"
      + " Proveedor pr, UnidadMedida u, Categoria c where p.IDProveedor ="
      + " pr.IDProveedor AND p.IDCategoria = c.IDCategoria "
      + "AND p.IDUnidadMedida = u.IDUnidadMedida");
      while (resultSet.next()) {
        BeanProducto bean = new BeanProducto();
        bean.setProductId(resultSet.getInt(1));
        bean.setProductoNombre(resultSet.getString(2));
        bean.setPrecioVenta(resultSet.getDouble(3));
        bean.setPrecioUnitario(resultSet.getDouble(4));
        bean.setIva(resultSet.getDouble(5));
        bean.setCantidad(resultSet.getInt(6));
        bean.setFechaCaducicad(resultSet.getString(7));
        bean.setProveedorNombre(resultSet.getString(8));
        bean.setCategoriaNombre(resultSet.getString(9));
        bean.setUnidadmedidaNombre(resultSet.getString(10));
        list.add(bean);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    return list;
  }
  /**.
  * @param bean bean 
  * @return data
  */
  public BeanProducto save(BeanProducto bean) {
    PreparedStatement ps;
    try {
      String sql = "insert into dbo.Producto values (?, ?, ?, ?, ?, ?, "
          + "(select p.IDProveedor from  dbo.Proveedor p where ? = p.Nombre ),"
          + " (select c.IDCategoria from  dbo.Categoria c where ? = c.Nombre ), "
          + "(select m.IDUnidadMedida from  dbo.UnidadMedida m where ? = m.Nombre ))";
      // Setup the connection with the DB
      connect = Conexion.getConnection();

      // Statements allow to issue SQL queries to the database
      ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, bean.getProductoNombre());
      ps.setDouble(2, bean.getPrecioVenta());
      ps.setDouble(3, bean.getPrecioUnitario());
      ps.setDouble(4, bean.getIva());
      ps.setInt(5, bean.getCantidad());
      ps.setString(6, bean.getFechaCaducicad());
      ps.setString(7, bean.getProveedorNombre());
      ps.setString(8, bean.getCategoriaNombre());
      ps.setString(9, bean.getUnidadmedidaNombre());
      // Result set get the result of the SQL query
      ps.execute();
      ResultSet rs = ps.getGeneratedKeys();
      int generatedKey = 0;
      if (rs.next()) {
        generatedKey = rs.getInt(1);
      }
      bean.setProductId(generatedKey);
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
