package com.mcenter.doctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleBack {

	
    
    
  
    
	public static void main(String[] args) throws Exception {
		
		PreparedStatement ps1 = null;
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	    
	    
	     String sql1="INSERT INTO rolebackTEST VALUES('Adnan',1)";
	     String sql2="INSERT INTO rolebackTEST VALUES('Moin',2)";
	     String sql3="INSERT INTO rolebackTEST VALUES('Abir',b)";
	    
		Connection con = null;
		try{
			
			String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");
	         
	         con.setAutoCommit(false);
	         
	         ps1 = con.prepareStatement(sql1);
	         ps2 = con.prepareStatement(sql2);
	         ps3 = con.prepareStatement(sql3);
	         
	         ps1.executeUpdate();
	         ps2.executeUpdate();
	         ps3.executeUpdate();
				
		
	          con.commit();
					
					
				}
		
		
		    catch (SQLException e ) {
	        
	        e.printStackTrace();
	        
		
	        if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();}
	            }
		    }
	     finally {
	        if (ps1!= null) {
	        	ps1.close();
	        }
	        if (ps2 != null) {
	        	ps2.close();
	        }
	        
	        if (ps3 != null) {
	        	ps3.close();
	        }
	        con.setAutoCommit(true);
	        con.close();
	    }

	}
}