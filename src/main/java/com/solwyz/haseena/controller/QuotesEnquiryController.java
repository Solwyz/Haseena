package com.solwyz.haseena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwyz.haseena.entity.QuotesEnquiry;
import com.solwyz.haseena.service.QuotesEnquiryService;

@RestController
@RequestMapping("/api/quotes")
public class QuotesEnquiryController {
	
	@Autowired
    private QuotesEnquiryService quotesEnquiryService;

    // Create QuotesEnquiry
    @PostMapping("/create")
    public ResponseEntity<QuotesEnquiry> createQuotesEnquiry(@RequestBody QuotesEnquiry quotesEnquiry) {
        QuotesEnquiry createdEnquiry = quotesEnquiryService.createQuotesEnquiry(quotesEnquiry);
        return ResponseEntity.ok(createdEnquiry);
    }

    // Get all QuotesEnquiries
    @GetMapping("/getAll")
    public ResponseEntity<List<QuotesEnquiry>> getAllQuotesEnquiries() {
        List<QuotesEnquiry> quotesEnquiries = quotesEnquiryService.getAllQuotesEnquiries();
        return ResponseEntity.ok(quotesEnquiries);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuotesEnquiry(@PathVariable Long id) {
        quotesEnquiryService.deleteQuotesEnquiryById(id);
        return ResponseEntity.ok("QuotesEnquiry with ID " + id + " has been deleted.");
    }

}
