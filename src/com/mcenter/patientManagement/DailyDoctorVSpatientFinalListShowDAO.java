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

import com.mcenter.patientManagement.DTO.DailyDoctorVSpatientFinalListShowDTO;

import com.opensymphony.xwork2.ActionSupport;

public class DailyDoctorVSpatientFinalListShowDAO extends ActionSupport {
	
	
	
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
Date date = new Date();
String Date = dateFormat.format(date);	

private String shift; 
private String fdate;
private String tdate;



public String getShift() {
	return shift;
}


public void setShift(String shift) {
	this.shift = shift;
}


public String getFdate() {
	return fdate;
}


public void setFdate(String fdate) {
	this.fdate = fdate;
}


public String getTdate() {
	return tdate;
}


public void setTdate(String tdate) {
	this.tdate = tdate;
}

ArrayList<DailyDoctorVSpatientFinalListShowDTO> dailydoctorvspatientlist=new ArrayList<DailyDoctorVSpatientFinalListShowDTO>();
	   
	
public ArrayList<DailyDoctorVSpatientFinalListShowDTO> getDailydoctorvspatientlist() {
		return dailydoctorvspatientlist;
	}


	public void setDailydoctorvspatientlist(
			ArrayList<DailyDoctorVSpatientFinalListShowDTO> dailydoctorvspatientlist) {
		this.dailydoctorvspatientlist = dailydoctorvspatientlist;
	}

	 PreparedStatement ps1 = null;
	    
	    
     

public String dailydoctorVSpatient() throws Exception  
	
	{
		//System.out.println("Adnan");
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
		
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			fdate=request.getParameter("fdate");
			tdate=request.getParameter("tdate");		
			/*String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/
			
	     /*    Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/		
	        
		     
             con.setAutoCommit(false);
             
             String sql1="SELECT TO_CHAR (VISITINGDATE, 'dd/mm/yyyy'), " +
            		 "         VISITID, " +
            		 "         PATIENTNAME, " +
            		 "         REFDOCTORNAME, " +
            		 "         PATIENTNUMBER ," +
            		 "         PATIENTID, " +
            		 "         SHIFT " +
            		 "    FROM MCENTER.PATIENT_HISTORY " +
            		 "   WHERE VISITINGDATE BETWEEN TO_DATE ('"+fdate+"', 'dd/mm/yyyy') " +
            		 "                          AND TO_DATE ('"+tdate+"', 'dd/mm/yyyy') " +
            		 "GROUP BY TO_CHAR (VISITINGDATE, 'dd/mm/yyyy'), " +
            		 "         VISITID, " +
            		 "         PATIENTNAME, " +
            		 "         REFDOCTORNAME, " +
            		 "         PATIENTNUMBER, " +
            		 "         PATIENTID, " +
            		 "         SHIFT " +
            		 "ORDER BY TO_CHAR (VISITINGDATE, 'dd/mm/yyyy'),PATIENTNUMBER asc " ;   
            // String sql1="select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),VISITID,PATIENTNAME,REFDOCTORNAME from MCENTER.PATIENT_HISTORY WHERE   VISITINGDATE between to_date('"+fdate+"','mm/dd/yyyy') and to_date('"+tdate+"','mm/dd/yyyy') ORDER BY PATIENTNUMBER";
	         ps1 = con.prepareStatement(sql1);
	         ResultSet rs=ps1.executeQuery();
	         while(rs.next()){
	        	 DailyDoctorVSpatientFinalListShowDTO dp=new DailyDoctorVSpatientFinalListShowDTO();

	                   dp.setVisitingdate(rs.getString(1));
                       dp.setSerialNo(rs.getString(2));
                       dp.setPatient(rs.getString(3));
                       dp.setDoctor(rs.getString(4));
                       dp.setPatientnumber(rs.getInt(5));
                       dp.setPatientID(rs.getString(6));
                       dp.setShift(rs.getString(7));
                       
                       
                       
                       dailydoctorvspatientlist.add(dp);
	        	    
				
	         }
	         
	         con.commit();
	         
	   
	         
	         
	         
		}
		catch(Exception e){
			
		e.printStackTrace();
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in DailyDoctorVSpatientFinalListShowDAO at dailydoctorVSpatient()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();}
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

