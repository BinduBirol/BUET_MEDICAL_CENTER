package com.mcenter.moneyReceiptofMedicalCheckUp;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class MoneyReceiptforNewstudentMedicalCheckupAction extends ActionSupport{
	
	private String receiptNO;
	private String aboID;
	private String rhdID;
	private String hbsagID;
	NewstudentMedicalCheckupDTO dto;

	private static final long serialVersionUID = 6723161103674655394L;
	
	private List<MoneyReceiptforNewstudentMedicalCheckup> sdList=new ArrayList<MoneyReceiptforNewstudentMedicalCheckup>();
	
	
	public String receiptList()
	{
		
		MoneyReceiptforNewstudentMedicalCheckupDAO sDAO= new MoneyReceiptforNewstudentMedicalCheckupDAO();
		sdList=sDAO.getreceiptList();
		
		return "success";		
	}
	
	public String assignedtestList()
	{
		
		MoneyReceiptforNewstudentMedicalCheckupDAO sDAO= new MoneyReceiptforNewstudentMedicalCheckupDAO();
		sdList=sDAO.getassignedtestList();
		
		return "success";		
	}
	
	public String physicalexaminationList()
	{
		
		MoneyReceiptforNewstudentMedicalCheckupDAO sDAO= new MoneyReceiptforNewstudentMedicalCheckupDAO();
		sdList=sDAO.getphysicalexaminationList();
		
		return "success";		
	}
	
	
	public String testReportShowNewAdmission()
	{
		
		MoneyReceiptforNewstudentMedicalCheckupDAO sDAO= new MoneyReceiptforNewstudentMedicalCheckupDAO();
		dto=sDAO.gettestReportShowNewAdmission(receiptNO);
		
		aboID=dto.getTestResult_bloodGroup_ABO();
		rhdID=dto.getTestResult_bloodGroup_Rh_D();
		hbsagID=dto.getTestResult_HBsAg_Screening();
		receiptNO=dto.getReceiptNO();
		
		
		return "success";		
	}




	public List<MoneyReceiptforNewstudentMedicalCheckup> getSdList() {
		return sdList;
	}


	public void setSdList(List<MoneyReceiptforNewstudentMedicalCheckup> sdList) {
		this.sdList = sdList;
	}

	public String getReceiptNO() {
		return receiptNO;
	}

	public void setReceiptNO(String receiptNO) {
		this.receiptNO = receiptNO;
	}

	public String getAboID() {
		return aboID;
	}

	public void setAboID(String aboID) {
		this.aboID = aboID;
	}

	public String getRhdID() {
		return rhdID;
	}

	public void setRhdID(String rhdID) {
		this.rhdID = rhdID;
	}

	public String getHbsagID() {
		return hbsagID;
	}

	public void setHbsagID(String hbsagID) {
		this.hbsagID = hbsagID;
	}






	
		
	
}
