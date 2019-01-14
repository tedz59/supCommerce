package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.entity.Product;

import java.util.List;

public interface ProductDao {

	/**
	 * Permet de créer un {@code Product}
	 *
	 * @param product
	 * 	à créer.
	 *
	 * @return Le {@code Product} créé, contient l'id généré.
	 */
	Product create(Product product);

	/**
	 * Permet de supprimer un {@code Product}.
	 *
	 * @param id
	 * 	identifiant du {@code Product}.
	 */
	void deleteById(Long id);

	/**
	 * Permet de récupérer un {@code Product}.
	 *
	 * @param id
	 * 	identifiant du {@code Product}
	 *
	 * @return le {@code Product} recherché.
	 */
	Product findById(Long id);

	/**
	 * Permet de récupérer tous les {@code Product}.
	 *
	 * @return Une {@code List} de {@code Product}.
	 */
	List<Product> getAll();

	/**
	 * Permet de récupérer les {@code Product} moins cher que 100 euros.
	 *
	 * @return Une {@code List} de {@code Product}.
	 */
	List<Product> getCheaperProducts();

}
