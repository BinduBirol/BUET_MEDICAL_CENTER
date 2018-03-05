package com.mcenter.doctorManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.mcenter.patientManagement.CreateSerialDAO;
import com.mcenter.report.TokenforSerialedpatient1;

import util.ConnectionUtil.ConnectionManager;




public class RecommendDoctor {
	
	
	private String recDOCTOR;
	private int recomendarionNUMBER;
	private int availableRoundNumber;
	private int individualCurrentRoundNumber;
	private String doctorNAME;
	private String doctorName;
	
	private String serialedpatientName;
	private String serialNo;
	private String patientNAME;
	private String personID;
	
	private int patientNumberTEMP;
	private int patientNumber;
	private String lastDoctor;
	private int maximumrecommendNumber;
	private int roundNumber;
	private int condition1;
	private int anyActiveDoctor;
	
	private String medicalID;
	private String patientID;
	private String medicalIDholderName;
	private String departmentID;
	private String department;
	private String designation;
	private String patientRelationWithIDholder;
	private String patientName;
	private String doctorID;
	private String shift;
	
	    PreparedStatement ps16 = null;
		PreparedStatement ps26 = null;
	
	
	  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	   //get current date time with Date()
	   Date date = new Date();
	   String Date = dateFormat.format(date);
	
	   DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
  	   //get current date time with Date()
  	   Date serialdate1 = new Date();
  	   String DateofSerial1 = dateFormat1.format(serialdate1);
	   

public int getAvailableRoundNumber() {
		return availableRoundNumber;
	}


	public void setAvailableRoundNumber(int availableRoundNumber) {
		this.availableRoundNumber = availableRoundNumber;
	}


	public int getIndividualCurrentRoundNumber() {
		return individualCurrentRoundNumber;
	}


	public void setIndividualCurrentRoundNumber(int individualCurrentRoundNumber) {
		this.individualCurrentRoundNumber = individualCurrentRoundNumber;
	}


public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


public String getShift() {
		return shift;
	}


	public void setShift(String shift) {
		this.shift = shift;
	}


public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


public int getPatientNumber() {
		return patientNumber;
	}


	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}


	public String getMedicalID() {
		return medicalID;
	}


	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}


	public String getPatientID() {
		return patientID;
	}


	public void setPatientID(String patientID) {
		this.patientID = patientID;
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


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getPatientRelationWithIDholder() {
		return patientRelationWithIDholder;
	}


	public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
		this.patientRelationWithIDholder = patientRelationWithIDholder;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}


public String getPatientNAME() {
		return patientNAME;
	}


	public void setPatientNAME(String patientNAME) {
		this.patientNAME = patientNAME;
	}


	public String getPersonID() {
		return personID;
	}


	public void setPersonID(String personID) {
		this.personID = personID;
	}


public int getCondition1() {
		return condition1;
	}


	public void setCondition1(int condition1) {
		this.condition1 = condition1;
	}


public int getMaximumrecommendNumber() {
		return maximumrecommendNumber;
	}


	public void setMaximumrecommendNumber(int maximumrecommendNumber) {
		this.maximumrecommendNumber = maximumrecommendNumber;
	}


	public int getRoundNumber() {
		return roundNumber;
	}


	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}


public String getLastDoctor() {
		return lastDoctor;
	}


	public void setLastDoctor(String lastDoctor) {
		this.lastDoctor = lastDoctor;
	}


public String getDoctorNAME() {
		return doctorNAME;
	}


	public void setDoctorNAME(String doctorNAME) {
		this.doctorNAME = doctorNAME;
	}

public int getRecomendarionNUMBER() {
		return recomendarionNUMBER;
	}


	public void setRecomendarionNUMBER(int recomendarionNUMBER) {
		this.recomendarionNUMBER = recomendarionNUMBER;
	}


public String getRecDOCTOR() {
		return recDOCTOR;
	}


	public void setRecDOCTOR(String recDOCTOR) {
		this.recDOCTOR = recDOCTOR;
	}

public String getSerialedpatientName() {
		return serialedpatientName;
	}


	public void setSerialedpatientName(String serialedpatientName) {
		this.serialedpatientName = serialedpatientName;
	}


	public String getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

   public int getAnyActiveDoctor() {
		return anyActiveDoctor;
	}


	public void setAnyActiveDoctor(int anyActiveDoctor) {
		this.anyActiveDoctor = anyActiveDoctor;
	}


