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
  private String iduser;
  
  public String getactive() {
    return active;
  }
  public String getiduser() {
	    return iduser;
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
    category="";
    active="";
    String sql = "SELECT * FROM Empleado where [User] = '"
        + this.username + "' and password= '" + this.password + "'";
    try {
      setStmt(getConexion().getCon().createStatement());
      result = getStmt().executeQuery(sql);
      boolean val = result.next();
      if (!val) {
        return "Wrong username/password ";
      }
      
    //  result.next();
      iduser= result.getString(result.findColumn("ID"));
      category = result.getString(result.findColumn("Category"));
      active = result.getString(result.findColumn("password"));
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
