package com.springboot.crud.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.api.model.Category;
import com.springboot.crud.api.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			Category category = optional.get();
			return category;
		}
		return null;
	}

}
