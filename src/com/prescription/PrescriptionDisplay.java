package com.prescription;

import java.util.ArrayList;
import java.util.List;

import com.patient.PatientDAO;
import com.table.PatientDetailDTO;

public class PrescriptionDisplay {
	
	
	
	private String patientid;
	private String visitid;
	
	
	private List<PatientDetailDTO> petientList;
	
	
	public String prescription()

	    {
		 PatientDAO pDAO = new PatientDAO();
		 petientList = pDAO.ptdisplay(patientid, visitid);

	        return "success";
	    }
	
	public String display()

    {
	 
        return "success";
    }


	 
	 
	 
	public String getVisitid() {
			return visitid;
		}




		public void setVisitid(String visitid) {
			this.visitid = visitid;
		}




	public void setPetientList(List<PatientDetailDTO> petientList) {
		this.petientList = petientList;
	}

	public List<PatientDetailDTO> getPetientList() {
		return petientList;
	}


	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}


	public String getPatientid() {
		return patientid;
	}
	 
	 
	 
	 
	 
	 
	 
	 

	
}