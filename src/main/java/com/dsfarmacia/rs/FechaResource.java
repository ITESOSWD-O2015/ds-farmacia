package com.dsfarmacia.rs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.controllers.ProductController;

@Path("/fecha")
public class FechaResource {
	
	  @Context
	  private HttpServletRequest request;
	 
	  @GET
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) // PRODUCES nos va a regresar todos los productos en un JSON y en caso de que no pueda nos regresa un XML
	  /**
	   * Returns all products from database.
	   * @return
	   */
	  public Response getProduct() {
		 
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{	
				System.out.println("Getting list of products...");
				List<BeanProducto> list = ProductController.getController().getList(); // Se obtiene una lista con los productos de la BD
				List<BeanProducto> lista = new ArrayList<BeanProducto>();
				
				for(BeanProducto b : list){ //Se hace un ciclo for each y comparamos el id de la lista con el ID que recibimos
					if(b.getCantidad()<=4){ //Se hace un parse para se comparen INT.
						System.out.println("si soy igual");
						lista.add(b);
					}
				}
				
				System.out.println(lista+"\n");
				if(lista.isEmpty())
				return Response.noContent().build(); //Si no encuentra nada, regresa un 204.
				else{

					return Response.ok(lista).build();
				}
				
				
//			}
//			else{
//				  return Response.status(Response.Status.FORBIDDEN).build(); //Este metodo retorna prohibido (Sirve para el login)
//			  }
	  }

}
