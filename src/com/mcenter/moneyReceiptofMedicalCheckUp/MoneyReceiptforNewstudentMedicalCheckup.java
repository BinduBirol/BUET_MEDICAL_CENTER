package com.mcenter.moneyReceiptofMedicalCheckUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.ConnectionUtil.ConnectionManager;
import util.login.ValidateUser;

import com.mcenter.allphysicalexaminationform.Physicaltest;
import com.mcenter.patientManagement.CreateSerialDAO;
import com.mcenter.report.MoneyReceiptforNewAdmitedStudent;
import com.mcenter.report.finalTestReportAdmission;
import com.opensymphony.xwork2.ActionContext;


public class MoneyReceiptforNewstudentMedicalCheckup {

	private String facultyID;
	private String departmentID;
	private String departmentName;
	private String receiptNO;
	private String serial;
	private int countreceipt;
	private String fatherName;
	
	private String receiptNUMBER;
	private String group_id;
	private String academic_session;
	private String merit_position;
	private String father_name;
	private String dob;
	private String gender;
	private String acadenicsession;
	private String faculty;
	private String department;
	private String studentname;
	private String meritPosition;
	private String amount;
	private String doctorName;
	
	
	private String testType;
	private String testName;
	private String testTypeID;
	private String testNameID;
	private String testResult;
	
	private String globalidentificationMark;
	private String globalheight;
	private String globalweight;
	private String globalpulserate;
	private String globalbloodpressureSystolic;
	private String globalbloodpressureDiastolic;
	private String globaleyesightR;
	private String globaleyesightL;
	private String globalcolourblindness;
	private String globallungs;
	private String globalheart;
	private String globalchestnormal;
	private String globalchesttb;
	private String globalchestlb;
	private String globalnormalHealthCondition;
	private String globalliver;
	private String globalsplees;
	private String globalhernia;
	private String globalanyPhysicalDisability;
	private String globalskinDisease;
	private String globalear;
	private String globalnose;
	private String globalteeth;
	private String globalothers;
	
	
	
	
	private String globalhearing;
	private String globalspeech;
    private String globalpae;
	private String father;
	
	private String dataString;

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	ArrayList<MoneyReceiptforNewstudentMedicalCheckup> assignedTestlist=new ArrayList<MoneyReceiptforNewstudentMedicalCheckup>();
	
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
	   
	  
	   private ArrayList<String>facultylist= new ArrayList<String>();
	   private ArrayList<String>departmentlist= new ArrayList<String>();
	   private ArrayList<String>departmentIDlist= new ArrayList<String>();
		
	   
	   

	public String execute() throws Exception{
			System.out.println("Adnan");
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		         
		      
	             con.setAutoCommit(false);
	             
	            String sql1="Select distinct FACULTYID as facultyname from BIIS.DEPARTMENT";
		         ps1 = con.prepareStatement(sql1);
		         
		         
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
										
					facultylist.add(rs1.getString("facultyname"));
					
				
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
			        if (ps1!= null) {
			        	ps1.close();
			        }
			     
			       
			       
			        con.setAutoCommit(true);
			        con.close();
			    }
			
