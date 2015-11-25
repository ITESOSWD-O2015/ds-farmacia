package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dsfarmacia.*;
import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.db.Conexion;

public class ProductoDao {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public boolean delete(String id){
		PreparedStatement ps;
		try {
			String sql = "DELETE FROM dbo.Producto WHERE IDProducto = ?";
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
	

	public BeanProducto update(BeanProducto bean){
		PreparedStatement ps;
		try {
			String sql = "UPDATE dbo.Producto SET Descripcion = ?, PrecioVenta= ?, PrecioUnitario = ?, IVA = ?, Existencia = ?, "
					+ "FechaCaducidad = ?,  IDProveedor = (select p.IDProveedor from  dbo.Proveedor p where ? = p.Nombre ), "
					+ "IDCategoria= (select c.IDCategoria from  dbo.Categoria c where ? = c.Nombre ), "
					+ "IDUnidadMedida= (select m.IDUnidadMedida from  dbo.UnidadMedida m where ? = m.Nombre ) Where IDProducto = ?";
			
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			
			ps.setString(1, bean.getProductoNombre());
			ps.setDouble(2, bean.getPrecioVenta());
			ps.setDouble(3, bean.getPrecioUnitario());
			ps.setDouble(4, bean.getIva());
			ps.setInt(5, bean.getCantidad());
			ps.setString(6, bean.getFechaCaducicad());
			ps.setString(7, bean.getProveedorNombre());
			ps.setString(8, bean.getCategoriaNombre());
			ps.setString(9, bean.getUnidadmedidaNombre());
			ps.setInt(10, bean.getProductId());
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
	
	
	public List<BeanProducto> get() {
		
		List<BeanProducto> list = new ArrayList<BeanProducto>();
		
		try {
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select p.IDProducto, p.Descripcion, p.PrecioVenta, p.PrecioUnitario,"
					+ " p.IVA, p.Existencia, p.FechaCaducidad, pr.Nombre, c.Nombre, u.Nombre from Producto p, Proveedor pr, "
					+ "UnidadMedida u, Categoria c where p.IDProveedor = pr.IDProveedor AND p.IDCategoria = c.IDCategoria "
					+ "AND p.IDUnidadMedida = u.IDUnidadMedida");
			
			while (resultSet.next()) {
				BeanProducto b = new BeanProducto();
				b.setProductId(resultSet.getInt(1));
				b.setProductoNombre(resultSet.getString(2));
				b.setPrecioVenta(resultSet.getDouble(3));
				b.setPrecioUnitario(resultSet.getDouble(4));
				b.setIva(resultSet.getDouble(5));
				b.setCantidad(resultSet.getInt(6));
				b.setFechaCaducicad(resultSet.getString(7));
				b.setProveedorNombre(resultSet.getString(8));
				b.setCategoriaNombre(resultSet.getString(9));
				b.setUnidadmedidaNombre(resultSet.getString(10));
				
				list.add(b);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	
	public BeanProducto save(BeanProducto bean){
		PreparedStatement ps;
		
		try {
			String sql = "insert into dbo.Producto values (?, ?, ?, ?, ?, ?, "
					+ "(select p.IDProveedor from  dbo.Proveedor p where ? = p.Nombre ),"
					+ " (select c.IDCategoria from  dbo.Categoria c where ? = c.Nombre ), "
					+ "(select m.IDUnidadMedida from  dbo.UnidadMedida m where ? = m.Nombre ))";
			
			// Setup the connection with the DB
			connect = Conexion.getConnection();

			// Statements allow to issue SQL queries to the database
			ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, bean.getProductoNombre());
			ps.setDouble(2, bean.getPrecioVenta());
			ps.setDouble(3, bean.getPrecioUnitario());
			ps.setDouble(4, bean.getIva());
			ps.setInt(5, bean.getCantidad());
			ps.setString(6, bean.getFechaCaducicad());
			ps.setString(7, bean.getProveedorNombre());
			ps.setString(8, bean.getCategoriaNombre());
			ps.setString(9, bean.getUnidadmedidaNombre());
			
			
			
			// Result set get the result of the SQL query
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			int generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			bean.setProductId(generatedKey);
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
