package com.mcenter.doctorManagement.DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




//import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ActiveDoctorDTO extends ActionSupport {

	private String doctorId;//official ID
	private String doctorName;
	private String deactivedoctordoctorId;
	private String deactivedoctordoctorName;
	

	public String getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	
	
	

	public String getDeactivedoctordoctorId() {
		return deactivedoctordoctorId;
	}



	public void setDeactivedoctordoctorId(String deactivedoctordoctorId) {
		this.deactivedoctordoctorId = deactivedoctordoctorId;
	}
	
	
	public String getDeactivedoctordoctorName() {
		return deactivedoctordoctorName;
	}



	public void setDeactivedoctordoctorName(String deactivedoctordoctorName) {
		this.deactivedoctordoctorName = deactivedoctordoctorName;
	}


   }
	

