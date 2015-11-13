package com.dsfarmacia.daos;

import com.dsfarmacia.db.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class Login {
	private IConexion Conexion;
	private String username;
	private String password;
	private Statement stmt;
	private ResultSet rs;
	
	public Login(){
		setConexion(new Conexion());
	}
	
	public String Connect(String username, String password) {
		this.username = username;
		this.password = password;
		
		String SQL = "SELECT * FROM Empleado where Nombre = '"
				+ this.username + "' and Pass= '" + this.password + "'";
		
		
		
		try {
			
			
			setStmt(getConexion().getCon().createStatement());
			rs = getStmt().executeQuery(SQL);
			if (!rs.isBeforeFirst())
				return "Wrong username/password";
			rs.next();
			CloseConection();
		//	System.out.println(rs.getString(1));	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return "Connection Stablished";
	}
	
	
	public  IConexion getConexion() {
		
		return Conexion;
	}
	public  void CloseConection() throws SQLException {
		Conexion.closeCon();
	}

	public void setConexion(IConexion Conexion) {
		this.Conexion = Conexion;
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
	public String getCurrentDate(){
		return new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
	}

}
