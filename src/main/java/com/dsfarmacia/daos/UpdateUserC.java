package com.dsfarmacia.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dsfarmacia.db.IConexion;

public class UpdateUserC implements UpdateUser {
	
	private Statement stmt;
	private IConexion conexion;
	private ResultSet result;

	public boolean updateactivation(int id, int active) {
		String sql = "UPDATE  Empleado set Active ='" + active + "' where [User] = '" + id + "'";
		try {
			setStmt(getConexion().getCon().createStatement());
			setRs(getStmt().executeQuery(sql));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}

	public ResultSet GetUsers() {
		String sql = "Select * from Empleado";

		try {
			setStmt(getConexion().getCon().createStatement());
			setRs(getStmt().executeQuery(sql));
			setStmt(getConexion().getCon().createStatement());
			// System.out.println(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean updateCategory(int id, int Category) {
		String sql = "UPDATE  Empleado set Category ='" + Category + "' where [User] = '" + id + "'";
		try {
			setStmt(getConexion().getCon().createStatement());
			setRs(getStmt().executeQuery(sql));
			// System.out.println(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
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

}
