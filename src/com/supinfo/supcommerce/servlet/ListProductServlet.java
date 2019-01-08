package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.RequestDispatcher;
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
		request.setAttribute("products", SupProductDao.getAllProducts());
		RequestDispatcher rd = request.getRequestDispatcher("/listProduct.jsp");
		rd.forward(request, response);
	}
}


