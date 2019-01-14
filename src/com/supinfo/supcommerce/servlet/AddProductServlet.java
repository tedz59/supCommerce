package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/addProduct")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("categories", DaoFactory.createCategoryDao()
												 .getAll());

		req.getRequestDispatcher("/auth/addProduct.jsp")
		   .forward(req, resp);
	}

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

		Product product = new Product();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		Long categoryId = Long.valueOf(request.getParameter("categoryId"));
		product.setCategory(DaoFactory.createCategoryDao()
									  .findById(categoryId));

		DaoFactory.createProductDao()
				  .create(product);

		response.sendRedirect(request.getContextPath() + "/showProduct?id=" + product.getId());
	}

}
