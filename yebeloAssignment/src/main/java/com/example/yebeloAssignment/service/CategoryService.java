package com.example.yebeloAssignment.service;

import java.util.List;

import com.example.yebeloAssignment.entity.Category;

public interface CategoryService {

	public Category getCategoryByCategoryCode(int categoryCode);

	List<Category> findAll();

	int findNewValue(int value);

	public void saveOrUpdate(Category category);
}
