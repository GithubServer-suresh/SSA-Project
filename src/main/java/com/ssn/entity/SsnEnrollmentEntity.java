package com.ssn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Table(name="SSN_MASTER")
@Entity
public class SsnEnrollmentEntity {

	@Id
	@Column(name="SSN_Number")
	@GenericGenerator(strategy="com.ssn.generators.SsnGenerator",name="ssn_id_gen")
	@GeneratedValue(generator="ssn_id_gen")
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE)*/
	private Long ssnId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private Character gender;
	@Column(name="DOB")
	private Date dob;
	@Column(name="STATE")
	private String state;
	@Column(name="CREATED_DATE",updatable=false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createdDate;
	@Column(name="UPDATED_DATE",insertable=false)
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date updatedDate;
	
	
	
}
