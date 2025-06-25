package com.solwyz.haseena.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.Enquiry;
import com.solwyz.haseena.repo.EnquiryRepository;

@Service
public class EnquiryService {
	
	 private static final Logger logger = LoggerFactory.getLogger(EnquiryService.class);

	    @Autowired
	    private EnquiryRepository enquiryRepository;

	    public Enquiry addEnquiry(Enquiry enquiry) {
	        // Log the incoming enquiry to be saved
	        logger.info("Adding Enquiry: {}", enquiry);

	        // Save the enquiry to the database
	        Enquiry savedEnquiry = enquiryRepository.save(enquiry);

	        // Log after saving the enquiry
	        logger.info("Enquiry added successfully with ID: {}", savedEnquiry.getId());

	        return savedEnquiry;
	    }

	public List<Enquiry> getAllEnquiry() {	
		return enquiryRepository.findAll();
	}
	
}
