package com.solwyz.haseena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.QuotesEnquiry;
import com.solwyz.haseena.repo.QuotesEnquiryRepository;

@Service
public class QuotesEnquiryService {
	
	 @Autowired
	    private QuotesEnquiryRepository quotesEnquiryRepository;

	    // Create method to save a new QuotesEnquiry
	    public QuotesEnquiry createQuotesEnquiry(QuotesEnquiry quotesEnquiry) {
	        return quotesEnquiryRepository.save(quotesEnquiry);
	    }

	    // GetAll method to fetch all QuotesEnquiries
	    public List<QuotesEnquiry> getAllQuotesEnquiries() {
	        return quotesEnquiryRepository.findAll();
	    }

	    public void deleteQuotesEnquiryById(Long id) {
	        quotesEnquiryRepository.deleteById(id);
	    }

}
