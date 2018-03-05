package com.mcenter.patientManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.mcenter.report.MoneyReceiptforNewAdmitedStudent;
import com.mcenter.report.TokenforSerialedpatient1;
import com.opensymphony.xwork2.ActionSupport;

public class DailyPatientInput extends ActionSupport {
	//	public HttpServletRequest request;
	private String patientId; //official ID
	private String serialedpatientName;
	private String serialNo;
	private String doctorName;
	private String doctorID;
	private String patientmedicalID;
	private String Name;
	private String dependentName;
	private String idholderName;
	private String relation;
	private String patientNAME;
	private String personID;
	private String shift;
	private int individualCurrentRoundNumber;
	private String patientName;
	private String assignedDoctor;
	private String assignedDoctorofficialID;
	private String serialNumber;
	private int digitforserialNumber;
	private int anyActiveDoctor;
	private String lastDoctor;
	private String lastDoctorNAME;
	private String lastDoctorID;
	private int roundNumber;
	private int maximumrecommendNumber;

	private int patientNumberTEMP;
	private int patientNumber;

	//////////////////////////////////
	//private String doctorID;
	//private String doctorName;
	private String medicalID;
	private String patientID;
	private String medicalIDholderName;
	private String departmentID;
	private String department;
	//private String patientName;
	private String patientRelationWithIDholder;
	private String visitID;
	private String designation;

	///////////////////////////////////


	//private String patientautocompleteID;

	HttpServletRequest request = ServletActionContext.getRequest();
	private String patientautocompleteID = request.getParameter("patientautocompleteID");

	//HttpServletRequest request =  ServletActionContext.getRequest();
	//String searchString = request.getParameter("term");

	ArrayList < DailyPatientInput > patientIdsearchList = new ArrayList < DailyPatientInput > ();
	//String name=request.getParameter("r");
	ArrayList < String > patients = new ArrayList < String > ();
	ArrayList < String > patientsidlist = new ArrayList < String > ();



	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	//get current date time with Date()
	Date date = new Date();
	String Date = dateFormat.format(date);


	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps16 = null;
	PreparedStatement ps26 = null;
	PreparedStatement ps36 = null;
	PreparedStatement ps46 = null;
	PreparedStatement ps56 = null;
	PreparedStatement ps66 = null;
	PreparedStatement ps76 = null;

	DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
	//get current date time with Date()
	Date serialdate1 = new Date();
	String DateofSerial1 = dateFormat1.format(serialdate1);






	public int getAnyActiveDoctor() {
		return anyActiveDoctor;
	}


	public void setAnyActiveDoctor(int anyActiveDoctor) {
		this.anyActiveDoctor = anyActiveDoctor;
	}


	public int getIndividualCurrentRoundNumber() {
		return individualCurrentRoundNumber;
	}


	public void setIndividualCurrentRoundNumber(int individualCurrentRoundNumber) {
		this.individualCurrentRoundNumber = individualCurrentRoundNumber;
	}


	public String getLastDoctorNAME() {
		return lastDoctorNAME;
	}


	public void setLastDoctorNAME(String lastDoctorNAME) {
		this.lastDoctorNAME = lastDoctorNAME;
	}


	public String getLastDoctorID() {
		return lastDoctorID;
	}


	public void setLastDoctorID(String lastDoctorID) {
		this.lastDoctorID = lastDoctorID;
	}


	public String getShift() {
		return shift;
	}