public String doctorrecomendation(){
	//System.out.println("Adnan");
	//System.out.println(recDOCTOR);
	
	HttpServletRequest request = ServletActionContext.getRequest();
	//serialNo=request.getParameter("recommendedserialadvance");
	recDOCTOR=request.getParameter("recommendeddoctoradvance");
	serialedpatientName=request.getParameter("recommendedpatientNameadvance");
	//shift=request.getParameter("recommendeshiftadvancehidden");
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	
	try{
		
		
	//	int[] temp = new int[100];
		
		
		
		
		/*String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/
         
/*         Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		
		String sql="SELECT COUNT (*) ACTIVE_DOCTOR \n" +
	              "  FROM MCENTER.TODAYDOCTOR\n" +
	              " WHERE     D_DATE = (SELECT TO_DATE (CURRENT_DATE) FROM DUAL)\n" +
	              "       AND SHIFT_SATUS= 'running'\n" +
	              "       AND STATUS='active'";
		
        PreparedStatement ps99=con.prepareStatement(sql);
		ResultSet rs99=ps99.executeQuery();
		 while(rs99.next()){
		                         
			 anyActiveDoctor=rs99.getInt("ACTIVE_DOCTOR");//active+not recomended
		             			
		              }
		 

		 
		if(anyActiveDoctor>0){
		
		CreateSerialDAO recadDAO= new CreateSerialDAO();
		recadDAO.createSerialANDassignDoctor();	 
		serialNo=recadDAO.getSerialNumber();	
		shift=recadDAO.getShift();     

		
		
		
		
         PreparedStatement ps1=con.prepareStatement("SELECT * FROM todaydoctor  WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') AND  OFFICIALID='"+recDOCTOR+"' and SHIFT_SATUS='running'  ");
         ResultSet rs1=ps1.executeQuery();
         while(rs1.next()){
                         
        	// doctorNAME=rs1.getString(3);
        	 doctorName=rs1.getString(3);
        	 recomendarionNUMBER=rs1.getInt(7);
        	 individualCurrentRoundNumber=rs1.getInt(8);
        	 availableRoundNumber=rs1.getInt(12);
        	 System.out.println("Doctor Name:"+doctorName);		
                      }
              	 
       
         
         
         recomendarionNUMBER=recomendarionNUMBER+1;
         
         if(individualCurrentRoundNumber>=1 && availableRoundNumber==1){
        	 availableRoundNumber=individualCurrentRoundNumber+1; 
        	 }

         if(individualCurrentRoundNumber>1 && availableRoundNumber>1){
        	 if(individualCurrentRoundNumber>=availableRoundNumber)
        	 {
        	 availableRoundNumber=individualCurrentRoundNumber+1; 
        	 }
        	 else if(individualCurrentRoundNumber<availableRoundNumber){
            	 availableRoundNumber=availableRoundNumber+1; 
            	 }
        	 }
 
         //availableRoundNumber=recomendarionNUMBER+individualCurrentRoundNumber;
         PreparedStatement ps=con.prepareStatement("UPDATE todaydoctor SET AVAILABLE_ROUNDNUMBER='"+availableRoundNumber+"',recommended='YES',activity='busy',recommendNumber='"+recomendarionNUMBER +"'  WHERE OFFICIALID='"+recDOCTOR+"' and d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' ");
         ps.executeUpdate(); 
         
    //////////////////////////////////////////////////////////////////////     
         
         PreparedStatement ps9=con.prepareStatement("SELECT count(*) as condition1 FROM todaydoctor    WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') AND activity='idle' and  STATUS='active' AND recommended='NO' and SHIFT_SATUS='running' ");
		 ResultSet rs9=ps9.executeQuery();
		 while(rs9.next()){
		                         
			 condition1=rs9.getInt("condition1");//active+not recomended
		             			
		                      }
         
         
         if(condition1==0)
		 {
        	 
		 PreparedStatement ps10=con.prepareStatement("UPDATE todaydoctor SET activity='idle' WHERE  activity='busy'and STATUS='active' AND recommended='NO'and d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' ");
	         ps10.executeUpdate();
	         
	         			 
	         PreparedStatement ps6=con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' and SHIFT_SATUS='running' ");
			 ResultSet rs6=ps6.executeQuery();
			 while(rs6.next()){
			                         
				 maximumrecommendNumber=rs6.getInt(7);
				 roundNumber=rs6.getInt(8);

				int roundNumberTEMP=roundNumber+1;
				 PreparedStatement ps5=con.prepareStatement("UPDATE todaydoctor SET  roundnumber='"+roundNumberTEMP+"'  WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  roundnumber='"+roundNumber+"' and  STATUS='active' and SHIFT_SATUS='running' ");
		         ps5.executeUpdate();
				   
				}
			 
			 
			    PreparedStatement ps7=con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  ROUNDNUMBER>=AVAILABLE_ROUNDNUMBER and d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' and SHIFT_SATUS='running' ");
				ps7.executeUpdate(); 
        	 
        	 
        	 
		 }
          
		 

		 
		 String sql2="select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy') ";
         ps = con.prepareStatement(sql2);
         
         
       
         
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
        	 
        	 patientNumberTEMP=rs.getInt(1);
        	 
			
         }
	 
         patientNumber=patientNumberTEMP+1;
         
         
         PreparedStatement ps33=con.prepareStatement("SELECT DISTINCT t1.id, t1.name " +
     			"  FROM (SELECT STUDENTID id, STUDENTNAME name " +
     			"          FROM BIIS.STUDENT " +
     			"         WHERE BIIS.STUDENT.STUDENTID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT OFFICIAL_ID id, NAME name " +
     			"          FROM ESTABLISHMENT.PERSONNEL " +
     			"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT TEMPID id, NAME name " +
     			"          FROM MCENTER.NONIDPATIENT " +
     			"         WHERE MCENTER.NONIDPATIENT.TEMPID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT OFFICIALID id, DNAME name " +
     			"          FROM DEPENDENCY " +
     			"         WHERE DEPENDENCY.DEPENDENTID='"+serialedpatientName+"') t1 ");		         
     	
         ResultSet rs33=ps33.executeQuery();
while(rs33.next()){

personID=rs33.getString(1);
patientNAME=rs33.getString(2); 

  
}


PreparedStatement ps5=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+personID+"','"+serialNo+"',to_date('"+Date+"','mm/dd/yyyy'),'"+doctorName+"' ,'"+serialedpatientName+"','"+patientNAME+"','"+patientNumber+"','"+recDOCTOR+"','"+shift+"')");
ps5.executeUpdate();	 
  /*   PreparedStatement ps5=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+serialNo+"','"+serialNo+"',to_date('"+Date+"','mm/dd/yyyy'),'"+doctorNAME+"' ,'"+serialedpatientName+"','"+serialedpatientName+"','"+patientNumber+"')");
			ps5.executeUpdate();*/
		 
		 
String sql12="Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT from MCENTER.PATIENT_HISTORY where VISITID='"+serialNo+"'";
//String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
ps16 = con.prepareStatement(sql12);


ResultSet rs12=ps16.executeQuery();
while(rs12.next()){
	

	medicalID=rs12.getString(1);
	patientID=rs12.getString(2);
	patientName=rs12.getString(3);
	doctorID=rs12.getString(4);
	shift=rs12.getString(5);
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

String sql22="SELECT DISTINCT t1.id, " +
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
ps26 = con.prepareStatement(sql22);


ResultSet rs22=ps26.executeQuery();
while(rs22.next()){
	
	
	
	
	
	 medicalIDholderName=rs22.getString(2);
  department=rs22.getString(3);
	 designation=rs22.getString(4);
	
	}

if(designation==null)
{
	 designation="Student";	 
	 
}      

         
        
TokenforSerialedpatient1 a= new TokenforSerialedpatient1();
a.report(doctorName,patientName,shift,patientID,serialNo,DateofSerial1);      	 

         con.close();
	}}
	catch(Exception e){e.printStackTrace();}
	
	 if(anyActiveDoctor==0){
		 
		 return "error";
	 }
	 
	else{
	return "success";
	 }
	
	}

