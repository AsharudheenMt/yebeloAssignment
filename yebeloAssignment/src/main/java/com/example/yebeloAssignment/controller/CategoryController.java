package com.example.yebeloAssignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/fetchNextNumber")
	public Map<String, Integer> getNextValues(@RequestParam("categoryCode") int categoryCode) {
		Map<String, Integer> myMap = new HashMap<>();
		Category category = categoryService.getCategoryByCategoryCode(categoryCode);
		int oldValue = category.getValue();
		int newValue = categoryService.findNewValue(oldValue);
		category.setValue(newValue);
		categoryService.saveOrUpdate(category);
		myMap.put("oldValue", oldValue);
		myMap.put("newValue", newValue);
		return myMap;

	}

}
