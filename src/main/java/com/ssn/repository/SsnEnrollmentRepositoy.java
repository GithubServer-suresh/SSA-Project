package com.ssn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssn.entity.SsnEnrollmentEntity;

public interface SsnEnrollmentRepositoy extends JpaRepository<SsnEnrollmentEntity, String>{
	
	public SsnEnrollmentEntity findBySsnIdAndState(Long ssn, String stateName);

}
