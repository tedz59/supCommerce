package com.supinfo.supcommerce.servlet;

import com.supinfo.supcommerce.entity.Category;
import com.supinfo.supcommerce.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/addProduct")
public class AddProductServlet extends HttpServlet {

	private EntityManagerFactory entityManagerFactory;

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category AS c", Category.class);

		req.setAttribute("categories", query.getResultList());

		req.getRequestDispatcher("/auth/addProduct.jsp")
		   .forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		String name = request.getParameter("name")
							 .trim();

		String content = request.getParameter("content")
								.trim();
		float price = 0;
		try {
			price = Float.valueOf(request.getParameter("price"));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Product product = new Product();
		product.setName(name);
		product.setContent(content);
		product.setPrice(price);

		Long categoryId = Long.valueOf(request.getParameter("categoryId"));
		product.setCategory(entityManager.find(Category.class, categoryId));

		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(product);
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}

		response.sendRedirect(request.getContextPath() + "/showProduct?id=" + product.getId());
	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}

}
