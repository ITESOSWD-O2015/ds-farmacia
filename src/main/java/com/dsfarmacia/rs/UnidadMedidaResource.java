package com.dsfarmacia.rs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dsfarmacia.beans.BeanUnidadMedida;
import com.dsfarmacia.controllers.UnidadMedidaController;


public class UnidadMedidaResource {
	
	@Context
    private HttpServletRequest request;
	
	
	@GET //Este metodo GET es para buscar un id especifico. Recibimos el id de parte del metodo ProductResource
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Regresa un JSON
	  public Response getUnidadMedida(@PathParam("id") String id){

//		System.out.println("Checking valid session...");
//		HttpSession session = request.getSession(false);
//		if(session != null)
//		{	
			System.out.println("getting UnidadMedida with name["+id+"]");
			String patron= id+".*";
			System.out.println("El patron a buscar es:" + patron);
		  
			List<BeanUnidadMedida> lista = new ArrayList<BeanUnidadMedida>();
			List<BeanUnidadMedida> list = UnidadMedidaController.getController().getList(); //Primero se obtiene la lista con todos los productos
			
			System.out.println(list);
			//Preguntar que pedob
			try{
				int aid = Integer.parseInt(id);
				for(BeanUnidadMedida b : list){ //Se hace un ciclo for each y comparamos el id de la lista con el ID que recibimos
					if(b.getUnidadmedidaId() == aid){ //Se hace un parse para se comparen INT.
						System.out.println("si soy igual");
						lista.add(b);
						System.out.println("quepedo");
						
						return Response.ok(b).build(); //Si encuentra el producto en la BD, regresa un ok(200) con el todos los datos.
					}
				}
			}catch(Exception e){
				for(BeanUnidadMedida b : list){ //Se hace un ciclo for each y comparamos el id de la lista con el ID que recibimos

					if(b.getUnidadmedidanombre().startsWith(id)){ 
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
	  public Response updateUnidadMedida(@PathParam("id") String id, BeanUnidadMedida bean){
		 
//		  System.out.println("Checking valid session...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{	
//				
				System.out.println("updating unidadMedida with id["+id+"]");
				System.out.println(bean);
				bean.setUnidadmedidaId(Integer.parseInt(id)); //Se obtiene el id y se agrega al bean para que sepa que producto actualizar
				bean = UnidadMedidaController.getController().update(bean); // Se le envio los parametros que se modificaron
				return Response.ok(bean).build(); //Regresa el producto modificado con un ok (200)
//			}
//			else{
//				  return Response.status(Response.Status.FORBIDDEN).build();
//			  }
	  }
	 
	 @DELETE
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	  public Response deleteUnidadMedida(@PathParam("id") String id){
//		  System.out.println("Checking valid session...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{
				System.out.println("deleting unidadMedida with id["+id+"]");
				
				if(UnidadMedidaController.getController().delete(id)){// Se le envia el id para eliminar el producto
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
