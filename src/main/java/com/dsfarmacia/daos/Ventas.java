package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;
import com.dsfarmacia.db.IConexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ventas {
  private IConexion conexion;
  private Statement stmt;
  private ResultSet result;
  
  public Ventas() {
    setConexion(new Conexion());
  }

  /**.
  * @param filter data
  * @param orderby data
  * @param input data
  * @return resultset
  */
  public ResultSet connect(int filter,int orderby, String input) {
    String sql = "SELECT * FROM Ticket as t,  TicketDetalle as tp,"
        + "Producto as p where t.IDTicket=tp.IDTicket and "
        + "p.IDProducto=tp.IDProducto and ";
    switch (filter) {
      case 1:
        sql = sql + "t.User ='" + input + "'";
        break;
      case 2:
        sql = sql + "p.Descripcion ='" + input + "'";
        break;
      default:
        sql = sql + "";
        break;
    }
    switch (orderby) {
      case 1:
        sql = sql + " Order by Cantidad";
        break;
      case 2:
        sql = sql + " Order by Precio";
        break;
      case 3:
        sql = sql + " Order by User";
        break;
      default:
        sql = sql + "";
        break;
    }

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

  public ResultSet getRs() {
    return result;
  }

  public void setRs(ResultSet rs) {
    this.result = rs;
  }

  public void closeconection() throws SQLException {
    conexion.closeCon();
  }

}
