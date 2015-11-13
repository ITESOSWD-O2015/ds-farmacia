package com.dsfarmacia.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexion {

	public boolean crearConexion();
	public boolean cerrarConexion();
	public void crearConexion2();
	
	public void setCon(Connection con);
	public Connection getCon();
	public void closeCon() throws SQLException;
	
}
