package com.supinfo.supcommerce.dao.jpa;

import com.supinfo.supcommerce.dao.ProductDao;
import com.supinfo.supcommerce.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

import static com.supinfo.supcommerce.util.DaoUtils.persistEntityWithTransaction;

public class JpaProductDao implements ProductDao {

	private static final String SELECT_ALL_CLAUSE = "SELECT p FROM Product AS p";
	private EntityManagerFactory entityManagerFactory;

	/**
	 * Permet d'inititialiser le dao avec la factory.
	 *
	 * @param entityManagerFactory
	 * 	l'entity manager factory.
	 */
	public JpaProductDao(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public Product create(Product product) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		persistEntityWithTransaction(product, entityManager);

		return product;
	}

	@Override
	public void deleteById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.remove(entityManager.find(Product.class, id));
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}

	@Override
	public Product findById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Product category = entityManager.find(Product.class, id);
		entityManager.close();
		return category;
	}

	@Override
	public List<Product> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Product> products = entityManager.createQuery(SELECT_ALL_CLAUSE, Product.class)
											  .getResultList();
		entityManager.close();
		return products;
	}

	@Override
	public List<Product> getCheaperProducts() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Product> products = entityManager.createQuery(SELECT_ALL_CLAUSE + " WHERE p.price < 100", Product.class)
											  .getResultList();
		entityManager.close();
		return products;
	}
}
