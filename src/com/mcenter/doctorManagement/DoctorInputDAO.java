package com.mcenter.doctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import util.ConnectionUtil.ConnectionManager;

import com.mcenter.doctorManagement.DTO.DoctorInputDTO;




import com.opensymphony.xwork2.ActionSupport;

public class DoctorInputDAO extends ActionSupport {
	
	private int doctorNumber;
	private int doctorNumberTEMP;
	private String activeDoctorName;
	private String dutyHour;
    private int individualdoctorNUmber;
	private String message;
	private String doctorName;
	private int countshiftSTATUS;
	private int countOpenningshiftSTATUS;
	
	   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
	


	public int getCountOpenningshiftSTATUS() {
		return countOpenningshiftSTATUS;
	}



	public void setCountOpenningshiftSTATUS(int countOpenningshiftSTATUS) {
		this.countOpenningshiftSTATUS = countOpenningshiftSTATUS;
	}



	public int getCountshiftSTATUS() {
		return countshiftSTATUS;
	}



	public void setCountshiftSTATUS(int countshiftSTATUS) {
		this.countshiftSTATUS = countshiftSTATUS;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public String getDutyHour() {
		return dutyHour;
	}



	public void setDutyHour(String dutyHour) {
		this.dutyHour = dutyHour;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		
		this.message = message;
	}



	public String getActiveDoctorName() {
		return activeDoctorName;
	}



	public void setActiveDoctorName(String activeDoctorName) {
		this.activeDoctorName = activeDoctorName;
	}

	ArrayList<DoctorInputDTO> list=new ArrayList<DoctorInputDTO>();
	
	public ArrayList<DoctorInputDTO> getList() {
		return list;
	}



	public void setList(ArrayList<DoctorInputDTO> list) {
		this.list = list;
	}

	
	PreparedStatement ps1 = null;
    PreparedStatement ps2 = null;
    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
    PreparedStatement ps5 = null;
    PreparedStatement ps6 = null;
    
    
     String sql1="select * from ESTABLISHMENT.PERSONNEL where CURRENT_DESIGNATION_ID in('Bo5oo07','Bo8oo01','Bo4oo01','E200056') order by CURRENT_DESIGNATION_ID,NAME";
    
     
/*    String sql1=" select * from ESTABLISHMENT.PERSONNEL where CURRENT_DESIGNATION_ID='Bo5oo07'" +
    		"union select * from ESTABLISHMENT.PERSONNEL where CURRENT_DESIGNATION_ID='Bo4oo01'" +
    		"union select * from ESTABLISHMENT.PERSONNEL where CURRENT_DESIGNATION_ID='Bo8oo01'" ;*/
	

	public String execute() throws Exception{
		//System.out.println("Adnan");
		//Connection con = null;
		Connection con = ConnectionManager.getConnection();	
		try{
			
			
		/*	String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/
	         
/*	         Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
             con.setAutoCommit(false);
	         
	         ps1 = con.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				
				DoctorInputDTO dailydoctorinput=new DoctorInputDTO();
				
				dailydoctorinput.setDoctorId(rs.getString(2));
				dailydoctorinput.setDoctorName(rs.getString(3));
				
				list.add(dailydoctorinput);
				
				
				
			}
			
			con.commit();
			
		}catch(Exception e){e.printStackTrace();
		
		if (con != null) {
            try {
            	System.err.println("There is sql exception Mr.Adnan");
                System.out.println(" So...Transaction is being rolled back in  DoctorInputDAO at execute() ");
                con.rollback();
            } 
            catch(SQLException excep) {
                
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
	
	
	
	public String saveActiveDoctor() throws Exception {
		//System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
			/*String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/
	         
	/*         Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	         con.setAutoCommit(false);
	         
	         String sql2="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='"+dutyHour+"'";
	         ps2 = con.prepareStatement(sql2);
	         
	         
	       
	         
	         ResultSet rs=ps2.executeQuery();
	         while(rs.next()){
	        	 
	        	 doctorNumberTEMP=rs.getInt(1);
	        	 
				
	         }
	         
	         doctorNumber=doctorNumberTEMP+1;
	         System.out.println("He/She is doctor Number:"+doctorNumber);
	         
	         String sql4="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='"+dutyHour+"' and OFFICIALID='"+activeDoctorName+"' and SHIFT_SATUS='running' ";
	         ps6 = con.prepareStatement(sql4);
	         
	         ResultSet rs1=ps6.executeQuery();
	         while(rs1.next()){
	        	 
	        	 individualdoctorNUmber=rs1.getInt(1);
	        	 
				
	         }
	         
	    	 String sql11="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='"+dutyHour+"' and SHIFT_SATUS='close'";
	    	 ps1 = con.prepareStatement(sql11);
	    	     	          
	    	     	 ResultSet rs11=ps1.executeQuery();
	    	     	 while(rs11.next()){
	    	     	countshiftSTATUS=rs11.getInt(1);

	    	     	         }
	    	/*   String sql12="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='"+dutyHour+"' and SHIFT_SATUS='running'";
	    	   ps4 = con.prepareStatement(sql12);
	    	        	          
	    	   ResultSet rs12=ps4.executeQuery();
	    	   while(rs12.next()){
	    		   countOpenningshiftSTATUS=rs12.getInt(1);
	    	    	     	        	 
	    	    	     				
	    	    	     	         }*/
	    	     	 if(dutyHour.equalsIgnoreCase("3.30-5.30  PM")){
	    	     		 
	    	     		 String sql12="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='9-12 AM' and SHIFT_SATUS='running'";
	    		    	   ps4 = con.prepareStatement(sql12);
	    		    	        	          
	    		    	   ResultSet rs12=ps4.executeQuery();
	    		    	   while(rs12.next()){
	    		    		   countOpenningshiftSTATUS=rs12.getInt(1);
	    		    	    	     	        	 
	    		    	    	     				
	    		    	    	     	         }
	         
	        	if(individualdoctorNUmber==0 && !activeDoctorName.equalsIgnoreCase("-1")&&countshiftSTATUS==0 &&countOpenningshiftSTATUS==0){
	        		
			 String sql3="INSERT INTO todaydoctor " +
					 "     VALUES ('"+activeDoctorName+"', " +
					 "             '"+doctorNumber+"', " +
					 "             (SELECT NAME " +
					 "                FROM ESTABLISHMENT.PERSONNEL " +
					 "               WHERE OFFICIAL_ID = '"+activeDoctorName+"'), " +
					 "             TO_DATE ('"+Date+"', 'mm/dd/yyyy'), " +
					 "             'active', " +
					 "             'NO', " +
					 "             0, " +
					 "             1, " +
					 "             'idle', " +
					 "             '"+dutyHour+"', " +
					 "             'running', " +
					 "             1) " ;
	         
	                ps3 = con.prepareStatement(sql3);
	         
					ps3.executeUpdate();
					String sql="Select NAME from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+activeDoctorName+"'";
					 ps6 = con.prepareStatement(sql);
			         
			         ResultSet rs8=ps6.executeQuery();
			         while(rs8.next()){
			        	 
			        	 doctorName=rs8.getString(1);
			        	 
						
			         }
	        	}
		
	        	else{
	        		

	        		if(activeDoctorName.equalsIgnoreCase("-1")){
	        		 message="Please Select a Doctor ";
	        		}
	        		
	        		else if(countshiftSTATUS>0){
	        			message="Shift"+dutyHour+"is alrady Closed";
	        			
	        		}
	        		
	        		else if(countOpenningshiftSTATUS>0){
	        			message="Shift 9-12 AM is not closed yet.Close it at first";
	        			
	        		}
	        		
	        		/*else if(countOpenningshiftSTATUS==0){
	        			message="Shift is not Opened yet.";
	        			
	        		}*/
	        		
	        		else{
	        			
	        			message="Doctor is duplicate";
	        	}
	        		System.out.println(message);
	        	}
					
	        	
	    	     	 }
	    	     	 
  	 if(dutyHour.equalsIgnoreCase("9-12 AM")){
	    	     		 
	    	     		 String sql12="select count(*) from todaydoctor where d_date=to_date('"+Date+"','mm/dd/yyyy') and DUTYHOUR='3.30-5.30  PM' and SHIFT_SATUS='running'";
	    		    	   ps4 = con.prepareStatement(sql12);
	    		    	        	          
	    		    	   ResultSet rs12=ps4.executeQuery();
	    		    	   while(rs12.next()){
	    		    		   countOpenningshiftSTATUS=rs12.getInt(1);
	    		    	    	     	        	 
	    		    	    	     				
	    		    	    	     	         }
	         
	        	if(individualdoctorNUmber==0 && !activeDoctorName.equalsIgnoreCase("-1")&&countshiftSTATUS==0 &&countOpenningshiftSTATUS==0){
	        		
			 String sql3="INSERT INTO todaydoctor " +
					 "     VALUES ('"+activeDoctorName+"', " +
					 "             '"+doctorNumber+"', " +
					 "             (SELECT NAME " +
					 "                FROM ESTABLISHMENT.PERSONNEL " +
					 "               WHERE OFFICIAL_ID = '"+activeDoctorName+"'), " +
					 "             TO_DATE ('"+Date+"', 'mm/dd/yyyy'), " +
					 "             'active', " +
					 "             'NO', " +
					 "             0, " +
					 "             1, " +
					 "             'idle', " +
					 "             '"+dutyHour+"', " +
					 "             'running', " +
					 "             1) ";
	         
	                ps3 = con.prepareStatement(sql3);
	         
					ps3.executeUpdate();
					String sql="Select NAME from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+activeDoctorName+"'";
					 ps6 = con.prepareStatement(sql);
			         
			         ResultSet rs8=ps6.executeQuery();
			         while(rs8.next()){
			        	 
			        	 doctorName=rs8.getString(1);
			        	 
						
			         }
	        	}
		
	        	else{
	        		
	        		

	        		
	        		if(activeDoctorName.equalsIgnoreCase("-1")){
	        		 message="Please Select a Doctor ";
	        		}
	        		
	        		else if(countshiftSTATUS>0){
	        			message="Shift'"+dutyHour+"'is alrady Closed";
	        			
	        		}
	        		
	        		
	        		
	        		else if(countOpenningshiftSTATUS>0){
	        			message="Shift 3.30-5.30  PM is Running now.";
	        			
	        		}
	        		
	        		else{
	        			
	        			message="Doctor is duplicate";
	        	}
	        		System.out.println(message);
	        	}
					
	        	
	    	     	 }
	    	     	 
	    	     	 
	    	     	 
					con.commit();
			


		}catch(Exception e){
			
			
			
			e.printStackTrace();
			 if (con != null) {
		            try {
		            	System.err.println("There is sql exception Mr.Adnan");
		                System.out.println(" So...Transaction is being rolled back in DoctorInputDAO at saveActiveDoctor() ");
		                con.rollback();
		            } catch(SQLException excep) {
		                
		                excep.printStackTrace();}
		            }
		
		}
		
		  finally {
		       
			  if (ps2 != null) {
		        	ps2.close();
		        }
		        
		        if (ps3 != null) {
		        	ps3.close();
		        }
		        if (ps4 != null) {
		        	ps4.close();
		        }
		        if (ps5 != null) {
		        	ps5.close();
		        }
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		
		
		return "success";
   }
	
	
	
}
