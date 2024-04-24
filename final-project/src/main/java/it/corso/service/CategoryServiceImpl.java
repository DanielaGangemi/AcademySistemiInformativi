package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoryDao;
import it.corso.dto.CategoryInsertDto;
import it.corso.dto.CategoryShowDto;
import it.corso.model.Category;
import it.corso.model.CategoryName;

@Service
public class CategoryServiceImpl implements CategoryService {

	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<CategoryShowDto> findAll() {

		List<Category> categoryList = categoryDao.findAll();

		List<CategoryShowDto> categoryListDto = new ArrayList<>();

		categoryList.forEach(c -> categoryListDto.add(mapper.map(c, CategoryShowDto.class)));

		return categoryListDto;

	}

	@Override
	public CategoryShowDto findById(int id) {

		Optional<Category> category = categoryDao.findById(id);

		return category.isPresent() ? mapper.map(category, CategoryShowDto.class) : null;

	}

	@Override
	public void insert(CategoryInsertDto categoryInsertDto) {

		categoryDao.save(mapper.map(categoryInsertDto, Category.class));

	}

	@Override
	public List<CategoryShowDto> findAllByCategory(String categoryName) {

		List<Category> categoryList = categoryDao.findByCategoryName(CategoryName.valueOf(categoryName));

		List<CategoryShowDto> categoryListDto = new ArrayList<>();

		categoryList.forEach(c -> categoryListDto.add(mapper.map(c, CategoryShowDto.class)));

		return categoryListDto;
	}

	@Override
	public void delete(int id) {

		CategoryShowDto categoryShowDto = findById(id);

		categoryDao.delete(mapper.map(categoryShowDto, Category.class));

	}

}
