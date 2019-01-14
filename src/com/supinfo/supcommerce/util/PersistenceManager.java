package com.supinfo.supcommerce.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceManager {

	/**
	 * Constructeur privé pour empecher de l'instancier.
	 */
	private PersistenceManager() {
	}

	private static EntityManagerFactory emf;

	/**
	 * Renvoi une instance de {@code EntityManagerFactory} unique.
	 *
	 * @return une instance de {@code EntityManagerFactory} unique.
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("SUPCOMMERCE-PU");
		}
		return emf;
	}

	/**
	 * Permet de fermer le {@code EntityManagerFactory}.
	 */
	public static void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}
	}

}
