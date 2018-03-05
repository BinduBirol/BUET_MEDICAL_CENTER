package com.mcenter.patientManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.ConnectionUtil.ConnectionManager;

public class CreateSerialDAO {
	
	private String shift;
	private String patientName;
	private String assignedDoctor;
	private String assignedDoctorofficialID;
	private String serialNumber;
	private int digitforserialNumber;
	private String patientID;
	private String receiptNO;
	private String serial;
	private int countreceipt;
	
	   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
	
	    PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
	
		public String getShift() {
			return shift;
		}


		public void setShift(String shift) {
			this.shift = shift;
		}


		public String getPatientName() {
			return patientName;
		}


		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}


		public String getAssignedDoctor() {
			return assignedDoctor;
		}


		public void setAssignedDoctor(String assignedDoctor) {
			this.assignedDoctor = assignedDoctor;
		}


		public String getAssignedDoctorofficialID() {
			return assignedDoctorofficialID;
		}


		public void setAssignedDoctorofficialID(String assignedDoctorofficialID) {
			this.assignedDoctorofficialID = assignedDoctorofficialID;
		}


		public String getSerialNumber() {
			return serialNumber;
		}


		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}


		public int getDigitforserialNumber() {
			return digitforserialNumber;
		}


		public void setDigitforserialNumber(int digitforserialNumber) {
			this.digitforserialNumber = digitforserialNumber;
		}


		public String getPatientID() {
			return patientID;
		}


		public void setPatientID(String patientID) {
			this.patientID = patientID;
		}
		
		
	public String getReceiptNO() {
			return receiptNO;
		}


		public void setReceiptNO(String receiptNO) {
			this.receiptNO = receiptNO;
		}


		public String getSerial() {
			return serial;
		}


		public void setSerial(String serial) {
			this.serial = serial;
		}


		public int getCountreceipt() {
			return countreceipt;
		}


		public void setCountreceipt(int countreceipt) {
			this.countreceipt = countreceipt;
		}


	public String createSerialANDassignDoctor(){

		Connection con = ConnectionManager.getConnection();

		try{

	         PreparedStatement ps1=con.prepareStatement("select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy')");
	         ResultSet rs1=ps1.executeQuery();
	         while(rs1.next()){
	            
	        	 digitforserialNumber=rs1.getInt(1);
				
	         }
	 
	         
	         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  	   //get current date time with Date()
	  	   Date serialdate = new Date();
	  	   String DateofSerial = dateFormat.format(serialdate);
	 
	             digitforserialNumber=digitforserialNumber+1; 
	        	 serialNumber=DateofSerial+"-"+"P-"+digitforserialNumber;
    	 
	PreparedStatement ps2=con.prepareStatement("SELECT SID, " +
			"       NAME, " +
			"       OFFICIALID, " +
			"       DUTYHOUR " +
			"  FROM todaydoctor " +
			" WHERE     d_date = TO_DATE ('"+Date+"', 'mm/dd/yyyy') " +
			"       AND STATUS = 'active' " +
			"       AND recommended = 'NO' " +
			"       AND activity = 'idle' " +
			"       AND SHIFT_SATUS = 'running' " +
			"       AND SID = " +
			"              (SELECT MIN (SID) " +
			"                 FROM todaydoctor " +
			"                WHERE     d_date = TO_DATE ('"+Date+"', 'mm/dd/yyyy') " +
			"                      AND STATUS = 'active' " +
			"                      AND recommended = 'NO' " +
			"                      AND activity = 'idle' " +
			"                      AND SHIFT_SATUS = 'running') ");        	 
 
	ResultSet rs2=ps2.executeQuery();
	while(rs2.next()){
	                
		assignedDoctor=rs2.getString(2);
		assignedDoctorofficialID=rs2.getString(3);
		shift=rs2.getString(4);			
	             }

	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}

	
	public String createSerialANDassigndoctorforNONidpatient() throws Exception{
		
		int countPatient=0;

		Connection con = ConnectionManager.getConnection();
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
      		
 			 PreparedStatement ps1=con.prepareStatement("select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy')");
 	         ResultSet rs1=ps1.executeQuery();
 	         while(rs1.next()){
 	            
 	        	 digitforserialNumber=rs1.getInt(1);
 				
 	         }
 	 
 	         
 	         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
 	  	   //get current date time with Date()
 	  	   Date serialdate = new Date();
 	  	   String DateofSerial = dateFormat.format(serialdate);
 	 
 	             digitforserialNumber=digitforserialNumber+1; 
 	        	 serialNumber=DateofSerial+"-"+"P-"+digitforserialNumber;
 			
 			
 			
 		    String sql2="Select count(*) from MCENTER.NONIDPATIENT";
 			
 		 			ps2=con.prepareStatement(sql2);
 		 			ResultSet rs2=ps2.executeQuery();
 		 			while(rs2.next()){

 		 				countPatient=rs2.getInt(1);
 		 				
 		 			   
 		 			}
 		 			countPatient=countPatient+1;
 			
 		 			patientID="TEMP-ID:"+countPatient;
 			
 			
 		 			PreparedStatement ps2=con.prepareStatement("SELECT SID, " +
 		 					"       NAME, " +
 		 					"       OFFICIALID, " +
 		 					"       DUTYHOUR " +
 		 					"  FROM todaydoctor " +
 		 					" WHERE     d_date = TO_DATE ('"+Date+"', 'mm/dd/yyyy') " +
 		 					"       AND STATUS = 'active' " +
 		 					"       AND recommended = 'NO' " +
 		 					"       AND activity = 'idle' " +
 		 					"       AND SHIFT_SATUS = 'running' " +
 		 					"       AND SID = " +
 		 					"              (SELECT MIN (SID) " +
 		 					"                 FROM todaydoctor " +
 		 					"                WHERE     d_date = TO_DATE ('"+Date+"', 'mm/dd/yyyy') " +
 		 					"                      AND STATUS = 'active' " +
 		 					"                      AND recommended = 'NO' " +
 		 					"                      AND activity = 'idle' " +
 		 					"                      AND SHIFT_SATUS = 'running') ");        	 


 
 		 			ResultSet rs3=ps2.executeQuery();
 		 			while(rs3.next()){
 		 			                
 		 				assignedDoctor=rs3.getString(2);
 		 				assignedDoctorofficialID=rs3.getString(3);
 		 				shift=rs3.getString(4);			
 		 			             }
 		 			     	 
             
             
             con.commit(); 
				
				
				
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in TestBillforOthers at insertANDshow()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		       
		       
		        if (ps1!= null) {
		        	ps1.close();
		        }
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	
	
	public String receiptNo() throws Exception{
		
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
              
            String sql3="select count(*) from MCENTER.NEWSTDCHECKUPMONEYRECIPT";
	         ps3 = con.prepareStatement(sql3);
	         
	         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
									
				countreceipt=rs3.getInt(1);
				
			
				}
			
			countreceipt=countreceipt+1;
			receiptNO="ADM-RECPT NO:"+countreceipt;
			 
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }

	
}
