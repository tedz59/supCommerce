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

@WebServlet(urlPatterns = "/listProduct")
public class ListProductServlet extends HttpServlet {

	private EntityManagerFactory entityManagerFactory;

	@Override
	public void init() throws ServletException {
		entityManagerFactory = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product AS p", Product.class);
		request.setAttribute("products", query.getResultList());
		request.getRequestDispatcher("/listProduct.jsp")
			   .forward(request, response);
	}

	@Override
	public void destroy() {
		entityManagerFactory.close();
	}
}


