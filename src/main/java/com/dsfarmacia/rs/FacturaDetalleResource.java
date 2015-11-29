package com.dsfarmacia.rs;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.dsfarmacia.beans.BeanFacturaDetalle;

import com.dsfarmacia.controllers.FacturaDetalleController;

@Path("/facturad")
public class FacturaDetalleResource {
	
	@Context
	  private HttpServletRequest request;
	
	  @POST //El metodo entra aqui si fue un httt.post
	  //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Retorna en un JSON los productos agregados
	  @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON}) //Recibe un JSON y lo convierte a un bean.
	  	
	  public BeanFacturaDetalle insertar(BeanFacturaDetalle bean){
		  System.out.println("Entre a factura detalle");
	//  public ProductBean saveProduct(@FormParam("id") String id, @FormParam("name") String name,
//			  @FormParam("categoria") String categoria, @FormParam("precio") String precio,
//			  @FormParam("marca") String marca, @FormParam("cantidad") String cantidad){
	    //	  	System.out.println("Checking valid session...");
		//	HttpSession session = request.getSession(false);
		//	if(session != null)
		//	{	
	
		    System.out.println(bean.toString());
//		   	ProductBean bean = new ProductBean();
//		   	bean.setProductId(Integer.parseInt(id));
//		   	bean.setNombre(name);
//		   	bean.setCategoria(Integer.parseInt(categoria));
//		   	bean.setPrecio(Integer.parseInt(precio));
//		   	bean.setMarca(Integer.parseInt(marca));
//		   	bean.setCantidad(Integer.parseInt(cantidad));
			FacturaDetalleController.getController(); //Se crea el controlador, en caso de no existir.
			bean = FacturaDetalleController.save(bean); //Se le envia el bean al DAO para guardarlos en la BD
			System.out.println(bean);
			return bean;
}

}
