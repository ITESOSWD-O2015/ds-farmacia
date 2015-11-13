package com.dsfarmacia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsfarmacia.daos.EliminarProducto;

/**
 * Servlet implementation class ServletEliminar
 */
@WebServlet("/ServletEliminar")
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEliminar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println("Si entre aqui");
		boolean sw= EliminarProducto.eliminarProducto(id);
		if(sw){
			request.getRequestDispatcher("MensajeBorrado.html").forward(request, response);
		}else{
			PrintWriter out=response.getWriter();
			out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
