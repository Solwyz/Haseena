package com.solwyz.haseena.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category save(Category category);

}
