package com.supinfo.supcommerce.dao.jpa;

import com.supinfo.supcommerce.dao.CategoryDao;
import com.supinfo.supcommerce.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

import static com.supinfo.supcommerce.util.DaoUtils.persistEntityWithTransaction;

public class JpaCategoryDao implements CategoryDao {

	private EntityManagerFactory entityManagerFactory;

	/**
	 * Permet d'inititialiser le dao avec la factory.
	 *
	 * @param entityManagerFactory
	 * 	l'entity manager factory.
	 */
	public JpaCategoryDao(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Category> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Category> categories = entityManager.createQuery("SELECT c FROM Category AS c", Category.class)
												 .getResultList();
		entityManager.close();
		return categories;
	}

	@Override
	public Category findById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Category category = entityManager.find(Category.class, id);
		entityManager.close();
		return category;
	}

	@Override
	public Category create(Category category) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		persistEntityWithTransaction(category, entityManager);

		return category;
	}

	@Override
	public void update(Category categoryToUpdate) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(categoryToUpdate);
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}
}
