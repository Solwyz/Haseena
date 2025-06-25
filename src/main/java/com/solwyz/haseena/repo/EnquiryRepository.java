package com.solwyz.haseena.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long>{

	Enquiry save(Enquiry enquiry);

}
