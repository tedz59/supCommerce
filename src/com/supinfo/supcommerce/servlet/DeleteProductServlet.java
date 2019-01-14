package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/auth/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

	private EntityManagerFactory entityManagerFactory;

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Optional<String> idOption = Optional.ofNullable(req.getParameter("id"));

		idOption.ifPresent(id -> deleteProduct(id));

		resp.sendRedirect(req.getContextPath() + "/listProduct");
	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}

	private void deleteProduct(String id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.remove(entityManager.find(Product.class, Long.valueOf(id)));
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}
}
