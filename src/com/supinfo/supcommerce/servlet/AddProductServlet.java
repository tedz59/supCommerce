package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/addProduct")
public class AddProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		String name = request.getParameter("name")
							 .trim();

		String content = request.getParameter("content")
								.trim();
		float price = 0;

		try {
			price = Float.valueOf(request.getParameter("price"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		SupProduct product = new SupProduct();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		SupProductDao.addProduct(product);

		response.sendRedirect(request.getContextPath() + "/showProduct?id=" + product.getId());
	}

}
