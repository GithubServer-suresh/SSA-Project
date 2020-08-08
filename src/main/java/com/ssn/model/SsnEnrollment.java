package com.ssn.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SsnEnrollment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7114415908647980018L;

	
	private String firstName;
	private String lastName;
	private Character gender;
	private Date dob;
	private String state;
	
}
