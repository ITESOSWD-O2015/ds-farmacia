package com.dsfarmacia.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.dsfarmacia.db.*;

public class Ventas {
	private IConexion Conexion;
	private Statement stmt;
	private ResultSet rs;
	public Ventas() {
		setConexion(new Conexion());
	}

	public ResultSet Connect(int filter,int orderby, String input) {
		String SQL = "SELECT * FROM Ticket as t,  TicketProducto as tp,Producto as p,Empleado as e where t.IDTicket=tp.IDProducto and t.IDEmpleado=e.IDEmpleado and  p.IDProducto=tp.IDProducto and ";
		switch (filter) {
		case 1:
			SQL=SQL+"e.Nombre ='"+input+"'";
			break;
		case 2:
			SQL=SQL+"p.Descripcion ='"+input+"'";
			break;
		}
		switch (orderby) {
		case 1:
			SQL=SQL+" Order by Cantidad";
			break;
		case 2:
			SQL=SQL+" Order by Precio";
			break;
		case 3:
			SQL=SQL+" Order by Nombre";
			break;
		}

		try {
			setStmt(getConexion().getCon().createStatement());
			setRs(getStmt().executeQuery(SQL));

		

			// System.out.println(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public IConexion getConexion() {
		return Conexion;
	}

	public void setConexion(IConexion conexion) {
		Conexion = conexion;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void CloseConection() throws SQLException {
		Conexion.closeCon();
	}

}
