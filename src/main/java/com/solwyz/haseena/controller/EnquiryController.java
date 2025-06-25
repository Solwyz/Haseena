//package com.solwyz.haseena.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.solwyz.haseena.entity.Enquiry;
//import com.solwyz.haseena.pojo.response.ApiResponse;
//import com.solwyz.haseena.service.EnquiryService;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/enquiry")
//public class EnquiryController {
//	
//	 private static final Logger logger = LoggerFactory.getLogger(EnquiryController.class);
//
//	    @Autowired
//	    private EnquiryService enquiryService;
//
//	    @PostMapping("/create")
//	    public ResponseEntity<Enquiry> addEnquiry(@RequestBody Enquiry enquiry) {
//	        // Log the incoming request
//	        logger.info("Received Enquiry: {}", enquiry);
//
//	        // Save the enquiry and log the result
//	        Enquiry savedEnquiry = enquiryService.addEnquiry(enquiry);
//	        logger.info("Enquiry saved successfully with ID: {}", savedEnquiry.getId());
//
//	        return ResponseEntity.ok(savedEnquiry);
//	    }
//	
//	@GetMapping("/all")
//	public ResponseEntity<ApiResponse<List<Enquiry>>> getAllEnquiry() {
//	    List<Enquiry> enquiry = enquiryService.getAllEnquiry();
//	    return ResponseEntity.ok(new ApiResponse<>("success", enquiry));
//	}
//
//}
