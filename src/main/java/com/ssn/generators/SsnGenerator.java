package com.ssn.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SsnGenerator implements IdentifierGenerator {

	private static final String selectQuery = " SELECT SSN_ID_SEQ.NEXTVAL FROM DUAL"; 
	
	Long seqVal = null; 

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		try {
			Connection con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			if(rs.next()) {
				seqVal = rs.getLong(1);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return seqVal;
	}

}