			return "success";
	   
	   }
	   
	public String department() throws Exception{
		System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
				
			String sql2="Select * from BIIS.DEPARTMENT where FACULTYID='"+facultyID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				

						
departmentIDlist.add(rs2.getString(1));
departmentlist.add(rs2.getString(6));

				 
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
	
	public String searchNewStudent() throws Exception{
		
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
	         con.setAutoCommit(false);
	         
	         System.out.println(group_id);	
	         System.out.println(academic_session);
	         System.out.println(merit_position);
				
	 		String sql2="Select NAME,FATHER_NAME,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH,GENDER from MCENTER.NEW_ADMITTED_STUDENT_BSC where GROUP_ID='"+group_id+"' and MERIT_POSITION='"+merit_position+"'";
	         ps2 = con.prepareStatement(sql2);
	          
	          
	 		 ResultSet rs2=ps2.executeQuery();
	 		 while(rs2.next()){	
	 			
	 			 studentname=rs2.getString("NAME");
	 			 father_name=rs2.getString("FATHER_NAME");
	 			 dob=rs2.getString("DATE_OF_BIRTH");
	 			 gender=rs2.getString("GENDER");
	 	 
	 							 
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
		        if (ps3!= null) {
		        	ps3.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }
	
	public String moneyReceiptList() throws Exception{
		System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
				
			String sql2="Select * from BIIS.DEPARTMENT where FACULTYID='"+facultyID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				

						
departmentIDlist.add(rs2.getString(1));
departmentlist.add(rs2.getString(6));

				 
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
	
	   
/*	public String receiptNo() throws Exception{
		
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
	         
	      
             con.setAutoCommit(false);
              
            String sql3="select count(*) from MCENTER.NEWSTDCHECKUPMONEYRECIPT";
	         ps3 = con.prepareStatement(sql3);
	         
	         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
									
				countreceipt=rs3.getInt(1);
				
			
				}
			
			countreceipt=countreceipt+1;
			receiptNO="ADM-RECPT NO:"+countreceipt;
			 
			
			
			
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
   
   }	*/
	public String rePrintReceipt() throws Exception{
		
		String[] data = dataString.split("###"); 
		
		 MoneyReceiptforNewAdmitedStudent a= new MoneyReceiptforNewAdmitedStudent();
		 a.report(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9]);
		
		return "success";		
	}
	
public String insert() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	

	acadenicsession=request.getParameter("acadenicsession");
	studentname=request.getParameter("studentName");
	meritPosition=request.getParameter("meritposition");
	amount=request.getParameter("amount");
	String doctorID=request.getParameter("doctorsName");
	String group=request.getParameter("group");
	
	
	String gender=request.getParameter("gender");
	String dob=request.getParameter("dob");
	String fatherName=request.getParameter("father_name");
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
    		Map<String, Object> session = ActionContext.getContext().getSession();
    		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
    		
    		System.out.println(user.getUserfullname());
    		System.out.println(user.getUserdesignation());
    		System.out.println(user.getUsername());
    		
    		con.setAutoCommit(false);
    		
    		CreateSerialDAO dDAO = new CreateSerialDAO();
			dDAO.receiptNo();
			String receipt = dDAO.getReceiptNO();

			String sql="Select NAME from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+doctorID+"'";
			 ps6 = con.prepareStatement(sql);
	         
	         ResultSet rs8=ps6.executeQuery();
	         while(rs8.next()){
	        	 
	        	 doctorName=rs8.getString(1);
	        	 
				
	         }     
             
              
 ps4=con.prepareStatement("INSERT INTO MCENTER.NEWSTDCHECKUPMONEYRECIPT VALUES('"+receipt+"','"+acadenicsession+"','"+studentname+"','"+meritPosition+"','"+amount+"',to_date('"+Date+"','mm/dd/yyyy'),'"+user.getUsername()+"','"+doctorID+"','"+doctorName+"','"+group+"','"+fatherName+"',to_date('"+dob+"','dd/mm/yyyy'),'"+gender+"')");
 ps4.executeUpdate(); 
 
/* ps4=con.prepareStatement("INSERT INTO MCENTER.NEWSTDCHECKUPMONEYRECIPT VALUES('"+receiptNUMBER+"','"+acadenicsession+"','"+faculty+"','"+department+"','"+studentname+"','"+meritPosition+"','"+amount+"',to_date('"+Date+"','mm/dd/yyyy'),NULL)");
 ps4.executeUpdate(); */
 
 
 String sql3="select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receipt+"'";
 ps3 = con.prepareStatement(sql3);
 
 
ResultSet rs3=ps3.executeQuery();
while(rs3.next()){
						
	receiptNUMBER=rs3.getString(1);
	acadenicsession=rs3.getString(2);
	studentname=rs3.getString(3);
	meritPosition=rs3.getString(4);
	amount=rs3.getString(5);

	}
 
 MoneyReceiptforNewAdmitedStudent a= new MoneyReceiptforNewAdmitedStudent();
 a.report(receiptNUMBER,studentname,acadenicsession,meritPosition,amount,group,gender,dob,fatherName,doctorName);
			 
			
			
			
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
		        if (ps4!= null) {
		        	ps4.close();
		        }
		     
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }		   
	   
public String searchstudentbyreceiptNO() throws Exception{
//	System.out.println("Adnan");
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
         
  
			
		String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNO+"'";
        ps2 = con.prepareStatement(sql2);
         
         
		 ResultSet rs2=ps2.executeQuery();
		 while(rs2.next()){
			
			
			
			 receiptNO=rs2.getString(1);
			 acadenicsession=rs2.getString(2);
			 studentname=rs2.getString(3);
			 meritPosition=rs2.getString(4);
			 group_id=rs2.getString("GROUP_ID");
							 
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
/*String testypename[]=request.getParameterValues("testypename");
	String testname[]=request.getParameterValues("testname");
	
	this one for dynamic test fitnesstestassignform.jsp*/
	
	

	
	String testypename[]={"4","4"};
	String testname[]={"14","51"};
	
	
	
	Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			for(int i=0;i<testname.length;i++) { 
                  
 ps3=con.prepareStatement("INSERT INTO MCENTER.TEST_SAVE_FOR_NEW_STUDENT VALUES('"+receiptNO+"','"+testypename[i]+"','"+testname[i]+"',NULL)");
 ps3.executeUpdate(); 
			 
              }
			
  			 String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNO+"'";
  	         ps2 = con.prepareStatement(sql2);
  	          
  	          
  	 		 ResultSet rs2=ps2.executeQuery();
  	 		 while(rs2.next()){
  	 			
  	 			
  	 			
  	 			receiptNUMBER=rs2.getString(1);
  	 			acadenicsession=rs2.getString(2);
  	 			studentname=rs2.getString(3);
  	 			meritPosition=rs2.getString(4);
  	 			 
  	 							 
  	 			}
  	 		   
  	         
  	         
  			String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNUMBER+"' ";
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
  				
  					
  				MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
  				
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


public String testReportSaveAdmissionMethods() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	String abo=request.getParameter("abo");
	String rhd=request.getParameter("rhd");
	String hbsag= request.getParameter("hbsag");
	
	String blood_group=abo+"#"+rhd;
	
/*String testypename[]=request.getParameterValues("testypename");
	String testname[]=request.getParameterValues("testname");
	
	this one for dynamic test fitnesstestassignform.jsp*/
	
	

	String resultSet[]={blood_group,hbsag};
	String testypename[]={"4","4"};
	String testname[]={"14","51"};
	
	
	
	Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			for(int i=0;i<testname.length;i++) { 
                  
  				String sql="update MCENTER.TEST_SAVE_FOR_NEW_STUDENT set RESULT='"+resultSet[i]+"' where RECEIPTNO='"+receiptNO+"' AND TESTTYPEID='"+testypename[i]+"' AND TESTID='"+testname[i]+"'";
 ps3=con.prepareStatement(sql);
 ps3.executeUpdate(); 
			 
              }
			
  			finalTestReportAdmission GenerateReport=new finalTestReportAdmission();
  			GenerateReport.report(receiptNO,abo,rhd,hbsag);
  			
			
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



public String searchmedicalcheckupstudentbyreceiptNO() throws Exception{
	System.out.println("Adnan");
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
         
         String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNUMBER+"'";
         ps2 = con.prepareStatement(sql2);
          
          
 		 ResultSet rs2=ps2.executeQuery();
 		 while(rs2.next()){
 			
 			
 			
 			 receiptNO=rs2.getString(1);
 			acadenicsession=rs2.getString(2);
 			 studentname=rs2.getString(3);
 			meritPosition=rs2.getString(4);
 			 
 							 
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


public String testTABLE() throws Exception{
	
	HttpServletRequest request = ServletActionContext.getRequest();
	
	String receiptNumber=request.getParameter("receiptNO");
	
	System.out.println(" hi...Adnan");
	//System.out.println(serialNO);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
         */
      
         con.setAutoCommit(false);
                
         String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNumber+"'";
         ps2 = con.prepareStatement(sql2);
          
          
 		 ResultSet rs2=ps2.executeQuery();
 		 while(rs2.next()){
 			
 			
 			
 			receiptNO=rs2.getString(1);
 			acadenicsession=rs2.getString(2);
 			studentname=rs2.getString(3);
 			meritPosition=rs2.getString(4);
 							 
 			}
 		   
         
         
		String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNO+"' ";
		System.out.println("receiptNO:"+receiptNO);
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
			
				
			MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
			
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

public String testTABLEreport(String receiptNONewstudent) throws Exception{
	
/*	HttpServletRequest request = ServletActionContext.getRequest();
	
	String receiptNumber=request.getParameter("receiptNO");*/
	
	//System.out.println(" hi...Adnan");
	//System.out.println(serialNO);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
         */
      
         con.setAutoCommit(false);
                
         String sql2="Select RECIPSNO,SESSIONN,STUDENTNAME,MERITPOSITION,SEX,to_char(DOB,'dd/mm/yyyy') DOB,FATHER_NAME,REFDOCTOR_NAME,GROUP_ID from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNONewstudent+"'";
         ps2 = con.prepareStatement(sql2);
          
          
 		 ResultSet rs2=ps2.executeQuery();
 		 while(rs2.next()){
 			
 			
 			
 			receiptNO=rs2.getString(1);
 			acadenicsession=rs2.getString(2);
 			studentname=rs2.getString(3);
 			meritPosition=rs2.getString(4);
 			gender=rs2.getString("SEX"); 
 			dob=rs2.getString("DOB"); 
 			father=rs2.getString("FATHER_NAME"); 
 			doctorName=rs2.getString("REFDOCTOR_NAME"); 
 			group_id=rs2.getString("GROUP_ID");
 			
 			
 			}
 		   
         
         
		String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNO+"' ";
		System.out.println("receiptNO:"+receiptNO);
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
			
				
			MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
			
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

public String physicalexaminationANDtestresultSHOW() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	

	
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
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
		globalbloodpressureDiastolic=rs22.getString(13);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
	//	globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
    String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNO+"'";
    ps2 = con.prepareStatement(sql2);
     
     
	 ResultSet rs2=ps2.executeQuery();
	 while(rs2.next()){
		
		
		
		receiptNUMBER=rs2.getString(1);
		acadenicsession=rs2.getString(2);
		studentname=rs2.getString(3);
		meritPosition=rs2.getString(4);
						 
		}
	   
    
    
	String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNUMBER+"' ";
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
		
/*	String sql66="Select RESULT from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where TESTID='" + testNameID + "' and TESTTYPEID='" + testTypeID + "' and RECEIPTNO='"+receiptNUMBER+"'" ;
		
		ps4=con.prepareStatement(sql66);
		ResultSet rs66=ps4.executeQuery();
		while(rs66.next()){
			
			//testType=rs6.getString(2);
			testResult=rs66.getString(1);
			}	*/
		
		
		
		MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
    
    
		System.out.println(testResult);
    
    
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

public String physicalexaminationsave() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	
	String height=request.getParameter("height");
	height=height.replace("'","''");
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
	String anaemia=request.getParameter("anaemia");
	/*	String speech=request.getParameter("speech");*/
	String lungs=request.getParameter("lungs");
	String heart=request.getParameter("heart");
	String identificationMark=request.getParameter("identificationMark");
	String chestnormal=request.getParameter("chestnormal");
	String chesttb=request.getParameter("chesttb");
	String chestlb=request.getParameter("chestlb");
	String normalHealthCondition=request.getParameter("normalHealthCondition");
	String liver=request.getParameter("liver");
	String splees=request.getParameter("splees");
	String hernia=request.getParameter("hernia");
	String anyPhysicalDisability=request.getParameter("anyPhysicalDisability");
	String skinDisease=request.getParameter("skinDisease");
	String ear=request.getParameter("ear");
	String nose=request.getParameter("nose");
	String throat=request.getParameter("throat");
	String others=request.getParameter("others");

	//String pae=request.getParameter("pae");
/*	String testypeID[]=request.getParameterValues("testTypeID");
	String testnameID[]=request.getParameterValues("testNameID");
	String testresult[]=request.getParameterValues("testresult");*/
	
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			

  			String weightfinal=weight+" "+"kg";
  			String pulsefinal=pulserate+"/min"+" "+pulserateCONDITION;
  			String bloodpressurefinalSystolic="Systolic"+" "+bloodpressureSystolic+" "+"mm of Hg";
  			String bloodpressurefinalDiastolic="Diastolic"+" "+bloodpressureDiastolic+" "+"mm of Hg";
  			String eyesightRfinal=eyesightR+" "+eyesightRCONDITION;
  			String eyesightLfinal=eyesightL+" "+eyesightLCONDITION;
  			String chestnormalFinal=chestnormal+" "+" inchs";
  			String chesttbFinal=chesttb+" "+" inchs";
  			String chestlbFinal=chestlb+" "+" inchs";
  			
  			String sqlStudent="INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+identificationMark+"','"+height+"','"+weightfinal+"'," +
    		"'"+chestnormalFinal+"','"+chesttbFinal+"','"+chestlbFinal+"','"+eyesightRfinal+"'," +
    		"'"+eyesightLfinal+"','"+normalHealthCondition+"','"+pulsefinal+"','"+bloodpressurefinalSystolic+"'," +	
    		"'"+bloodpressurefinalDiastolic+"','"+heart+"','"+lungs+"','"+liver+"'," +	
    		"'"+splees+"','"+hernia+"','"+anyPhysicalDisability+"','"+skinDisease+"'," +
    		"'"+ear+"','"+nose+"','"+throat+"','"+colourblindness+"','"+others+"','"+anaemia+"')";
  			    

    
/*    ps3=con.prepareStatement("INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+height+"','"+weightfinal+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+bloodpressurefinalDiastolic+"')");
    */
/*    ps3=con.prepareStatement("INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+height+"','"+weightfinal+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+pae+"','"+bloodpressurefinalDiastolic+"')");*/
  	ps3 = con.prepareStatement(sqlStudent);
    ps3.executeUpdate(); 
    
    
    
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNO+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		 
				
		globalidentificationMark=rs22.getString(2);
		globalheight=rs22.getString(3);
		globalweight=rs22.getString(4);
		globalchestnormal=rs22.getString(5);
		globalchesttb=rs22.getString(6);
		globalchestlb=rs22.getString(7);
		globaleyesightR=rs22.getString(8);
		globaleyesightL=rs22.getString(9);
		globalnormalHealthCondition=rs22.getString(10);
		globalpulserate=rs22.getString(11);
		globalbloodpressureSystolic=rs22.getString(12);
		globalbloodpressureDiastolic=rs22.getString(13);
		globalheart=rs22.getString(14);
		globallungs=rs22.getString(15);
		globalliver=rs22.getString(16);
		globalsplees=rs22.getString(17);
		globalhernia=rs22.getString(18);
		globalanyPhysicalDisability=rs22.getString(19);
		globalskinDisease=rs22.getString(20);
		globalear=rs22.getString(21);
		globalnose=rs22.getString(22);
		globalteeth=rs22.getString(23);
		globalcolourblindness=rs22.getString(24);
		globalothers=rs22.getString(25);
	//	globalpae=rs22.getString(13);
						 
		}
    
	// System.out.println("globalheight:"+globalheight);  
    
    String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNO+"'";
    ps2 = con.prepareStatement(sql2);
     
     
	 ResultSet rs2=ps2.executeQuery();
	 while(rs2.next()){		
		
		receiptNUMBER=rs2.getString(1);
		acadenicsession=rs2.getString(2);
		studentname=rs2.getString(3);
		meritPosition=rs2.getString(4);
						 
		}
	   
    
    
	String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNUMBER+"' ";
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
		
/*	String sql66="Select RESULT from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where TESTID='" + testNameID + "' and TESTTYPEID='" + testTypeID + "' and RECEIPTNO='"+receiptNUMBER+"'" ;
		
		ps4=con.prepareStatement(sql66);
		ResultSet rs66=ps4.executeQuery();
		while(rs66.next()){
			
			//testType=rs6.getString(2);
			testResult=rs66.getString(1);
			}	*/
		
		
		
		MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
    
    
		System.out.println(testResult);
    
    
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
	
public String physicalexaminationANDtestsave() throws Exception{

	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");
	
	String height=request.getParameter("height");
	height=height.replace("'","''");
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
	//String pae=request.getParameter("pae");
	String testypeID[]=request.getParameterValues("testTypeID");
	String testnameID[]=request.getParameterValues("testNameID");
	String testresult[]=request.getParameterValues("testresult");
	
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			
  			for(int i=0;i<testnameID.length;i++) { 
                  
   String sql222="UPDATE MCENTER.TEST_SAVE_FOR_NEW_STUDENT SET RESULT='"+testresult[i]+"' WHERE TESTTYPEID='"+testypeID[i]+"' and TESTID='"+testnameID[i]+"' and RECEIPTNO='"+receiptNO+"'  ";
  				
  				ps5 = con.prepareStatement(sql222);
  			    ps5.executeQuery();				
  		
  		
              }
  			String weightfinal=weight+" "+"kg";
  			String pulsefinal=pulserate+"/min"+" "+pulserateCONDITION;
  			String bloodpressurefinalSystolic="Systolic"+" "+bloodpressureSystolic+" "+"mm of Hg";
  			String bloodpressurefinalDiastolic="Diastolic"+" "+bloodpressureDiastolic+" "+"mm of Hg";
  			String eyesightRfinal=eyesightR+" "+eyesightRCONDITION;
  			String eyesightLfinal=eyesightL+" "+eyesightLCONDITION;
  			
  			String sqlStudent="INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+height+"','"+weightfinal+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+bloodpressurefinalDiastolic+"')";
  			    

    
/*    ps3=con.prepareStatement("INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+height+"','"+weightfinal+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+bloodpressurefinalDiastolic+"')");
    */
/*    ps3=con.prepareStatement("INSERT INTO MCENTER.PHYSICALEXAMINATION_SAVE VALUES('"+receiptNO+"','"+height+"','"+weightfinal+"','"+pulsefinal+"'," +
    		"'"+bloodpressurefinalSystolic+"','"+eyesightRfinal+"','"+eyesightLfinal+"','"+colourblindness+"'," +
    				"'"+hearing+"','"+speech+"','"+lungs+"','"+heart+"','"+pae+"','"+bloodpressurefinalDiastolic+"')");*/
  	ps3 = con.prepareStatement(sqlStudent);
    ps3.executeUpdate(); 
    
    
    
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNO+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		
		
		globalheight=rs22.getString(2);
		globalweight=rs22.getString(3);
		globalpulserate=rs22.getString(4);
		globalbloodpressureSystolic=rs22.getString(5);
		globalbloodpressureDiastolic=rs22.getString(13);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
	//	globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
    String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNO+"'";
    ps2 = con.prepareStatement(sql2);
     
     
	 ResultSet rs2=ps2.executeQuery();
	 while(rs2.next()){
		
		
		
		receiptNUMBER=rs2.getString(1);
		acadenicsession=rs2.getString(2);
		studentname=rs2.getString(3);
		meritPosition=rs2.getString(4);
						 
		}
	   
    
    
	String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNUMBER+"' ";
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
		
/*	String sql66="Select RESULT from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where TESTID='" + testNameID + "' and TESTTYPEID='" + testTypeID + "' and RECEIPTNO='"+receiptNUMBER+"'" ;
		
		ps4=con.prepareStatement(sql66);
		ResultSet rs66=ps4.executeQuery();
		while(rs66.next()){
			
			//testType=rs6.getString(2);
			testResult=rs66.getString(1);
			}	*/
		
		
		
		MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
    
    
		System.out.println(testResult);
    
    
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
	

public String physicalexaminationANDtestREPORT(String receiptNONewstudent) throws Exception{

/*	HttpServletRequest request = ServletActionContext.getRequest();
	
	receiptNO=request.getParameter("receiptNO");*/
	

	
	
	
	
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
  			

    
    
    
    String sql22="Select * from MCENTER.PHYSICALEXAMINATION_SAVE where RECEIPTNO='"+receiptNONewstudent+"'";
    ps6= con.prepareStatement(sql22);
     
     
	 ResultSet rs22=ps6.executeQuery();
	 while(rs22.next()){
		
		
		globalheight=rs22.getString(2);
		globalweight=rs22.getString(3);
		globalpulserate=rs22.getString(4);
		globalbloodpressureSystolic=rs22.getString(5);
		globalbloodpressureDiastolic=rs22.getString(13);
		globaleyesightR=rs22.getString(6);
		globaleyesightL=rs22.getString(7);
		globalcolourblindness=rs22.getString(8);
		globalhearing=rs22.getString(9);
		globalspeech=rs22.getString(10);
		globallungs=rs22.getString(11);
		globalheart=rs22.getString(12);
		//globalpae=rs22.getString(13);
						 
		}
    
	 System.out.println("globalheight:"+globalheight);  
    
  /*  String sql2="Select * from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNONewstudent+"'";
    ps2 = con.prepareStatement(sql2);
     
     
	 ResultSet rs2=ps2.executeQuery();
	 while(rs2.next()){
			
		receiptNUMBER=rs2.getString(1);
		acadenicsession=rs2.getString(2);
		studentname=rs2.getString(3);
		meritPosition=rs2.getString(4);
						 
		}*/
	   
	 String sql2="Select RECIPSNO,SESSIONN,STUDENTNAME,MERITPOSITION,SEX,to_char(DOB,'dd/mm/yyyy') DOB,FATHER_NAME,REFDOCTOR_NAME,GROUP_ID from MCENTER.NEWSTDCHECKUPMONEYRECIPT where RECIPSNO='"+receiptNONewstudent+"'";
     ps2 = con.prepareStatement(sql2);
      
      
		 ResultSet rs2=ps2.executeQuery();
		 while(rs2.next()){
			
			
			
			receiptNO=rs2.getString(1);
			acadenicsession=rs2.getString(2);
			studentname=rs2.getString(3);
			meritPosition=rs2.getString(4);
			gender=rs2.getString("SEX"); 
			dob=rs2.getString("DOB"); 
			father=rs2.getString("FATHER_NAME"); 
			doctorName=rs2.getString("REFDOCTOR_NAME"); 
			group_id=rs2.getString("GROUP_ID");
			
			
			}
    
    
	String sql5="Select * from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNO+"' ";
	System.out.println("receiptNO:"+receiptNO);
	 PreparedStatement ps1=con.prepareStatement(sql5);
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
		

		
		
		MoneyReceiptforNewstudentMedicalCheckup test=new MoneyReceiptforNewstudentMedicalCheckup();
		
		test.setTestType(testType);
		test.setTestName(testName);
		test.setTestTypeID(testTypeID);
		test.setTestNameID(testNameID);
		test.setTestResult(testResult);
		
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		assignedTestlist.add(test);
    
    
		System.out.println(testResult);
    
    
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
	
public ArrayList<MoneyReceiptforNewstudentMedicalCheckup> getAssignedTestlist() {
	return assignedTestlist;
}
public void setAssignedTestlist(
		ArrayList<MoneyReceiptforNewstudentMedicalCheckup> assignedTestlist) {
	this.assignedTestlist = assignedTestlist;
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
public String getReceiptNUMBER() {
	return receiptNUMBER;
}
public void setReceiptNUMBER(String receiptNUMBER) {
	this.receiptNUMBER = receiptNUMBER;
}
public String getAcadenicsession() {
	return acadenicsession;
}
public void setAcadenicsession(String acadenicsession) {
	this.acadenicsession = acadenicsession;
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
public String getTestResult() {
	return testResult;
}
public void setTestResult(String testResult) {
	this.testResult = testResult;
}
public ArrayList<String> getFacultylist() {
	return facultylist;
}
public void setFacultylist(ArrayList<String> facultylist) {
	this.facultylist = facultylist;
}
public ArrayList<String> getDepartmentlist() {
	return departmentlist;
}
public void setDepartmentlist(ArrayList<String> departmentlist) {
	this.departmentlist = departmentlist;
}
public ArrayList<String> getDepartmentIDlist() {
	return departmentIDlist;
}
public void setDepartmentIDlist(ArrayList<String> departmentIDlist) {
	this.departmentIDlist = departmentIDlist;
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
	
public String getGroup_id() {
	return group_id;
}
public void setGroup_id(String group_id) {
	this.group_id = group_id;
}
public String getAcademic_session() {
	return academic_session;
}
public void setAcademic_session(String academic_session) {
	this.academic_session = academic_session;
}
public String getMerit_position() {
	return merit_position;
}
public void setMerit_position(String merit_position) {
	this.merit_position = merit_position;
}

public String getFather_name() {
	return father_name;
}

public void setFather_name(String father_name) {
	this.father_name = father_name;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getDoctorName() {
	return doctorName;
}

public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public String getGlobalidentificationMark() {
	return globalidentificationMark;
}

public void setGlobalidentificationMark(String globalidentificationMark) {
	this.globalidentificationMark = globalidentificationMark;
}

public String getGlobalchestnormal() {
	return globalchestnormal;
}

public void setGlobalchestnormal(String globalchestnormal) {
	this.globalchestnormal = globalchestnormal;
}

public String getGlobalchesttb() {
	return globalchesttb;
}

public void setGlobalchesttb(String globalchesttb) {
	this.globalchesttb = globalchesttb;
}

public String getGlobalchestlb() {
	return globalchestlb;
}

public void setGlobalchestlb(String globalchestlb) {
	this.globalchestlb = globalchestlb;
}

public String getGlobalnormalHealthCondition() {
	return globalnormalHealthCondition;
}

public void setGlobalnormalHealthCondition(String globalnormalHealthCondition) {
	this.globalnormalHealthCondition = globalnormalHealthCondition;
}

public String getGloballiver() {
	return globalliver;
}

public void setGloballiver(String globalliver) {
	this.globalliver = globalliver;
}

public String getGlobalsplees() {
	return globalsplees;
}

public void setGlobalsplees(String globalsplees) {
	this.globalsplees = globalsplees;
}

public String getGlobalhernia() {
	return globalhernia;
}

public void setGlobalhernia(String globalhernia) {
	this.globalhernia = globalhernia;
}

public String getGlobalanyPhysicalDisability() {
	return globalanyPhysicalDisability;
}

public void setGlobalanyPhysicalDisability(String globalanyPhysicalDisability) {
	this.globalanyPhysicalDisability = globalanyPhysicalDisability;
}

public String getGlobalskinDisease() {
	return globalskinDisease;
}

public void setGlobalskinDisease(String globalskinDisease) {
	this.globalskinDisease = globalskinDisease;
}

public String getGlobalear() {
	return globalear;
}

public void setGlobalear(String globalear) {
	this.globalear = globalear;
}

public String getGlobalnose() {
	return globalnose;
}

public void setGlobalnose(String globalnose) {
	this.globalnose = globalnose;
}

public String getGlobalteeth() {
	return globalteeth;
}

public void setGlobalteeth(String globalteeth) {
	this.globalteeth = globalteeth;
}

public String getGlobalothers() {
	return globalothers;
}

public void setGlobalothers(String globalothers) {
	this.globalothers = globalothers;
}

public DateFormat getDateFormat() {
	return dateFormat;
}

public void setDateFormat(DateFormat dateFormat) {
	this.dateFormat = dateFormat;
}

public String getDataString() {
	return dataString;
}

public void setDataString(String dataString) {
	this.dataString = dataString;
}

}
