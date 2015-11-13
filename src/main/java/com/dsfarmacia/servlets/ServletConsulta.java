package com.dsfarmacia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.daos.BuscarProducto;

/**
 * Servlet implementation class ServletConsulta
 */
@WebServlet("/ServletConsulta")
public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletConsulta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descripcion=request.getParameter("descripcion");
		BeanProducto bproducto = BuscarProducto.consultarProducto(descripcion);
		if(bproducto!=null){
			request.setAttribute("bproducto", bproducto);
			request.getRequestDispatcher("DesplegarProductos.jsp").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.println("Error, no se encontro el usuario.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
