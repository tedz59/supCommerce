package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		request.setAttribute("products", DaoFactory.createProductDao()
												   .getAll());
		request.getRequestDispatcher("/listProduct.jsp")
			   .forward(request, response);
	}
}


