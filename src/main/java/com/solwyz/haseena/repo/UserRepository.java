package com.solwyz.haseena.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User save(User user);

	
	//Optional<User> findFirstByEmail(String email);
    Optional<User> findByEmail(String email);
	//Optional<User> findByUserName(String userName);


    Optional<User>findByUsername(String username);


}
