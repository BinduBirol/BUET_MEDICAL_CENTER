package store.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil.ConnectionManager;

public class TestDAO {
	
	

	PreparedStatement ps1 = null;
	
	ArrayList<TestDTO> testlist=new ArrayList<TestDTO>();
	
	
	public ArrayList<TestDTO> getTestlist() {
		return testlist;
	}


	public void setTestlist(ArrayList<TestDTO> testlist) {
		this.testlist = testlist;
	}


	public String testTABLE() throws Exception{
		
		
		
		System.out.println(" hi...Adnan");
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
             
                   
			
	String sql="SELECT MCENTER.TESTTYPE.TESTTYPEID,TESTTYPENAME,TESTID, " +
			"         TESTNAME, " +
			"         VAT, " +
			"         RATE  " +
			"    FROM MCENTER.TESTS, MCENTER.TESTTYPE " +
			"   WHERE MCENTER.TESTS.TESTTYPEID  = MCENTER.TESTTYPE.TESTTYPEID " +
			"GROUP BY MCENTER.TESTTYPE.TESTTYPEID,TESTTYPENAME,TESTID, " +
			"         TESTNAME, " +
			"         VAT, " +
			"         RATE  " +
			"ORDER BY MCENTER.TESTTYPE.TESTTYPEID " ;
		
			ps1=con.prepareStatement(sql);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				             
				TestDTO test=new TestDTO();
				
				test.setTestTypeID(rs.getString(1));
				test.setTestType(rs.getString(2));
				test.setTestNameID(rs.getString(3));
				test.setTestName(rs.getString(4));
				test.setVat(rs.getDouble(5));
				test.setRate(rs.getDouble(6));
			
				testlist.add(test);
						
				
			}
				
				
		
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at medicineTABLE()");
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
