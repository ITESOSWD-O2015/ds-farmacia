package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;
import com.dsfarmacia.db.IConexion;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;




public class Logout {
  private IConexion conexion;
  private Statement stmt;
  
  public Logout() {
    setConexion(new Conexion());
  }
  /**.
  * @param user username
  * @param date last date
  * @return true if connected
  */
  public boolean connect(String user, String date) {
    String sql = "INSERT INTO [FarmaciaWeb].[dbo].[Log]  Values('"
        + user + "','" + date + "'" + ",'" + getCurrentDate() + "');";
    boolean salida = true;
    try {
      setStmt(getConexion().getCon().createStatement());
      salida = getStmt().execute(sql);
      closecon();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return salida;

  }
  
  public String getCurrentDate() {
    return new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
  }
  
  public IConexion getConexion() {
    return conexion;
  }
  
  public void setConexion(IConexion conexion) {
    this.conexion = conexion;
  }
  
  public Statement getStmt() {
    return stmt;
  }
  
  public void setStmt(Statement stmt) {
    this.stmt = stmt;
  }
  
  public  void closecon() throws SQLException {
    conexion.closeCon();
  }
}
