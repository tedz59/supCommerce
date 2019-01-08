package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		try {
			Optional<String> idOption = Optional.ofNullable(request.getParameter("id"));
			idOption.ifPresent(id -> printProduct(id, request));
			request.getRequestDispatcher("/showProduct.jsp")
				   .forward(request, response);

		} catch (UnknownProductException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	private void printProduct(String stringId, HttpServletRequest request) {
		Long id = Long.valueOf(stringId);
		request.setAttribute("product", SupProductDao.findProductById(id));
	}

}