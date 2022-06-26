package com.example.yebeloAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yebeloAssignment.dao.CategoryRepository;
import com.example.yebeloAssignment.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	// constructor injection of categoryRepository
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

//	Method for finding the sum of individual digits
	static int digSum(int n) {
		int sum = 0;

		// Loop to do sum while
		// sum is not less than
		// or equal to 9
		while (n > 0 || sum > 9) {
			if (n == 0) {
				n = sum;
				sum = 0;
			}
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	@Override
	public Category getCategoryByCategoryCode(int categoryCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findNewValue(int value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void saveOrUpdate(Category category) {
		// TODO Auto-generated method stub

	}

}
