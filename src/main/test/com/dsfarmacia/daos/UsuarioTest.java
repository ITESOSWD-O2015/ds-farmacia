package com.dsfarmacia.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.daos.AgregarProducto;

import static org.mockito.Mockito.*;

public class UsuarioTest {
	
	AgregarProducto usuario;
	
	@Before
	public void setUp(){
		usuario = mock(AgregarProducto.class);
	}
	
	@Test
	public void agregarProductoTest() throws SQLException{
		 
	}

}
