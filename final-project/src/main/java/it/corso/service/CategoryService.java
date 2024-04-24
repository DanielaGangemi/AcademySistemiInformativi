package it.corso.service;

import java.util.List;

import it.corso.dto.CategoryInsertDto;
import it.corso.dto.CategoryShowDto;

public interface CategoryService {

	List<CategoryShowDto> findAll();
	
	List<CategoryShowDto> findAllByCategory(String categoryName);

	CategoryShowDto findById(int id);

	void insert(CategoryInsertDto categoryInsertDto);
	
	void delete(int id);

}
