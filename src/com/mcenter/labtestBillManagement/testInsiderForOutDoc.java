package com.mcenter.labtestBillManagement;

import java.sql.Connection;
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

import com.mcenter.report.TokenForInsiderOutDoc;
import com.opensymphony.xwork2.ActionSupport;

public class TestInsiderForOutDoc extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2851191842900083129L;
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
	   
	   
		private ArrayList<TestInsiderForOutDoc> TestBillforOtherslist= new ArrayList<TestInsiderForOutDoc>();
		private ArrayList<String> testtypeNamelist= new ArrayList<String>();
		private ArrayList<String>testtypeIDlist= new ArrayList<String>();
		private ArrayList<String> testNamelist= new ArrayList<String>();
		private ArrayList<String>testIDlist= new ArrayList<String>();
		private String serial;
		private String visitID;
		private String personID;
		private String personName;
		private String patientname;
		private String patientID;
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
	
	
	
	
	
	public ArrayList<TestInsiderForOutDoc> getTestBillforOtherslist() {
		return TestBillforOtherslist;
	}

	public void setTestBillforOtherslist(
			ArrayList<TestInsiderForOutDoc> testBillforOtherslist) {
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

	public String getAlltestType() {
		return alltestType;
	}

	public void setAlltestType(String alltestType) {
		this.alltestType = alltestType;
	}

	public int getAlltestTypeID() {
		return alltestTypeID;
	}

	public void setAlltestTypeID(int alltestTypeID) {
		this.alltestTypeID = alltestTypeID;
	}

	public String getInword() {
		return inword;
	}

	public void setInword(String inword) {
		this.inword = inword;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
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

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getRefDoctor() {
		return refDoctor;
	}

	public void setRefDoctor(String refDoctor) {
		this.refDoctor = refDoctor;
	}

	public String getVisitID() {
		return visitID;
	}

	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAgeStr() {
		return ageStr;
	}

	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String execute() throws SQLException{
		
		
		int count=0;
		
		
		
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
            String sql1="Select count(*) from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy')";
 			
 			ps1=con.prepareStatement(sql1);
 			ResultSet rs1=ps1.executeQuery();
 			while(rs1.next()){
 				
 			
 			
 				count=rs1.getInt(1);
 			   
 			}
 			count=count+1;	
 			serial=Date1+":IPOD:"+count;
 			
 			//IPOD=inside patient outside doctor
 			
 			
 			
 		  
 			
 			
             
             
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
		
		
		return SUCCESS;
	}
	
	
	public String patiententry() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String personName=request.getParameter("personName");
		String personOffID=request.getParameter("officialId");
		String patientID=request.getParameter("patientNameadvancesearch");
		
		String doctorName=request.getParameter("doctor");
		
		String serialnumber=request.getParameter("serialNo");
		
		String patientName=request.getParameter("patientName");
	
			
			System.out.println(" hi...Adnan");
			//System.out.println(serialNO);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				System.out.println(personName+" "+personOffID+" "+patientID+" "+doctorName);

			    
		          if(patientName!=null&& personOffID!=null){  
		        	  
		       
		           
		            ps1=con.prepareStatement("INSERT INTO MCENTER.TESTINSIDERFOROUTSIDERDOCTOR VALUES('"+personOffID+"','"+patientID+"','"+patientName+"','"+serialnumber+"',to_date('"+Date+"','mm/dd/yyyy'),'"+doctorName+"')");
					ps1.executeUpdate(); 
		             
		          }  
		      
	             con.setAutoCommit(false);
	              
	            
	             
	             TokenForInsiderOutDoc  a= new TokenForInsiderOutDoc ();
	 			 a.report(patientName,patientID,doctorName,serialnumber);
	           
	             
	             
	        
	          
			} finally {
			       
			       
		        if (ps1!= null) {
		        	ps1.close();
		        }
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
			return SUCCESS;
	
	
	}
	
	public String searchPatient() throws Exception{
		
		
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            System.out.println(visitID);
             String sql1="Select * from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where SERIALNUMBER='"+visitID+"'";
  			
  			ps1=con.prepareStatement(sql1);
  			ResultSet rs1=ps1.executeQuery();
  			while(rs1.next()){
  				
  			
  				
  				 patientname=rs1.getString("PATIENTNAME");
  				patientID=rs1.getString("PATIENTID");
  					
  				refDoctor=rs1.getString("REFERENCEDDOCTOR");
  				personID=rs1.getString("PERSONID");
  				 System.out.println(patientname);
  				 System.out.println(patientID);
  				 System.out.println(refDoctor);
  				
  				
  				
  				
  			   
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
		personID=request.getParameter("personID");
		String testypename[]=request.getParameterValues("testypename");
		String testname[]=request.getParameterValues("testname");
		 
			
//			System.out.println(" hi...Adnan");
			//System.out.println(serialNO);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
	/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		         
		      
	             con.setAutoCommit(false);
	            
	            if(testypename!=null&& testname!=null){ 
	   			for(int i=0;i<testname.length;i++) { 
	                
	   	        ps1=con.prepareStatement("INSERT INTO MCENTER.TEST_SAVE_INSIDER_OUT_DOC VALUES('"+personID+"','"+patientID+"','"+visitID+"','"+testypename[i]+"','"+testname[i]+"',to_date(sysdate))");
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
	             
	            String sql3="Select PATIENTID,VISITID,TESTTYPEID,TESTID from MCENTER.TEST_SAVE_INSIDER_OUT_DOC where VISITID='"+visitID+"'";
	 			
	 			ps3=con.prepareStatement(sql3);
	 			ResultSet rs3=ps3.executeQuery();
	 			while(rs3.next()){
	 	//////////////////////////////////////////////////			
	 				
	 				 String testtypeid=rs3.getString("TESTTYPEID");
	 				 String testid=rs3.getString("TESTID");
	 				 
	 	 				
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
	   				
					 TestInsiderForOutDoc tbill=new TestInsiderForOutDoc();
	 				
	 				tbill.setVisitID(rs3.getString("VISITID"));
	 				tbill.setTestType(testTypeName);
	 			  
	  					
	 				
	 				tbill.setTestName(testName);
	 				tbill.setPatientID(rs3.getString("PATIENTID"));
	 				tbill.setRate(rate);
	 				tbill.setCost(cost);
	 				tbill.setVat(vat);
	 				tbill.setTotal(total);
	 				//a=rs2.getString(16);
	 			    //	b=rs2.getInt(17);
	 				
	 				TestBillforOtherslist.add(tbill);	
	 				
	             
	 			}
					
					
	    ////////////////////////////////////////     
	 		   /*String sql1="Select TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') AS DOB,PATIENTNAME,DESIGNATION,REFERENCEDDOCTOR,GENDER from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where SERIALNUMBER='"+visitID+"'";*/
	 		  String sql1="Select PATIENTNAME,REFERENCEDDOCTOR from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where SERIALNUMBER='"+visitID+"'";
	 		   
				ps1=con.prepareStatement(sql1);
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					String dob;
				
					patientname=rs1.getString("PATIENTNAME");
			//		designation=rs1.getString("DESIGNATION");
					refDoctor=rs1.getString("REFERENCEDDOCTOR");
	 			//	gender=rs1.getString("GENDER");
/*					dob=rs1.getString("DOB");
					
					org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
					
					org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
					org.joda.time.DateMidnight birthdate = new org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
					org.joda.time.DateTime now = new org.joda.time.DateTime();
					org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
					
					ageStr = java.lang.String.valueOf (age.getYears());
					*/
					
					
					
				   
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
	
	public String insertANDshow1() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		visitID=request.getParameter("serialNo");
		testType = request.getParameter("b");
		 testID = request.getParameter("c");
		patientID = request.getParameter("patientlId");
		personID=request.getParameter("personID");
		 
			
			System.out.println(" hi...Adnan");
			//System.out.println(serialNO);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
			
		         
		      
	             con.setAutoCommit(false);
	            
	           
	             
	             
	             
	          if(testID!=null&& patientID!=null){   
	           
	            ps1=con.prepareStatement("INSERT INTO MCENTER.TEST_SAVE_INSIDER_OUT_DOC VALUES('"+personID+"','"+patientID+"','"+visitID+"','"+testType+"','"+testID+"',to_date('"+Date+"','mm/dd/yyyy'))");
				ps1.executeUpdate(); 
				
				System.out.println(" hi...Adnan....inserted");
	             
	          }
	          
	          
	     
	          
	      ////////////////////////////////////////////////    
	             
	            String sql3="Select * from MCENTER.TEST_SAVE_INSIDER_OUT_DOC where VISITID='"+visitID+"' AND VISITDATE=to_date('"+Date+"','mm/dd/yyyy')";
	 			
	 			PreparedStatement ps3=con.prepareStatement(sql3);
	 			ResultSet rs3=ps3.executeQuery();
	 			while(rs3.next()){
	 	//////////////////////////////////////////////////			
	 				
	 				 String testtypeid=rs3.getString("TESTTYPEID");
	 				 String testid=rs3.getString("TESTID");
	 				 
	 	 				
	  			     String sql2="Select * from MCENTER.TESTS where TESTID='"+testid+"' and TESTTYPEID='"+testtypeid+"' ";
	   				
	   				PreparedStatement ps2=con.prepareStatement(sql2);
	   				ResultSet rs2=ps2.executeQuery();
	   				while(rs2.next()){
	   					testTypeID=rs2.getString(7);  					
	   					testName=rs2.getString(1);
	   					rate=rs2.getDouble(4);
						vat=rs2.getDouble(5);
	   									}
	  ///////////////////////////////////////////////////////////////////// 				
	  				
	   					
	      String sql4="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"'";
	   				
	   				PreparedStatement ps4=con.prepareStatement(sql4);
	   				ResultSet rs4=ps4.executeQuery();
	   				while(rs4.next()){
	   					  					
	   					testTypeName=rs4.getString(2);
	   							}				
	   System.out.println("testTypeName:"+testTypeName);					
//////////////////////////////////////////////////////////////////////////////////	   				
	 				
	   				 cost=((vat*rate)/100)+rate;
					 temp= cost;
					 total =total+temp;
	   				
					 TestInsiderForOutDoc tbill=new TestInsiderForOutDoc();
	 				
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
					
					
	 			 String sql1="Select * from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where SERIALNUMBER='"+visitID+"'";
	   			
	   			ps1=con.prepareStatement(sql1);
	   			ResultSet rs1=ps1.executeQuery();
	   			while(rs1.next()){
	   				
	   			
	   				
	   				 patientname=rs1.getString("PATIENTNAME");
	   				 patientID=rs1.getString("PATIENTID");
	   					
	   				 refDoctor=rs1.getString("REFERENCEDDOCTOR");
	   				 personID=rs1.getString("PERSONID");
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
	
	public String demoreport(String visitID) throws Exception{
		
		
	
			
			System.out.println(" hi...Adnan.....PDF new");
			System.out.println("Send Visit ID:"+visitID);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
	
		         
		      
	             con.setAutoCommit(false);
	             
	          
	      ////////////////////////////////////////////////    
	             
	            String sql3="Select * from MCENTER.TEST_SAVE_INSIDER_OUT_DOC where VISITID='"+visitID+"'";
	 			
	 			PreparedStatement ps3=con.prepareStatement(sql3);
	 			ResultSet rs3=ps3.executeQuery();
	 			while(rs3.next()){
	 	//////////////////////////////////////////////////			
	 				
	 				String testtypeid=rs3.getString("TESTTYPEID");
	 				 String testid=rs3.getString("TESTID");
	 	 				
	  			     String sql2="Select * from MCENTER.TESTS where TESTID=lpad('" + testid + "',2,'0') and TESTTYPEID=lpad('" + testtypeid + "',2,'0') " ;
	   				
	   				PreparedStatement ps2=con.prepareStatement(sql2);
	   				ResultSet rs2=ps2.executeQuery();
	   				while(rs2.next()){
	   					testTypeID=rs2.getString(7);  					
	   					testName=rs2.getString(1);
	   					rate=rs2.getDouble(4);
						vat=rs2.getDouble(5);
	   									}
	  ///////////////////////////////////////////////////////////////////// 				
	  				
	   					
	      String sql4="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
	   				
	   				PreparedStatement ps4=con.prepareStatement(sql4);
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
		   				
		   				PreparedStatement ps5=con.prepareStatement(sqlinword);
		   				ResultSet rs5=ps5.executeQuery();
		   				while(rs5.next()){
		   					inword=rs5.getString(1);  					
		   					
		   									}
					 
					 
					 
					 
					 
					 
		   				TestInsiderForOutDoc tbill=new TestInsiderForOutDoc();
	 				
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
	 		   
				
	 			 String sql1="Select * from MCENTER.TESTINSIDERFOROUTSIDERDOCTOR where SERIALNUMBER='"+visitID+"'";
		   			
		   			ps1=con.prepareStatement(sql1);
		   			ResultSet rs1=ps1.executeQuery();
		   			while(rs1.next()){
		   				
		   			
		   				
		   				 patientname=rs1.getString("PATIENTNAME");
		   				 patientID=rs1.getString("PATIENTID");
		   					
		   				 refDoctor=rs1.getString("REFERENCEDDOCTOR");
		   				 personID=rs1.getString("PERSONID");
		   				 serial=visitID;
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
