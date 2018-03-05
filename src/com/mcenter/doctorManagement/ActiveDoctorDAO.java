package com.mcenter.doctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import util.ConnectionUtil.ConnectionManager;

import com.mcenter.doctorManagement.DTO.ActiveDoctorDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveDoctorDAO extends ActionSupport {

	
	private String deactivedoctordoctorName;
	private String activeDoctorName;
	 private String dutyHour;
	
	ArrayList<ActiveDoctorDTO> list=new ArrayList<ActiveDoctorDTO>();
	ArrayList<ActiveDoctorDTO> deactivedoctorlist=new ArrayList<ActiveDoctorDTO>();
	
	 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
	  
		public String getDutyHour() {
		return dutyHour;
	}



	public void setDutyHour(String dutyHour) {
		this.dutyHour = dutyHour;
	}



		public String getActiveDoctorName() {
			return activeDoctorName;
		}



		public void setActiveDoctorName(String activeDoctorName) {
			this.activeDoctorName = activeDoctorName;
		}


	public String getDeactivedoctordoctorName() {
		return deactivedoctordoctorName;
	}



	public void setDeactivedoctordoctorName(String deactivedoctordoctorName) {
		this.deactivedoctordoctorName = deactivedoctordoctorName;
	}



	public ArrayList<ActiveDoctorDTO> getList() {
		return list;
	}



	public void setList(ArrayList<ActiveDoctorDTO> list) {
		this.list = list;
	}

	public ArrayList<ActiveDoctorDTO> getDeactivedoctorlist() {
		return deactivedoctorlist;
	}



	public void setDeactivedoctorlist(ArrayList<ActiveDoctorDTO> deactivedoctorlist) {
		this.deactivedoctorlist = deactivedoctorlist;
	}




	PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
   
    
    
     String sql1="select * from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' and status='active'";
     String sql2="select * from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' and status='deactive'";
     



	public String execute() throws Exception{
		//System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
	/*		String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/
	         
	         /*Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
	         
	         ps1 = con.prepareStatement(sql1);
	         ps2 = con.prepareStatement(sql2);
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				ActiveDoctorDTO activedoctor=new ActiveDoctorDTO();
				
				
				
				activedoctor.setDoctorId(rs1.getString(1));
				activedoctor.setDoctorName(rs1.getString(3));
				
				list.add(activedoctor);
				}
			
			
			
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next()){
				
				ActiveDoctorDTO deactivedoctor=new ActiveDoctorDTO();
				
				
				deactivedoctor.setDeactivedoctordoctorId(rs2.getString(1));
				deactivedoctor.setDeactivedoctordoctorName(rs2.getString(3));
				
				deactivedoctorlist.add(deactivedoctor);
				
				
				}
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in ActiveDoctorDAO at execute()");
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
		        if (ps2 != null) {
		        	ps2.close();
		        }
		        
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }
	
}
	

