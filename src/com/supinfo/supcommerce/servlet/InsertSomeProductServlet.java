package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		SupProduct product = new SupProduct();
		product.setName("My Product");
		product.setPrice(10.05F);
		product.setContent("My product is amazing !");
		SupProductDao.addProduct(product);
	}
}