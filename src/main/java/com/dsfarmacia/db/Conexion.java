package com.dsfarmacia.db;

import java.sql.*;

public class Conexion implements IConexion {

	private Connection con = null;
	
	
	public static Connection getConnection(){
		try {
		      // This will load the MySQL driver, each DB has its own driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ChoriStore;user=sa;password=sa;");//if there is a password it should place it here.
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
		public Connection getConexion(){
			return getCon();
		}
		
		public void crearConexion2() {
			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaWeb;user=sa;password=sa;";
	            setCon(DriverManager.getConnection(url));		
	            } catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getCon() {
			crearConexion2();
			return con;
		}

		public void setCon(Connection con) {
			this.con = con;
		}
		public void closeCon() throws SQLException {
			con.close();
		}
	
		//Mis metodos
	
	public Connection getConexioN(){
		return con;
	}
	
	@Override
	public boolean cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean crearConexion() {
			try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaWeb;user=sa;password=sa;";
            con= DriverManager.getConnection(url);		
            } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			
			return true;
	}
}