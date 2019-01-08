package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.doa.SupProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/auth/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<String> idOption = Optional.ofNullable(req.getParameter("id"));

		idOption.ifPresent(id -> deleteProduct(id));

		resp.sendRedirect(req.getContextPath() + "/listProduct");
	}

	private void deleteProduct(String id) {
		SupProductDao.removeProduct(Long.valueOf(id));
	}
}
