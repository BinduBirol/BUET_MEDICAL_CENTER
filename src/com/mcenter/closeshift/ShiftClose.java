package com.mcenter.closeshift;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.ConnectionUtil.ConnectionManager;

import com.opensymphony.xwork2.ActionSupport;

public class ShiftClose extends ActionSupport {
	   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
    
    private String shift;
	
	    public String getShift() {
		return shift;
	}




	public void setShift(String shift) {
		this.shift = shift;
	}




		PreparedStatement ps1 = null;
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	   
	    
		

	public String closeshift() throws Exception {
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
    	
   	 try{
   	/*	String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/
         
       /*  Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
         con.setAutoCommit(false);
         
                 
         String sql1="UPDATE todaydoctor SET status='deactive',activity='busy',SHIFT_SATUS='close' WHERE DUTYHOUR='"+shift+"' and d_date=to_date('"+Date+"','mm/dd/yyyy')";
         
         ps1 = con.prepareStatement(sql1);
         ps1.executeUpdate();
         
       
         
///////////////////////////////////////////////////////////////
         
       
         
        
	         
         con.commit(); 
		 
         
		 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		        
				
		        if (con != null) {
		            try {
		            	System.err.println("There is sql exception Mr.Adnan");
		                System.out.println(" So...Transaction is being rolled back in ShiftClose  at closeshift()");
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
   	 
   	 
   	 
   	 

        return SUCCESS;
    }
	
	
	
}
