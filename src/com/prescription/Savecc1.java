package com.prescription;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.login.ValidateUser;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.patient.PatientDAO;
import com.table.CcinfoDTO;
import com.table.PatientDetailDTO;
import com.table.PrescripDTO;
import com.table.PrescriptionDTO;

public class Savecc1 extends ActionSupport{

	 static final long serialVersionUID = -1450168026131640345L;
	 
	 
	 	
		private ArrayList<CcinfoDTO> cList = new ArrayList<CcinfoDTO>();
	 	
		
		private Long prescriptionid;	    
		private String patientid;
		private String name;
		private String visitid;
		private String doctorname;
		
	    private String[] ccname;
		private String[] cctype;
	    private String[] comments;
	    
	    private String[] oename;
	    private String[] oetype;
	    private String[] oecomments;
	    
	    private String[] pcomments;
	    private String[] advcomments;
	    
	    private String[] medOutSide;
	    private String[] testOutSide;
	    
	    


		private String[]genname;
	    private String[]drugname;
	    private String[]drgqty;
	    private String[]tknqty;	   
	    private String[]dose;
	    private String[]days;
	    private String[]takingtime;
	 
	    private String[]rxstatus;
	    private String[]uprice;
	   
	    private String[]dname;
	    private String[]dcomments;
	    
	    private String[]testypename;
	    private String[]testname;
	    private String[]tstcomm;
	    private String[]tstprice;
	    private String[]tstvat;
	    
	
		
		private List<PatientDetailDTO> petientList;
		private List<PrescriptionDTO> ccinfo;
		private List<PrescriptionDTO> oeinfo;		
		private List<PrescriptionDTO> medicine;
		private List<PrescriptionDTO> pinfo;
		private List<PrescriptionDTO> advinfo;
		private List<PrescriptionDTO> dinfo;
		private List<PrescriptionDTO> testinfo;
		
		
	    
	    
	  

		public String insert() throws Exception
		{	    	
	    	
			Map<String, Object> session = ActionContext.getContext().getSession();
			UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
	    	
			PrescriptionDAO pDao=new PrescriptionDAO();
	    	prescriptionid=pDao.getMaxPresNo();
	    	
	    		    
	    	
	    	
	    	pDao.insertValue(ccname, cctype, comments, prescriptionid, patientid,oename,oetype,oecomments,pcomments,
	    				  genname,drugname,drgqty,dose,days,takingtime,tknqty,rxstatus,dname,dcomments,
	    				  testypename,testname,tstcomm,advcomments,visitid,uprice,tstprice,tstvat,medOutSide,testOutSide, user.getOfficalid());
	    	
	    	
	    
	    	PrescriptionDAO pDao1=new PrescriptionDAO();
			PatientDAO ptDAO = new PatientDAO();
	    	
	    	
			petientList = ptDAO.ptdisplay(patientid,visitid);
			ccinfo=pDao1.ccdisplay(prescriptionid);
			oeinfo=pDao1.oedisplay(prescriptionid);
			medicine=pDao1.meddisplay(prescriptionid);
			pinfo=pDao1.paedisplay(prescriptionid);
			advinfo=pDao1.advdisplay(prescriptionid);
			dinfo=pDao1.diadisplay(prescriptionid);
			testinfo=pDao1.invdisplay(prescriptionid);   
			
	    	
	    	
	    	 	
	    		    	
	    	return "success";  	
	    	
		}
		
		public String show()
			{
			
			
			PrescriptionDAO pDao=new PrescriptionDAO();
			PatientDAO ptDAO = new PatientDAO();
			PrescripDTO pDTO = new PrescripDTO();
	    	
			petientList = ptDAO.ptdisplay(patientid,visitid);
			ccinfo=pDao.ccdisplay(prescriptionid);
			oeinfo=pDao.oedisplay(prescriptionid);
			medicine=pDao.meddisplay(prescriptionid);
			pinfo=pDao.paedisplay(prescriptionid);
			advinfo=pDao.advdisplay(prescriptionid);
			dinfo=pDao.diadisplay(prescriptionid);
			testinfo=pDao.invdisplay(prescriptionid);   
			
			pDTO=pDao.getPrescription(prescriptionid);
			
			
			return "success"; 
			
			
			}
	    	    
		public String previousShow()
		{
		doctorname=(String)ServletActionContext.getRequest().getParameter("doctorid");
		
		PrescriptionDAO pDao=new PrescriptionDAO();
		PatientDAO ptDAO = new PatientDAO();
		PrescripDTO pDTO = new PrescripDTO();
    	
		petientList = ptDAO.ptdisplay(patientid,visitid);
		ccinfo=pDao.ccdisplay(prescriptionid);
		oeinfo=pDao.oedisplay(prescriptionid);
		medicine=pDao.meddisplay(prescriptionid);
		pinfo=pDao.paedisplay(prescriptionid);
		advinfo=pDao.advdisplay(prescriptionid);
		dinfo=pDao.diadisplay(prescriptionid);
		testinfo=pDao.invdisplay(prescriptionid);   
		
		pDTO=pDao.getPrescription(prescriptionid);
		
		
		return "success"; 
		
		
		}
			public String[] getTakingtime() {
			return takingtime;
			}


			public void setTakingtime(String[] takingtime) {
			this.takingtime = takingtime;
			}

	    
		  	public String[] getDrgqty() {
				return drgqty;
			}



			public void setDrgqty(String[] drgqty) {
				this.drgqty = drgqty;
			}


