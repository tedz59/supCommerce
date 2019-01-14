package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/cheaperProducts")
public class CheaperProductServlet extends HttpServlet {
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product AS p WHERE p.price < 100", Product.class);

		req.setAttribute("products", query.getResultList());

		req.getRequestDispatcher("/listProduct.jsp")
		   .forward(req, resp);

		entityManager.close();
	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}
}
