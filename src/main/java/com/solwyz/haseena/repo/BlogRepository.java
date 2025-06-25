package com.solwyz.haseena.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
