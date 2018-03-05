package com.mcenter.labtestBillManagement;

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



import com.mcenter.report.TokenforOutsiderTestPatient1;
import com.opensymphony.xwork2.ActionSupport;

public class TestBillforOthers extends ActionSupport  {
	private String serial;
	private String patientID;
	private String patientname;
	private String visitID;
	private String serialNumber;
	private String refDoctor;
	private String designation;
	private String ageStr;
	private String gender;
	private String testType;
	private String testTypeID;
	private String testTypeName;
	private String testID;
	private String testName;	
	private double rate;
	private double cost;
	private double vat;
	private double total;
	private double temp;
	private String alltestType;
	private int alltestTypeID;
	private String inword;
	
	
	private ArrayList<TestBillforOthers> TestBillforOtherslist= new ArrayList<TestBillforOthers>();
	private ArrayList<String> testtypeNamelist= new ArrayList<String>();
	private ArrayList<String>testtypeIDlist= new ArrayList<String>();
	private ArrayList<String> testNamelist= new ArrayList<String>();
	private ArrayList<String>testIDlist= new ArrayList<String>();
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
	   DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
	   //get current date time with Date()
	   Date date1 = new Date();
	   String Date1 = dateFormat1.format(date1);
	


public String getInword() {
		return inword;
	}

	public void setInword(String inword) {
		this.inword = inword;
	}

public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

public String getAgeStr() {
		return ageStr;
	}

	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}

public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

public String getTestTypeID() {
		return testTypeID;
	}

	public void setTestTypeID(String testTypeID) {
		this.testTypeID = testTypeID;
	}

public String getTestTypeName() {
		return testTypeName;
	}

	public void setTestTypeName(String testTypeName) {
		this.testTypeName = testTypeName;
	}

public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}

public int getAlltestTypeID() {
		return alltestTypeID;
	}

	public void setAlltestTypeID(int alltestTypeID) {
		this.alltestTypeID = alltestTypeID;
	}

public String getAlltestType() {
		return alltestType;
	}

	public void setAlltestType(String alltestType) {
		this.alltestType = alltestType;
	}



