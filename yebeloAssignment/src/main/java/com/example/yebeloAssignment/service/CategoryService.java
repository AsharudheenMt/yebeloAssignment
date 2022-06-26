package com.example.yebeloAssignment.service;

import java.util.List;
import java.util.Optional;

import com.example.yebeloAssignment.entity.Category;

public interface CategoryService {

	public Category getCategoryByCategoryCode(int categoryCode);

	List<Category> findAll();

	int findNewValue(int oldValue);

	public void saveOrUpdate(Category category);
}
