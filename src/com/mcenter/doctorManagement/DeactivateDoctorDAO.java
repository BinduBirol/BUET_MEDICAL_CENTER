package com.mcenter.doctorManagement;

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

public class DeactivateDoctorDAO extends ActionSupport {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 2282775401176254696L;
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
    
    private String activeDoctorName;
    private String deactiveDoctorName;
    private String doctorName;
    private String message;
  
    private int condition1;
	
	
	
	private int maximumrecommendNumber;
	private int roundNumber;
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getCondition1() {
		return condition1;
	}
	public void setCondition1(int condition1) {
		this.condition1 = condition1;
	}
	public int getMaximumrecommendNumber() {
		return maximumrecommendNumber;
	}
	public void setMaximumrecommendNumber(int maximumrecommendNumber) {
		this.maximumrecommendNumber = maximumrecommendNumber;
	}
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public String getActiveDoctorName() {
			return activeDoctorName;
		}

	public void setActiveDoctorName(String activeDoctorName) {
			this.activeDoctorName = activeDoctorName;
		}
	public String getDeactiveDoctorName() {
			return deactiveDoctorName;
		}
    public void setDeactiveDoctorName(String deactiveDoctorName) {
			this.deactiveDoctorName = deactiveDoctorName;
		}
	
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	    PreparedStatement ps6 = null;
	   
	public String deactiveDoctor() throws Exception {
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
    	
   	 try{
   	/*	String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/
         
       /*  Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
         con.setAutoCommit(false);
         
              
		   PreparedStatement ps9=con.prepareStatement("SELECT count(*) as condition1 FROM todaydoctor    WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') AND activity='idle' and  STATUS='active' AND recommended='NO' ");
			 ResultSet rs9=ps9.executeQuery();
			 while(rs9.next()){
			                         
				 condition1=rs9.getInt("condition1");//active+not recomended
			             			
			                      }
			 if(!activeDoctorName.equalsIgnoreCase("-1") ){
		   
         String sql1="UPDATE todaydoctor SET status='deactive',activity='busy' WHERE OFFICIALID='"+activeDoctorName+"' and SHIFT_SATUS='running' and d_date=to_date('"+Date+"','mm/dd/yyyy')";
         
         ps3 = con.prepareStatement(sql1);
         ps3.executeUpdate();
         
         String sql="Select NAME from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+activeDoctorName+"'";
		 ps6 = con.prepareStatement(sql);
         
         ResultSet rs8=ps6.executeQuery();
         while(rs8.next()){
        	 
        	 doctorName=rs8.getString(1);
        	 	
         }
         
///////////////////////////////////////////////////////////////
           
         if(condition1==1)
		 {
        	 
			 PreparedStatement ps10=con.prepareStatement("UPDATE todaydoctor SET activity='idle' WHERE  activity='busy'and STATUS='active' AND recommended='NO'and d_date=to_date('"+Date+"','mm/dd/yyyy')");
	         ps10.executeUpdate();
	         
	         			 
	         PreparedStatement ps6=con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' ");
			 ResultSet rs6=ps6.executeQuery();
			 while(rs6.next()){
			                         
				 maximumrecommendNumber=rs6.getInt(7);
				 roundNumber=rs6.getInt(8);
				  
				
				int roundNumberTEMP=roundNumber+1;
				 PreparedStatement ps5=con.prepareStatement("UPDATE todaydoctor SET  roundnumber='"+roundNumberTEMP+"'  WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  roundnumber='"+roundNumber+"' and  STATUS='active' ");
		         ps5.executeUpdate();
				   
				}
			 
			 
			    PreparedStatement ps7=con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  roundnumber>recommendNumber and d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' ");
				ps7.executeUpdate(); 
        	 
        	 
        	 
		 }
                 
         
       
		/*
         PreparedStatement ps8=con.prepareStatement("SELECT count(*) as condition1 FROM todaydoctor   WHERE d_date='"+Date+"' and  STATUS='active'  AND activity='busy'  ");
		 ResultSet rs8=ps8.executeQuery();
		 while(rs8.next()){
		                         
			 condition1=rs8.getInt("condition1");//active+busy
		             			
		                      }
		 
		 PreparedStatement ps9=con.prepareStatement("SELECT count(*) as condition2 FROM todaydoctor    WHERE d_date='"+Date+"' and  STATUS='active' AND recommended='NO' ");
		 ResultSet rs9=ps9.executeQuery();
		 while(rs9.next()){
		                         
			 condition2=rs9.getInt("condition2");//active+not recomended
		             			
		                      }
		 
		 
		 
		 System.out.println(condition1);
		 System.out.println(condition2);
		 if(condition1>=condition2)
		 {
			 
			 
			 
			  PreparedStatement ps11=con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date='"+Date+"' and  STATUS='active' ");
				 ResultSet rs11=ps11.executeQuery();
				 while(rs11.next()){
				                         
					 
				int	 roundNumberTEMPORARY=rs11.getInt(8);
				int roundNumberTEMP=roundNumberTEMPORARY+1;
				
				
				 PreparedStatement ps3=con.prepareStatement("SELECT count(*) as CountIDLEnumber FROM todaydoctor   WHERE d_date='"+Date+"' and  STATUS='active'  AND activity='idle'  ");
				 ResultSet rs3=ps3.executeQuery();
				 while(rs3.next()){
				                         
					 countIDLEnumber=rs3.getInt("CountIDLEnumber");//active+busy
				             			
				                      }
					
				 if(countIDLEnumber==0){
					 PreparedStatement ps12=con.prepareStatement("UPDATE todaydoctor SET  roundnumber='"+roundNumberTEMP+"'  WHERE  d_date='"+Date+"' and  roundnumber='"+roundNumberTEMPORARY+"' and STATUS='active' ");
			         ps12.executeUpdate();
			         
				 }
			         
				 }
			 
			 
			 
			 PreparedStatement ps10=con.prepareStatement("UPDATE todaydoctor SET activity='idle' WHERE  activity='busy'and STATUS='active' AND recommended='NO'and d_date='"+Date+"'");
	         ps10.executeUpdate();
	         
	         
	      */   
			 }  
			 
			 
			 else{
	        			        		
	        		if(activeDoctorName.equalsIgnoreCase("-1")){
	        		 message="Please Select a Doctor ";
	        		}
	        		
	        	
	        		System.out.println(message);
	        	}
         con.commit(); 
		 
         
		 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		        
				
		        if (con != null) {
		            try {
		            	System.err.println("There is sql exception Mr.Adnan");
		                System.out.println(" So...Transaction is being rolled back in DeactivateDoctorDAO at deactiveDoctor()");
		                con.rollback();
		            } catch(SQLException excep) {
		                
		                excep.printStackTrace();}
		            }
		 
		 
		 }
   	 
