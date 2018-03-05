package com.mcenter.allphysicalexaminationform;

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

import com.mcenter.labtestBillManagement.DailyRegularTestBill;
import com.mcenter.moneyReceiptofMedicalCheckUp.MoneyReceiptforNewstudentMedicalCheckup;
import com.mcenter.report.MoneyReceiptforPhysicalExaminationAndTest;
import com.prescription.PrescriptionAction;





 public class Physicaltest {

	private String facultyID;
	private String departmentID;
	private String departmentName;
	private String receiptNO;
	private String serial;
	private int countreceipt;
	
	private String receiptNUMBER;
	private String session;
	private String faculty;
	private String department;
	private String studentname;
	private String meritPosition;
	private String amount;
	
	
	private String purpose;
	private String name;
	private String gender;
	private String dob;
	private String designation;
	
	private String testType;
	private String testName;
	private String testTypeID;
	private String testNameID;
    private String testResult;
	
	private String globalheight;
	private String globalweight;
	private String globalpulserate;
	private String globalbloodpressureSystolic;
	private String globalbloodpressureDiastolic;
	private String globaleyesightR;
	private String globaleyesightL;
	private String globalcolourblindness;
	private String globalhearing;
	private String globalspeech;
	private String globallungs;
	private String globalheart;
	private String globalpae;
	
	
	   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	   
	   PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;
		PreparedStatement ps6 = null;
	  

		
	   
	   
	   public String getTestResult() {
			return testResult;
		}
		public void setTestResult(String testResult) {
			this.testResult = testResult;
		}
		public String getGlobalheight() {
			return globalheight;
		}
		public void setGlobalheight(String globalheight) {
			this.globalheight = globalheight;
		}
		public String getGlobalweight() {
			return globalweight;
		}
		public void setGlobalweight(String globalweight) {
			this.globalweight = globalweight;
		}
		public String getGlobalpulserate() {
			return globalpulserate;
		}
		public void setGlobalpulserate(String globalpulserate) {
			this.globalpulserate = globalpulserate;
		}
		public String getGlobalbloodpressureSystolic() {
			return globalbloodpressureSystolic;
		}
		public void setGlobalbloodpressureSystolic(String globalbloodpressureSystolic) {
			this.globalbloodpressureSystolic = globalbloodpressureSystolic;
		}
		public String getGlobalbloodpressureDiastolic() {
			return globalbloodpressureDiastolic;
		}
		public void setGlobalbloodpressureDiastolic(String globalbloodpressureDiastolic) {
			this.globalbloodpressureDiastolic = globalbloodpressureDiastolic;
		}
		public String getGlobaleyesightR() {
			return globaleyesightR;
		}
		public void setGlobaleyesightR(String globaleyesightR) {
			this.globaleyesightR = globaleyesightR;
		}
		public String getGlobaleyesightL() {
			return globaleyesightL;
		}
		public void setGlobaleyesightL(String globaleyesightL) {
			this.globaleyesightL = globaleyesightL;
		}
		public String getGlobalcolourblindness() {
			return globalcolourblindness;
		}
		public void setGlobalcolourblindness(String globalcolourblindness) {
			this.globalcolourblindness = globalcolourblindness;
		}
		public String getGlobalhearing() {
			return globalhearing;
		}
		public void setGlobalhearing(String globalhearing) {
			this.globalhearing = globalhearing;
		}
		public String getGlobalspeech() {
			return globalspeech;
		}
		public void setGlobalspeech(String globalspeech) {
			this.globalspeech = globalspeech;
		}
		public String getGloballungs() {
			return globallungs;
		}
		public void setGloballungs(String globallungs) {
			this.globallungs = globallungs;
		}
		public String getGlobalheart() {
			return globalheart;
		}
		public void setGlobalheart(String globalheart) {
			this.globalheart = globalheart;
		}
		public String getGlobalpae() {
			return globalpae;
		}
		public void setGlobalpae(String globalpae) {
			this.globalpae = globalpae;
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
	public String getTestTypeID() {
		return testTypeID;
	}
	public void setTestTypeID(String testTypeID) {
		this.testTypeID = testTypeID;
	}
	public String getTestNameID() {
		return testNameID;
	}
	public void setTestNameID(String testNameID) {
		this.testNameID = testNameID;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getReceiptNUMBER() {
		return receiptNUMBER;
	}
	public void setReceiptNUMBER(String receiptNUMBER) {
		this.receiptNUMBER = receiptNUMBER;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getMeritPosition() {
		return meritPosition;
	}
	public void setMeritPosition(String meritPosition) {
		this.meritPosition = meritPosition;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getCountreceipt() {
		return countreceipt;
	}
	public void setCountreceipt(int countreceipt) {
		this.countreceipt = countreceipt;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getReceiptNO() {
		return receiptNO;
	}
	public void setReceiptNO(String receiptNO) {
		this.receiptNO = receiptNO;
	}
	public String getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

  
	ArrayList<Physicaltest> assignedTestlist=new ArrayList<Physicaltest>();
	
	
	
	public ArrayList<Physicaltest> getAssignedTestlist() {
		return assignedTestlist;
	}
	public void setAssignedTestlist(ArrayList<Physicaltest> assignedTestlist) {
		this.assignedTestlist = assignedTestlist;
	}
	public String receiptNo() throws Exception{
		System.out.println("Adnananan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
              
            String sql3="select count(*) from MCENTER.PHYSICAL_EXAMINATION where PURPOSE='"+purpose+"'";
	         ps3 = con.prepareStatement(sql3);
	         
	         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
									
				countreceipt=rs3.getInt(1);
				
			
				}
			
			countreceipt=countreceipt+1;
			if(purpose.equalsIgnoreCase("New Appoinment")){
			receiptNO="NAP-RECPT NO:"+countreceipt;
			      }
			else if(purpose.equalsIgnoreCase("Going abroad"))
					{
				receiptNO="GAB-RECPT NO:"+countreceipt;
				}
			else if(purpose.equalsIgnoreCase("Re Joinning"))
					{
				receiptNO="REJ-RECPT NO:"+countreceipt;
				}
			else if(purpose.equalsIgnoreCase("Extention"))
			{
		        receiptNO="EXT-RECPT NO:"+countreceipt;
		        }
			//receiptNO=purpose+"-RECPT NO:"+countreceipt;
			 
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	
	
public String insert() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	purpose=request.getParameter("purpose");
	receiptNUMBER=request.getParameter("receiptNO");
	name=request.getParameter("name");
	gender=request.getParameter("sex");
	dob=request.getParameter("dob");
	designation=request.getParameter("designation");
	department=request.getParameter("office");
	

	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		 /*Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
              
 ps4=con.prepareStatement("INSERT INTO MCENTER.PHYSICAL_EXAMINATION VALUES('"+purpose+"','"+receiptNUMBER+"','"+name+"','"+gender+"',to_date('"+dob+"','dd/mm/yyyy'),'"+designation+"','"+department+"')");
 ps4.executeUpdate(); 
 

 String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNUMBER+"'";
 ps1 = con.prepareStatement(sql3);
 
 
ResultSet rs3=ps1.executeQuery();
while(rs3.next()){
						
	purpose=rs3.getString(1);
	receiptNUMBER=rs3.getString(2);
	name=rs3.getString(3);
	designation=rs3.getString(6);
	department=rs3.getString(7);
 
}
MoneyReceiptforPhysicalExaminationAndTest a= new MoneyReceiptforPhysicalExaminationAndTest();
 a.report(receiptNUMBER,purpose,name,designation,department);
			 
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at insert()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps4!= null) {
		        	ps4.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }		   
	   
public String searchmedicalcheckuppersonbyreceiptNO() throws Exception{
	System.out.println("Adnan");
	Connection con = ConnectionManager.getConnection();	
//	Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
         
         String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNUMBER+"'";
         ps1 = con.prepareStatement(sql3);
         
         
        ResultSet rs3=ps1.executeQuery();
        while(rs3.next()){
        						
     	purpose=rs3.getString(1);
     	receiptNUMBER=rs3.getString(2);
     	name=rs3.getString(3);
     	designation=rs3.getString(6);
     	department=rs3.getString(7);
         
     }
			
		
		con.commit();
		
		
	}
	
	catch(Exception e){
		e.printStackTrace();
	
	
	
	 if (con != null) {
            try {
            	System.err.println("There is sql exception Mr.Adnan");
                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
                con.rollback();
            } catch(SQLException excep) {
                
                excep.printStackTrace();
                }
            
	 }
	 
	}
	
	    finally {
	      
	        if (ps2!= null) {
	        	ps2.close();
	        }
	       
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
	
	return "success";

}		   

public String testsave() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	String testypename[]=request.getParameterValues("testypename");
	String testname[]=request.getParameterValues("testname");
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
	/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			for(int i=0;i<testname.length;i++) { 
                  
 ps3=con.prepareStatement("INSERT INTO MCENTER.TEST_PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+testypename[i]+"','"+testname[i]+"',NULL)");
 ps3.executeUpdate(); 
			 
              }
  			
  			
  			
  		   String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNO+"'";
           ps4 = con.prepareStatement(sql3);
           
           
          ResultSet rs3=ps4.executeQuery();
          while(rs3.next()){
          						
       	purpose=rs3.getString(1);
       	receiptNUMBER=rs3.getString(2);
       	name=rs3.getString(3);
       	designation=rs3.getString(6);
       	department=rs3.getString(7);
           
       }
           
           
           
  		String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
  		System.out.println("receiptNO:"+receiptNUMBER);
  		ps1=con.prepareStatement(sql5);
  		ResultSet rs=ps1.executeQuery();
  		while(rs.next()){
  				
  			testTypeID=rs.getString(2);
  			testNameID=rs.getString(3);
  			 
  		
             //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
             	
  			String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
  			
  			ps2=con.prepareStatement(sql6);
  			ResultSet rs6=ps2.executeQuery();
  			while(rs6.next()){
  				
  				//testType=rs6.getString(2);
  				testName=rs6.getString(1);
  				}				
  			
        // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
         String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
         
  			ps3=con.prepareStatement(sql7);
  			ResultSet rs7=ps3.executeQuery();
  			while(rs7.next()){
  				testType=rs7.getString(2);
  				
  				
  		 
  			}
  			
  				
  			Physicaltest test=new Physicaltest();
  			
  			test.setTestType(testType);
  			test.setTestName(testName);
  			test.setTestTypeID(testTypeID);
  			test.setTestNameID(testNameID);
  			
  			//a=rs2.getString(16);
  		    //	b=rs2.getInt(17);
  			
  			assignedTestlist.add(test);
  			
  			
  		
  			
  			
  		}
  			
  			
  			
  			/*testTABLEshow(receiptNO);*/
  			

			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in Physicaltest at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }		   

public String testTABLE() throws Exception{
	
	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	
	System.out.println(" hi...Adnan");
	System.out.println(" receiptNO===="+receiptNO);
	//System.out.println(serialNO);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
                
         String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNO+"'";
         ps4 = con.prepareStatement(sql3);
         
         
        ResultSet rs3=ps4.executeQuery();
        while(rs3.next()){
        						
     	purpose=rs3.getString(1);
     	receiptNUMBER=rs3.getString(2);
     	name=rs3.getString(3);
     	designation=rs3.getString(6);
     	department=rs3.getString(7);
         
     }
         
         
         
		String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
		System.out.println("receiptNO:"+receiptNUMBER);
		ps1=con.prepareStatement(sql5);
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
				
			testTypeID=rs.getString(2);
			testNameID=rs.getString(3);
			 
		
           //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
           	
			String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
			
			ps2=con.prepareStatement(sql6);
			ResultSet rs6=ps2.executeQuery();
			while(rs6.next()){
				
				//testType=rs6.getString(2);
				testName=rs6.getString(1);
				}				
			
      // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
       String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
       
			ps3=con.prepareStatement(sql7);
			ResultSet rs7=ps3.executeQuery();
			while(rs7.next()){
				testType=rs7.getString(2);
				
				
		 
			}
			
				
			Physicaltest test=new Physicaltest();
			
			test.setTestType(testType);
			test.setTestName(testName);
			test.setTestTypeID(testTypeID);
			test.setTestNameID(testNameID);
			
			//a=rs2.getString(16);
		    //	b=rs2.getInt(17);
			
			assignedTestlist.add(test);
			
			
		
			
			
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
	       
	       
	        if (ps2!= null) {
	        	ps2.close();
	        }
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
	
	return "success";

}


public String testTABLEreport(String receiptNO ) throws Exception{
	
/*	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNUMBER");*/
	
	System.out.println(" hi...Adnan");
	System.out.println(" receiptNO===="+receiptNO);
	//System.out.println(serialNO);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
                
         String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNO+"'";
         ps4 = con.prepareStatement(sql3);
         
         
        ResultSet rs3=ps4.executeQuery();
        while(rs3.next()){
        						
     	purpose=rs3.getString(1);
     	receiptNUMBER=rs3.getString(2);
     	name=rs3.getString(3);
     	designation=rs3.getString(6);
     	department=rs3.getString(7);
         
     }
         
         
         
		String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
		System.out.println("receiptNO:"+receiptNUMBER);
		ps1=con.prepareStatement(sql5);
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
				
			testTypeID=rs.getString(2);
			testNameID=rs.getString(3);
			 
		
           //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
           	
			String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
			
			ps2=con.prepareStatement(sql6);
			ResultSet rs6=ps2.executeQuery();
			while(rs6.next()){
				
				//testType=rs6.getString(2);
				testName=rs6.getString(1);
				}				
			
      // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
       String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
       
			ps3=con.prepareStatement(sql7);
			ResultSet rs7=ps3.executeQuery();
			while(rs7.next()){
				testType=rs7.getString(2);
				
				
		 
			}
			
				
			Physicaltest test=new Physicaltest();
			
			test.setTestType(testType);
			test.setTestName(testName);
			test.setTestTypeID(testTypeID);
			test.setTestNameID(testNameID);
			
			//a=rs2.getString(16);
		    //	b=rs2.getInt(17);
			
			assignedTestlist.add(test);
			
			
		
			
			
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
	       
	       
	        if (ps2!= null) {
	        	ps2.close();
	        }
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
	
	return "success";

}


public String physicalexaminationANDtestsave() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNUMBER");
	
	String heihgt=request.getParameter("height");
	String weight=request.getParameter("weight");
	String pulserate=request.getParameter("pulseRate");
	String pulserateCONDITION=request.getParameter("pulserateCONDITION");
	String bloodpressureSystolic=request.getParameter("bloodpressureSystolic");
	String bloodpressureDiastolic=request.getParameter("bloodpressureDiastolic");
	String eyesightR=request.getParameter("eyesightR");
	String eyesightRCONDITION=request.getParameter("eyesightRGLLASS");
	String eyesightL=request.getParameter("eyesightL");
	String eyesightLCONDITION=request.getParameter("eyesightLGLLASS");
	String colourblindness=request.getParameter("colourblindness");
	String hearing=request.getParameter("hearing");
	String speech=request.getParameter("speech");
	String lungs=request.getParameter("lungs");
	String heart=request.getParameter("heart");
	String pae=request.getParameter("pae");
	String testypeID[]=request.getParameterValues("testTypeID");
	String testnameID[]=request.getParameterValues("testNameID");
	String testresult[]=request.getParameterValues("testresult");
	
	
	
	
	Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			for(int i=0;i<testnameID.length;i++) { 
                  
   String sql222="UPDATE MCENTER.TEST_PHYSICALEXAMINATION_SAVE SET RESULT='"+testresult[i]+"' WHERE TESTTYPEID='"+testypeID[i]+"' and TESTID='"+testnameID[i]+"' and RECEIPTNO='"+receiptNO+"'  ";
  				
  				ps5 = con.prepareStatement(sql222);
  			    ps5.executeQuery();				
  		
  		
              }
			
  			String pulsefinal=pulserate+"/min"+" "+pulserateCONDITION;
  			String bloodpressurefinalSystolic="Systolic"+" "+bloodpressureSystolic+" "+"mm of Hg";
  			String bloodpressurefinalDiastolic="Diastolic"+" "+bloodpressureDiastolic+" "+"mm of Hg";
  			String eyesightRfinal=eyesightR+" "+eyesightRCONDITION;
  			String eyesightLfinal=eyesightL+" "+eyesightLCONDITION;
  			    
    ps3=con.prepareStatement("INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+heihgt+"','"+weight+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+pae+"','"+bloodpressurefinalDiastolic+"')");
   
    ps3.executeUpdate(); 
	
    
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNO+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		
		
		globalheight=rs22.getString(2);
		globalweight=rs22.getString(3);
		globalpulserate=rs22.getString(4);
		globalbloodpressureSystolic=rs22.getString(5);
		globalbloodpressureDiastolic=rs22.getString(14);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
		globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
    
	 String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNO+"'";
     ps4 = con.prepareStatement(sql3);
     
     
    ResultSet rs3=ps4.executeQuery();
    while(rs3.next()){
    						
 	purpose=rs3.getString(1);
 	receiptNUMBER=rs3.getString(2);
 	name=rs3.getString(3);
 	designation=rs3.getString(6);
 	department=rs3.getString(7);
     
 }
     
     
     
	String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
	System.out.println("receiptNO:"+receiptNUMBER);
	ps1=con.prepareStatement(sql5);
	ResultSet rs=ps1.executeQuery();
	while(rs.next()){
			
		testTypeID=rs.getString(2);
		testNameID=rs.getString(3);
		testResult=rs.getString(4);
		 
	
       //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
       	
		String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
		
		ps2=con.prepareStatement(sql6);
		ResultSet rs6=ps2.executeQuery();
		while(rs6.next()){
			
			//testType=rs6.getString(2);
			testName=rs6.getString(1);
			}				
		
  // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
   String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
   
		ps3=con.prepareStatement(sql7);
		ResultSet rs7=ps3.executeQuery();
		while(rs7.next()){
			testType=rs7.getString(2);
			
			
	 
		}
		
			
		Physicaltest test=new Physicaltest();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
		
		
	
		
		
	}
		
    
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in Physicaltest at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	


public String physicalexaminationANDtestShow() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	
	
	
	
	
	
	Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNO+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		
		
		globalheight=rs22.getString(2);
		globalweight=rs22.getString(3);
		globalpulserate=rs22.getString(4);
		globalbloodpressureSystolic=rs22.getString(5);
		globalbloodpressureDiastolic=rs22.getString(14);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
		globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
    
	 String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNO+"'";
     ps4 = con.prepareStatement(sql3);
     
     
    ResultSet rs3=ps4.executeQuery();
    while(rs3.next()){
    						
 	purpose=rs3.getString(1);
 	receiptNUMBER=rs3.getString(2);
 	name=rs3.getString(3);
 	designation=rs3.getString(6);
 	department=rs3.getString(7);
     
 }
     
     
     
	String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
	System.out.println("receiptNO:"+receiptNUMBER);
	ps1=con.prepareStatement(sql5);
	ResultSet rs=ps1.executeQuery();
	while(rs.next()){
			
		testTypeID=rs.getString(2);
		testNameID=rs.getString(3);
		testResult=rs.getString(4);
		 
	
       //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
       	
		String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
		
		ps2=con.prepareStatement(sql6);
		ResultSet rs6=ps2.executeQuery();
		while(rs6.next()){
			
			//testType=rs6.getString(2);
			testName=rs6.getString(1);
			}				
		
  // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
   String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
   
		ps3=con.prepareStatement(sql7);
		ResultSet rs7=ps3.executeQuery();
		while(rs7.next()){
			testType=rs7.getString(2);
			
			
	 
		}
		
			
		Physicaltest test=new Physicaltest();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
		
		
	
		
		
	}
		
    
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in Physicaltest at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	


public String physicalexaminationANDtestREPORT(String receiptNOPhysicalTest) throws Exception{

/*	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");*/
	

	
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			

    
    
    
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNOPhysicalTest+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		
		
		globalheight=rs22.getString(2);
		globalweight=rs22.getString(3);
		globalpulserate=rs22.getString(4);
		globalbloodpressureSystolic=rs22.getString(5);
		globalbloodpressureDiastolic=rs22.getString(14);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
		globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
	 String sql3="select * from MCENTER.PHYSICAL_EXAMINATION where RECEIPTNO='"+receiptNOPhysicalTest+"'";
     ps4 = con.prepareStatement(sql3);
     
     
    ResultSet rs3=ps4.executeQuery();
    while(rs3.next()){
    						
 	purpose=rs3.getString(1);
 	receiptNUMBER=rs3.getString(2);
 	name=rs3.getString(3);
 	designation=rs3.getString(6);
 	department=rs3.getString(7);
     
 }
     
     
     
	String sql5="Select * from MCENTER.TEST_PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNUMBER+"' ";
	System.out.println("receiptNO:"+receiptNUMBER);
	ps1=con.prepareStatement(sql5);
	ResultSet rs=ps1.executeQuery();
	while(rs.next()){
			
		testTypeID=rs.getString(2);
		testNameID=rs.getString(3);
		testResult=rs.getString(4);
		 
	
       //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
       	
		String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
		
		ps2=con.prepareStatement(sql6);
		ResultSet rs6=ps2.executeQuery();
		while(rs6.next()){
			
			//testType=rs6.getString(2);
			testName=rs6.getString(1);
			}				
		
  // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
   String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
   
		ps3=con.prepareStatement(sql7);
		ResultSet rs7=ps3.executeQuery();
		while(rs7.next()){
			testType=rs7.getString(2);
			
			
	 
		}
		
			
		Physicaltest test=new Physicaltest();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
		
		
	
		
		
	}
			 
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in Physicaltest at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	
	

}
