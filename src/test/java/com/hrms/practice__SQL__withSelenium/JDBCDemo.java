package com.hrms.practice__SQL__withSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * while(rset.next()) {
			firstname = rset.getString("emp_firstname");
			System.out.println(firstname);
		}  using with while you can print all names
 */

public class JDBCDemo {
	
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	//jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	//@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees");
		
		//first row
		rs.next();
		String firstname = rs.getString("emp_firstname");
		System.out.println(firstname);
		
		
		//second row
		rs.next();
		String firstname2 = rs.getObject("emp_firstname").toString();
		System.out.println(firstname2);
		
		
		// all data from one column
		String allData;
		while(rs.next()) {
			allData = rs.getObject("Emp_firstname").toString();
			System.out.println(allData);
		}
		rs.close();
		st.close();
		conn.close();
	}
	
	// retrieve all the job titles and store them in arraylist and show it in 
	//console it from arraylist
	@Test
	public void listTask() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("DB connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		List<String> jobTitles = new ArrayList<>();
		while(rs.next()) {
			jobTitles.add(rs.getObject("job_title").toString());
		}
		System.out.println(jobTitles);
		for (String jt : jobTitles) {
			System.out.println(jt);
		}
		
	}
	}


