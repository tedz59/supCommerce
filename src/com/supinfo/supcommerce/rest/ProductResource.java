package com.supinfo.supcommerce.rest;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("products")
public class ProductResource {

	@GET
	@Path("/hello")
	@Produces("text/plain")
	public String hello() {
		return "Hello World!!!";
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getAllProductsInXml() {
		return DaoFactory.createProductDao()
						 .getAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getProductInXml(@PathParam("id") Long productId) {
		return Response.ok()
					   .entity(DaoFactory.createProductDao()
										 .findById(productId))
					   .build();
	}

	@DELETE
	@Path("/{id}")
	public Response removeProduct(@PathParam("id") Long productId) {
		DaoFactory.createProductDao()
				  .deleteById(productId);
		return Response.noContent()
					   .build();
	}

}