public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}

	public String getRefDoctor() {
		return refDoctor;
	}

	public void setRefDoctor(String refDoctor) {
		this.refDoctor = refDoctor;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

public ArrayList<TestBillforOthers> getTestBillforOtherslist() {
		return TestBillforOtherslist;
	}

	public void setTestBillforOtherslist(
			ArrayList<TestBillforOthers> testBillforOtherslist) {
		TestBillforOtherslist = testBillforOtherslist;
	}



public ArrayList<String> getTesttypeNamelist() {
		return testtypeNamelist;
	}

	public void setTesttypeNamelist(ArrayList<String> testtypeNamelist) {
		this.testtypeNamelist = testtypeNamelist;
	}

	

public ArrayList<String> getTesttypeIDlist() {
		return testtypeIDlist;
	}

	public void setTesttypeIDlist(ArrayList<String> testtypeIDlist) {
		this.testtypeIDlist = testtypeIDlist;
	}

public ArrayList<String> getTestNamelist() {
		return testNamelist;
	}

	public void setTestNamelist(ArrayList<String> testNamelist) {
		this.testNamelist = testNamelist;
	}

	

public ArrayList<String> getTestIDlist() {
		return testIDlist;
	}

	public void setTestIDlist(ArrayList<String> testIDlist) {
		this.testIDlist = testIDlist;
	}

public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	

	public String createSerial() throws Exception{
		int count=0;
		int countPatient=0;
		
		
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
            String sql1="Select count(*) from MCENTER.TESTFOROUTSIDER where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy')";
 			
 			ps1=con.prepareStatement(sql1);
 			ResultSet rs1=ps1.executeQuery();
 			while(rs1.next()){
 				
 			
 			
 				count=rs1.getInt(1);
 			   
 			}
 			count=count+1;	
 			serial=Date1+":OTP:"+count;
 			
 			
 			
 		    String sql2="Select count(*) from MCENTER.TESTFOROUTSIDER";
 			
 		 			ps2=con.prepareStatement(sql2);
 		 			ResultSet rs2=ps2.executeQuery();
 		 			while(rs2.next()){
 		 				
 		 			
 		 			
 		 				countPatient=rs2.getInt(1);
 		 			   
 		 			}
 			
 		 			patientID="OTP:"+countPatient;
 			
 			
 			
             
             
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
	
	
	
	public String patiententry() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String apatientName=request.getParameter("patientname");
		String apatientsex=request.getParameter("gender");
		String apatientDateofBirth=request.getParameter("dob");
		String apatientID=request.getParameter("patientlId");
		String apatientdesignation=request.getParameter("designation");
		String areferenceddoctor=request.getParameter("doctor");
		String aserialnumber=request.getParameter("serialNo");
		String dob;
			
			System.out.println(" hi...Adnan");
			//System.out.println(serialNO);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		         
		      
	             con.setAutoCommit(false);
	            
	           
	             
	             
	             
	          if(apatientName!=null&& apatientdesignation!=null){   
	           
	            ps1=con.prepareStatement("INSERT INTO MCENTER.TESTFOROUTSIDER VALUES('"+apatientName+"','"+apatientID+"','"+apatientdesignation+"','"+areferenceddoctor+"','"+aserialnumber+"','"+apatientsex+"',to_date('"+apatientDateofBirth+"','mm/dd/yyyy'),to_date('"+Date+"','mm/dd/yyyy'))");
				ps1.executeUpdate(); 
	             
	          }  
	          
	          
	          
	          String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTNAME,PATIENTID,DESIGNATION,REFERENCEDDOCTOR,GENDER,SERIALNUMBER from MCENTER.TESTFOROUTSIDER where SERIALNUMBER='"+aserialnumber+"'";
	 			
	 			ps2=con.prepareStatement(sql1);
	 			ResultSet rs1=ps2.executeQuery();
	 			while(rs1.next()){
	 				
	 			
	 				patientname=rs1.getString("PATIENTNAME");
	 				patientID=rs1.getString("PATIENTID");
	 				designation=rs1.getString("DESIGNATION");
	 				refDoctor=rs1.getString("REFERENCEDDOCTOR");
	  				gender=rs1.getString("GENDER");
	  				serialNumber=rs1.getString("SERIALNUMBER");
	 				dob=rs1.getString("DOB");
	 				
	 				org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
					
					org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
					org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
					org.joda.time.DateTime now = new org.joda.time.DateTime();
					org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
					
					ageStr = java.lang.String.valueOf (age.getYears());
	          
	       }
	 			TokenforOutsiderTestPatient1  a= new TokenforOutsiderTestPatient1 ();
	 			 a.report(patientname,patientID,designation,refDoctor,gender,ageStr,serialNumber);
	 			
	 			
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
	
	
	
	
	public String searchpatient() throws Exception{
		
		String dob;
		
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
            String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTNAME,PATIENTID,DESIGNATION,REFERENCEDDOCTOR,GENDER,SERIALNUMBER from MCENTER.TESTFOROUTSIDER where SERIALNUMBER='"+visitID+"'";
 			
 			ps1=con.prepareStatement(sql1);
 			ResultSet rs1=ps1.executeQuery();
 			while(rs1.next()){
 				
 			
 				patientname=rs1.getString("PATIENTNAME");
 				patientID=rs1.getString("PATIENTID");
 				visitID=rs1.getString("SERIALNUMBER");
 				designation=rs1.getString("DESIGNATION");
 				refDoctor=rs1.getString("REFERENCEDDOCTOR");
  				gender=rs1.getString("GENDER");
 				dob=rs1.getString("DOB");
 				
 				org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
				
				org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
				org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
				org.joda.time.DateTime now = new org.joda.time.DateTime();
				org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
				
				ageStr = java.lang.String.valueOf (age.getYears());
 				
 				
 				
 				
 			   
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
		
	
	
	public String testType() throws Exception{
		
	
			//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		         
		      
	             con.setAutoCommit(false);
	            
	      
	             
	             
	             
	            String sql1="Select * from MCENTER.TESTTYPE";
	 			
	 			ps1=con.prepareStatement(sql1);
	 			ResultSet rs1=ps1.executeQuery();
	 			while(rs1.next()){
	 				
	 			
	 			 testtypeIDlist.add(rs1.getString(1));
	 			 testtypeNamelist.add(rs1.getString(2));
	 				
	 				
				
	             
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

	public String test() throws Exception{
		
		
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
            String sql1="Select * from MCENTER.TESTS where TESTTYPEID='"+testType+"'";
 			
 			ps1=con.prepareStatement(sql1);
 			ResultSet rs1=ps1.executeQuery();
 			while(rs1.next()){
 				
 			
 			testNamelist.add(rs1.getString(1));
 			testIDlist.add(rs1.getString(8));
 			   
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
	
public String insertANDshow() throws Exception{
		
	HttpServletRequest request = ServletActionContext.getRequest();
	
	visitID=request.getParameter("visitID");
	patientID=request.getParameter("patientId");
	String testypename[]=request.getParameterValues("testypename");
	String testname[]=request.getParameterValues("testname");
	 
		
//		System.out.println(" hi...Adnan");
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
            if(testypename!=null&& testname!=null){ 
   			for(int i=0;i<testname.length;i++) { 
                
   	        ps1=con.prepareStatement("INSERT INTO MCENTER.TESTSAVEFOROUTSIDERPATIENT VALUES('"+visitID+"','"+testypename[i]+"','"+testname[i]+"','"+patientID+"')");
  			ps1.executeUpdate(); 
  			
  			System.out.println(" hi...Adnan....inserted");
   						 
   			              }
             }
             
/*          if(testID!=null&& patientID!=null){   
           
            ps1=con.prepareStatement("INSERT INTO MCENTER.TESTSAVEFOROUTSIDERPATIENT VALUES('"+visitID+"','"+testType+"','"+testID+"','"+patientID+"')");
			ps1.executeUpdate(); 
			
			System.out.println(" hi...Adnan....inserted");
             
          }*/
          
          
     
          
      ////////////////////////////////////////////////    
             
            String sql3="Select * from MCENTER.TESTSAVEFOROUTSIDERPATIENT where VISITID='"+visitID+"'";
 			
 			ps3=con.prepareStatement(sql3);
 			ResultSet rs3=ps3.executeQuery();
 			while(rs3.next()){
 	//////////////////////////////////////////////////			
 				
 				 String testtypeid=rs3.getString(2);
 				 String testid=rs3.getString(3);
 				 
 	 				
  			     String sql2="Select * from MCENTER.TESTS where TESTID=lpad('" + testid + "',2,'0') and TESTTYPEID=lpad('" + testtypeid + "',2,'0') " ;
   				
   				ps2=con.prepareStatement(sql2);
   				ResultSet rs2=ps2.executeQuery();
   				while(rs2.next()){
   					testTypeID=rs2.getString(7);  					
   					testName=rs2.getString(1);
   					rate=rs2.getDouble(4);
					vat=rs2.getDouble(5);
   									}
  ///////////////////////////////////////////////////////////////////// 				
  				
   					
      String sql4="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
   				
   				ps4=con.prepareStatement(sql4);
   				ResultSet rs4=ps4.executeQuery();
   				while(rs4.next()){
   					  					
   					testTypeName=rs4.getString(2);
   							}				
   System.out.println("testTypeName:"+testTypeName);					
//////////////////////////////////////////////////////////////////////////////////   				
 				
   				 cost=((vat*rate)/100)+rate;
				 temp= cost;
				 total =total+temp;
   				
 				TestBillforOthers tbill=new TestBillforOthers();
 				
 				tbill.setVisitID(rs3.getString(1));
 				tbill.setTestType(testTypeName);
 			  
  					
 				
 				tbill.setTestName(testName);
 				tbill.setPatientID(rs3.getString(4));
 				tbill.setRate(rate);
 				tbill.setCost(cost);
 				tbill.setVat(vat);
 				tbill.setTotal(total);
 				//a=rs2.getString(16);
 			    //	b=rs2.getInt(17);
 				
 				TestBillforOtherslist.add(tbill);	
 				
             
 			}
				
				
    ////////////////////////////////////////     
 		   String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTNAME,DESIGNATION,REFERENCEDDOCTOR,GENDER from MCENTER.TESTFOROUTSIDER where SERIALNUMBER='"+visitID+"'";
			
			ps1=con.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				String dob;
			
				patientname=rs1.getString("PATIENTNAME");
				designation=rs1.getString("DESIGNATION");
				refDoctor=rs1.getString("REFERENCEDDOCTOR");
 				gender=rs1.getString("GENDER");
				dob=rs1.getString("DOB");
				
				org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
				
				org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
				org.joda.time.DateMidnight birthdate = new org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
				org.joda.time.DateTime now = new org.joda.time.DateTime();
				org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
				
				ageStr = java.lang.String.valueOf (age.getYears());
				
				
				
				
			   
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
	
public String report(String visitID) throws Exception{
	
	
	
	//HttpServletRequest request = ServletActionContext.getRequest();
	
	//visitID=request.getParameter("serialNo");
	
	//patientID=request.getParameter("patientlId");
	 
		
		System.out.println(" hi...Adnan.....PDF");
		System.out.println("Send Visit ID:"+visitID);
		Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
          
      ////////////////////////////////////////////////    
             
            String sql3="Select * from MCENTER.TESTSAVEFOROUTSIDERPATIENT where VISITID='"+visitID+"'";
 			
 			ps3=con.prepareStatement(sql3);
 			ResultSet rs3=ps3.executeQuery();
 			while(rs3.next()){
 	//////////////////////////////////////////////////			
 				
 				 String testid=rs3.getString(3);
 				 String testtypeid=rs3.getString(2);
 	 				
  			     String sql2="Select * from MCENTER.TESTS where TESTID='"+testid+"' and TESTTYPEID='"+testtypeid+"' ";
   				
   				ps2=con.prepareStatement(sql2);
   				ResultSet rs2=ps2.executeQuery();
   				while(rs2.next()){
   					testTypeID=rs2.getString(7);  					
   					testName=rs2.getString(1);
   					rate=rs2.getDouble(4);
					vat=rs2.getDouble(5);
   									}
  ///////////////////////////////////////////////////////////////////// 				
  				
   					
      String sql4="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"'";
   				
   				ps4=con.prepareStatement(sql4);
   				ResultSet rs4=ps4.executeQuery();
   				while(rs4.next()){
   					  					
   					testTypeName=rs4.getString(2);
   							}				
   System.out.println("testTypeName:"+testTypeName);					
//////////////////////////////////////////////////////////////////////////////////   				
 				
   				 cost=((vat*rate)/100)+rate;
				 temp= cost;
				 total =total+temp;
   				
 				TestBillforOthers tbill=new TestBillforOthers();
 				
 				tbill.setVisitID(rs3.getString(1));
 				tbill.setTestType(testTypeName);
 			  
  					
 				
 				tbill.setTestName(testName);
 				tbill.setPatientID(rs3.getString(4));
 				tbill.setRate(rate);
 				tbill.setCost(cost);
 				tbill.setVat(vat);
 				tbill.setTotal(total);
 				
 				
 				TestBillforOtherslist.add(tbill);	
 				
             
 			}
				
				
    ////////////////////////////////////////     
 		   String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTNAME,DESIGNATION,REFERENCEDDOCTOR,GENDER from MCENTER.TESTFOROUTSIDER where SERIALNUMBER='"+visitID+"'";
			
			ps1=con.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				String dob;
			
				
				patientname=rs1.getString("PATIENTNAME");
				patientname=rs1.getString("PATIENTNAME");
				designation=rs1.getString("DESIGNATION");
				refDoctor=rs1.getString("REFERENCEDDOCTOR");
 				gender=rs1.getString("GENDER");
				dob=rs1.getString("DOB");
				
				org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
				
				org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
				org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
				org.joda.time.DateTime now = new org.joda.time.DateTime();
				org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
				
				ageStr = java.lang.String.valueOf (age.getYears());
				
				
				
				
			   
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
		
		return "a";
   
   }	
	
public String demoreport(String visitID) throws Exception{
	
	
	
	//HttpServletRequest request = ServletActionContext.getRequest();
	
	//visitID=request.getParameter("serialNo");
	
	//patientID=request.getParameter("patientlId");
	 
		
		System.out.println(" hi...Adnan.....PDF new");
		System.out.println("Send Visit ID:"+visitID);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
          
      ////////////////////////////////////////////////    
             
            String sql3="Select * from MCENTER.TESTSAVEFOROUTSIDERPATIENT where VISITID='"+visitID+"'";
 			
 			ps3=con.prepareStatement(sql3);
 			ResultSet rs3=ps3.executeQuery();
 			while(rs3.next()){
 	//////////////////////////////////////////////////			
 				
 				 String testid=rs3.getString(3);
 				 String testtypeid=rs3.getString(2);
 	 				
  			     String sql2="Select * from MCENTER.TESTS where TESTID=lpad('" + testid + "',2,'0') and TESTTYPEID=lpad('" + testtypeid + "',2,'0') " ;
   				
   				ps2=con.prepareStatement(sql2);
   				ResultSet rs2=ps2.executeQuery();
   				while(rs2.next()){
   					testTypeID=rs2.getString(7);  					
   					testName=rs2.getString(1);
   					rate=rs2.getDouble(4);
					vat=rs2.getDouble(5);
   									}
  ///////////////////////////////////////////////////////////////////// 				
  				
   					
      String sql4="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
   				
   				ps4=con.prepareStatement(sql4);
   				ResultSet rs4=ps4.executeQuery();
   				while(rs4.next()){
   					  					
   					testTypeName=rs4.getString(2);
   							}				
   System.out.println("testTypeName:"+testTypeName);					
//////////////////////////////////////////////////////////////////////////////////   				
 				
   				 cost=((vat*rate)/100)+rate;
				 temp= cost;
				 total =total+temp;
   				
				  String sqlinword="select MCENTER.numbertoword('"+total+"') from dual";
	   				
	   				ps5=con.prepareStatement(sqlinword);
	   				ResultSet rs5=ps5.executeQuery();
	   				while(rs5.next()){
	   					inword=rs5.getString(1);  					
	   					
	   									}
				 
				 
				 
				 
				 
				 
 				TestBillforOthers tbill=new TestBillforOthers();
 				
 				tbill.setVisitID(rs3.getString(1));
 				tbill.setTestType(testTypeName);
 			  
  					
 				
 				tbill.setTestName(testName);
 				tbill.setPatientID(rs3.getString(4));
 				tbill.setRate(rate);
 				tbill.setCost(cost);
 				tbill.setVat(vat);
 				tbill.setTotal(total);
 				
 				
 				TestBillforOtherslist.add(tbill);	
 				
             
 			}
				
				
    ////////////////////////////////////////     
 		   String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTID,PATIENTNAME,SERIALNUMBER,DESIGNATION,REFERENCEDDOCTOR,GENDER from MCENTER.TESTFOROUTSIDER where SERIALNUMBER='"+visitID+"'";
			
			ps1=con.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				String dob;
				
				serialNumber=rs1.getString("SERIALNUMBER");
				patientID=rs1.getString("PATIENTID");
				patientname=rs1.getString("PATIENTNAME");
				designation=rs1.getString("DESIGNATION");
				refDoctor=rs1.getString("REFERENCEDDOCTOR");
 				gender=rs1.getString("GENDER");
				dob=rs1.getString("DOB");
				
				org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
				
				org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
				org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
				org.joda.time.DateTime now = new org.joda.time.DateTime();
				org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
				
				ageStr = java.lang.String.valueOf (age.getYears());
				
				
				
				
			   
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
		
		return "a";
   
   }	

}
