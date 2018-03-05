package com.mcenter.doctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotRoleback {

	
	public static void main(String[] args) throws SQLException {
		

		PreparedStatement ps1 = null;
	    PreparedStatement ps2 = null;
	    PreparedStatement ps3 = null;
	    
	    
	     String sql1="INSERT INTO rolebackTEST VALUES('Adnan',1)";
	     String sql2="INSERT INTO rolebackTEST VALUES('Shoroni',2)";
	     String sql3="INSERT INTO rolebackTEST VALUES('Aroni',b)";
	    
		Connection con = null;
		try{
			
			String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");
	         
	         
	         
	         ps1 = con.prepareStatement(sql1);
	         ps2 = con.prepareStatement(sql2);
	         ps3 = con.prepareStatement(sql3);
	         
	         ps1.executeUpdate();
	         ps2.executeUpdate();
	         ps3.executeUpdate();
				
		
	          
					
					
				}
		
		
	        catch(Exception e)
	        {e.printStackTrace();}
		
		finally{
			
			if (con!= null) {
				con.close();
	        }
			
			
			
		}

	}

}
