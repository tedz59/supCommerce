package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cheaperProducts")
public class CheaperProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("products", DaoFactory.createProductDao()
											   .getCheaperProducts());

		req.getRequestDispatcher("/listProduct.jsp")
		   .forward(req, resp);
	}
}
