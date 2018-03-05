package com.mcenter.editPrescriptionByDoctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import com.mcenter.pharmasistBillManagement.PharmacyMedicineBill;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditprescriptionByDoctor extends ActionSupport {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
		private String doctorID;
		private String doctorName;
		private String prescriptionID;
		private String prescriptionDate;
		private String medicalID;
		private String medicalIDholderName;
		private String departmentID;
		private String department;
		private String patientName;
		private String patientID;
		private String patientRelationWithIDholder;
		private String visitID;
		private String designation;
		private String medicineID;
		private String medicineeditID;
		private String medicineName;
		private int medicineQuantity;
		private String vID;
		private String serialNO;
		private String editquantiy;
		private String message;
		private int billCompleted;
		
	   
	double rate=4.00;
	int quantity;
	double temp;
	double total=0;
	
	private String serial;
	private String mName;
	double previousQuantity;
	double editedQuantity;
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps55 = null;
	
	
	public int getBillCompleted() {
		return billCompleted;
	}
	public void setBillCompleted(int billCompleted) {
		this.billCompleted = billCompleted;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEditquantiy() {
		return editquantiy;
	}
	public void setEditquantiy(String editquantiy) {
		this.editquantiy = editquantiy;
	}
	public String getMedicineeditID() {
		return medicineeditID;
	}
	public void setMedicineeditID(String medicineeditID) {
		this.medicineeditID = medicineeditID;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public double getPreviousQuantity() {
		return previousQuantity;
	}

	public void setPreviousQuantity(double previousQuantity) {
		this.previousQuantity = previousQuantity;
	}
	public double getEditedQuantity() {
		return editedQuantity;
	}

	public void setEditedQuantity(double editedQuantity) {
		this.editedQuantity = editedQuantity;
	}


	ArrayList<EditprescriptionByDoctor> editprescriptionList=new ArrayList<EditprescriptionByDoctor>();
    
   

	public ArrayList<EditprescriptionByDoctor> getEditprescriptionList() {
		return editprescriptionList;
	}


	public void setEditprescriptionList(
			ArrayList<EditprescriptionByDoctor> editprescriptionList) {
		this.editprescriptionList = editprescriptionList;
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
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
	         */
			Map<String, Object> session = ActionContext.getContext().getSession();
    		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
    		
    		String sql="SELECT COUNT (*) BILL_COMPLETED FROM MCENTER.PATIENTMEDBILL WHERE VISITID ='"+visitID+"'";
  		
    		PreparedStatement ps99=con.prepareStatement(sql);
  			ResultSet rs99=ps99.executeQuery();
  		 while(rs99.next()){
  		                         
  			billCompleted=rs99.getInt("BILL_COMPLETED");
  		             			
  		              }
  		 
  		 
  		 if(billCompleted>0){
  			 message="Already Patient has taken medicine.So no way to edit...";
  		 				}
  		 
  		else if(billCompleted==0){
    		
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
 			if(doctorID!=null){
 			if(doctorID.equalsIgnoreCase(user.getOfficalid())){
 			   String sql12="Select PERSONID,PATIENTID,PATIENTNAME from MCENTER.PATIENT_HISTORY where VISITID='"+visitID+"'";
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
 					  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 ";
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
 				message="This is your patient ";	 
             
 			}
 			
 			else{
				 message="This is not your patient ";
				
			}
 			
 			///////////////////////////////
 			}
 			else{
 				 message="The patient is not prescribed Yet ";
 				
 			}
			con.commit();
			
			
			
  		}
  		
  		
			
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
	
	public String editPrescription() throws Exception{
		
HttpServletRequest request = ServletActionContext.getRequest();
		
		serialNO=request.getParameter("serial");
		
		System.out.println(" hi...Adnan");
		System.out.println(serialNO);
		///System.out.println(serial);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
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
 					  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 ";
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
						
							 quantity=rs4.getInt(5);
							 temp= quantity*rate;
							 total =total+temp;
					
			   EditprescriptionByDoctor mbill=new EditprescriptionByDoctor();
				mbill.setMedicineID(medicineID);
				mbill.setMedicineName(medicineName);
				mbill.setMedicineQuantity(quantity);
				mbill.setRate(rate);
				mbill.setTotal(total);
				//a=rs2.getString(16);
			    //	b=rs2.getInt(17);
				
				editprescriptionList.add(mbill);

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
	

	
	
public String editmedicineQuantiryBYdoctor() throws Exception{
		
		
HttpServletRequest request = ServletActionContext.getRequest();
           serialNO=request.getParameter("serialNO");
           editquantiy=request.getParameter("quantityEdited");
           medicineeditID=request.getParameter("medicineID");
          
		  			
			System.out.println("Hitted");
			System.out.println("serial:"+serialNO);
			System.out.println("editquantiy:"+editquantiy);
			System.out.println(Date);
			System.out.println("medicineeditID:"+medicineeditID);
			//System.out.println(previousQuantity);
			Connection con = ConnectionManager.getConnection();	
			//Connection con = null;
			try{
				
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		         
		     con.setAutoCommit(false);    
	          ////////////////////////////////////////////////////////////////////////////////////
		     
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
 					  "         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='"+medicalID+"') t1 ";
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

System.out.println("prescriptionID:"+prescriptionID);
System.out.println("editedQuantity:"+editquantiy);
System.out.println("medicineeditID:"+medicineeditID);
System.out.println(" Patient medicalID:"+patientID);

String sql22="UPDATE MCENTER.MEDICINE_SAVE SET DRGQTY='"+editquantiy+"' WHERE PRESCRIPTIONID='"+prescriptionID+"'   and MED_ID='"+medicineeditID+"' and PATIENTID ='"+patientID+"'";
	      
//Statement stmt=con.createStatement();
//stmt.execute(sql1);

	ps5 = con.prepareStatement(sql22);
    ps5.executeQuery();
    
    
    
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
		
			 quantity=rs4.getInt(5);
			 temp= quantity*rate;
			 total =total+temp;
			
	   EditprescriptionByDoctor mbill=new EditprescriptionByDoctor();
		mbill.setMedicineID(medicineID);
		mbill.setMedicineName(medicineName);
		mbill.setMedicineQuantity(quantity);
		mbill.setRate(rate);
		mbill.setTotal(total);
		//a=rs2.getString(16);
	    //	b=rs2.getInt(17);
		
		editprescriptionList.add(mbill);

		}
		
    con.commit();	
	
			}
			
			catch(Exception e){
				e.printStackTrace();
			
			
			
			 if (con != null) {
		            try {
		            	System.err.println("There is sql exception Mr.Adnan");
		                System.out.println(" So...Transaction is being rolled back in EditprescriptionByDoctor at editmedicineQuantiryBYdoctor()");
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
			        if (ps5!= null) {
			        	ps5.close();
			        }
			       
			       
			        con.setAutoCommit(true);
			        con.close();
			    }
			
			return "success";
			
	   }
			
	
	
	
	
//////////////////////////////// for  see in  one page////////////////////////////////////////////	
	
public String editMedicine() throws Exception{
	   System.out.println(serialNO);
	   System.out.println(mName);
	   System.out.println(editedQuantity);
	  
	   System.out.println("HIii.........");
		//HttpServletRequest request = ServletActionContext.getRequest();
		
		//String serialNO=request.getParameter("r");
		
		//System.out.println(" hi...Adnan");
		//System.out.println(serialNO);
	   Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
            
             
            
             
             
             
			
			String sql2="Select * from MCENTER.PRESCRIPTION where VISITID='"+serialNO+"'";
			
			ps5=con.prepareStatement(sql2);
			ResultSet rs5=ps5.executeQuery();
			while(rs5.next()){
				
				 quantity=rs5.getInt(17);
				 temp= quantity*rate;
				 total =total+temp;
				
				
				 EditprescriptionByDoctor mbill=new EditprescriptionByDoctor();
				
				mbill.setMedicineName(rs5.getString(16));
				mbill.setMedicineQuantity(rs5.getInt(17));
				mbill.setTotal(total);
				//a=rs2.getString(16);
			    //	b=rs2.getInt(17);
				
				editprescriptionList.add(mbill);
				
				
			
				
				
				
				
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
		       
		       
		        if (ps5!= null) {
		        	ps5.close();
		        }
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }
	
	
	

}