     finally {
	        if (ps3!= null) {
	        	ps3.close();
	        }
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
   	 
   	 
   	 
   	 

        return SUCCESS;
    }
	
	
	
	public String activeDoctor() throws Exception {
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
    	
   	 try{
   		/*String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/
         
         
  /*       Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
      
         con.setAutoCommit(false);
         if( !deactiveDoctorName.equalsIgnoreCase("-1") ){
         
         String sql2="UPDATE todaydoctor SET status='active',activity='idle' WHERE OFFICIALID='"+deactiveDoctorName+"' and SHIFT_SATUS='running' and d_date=to_date('"+Date+"','mm/dd/yyyy')";
         ps2 = con.prepareStatement(sql2);
         ps2.executeUpdate();
         
         
         String sql="Select NAME from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+deactiveDoctorName+"'";
		 ps6 = con.prepareStatement(sql);
         
         ResultSet rs8=ps6.executeQuery();
         while(rs8.next()){
        	 
        	 doctorName=rs8.getString(1);
        	 
			
         }
         
         }
         
         
		 else{
        			        		
        		if(deactiveDoctorName.equalsIgnoreCase("-1")){
        		 message="Please Select a Doctor ";
        		}
        		
        	
        		System.out.println(message);
        	}
         con.commit();
		 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		        
				
		        if (con != null) {
		            try {
		            	System.err.println("There is sql exception Mr.Adnan");
		                System.out.println(" So...Transaction is being rolled back in DeactivateDoctorDAO at activeDoctor()");
		                con.rollback();
		            } catch(SQLException excep) {
		                
		                excep.printStackTrace();}
		            }
		 
		 
		 }
	 
  finally {
	        if (ps2!= null) {
	        	ps2.close();
	        }
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
		 

        return SUCCESS;
    }
	
	
	
	
}
