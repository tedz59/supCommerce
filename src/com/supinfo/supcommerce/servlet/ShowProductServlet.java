package com.supinfo.supcommerce.servlet;

import com.supinfo.sun.supcommerce.exception.UnknownProductException;
import com.supinfo.supcommerce.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

	private EntityManagerFactory entityManagerFactory;

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		Optional<String> idOption = Optional.ofNullable(request.getParameter("id"));
		idOption.ifPresent(id -> printProduct(id, request));

		request.getRequestDispatcher("/showProduct.jsp")
			   .forward(request, response);
	}

	private void printProduct(String stringId, HttpServletRequest request) {
		try {
			Long id = Long.valueOf(stringId);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			request.setAttribute("product", entityManager.find(Product.class, id));
			entityManager.close();
		} catch (UnknownProductException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}
}