package com.solwyz.haseena.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.Category;
import com.solwyz.haseena.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(Long categoryId);

	long countByCategory(Category category);

	 List<Product> findByCategoryAndIdNot(Category category, Long id);

}
