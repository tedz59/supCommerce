package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.dao.DaoFactory;
import com.supinfo.supcommerce.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/auth/addCategory.jsp")
		   .forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String name = req.getParameter("name");

		Category category = new Category(name);

		DaoFactory.createCategoryDao()
				  .create(category);

		resp.sendRedirect(req.getContextPath() + "/");

	}

}
