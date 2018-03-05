package com.table;

public class PrescriptionDTO {
	
	
	
	 private Long   prescriptionid;	
	 private String medicalid;
	
	 private String ccid;
	 private String ccname;
	 private String cctype;
	 private String cctypeid;
	 private String comments;
	
	
	 private String oeid;
	 private String oename;
	 private String oetype;
	 private String oetypeid;
	 private String oecomments;
	 
	 private String pcomments;
	 private String advcomments;
	 
	 private String genid;	 
	 private String genname;
	 private String gencatagory;
	 
	 private String drugid;
	 private String drugname;
	 private String drgqty;
	 private String tknqty;
	// private String times;
	 private String stock;
	 private String dose;
	 private String unit;
	 private String days;
	 private String takingtime;
     private String rxstatus;
     private String uprice;
	 
     private String testypeid;
     private String testypename;
     private String testid;
     private String testname;
     private String tstcomments;
     //private String subtestid;
     //private String subtestname;     
     
     private String did;
     private String dname;
     private String dcomments;
	
    
	
	
	public String getGencatagory() {
		return gencatagory;
	}
	public void setGencatagory(String gencatagory) {
		this.gencatagory = gencatagory;
	}
	public String getOetype() {
		return oetype;
	}
	public void setOetype(String oetype) {
		this.oetype = oetype;
	}
	public String getOetypeid() {
		return oetypeid;
	}
	public void setOetypeid(String oetypeid) {
		this.oetypeid = oetypeid;
	}
	public Long getPrescriptionid() {
		return prescriptionid;
	}
	public void setPrescriptionid(Long prescriptionid) {
		this.prescriptionid = prescriptionid;
	}
	public String getMedicalid() {
		return medicalid;
	}
	public void setMedicalid(String medicalid) {
		this.medicalid = medicalid;
	}
	public String getCcid() {
		return ccid;
	}
	public void setCcid(String ccid) {
		this.ccid = ccid;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}
	public String getCctypeid() {
		return cctypeid;
	}
	public void setCctypeid(String cctypeid) {
		this.cctypeid = cctypeid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setOeid(String oeid) {
		this.oeid = oeid;
	}
	public String getOeid() {
		return oeid;
	}
	public void setOename(String oename) {
		this.oename = oename;
	}
	public String getOename() {
		return oename;
	}
	public void setOecomments(String oecomments) {
		this.oecomments = oecomments;
	}
	public String getOecomments() {
		return oecomments;
	}
	public void setPcomments(String pcomments) {
		this.pcomments = pcomments;
	}
	public String getPcomments() {
		return pcomments;
	}
	public void setGenid(String genid) {
		this.genid = genid;
	}
	public String getGenid() {
		return genid;
	}
	public void setGenname(String genname) {
		this.genname = genname;
	}
	public String getGenname() {
		return genname;
	}
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	public String getDrugname() {
		return drugname;
	}	
	
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getDose() {
		return dose;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getDays() {
		return days;
	}	
	public void setDrgqty(String drgqty) {
		this.drgqty = drgqty;
	}
	public String getDrgqty() {
		return drgqty;
	}
	public void setTknqty(String tknqty) {
		this.tknqty = tknqty;
	}
	public String getTknqty() {
		return tknqty;
	}
	public void setTakingtime(String takingtime) {
		this.takingtime = takingtime;
	}
	public String getTakingtime() {
		return takingtime;
	}
	public void setRxstatus(String rxstatus) {
		this.rxstatus = rxstatus;
	}
	public String getRxstatus() {
		return rxstatus;
	}
	public void setTestypeid(String testypeid) {
		this.testypeid = testypeid;
	}
	public String getTestypeid() {
		return testypeid;
	}
	public void setTestypename(String testypename) {
		this.testypename = testypename;
	}
	public String getTestypename() {
		return testypename;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDid() {
		return did;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
	public void setDcomments(String dcomments) {
		this.dcomments = dcomments;
	}
	public String getDcomments() {
		return dcomments;
	}
	public void setDrugid(String drugid) {
		this.drugid = drugid;
	}
	public String getDrugid() {
		return drugid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public String getTestid() {
		return testid;
	}
	public void setTestname(String testname) {
		this.testname = testname;
	}
	public String getTestname() {
		return testname;
	}
	/*public void setSubtestid(String subtestid) {
		this.subtestid = subtestid;
	}
	public String getSubtestid() {
		return subtestid;
	}
	public void setSubtestname(String subtestname) {
		this.subtestname = subtestname;
	}
	public String getSubtestname() {
		return subtestname;
	}*/
	public void setTstcomments(String tstcomments) {
		this.tstcomments = tstcomments;
	}
	public String getTstcomments() {
		return tstcomments;
	}
	public void setAdvcomments(String advcomments) {
		this.advcomments = advcomments;
	}
	public String getAdvcomments() {
		return advcomments;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getStock() {
		return stock;
	}
	public void setUprice(String uprice) {
		this.uprice = uprice;
	}
	public String getUprice() {
		return uprice;
	}
	

}
