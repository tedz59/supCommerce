package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<SupProduct> products = SupProductDao.getAllProducts();

		PrintWriter out = response.getWriter();
		out.println("My products : ");

		for (SupProduct product : products) {
			out.println(product.getName() + " - " + product.getContent() + " - " + product.getPrice());
		}
	}
}


