package com.supinfo.supcommerce.rest;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Category;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("categories")
public class CategoryResource {

	@Path("/{id}")
	@GET
	public Response getById(@PathParam("id") Long id) {
		return Response.ok()
					   .entity(DaoFactory.createCategoryDao()
										 .findById(id))
					   .build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response create(Category category, @Context ServletContext servletContext) throws URISyntaxException {
		Category newCategory = DaoFactory.createCategoryDao()
										 .create(category);
		return Response.created(URI.create(String.format("/rest/categories/%d", newCategory.getId())))
					   .entity(category)
					   .build();
	}

	@Path("/{id}")
	@PUT
	public Response update(@PathParam("id") Long id, Category category) {
		Category categoryToUpdate = DaoFactory.createCategoryDao()
											  .findById(id);

		categoryToUpdate.setName(category.getName());

		DaoFactory.createCategoryDao()
				  .update(categoryToUpdate);

		return Response.accepted()
					   .entity(categoryToUpdate)
					   .build();
	}

}
