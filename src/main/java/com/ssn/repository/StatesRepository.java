package com.ssn.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssn.entity.StatesMasterEntity;

public interface StatesRepository extends JpaRepository<StatesMasterEntity, Serializable> {

	@Query(value= "select stateName from StatesMasterEntity")
	public List<String> findAllStateNames();
	
}
