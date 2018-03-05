package com.table;

import java.util.ArrayList;

public class PrescripDTO {
	
	 private Long   prescriptionid;	
	 private String medicalid;
	 private ArrayList<String> cc;
	 private ArrayList<String> diagonasis;
	 private ArrayList<String> oe;
	 private ArrayList<String> investigation;
	 private ArrayList<String> pae;
	 private ArrayList<String> rx;
	 private ArrayList<String> rxd;
	 private ArrayList<String> rxdout;
	 private ArrayList<String> advice;
	 private String weight;
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
	public ArrayList<String> getCc() {
		return cc;
	}
	public void setCc(ArrayList<String> cc) {
		this.cc = cc;
	}
	public ArrayList<String> getDiagonasis() {
		return diagonasis;
	}
	public void setDiagonasis(ArrayList<String> diagonasis) {
		this.diagonasis = diagonasis;
	}
	public ArrayList<String> getOe() {
		return oe;
	}
	public void setOe(ArrayList<String> oe) {
		this.oe = oe;
	}
	public ArrayList<String> getInvestigation() {
		return investigation;
	}
	public void setInvestigation(ArrayList<String> investigation) {
		this.investigation = investigation;
	}
	public ArrayList<String> getPae() {
		return pae;
	}
	public void setPae(ArrayList<String> pae) {
		this.pae = pae;
	}
	public ArrayList<String> getRx() {
		return rx;
	}
	public void setRx(ArrayList<String> rx) {
		this.rx = rx;
	}
	public ArrayList<String> getRxd() {
		return rxd;
	}
	public void setRxd(ArrayList<String> rxd) {
		this.rxd = rxd;
	}
	public ArrayList<String> getAdvice() {
		return advice;
	}
	public void setAdvice(ArrayList<String> advice) {
		this.advice = advice;
	}
	public ArrayList<String> getRxdout() {
		return rxdout;
	}
	public void setRxdout(ArrayList<String> rxdout) {
		this.rxdout = rxdout;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	 
	 
	 
	 
}
