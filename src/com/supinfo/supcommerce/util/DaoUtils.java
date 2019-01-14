package com.supinfo.supcommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public final class DaoUtils {

	private DaoUtils() {

	}

	/**
	 * Permet de sauvegarder une entity en bdd avec une transaction, puis ferme le transaction manager.
	 *
	 * @param entity
	 * 	à sauvegarder.
	 * @param entityManager
	 * 	entity manager.
	 */
	public static void persistEntityWithTransaction(Object entity, EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(entity);
			transaction.commit();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			entityManager.close();
		}
	}
}
