package com.dsfarmacia.rs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dsfarmacia.beans.BeanProducto;
import com.dsfarmacia.controllers.ProductController;


public class ProductResource {
	@Context
    private HttpServletRequest request;
	
	
	@GET //Este metodo GET es para buscar un id especifico. Recibimos el id de parte del metodo ProductResource
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Regresa un JSON
	  public Response getUser(@PathParam("id") String id){

//		System.out.println("Checking valid session...");
//		HttpSession session = request.getSession(false);
//		if(session != null)
//		{	
			System.out.println("getting user with name["+id+"]");
			String patron= id+".*";
			System.out.println("El patron a buscar es:" + patron);
		  
			List<BeanProducto> lista = new ArrayList<BeanProducto>();
			List<BeanProducto> list = ProductController.getController().getList(); //Primero se obtiene la lista con todos los productos
			
			System.out.println(list);
			//Preguntar que pedob
			try{
				int aid = Integer.parseInt(id);
				for(BeanProducto b : list){ //Se hace un ciclo for each y comparamos el id de la lista con el ID que recibimos
					if(b.getProductId() == aid){ //Se hace un parse para se comparen INT.
						System.out.println("si soy igual");
						lista.add(b);
						System.out.println("quepedo");
						
						return Response.ok(b).build(); //Si encuentra el producto en la BD, regresa un ok(200) con el todos los datos.
					}
				}
			}catch(Exception e){
				for(BeanProducto b : list){ //Se hace un ciclo for each y comparamos el id de la lista con el ID que recibimos

					if(b.getProductoNombre().startsWith(id)){ 
						lista.add(b);
						//Se hace un parse para se comparen INT.
						 //Si encuentra el producto en la BD, regresa un ok(200) con el todos los datos.
					}
				}
				
				
				
			}
			
			System.out.println(lista+"\n");
			if(lista.isEmpty())
			return Response.noContent().build(); //Si no encuentra nada, regresa un 204.
			else{

				return Response.ok(lista).build();
			}
			
			
		
				
//		}
//		else{
//			  return Response.status(Response.Status.FORBIDDEN).build();
//		  }
	  }

	
	 @PUT
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Regresa un JSON
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Convierte el JSON
	  public Response updateUser(@PathParam("id") String id, BeanProducto bean){
		 
//		  System.out.println("Checking valid session...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{	
//				
				System.out.println("updating user with id["+id+"]");
				System.out.println(bean);
				bean.setProductId(Integer.parseInt(id)); //Se obtiene el id y se agrega al bean para que sepa que producto actualizar
				bean = ProductController.getController().updateProduct(bean); // Se le envio los parametros que se modificaron
				return Response.ok(bean).build(); //Regresa el producto modificado con un ok (200)
//			}
//			else{
//				  return Response.status(Response.Status.FORBIDDEN).build();
//			  }
	  }
	 
	 @DELETE
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	  public Response deleteMessage(@PathParam("id") String id){
//		  System.out.println("Checking valid session...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{
				System.out.println("deleting user with id["+id+"]");
				
				if(ProductController.getController().delete(id)){// Se le envia el id para eliminar el producto
					return Response.ok().build(); //Regresa una respuesta ok(200) si elimino el producto.
				}
				return Response.notModified().build(); //Si no lo elimino regresa un notModified(304)
//			}
//			else{
//				  return Response.status(Response.Status.FORBIDDEN).build();
//			  }
//	  }
	
}
	 
}
