package com.example.yebeloAssignment.service;

import java.util.ArrayList;
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

		Category category = categoryRepository.findByCategoryCode(categoryCode);
		return category;
	}

	@Override
	public List<Category> findAll() {
		List<Category> list = new ArrayList<>();
		categoryRepository.findAll().forEach(category -> list.add(category));
		return list;
	}

	@Override
	public int findNewValue(int oldValue) {
		// if the fetched value's sum of digits is 1 we use the next value.
		if (digSum(oldValue) == 1) {
			oldValue++;
		}

		// smallest next number is calculated
		for (int i = oldValue; true; i++, oldValue++) {
			if (digSum(i) == 1) {
				return oldValue;
			}
		}
	}

	@Override
	public void saveOrUpdate(Category category) {
		categoryRepository.save(category);

	}

}
