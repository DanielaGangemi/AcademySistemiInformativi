package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
