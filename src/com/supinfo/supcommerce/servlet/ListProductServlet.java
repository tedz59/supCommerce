package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		List<SupProduct> products = SupProductDao.getAllProducts();

		PrintWriter out = response.getWriter();
		out.println("My products : ");

		products.stream()
				.forEach(p -> out.println(p.getName() + " - " + p.getContent() + " - " + p.getPrice()));

	}
}


