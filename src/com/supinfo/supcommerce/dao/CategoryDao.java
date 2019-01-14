package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.entity.Category;

import java.util.List;

public interface CategoryDao {

	/**
	 * Renvoi toutes les catégories.
	 *
	 * @return Une {@code List} de {@code Category}.
	 */
	List<Category> getAll();

	/**
	 * Permet de récupérer une categories.
	 *
	 * @param id
	 * 	identifiant de la catégorie.
	 *
	 * @return La {@code Category} recherché.
	 */
	Category findById(Long id);

	/**
	 * Permet de créer une {@code Category}.
	 *
	 * @param category
	 * 	La {@code Category} à créer.
	 *
	 * @return La {@code Category} créé, contiens l'id généré.
	 */
	Category create(Category category);

}
