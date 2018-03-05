package com.mcenter.totalBill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TotalBillofStudent {

	
	private String medicalID;
	private String name;
	private String department;
	private String designation;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getMedicalID() {
		return medicalID;
	}



	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}



	public String searchPerson(){
		System.out.println("HIT:"+medicalID);
		Connection con = null;
		
		try{
					
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
			
	        
	         
	         PreparedStatement ps=con.prepareStatement("select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'  ");
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()){
	        	     
	        	 name=rs.getString(2);
	        	 department=rs.getString(3);
	        	 designation=rs.getString(5);
	             	        	    
				
	         }
	         	         
	         
	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}
	
	
	
}
