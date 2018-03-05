package com.mcenter.pharmasistBillManagement;

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
import java.math.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.ConnectionUtil.ConnectionManager;
import util.login.ValidateUser;

import com.mcenter.totalBill.TotalBillofEmployee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;







public class PathTestBill extends ActionSupport {
	
	private String doctorID;
	private String doctorName;
	private String prescriptionID;
	private String prescriptionDate;
	private String medicalID;
	private String patientID;
	private String medicalIDholderName;
	private String departmentID;
	private String department;
	private String patientName;
	private String patientRelationWithIDholder;
	private String visitID;
	private String designation;
	private String medicineID;
	private String billID;
	private String medicineName;
	private int medicineQuantity;
	private String vID;
	private String serialNO;
	private String inword;
	private String ageStr;
	private String gender;
	private String status;
	private String newBillYN="N";
	private String testTypeID;
	private String testTypeName;
	private String  testNameID;
	private String testName;
	double rate;
	int quantity;
	double temp;
	double total=0;
	private double individualCOST;
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;
	PreparedStatement ps8 = null;
	PreparedStatement ps9 = null;
	PreparedStatement ps55 = null;
	
	
   
	ArrayList<PathTestBill> pharmacyMedicineBilllist=new ArrayList<PathTestBill>();
	ArrayList<TotalBillofEmployee> totalbillList=new ArrayList<TotalBillofEmployee>();
    
	  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	   
	   DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
  	   //get current date time with Date()
  	   Date serialdate1 = new Date();
  	   String DateofSerial1 = dateFormat1.format(serialdate1);
	

	   
	public double getIndividualCOST() {
		return individualCOST;
	}


	public void setIndividualCOST(double individualCOST) {
		this.individualCOST = individualCOST;
	}


	public String getNewBillYN() {
		return newBillYN;
	}


