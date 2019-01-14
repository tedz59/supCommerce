package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		Product product = new Product();
		product.setName("My Product");
		product.setPrice(10.05F);
		product.setContent("My product is amazing !");

		DaoFactory.createProductDao()
				  .create(product);

	}
}