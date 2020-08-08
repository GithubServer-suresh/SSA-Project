package com.ssn.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssn.service.SsnService;

@RestController
public class SsnValidationRestController {

	@Autowired
	private SsnService service;
		
	@GetMapping("/checkSSN/{ssn}/{state}")
	public ResponseEntity<String> validateCustomerSSN(@PathVariable("ssn") String ssn, @PathVariable("state") String state) {
		
		ResponseEntity<String> response = null;
		
		String ssnValidateByState = service.checkEnrollmentBySsnId(Long.parseLong(ssn), state);
		System.out.println(ssnValidateByState);
		response = new ResponseEntity<String>(ssnValidateByState,HttpStatus.OK);
		return response;
	}
	
}
