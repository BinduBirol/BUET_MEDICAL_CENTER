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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.ConnectionUtil.ConnectionManager;
import util.login.ValidateUser;


import com.mcenter.totalBill.TotalBillofEmployee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class DailyRegularTestBill extends ActionSupport{

	
	private String doctorID;
	private String doctorName;
	private String prescriptionID;
	private String prescriptionDate;
	private String medicalID;
	private String medicalIDholderName;
	private String departmentID;
	private String department;
	private String patientName;
	private String patientRelationWithIDholder;
	private String visitID;
	private String designation;
	private String medicineID;
	private String patientID;
	private String medicineName;
	private int medicineQuantity;
	private String vID;
	private String serialNO;
	private String ageStr;
	private String gender;
	private String inword;
	private String billID;
	private String status;
	private String billStatus;
	private String newBillYN="N";
	
	
	private String testType;
	private String testName;
	private String testTypeID;
	private String testNameID;
	
	
	double rate;
	double cost;
	double temp;
	double total=0;
	double vat;
	private double individualCOST;
	ArrayList<TotalBillofEmployee> totalbillList=new ArrayList<TotalBillofEmployee>();
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps8 = null;
	PreparedStatement ps9 = null;
	PreparedStatement ps10= null;
	PreparedStatement ps55 = null;
	PreparedStatement ps58 = null;
   
	ArrayList<DailyRegularTestBill> dailyRegularTestBilllist=new ArrayList<DailyRegularTestBill>();
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	   //get current date time with Date()
	Date date = new Date();
	String Date = dateFormat.format(date);
	
    
	DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
	//get current date time with Date()
	Date serialdate1 = new Date();
	String DateofSerial1 = dateFormat1.format(serialdate1);
  	
  	   
	public String execute() throws Exception{
	//	System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
	/*		
		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
			con.setAutoCommit(false);
             
             
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
			
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
 				
			}
 			
				
			String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+visitID +"'";
 	            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			PreparedStatement ps12 = con.prepareStatement(sql12);
 		         
 		         
			ResultSet rs12=ps12.executeQuery();
			while(rs12.next()){		
				medicalID=rs12.getString(1);
				patientID=rs12.getString(2);
				patientName=rs12.getString(3);
			}
 			
 				
			if(medicalID!=null){
				if(medicalID.equals(patientID))
				{
					patientRelationWithIDholder="Self"; 
 		        	 
				}
 		         
				else{
 		        	  		        	
					PreparedStatement ps11=con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='"+patientID+"'  ");
					ResultSet rs11=ps11.executeQuery();
					while(rs11.next()){
 		        	     
						patientRelationWithIDholder=rs11.getString(6); 
 		                   
					}        		        	    		         
				}
			}
 			
 		//System.out.println(medicalID);
 			//////////////////////////////////////////////	/
 			  
			String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
			ps2 = con.prepareStatement(sql2);
 		          		         
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next()){
				medicalIDholderName=rs2.getString(2);
				department=rs2.getString(3);
				designation=rs2.getString(4);
 					
			}
 				 
			if(designation==null)
			{
				designation="Student";	 
 					 
			}
 			  

// 			 System.out.println(doctorID);
			String sql3="Select distinct name doctor_name from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
			ps3 = con.prepareStatement(sql3);		         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
 					
				doctorName=rs3.getString("doctor_name");
 					
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
	
	public String testTABLE() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		serialNO=request.getParameter("serial");
		
//		System.out.println(" hi...Adnan");
		//System.out.println(serialNO);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
			con.setAutoCommit(false);
             
             
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
			ps1 = con.prepareStatement(sql1);
	         	         
			ResultSet rs1=ps1.executeQuery();
 			while(rs1.next()){
 				prescriptionDate=rs1.getString(1);
 				prescriptionID=rs1.getString(2);
 				doctorID=rs1.getString(3);
				
 			}
 			
 			
 			String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+serialNO+"'";
 	            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
 			PreparedStatement ps12 = con.prepareStatement(sql12);
 		          		         
 			ResultSet rs12=ps12.executeQuery();
 			while(rs12.next()){
		
 				medicalID=rs12.getString(1);
 				patientID=rs12.getString(2);
 				patientName=rs12.getString(3);
 			}
			
 			if(medicalID.equals(patientID))
 			{
 				patientRelationWithIDholder="Self"; 
 		        	 
 			}
 		         
 			else{
 				PreparedStatement ps11=con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='"+patientID+"'  ");
 				ResultSet rs11=ps11.executeQuery();
 				while(rs11.next()){
 		        	     
 					patientRelationWithIDholder=rs11.getString(6); 
 		                   
 				}       
 		        	    
 		         
 			}
 			
 		//System.out.println(medicalID);
 			//////////////////////////////////////////////	/
 			  
 			  String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
 		        ps2 = con.prepareStatement(sql2);
 		         
                ResultSet rs2=ps2.executeQuery();
 				while(rs2.next()){

 					medicalIDholderName=rs2.getString(2);
 					department=rs2.getString(3);
 					designation=rs2.getString(4);
 					
 				}
 				 
 				if(designation==null)
 				{
 					designation="Student";	 
 					 
 				}
 			  
 			  /////////////////////////////////////////////
 			
// 			 System.out.println(doctorID);
 				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
 				ps3 = con.prepareStatement(sql3);
 				ResultSet rs3=ps3.executeQuery();
 				while(rs3.next()){

 					doctorName=rs3.getString(3);
 					
 				}
      
             
     /////////////////////////////////////////////////////
	
             
			
 				String sql5="Select a.TESTTYPEID,a.TESTID,a.STATUS from MCENTER.TEST_SAVE a,MCENTER.TESTS b where a.TESTID=b.TESTID and b.STATUS='Available' and  PRESCRIPTIONID ='"+prescriptionID+"' ";
 				System.out.println("prescriptionID:"+prescriptionID);
 				ps58=con.prepareStatement(sql5);
 				ResultSet rs=ps58.executeQuery();
 				while(rs.next()){
					
 					testTypeID=rs.getString("TESTTYPEID");
 					testNameID=rs.getString("TESTID");
 					billStatus=rs.getString("STATUS");
				 
			
               //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
               	
 					String sql6="Select * from MCENTER.TESTS where TESTID=" + testNameID + " and TESTTYPEID=" + testTypeID;
				
 					ps6=con.prepareStatement(sql6);
 					ResultSet rs6=ps6.executeQuery();
 					while(rs6.next()){
					
					//testType=rs6.getString(2);
 						testName=rs6.getString(1);
 						testNameID=rs6.getString(8);
 						rate=rs6.getDouble(4);
 						vat=rs6.getDouble(5);
					
			 
				}				
				
          // String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
 					String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=" + testTypeID ;
           
 					ps7=con.prepareStatement(sql7);
 					ResultSet rs7=ps7.executeQuery();
 					while(rs7.next()){
 						testTypeID=rs7.getString(1);
 						testType=rs7.getString(2);
			 
 					}

 					cost=((vat*rate)/100)+rate;
 					temp= cost;
 					total =total+temp;
			
 					DailyRegularTestBill tbill=new DailyRegularTestBill();
				
 					tbill.setTestType(testType);
 					tbill.setTestTypeID(testTypeID);
 					tbill.setTestName(testName);
 					tbill.setTestNameID(testNameID);
 					tbill.setRate(rate);
 					tbill.setCost(cost);
 					tbill.setVat(vat);
 					tbill.setTotal(total);
 					tbill.setBillStatus(billStatus);
				//a=rs2.getString(16);
			    //	b=rs2.getInt(17);
				
 					dailyRegularTestBilllist.add(tbill);
	
 				}

//			System.out.println("Total:"+total);

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
	

	
	public String testbillTABLEsave() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
	
		serialNO=request.getParameter("serial");
		String totalbillamount=request.getParameter("totalcost");
		
		String[] testTypeID=null;
		String[] testID=null;
		String checkedTest[]=request.getParameterValues("checkedtest");

		if(checkedTest!=null) {
	//		System.out.println("applicationID Problem!!!!!!!!!!!!!!!!!!!!!!!!!!");
			testTypeID = new String[checkedTest.length]; 
			testID = new String[checkedTest.length] ;
			for(int i=0;i<checkedTest.length;i++){
	//			System.out.println("applicationID 1 Problem!!!!!!!!!!!!!!!!!!!!!!!!!!");
				String serialNo=checkedTest[i];
				String[] parts = serialNo.split("#");
				String string1 = parts[0]; 
				String string2 = parts[1];
				testTypeID[i]=string1;
				testID[i]=string2;
			}
			
		}
		
		Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
			Map<String, Object> session = ActionContext.getContext().getSession();
			UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
    		
//			System.out.println(user.getUserfullname());
 //   		System.out.println(user.getUserdesignation());
    		
			con.setAutoCommit(false);
             
			String sql1z="Select PRESCRIPTIONID from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
			PreparedStatement   ps1z = con.prepareStatement(sql1z);
 	         
 	         
			ResultSet rs1z=ps1z.executeQuery();
			while(rs1z.next()){

				prescriptionID=rs1z.getString("PRESCRIPTIONID");
 				
			}
 			
 			
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'mm/dd/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
              // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps1 = con.prepareStatement(sql1);
  	         
  	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){

				prescriptionID=rs1.getString("PRESCRIPTIONID");
				doctorID=rs1.getString("DOCTORID");
				prescriptionDate=rs1.getString("PRESCRIPTIONDATE");
  				
			}
  			
  			
			String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+serialNO+"'";
			// String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			PreparedStatement ps12 = con.prepareStatement(sql12);
  		           		         
			ResultSet rs12=ps12.executeQuery();
			while(rs12.next()){
				medicalID=rs12.getString("PERSONID");
				patientID=rs12.getString("PATIENTID");
				patientName=rs12.getString("PATIENTNAME");
			}
			
  			  if(medicalID.equals(patientID))
  			  {
  				  patientRelationWithIDholder="Self"; 
  				  
  			  }
  		         
  			  else{
     	
  				  PreparedStatement ps11=con.prepareStatement("select RELATION from MCENTER.DEPENDENCY where DEPENDENTID='"+patientID+"'  ");
  				  ResultSet rs11=ps11.executeQuery();
  				  while(rs11.next()){
  		        	     
  					  patientRelationWithIDholder=rs11.getString("RELATION"); 
  		                   
  				  }       
 				  
  			  }
  			
  		//System.out.println(medicalID);
  			//////////////////////////////////////////////	/
  			  
  			  String sql2="select distinct t1.id, t1.name NAME ,t1.departmentname departmentname,t1.DESIGNATION DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
  			  ps2 = con.prepareStatement(sql2);
  		         
  		         
  			  ResultSet rs2=ps2.executeQuery();
  			  while(rs2.next()){
	
  				  medicalIDholderName=rs2.getString("NAME");
  				  department=rs2.getString("departmentname");
  				  designation=rs2.getString("DESIGNATION");
  					
  			  }
  				 
  			  if(designation==null)
  			  {
  				  designation="Student";	 
  					 
  			  }
 			 
 			 
 			 
 			 ///////////////////////////////////////////////////////////
  			  System.out.println(doctorID);
  			  String sql3="Select distinct(NAME) from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
  			  ps3 = con.prepareStatement(sql3);
 		         		         
  			  ResultSet rs3=ps3.executeQuery();
  			  while(rs3.next()){
			
  				  doctorName=rs3.getString("NAME");
 					
  			  }            
  			  String sql33="Select count(*) from MCENTER.PATIENTTESTBILL where BILLINGDATE=to_date('"+Date+"','dd/mm/yyyy')";
  			  ps8= con.prepareStatement(sql33);
  	         
  	         
  			  ResultSet rs33=ps8.executeQuery();
  			  while(rs33.next()){
  				
  				
  				  int	billcount=rs33.getInt(1);	
  				  billcount=billcount+1;           
  				  billID=DateofSerial1+"-testbill:"+billcount; 		
				}  	
  			  
  			  for(int i=0;i<testID.length;i++)
  			  {
  				if(testID!=null ) { 
  					/*if(Integer.valueOf(testTypeID[i])<10)
  					{
  						testTypeID[i]=Integer.valueOf(testTypeID[i]).toString();
  					}*/
  					
  				/*	******TEST AVIALABLE KInA TA ADD KORTE HOBE********/
  					String sql77="Select STATUS from MCENTER.TEST_SAVE where PRESCRIPTIONID='"+prescriptionID+"' and TESTID='"+testID[i]+"' and TESTTYPEID='"+testTypeID[i]+"'";
     				
					PreparedStatement ps55=con.prepareStatement(sql77);
					ResultSet rs77=ps55.executeQuery();
					while(rs77.next()){
		     					
						status=rs77.getString(1);
						System.out.println("status="+status);
		     			 
					}
					
					
					  if(status.equalsIgnoreCase("Not Taken")){
							
		  				  String sql222="UPDATE MCENTER.TEST_SAVE SET STATUS='Taken' WHERE  PRESCRIPTIONID='"+prescriptionID+"' and TESTID='"+testID[i]+"' and TESTTYPEID='"+testTypeID[i]+"' ";
								
		  				  ps5 = con.prepareStatement(sql222);
		  				  ps5.executeQuery();
		  				  
		  				newBillYN="Y";
							
		  				  
		             
		  			  }	
  					
  				}
  			  }
  			  
  			  
  			String sql4="Select TESTID from MCENTER.TEST_SAVE where PRESCRIPTIONID='"+prescriptionID+"' and STATUS='Taken' and BILL_COMPLETED_YN='N' ";
			
			ps4=con.prepareStatement(sql4);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next()){
				testNameID=rs4.getString("TESTID");
				
				String sql5="Select * from MCENTER.TESTS where TESTID ='"+testNameID+"'";
				
				ps5=con.prepareStatement(sql5);
				ResultSet rs5=ps5.executeQuery();
				while(rs5.next())
				{
				testName=rs5.getString("TESTNAME");
				rate=rs5.getDouble("RATE");
				System.out.println("rate="+rate);
							
				}
				total =total+rate;
				

			    String sql="Select count(*) from MCENTER.PATIENTTESTBILL where BILLINGDATE=to_date('"+Date+"','dd/mm/yyyy')";
     	        ps8= con.prepareStatement(sql);
     	         
     	         
     			ResultSet rs=ps8.executeQuery();
     			while(rs.next()){
     				
     				
     			int	billcount=rs.getInt(1);	

     			billcount=billcount+1;
                 
     			billID=DateofSerial1+"-medbill:"+billcount; 
			}
			
			////////////////////********* ekhan thyeke shuru hobe
     			
     			
     			String sqlBillCreate="UPDATE MCENTER.TEST_SAVE SET TEST_BILLID='"+billID+"',BILL_COMPLETED_YN='Y' WHERE TESTID ='"+testNameID+"' and PRESCRIPTIONID='"+prescriptionID+"'  ";
					
     			ps5 = con.prepareStatement(sqlBillCreate);
     			ps5.executeQuery();
			
     			
     			
     			
     		
			
			}	
			
			
			
 			if(newBillYN.equalsIgnoreCase("Y")){
 				
 				String sql="INSERT INTO MCENTER.PATIENTTESTBILL (TESTBILLID,MEDICALID,REFDOCTOR,PATIENTNAME,VISITID,VISITINGDATE,BILLINGAMOUNT,USERID,BILLINGDATE)" +
 						" VALUES('"+billID+"','"+medicalID+"','"+doctorID+"','"+patientName+"','"+serialNO+"',to_date('"+prescriptionDate+"','mm/dd/yyyy'),'"+total+"','"+user.getUsername()+"',to_date('"+Date+"','dd/mm/yyyy'))";
				ps9=con.prepareStatement(sql);
			    ps9.executeUpdate(); 
			 
			    System.out.println("Billing is successfully done...............");
				}
				
				
				else{
				System.out.println("Billing has previously done...............");
				}
				
 			String medBill="select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),TESTBILLID,VISITID,BILLINGAMOUNT from MCENTER.PATIENTTESTBILL where VISITID='"+serialNO+"' ";

			
			PreparedStatement ps1=con.prepareStatement(medBill);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
					
				TotalBillofEmployee pt = new TotalBillofEmployee();
	                
				pt.setDate(rs.getString(1));
				pt.setBillNo(rs.getString(2));
				pt.setVisitID(rs.getString(3));
					
					
				individualCOST=rs.getDouble(4);
				temp=individualCOST;
				total =total+temp;	
				pt.setCost(individualCOST);
				
				totalbillList.add(pt);	
				
			 
				}
         
		
			  con.commit();
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
			if (con != null) {
				try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in DailyRegularTestBill at testbillTABLEsave()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
			}
		 
		}
		
		finally {
		       
		       
			if (ps8!= null) {
				ps8.close();
			}
		       
			con.setAutoCommit(true);
			con.close();
		}
		
		return "success";
   
	}
		
	
	
	public String demoreport(String visitID) throws Exception{
	
	
	
	//HttpServletRequest request = ServletActionContext.getRequest();
	
	//visitID=request.getParameter("serialNo");
	
	//patientID=request.getParameter("patientlId");
	 
		
//		System.out.println(" hi...Adnan.....PDF new");
//		System.out.println("Send Visit ID:"+visitID);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
       
        
 			
 			
              String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+visitID+"'";
              // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
  	         ps1 = con.prepareStatement(sql1);
  	         
  	         
  			ResultSet rs1=ps1.executeQuery();
  			while(rs1.next()){
  				
  				
  				
  				
  				
  				prescriptionID=rs1.getString(2);
  				doctorID=rs1.getString(3);
  				prescriptionDate=rs1.getString(1);
  				
  				}
  			
  			
  			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME,VISITID from MCENTER.PATIENT_HISTORY where VISITID='"+visitID+"'";
  	            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
  			   PreparedStatement ps12 = con.prepareStatement(sql12);
  		         
  		         
  				ResultSet rs12=ps12.executeQuery();
  				while(rs12.next()){
  					
  			
  					medicalID=rs12.getString(1);
  					patientID=rs12.getString(2);
  					patientName=rs12.getString(3);
  					vID=rs12.getString(4);
  					}
  			
  			///////////////////////////
  				//age+sex
  				
  			////////////////////////////
  				
  			  if(medicalID.equals(patientID))
  		         {
  				  patientRelationWithIDholder="Self"; 
  		        	 
  		         }
  		         
  		         else{
  		        	 
  		        	
  		         PreparedStatement ps11=con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='"+patientID+"'  ");
  		         ResultSet rs11=ps11.executeQuery();
  		         while(rs11.next()){
  		        	     
  		        	 patientRelationWithIDholder=rs11.getString(6); 
  		                   
  		         }       
  		        	    
  		         
  		         }
  			
  		//System.out.println(medicalID);
  			//////////////////////////////////////////////	/
  			  
  			  String sql2="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
  		        ps2 = con.prepareStatement(sql2);
  		         
  		         
  				 ResultSet rs2=ps2.executeQuery();
  				 while(rs2.next()){
  					
  					
  					
  					
  					
  					 medicalIDholderName=rs2.getString(2);
  			         department=rs2.getString(3);
  					 designation=rs2.getString(4);
  					
  					}
  				 
  				 if(designation==null)
  				 {
  					 designation="Student";	 
  					 
  				 }
 			 
 			 
 			 
 			 ///////////////////////////////////////////////////////////
 			 System.out.println("doctorID:"+doctorID);
 				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
 		        ps3 = con.prepareStatement(sql3);
 		         
 		         
 				 ResultSet rs3=ps3.executeQuery();
 				 while(rs3.next()){
 					
 					
 					
 					
 					
 					 doctorName=rs3.getString(3);
 					
 					}
          
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
 				System.out.println("prescriptionID:"+prescriptionID);     
 				
 				String sql5="Select * from MCENTER.TEST_SAVE where PRESCRIPTIONID ='"+prescriptionID+"' ";
 				
 				ps5=con.prepareStatement(sql5);
 				ResultSet rs5=ps5.executeQuery();
 				while(rs5.next()){
 					
 					testTypeID=rs5.getString(2);
 					testNameID=rs5.getString(3);
 					 
 					
 	               //String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"'";
 					String sql6="Select * from MCENTER.TESTS where TESTID=lpad('" + testNameID + "',2,'0') and TESTTYPEID=lpad('" + testTypeID + "',2,'0') " ;
 					
 					ps6=con.prepareStatement(sql6);
 					ResultSet rs6=ps6.executeQuery();
 					while(rs6.next()){
 						//testType=rs6.getString(2);
 						testName=rs6.getString(1);
 						rate=rs6.getDouble(4);
 						vat=rs6.getDouble(5);
 						
 				 
 					}				
 					
 	        //   String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID='"+testTypeID+"' ";
 					String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0') ";
 					ps7=con.prepareStatement(sql7);
 					ResultSet rs7=ps7.executeQuery();
 					while(rs7.next()){
 						testType=rs7.getString(2);
 						
 						
 				 
 					}
 					
 					
 					
 					
 					
 					 cost=((vat*rate)/100)+rate;
 					 temp= cost;
 					 total =total+temp;
 					
 					
 					DailyRegularTestBill tbill=new DailyRegularTestBill();
 					
 					tbill.setTestType(testType);
 					tbill.setTestName(testName);
 					tbill.setRate(rate);
 					tbill.setCost(cost);
 					tbill.setVat(vat);
 					tbill.setTotal(total);
 					//a=rs2.getString(16);
 				    //	b=rs2.getInt(17);
 					
 					dailyRegularTestBilllist.add(tbill);
 					
 					
 				
 					
 					
 					
 					
 					}
 				
			
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Size of list:"+dailyRegularTestBilllist.size());
			 String sqlinword="select MCENTER.numbertoword('"+total+"') from dual";
				
				ps8=con.prepareStatement(sqlinword);
				ResultSet rs55=ps8.executeQuery();
				while(rs55.next()){
					inword=rs55.getString(1);  					
					
									}
    ////////////////////////////////////////     
				String sql10="select distinct t1.id, t1.name,t1.date_of_birth,t1.gender from(select STUDENTID id,STUDENTNAME name,TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+patientID+"'" +
						"union " +
						"select OFFICIAL_ID id, NAME name,TO_CHAR(DATE_OF_BIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+patientID+"'" +
						"union " +
						"select DEPENDENTID id, DNAME name,TO_CHAR(DOB, 'dd/mm/yyyy') date_of_birth,SEX gender from DEPENDENCY where DEPENDENCY.DEPENDENTID='"+patientID+"')t1";
									
									ps9=con.prepareStatement(sql10);
									ResultSet rs10=ps9.executeQuery();
									while(rs10.next()){
										String dob;
										
										gender=rs10.getString(4);
										dob=rs10.getString(3);
										if(dob!=null){
										org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
										
										org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dob);
										org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
										org.joda.time.DateTime now = new org.joda.time.DateTime();
										org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
										
										ageStr = java.lang.String.valueOf (age.getYears());
										}
										
										 if(gender==null)
											{
												gender="N/A";	
												
											}
										 else{
										if(gender.equals("M"))
										
										{
											gender="Male";
											
										}
										
										else if(gender.equals("F"))
										{
											gender="Female";	
											
										}
										 }
										
										if(dob==null)
										
										{
											
											ageStr ="N/A";
										}
 			
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
	
	
	
	
public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getBillID() {
	return billID;
}


public void setBillID(String billID) {
	this.billID = billID;
}


public String getInword() {
	return inword;
}


public void setInword(String inword) {
	this.inword = inword;
}


public String getPatientID() {
	return patientID;
}


public void setPatientID(String patientID) {
	this.patientID = patientID;
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


public String getDoctorID() {
	return doctorID;
}


public void setDoctorID(String doctorID) {
	this.doctorID = doctorID;
}


public String getPrescriptionID() {
	return prescriptionID;
}


public void setPrescriptionID(String prescriptionID) {
	this.prescriptionID = prescriptionID;
}


public String getMedicalIDholderName() {
	return medicalIDholderName;
}


public void setMedicalIDholderName(String medicalIDholderName) {
	this.medicalIDholderName = medicalIDholderName;
}


public String getDepartmentID() {
	return departmentID;
}


public void setDepartmentID(String departmentID) {
	this.departmentID = departmentID;
}


public String getPatientRelationWithIDholder() {
	return patientRelationWithIDholder;
}


public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
	this.patientRelationWithIDholder = patientRelationWithIDholder;
}


public String getDesignation() {
	return designation;
}


public void setDesignation(String designation) {
	this.designation = designation;
}


public String getMedicineID() {
	return medicineID;
}


public void setMedicineID(String medicineID) {
	this.medicineID = medicineID;
}


public String getMedicineName() {
	return medicineName;
}


public void setMedicineName(String medicineName) {
	this.medicineName = medicineName;
}


public int getMedicineQuantity() {
	return medicineQuantity;
}


public void setMedicineQuantity(int medicineQuantity) {
	this.medicineQuantity = medicineQuantity;
}


public String getSerialNO() {
	return serialNO;
}


public void setSerialNO(String serialNO) {
	this.serialNO = serialNO;
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


public double getTotal() {
	return total;
}



public void setTotal(double total) {
	this.total = total;
}


public String getvID() {
	return vID;
}


public void setvID(String vID) {
	this.vID = vID;
}

public ArrayList<DailyRegularTestBill> getDailyRegularTestBilllist() {
	return dailyRegularTestBilllist;
}


public void setDailyRegularTestBilllist(
		ArrayList<DailyRegularTestBill> dailyRegularTestBilllist) {
	this.dailyRegularTestBilllist = dailyRegularTestBilllist;
}


public String getDoctorName() {
	return doctorName;
}


public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}

public String getPrescriptionDate() {
	return prescriptionDate;
}


public void setPrescriptionDate(String prescriptionDate) {
	this.prescriptionDate = prescriptionDate;
}



public String getMedicalID() {
	return medicalID;
}

public void setMedicalID(String medicalID) {
	this.medicalID = medicalID;
}

public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}

public String getPatientName() {
	return patientName;
}


public void setPatientName(String patientName) {
	this.patientName = patientName;
}

public String getVisitID() {
	return visitID;
}

public void setVisitID(String visitID) {
	this.visitID = visitID;
}

public double getIndividualCOST() {
	return individualCOST;
}

public void setIndividualCOST(double individualCOST) {
	this.individualCOST = individualCOST;
}

public ArrayList<TotalBillofEmployee> getTotalbillList() {
	return totalbillList;
}

public void setTotalbillList(ArrayList<TotalBillofEmployee> totalbillList) {
	this.totalbillList = totalbillList;
}

	
}
