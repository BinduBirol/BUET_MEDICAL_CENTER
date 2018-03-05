package com.mcenter.patientManagement;

import com.mcenter.report.TokenforSerialedpatient1;
import com.opensymphony.xwork2.ActionSupport;

public class tanmayPrint extends ActionSupport {
	printBean pBean = new printBean();

	public printBean getpBean() {
		return pBean;
	}

	public void setpBean(printBean pBean) {
		this.pBean = pBean;
	}


	public String execute() {
		TokenforSerialedpatient1 a = new TokenforSerialedpatient1();
		try {
			a.report(pBean.getDdoctor(), pBean.getDpatient(), pBean.getDshift(), pBean.getDpatientID(), pBean.getDserialNo(), pBean.getDvisitingdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}




}