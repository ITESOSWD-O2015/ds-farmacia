package com.dsfarmacia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.daos.AgregarProducto;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletRegistro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String descripcion=request.getParameter("descripcion");
		String precio=request.getParameter("precio");
		String cantidad=request.getParameter("cantidad");
		String iva=request.getParameter("iva");
		String caducidad=request.getParameter("caducidad");
		
		if(!id.equalsIgnoreCase("") && !descripcion.equalsIgnoreCase("") && !precio.equalsIgnoreCase("") && !cantidad.equalsIgnoreCase("") && !iva.equalsIgnoreCase("") && !caducidad.equalsIgnoreCase("")){
			BeanProducto busuario=new BeanProducto(id, descripcion, precio, cantidad, iva, caducidad);
			
			boolean sw=AgregarProducto.agregarProducto(busuario);
			if(sw){
				request.getRequestDispatcher("Mensaje.html").forward(request, response);
			}else{
				PrintWriter out=response.getWriter();
				out.println("Si estas viendo este mensaje es por que algo salio mal, no se pudo completar tu solicitud.");
			}
		}
	}

}
