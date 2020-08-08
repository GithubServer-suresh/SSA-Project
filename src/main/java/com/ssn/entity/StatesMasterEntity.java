package com.ssn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="STATES_MASTER")
@Data
public class StatesMasterEntity {

	@Id
	@Column(name="STATE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer stateId;
	@Column(name="STATE_NAME")
	private String stateName;
}