	public void setShift(String shift) {
		this.shift = shift;
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


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPatientRelationWithIDholder() {
		return patientRelationWithIDholder;
	}


	public void setPatientRelationWithIDholder(String patientRelationWithIDholder) {
		this.patientRelationWithIDholder = patientRelationWithIDholder;
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


	public String getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}


	public String getAssignedDoctorofficialID() {
		return assignedDoctorofficialID;
	}


	public void setAssignedDoctorofficialID(String assignedDoctorofficialID) {
		this.assignedDoctorofficialID = assignedDoctorofficialID;
	}


	public ArrayList < String > getPatientsidlist() {
		return patientsidlist;
	}


	public void setPatientsidlist(ArrayList < String > patientsidlist) {
		this.patientsidlist = patientsidlist;
	}


	public ArrayList < String > getPatients() {
		return patients;
	}

	public void setPatients(ArrayList < String > patients) {
		this.patients = patients;
	}


	public String getIdholderName() {
		return idholderName;
	}


	public void setIdholderName(String idholderName) {
		this.idholderName = idholderName;
	}


	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPatientautocompleteID() {
		return patientautocompleteID;
	}

	public void setPatientautocompleteID(String patientautocompleteID) {
		this.patientautocompleteID = patientautocompleteID;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAssignedDoctor() {
		return assignedDoctor;
	}

	public void setAssignedDoctor(String assignedDoctor) {
		this.assignedDoctor = assignedDoctor;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientmedicalID() {
		return patientmedicalID;
	}
	public void setPatientmedicalID(String patientmedicalID) {
		this.patientmedicalID = patientmedicalID;
	}

	public int getDigitforserialNumber() {
		return digitforserialNumber;
	}

	public void setDigitforserialNumber(int digitforserialNumber) {
		this.digitforserialNumber = digitforserialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getLastDoctor() {
		return lastDoctor;
	}

	public void setLastDoctor(String lastDoctor) {
		this.lastDoctor = lastDoctor;
	}

	public ArrayList < DailyPatientInput > getPatientIdsearchList() {
		return patientIdsearchList;
	}
	public void setPatientIdsearchList(
	ArrayList < DailyPatientInput > patientIdsearchList) {
		this.patientIdsearchList = patientIdsearchList;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String searchPatientAutocomplete() {


		//System.out.println(searchString);
		//Connection con = null;
		Connection con = ConnectionManager.getConnection();

		try {


			//	int[] temp = new int[100];




			/*String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/


			/*    Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/

			String concatString = patientautocompleteID.concat("%");

			PreparedStatement ps = con.prepareStatement("select * from patient where MedicalID LIKE '" + concatString + "'  ");
			ResultSet rs = ps.executeQuery();
			System.out.println("Autocomplete is done..");

			while (rs.next()) {
				DailyPatientInput patientautocomplete = new DailyPatientInput();


				patientautocomplete.setPatientautocompleteID(rs.getString(1));

				patientIdsearchList.add(patientautocomplete);

			}

			// ConnectionManager.closeConnection(con);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "success";

	}





	public String searchIdholderName() {
		System.out.println("HIT id holder search :" + patientmedicalID);
		Connection con = ConnectionManager.getConnection();
		//Connection con = null;

		try {


			//	int[] temp = new int[100];




			/*String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/

			/*	Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/


			PreparedStatement ps = con.prepareStatement("select distinct t1.id,temp.pid , temp.name" +
				" from (select STUDENTID id,STUDENTNAME name from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='" + patientmedicalID + "' " +
				"union " +
				"select OFFICIAL_ID id, NAME name from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + patientmedicalID + "'" +
				"union   " +
				"select TEMPID id, NAME name from MCENTER.NONIDPATIENT where MCENTER.NONIDPATIENT.TEMPID='" + patientmedicalID + "')t1, " +
				"(select STUDENTID pid,STUDENTNAME name  from BIIS.STUDENT   where BIIS.STUDENT.STUDENTID='" + patientmedicalID + "'  " +
				"union     " +
				"select OFFICIAL_ID pid, NAME name  from ESTABLISHMENT.PERSONNEL    where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + patientmedicalID + "'" +
				"union   " +
				"select TEMPID pid, NAME name from MCENTER.NONIDPATIENT where MCENTER.NONIDPATIENT.TEMPID='" + patientmedicalID + "') temp");


			// PreparedStatement ps=con.prepareStatement("select * from patient where MedicalID='"+patientmedicalID+"'  ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {


				DailyPatientInput patientsearchbyneducalID = new DailyPatientInput();


				patientsearchbyneducalID.setPatientName(rs.getString(3));

				setName((rs.getString(3)));
				System.out.println("Name:" + Name);

			}




			PreparedStatement ps1 = con.prepareStatement("select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('" + Date + "','mm/dd/yyyy')");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {

				digitforserialNumber = rs1.getInt(1);

			}


			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			//get current date time with Date()
			Date serialdate = new Date();
			String DateofSerial = dateFormat.format(serialdate);

			digitforserialNumber = digitforserialNumber + 1;
			serialNumber = DateofSerial + "-" + "P-" + digitforserialNumber;



			PreparedStatement ps2 = con.prepareStatement("SELECT SID, " +
				"       NAME, " +
				"       OFFICIALID, " +
				"       DUTYHOUR " +
				"  FROM todaydoctor " +
				" WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"       AND STATUS = 'active' " +
				"       AND recommended = 'NO' " +
				"       AND activity = 'idle' " +
				"       AND SHIFT_SATUS = 'running' " +
				"       AND SID = " +
				"              (SELECT MIN (SID) " +
				"                 FROM todaydoctor " +
				"                WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"                      AND STATUS = 'active' " +
				"                      AND recommended = 'NO' " +
				"                      AND activity = 'idle' " +
				"                      AND SHIFT_SATUS = 'running') ");


			/*PreparedStatement ps2=con.prepareStatement("SELECT " +
		"(SELECT max(NAME) FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle' )name," +
		"OFFICIALID,DUTYHOUR FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle'" +
		" and NAME=(SELECT max(NAME)name FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle')  "); */
			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				assignedDoctor = rs2.getString(2);
				assignedDoctorofficialID = rs2.getString(3);
				shift = rs2.getString(4);
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "success";

	}



	public String searchPatient() {
		System.out.println("HIT patientsearch:" + patientmedicalID);
		Connection con = ConnectionManager.getConnection();
		//Connection con = null;

		try {


			//	int[] temp = new int[100];




			/*	String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/

			/*         Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/



			PreparedStatement ps = con.prepareStatement("select distinct t1.id,temp.pid , temp.name" +
				" from (select STUDENTID id,STUDENTNAME name from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='" + patientmedicalID + "' " +
				"union " +
				"select OFFICIAL_ID id, NAME name from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + patientmedicalID + "'" +
				"union   " +
				"select TEMPID id, NAME name from MCENTER.NONIDPATIENT where MCENTER.NONIDPATIENT.TEMPID='" + patientmedicalID + "')t1, " +
				"(select STUDENTID pid,STUDENTNAME name  from BIIS.STUDENT   where BIIS.STUDENT.STUDENTID='" + patientmedicalID + "'  " +
				"union     " +
				"select OFFICIAL_ID pid, NAME name  from ESTABLISHMENT.PERSONNEL    where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + patientmedicalID + "'  " +
				"union   " +
				"select DEPENDENTID pid, DNAME name     from DEPENDENCY   where DEPENDENCY.OFFICIALID='" + patientmedicalID + "' " +
				"union   " +
				"select TEMPID pid, NAME name from MCENTER.NONIDPATIENT where MCENTER.NONIDPATIENT.TEMPID='" + patientmedicalID + "'  ) temp");


			// PreparedStatement ps=con.prepareStatement("select * from patient where MedicalID='"+patientmedicalID+"'  ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				patients.add(rs.getString(3));
				patientsidlist.add(rs.getString(2));

				System.out.println(patients.size());

			}


			System.out.println("Number of patients: " + patients.size());

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "success";

	}



	public String relationwithIDholder() {
		System.out.println("HIT:" + dependentName);

		//Connection con = null;

		try {


			//	int[] temp = new int[100];




			/*String URL = "jdbc:mysql://localhost/mcenter";
        Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(URL, "root", "");*/


			/*     Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/

			Connection con = ConnectionManager.getConnection();

			if (patientmedicalID.equals(dependentName)) {
				relation = "Self";

			} else {


				PreparedStatement ps1 = con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='" + dependentName + "'  ");
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {

					relation = rs1.getString(6);

				}


			}

			System.out.println(relation);

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return "success";

	}



	public String savedailyPatient() {
		//	System.out.println("Adnan");


		HttpServletRequest request = ServletActionContext.getRequest();
		/*		serialNo=request.getParameter("serialadvancesearch");
		doctorName=request.getParameter("assignedDoctoradvancesearch");
		doctorID=request.getParameter("assignedDoctorIDadvancesearchhidden");*/
		serialedpatientName = request.getParameter("patientNameadvancesearch");
		/*		shift=request.getParameter("advancesearchshifthidden");*/





		Connection con = ConnectionManager.getConnection();
		//Connection con = null;
		try {

			/*String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/


			/*    Class.forName("oracle.jdbc.driver.OracleDriver");
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
			
			CreateSerialDAO dDAO = new CreateSerialDAO();
			dDAO.createSerialANDassignDoctor();
			serialNo = dDAO.getSerialNumber();
			doctorName = dDAO.getAssignedDoctor();
			doctorID = dDAO.getAssignedDoctorofficialID();
			shift = dDAO.getShift();

			PreparedStatement ps2 = con.prepareStatement("SELECT SID, " +
				"       NAME, " +
				"       OFFICIALID, " +
				"       DUTYHOUR " +
				"  FROM todaydoctor " +
				" WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"       AND STATUS = 'active' " +
				"       AND recommended = 'NO' " +
				"       AND activity = 'idle' " +
				"       AND SHIFT_SATUS = 'running' " +
				"       AND SID = " +
				"              (SELECT MAX (SID) " +
				"                 FROM todaydoctor " +
				"                WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"                      AND STATUS = 'active' " +
				"                      AND recommended = 'NO' " +
				"                      AND activity = 'idle' " +
				"                      AND SHIFT_SATUS = 'running') ");

			/* PreparedStatement ps2=con.prepareStatement("SELECT min(NAME) FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle' and SHIFT_SATUS='running' ");*/

			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				lastDoctorNAME = rs2.getString(2);
				lastDoctorID = rs2.getString(3);

				// lastDoctor=rs2.getString(1);

			}
			System.out.println("LastDoctor:" + lastDoctorNAME);



			String sql2 = "select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('" + Date + "','mm/dd/yyyy')";
			ps2 = con.prepareStatement(sql2);




			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {

				patientNumberTEMP = rs.getInt(1);


			}

			patientNumber = patientNumberTEMP + 1;

			System.out.println("TEsting...." + serialedpatientName);

			PreparedStatement ps33 = con.prepareStatement("SELECT DISTINCT t1.id, t1.name " +
				"  FROM (SELECT STUDENTID id, STUDENTNAME name " +
				"          FROM BIIS.STUDENT " +
				"         WHERE BIIS.STUDENT.STUDENTID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT OFFICIAL_ID id, NAME name " +
				"          FROM ESTABLISHMENT.PERSONNEL " +
				"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT TEMPID id, NAME name " +
				"          FROM MCENTER.NONIDPATIENT " +
				"         WHERE MCENTER.NONIDPATIENT.TEMPID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT OFFICIALID id, DNAME name " +
				"          FROM DEPENDENCY " +
				"         WHERE DEPENDENCY.DEPENDENTID='" + serialedpatientName + "') t1 ");


			ResultSet rs33 = ps33.executeQuery();
			while (rs33.next()) {

				personID = rs33.getString(1);
				patientNAME = rs33.getString(2);


			}

			if (personID != null && serialNo != null) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('" + personID + "','" + serialNo + "',to_date('" + Date + "','mm/dd/yyyy'),'" + doctorName + "' ,'" + serialedpatientName + "','" + patientNAME + "','" + patientNumber + "','" + doctorID + "','" + shift + "')");
				//  PreparedStatement ps=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+patientNumber+"','"+serialNo+"','"+doctorName+"' ,'"+serialedpatientName+"','"+Date+"')");
				ps.executeUpdate();

			}


			// if(lastDoctor.equals(doctorName))
			if (lastDoctorID.equals(doctorID)) {


				/*PreparedStatement ps3=con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date='"+Date+"'");
		         ps3.executeUpdate();*/

				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();


				PreparedStatement ps3 = con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running'");
				ps3.executeUpdate();


				PreparedStatement ps6 = con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and SHIFT_SATUS='running' ");
				ResultSet rs6 = ps6.executeQuery();
				while (rs6.next()) {

					maximumrecommendNumber = rs6.getInt(7);
					roundNumber = rs6.getInt(8);


					int roundNumberTEMP = roundNumber + 1;
					PreparedStatement ps5 = con.prepareStatement("UPDATE todaydoctor SET  roundnumber='" + roundNumberTEMP + "'  WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  roundnumber='" + roundNumber + "' and  STATUS='active' and SHIFT_SATUS='running' ");
					ps5.executeUpdate();

				}


				PreparedStatement ps7 = con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  ROUNDNUMBER>=AVAILABLE_ROUNDNUMBER and d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' and SHIFT_SATUS='running' ");
				ps7.executeUpdate();



			} else {

				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET activity='busy',AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();

			}





			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			 

			String sql12 = "Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT from MCENTER.PATIENT_HISTORY where VISITID='" + serialNo + "'";
			// String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps16 = con.prepareStatement(sql12);


			ResultSet rs12 = ps16.executeQuery();
			while (rs12.next()) {


				medicalID = rs12.getString(1);
				patientID = rs12.getString(2);
				patientName = rs12.getString(3);
				doctorID = rs12.getString(4);
				shift = rs12.getString(5);
			}

			if (medicalID != null) {

				if (medicalID.equals(patientID)) {
					patientRelationWithIDholder = "Self";

				} else {


					PreparedStatement ps11 = con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='" + patientID + "'  ");
					ResultSet rs11 = ps11.executeQuery();
					while (rs11.next()) {

						patientRelationWithIDholder = rs11.getString(6);

					}


				}
			}

			//System.out.println(medicalID);
			//////////////////////////////////////////////	/

			String sql22 = "SELECT DISTINCT t1.id, " +
				"                t1.name, " +
				"                t1.departmentname, " +
				"                t1.DESIGNATION " +
				"  FROM (SELECT STUDENTID id, " +
				"               STUDENTNAME name, " +
				"               DEPARTMENTID departmentname, " +
				"               '' DESIGNATION " +
				"          FROM BIIS.STUDENT " +
				"         WHERE BIIS.STUDENT.STUDENTID ='" + medicalID + "' " +
				"         UNION " +
				"         SELECT TEMPID id, " +
				"               NAME name, " +
				"               DEPT departmentname, " +
				"               DESIGNATION DESIGNATION " +
				"          FROM MCENTER.NONIDPATIENT " +
				"         WHERE MCENTER.NONIDPATIENT.TEMPID='" + medicalID + "' " +
				"        UNION " +
				"        SELECT OFFICIAL_ID id, " +
				"               NAME name, " +
				"               (SELECT SHORT_DEPARTMENT_NAME " +
				"                  FROM ESTABLISHMENT.DEPARTMENT " +
				"                 WHERE DEPARTMENT_ID = " +
				"                          (SELECT DEPARTMENT_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  departmentname, " +
				"               (SELECT SHORT_DESIGNATION " +
				"                  FROM ESTABLISHMENT.DESIGNATION " +
				"                 WHERE DESIGNATION_ID = " +
				"                          (SELECT CURRENT_DESIGNATION_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  DESIGNATION " +
				"          FROM ESTABLISHMENT.PERSONNEL " +
				"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='" + medicalID + "') t1 ";
			ps26 = con.prepareStatement(sql22);


			ResultSet rs22 = ps26.executeQuery();
			while (rs22.next()) {

				medicalIDholderName = rs22.getString(2);
				department = rs22.getString(3);
				designation = rs22.getString(4);

			}

			if (designation == null) {
				designation = "Student";

			}


			System.out.println(doctorID);
			String sql3 = "Select * from MCENTER.TODAYDOCTOR where OFFICIALID='" + doctorID + "'";
			ps36 = con.prepareStatement(sql3);


			ResultSet rs3 = ps36.executeQuery();
			while (rs3.next()) {

				doctorName = rs3.getString(3);

			}


			TokenforSerialedpatient1 a = new TokenforSerialedpatient1();
			a.report(doctorName, patientName, shift, patientID, serialNo, DateofSerial1);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		 



			con.close();
		} }
		catch (Exception e) {



			e.printStackTrace();
		}

		 if(anyActiveDoctor==0){
			 
			 return "error";
		 }
		 
		else{
		return "success";
		 }
	}



	public String savedailyregularPatient() {
		//	System.out.println("Adnan");


		HttpServletRequest request = ServletActionContext.getRequest();
		//serialNo=request.getParameter("serial");
		//	doctorName=request.getParameter("assignedDoctor");
		//	doctorID=request.getParameter("assignedDoctorIDhidden");
		serialedpatientName = request.getParameter("patientName");
		System.out.println(serialedpatientName + "test");
		//	shift=request.getParameter("shifthidden");

		Connection con = ConnectionManager.getConnection();
		//Connection con = null;
		try {

			/*  Class.forName("oracle.jdbc.driver.OracleDriver");
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
			CreateSerialDAO dDAO = new CreateSerialDAO();
			dDAO.createSerialANDassignDoctor();
			serialNo = dDAO.getSerialNumber();
			doctorName = dDAO.getAssignedDoctor();
			doctorID = dDAO.getAssignedDoctorofficialID();
			shift = dDAO.getShift();




			PreparedStatement ps2 = con.prepareStatement("SELECT SID, " +
				"       NAME, " +
				"       OFFICIALID, " +
				"       DUTYHOUR " +
				"  FROM todaydoctor " +
				" WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"       AND STATUS = 'active' " +
				"       AND recommended = 'NO' " +
				"       AND activity = 'idle' " +
				"       AND SHIFT_SATUS = 'running' " +
				"       AND SID = " +
				"              (SELECT MAX (SID) " +
				"                 FROM todaydoctor " +
				"                WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"                      AND STATUS = 'active' " +
				"                      AND recommended = 'NO' " +
				"                      AND activity = 'idle' " +
				"                      AND SHIFT_SATUS = 'running') ");

			/* PreparedStatement ps2=con.prepareStatement("SELECT min(NAME) FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle' and SHIFT_SATUS='running' ");*/

			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				lastDoctorNAME = rs2.getString(2);
				lastDoctorID = rs2.getString(3);

				// lastDoctor=rs2.getString(1);

			}
			System.out.println("LastDoctor:" + lastDoctorNAME);



			String sql2 = "select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('" + Date + "','mm/dd/yyyy') ";
			ps2 = con.prepareStatement(sql2);




			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {

				patientNumberTEMP = rs.getInt(1);


			}

			patientNumber = patientNumberTEMP + 1;

			System.out.println("TEsting...." + serialedpatientName);
			/////



			PreparedStatement ps33 = con.prepareStatement("SELECT DISTINCT t1.id, t1.name " +
				"  FROM (SELECT STUDENTID id, STUDENTNAME name " +
				"          FROM BIIS.STUDENT " +
				"         WHERE BIIS.STUDENT.STUDENTID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT OFFICIAL_ID id, NAME name " +
				"          FROM ESTABLISHMENT.PERSONNEL " +
				"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT TEMPID id, NAME name " +
				"          FROM MCENTER.NONIDPATIENT " +
				"         WHERE MCENTER.NONIDPATIENT.TEMPID='" + serialedpatientName + "' " +
				"        UNION " +
				"        SELECT OFFICIALID id, DNAME name " +
				"          FROM DEPENDENCY " +
				"         WHERE DEPENDENCY.DEPENDENTID='" + serialedpatientName + "') t1 ");



			ResultSet rs33 = ps33.executeQuery();
			while (rs33.next()) {

				personID = rs33.getString(1);
				patientNAME = rs33.getString(2);


			}

			if (personID != null && serialNo != null) {
				PreparedStatement ps = con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('" + personID + "','" + serialNo + "',to_date('" + Date + "','mm/dd/yyyy'),'" + doctorName + "' ,'" + serialedpatientName + "','" + patientNAME + "','" + patientNumber + "','" + doctorID + "','" + shift + "')");
				//  PreparedStatement ps=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+patientNumber+"','"+serialNo+"','"+doctorName+"' ,'"+serialedpatientName+"','"+Date+"')");
				ps.executeUpdate();

			}


			if (lastDoctorID.equals(doctorID)) {
				/*
					 
					 PreparedStatement ps3=con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date='"+Date+"'");
			         ps3.executeUpdate();
			         
			         */

				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();

				PreparedStatement ps3 = con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps3.executeUpdate();


				PreparedStatement ps6 = con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and SHIFT_SATUS='running' ");
				ResultSet rs6 = ps6.executeQuery();
				while (rs6.next()) {

					maximumrecommendNumber = rs6.getInt(7);
					roundNumber = rs6.getInt(8);





					int roundNumberTEMP = roundNumber + 1;
					PreparedStatement ps5 = con.prepareStatement("UPDATE todaydoctor SET  roundnumber='" + roundNumberTEMP + "'  WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  roundnumber='" + roundNumber + "' and  STATUS='active' and SHIFT_SATUS='running' ");
					ps5.executeUpdate();

				}


				PreparedStatement ps7 = con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  ROUNDNUMBER>=AVAILABLE_ROUNDNUMBER and d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' and SHIFT_SATUS='running' ");
				ps7.executeUpdate();



			} else {

				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET activity='busy',AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();

			}





			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			 

			String sql12 = "Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT from MCENTER.PATIENT_HISTORY where VISITID='" + serialNo + "'";
			// String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps16 = con.prepareStatement(sql12);


			ResultSet rs12 = ps16.executeQuery();
			while (rs12.next()) {

				medicalID = rs12.getString(1);
				patientID = rs12.getString(2);
				patientName = rs12.getString(3);
				doctorID = rs12.getString(4);
				shift = rs12.getString(5);
			}

			if (medicalID != null) {

				if (medicalID.equals(patientID)) {
					patientRelationWithIDholder = "Self";

				} else {


					PreparedStatement ps11 = con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='" + patientID + "'  ");
					ResultSet rs11 = ps11.executeQuery();
					while (rs11.next()) {

						patientRelationWithIDholder = rs11.getString(6);

					}


				}
			}

			//System.out.println(medicalID);
			//////////////////////////////////////////////	/

			String sql22 = "SELECT DISTINCT t1.id, " +
				"                t1.name, " +
				"                t1.departmentname, " +
				"                t1.DESIGNATION " +
				"  FROM (SELECT STUDENTID id, " +
				"               STUDENTNAME name, " +
				"               DEPARTMENTID departmentname, " +
				"               '' DESIGNATION " +
				"          FROM BIIS.STUDENT " +
				"         WHERE BIIS.STUDENT.STUDENTID ='" + medicalID + "' " +
				"         UNION " +
				"         SELECT TEMPID id, " +
				"               NAME name, " +
				"               DEPT departmentname, " +
				"               DESIGNATION DESIGNATION " +
				"          FROM MCENTER.NONIDPATIENT " +
				"         WHERE MCENTER.NONIDPATIENT.TEMPID='" + medicalID + "' " +
				"        UNION " +
				"        SELECT OFFICIAL_ID id, " +
				"               NAME name, " +
				"               (SELECT SHORT_DEPARTMENT_NAME " +
				"                  FROM ESTABLISHMENT.DEPARTMENT " +
				"                 WHERE DEPARTMENT_ID = " +
				"                          (SELECT DEPARTMENT_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  departmentname, " +
				"               (SELECT SHORT_DESIGNATION " +
				"                  FROM ESTABLISHMENT.DESIGNATION " +
				"                 WHERE DESIGNATION_ID = " +
				"                          (SELECT CURRENT_DESIGNATION_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  DESIGNATION " +
				"          FROM ESTABLISHMENT.PERSONNEL " +
				"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='" + medicalID + "') t1 ";
			ps26 = con.prepareStatement(sql22);


			ResultSet rs22 = ps26.executeQuery();
			while (rs22.next()) {

				medicalIDholderName = rs22.getString(2);
				department = rs22.getString(3);
				designation = rs22.getString(4);

			}

			if (designation == null) {
				designation = "Student";

			}


			System.out.println(doctorID);
			String sql3 = "Select * from MCENTER.TODAYDOCTOR where OFFICIALID='" + doctorID + "'";
			ps36 = con.prepareStatement(sql3);


			ResultSet rs3 = ps36.executeQuery();
			while (rs3.next()) {

				doctorName = rs3.getString(3);

			}

			TokenforSerialedpatient1 a = new TokenforSerialedpatient1();
			a.report(doctorName, patientName, shift, patientID, serialNo, DateofSerial1);





			con.close();
		}}
		catch (Exception e) {



			e.printStackTrace();
		}

		 if(anyActiveDoctor==0){
			 
			 return "error";
		 }
		 
		else{
		return "success";
		 }
	}



	public String savedailyregularNONIDPatient() {
		//	System.out.println("Adnan");


		HttpServletRequest request = ServletActionContext.getRequest();
		//	serialNo=request.getParameter("serialnonid");
		//doctorName=request.getParameter("assignedDoctornonid");
		//doctorID=request.getParameter("assignedDoctornonidhidden");
		serialedpatientName = request.getParameter("patientname");
		//personID=request.getParameter("patientlId");
		department = request.getParameter("department");
		designation = request.getParameter("designation");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		//	shift=request.getParameter("nonidshifthidden");
		Connection con = ConnectionManager.getConnection();
		//Connection con = null;
		try {

			/*String URL = "jdbc:mysql://localhost/mcenter";
		        Class.forName("com.mysql.jdbc.Driver");
		         con = DriverManager.getConnection(URL, "root", "");*/

			/*		         
		         Class.forName("oracle.jdbc.driver.OracleDriver");
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
			CreateSerialDAO ddDAO = new CreateSerialDAO();
			ddDAO.createSerialANDassigndoctorforNONidpatient();
			serialNo = ddDAO.getSerialNumber();
			doctorName = ddDAO.getAssignedDoctor();
			doctorID = ddDAO.getAssignedDoctorofficialID();
			shift = ddDAO.getShift();
			personID = ddDAO.getPatientID();


			PreparedStatement ps2 = con.prepareStatement("SELECT SID, " +
				"       NAME, " +
				"       OFFICIALID, " +
				"       DUTYHOUR " +
				"  FROM todaydoctor " +
				" WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"       AND STATUS = 'active' " +
				"       AND recommended = 'NO' " +
				"       AND activity = 'idle' " +
				"       AND SHIFT_SATUS = 'running' " +
				"       AND SID = " +
				"              (SELECT MAX (SID) " +
				"                 FROM todaydoctor " +
				"                WHERE     d_date = TO_DATE ('" + Date + "', 'mm/dd/yyyy') " +
				"                      AND STATUS = 'active' " +
				"                      AND recommended = 'NO' " +
				"                      AND activity = 'idle' " +
				"                      AND SHIFT_SATUS = 'running') ");

			/* PreparedStatement ps2=con.prepareStatement("SELECT min(NAME) FROM todaydoctor   WHERE d_date=to_date('"+Date+"','mm/dd/yyyy') and  STATUS='active' AND recommended='NO' AND activity='idle' and SHIFT_SATUS='running' ");*/

			ResultSet rs2 = ps2.executeQuery();
			while (rs2.next()) {

				lastDoctorNAME = rs2.getString(2);
				lastDoctorID = rs2.getString(3);

				// lastDoctor=rs2.getString(1);

			}
			System.out.println("LastDoctor:" + lastDoctorNAME);



			String sql2 = "select count(*) from MCENTER.PATIENT_HISTORY where VISITINGDATE=to_date('" + Date + "','mm/dd/yyyy')";
			ps2 = con.prepareStatement(sql2);




			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {

				patientNumberTEMP = rs.getInt(1);


			}

			patientNumber = patientNumberTEMP + 1;

			System.out.println("TEsting...." + serialedpatientName);


			if (personID != null && serialNo != null) {
				PreparedStatement psnonID = con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('" + personID + "','" + serialNo + "',to_date('" + Date + "','mm/dd/yyyy'),'" + doctorName + "' ,'" + personID + "','" + serialedpatientName + "','" + patientNumber + "','" + doctorID + "','" + shift + "')");
				//  PreparedStatement ps=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+patientNumber+"','"+serialNo+"','"+doctorName+"' ,'"+serialedpatientName+"','"+Date+"')");
				psnonID.executeUpdate();

				PreparedStatement ps23 = con.prepareStatement("INSERT INTO MCENTER.NONIDPATIENT VALUES('" + personID + "','" + serialedpatientName + "','" + department + "','" + designation + "','" + gender + "',to_date('" + dob + "','dd/mm/yyyy'))");
				//  PreparedStatement ps=con.prepareStatement("INSERT INTO MCENTER.PATIENT_HISTORY VALUES('"+patientNumber+"','"+serialNo+"','"+doctorName+"' ,'"+serialedpatientName+"','"+Date+"')");
				ps23.executeUpdate();

			}


			if (lastDoctorID.equals(doctorID)) {
				/*
					 
					 PreparedStatement ps3=con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date='"+Date+"'");
			         ps3.executeUpdate();
			         
			         */
				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();


				PreparedStatement ps3 = con.prepareStatement("UPDATE todaydoctor SET  activity='idle'  WHERE activity='busy' and  recommended='NO' and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps3.executeUpdate();


				PreparedStatement ps6 = con.prepareStatement("SELECT *  FROM todaydoctor WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and SHIFT_SATUS='running' ");
				ResultSet rs6 = ps6.executeQuery();
				while (rs6.next()) {

					maximumrecommendNumber = rs6.getInt(7);
					roundNumber = rs6.getInt(8);





					int roundNumberTEMP = roundNumber + 1;
					PreparedStatement ps5 = con.prepareStatement("UPDATE todaydoctor SET  roundnumber='" + roundNumberTEMP + "'  WHERE  d_date=to_date('" + Date + "','mm/dd/yyyy') and  roundnumber='" + roundNumber + "' and  STATUS='active'  and SHIFT_SATUS='running' ");
					ps5.executeUpdate();

				}


				PreparedStatement ps7 = con.prepareStatement("UPDATE todaydoctor SET  recommended='NO',activity='idle'  WHERE  ROUNDNUMBER>=AVAILABLE_ROUNDNUMBER and d_date=to_date('" + Date + "','mm/dd/yyyy') and  STATUS='active' and  recommended='YES' and SHIFT_SATUS='running' ");
				ps7.executeUpdate();



			} else {
				PreparedStatement ps = con.prepareStatement("SELECT ROUNDNUMBER FROM todaydoctor  WHERE d_date=to_date('" + Date + "','mm/dd/yyyy') AND  OFFICIALID='" + doctorID + "' and SHIFT_SATUS='running'  ");
				ResultSet rs1 = ps.executeQuery();
				while (rs1.next()) {
					individualCurrentRoundNumber = rs1.getInt(1);
					System.out.println("individualCurrentRoundNumber:" + individualCurrentRoundNumber);
				}
				individualCurrentRoundNumber = individualCurrentRoundNumber + 1;
				PreparedStatement ps1 = con.prepareStatement("UPDATE todaydoctor SET activity='busy',AVAILABLE_ROUNDNUMBER='" + individualCurrentRoundNumber + "' WHERE OFFICIALID='" + doctorID + "'  and d_date=to_date('" + Date + "','mm/dd/yyyy') and SHIFT_SATUS='running' ");
				ps1.executeUpdate();

			}





			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			 

			String sql12 = "Select PERSONID,PATIENTID,PATIENTNAME,REFDOCTORID,SHIFT from MCENTER.PATIENT_HISTORY where VISITID='" + serialNo + "'";
			// String sql1="Select * from MCENTER.PRESCRIPTION where VISITID='"+visitID +"'";
			ps16 = con.prepareStatement(sql12);


			ResultSet rs12 = ps16.executeQuery();
			while (rs12.next()) {


				medicalID = rs12.getString(1);
				patientID = rs12.getString(2);
				patientName = rs12.getString(3);
				doctorID = rs12.getString(4);
				shift = rs12.getString(5);
			}

			if (medicalID != null) {

				if (medicalID.equals(patientID)) {
					patientRelationWithIDholder = "Self";

				} else {


					PreparedStatement ps11 = con.prepareStatement("select * from MCENTER.DEPENDENCY where DEPENDENTID='" + patientID + "'  ");
					ResultSet rs11 = ps11.executeQuery();
					while (rs11.next()) {

						patientRelationWithIDholder = rs11.getString(6);

					}


				}
			}

			//System.out.println(medicalID);
			//////////////////////////////////////////////	/

			//  String sql22="select distinct t1.id, t1.name ,t1.departmentname,t1.DESIGNATION from (select STUDENTID id,STUDENTNAME name,DEPARTMENTID departmentname,'' DESIGNATION from BIIS.STUDENT where BIIS.STUDENT.STUDENTID='"+medicalID+"' union select OFFICIAL_ID id, NAME name,(select SHORT_DEPARTMENT_NAME from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID=(select DEPARTMENT_ID from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) departmentname,(select SHORT_DESIGNATION from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID=(select CURRENT_DESIGNATION_ID  from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')) DESIGNATION from ESTABLISHMENT.PERSONNEL where ESTABLISHMENT.PERSONNEL.OFFICIAL_ID='"+medicalID+"')t1";
			String sql22 = "SELECT DISTINCT t1.id, " +
				"                t1.name, " +
				"                t1.departmentname, " +
				"                t1.DESIGNATION " +
				"  FROM (SELECT STUDENTID id, " +
				"               STUDENTNAME name, " +
				"               DEPARTMENTID departmentname, " +
				"               '' DESIGNATION " +
				"          FROM BIIS.STUDENT " +
				"         WHERE BIIS.STUDENT.STUDENTID ='" + medicalID + "' " +
				"         UNION " +
				"         SELECT TEMPID id, " +
				"               NAME name, " +
				"               DEPT departmentname, " +
				"               DESIGNATION DESIGNATION " +
				"          FROM MCENTER.NONIDPATIENT " +
				"         WHERE MCENTER.NONIDPATIENT.TEMPID='" + medicalID + "' " +
				"        UNION " +
				"        SELECT OFFICIAL_ID id, " +
				"               NAME name, " +
				"               (SELECT SHORT_DEPARTMENT_NAME " +
				"                  FROM ESTABLISHMENT.DEPARTMENT " +
				"                 WHERE DEPARTMENT_ID = " +
				"                          (SELECT DEPARTMENT_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  departmentname, " +
				"               (SELECT SHORT_DESIGNATION " +
				"                  FROM ESTABLISHMENT.DESIGNATION " +
				"                 WHERE DESIGNATION_ID = " +
				"                          (SELECT CURRENT_DESIGNATION_ID " +
				"                             FROM ESTABLISHMENT.PERSONNEL " +
				"                            WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID = " +
				"                                     '" + medicalID + "')) " +
				"                  DESIGNATION " +
				"          FROM ESTABLISHMENT.PERSONNEL " +
				"         WHERE ESTABLISHMENT.PERSONNEL.OFFICIAL_ID ='" + medicalID + "') t1 ";
			ps26 = con.prepareStatement(sql22);


			ResultSet rs22 = ps26.executeQuery();
			while (rs22.next()) {

				medicalIDholderName = rs22.getString(2);
				department = rs22.getString(3);
				designation = rs22.getString(4);

			}

			if (designation == null) {
				designation = "Student";

			}


			System.out.println(doctorID);
			String sql3 = "Select * from MCENTER.TODAYDOCTOR where OFFICIALID='" + doctorID + "'";
			ps36 = con.prepareStatement(sql3);


			ResultSet rs3 = ps36.executeQuery();
			while (rs3.next()) {

				doctorName = rs3.getString(3);

			}


			TokenforSerialedpatient1 a = new TokenforSerialedpatient1();
			a.report(doctorName, patientName, shift, patientID, serialNo, DateofSerial1);

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		 


			con.close();
		}}
		catch (Exception e) {



			e.printStackTrace();
		}

		 if(anyActiveDoctor==0){
			 
			 return "error";
		 }
		 
		else{
		return "success";
		 }
	}



}