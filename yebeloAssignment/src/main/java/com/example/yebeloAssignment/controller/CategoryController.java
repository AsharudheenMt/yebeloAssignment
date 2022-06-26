package com.example.yebeloAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yebeloAssignment.entity.Category;
import com.example.yebeloAssignment.service.CategoryService;

@RestController
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/findAll")
	public List<Category> getAll() {
		return categoryService.findAll();
	}
	
	
}
