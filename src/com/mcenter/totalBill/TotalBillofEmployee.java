package com.mcenter.totalBill;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;


import com.mcenter.labtestBillManagement.DailyRegularTestBill;
import com.opensymphony.xwork2.ActionSupport;





public class TotalBillofEmployee extends ActionSupport {
	
	
	private String testType;
	private String testName;
	private String testTypeID;
	private String testNameID;
	
	double vat;
	/////////////////////////////////////
	private String serialNumber;
	private String billID;
	private String doctorID;
	private String doctorName;
	private String prescriptionID;
	private String prescriptionDate;
	
	private String medicalIDholderName;
	private String departmentID;
	
	private String patientName;
	private String patientID;
	private String patientRelationWithIDholder;
	
	private String inword;
	private String inwordTest;
	private String ageStr;
	private String gender;
	private String medicineID;
	private String medicineName;
	private int medicineQuantity;
	
	private String serialNO;
	
	double rate;
	int quantity;
	
	
	/////////////////////////////////
	private String medicalID;
	private String name;
	private String department;
	private String designation;
	private String fdate;
	private String tdate;
	
	private String billNo;
	private String visitID;
	private String date;
	private double cost;
	
	
	private double individualCOST;
	private double temp;
	private double total=0;
	///////////
	
	
	private String testbillNo;
	private String testvisitID;
	private String testdate;
	private double testcost;
	
	
	private double testindividualCOST;
	private double testtemp;
	private double testtotal=0;
	
