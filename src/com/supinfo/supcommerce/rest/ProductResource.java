package com.supinfo.supcommerce.rest;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
	@Produces(MediaType.APPLICATION_XML)
	public String getAllProductsInXml() {
		List<Product> products = DaoFactory.createProductDao()
										   .getAll();
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		for (Product product : products) {
			result = result.concat("<products>"
									   + "<product>"
									   + "<id>" + product.getId() + "</id>"
									   + "<name>" + product.getName() + "</name>"
									   + "<description>" + product.getContent() + "</description>"
									   + "<price>" + product.getPrice() + "</price>"
									   + "</product>"
									   + "</products>");
		}
		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllProductsInJson() throws JSONException {
		List<Product> products = DaoFactory.createProductDao()
										   .getAll();
		JSONArray list1 = new JSONArray();
		for (Product product : products) {
			JSONObject obj1 = mapProduct(product);
			list1.put(obj1);
		}

		return list1.toString();

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String getProductInXml(@PathParam("id") Long productId) {
		Product product = DaoFactory.createProductDao()
									.findById(productId);
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result = result.concat("<product>"
								   + "<id>" + product.getId() + "</id>"
								   + "<name>" + product.getName() + "</name>"
								   + "<description>" + product.getContent() + "</description>"
								   + "<price>" + product.getPrice() + "</price>"
								   + "</product>");

		return result;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductInJson(@PathParam("id") Long productId) throws JSONException {

		Product product = DaoFactory.createProductDao()
									.findById(productId);
		return mapProduct(product).toString();

	}

	@DELETE
	@Path("/{id}")
	public void removeProduct(@PathParam("id") Long productId) {

		DaoFactory.createProductDao()
				  .deleteById(productId);
	}

	private JSONObject mapProduct(Product product) {
		JSONObject obj1 = new JSONObject();
		obj1.put("id", product.getId());
		obj1.put("name", product.getName());
		obj1.put("description", product.getContent());
		obj1.put("price", product.getPrice());

		return obj1;
	}

}
