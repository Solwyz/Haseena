package com.solwyz.haseena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solwyz.haseena.entity.ContactUs;
import com.solwyz.haseena.pojo.response.ApiResponse;
import com.solwyz.haseena.service.ContactUsService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contact")
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@PostMapping("/create")
	public ResponseEntity<ContactUs> addContact(@RequestBody ContactUs contactUs) {
		return ResponseEntity.ok(contactUsService.addContact(contactUs));
	}
	
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<ContactUs>>> getAllContactUs() {
	    List<ContactUs> contactUs = contactUsService.getAllContactUs();
	    return ResponseEntity.ok(new ApiResponse<>("success", contactUs));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<String>> deleteContact(@PathVariable Long id) {
	    contactUsService.deleteContact(id);
	    return ResponseEntity.ok(new ApiResponse<>("Contact deleted successfully", null));
	}

}
