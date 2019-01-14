package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.dao.jpa.JpaCategoryDao;
import com.supinfo.supcommerce.dao.jpa.JpaProductDao;
import com.supinfo.supcommerce.util.PersistenceManager;

/**
 * Usine de Dao.
 */
public final class DaoFactory {

	/**
	 * Empeche d'instancer la classe car c'est une classe utilitaire.
	 */
	private DaoFactory() {
	}

	/**
	 * Renvoi une nouvelle instance de {@code ProductDao}.
	 *
	 * @return une nouvelle instance de {@code ProductDao}.
	 */
	public static ProductDao createProductDao() {
		return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
	}

	/**
	 * Renvoi une nouvelle instance de {@code CategoryDao}.
	 *
	 * @return une nouvelle instance de {@code CategoryDao}.
	 */
	public static CategoryDao createCategoryDao() {
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}

}
