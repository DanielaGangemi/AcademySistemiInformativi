package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.Category;
import it.corso.model.CategoryName;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	List<Category> findByCategoryName(CategoryName categoryName);
}
