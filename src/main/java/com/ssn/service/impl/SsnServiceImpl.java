package com.ssn.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.entity.SsnEnrollmentEntity;
import com.ssn.model.SsnEnrollment;
import com.ssn.repository.SsnEnrollmentRepositoy;
import com.ssn.repository.StatesRepository;
import com.ssn.service.SsnService;

@Service
public class SsnServiceImpl implements SsnService {
	
	@Autowired
	private SsnEnrollmentRepositoy repository;
	
	@Autowired
	private StatesRepository statesRepo;
	
	@Override
	public List<String> getAllStates() {
		List<String> allStateNames = statesRepo.findAllStateNames();
		return allStateNames;
	}
	

	@Override
	public Long saveCustomerInfo(SsnEnrollment ssnCustomer) {
		SsnEnrollmentEntity entity = new SsnEnrollmentEntity();
		BeanUtils.copyProperties(ssnCustomer, entity);
		SsnEnrollmentEntity savedEntity = repository.save(entity);
		
		BeanUtils.copyProperties(savedEntity, ssnCustomer);
		if(savedEntity!=null) {
			return savedEntity.getSsnId();
		}
		return null;
	}
	
	@Override
	public String checkEnrollmentBySsnId(Long ssn, String stateName) {
		SsnEnrollmentEntity ssnEntity = repository.findBySsnIdAndState(ssn, stateName);
		if(ssnEntity!=null) {
			return "Valid SSN";
		}
		return "InValid SSN";
	}

}
