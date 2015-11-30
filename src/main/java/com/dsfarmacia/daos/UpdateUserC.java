package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;
import com.dsfarmacia.db.IConexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UpdateUserC implements UpdateUser {

  private Statement stmt;
  private IConexion conexion;
  private ResultSet result;

  public UpdateUserC() {
    setConexion(new Conexion());
  }

  /**.
  * @return result salida
  */
  public boolean updateactivation(String id, String active) {
    String sql = "UPDATE  Empleado set Active ='" + active + "' where ID = '" + id + "'";
    boolean salida = false;
    try {
      setStmt(getConexion().getCon().createStatement());
      salida = getStmt().execute(sql);
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return salida;
  }

  /**.
  * @return result set
  */
  public ResultSet getusers() {
    String sql = "Select * from Empleado";
    try {
      setStmt(getConexion().getCon().createStatement());
      setRs(getStmt().executeQuery(sql));
      // System.out.println(rs.getString(1));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return result;
  }

  /**.
  * @return result salida
  */
  public boolean updatecategory(String id, String category) {
    String sql = "UPDATE  Empleado set Category ='" + category + "' where ID = '" + id + "'";
    boolean salida = false;
    try {
      setStmt(getConexion().getCon().createStatement());
      salida = getStmt().execute(sql);
    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    System.out.println(sql);
    return salida;
  }

  public IConexion getConexion() {
    return conexion;
  }

  public void closecon() throws SQLException {
    conexion.closeCon();
  }

  public void setconection(IConexion con) {
    this.conexion = con;
  }

  public Statement getStmt() {
    return stmt;
  }

  public void setStmt(Statement stmt) {
    this.stmt = stmt;
  }

  public ResultSet getRs() {
    return result;
  }

  public void setRs(ResultSet rs) {
    this.result = rs;
  }

  public void setConexion(IConexion conexion) {
    this.conexion = conexion;
  }
}
