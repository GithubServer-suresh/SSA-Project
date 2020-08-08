package com.ssn.service;

import java.util.List;

import com.ssn.model.SsnEnrollment;

public interface SsnService {

	public List<String> getAllStates();
	
	public Long saveCustomerInfo(SsnEnrollment ssnCustomer);
	
	public String checkEnrollmentBySsnId(Long ssn, String stateName);
}
