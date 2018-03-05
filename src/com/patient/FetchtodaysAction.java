package com.patient;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.table.PatientListDTO;



public class FetchtodaysAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fdate;	
	private String tdate;
	
	private ArrayList<PatientListDTO> patientoo = new ArrayList<PatientListDTO>();
	private ArrayList<PatientListDTO> patientpo = new ArrayList<PatientListDTO>();
	private ArrayList<PatientListDTO> patienthistory = new ArrayList<PatientListDTO>();
	
	public String fetchTodayslist()
	{
		
		PatientDAO  pDAO = new PatientDAO();
		
		patientoo=pDAO.fetchtodaylist();
		
				
		return "success";
	}

	
	public String fetchpatientHIstorylist()
	{
		String patientid=(String)ServletActionContext.getRequest().getParameter("patientid");
		PatientDAO  pDAO = new PatientDAO();
		
		patienthistory=pDAO.fetchPreviousHistorylist(patientid);
		
				
		return "success";
	}
	
	
	
	public String fetchAlllist()
	{
		
		PatientDAO  pDAO = new PatientDAO();
		
		patientpo=pDAO.fetchAlllist(fdate,tdate);
		
				
		return "success";
	}
	
	public String fetchAlllistforAdoctor()
	{
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		
		PatientDAO  pDAO = new PatientDAO();
		
		patientpo=pDAO.fetchAlllistforAdoctor(fdate,tdate,user.getOfficalid());
		
				
		return "success";
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
	
	public ArrayList<PatientListDTO> getPatientoo() {
		return patientoo;
	}
	public void setPatientoo(ArrayList<PatientListDTO> patientoo) {
		this.patientoo = patientoo;
	}
	
	

	public ArrayList<PatientListDTO> getPatientpo() {
		return patientpo;
	}


	public void setPatientpo(ArrayList<PatientListDTO> patientpo) {
		this.patientpo = patientpo;
	}


	public ArrayList<PatientListDTO> getPatienthistory() {
		return patienthistory;
	}


	public void setPatienthistory(ArrayList<PatientListDTO> patienthistory) {
		this.patienthistory = patienthistory;
	}
	

}