	/////////////////////////////////////
	
	

	
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps55 = null;

	
	ArrayList<TotalBillofEmployee> pharmacyMedicineBilllist=new ArrayList<TotalBillofEmployee>();
	ArrayList<TotalBillofEmployee> totalbillList=new ArrayList<TotalBillofEmployee>();
	ArrayList<TotalBillofEmployee> totalTestbillList=new ArrayList<TotalBillofEmployee>();
	ArrayList<TotalBillofEmployee> dailyRegularTestBilllist=new ArrayList<TotalBillofEmployee>();
	
	
	
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getInwordTest() {
		return inwordTest;
	}
	public void setInwordTest(String inwordTest) {
		this.inwordTest = inwordTest;
	}
	public String getInword() {
		return inword;
	}
	public void setInword(String inword) {
		this.inword = inword;
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
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
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
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public ArrayList<TotalBillofEmployee> getDailyRegularTestBilllist() {
		return dailyRegularTestBilllist;
	}
	public void setDailyRegularTestBilllist(
			ArrayList<TotalBillofEmployee> dailyRegularTestBilllist) {
		this.dailyRegularTestBilllist = dailyRegularTestBilllist;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getSerialNO() {
		return serialNO;
	}
	public void setSerialNO(String serialNO) {
		this.serialNO = serialNO;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ArrayList<TotalBillofEmployee> getPharmacyMedicineBilllist() {
		return pharmacyMedicineBilllist;
	}
	public void setPharmacyMedicineBilllist(
			ArrayList<TotalBillofEmployee> pharmacyMedicineBilllist) {
		this.pharmacyMedicineBilllist = pharmacyMedicineBilllist;
	}
	public String getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPrescriptionID() {
		return prescriptionID;
	}
	public void setPrescriptionID(String prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	public String getPrescriptionDate() {
		return prescriptionDate;
	}
	public void setPrescriptionDate(String prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientRelationWithIDholder() {
		return patientRelationWithIDholder;
	}
	public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
		this.patientRelationWithIDholder = patientRelationWithIDholder;
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
	public String getTestbillNo() {
		return testbillNo;
	}
	public void setTestbillNo(String testbillNo) {
		this.testbillNo = testbillNo;
	}
	public String getTestvisitID() {
		return testvisitID;
	}
	public void setTestvisitID(String testvisitID) {
		this.testvisitID = testvisitID;
	}
	public String getTestdate() {
		return testdate;
	}
	public void setTestdate(String testdate) {
		this.testdate = testdate;
	}
	public double getTestcost() {
		return testcost;
	}
	public void setTestcost(double testcost) {
		this.testcost = testcost;
	}
	public double getTestindividualCOST() {
		return testindividualCOST;
	}
	public void setTestindividualCOST(double testindividualCOST) {
		this.testindividualCOST = testindividualCOST;
	}
	public double getTesttemp() {
		return testtemp;
	}
	public void setTesttemp(double testtemp) {
		this.testtemp = testtemp;
	}
	public double getTesttotal() {
		return testtotal;
	}
	public void setTesttotal(double testtotal) {
		this.testtotal = testtotal;
	}
	public double getIndividualCOST() {
		return individualCOST;
	}
	public void setIndividualCOST(double individualCOST) {
		this.individualCOST = individualCOST;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getVisitID() {
		return visitID;
	}
	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public ArrayList<TotalBillofEmployee> getTotalbillList() {
		return totalbillList;
	}
	public void setTotalbillList(ArrayList<TotalBillofEmployee> totalbillList) {
		this.totalbillList = totalbillList;
	}

	
	public ArrayList<TotalBillofEmployee> getTotalTestbillList() {
		return totalTestbillList;
	}
	public void setTotalTestbillList(
			ArrayList<TotalBillofEmployee> totalTestbillList) {
		this.totalTestbillList = totalTestbillList;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMedicalID() {
		return medicalID;
	}

	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}



	public String searchPerson(){
		System.out.println("HIT:"+medicalID);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		
		try{

/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			
	        
		//     String sql="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
		     String sql="SELECT DISTINCT t1.id,\n" +
	                    "                t1.name,\n" +
	                    "                t1.departmentname,\n" +
	                    "                t1.DESIGNATION\n" +
	                    "  FROM (SELECT STUDENTID id,\n" +
	                    "               STUDENTNAME name,\n" +
	                    "               DEPARTMENTID departmentname,\n" +
	                    "               'Student' DESIGNATION\n" +
	                    "          FROM BIIS.STUDENT\n" +
	                    "         WHERE BIIS.STUDENT.STUDENTID ='"+medicalID+"'\n" +
	                    "        UNION\n" +
	                    "        SELECT OFFICIAL_ID id,\n" +
	                    "               NAME name,\n" +
	                    "               (SELECT SHORT_DEPARTMENT_NAME\n" +
	                    "                  FROM ESTABLISHMENT.DEPARTMENT\n" +
	                    "                 WHERE DEPARTMENT_ID =\n" +
	                    "                          (SELECT DEPARTMENT_ID\n" +
	                    "                             FROM ESTABLISHMENT.PERSONNEL\n" +
	                    "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID =\n" +
	                    "                                     '"+medicalID+"'))\n" +
	                    "                  departmentname,\n" +
	                    "               (SELECT SHORT_DESIGNATION\n" +
	                    "                  FROM ESTABLISHMENT.DESIGNATION\n" +
	                    "                 WHERE DESIGNATION_ID =\n" +
	                    "                          (SELECT CURRENT_DESIGNATION_ID\n" +
	                    "                             FROM ESTABLISHMENT.PERSONNEL\n" +
	                    "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID =\n" +
	                    "                                     '"+medicalID+"'))\n" +
	                    "                  DESIGNATION\n" +
	                    "          FROM ESTABLISHMENT.PERSONNEL\n" +
	                    "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1";
		     
		     
		     PreparedStatement  ps = con.prepareStatement(sql);
		     
		     
	        /* PreparedStatement ps=con.prepareStatement("select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'  ");*/
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()){
	        	     
	        	 name=rs.getString(2);
	        	 department=rs.getString(3);
	        	 designation=rs.getString(4);
	                   
	           			
	         }
	         
/*	         if(designation==null)
				 {
					 designation="Student";	 
					 
				 }*/
	         
	                
	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}
	
	public String totalBillofemployee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		medicalID=request.getParameter("medicalID");
		name=request.getParameter("name");
		department=request.getParameter("department");
		designation=request.getParameter("designation");
		fdate=request.getParameter("fdate");
		tdate=request.getParameter("tdate");
		
		
		
		System.out.println("HIT:"+medicalID);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		//PreparedStatement stmt = null;
		//ResultSet r = null;
		try{

			System.out.println("Medical id:"+medicalID);
			System.out.println("From Date:"+fdate);
			System.out.println("TO date:"+tdate);
			
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			
		    /*for(int i=16;i<123;i++) 
		    {
		     PreparedStatement ps=con.prepareStatement("insert into MCENTER.SUB_STORE values('"+i+"',1000,4.5)");
		       //  PreparedStatement ps=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+patientNumber+"','"+serialNo+"','"+doctorName+"' ,'"+serialedpatientName+"','"+Date+"')");
			ps.executeUpdate();
		      }*/
		     
		     String sql1=" select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),BILLID,VISITID,BILLAMOUNT from MCENTER.PATIENTMEDBILL where MEDICALID='"+medicalID+"' and VISITINGDATE between to_date('"+fdate+"','dd/mm/yyyy') and to_date('"+tdate+"','dd/mm/yyyy') ";

			
		     
		 	ps1=con.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				
               TotalBillofEmployee pt = new TotalBillofEmployee();
                
                pt.setDate(rs.getString(1));
				pt.setBillNo(rs.getString(2));
				pt.setVisitID(rs.getString(3));
				
				
				 individualCOST=rs.getDouble(4);
				 temp=individualCOST;
				 total =total+temp;
				 System.out.println("individualCOST:"+individualCOST);
				 System.out.println("total:"+total);
				pt.setCost(individualCOST);
				
				
			
				totalbillList.add(pt);	
				
		 
			}
			
			
			
			
		     String sql2="select TO_CHAR(VISITINGDATE,'dd/mm/yyyy'),TESTBILLID,VISITID,BILLINGAMOUNT  from MCENTER.PATIENTTESTBILL where MEDICALID='"+medicalID+"' and VISITINGDATE between to_date('"+fdate+"','dd/mm/yyyy') and to_date('"+tdate+"','dd/mm/yyyy') ";

		     
		     
			 	ps2=con.prepareStatement(sql2);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					System.out.println("????????????????");
	               TotalBillofEmployee test = new TotalBillofEmployee();
				
	               test.setTestdate(rs2.getString(1));
	               test.setTestbillNo(rs2.getString(2));
	               test.setTestvisitID(rs2.getString(3));
	               
					
	               testindividualCOST=rs2.getDouble(4);
	               testtemp=testindividualCOST;
	               testtotal =testtotal+testtemp;
					 
		           test.setTestcost(testindividualCOST);
					
					
				
					 totalTestbillList.add(test);	
					 
			 
				}
			
		     
		  /*   
			stmt = con.prepareStatement(sql);
			//stmt.setString(1, medicalID);
			//stmt.setString(2, fdate);
			//stmt.setString(3, tdate);	
			//stmt.setDate(2, fdate);
			//stmt.setDate(3, tdate);
		
			
			r = stmt.executeQuery();
			System.out.println("Response : " + sql);
			
			while (r.next())
			{
				TotalBillofEmployee pt = new TotalBillofEmployee();
				
				pt.setBillNo(r.getString(1));
				pt.setVisitID(r.getString(5));
				pt.setDate(r.getString(6));
				pt.setCost(r.getInt(9));
				
				System.out.println("Ad:"+r.getInt(9));
							
				totalbillList.add(pt);	
			}  
		     
		     
		     
		   */     
	                
	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}
	

	
public String detailmedicalBill() throws Exception{
	HttpServletRequest request = ServletActionContext.getRequest();
	serialNumber=request.getParameter("visitID");
	billID=request.getParameter("billID");
	
	
	System.out.println(serialNumber);
	

	///System.out.println(serial);
	Connection con = ConnectionManager.getConnection();	
//	Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
         
         String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNumber+"'";
         // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
	         ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				
				
				
				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
				
				}
			
			
			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+serialNumber+"'";
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
			/*String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				
				
				
				 medicalIDholderName=rs2.getString(2);
				 //patientName=rs2.getString(9);
				 department=rs2.getString(3);
				 designation=rs2.getString(5);
				// patientRelationWithIDholder=rs2.getString(10);
				}*/
			
			
			
			
			//////////////////////////////////////////////////
			/*String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				
				
				
				 medicalIDholderName=rs2.getString(2);
				 patientName=rs2.getString(9);
				 department=rs2.getString(3);
				 designation=rs2.getString(5);
				 patientRelationWithIDholder=rs2.getString(10);
				}*/
			 System.out.println(doctorID);
				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
		        ps3 = con.prepareStatement(sql3);
		         
		         
				 ResultSet rs3=ps3.executeQuery();
				 while(rs3.next()){
					
					
					
					
					
					 doctorName=rs3.getString(3);
					
					}
			
        
        /* String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+serialNumber+"'";
         ps1 = con.prepareStatement(sql1);
         
         
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next()){
			
			
			
			
			
			prescriptionID=rs1.getString(1);
			doctorID=rs1.getString(2);
			prescriptionDate=rs1.getString(4);
			medicalID=rs1.getString(5);
			}
		
	//System.out.println(medicalID);
			
		String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
        ps2 = con.prepareStatement(sql2);
         
         
		 ResultSet rs2=ps2.executeQuery();
		 while(rs2.next()){
			
			
			
			
			
			 medicalIDholderName=rs2.getString(2);
			 patientName=rs2.getString(9);
			 department=rs2.getString(3);
			 designation=rs2.getString(5);
			 patientRelationWithIDholder=rs2.getString(10);
			}
		 System.out.println(doctorID);
			String sql3="Select * from MCENTER.DOCTOR where USERID='"+doctorID+"'";
	        ps3 = con.prepareStatement(sql3);
	         
	         
			 ResultSet rs3=ps3.executeQuery();
			 while(rs3.next()){
				
				
				
				
				
				 doctorName=rs3.getString(3);
				
				}
         */
         
////////////////////////////////////////////////           
		
			 
			 
				 String sql4="Select * from MCENTER.MEDICINE_SAVE where PRESCRIPTIONID='"+prescriptionID+"'  and MED_BILLID='"+billID+"'";
					
					ps4=con.prepareStatement(sql4);
					ResultSet rs4=ps4.executeQuery();
					while(rs4.next()){
						
						
						
						 
						 medicineID=rs4.getString(4); 
						 
						 
						 String sql5="Select * from MCENTER.MEDICINE_INFO where MED_ID ='"+medicineID+"'";
							
							ps5=con.prepareStatement(sql5);
							ResultSet rs5=ps5.executeQuery();
							while(rs5.next()){
								medicineName=rs5.getString(2);
								
								 String sql55="Select MED_RATE from MCENTER.MEDICINE_SAVE where MED_ID='"+medicineID+"'";
									
									ps55=con.prepareStatement(sql55);
									ResultSet rs555=ps55.executeQuery();
									while(rs555.next()){
										
										rate=rs555.getDouble(1);
										System.out.println("rate="+rate);
								 
									}
								//rate=rs5.getDouble(8);
								
						 
							}
						
							 quantity=rs4.getInt(6);
							 temp= quantity*rate;
							 total =total+temp;
				
				
				 TotalBillofEmployee mbill=new TotalBillofEmployee();
			
			mbill.setMedicineName(medicineName);
			mbill.setMedicineQuantity(quantity);
			mbill.setRate(rate);
			mbill.setTotal(total);
			//a=rs2.getString(16);
		    //	b=rs2.getInt(17);
			
			pharmacyMedicineBilllist.add(mbill);
			
			
		
			
			
			
			
			}
		
		
		
		System.out.println(total);
		
		
		
		
		
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

	        if (ps3!= null) {
	        	ps3.close();
	        }
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
	
	return "success";

	
}



public String detailtestBill() throws Exception{
	
	HttpServletRequest request = ServletActionContext.getRequest();
	serialNumber=request.getParameter("testvisitID");
	
	System.out.println(" hi...Adnan");
	System.out.println(serialNumber);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
         
         String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNumber+"'";
         // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
	         ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				
				
				
				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
				
				}
			
			
			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+serialNumber+"'";
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
			/*String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				
				
				
				 medicalIDholderName=rs2.getString(2);
				 //patientName=rs2.getString(9);
				 department=rs2.getString(3);
				 designation=rs2.getString(5);
				// patientRelationWithIDholder=rs2.getString(10);
				}*/
			
			
			
			
			//////////////////////////////////////////////////
			/*String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				
				
				
				 medicalIDholderName=rs2.getString(2);
				 patientName=rs2.getString(9);
				 department=rs2.getString(3);
				 designation=rs2.getString(5);
				 patientRelationWithIDholder=rs2.getString(10);
				}*/
			 System.out.println(doctorID);
				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
		        ps3 = con.prepareStatement(sql3);
		         
		         
				 ResultSet rs3=ps3.executeQuery();
				 while(rs3.next()){
					
					
					
					
					
					 doctorName=rs3.getString(3);
					
					}
			
			
        
       /*  String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+serialNumber+"'";
         ps1 = con.prepareStatement(sql1);
         
         
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next()){
			
			
			
			
			
			prescriptionID=rs1.getString(1);
			doctorID=rs1.getString(2);
			prescriptionDate=rs1.getString(4);
			medicalID=rs1.getString(5);
			}
		
	//System.out.println(medicalID);
			
		String sql2="Select * from MCENTER.PATIENTDETAILS where MEDICALID='"+medicalID+"'";
        ps2 = con.prepareStatement(sql2);
         
         
		 ResultSet rs2=ps2.executeQuery();
		 while(rs2.next()){
			
			
			
			
			
			 medicalIDholderName=rs2.getString(2);
			 patientName=rs2.getString(9);
			 department=rs2.getString(3);
			 designation=rs2.getString(5);
			 patientRelationWithIDholder=rs2.getString(10);
			}
		 System.out.println(doctorID);
			String sql3="Select * from MCENTER.DOCTOR where USERID='"+doctorID+"'";
	        ps3 = con.prepareStatement(sql3);
	         
	         
			 ResultSet rs3=ps3.executeQuery();
			 while(rs3.next()){
				
				
				
				
				
				 doctorName=rs3.getString(3);
				
				}*/
         
        
         
 /////////////////////////////////////////////////////

         
		/////////////////////////////////////////////
		String sql5="Select * from MCENTER.TEST_SAVE where PRESCRIPTIONID='"+prescriptionID+"'";
		
		ps5=con.prepareStatement(sql5);
		ResultSet rs5=ps5.executeQuery();
		while(rs5.next()){
			
			testTypeID=rs5.getString(2);
			testNameID=rs5.getString(3);
			 
			
           String sql6="Select * from MCENTER.TESTS where TESTID='"+testNameID+"' and TESTTYPEID=lpad('"+testTypeID+"',2,'0') ";
			
			ps6=con.prepareStatement(sql6);
			ResultSet rs6=ps6.executeQuery();
			while(rs6.next()){
				//testType=rs6.getString(2);
				testName=rs6.getString(1);
				String sql55="Select * from MCENTER.TEST_SAVE where TESTID='"+testNameID+"' and TESTTYPEID='"+testTypeID+"' and PRESCRIPTIONID='"+prescriptionID+"'";
				ps5=con.prepareStatement(sql55);
				ResultSet rs55=ps5.executeQuery();
				while(rs55.next()){
					
					rate=rs55.getDouble(6);	
					vat=rs55.getDouble(7);
				}
				//rate=rs6.getDouble(4);
				//vat=rs6.getDouble(5);
				
		 
			}				
			
       String sql7="Select * from MCENTER.TESTTYPE where TESTTYPEID=lpad('"+testTypeID+"',2,'0') ";
			
			ps7=con.prepareStatement(sql7);
			ResultSet rs7=ps7.executeQuery();
			while(rs7.next()){
				testType=rs7.getString(2);
				
				
		 
			}
			
			
			
			
			
			 cost=((vat*rate)/100)+rate;
			 temp= cost;
			 total =total+temp;
			
			
			 TotalBillofEmployee tbill=new TotalBillofEmployee();
			
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
		
		
		
		System.out.println(total);
		
		
		
		
		
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


public String report(String medicalID,String fromdate,String todate){
	/*HttpServletRequest request = ServletActionContext.getRequest();
	medicalID=request.getParameter("medicalID");
	name=request.getParameter("name");
	department=request.getParameter("department");
	designation=request.getParameter("designation");
	fdate=request.getParameter("fdate");
	tdate=request.getParameter("tdate");*/
	
	
	
	
	
	
	
	System.out.println(" Report HIT:"+medicalID);
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	//PreparedStatement stmt = null;
	//ResultSet r = null;
	try{

		System.out.println(" Report Medical id:"+medicalID);
		System.out.println("Report From Date:"+fromdate);
		System.out.println("Report TO date:"+todate);
		
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		
	     ////////////////////////////////////////
	     
	    /* String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'mm/dd/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNumber+"'";
         // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
	         ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				
				
				
				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
				
				}
			
			
			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+serialNumber+"'";
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
		        	    
		         
		         }*/
			
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
			  
			
			 System.out.println(doctorID);
				String sql3="Select * from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
		        ps3 = con.prepareStatement(sql3);
		         
		         
				 ResultSet rs3=ps3.executeQuery();
				 while(rs3.next()){
					
					
					
					
					
					 doctorName=rs3.getString(3);
					
					}
	     ////////////////////////////////////////////////////////
				 
				 
				 String sql10="select distinct t1.id, t1.name,t1.date_of_birth,t1.gender from(select STUDENTID id,STUDENTNAME name,TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"'" +
							"union " +
							"select OFFICIAL_ID id, NAME name,TO_CHAR(DATE_OF_BIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"'" +
							"union " +
							"select DEPENDENTID id, DNAME name,TO_CHAR(DOB, 'dd/mm/yyyy') date_of_birth,SEX gender from DEPENDENCY where DEPENDENCY.DEPENDENTID='"+medicalID+"')t1";
										
										ps7=con.prepareStatement(sql10);
										ResultSet rs10=ps7.executeQuery();
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
				 
	     
	     //////////////////////////////////////////////////////////
	     
	     String sql11=" select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),BILLID,VISITID,BILLAMOUNT from MCENTER.PATIENTMEDBILL where MEDICALID='"+medicalID+"' and VISITINGDATE between to_date('"+fromdate+"','dd/mm/yyyy') and to_date('"+todate+"','dd/mm/yyyy') ";

		
	     
	 	ps4=con.prepareStatement(sql11);
		ResultSet rs=ps4.executeQuery();
		while(rs.next()){
			
           TotalBillofEmployee pt = new TotalBillofEmployee();
			
			pt.setBillNo(rs.getString(2));
			pt.setVisitID(rs.getString(3));
			pt.setDate(rs.getString(1));
			
			 individualCOST=rs.getDouble(4);
			 temp=individualCOST;
			 total =total+temp;
			 System.out.println("MedicineindividualCOST:"+individualCOST);
			 System.out.println(" Medicine total:"+total);
			pt.setCost(individualCOST);
			pt.setTotal(total);
			
			String sqlinword="select MCENTER.numbertoword('"+total+"') from dual";
				
				ps6=con.prepareStatement(sqlinword);
				ResultSet rs55=ps6.executeQuery();
				while(rs55.next()){
					inword=rs55.getString(1);  					
					
									}
		
			totalbillList.add(pt);	
			
	 
		}
		
		
		
		
	     String sql25=" select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),TESTBILLID,VISITID,BILLINGAMOUNT from MCENTER.PATIENTTESTBILL where MEDICALID='"+medicalID+"' and VISITINGDATE between to_date('"+fromdate+"','dd/mm/yyyy') and to_date('"+todate+"','dd/mm/yyyy') ";

			
	     
		 	ps5=con.prepareStatement(sql25);
			ResultSet rs24=ps5.executeQuery();
			while(rs24.next()){
				
               TotalBillofEmployee test = new TotalBillofEmployee();
				
               test.setTestbillNo(rs24.getString(2));
               test.setTestvisitID(rs24.getString(3));
               test.setTestdate(rs24.getString(1));
				
               testindividualCOST=rs24.getDouble(4);
               testtemp=testindividualCOST;
               testtotal =testtotal+testtemp;
               System.out.println("testindividualCOST:"+testindividualCOST);
  			 System.out.println("testtotal:"+testtotal); 
	           test.setTestcost(testindividualCOST);
	           test.setTesttotal(testtotal);
				
	           String sqlinword="select MCENTER.numbertoword('"+testtotal+"') from dual";
				
				ps7=con.prepareStatement(sqlinword);
				ResultSet rs33=ps7.executeQuery();
				while(rs33.next()){
					inwordTest=rs33.getString(1);  					
					
									}
			
				 totalTestbillList.add(test);	
				
		 
			}
		
	     
	  /*   
		stmt = con.prepareStatement(sql);
		//stmt.setString(1, medicalID);
		//stmt.setString(2, fdate);
		//stmt.setString(3, tdate);	
		//stmt.setDate(2, fdate);
		//stmt.setDate(3, tdate);
	
		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			TotalBillofEmployee pt = new TotalBillofEmployee();
			
			pt.setBillNo(r.getString(1));
			pt.setVisitID(r.getString(5));
			pt.setDate(r.getString(6));
			pt.setCost(r.getInt(9));
			
			System.out.println("Ad:"+r.getInt(9));
						
			totalbillList.add(pt);	
		}  
	     
	     
	     
	   */     
                
         con.close();
	}
	catch(Exception e){e.printStackTrace();}
	
		
	return "success";
	
	}




















}
