package com.solwyz.haseena.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solwyz.haseena.entity.User;

public interface AdminRepository extends JpaRepository<User, Long>{

	

}
