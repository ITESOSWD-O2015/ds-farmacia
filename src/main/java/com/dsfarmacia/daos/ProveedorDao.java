package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dsfarmacia.beans.BeanProveedor;
import com.dsfarmacia.db.Conexion;

public class ProveedorDao {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public boolean delete(String id){
		PreparedStatement ps;
		try {
			String sql = "DELETE FROM dbo.Proveedor WHERE IDProveedor = ?";
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, Integer.parseInt(id));
			// Result set get the result of the SQL query
			return ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	

	public BeanProveedor update(BeanProveedor bean){
		PreparedStatement ps;
		try {
			String sql = "UPDATE dbo.Proveedor SET Nombre = ? Where IDProveedor = ?";
			
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, bean.getProveedornombre());
			ps.setInt(2, bean.getProveedorId());
			// Result set get the result of the SQL query
			
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			
			@SuppressWarnings("unused")
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			//bean.setId(generatedKey);
			return bean;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bean;
	}
	
	
	public List<BeanProveedor> get() {
		
		List<BeanProveedor> list = new ArrayList<BeanProveedor>();
		
		try {
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from dbo.Proveedor");
			
			while (resultSet.next()) {
				BeanProveedor b = new BeanProveedor();
				b.setProveedorId(resultSet.getInt(1));
				b.setProveedornombre(resultSet.getString(2));
														
				list.add(b);
				
			}
			
			System.out.println(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public BeanProveedor save(BeanProveedor bean){
		PreparedStatement ps;
		
		try {
			String sql = "insert into dbo.Proveedor values (?)";
			
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, bean.getProveedornombre());
			

			
			// Result set get the result of the SQL query
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			bean.setProveedorId(generatedKey);
			return bean;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}
	
	
	
	// You need to close the resultSet
		private void close() {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {

			}
		}

}
