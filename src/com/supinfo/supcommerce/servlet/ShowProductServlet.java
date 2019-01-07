package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.sun.supcommerce.exception.UnknownProductException;

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
		throws IOException {
		PrintWriter out = response.getWriter();
		try {
			Optional<String> idOption = Optional.ofNullable(request.getParameter("id"));

			idOption.ifPresent(id -> printProduct(id, out));
		} catch (UnknownProductException e) {
			out.println("Product not found");
		} catch (NumberFormatException e) {
			out.println("Incorrect format");
		}
	}

	private void printProduct(String stringId, PrintWriter out) {
		Long id = Long.valueOf(stringId);
		SupProduct product = SupProductDao.findProductById(id);
		out.println("Name : " + product.getName());
		out.println("Content : " + product.getContent());
		out.println("Price : " + product.getPrice());
	}

}