package com.ssn.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.model.SsnEnrollment;
import com.ssn.service.SsnService;

@RestController
public class SsnEnrollmentRestController {

	@Autowired
	private SsnService service;
	
	
	@GetMapping(value="/getStates",consumes="application/json")
	public List<String> getAllStatesList() {
		List<String> allStates = service.getAllStates();
		return allStates;
	}
	
	@PostMapping(value="/submitEnrollment",consumes="application/json")
	public ResponseEntity<String> enroll(@RequestBody SsnEnrollment customer) {
		Long ssnNumber= service.saveCustomerInfo(customer);
		ResponseEntity<String> response =	null;
		String message ="Registration is Successfully done with SSN no " + ssnNumber;
		
		response = new ResponseEntity<>(message, HttpStatus.CREATED);
		return response;
	}
	
	
	
	
}
