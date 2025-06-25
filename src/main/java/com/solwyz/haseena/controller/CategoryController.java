package com.solwyz.haseena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwyz.haseena.entity.Category;
import com.solwyz.haseena.pojo.response.ApiResponse;
import com.solwyz.haseena.service.CategoryService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<Category>>> getAllCategory() {
	    List<Category> categories = categoryService.getAllCategoryWithProductCount();  // Make sure this is used
	    return ResponseEntity.ok(new ApiResponse<>("success", categories));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.ok("Category deleted successfully");
	}
	 @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        Category updatedCategory = categoryService.updateCategory(id, category);
	        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	    }
}
