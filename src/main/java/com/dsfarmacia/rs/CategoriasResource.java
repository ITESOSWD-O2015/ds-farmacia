package com.dsfarmacia.rs;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dsfarmacia.beans.BeanCategoria;
import com.dsfarmacia.controllers.CategoriaController;

@Path("/categorias")
public class CategoriasResource {
	
	@Context
	  private HttpServletRequest request;
	 
	  @GET
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) // PRODUCES nos va a regresar todos los productos en un JSON y en caso de que no pueda nos regresa un XML
	  /**
	   * Returns all products from database.
	   * @return
	   */
	  public Response getCategoria() {
		  System.out.println("Checking valid session...");
//			HttpSession session = request.getSession(false);
//			if(session != null)
//			{	
		  
		  
				System.out.println("Getting list of users...");
				List<BeanCategoria> list = CategoriaController.getController().getList(); // Se obtiene una lista con los productos de la BD
				GenericEntity<List<BeanCategoria>> entity = new GenericEntity<List<BeanCategoria>>(list) {};
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
	  
	  @POST //El metodo entra aqui si fue un httt.post
	  //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Retorna en un JSON los productos agregados
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Recibe un JSON y lo convierte a un bean.
	  /**
	   * Saves a product
	   * @param msg
	   * @return
	   */
	  public BeanCategoria saveCategoria(BeanCategoria bean){
	//  public ProductBean saveProduct(@FormParam("id") String id, @FormParam("name") String name,
//			  @FormParam("categoria") String categoria, @FormParam("precio") String precio,
//			  @FormParam("marca") String marca, @FormParam("cantidad") String cantidad){
	    //	  	System.out.println("Checking valid session...");
		//	HttpSession session = request.getSession(false);
		//	if(session != null)
		//	{	
		  
		  	System.out.println("Saving a product...");
		    System.out.println(bean.toString());
//		   	ProductBean bean = new ProductBean();
//		   	bean.setProductId(Integer.parseInt(id));
//		   	bean.setNombre(name);
//		   	bean.setCategoria(Integer.parseInt(categoria));
//		   	bean.setPrecio(Integer.parseInt(precio));
//		   	bean.setMarca(Integer.parseInt(marca));
//		   	bean.setCantidad(Integer.parseInt(cantidad));
			CategoriaController.getController(); //Se crea el controlador, en caso de no existir.
			bean = CategoriaController.save(bean); //Se le envia el bean al DAO para guardarlos en la BD
			System.out.println(bean);
			return bean;
	  }

	  
	@Path("/{id}") //El metodo entra aqui si encuentra en la url un ID
	public CategoriaResource getCategorias(@PathParam("id") String id) {
		  //System.out.println("Checking valid session...");
		//	HttpSession session = request.getSession(false);
		//	if(session != null)
		//	{	
				CategoriaResource categoria = new CategoriaResource(); // Buscamos un id en especifico, delete o update
				System.out.println(categoria);
				return categoria;
		//	}
		//	else{
				 // return Response.status(Response.Status.FORBIDDEN).build();
			 // }
	}

}
