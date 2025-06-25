package com.solwyz.haseena.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solwyz.haseena.entity.QuotesEnquiry;

@Repository
public interface QuotesEnquiryRepository extends JpaRepository<QuotesEnquiry, Long> {
}