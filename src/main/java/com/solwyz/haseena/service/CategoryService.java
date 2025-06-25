package com.solwyz.haseena.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.Category;
import com.solwyz.haseena.repo.CategoryRepository;
import com.solwyz.haseena.repo.ProductRepository;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAllCategoryWithProductCount() {
	    List<Category> categories = categoryRepository.findAll();
	    for (Category category : categories) {
	        long count = productRepository.countByCategory(category);
	        category.setTotalProducts(count);  // Important
	    }
	    return categories;
	}


	public void deleteCategory(Long id) {
		if (!categoryRepository.existsById(id)) {
			throw new RuntimeException(+id + " does not exist");
		}
		categoryRepository.deleteById(id);
	}

	public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(id + " does not exist"));

        // Only update 'name' since 'id' is generated and 'totalProducts' is transient
        existingCategory.setName(updatedCategory.getName());

        return categoryRepository.save(existingCategory);
    }
}
