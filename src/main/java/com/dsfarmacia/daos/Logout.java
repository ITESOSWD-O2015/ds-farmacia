package com.dsfarmacia.daos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import com.dsfarmacia.db.*;

public class Logout {
	private IConexion Conexion;
	private Statement stmt;
	public Logout(){
		setConexion(new Conexion());
	}
	public boolean connect(String user, String date){
		String SQL = "INSERT INTO [FarmaciaWeb].[dbo].[Log]  Values('"
				+ user + "','" +date + "'" + ",'" + getCurrentDate() + "');";
		boolean salida=true;
		try {
			setStmt(getConexion().getCon().createStatement());
			salida= getStmt().execute(SQL);
			CloseConection();
		//	System.out.println(rs.getString(1));	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salida;
		
	}
	public String getCurrentDate(){
		return new java.sql.Date(Calendar.getInstance().getTime().getTime()).toString();
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
	public  void CloseConection() throws SQLException {
		Conexion.closeCon();
	}
}