	public void setNewBillYN(String newBillYN) {
		this.newBillYN = newBillYN;
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


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getPatientRelationWithIDholder() {
		return patientRelationWithIDholder;
	}


	public String getTestNameID() {
		return testNameID;
	}


	public void setTestNameID(String testNameID) {
		this.testNameID = testNameID;
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


	public String getTestTypeName() {
		return testTypeName;
	}


	public void setTestTypeName(String testTypeName) {
		this.testTypeName = testTypeName;
	}


	public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
		this.patientRelationWithIDholder = patientRelationWithIDholder;
	}


	public String getMedicalIDholderName() {
		return medicalIDholderName;
	}


	public void setMedicalIDholderName(String medicalIDholderName) {
		this.medicalIDholderName = medicalIDholderName;
	}


	public String getPrescriptionID() {
		return prescriptionID;
	}
	
	


	public void setPrescriptionID(String prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}


	public String getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
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

	public ArrayList<PathTestBill> getPharmacyMedicineBilllist() {
		return pharmacyMedicineBilllist;
	}
	public void setPharmacyMedicineBilllist(
			ArrayList<PathTestBill> pharmacyMedicineBilllist) {
		this.pharmacyMedicineBilllist = pharmacyMedicineBilllist;
	}

	
	public ArrayList<TotalBillofEmployee> getTotalbillList() {
		return totalbillList;
	}


	public void setTotalbillList(ArrayList<TotalBillofEmployee> totalbillList) {
		this.totalbillList = totalbillList;
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


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
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



	public String execute() throws Exception{
		System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
			con.setAutoCommit(false);
                       
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
            // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps1 = con.prepareStatement(sql1);
	         
	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
				
			}
			
			String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+visitID +"' ";
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
			  
			  String sql2="SELECT DISTINCT t1.id, " +
			  "                t1.name, " +
			  "                t1.departmentname, " +
			  "                t1.DESIGNATION " +
			  "  FROM (SELECT STUDENTID id, " +
			  "               STUDENTNAME name, " +
			  "               DEPARTMENTID departmentname, " +
			  "               '' DESIGNATION " +
			  "          FROM BIIS.STUDENT " +
			  "         WHERE BIIS.STUDENT.STUDENTID ='"+medicalID+"' " +
			  "         UNION " +
			  "         SELECT TEMPID id, " +
			  "               NAME name, " +
			  "               DEPT departmentname, " +
			  "               DESIGNATION DESIGNATION " +
			  "          FROM MCENTER.NONIDPATIENT " +
			  "         WHERE MCENTER.NONIDPATIENT.TEMPID='"+medicalID+"' " +
			  "        UNION " +
			  "        SELECT OFFICIAL_ID id, " +
			  "               NAME name, " +
			  "               (SELECT SHORT_DEPARTMENT_NAME " +
			  "                  FROM ESTABLISHMENT.DEPARTMENT " +
			  "                 WHERE DEPARTMENT_ID = " +
			  "                          (SELECT DEPARTMENT_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  departmentname, " +
			  "               (SELECT SHORT_DESIGNATION " +
			  "                  FROM ESTABLISHMENT.DESIGNATION " +
			  "                 WHERE DESIGNATION_ID = " +
			  "                          (SELECT CURRENT_DESIGNATION_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  DESIGNATION " +
			  "          FROM ESTABLISHMENT.PERSONNEL " +
			  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 "  ;
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
			  String sql3="Select Distinct(NAME)  from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
			  ps3 = con.prepareStatement(sql3);
		         
			  ResultSet rs3=ps3.executeQuery();
			  while(rs3.next()){
				
				  doctorName=rs3.getString("NAME");
					
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
	
	
	public String medicinereducefromsubstore() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		serialNO=request.getParameter("serial");
/*		String medID[]=request.getParameterValues("medID");
		String medQuantity[]=request.getParameterValues("medquantity");*/
		String[] medID=null;
		String[] medQuantity=null;
		String checkedMedicine[]=request.getParameterValues("checkedmedicine");

		if(checkedMedicine!=null) {
	//		System.out.println("applicationID Problem!!!!!!!!!!!!!!!!!!!!!!!!!!");
			medID = new String[checkedMedicine.length]; 
			medQuantity = new String[checkedMedicine.length] ;
			for(int i=0;i<checkedMedicine.length;i++){
	//			System.out.println("applicationID 1 Problem!!!!!!!!!!!!!!!!!!!!!!!!!!");
				String serialNo=checkedMedicine[i];
				String[] parts = serialNo.split("#");
				String string1 = parts[0]; 
				String string2 = parts[1];
				medID[i]=string1;
				medQuantity[i]=string2;
			}
			
		}
		
		System.out.println(" hi...Adnan");
		System.out.println(serialNO);
		///System.out.println(serial);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
			Map<String, Object> session = ActionContext.getContext().getSession();
			UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
    		
			System.out.println(user.getUserfullname());
    		System.out.println(user.getUserdesignation());
    		
    		con.setAutoCommit(false);
            
      
             
    		String sql1z="Select * from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
    		PreparedStatement   ps1z = con.prepareStatement(sql1z);
	         
	         
    		ResultSet rs1z=ps1z.executeQuery();
			while(rs1z.next()){

				prescriptionID=rs1z.getString(1);
				
				}
			
			
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'mm/dd/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
             // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps1 = con.prepareStatement(sql1);
 	         
 	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
 
				prescriptionID=rs1.getString(2);
 				doctorID=rs1.getString(3);
 				prescriptionDate=rs1.getString(1);
 				
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
 			  
			String sql2="SELECT DISTINCT t1.id, " +
			  "                t1.name, " +
			  "                t1.departmentname, " +
			  "                t1.DESIGNATION " +
			  "  FROM (SELECT STUDENTID id, " +
			  "               STUDENTNAME name, " +
			  "               DEPARTMENTID departmentname, " +
			  "               '' DESIGNATION " +
			  "          FROM BIIS.STUDENT " +
			  "         WHERE BIIS.STUDENT.STUDENTID ='"+medicalID+"' " +
			  "         UNION " +
			  "         SELECT TEMPID id, " +
			  "               NAME name, " +
			  "               DEPT departmentname, " +
			  "               DESIGNATION DESIGNATION " +
			  "          FROM MCENTER.NONIDPATIENT " +
			  "         WHERE MCENTER.NONIDPATIENT.TEMPID='"+medicalID+"' " +
			  "        UNION " +
			  "        SELECT OFFICIAL_ID id, " +
			  "               NAME name, " +
			  "               (SELECT SHORT_DEPARTMENT_NAME " +
			  "                  FROM ESTABLISHMENT.DEPARTMENT " +
			  "                 WHERE DEPARTMENT_ID = " +
			  "                          (SELECT DEPARTMENT_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  departmentname, " +
			  "               (SELECT SHORT_DESIGNATION " +
			  "                  FROM ESTABLISHMENT.DESIGNATION " +
			  "                 WHERE DESIGNATION_ID = " +
			  "                          (SELECT CURRENT_DESIGNATION_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  DESIGNATION " +
			  "          FROM ESTABLISHMENT.PERSONNEL " +
			  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 " ;
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
			System.out.println(doctorID);
			String sql3="Select distinct(NAME) from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
			ps3 = con.prepareStatement(sql3);
		         		         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
				
				doctorName=rs3.getString("NAME");
					 
			}
			 
             
  ////////////////////////////////////////////////     
				 
			for(int i=0;i<medID.length;i++) { 
				if(medID!=null ) { 
					
					String sql="Select QUANTITY from MCENTER.SUB_STORE where MED_ID='"+medID[i]+"' and TRUNC (SYSDATE)<=EXPIRE_DATE ";
					ps4 = con.prepareStatement(sql);
					int c=0;	         
			         	         
					ResultSet rs=ps4.executeQuery();
					while(rs.next()){
			         							         				
						int count=rs.getInt("QUANTITY");
						if(count>=Integer.parseInt(medQuantity[i]))
						{
						c=count-Integer.parseInt(medQuantity[i]);
						}
						
/*						else if(count<Integer.parseInt(medQuantity[i]))
						{
						c=count;
						}*/
						
						String sql77="Select STATUS from MCENTER.MEDICINE_SAVE where PRESCRIPTIONID='"+prescriptionID+"' and MED_ID='"+medID[i]+"'";
			     				
						ps55=con.prepareStatement(sql77);
						ResultSet rs77=ps55.executeQuery();
						while(rs77.next()){
			     					
							status=rs77.getString(1);
							System.out.println("status="+status);
			     			 
						}
			                  
						if(status.equalsIgnoreCase("Not Taken") && count>=Integer.parseInt(medQuantity[i]))
						{	         						
							String sql22="UPDATE MCENTER.SUB_STORE SET QUANTITY='"+c+"' WHERE MED_ID='"+medID[i]+"'  ";
			     					
							ps5 = con.prepareStatement(sql22);
							ps5.executeQuery();
    
    
							String sql222="UPDATE MCENTER.MEDICINE_SAVE SET TKNQTY='"+medQuantity[i]+"',STATUS='Taken' WHERE MED_ID='"+medID[i]+"' and PRESCRIPTIONID='"+prescriptionID+"'  ";
			     					
							ps5 = con.prepareStatement(sql222);
							ps5.executeQuery();
							newBillYN="Y";
						}

					}  			 			         			 
				         
				}
			}			 
				 
			
			////////////////////Medicine Bill Start////////////////////////			 

				 
			String sql4="Select * from MCENTER.MEDICINE_SAVE where PRESCRIPTIONID='"+prescriptionID+"' and STATUS='Taken' and BILL_COMPLETED_YN='N' ";
						
						ps4=con.prepareStatement(sql4);
						ResultSet rs4=ps4.executeQuery();
	while(rs4.next()){					

						medicineID=rs4.getString(4); 
							 
							 
						String sql5="Select * from MCENTER.MEDICINE_INFO where MED_ID ='"+medicineID+"'";
								
						ps5=con.prepareStatement(sql5);
						ResultSet rs5=ps5.executeQuery();
		while(rs5.next()){
						medicineName=rs5.getString(2);
									
						String sql55="Select * from MCENTER.SUB_STORE where MED_ID='"+medicineID+"'";
										
						ps55=con.prepareStatement(sql55);
						ResultSet rs555=ps55.executeQuery();
						while(rs555.next()){
											
						rate=rs555.getDouble(3);
						System.out.println("rate="+rate);
									 
										}
									//rate=rs5.getDouble(8);
									
							 
				}
							
						quantity=rs4.getInt(6);
						temp= quantity*rate;
						total =total+temp;
					
			
					 
					 
					 
					    String sql33="Select count(*) from MCENTER.PATIENTMEDBILL where BILLDATE=to_date('"+Date+"','mm/dd/yyyy')";
	         	        ps8= con.prepareStatement(sql33);
	         	         
	         	         
	         			ResultSet rs33=ps8.executeQuery();
	         			while(rs33.next()){
	         				
	         				
	         			int	billcount=rs33.getInt(1);	

	         			billcount=billcount+1;
	                     
	         			billID=DateofSerial1+"-medbill:"+billcount; 		
	         

	         				 
	         				}  			 

					 
	         			

				
		}

						if(newBillYN.equalsIgnoreCase("Y")){
						ps9=con.prepareStatement("INSERT INTO MCENTER.PATIENTMEDBILL (BILLID,MEDICALID,REFDOCTOR,PATIENTNAME,VISITID,VISITINGDATE,BILLAMOUNT,USERID,BILLDATE)" +
						" VALUES('"+billID+"','"+medicalID+"','"+doctorID+"','"+patientName+"','"+serialNO+"',to_date('"+prescriptionDate+"','mm/dd/yyyy'),'"+total+"','"+user.getUsername()+"',to_date('"+Date+"','mm/dd/yyyy'))");
					    ps9.executeUpdate(); 
					 
					    System.out.println("Billing is successfully done...............");
						}
						
						
						else{
						System.out.println("Billing has previously done...............");
						}
						
						
						
						String medBill=" select TO_CHAR(VISITINGDATE, 'dd/mm/yyyy'),BILLID,VISITID,BILLAMOUNT from MCENTER.PATIENTMEDBILL where VISITID='"+serialNO+"' ";

						
						ps1=con.prepareStatement(medBill);
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
	
	
	public String medicineTABLE() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
				
		serialNO=request.getParameter("serial");
				
//		System.out.println(" hi...Adnan");
//		System.out.println(serialNO);
				///System.out.println(serial);
		Connection con = ConnectionManager.getConnection();	
				//Connection con = null;
		try{
/*					
				 Class.forName("oracle.jdbc.driver.OracleDriver");
			     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			         
			      
			con.setAutoCommit(false);
			
			/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/            
			String sql1z="Select * from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
			PreparedStatement   ps1z = con.prepareStatement(sql1z);
			         
			         
			ResultSet rs1z=ps1z.executeQuery();
			while(rs1z.next()){

				prescriptionID=rs1z.getString(1);
						
			}
			/*$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
					
			String sql1="Select TO_CHAR(PRESCRIPTIONDATE, 'dd/mm/yyyy') AS PRESCRIPTIONDATE,PRESCRIPTIONID,DOCTORID from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
		             // String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps1 = con.prepareStatement(sql1);
		 	         
		 	         
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()){
		 				
				prescriptionID=rs1.getString(2);
				doctorID=rs1.getString(3);
				prescriptionDate=rs1.getString(1);
		 				
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
		 			  
			String sql2="SELECT DISTINCT t1.id, " +
					  "                t1.name, " +
					  "                t1.departmentname, " +
					  "                t1.DESIGNATION " +
					  "  FROM (SELECT STUDENTID id, " +
					  "               STUDENTNAME name, " +
					  "               DEPARTMENTID departmentname, " +
					  "               '' DESIGNATION " +
					  "          FROM BIIS.STUDENT " +
					  "         WHERE BIIS.STUDENT.STUDENTID ='"+medicalID+"' " +
					  "         UNION " +
					  "         SELECT TEMPID id, " +
					  "               NAME name, " +
					  "               DEPT departmentname, " +
					  "               DESIGNATION DESIGNATION " +
					  "          FROM MCENTER.NONIDPATIENT " +
					  "         WHERE MCENTER.NONIDPATIENT.TEMPID='"+medicalID+"' " +
					  "        UNION " +
					  "        SELECT OFFICIAL_ID id, " +
					  "               NAME name, " +
					  "               (SELECT SHORT_DEPARTMENT_NAME " +
					  "                  FROM ESTABLISHMENT.DEPARTMENT " +
					  "                 WHERE DEPARTMENT_ID = " +
					  "                          (SELECT DEPARTMENT_ID " +
					  "                             FROM ESTABLISHMENT.PERSONNEL " +
					  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
					  "                                     '"+medicalID+"')) " +
					  "                  departmentname, " +
					  "               (SELECT SHORT_DESIGNATION " +
					  "                  FROM ESTABLISHMENT.DESIGNATION " +
					  "                 WHERE DESIGNATION_ID = " +
					  "                          (SELECT CURRENT_DESIGNATION_ID " +
					  "                             FROM ESTABLISHMENT.PERSONNEL " +
					  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
					  "                                     '"+medicalID+"')) " +
					  "                  DESIGNATION " +
					  "          FROM ESTABLISHMENT.PERSONNEL " +
					  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 " ;
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
			System.out.println(doctorID);
			String sql3="Select distinct(NAME)  from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
			ps3 = con.prepareStatement(sql3);
				         
				         
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){

				doctorName=rs3.getString("NAME");
							
			}
		             
		             
		  ////////////////////////////////////////////////           
					
			////////////////////////////////////////////////////////////////////////////////////////////////////			 
 
			String sql4="Select * from MCENTER.MEDICINE_SAVE where PRESCRIPTIONID='"+prescriptionID+"'";
					
			ps4=con.prepareStatement(sql4);
			ResultSet rs4=ps4.executeQuery();
			while(rs4.next()){

				medicineID=rs4.getString(4); 
						 
						 
				String sql5="Select * from MCENTER.MEDICINE_INFO where MED_ID ='"+medicineID+"'";
							
				ps5=con.prepareStatement(sql5);
				ResultSet rs5=ps5.executeQuery();
				while(rs5.next()){
					medicineName=rs5.getString(2);
								
					String sql55="Select * from MCENTER.SUB_STORE where MED_ID='"+medicineID+"'";
									
					ps55=con.prepareStatement(sql55);
					ResultSet rs555=ps55.executeQuery();
					while(rs555.next()){
										
						rate=rs555.getDouble(3);
						System.out.println("rate="+rate);
								 
					}
								//rate=rs5.getDouble(8);
								
						 
				}
						
				quantity=rs4.getInt(6);
				temp= quantity*rate;
				total =total+temp;
							 	
				PathTestBill mbill=new PathTestBill();
						 
				mbill.setMedicineID(medicineID);
				mbill.setMedicineName(medicineName);
				mbill.setMedicineQuantity(quantity);
				mbill.setRate(rate);
				mbill.setTotal(total);
						//a=rs2.getString(16);
					    //	b=rs2.getInt(17);
						
				pharmacyMedicineBilllist.add(mbill);

						
			}

			System.out.println("total="+total);

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
	
	public String testBillReport(String visitID,String billID) throws Exception{
		

		
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
			con.setAutoCommit(false);
			System.out.println("Adnan:"+visitID); 
			String sql1z="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID+"'";
            PreparedStatement   ps1z = con.prepareStatement(sql1z);
	         
	         
            ResultSet rs1z=ps1z.executeQuery();
            while(rs1z.next()){

            	prescriptionID=rs1z.getString(1);
				
            }
			
			
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
 			  
            String sql2="SELECT DISTINCT t1.id, " +
			  "                t1.name, " +
			  "                t1.departmentname, " +
			  "                t1.DESIGNATION " +
			  "  FROM (SELECT STUDENTID id, " +
			  "               STUDENTNAME name, " +
			  "               DEPARTMENTID departmentname, " +
			  "               '' DESIGNATION " +
			  "          FROM BIIS.STUDENT " +
			  "         WHERE BIIS.STUDENT.STUDENTID ='"+medicalID+"' " +
			  "         UNION " +
			  "         SELECT TEMPID id, " +
			  "               NAME name, " +
			  "               DEPT departmentname, " +
			  "               DESIGNATION DESIGNATION " +
			  "          FROM MCENTER.NONIDPATIENT " +
			  "         WHERE MCENTER.NONIDPATIENT.TEMPID='"+medicalID+"' " +
			  "        UNION " +
			  "        SELECT OFFICIAL_ID id, " +
			  "               NAME name, " +
			  "               (SELECT SHORT_DEPARTMENT_NAME " +
			  "                  FROM ESTABLISHMENT.DEPARTMENT " +
			  "                 WHERE DEPARTMENT_ID = " +
			  "                          (SELECT DEPARTMENT_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  departmentname, " +
			  "               (SELECT SHORT_DESIGNATION " +
			  "                  FROM ESTABLISHMENT.DESIGNATION " +
			  "                 WHERE DESIGNATION_ID = " +
			  "                          (SELECT CURRENT_DESIGNATION_ID " +
			  "                             FROM ESTABLISHMENT.PERSONNEL " +
			  "                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
			  "                                     '"+medicalID+"')) " +
			  "                  DESIGNATION " +
			  "          FROM ESTABLISHMENT.PERSONNEL " +
			  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 " ;
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
            System.out.println(doctorID);
            String sql3="Select distinct(NAME) from MCENTER.TODAYDOCTOR where OFFICIALID='"+doctorID+"'";
            ps3 = con.prepareStatement(sql3);
		         
		         
            ResultSet rs3=ps3.executeQuery();
            while(rs3.next()){

            	doctorName=rs3.getString("NAME");
					
            }

            String sql4="Select * from MCENTER.TEST_SAVE where PRESCRIPTIONID='"+prescriptionID+"' and TEST_BILLID='"+billID+"' ";
							
            ps4=con.prepareStatement(sql4);
            ResultSet rs4=ps4.executeQuery();
            while(rs4.next()){
            	
            	testNameID=rs4.getString("TESTID");
            	testTypeID=rs4.getString("TESTTYPEID");
				
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
				
					
				String sql44="Select TESTTYPEID,TESTTYPENAME from MCENTER.TESTTYPE where TESTTYPEID=lpad('" + testTypeID + "',2,'0')";
				
				PreparedStatement ps44=con.prepareStatement(sql44);
				ResultSet rs44=ps44.executeQuery();
				while(rs44.next()){
					  					
					testTypeID=rs44.getString("TESTTYPEID");
					testTypeName=rs44.getString("TESTTYPENAME");
							}				
		//		System.out.println("testTypeName:"+testTypeName);
								
            	
									 
            	String sqlinword="select MCENTER.numbertoword('"+total+"') from dual";
						   				
            	ps6=con.prepareStatement(sqlinword);
            	ResultSet rs55=ps6.executeQuery();
            	while(rs55.next()){
            		inword=rs55.getString(1);  					
						   					
						   									}
									
            	PathTestBill mbill=new PathTestBill();
								 
            	mbill.setTestNameID(testNameID);
            	mbill.setTestName(testName);
            	mbill.setTestTypeID(testTypeID);
            	mbill.setTestTypeName(testTypeName);
            	mbill.setRate(rate);
            	mbill.setTotal(total);
								//a=rs2.getString(16);
							    //	b=rs2.getInt(17);
								
            	pharmacyMedicineBilllist.add(mbill);
				/*TO_CHAR(DATEOFBIRTH, 'mm/dd/yyyy')
				TO_CHAR(DATE_OF_BIRTH, 'mm/dd/yyyy')
				TO_CHAR(DOB, 'mm/dd/yyyy')*/
				
            	String sql10="select distinct t1.id, t1.name,t1.date_of_birth,t1.gender from(select STUDENTID id,STUDENTNAME name,TO_CHAR(DATEOFBIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+patientID+"'" +
            			"union " +
            			"select OFFICIAL_ID id, NAME name,TO_CHAR(DATE_OF_BIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+patientID+"'" +
            			"union " +
            			"select TEMPID id, NAME name,TO_CHAR(DATE_OF_BIRTH, 'dd/mm/yyyy') date_of_birth,SEX gender from MCENTER.NONIDPATIENT where MCENTER.NONIDPATIENT.TEMPID='"+patientID+"'" +
            			"union " +
            			"select DEPENDENTID id, DNAME name,TO_CHAR(DOB, 'dd/mm/yyyy') date_of_birth,SEX gender from DEPENDENCY where DEPENDENCY.DEPENDENTID='"+patientID+"')t1";
					
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
	

	}
