package com.patient;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import com.lowagie.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import com.table.PatientDetailDTO;
import com.table.PatientListDTO;

import com.opensymphony.xwork2.ActionSupport;

public class PatientDetail extends ActionSupport implements ServletContextAware{
	

private static final long serialVersionUID = 1L;
private String name;
private String patientid;
private String visitid;
private Long prescriptionid;
private String doctorid;


private ServletContext servlet;	
	
private ArrayList<PatientDetailDTO> patientdtl = new ArrayList<PatientDetailDTO>();

	


	public String detail() throws  Exception
		{
		/*PatientDetailDTO pDAO=new PatientDetailDTO();*/
		
		//prescriptionid=Long.parseLong((String)ServletActionContext.getRequest().getParameter("prescriptionid"));
		PatientDAO  pDAO = new PatientDAO();
		
		patientdtl=pDAO.ptdetail(patientid,visitid);
		//patientdtl=pDAO.ptdetail(patientid,visitid,prescriptionid);
		
		
		/*String filename = "/resources/image/"+ patientid+ ".jpg";
		File f = new File(ServletActionContext.getServletContext().getRealPath("")+filename);
		
		if(f.exists())
		{}		
		else
		{		
			String ImagePath = servlet.getRealPath("/resources/image/");
			RandomAccessFile raf = new RandomAccessFile(ImagePath+"/"+ patientid +".jpg", "rw");		
			byte [] image = pDAO.getImage(patientid);
			int length = (int) image.length;
			raf.write(image,0,length);
		}*/
		
		
		return "success";
		}
	
	public String previousPAtientdetail() throws  Exception
	{
	/*PatientDetailDTO pDAO=new PatientDetailDTO();*/
	
	prescriptionid=Long.parseLong((String)ServletActionContext.getRequest().getParameter("prescriptionid"));
	doctorid=(String)ServletActionContext.getRequest().getParameter("doctorid");
	PatientDAO  pDAO = new PatientDAO();		
	patientdtl=pDAO.ptdetail(patientid,visitid,prescriptionid,doctorid);
	
	
	
	/*String filename = "/resources/image/"+ patientid+ ".jpg";
	File f = new File(ServletActionContext.getServletContext().getRealPath("")+filename);
	
	if(f.exists())
	{}		
	else
	{		
		String ImagePath = servlet.getRealPath("/resources/image/");
		RandomAccessFile raf = new RandomAccessFile(ImagePath+"/"+ patientid +".jpg", "rw");		
		byte [] image = pDAO.getImage(patientid);
		int length = (int) image.length;
		raf.write(image,0,length);
	}*/
	
	
	return "success";
	}

	public ServletContext getServlet() {
		return servlet;
	}



	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}



	public String getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public Long getPrescriptionid() {
		return prescriptionid;
	}



	public void setPrescriptionid(Long prescriptionid) {
		this.prescriptionid = prescriptionid;
	}



	public String getPatientid() {
		return patientid;
	}




	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public ArrayList<PatientDetailDTO> getPatientdtl() {
		return patientdtl;
	}


	public void setPatientdtl(ArrayList<PatientDetailDTO> patientdtl) {
		this.patientdtl = patientdtl;
	}




	public void setVisitid(String visitid) {
		this.visitid = visitid;
	}




	public String getVisitid() {
		return visitid;
	}



	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}



}