public String normaldoctorrecomendation(){
	//System.out.println("Adnan");
	//System.out.println(recDOCTOR);
	
	HttpServletRequest request = ServletActionContext.getRequest();
	//serialNo=request.getParameter("recommendedserial");
	recDOCTOR=request.getParameter("recommendeddoctor");
	serialedpatientName=request.getParameter("recommendedpatientName");
	//shift=request.getParameter("recommendedshiftPatient");
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	
	
	
	try{
		
		
	//	int[] temp = new int[100];
		
		
		
		
		/*String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/
         
  /*       Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
		
		String sql="SELECT COUNT (*) ACTIVE_DOCTOR \n" +
	              "  FROM MCENTER.TODAYDOCTOR\n" +
	              " WHERE     D_DATE = (SELECT TO_DATE (CURRENT_DATE) FROM DUAL)\n" +
	              "       AND SHIFT_SATUS= 'running'\n" +
	              "       AND STATUS='active'";
		
        PreparedStatement ps99=con.prepareStatement(sql);
		ResultSet rs99=ps99.executeQuery();
		 while(rs99.next()){
		                         
			 anyActiveDoctor=rs99.getInt("ACTIVE_DOCTOR");//active+not recomended
		             			
		              }
		 

		 
		if(anyActiveDoctor>0){ 
		
		CreateSerialDAO recnormalDAO= new CreateSerialDAO();
		recnormalDAO.createSerialANDassignDoctor();	 
		serialNo=recnormalDAO.getSerialNumber();	
		shift=recnormalDAO.getShift();  
   

         PreparedStatement ps1=con.prepareStatement("SELECT * FROM todaydoctor  WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') AND  OFFICIALID='"+recDOCTOR+"' and SHIFT_SATUS='running'  ");
         ResultSet rs1=ps1.executeQuery();
         while(rs1.next()){
                         
        	// doctorNAME=rs1.getString(3);
        	 doctorName=rs1.getString(3);
        	 recomendarionNUMBER=rs1.getInt(7);
        	 individualCurrentRoundNumber=rs1.getInt(8);
        	 availableRoundNumber=rs1.getInt(12);
        	 System.out.println("Doctor Name:"+doctorName);		
                      }
              	 
       
         
         
         recomendarionNUMBER=recomendarionNUMBER+1;
         
         if(individualCurrentRoundNumber>=1 && availableRoundNumber==1){
        	 availableRoundNumber=individualCurrentRoundNumber+1; 
        	 }

         if(individualCurrentRoundNumber>1 && availableRoundNumber>1){
        	 if(individualCurrentRoundNumber>=availableRoundNumber)
        	 {
        	 availableRoundNumber=individualCurrentRoundNumber+1; 
        	 }
        	 else if(individualCurrentRoundNumber<availableRoundNumber){
            	 availableRoundNumber=availableRoundNumber+1; 
            	 }
        	 }
 
         //availableRoundNumber=recomendarionNUMBER+individualCurrentRoundNumber;
         PreparedStatement ps=con.prepareStatement("UPDATE todaydoctor SET AVAILABLE_ROUNDNUMBER='"+availableRoundNumber+"',recommended='YES',activity='busy',recommendNumber='"+recomendarionNUMBER +"'  WHERE OFFICIALID='"+recDOCTOR+"' and d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' ");
         ps.executeUpdate(); 
         
    //////////////////////////////////////////////////////////////////////     
         
         PreparedStatement ps9=con.prepareStatement("SELECT count(*) as condition1 FROM todaydoctor    WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') AND activity='idle' and  STATUS='active' AND recommended='NO' and SHIFT_SATUS='running' ");
		 ResultSet rs9=ps9.executeQuery();
		 while(rs9.next()){
		                         
			 condition1=rs9.getInt("condition1");//active+not recomended
		             			
		                      }
         
         
         if(condition1==0)
		 {
        	 
		 PreparedStatement ps10=con.prepareStatement("UPDATE todaydoctor SET activity='idle' WHERE  activity='busy'and STATUS='active' AND recommended='NO'and d_date=to_date('"+Date+"','mm/dd/yyyy') and SHIFT_SATUS='running' ");
	         ps10.executeUpdate();
	         
	         			 
	         PreparedStatement ps6=con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' and SHIFT_SATUS='running' ");
			 ResultSet rs6=ps6.executeQuery();
			 while(rs6.next()){
			                         
				 maximumrecommendNumber=rs6.getInt(7);
				 roundNumber=rs6.getInt(8);

				int roundNumberTEMP=roundNumber+1;
				 PreparedStatement ps5=con.prepareStatement("UPDATE todaydoctor SET  roundnumber='"+roundNumberTEMP+"'  WHERE  d_date=to_date('"+Date+"','mm/dd/yyyy') and  roundnumber='"+roundNumber+"' and  STATUS='active' and SHIFT_SATUS='running' ");
		         ps5.executeUpdate();
				   
				}
			 
			 
			    PreparedStatement ps7=con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  ROUNDNUMBER>=AVAILABLE_ROUNDNUMBER and d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' and SHIFT_SATUS='running' ");
				ps7.executeUpdate(); 
        	 
        	 
        	 
		 }
          
		 

		 
		 String sql2="select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy') ";
         ps = con.prepareStatement(sql2);
         
         
       
         
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
        	 
        	 patientNumberTEMP=rs.getInt(1);
        	 
			
         }
	 
         patientNumber=patientNumberTEMP+1;
         
         
         PreparedStatement ps33=con.prepareStatement("SELECT DISTINCT t1.id, t1.name " +
     			"  FROM (SELECT STUDENTID id, STUDENTNAME name " +
     			"          FROM BIIS.STUDENT " +
     			"         WHERE BIIS.STUDENT.STUDENTID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT OFFICIAL_ID id, NAME name " +
     			"          FROM ESTABLISHMENT.PERSONNEL " +
     			"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT TEMPID id, NAME name " +
     			"          FROM MCENTER.NONIDPATIENT " +
     			"         WHERE MCENTER.NONIDPATIENT.TEMPID='"+serialedpatientName+"' " +
     			"        UNION " +
     			"        SELECT OFFICIALID id, DNAME name " +
     			"          FROM DEPENDENCY " +
     			"         WHERE DEPENDENCY.DEPENDENTID='"+serialedpatientName+"') t1 ");		         
     	
         ResultSet rs33=ps33.executeQuery();
while(rs33.next()){

personID=rs33.getString(1);
patientNAME=rs33.getString(2); 

  
}


PreparedStatement ps5=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+personID+"','"+serialNo+"',to_date('"+Date+"','mm/dd/yyyy'),'"+doctorName+"' ,'"+serialedpatientName+"','"+patientNAME+"','"+patientNumber+"','"+recDOCTOR+"','"+shift+"')");
ps5.executeUpdate();	 
  /*   PreparedStatement ps5=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+serialNo+"','"+serialNo+"',to_date('"+Date+"','mm/dd/yyyy'),'"+doctorNAME+"' ,'"+serialedpatientName+"','"+serialedpatientName+"','"+patientNumber+"')");
			ps5.executeUpdate();*/
		 
		 
String sql12="Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT from MCENTER.PATIENT_HISTORY where VISITID='"+serialNo+"'";
//String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
ps16 = con.prepareStatement(sql12);


ResultSet rs12=ps16.executeQuery();
while(rs12.next()){
	

	medicalID=rs12.getString(1);
	patientID=rs12.getString(2);
	patientName=rs12.getString(3);
	doctorID=rs12.getString(4);
	shift=rs12.getString(5);
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

String sql22="SELECT DISTINCT t1.id, " +
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
ps26 = con.prepareStatement(sql22);


ResultSet rs22=ps26.executeQuery();
while(rs22.next()){
	
	
	
	
	
	 medicalIDholderName=rs22.getString(2);
	 department=rs22.getString(3);
	 designation=rs22.getString(4);
	
	}

if(designation==null)
{
	 designation="Student";	 
	 
}      

         
        
TokenforSerialedpatient1 a= new TokenforSerialedpatient1();
a.report(doctorName,patientName,shift,patientID,serialNo,DateofSerial1);      	 

         con.close();
		 }       
		 }	
	catch(Exception e){e.printStackTrace();
	
	}
	
	 if(anyActiveDoctor==0){
		 
		 return "error";
	 }
	 
	else{
	return "success";
	 }	 
	}
	
		
	
	



	

}
