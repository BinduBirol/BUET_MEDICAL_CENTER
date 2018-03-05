package com.mcenter.patientManagement.DTO;



public class DailyDoctorVSpatientFinalListShowDTO  {
	
	 String  serialNo;
	 String  doctor;
	 String  patient;
	 String visitingdate;
	 int patientnumber;
	 String patientID;
	 String shift;





	/*testtanmay*/
	 public String getPatientID() {
		return patientID;
	}
	 public String getShift() {
			return shift;
		}


		public void setShift(String shift) {
			this.shift = shift;
		}


	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	/*testtanmay*/
	public int getPatientnumber() {
		return patientnumber;
	}


	public void setPatientnumber(int patientnumber) {
		this.patientnumber = patientnumber;
	}


	public String getVisitingdate() {
	 	return visitingdate;
	 }


	 public void setVisitingdate(String visitingdate) {
	 	this.visitingdate = visitingdate;
	 }
	

public String getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}


	public String getDoctor() {
		return doctor;
	}


	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}


	public String getPatient() {
		return patient;
	}


	public void setPatient(String patient) {
		this.patient = patient;
	}



}

