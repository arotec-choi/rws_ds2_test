package com.arotec.controller.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.ibatis.annotations.Select;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con= DriverManager.getConnection(
				"jdbc:oracle:thin:@arotec.asuscomm.com:9003/arodb",
				"DBO_FINGERBIZ",
				"fingerasdfgh")) {
		System.out.println("db연결성공" +con);
		
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
	
}
