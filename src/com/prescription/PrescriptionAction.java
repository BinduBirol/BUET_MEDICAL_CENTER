package com.prescription;

import java.util.ArrayList;
import java.util.List;

import com.patient.PatientDAO;
import com.table.PatientDetailDTO;
import com.table.PrescriptionDTO;


public class PrescriptionAction {

    private Long prescriptionid;
    private String patientid;
    private String name;
    private String visitid; 
    private String visidate; 

    private String advid;
    private String advicename;


    private List<PrescriptionDTO> strList;
    private List<PrescriptionDTO> oeList;
    private List<PrescriptionDTO> testypelist;
    private List<PrescriptionDTO> genericlist;
    
    private List<PrescriptionDTO> genericlistTablet;
    private List<PrescriptionDTO> genericlistCapsul;
    private List<PrescriptionDTO> genericlistSyrap;
    
    private List<PrescriptionDTO> genericlistRespiratrySystemdrugs;
    private List<PrescriptionDTO> genericlistOthers;
    
    
    private List<PrescriptionDTO> dlist;
    private List<PrescriptionAction> advlist;
   

    public String prescription()

    {

        PrescriptionDAO pDao = new PrescriptionDAO();
        PatientDAO  ptDAO = new PatientDAO();
        
        
        strList=pDao.showCCNames();
        oeList=pDao.showOENames();
   //     genericlist=pDao.showMedGenNames();
        genericlistTablet=pDao.showMedGenNamesTablet(); //Antibiotics
        genericlistCapsul=pDao.showMedGenNamesCapsul(); //Alimentary_System_drug
        genericlistSyrap=pDao.showMedGenNamesSyrap(); //Analgesics_nsaids
        
        genericlistRespiratrySystemdrugs=pDao.showMedGenNamesRespiratrySystemdrugs();
        
        genericlistOthers=pDao.showMedGenNamesOthers();
        
        dlist=pDao.showdNames();
        testypelist=pDao.showTestypeNames();
        //advlist=pDao.showAdvices();
        
        return "success";
    }
    
    public String prescription1()

    {

        PrescriptionDAO pDao = new PrescriptionDAO();
        PatientDAO  ptDAO = new PatientDAO();
        
        testypelist=pDao.showTestypeNames();
     
        
        return "success";
    }


	public void setPrescriptionid(Long prescriptionid) {
		this.prescriptionid = prescriptionid;
	}


	public Long getPrescriptionid() {
		return prescriptionid;
	}


	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}


	public String getPatientid() {
		return patientid;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAdvid(String advid) {
		this.advid = advid;
	}


	public String getAdvid() {
		return advid;
	}


	public void setAdvicename(String advicename) {
		this.advicename = advicename;
	}


	public String getAdvicename() {
		return advicename;
	}


	public void setStrList(List<PrescriptionDTO> strList) {
		this.strList = strList;
	}


	public List<PrescriptionDTO> getStrList() {
		return strList;
	}


	public void setOeList(List<PrescriptionDTO> oeList) {
		this.oeList = oeList;
	}


	public List<PrescriptionDTO> getOeList() {
		return oeList;
	}


	public void setTestypelist(List<PrescriptionDTO> testypelist) {
		this.testypelist = testypelist;
	}


	public List<PrescriptionDTO> getTestypelist() {
		return testypelist;
	}


	public void setGenericlist(List<PrescriptionDTO> genericlist) {
		this.genericlist = genericlist;
	}


	public List<PrescriptionDTO> getGenericlist() {
		return genericlist;
	}


	public void setDlist(List<PrescriptionDTO> dlist) {
		this.dlist = dlist;
	}


	public List<PrescriptionDTO> getDlist() {
		return dlist;
	}


	public void setAdvlist(List<PrescriptionAction> advlist) {
		this.advlist = advlist;
	}


	public List<PrescriptionAction> getAdvlist() {
		return advlist;
	}


	public void setVisitid(String visitid) {
		this.visitid = visitid;
	}


	public String getVisitid() {
		return visitid;
	}


	public void setVisidate(String visidate) {
		this.visidate = visidate;
	}


	public String getVisidate() {
		return visidate;
	}

	public List<PrescriptionDTO> getGenericlistTablet() {
		return genericlistTablet;
	}

	public void setGenericlistTablet(List<PrescriptionDTO> genericlistTablet) {
		this.genericlistTablet = genericlistTablet;
	}

	public List<PrescriptionDTO> getGenericlistCapsul() {
		return genericlistCapsul;
	}

	public void setGenericlistCapsul(List<PrescriptionDTO> genericlistCapsul) {
		this.genericlistCapsul = genericlistCapsul;
	}

	public List<PrescriptionDTO> getGenericlistSyrap() {
		return genericlistSyrap;
	}

	public void setGenericlistSyrap(List<PrescriptionDTO> genericlistSyrap) {
		this.genericlistSyrap = genericlistSyrap;
	}

	public List<PrescriptionDTO> getGenericlistRespiratrySystemdrugs() {
		return genericlistRespiratrySystemdrugs;
	}

	public void setGenericlistRespiratrySystemdrugs(
			List<PrescriptionDTO> genericlistRespiratrySystemdrugs) {
		this.genericlistRespiratrySystemdrugs = genericlistRespiratrySystemdrugs;
	}

	public List<PrescriptionDTO> getGenericlistOthers() {
		return genericlistOthers;
	}

	public void setGenericlistOthers(List<PrescriptionDTO> genericlistOthers) {
		this.genericlistOthers = genericlistOthers;
	}

	


    


}
