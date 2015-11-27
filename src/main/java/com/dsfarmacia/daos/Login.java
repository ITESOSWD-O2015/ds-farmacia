package com.dsfarmacia.daos;

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
  private String category;
  private String active;
  
  public String getactive() {
    return active;
  }
  
  public String getcategory() {
    return category;
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
      category = result.getString(5);
      active = result.getString(6);
      closecon();
      //System.out.println(rs.getString(1));
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (active.contains("0")) {
      return "User not active ";
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
