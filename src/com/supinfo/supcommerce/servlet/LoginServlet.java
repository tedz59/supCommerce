package com.supinfo.supcommerce.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {

		String username = req.getParameter("username")
							 .trim();
		req.getSession()
		   .setAttribute("username", username);

		resp.sendRedirect("listProduct");
	}
}