			public String[] getTknqty() {
				return tknqty;
			}


			public void setTknqty(String[] tknqty) {
				this.tknqty = tknqty;
			}


	    
	    public String[] getPcomments() {
			return pcomments;
		}

		public void setPcomments(String[] pcomments) {
			this.pcomments = pcomments;
		}

	    public ArrayList<CcinfoDTO> getcList() {
			return cList;
		}
		public void setcList(ArrayList<CcinfoDTO> cList) {
			this.cList = cList;
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

		public String[] getCcname() {
			return ccname;
		}
		public void setCcname(String[] ccname) {
			this.ccname = ccname;
		}
		public String[] getCctype() {
			return cctype;
		}
		public void setCctype(String[] cctype) {
			this.cctype = cctype;
		}
		public String[] getComments() {
			return comments;
		}
		public void setComments(String[] comments) {
			this.comments = comments;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


		public void setOename(String[] oename) {
			this.oename = oename;
		}


		public String[] getOename() {
			return oename;
		}

		public String[] getOetype() {
			return oetype;
		}

		public void setOetype(String[] oetype) {
			this.oetype = oetype;
		}

		public void setOecomments(String[] oecomments) {
			this.oecomments = oecomments;
		}


		public String[] getOecomments() {
			return oecomments;
		}


		public void setPetientList(List<PatientDetailDTO> petientList) {
			this.petientList = petientList;
		}


		public List<PatientDetailDTO> getPetientList() {
			return petientList;
		}


		public void setCcinfo(List<PrescriptionDTO> ccinfo) {
			this.ccinfo = ccinfo;
		}


		public List<PrescriptionDTO> getCcinfo() {
			return ccinfo;
		}


		public void setOeinfo(List<PrescriptionDTO> oeinfo) {
			this.oeinfo = oeinfo;
		}


		public List<PrescriptionDTO> getOeinfo() {
			return oeinfo;
		}


		public void setGenname(String[] genname) {
			this.genname = genname;
		}


		public String[] getGenname() {
			return genname;
		}


		public void setDrugname(String[] drugname) {
			this.drugname = drugname;
		}


		public String[] getDrugname() {
			return drugname;
		}



		


		public void setDose(String[] dose) {
			this.dose = dose;
		}


		public String[] getDose() {
			return dose;
		}


		public void setDays(String[] days) {
			this.days = days;
		}


		public String[] getDays() {
			return days;
		}


		

		public void setMedicine(List<PrescriptionDTO> medicine) {
			this.medicine = medicine;
		}


		public List<PrescriptionDTO> getMedicine() {
			return medicine;
		}



		public void setRxstatus(String[] rxstatus) {
			this.rxstatus = rxstatus;
		}






		public String[] getRxstatus() {
			return rxstatus;
		}



		public void setPinfo(List<PrescriptionDTO> pinfo) {
			this.pinfo = pinfo;
		}



		public List<PrescriptionDTO> getPinfo() {
			return pinfo;
		}




		public void setDname(String[] dname) {
			this.dname = dname;
		}


		public String[] getDname() {
			return dname;
		}


		public void setDcomments(String[] dcomments) {
			this.dcomments = dcomments;
		}


		public String[] getDcomments() {
			return dcomments;
		}




		public void setDinfo(List<PrescriptionDTO> dinfo) {
			this.dinfo = dinfo;
		}



		public List<PrescriptionDTO> getDinfo() {
			return dinfo;
		}




		public void setTestypename(String[] testypename) {
			this.testypename = testypename;
		}




		public String[] getTestypename() {
			return testypename;
		}




		public void setTestname(String[] testname) {
			this.testname = testname;
		}




		public String[] getTestname() {
			return testname;
		}




		public void setTstcomm(String[] tstcomm) {
			this.tstcomm = tstcomm;
		}




		public String[] getTstcomm() {
			return tstcomm;
		}




		public void setTestinfo(List<PrescriptionDTO> testinfo) {
			this.testinfo = testinfo;
		}




		public List<PrescriptionDTO> getTestinfo() {
			return testinfo;
		}
	   
		public String getVisitid() {
			return visitid;
		}




		public void setVisitid(String visitid) {
			this.visitid = visitid;
		}




		public void setAdvinfo(List<PrescriptionDTO> advinfo) {
			this.advinfo = advinfo;
		}




		public List<PrescriptionDTO> getAdvinfo() {
			return advinfo;
		}


		
		public String[] getAdvcomments() {
			return advcomments;
		}




		public void setAdvcomments(String[] advcomments) {
			this.advcomments = advcomments;
		}




		public void setUprice(String[] uprice) {
			this.uprice = uprice;
		}




		public String[] getUprice() {
			return uprice;
		}




		public void setTstprice(String[] tstprice) {
			this.tstprice = tstprice;
		}




		public String[] getTstprice() {
			return tstprice;
		}




		public void setTstvat(String[] tstvat) {
			this.tstvat = tstvat;
		}




		public String[] getTstvat() {
			return tstvat;
		}
		
		

		public String[] getMedOutSide() {
			return medOutSide;
		}

		public void setMedOutSide(String[] medOutSide) {
			this.medOutSide = medOutSide;
		}

		public String[] getTestOutSide() {
			return testOutSide;
		}

		public void setTestOutSide(String[] testOutSide) {
			this.testOutSide = testOutSide;
		}

		public String getDoctorname() {
			return doctorname;
		}

		public void setDoctorname(String doctorname) {
			this.doctorname = doctorname;
		}



}
