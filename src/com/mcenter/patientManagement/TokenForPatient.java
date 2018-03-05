package com.mcenter.patientManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.mcenter.pharmasistBillManagement.PharmacyMedicineBill;
import com.opensymphony.xwork2.ActionSupport;

public class TokenForPatient extends ActionSupport  {
	
	
	private String doctorID;
	private String doctorName;
	private String medicalID;
	private String patientID;
	private String medicalIDholderName;
	private String departmentID;
	private String department;
	private String patientName;
	private String patientRelationWithIDholder;
	private String visitID;
	private String designation;
	private String shift;
	
	
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	
	
   
	
    
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	   
	       DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
	  	   //get current date time with Date()
	  	   Date serialdate = new Date();
	  	   String DateofSerial = dateFormat1.format(serialdate);
	
	
	
	public String getShift() {
			return shift;
		}



		public void setShift(String shift) {
			this.shift = shift;
		}



	public String getDoctorID() {
			return doctorID;
		}



		public void setDoctorID(String doctorID) {
			this.doctorID = doctorID;
		}



		public String getDoctorName() {
			return doctorName;
		}



		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}



		public String getMedicalID() {
			return medicalID;
		}



		public void setMedicalID(String medicalID) {
			this.medicalID = medicalID;
		}



		public String getPatientID() {
			return patientID;
		}



		public void setPatientID(String patientID) {
			this.patientID = patientID;
		}



		public String getMedicalIDholderName() {
			return medicalIDholderName;
		}



		public void setMedicalIDholderName(String medicalIDholderName) {
			this.medicalIDholderName = medicalIDholderName;
		}



		public String getDepartmentID() {
			return departmentID;
		}



		public void setDepartmentID(String departmentID) {
			this.departmentID = departmentID;
		}



		public String getDepartment() {
			return department;
		}



		public void setDepartment(String department) {
			this.department = department;
		}



		public String getPatientName() {
			return patientName;
		}



		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}



		public String getPatientRelationWithIDholder() {
			return patientRelationWithIDholder;
		}



		public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
			this.patientRelationWithIDholder = patientRelationWithIDholder;
		}



		public String getVisitID() {
			return visitID;
		}



		public void setVisitID(String visitID) {
			this.visitID = visitID;
		}



		public String getDesignation() {
			return designation;
		}



		public void setDesignation(String designation) {
			this.designation = designation;
		}



		public String getDateofSerial() {
			return DateofSerial;
		}



		public void setDateofSerial(String dateofSerial) {
			DateofSerial = dateofSerial;
		}



	public String report(String visitID) throws Exception{
		System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			/*HttpServletRequest request = ServletActionContext.getRequest();
			visitID=request.getParameter("visitID");*/
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
                       
         /*    String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
	         ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				
				
				
				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
				
				}*/
			
			
			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT  from MCENTER.PATIENT_HISTORY where VISITID='"+visitID+"'";
	            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			   PreparedStatement ps12 = con.prepareStatement(sql12);
		         
		         
				ResultSet rs12=ps12.executeQuery();
				while(rs12.next()){
					
			
					medicalID=rs12.getString(1);
					patientID=rs12.getString(2);
					patientName=rs12.getString(3);
					doctorID=rs12.getString(4);
					shift=rs12.getString(5);
					}
			
				if(medicalID!=null){
				
			  if(medicalID.equals(patientID))
		         {
				  patientRelationWithIDholder="Self"; 
		        	 
		         }
		         
		         else{
		        	 
		        	
		         PreparedStatement ps11=con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='"+patientID+"'  ");
		         ResultSet rs11=ps11.executeQuery();
		         while(rs11.next()){
		        	     
		        	 patientRelationWithIDholder=rs11.getString(6); 
		                   
		         }       
		        	    
		         
		         }
				}
			
		//System.out.println(medicalID);
			//////////////////////////////////////////////	/
		      String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' UNION  SELECT TEMPID id, NAME name,DEPT departmentname,DESIGNATION  DESIGNATION FROM MCENTER.NONIDPATIENT   WHERE MCENTER.NONIDPATIENT.TEMPID = '"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1"; 
			 // String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
		        ps2 = con.prepareStatement(sql2);
		         
		         
				 ResultSet rs2=ps2.executeQuery();
				 while(rs2.next()){
					
					
					
					
					
					 medicalIDholderName=rs2.getString(2);
			         department=rs2.getString(3);
					 designation=rs2.getString(4);
					
					}
				 
				 if(designation==null)
				 {
					 designation="Student";	 
					 
				 }
			  
			
			 System.out.println(doctorID);
				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
		        ps3 = con.prepareStatement(sql3);
		         
		         
				 ResultSet rs3=ps3.executeQuery();
				 while(rs3.next()){
					
					
					
					
					
					 doctorName=rs3.getString(3);
					
					}
			
			
			
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
		        if (ps1!= null) {
		        	ps1.close();
		        }
		       
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }
	
	

}
