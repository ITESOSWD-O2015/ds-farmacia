package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;
import com.dsfarmacia.db.IConexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class Login {
  private IConexion conexion;
  private String username;
  private String password;
  private Statement stmt;
  private ResultSet result;

  public Login() {
    setconection(new Conexion());
  }

  /**.
  * @param username user
  * @param password user pass
  * @return connected or not
  */
  public String connect(String username, String password) {
    this.username = username;
    this.password = password;

    String sql = "SELECT * FROM Empleado where Nombre = '"
        + this.username + "' and Pass= '" + this.password + "'";
    try {
      setStmt(getConexion().getCon().createStatement());
      result = getStmt().executeQuery(sql);
      if (!result.isBeforeFirst()) {
        return "Wrong username/password";
      }
      result.next();
      closecon();
      //System.out.println(rs.getString(1));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return "Connection Stablished";
  }

  public  IConexion getConexion() {
    return conexion;
  }
  
  public  void closecon() throws SQLException {
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
  
  public String getCurrentDate() {
    return new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
  }

}
