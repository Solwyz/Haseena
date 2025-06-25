package com.solwyz.haseena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solwyz.haseena.entity.ContactUs;
import com.solwyz.haseena.repo.ContactUsRepository;

@Service
public class ContactUsService {
	
	@Autowired
	private ContactUsRepository contactUsRepository;
	

	public ContactUs addContact(ContactUs contactUs) {
		return contactUsRepository.save(contactUs);
	}


	 public List<ContactUs> getAllContactUs() {
	        return contactUsRepository.findAll();
	    }


	 public void deleteContact(Long id) {
	        
	        if(!contactUsRepository.existsById(id)) {
	            throw new RuntimeException("Contact with id " + id + " not found");
	        }
	        contactUsRepository.deleteById(id);
	    }

}
