package com.dsfarmacia.rs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dsfarmacia.beans.BeanPago;

import com.dsfarmacia.controllers.PagoController;

@Path("/pagos")
public class PagoResource {
	
	@Context
	  private HttpServletRequest request;
	 
	  @GET
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) // PRODUCES nos va a regresar todos los productos en un JSON y en caso de que no pueda nos regresa un XML
	  /**
	   * Returns all products from database.
	   * @return
	   */
	  public Response getCategoria() {
		  System.out.println("Checking pagos...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{	
		  
		  
				System.out.println("Getting list of tipo de pagos...");
				List<BeanPago> list = PagoController.getController().getList(); // Se obtiene una lista con los productos de la BD
				GenericEntity<List<BeanPago>> entity = new GenericEntity<List<BeanPago>>(list) {};
				System.out.println(list);
				if(list.isEmpty()){// Si no hay ningun producto en la base de Datos manda un http response 204. (no content)
					return Response.noContent().build();
				}else{
					return Response.ok(entity).build(); // Regresa un ok(200) con los productos.
				}
//			}
//			else{
//				  return Response.status(Response.Status.FORBIDDEN).build(); //Este metodo retorna prohibido (Sirve para el login)
//			  }
	  }

}
