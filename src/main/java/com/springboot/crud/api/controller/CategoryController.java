package com.springboot.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.api.dto.ResponseDto;
import com.springboot.crud.api.model.Category;
import com.springboot.crud.api.service.CategoryService;

@RestController
@CrossOrigin(origins = {"http://localhost:4080"})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ResponseDto responseDto;
	
	@PostMapping("/add/category")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
		responseDto.setMsg("Category added successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	@GetMapping("/get/categories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/get/category/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable("id") Long id) {
		Category category = categoryService.getCategoryById(id);
		if(category == null) {
			responseDto.setMsg("Invalid Category ID");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
		}
		return ResponseEntity.status(HttpStatus.OK).body(category);
	}

}
