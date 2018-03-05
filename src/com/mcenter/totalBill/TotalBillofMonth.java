package com.mcenter.totalBill;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.opensymphony.xwork2.ActionSupport;





public class TotalBillofMonth extends ActionSupport {
	
	
	private String fdate;
	private String tdate;
	
	private String medicalID;
	private String name;
	private String designation;
	private String department;
	private String totalMedicinebill;
	private String totalTestbill;
	private String totalbill;
	
	private double individualCOST;
	private double temp;
	private double total=0;
	
	private double individualmedCOST;
	private double tempmed;
	private double totalmed=0;
	
	private double individualtestCOST;
	private double temptest;
	private double totaltest=0;
	/////////////////////////////////////
	
	

	
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	PreparedStatement ps7 = null;


	
	
	ArrayList<TotalBillofMonth> totalbillList=new ArrayList<TotalBillofMonth>();
	ArrayList<TotalBillofMonth> totalbillListreport=new ArrayList<TotalBillofMonth>();


	public ArrayList<TotalBillofMonth> getTotalbillListreport() {
		return totalbillListreport;
	}
	public void setTotalbillListreport(
			ArrayList<TotalBillofMonth> totalbillListreport) {
		this.totalbillListreport = totalbillListreport;
	}
	public ArrayList<TotalBillofMonth> getTotalbillList() {
		return totalbillList;
	}
	public void setTotalbillList(ArrayList<TotalBillofMonth> totalbillList) {
		this.totalbillList = totalbillList;
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
	public String getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTotalMedicinebill() {
		return totalMedicinebill;
	}
	public void setTotalMedicinebill(String totalMedicinebill) {
		this.totalMedicinebill = totalMedicinebill;
	}
	public String getTotalTestbill() {
		return totalTestbill;
	}
	public void setTotalTestbill(String totalTestbill) {
		this.totalTestbill = totalTestbill;
	}
	public String getTotalbill() {
		return totalbill;
	}
	public void setTotalbill(String totalbill) {
		this.totalbill = totalbill;
	}
	public double getIndividualCOST() {
		return individualCOST;
	}
	public void setIndividualCOST(double individualCOST) {
		this.individualCOST = individualCOST;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getIndividualmedCOST() {
		return individualmedCOST;
	}
	public void setIndividualmedCOST(double individualmedCOST) {
		this.individualmedCOST = individualmedCOST;
	}
	public double getTempmed() {
		return tempmed;
	}
	public void setTempmed(double tempmed) {
		this.tempmed = tempmed;
	}
	public double getTotalmed() {
		return totalmed;
	}
	public void setTotalmed(double totalmed) {
		this.totalmed = totalmed;
	}
	public double getIndividualtestCOST() {
		return individualtestCOST;
	}
	public void setIndividualtestCOST(double individualtestCOST) {
		this.individualtestCOST = individualtestCOST;
	}
	public double getTemptest() {
		return temptest;
	}
	public void setTemptest(double temptest) {
		this.temptest = temptest;
	}
	public double getTotaltest() {
		return totaltest;
	}
	public void setTotaltest(double totaltest) {
		this.totaltest = totaltest;
	}
	public String totalBill(){
		HttpServletRequest request = ServletActionContext.getRequest();
		fdate=request.getParameter("fdate");
		tdate=request.getParameter("tdate");
		
		Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		//PreparedStatement stmt = null;
		//ResultSet r = null;
		try{

			
			System.out.println("From Date:"+fdate);
			System.out.println("TO date:"+tdate);
/*			
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			
		   
		     
String sql1= "select MEDICALID,NAME, SHORT_DESIGNATION, SHORT_DEPARTMENT_NAME, sum(medbill) medbill , sum(tstbill) tstbill, sum(medbill) + sum(tstbill) TotalBill " +
"from " +
"(select ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME,0 as medbill, round(sum(ts.BILLINGAMOUNT)) tstbill " +
"from PATIENTTESTBILL ts, establishment.DESIGNATION deg,establishment.PERSONNEL pp, establishment.DEPARTMENT de " +
"where ts.MEDICALID=pp.OFFICIAL_ID " +
"and pp.CURRENT_DESIGNATION_ID=deg.DESIGNATION_ID " +
"and pp.DEPARTMENT_ID=de.DEPARTMENT_ID " +
"and ts.BILLINGDATE between to_date('"+fdate+"','dd/mm/yyyy') and  to_date('"+tdate+"','dd/mm/yyyy')  " +
"group by ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME " +
"union all " +
"select ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME,round(sum(ts.BILLAMOUNT)) medbill, 0 as tstbill " +
"from PATIENTMEDBILL ts, establishment.DESIGNATION deg,establishment.PERSONNEL pp, establishment.DEPARTMENT de " +
"where ts.MEDICALID=pp.OFFICIAL_ID " +
"and pp.CURRENT_DESIGNATION_ID=deg.DESIGNATION_ID " +
"and pp.DEPARTMENT_ID=de.DEPARTMENT_ID " +
"and ts.BILLDATE between to_date('"+fdate+"','dd/mm/yyyy') and  to_date('"+tdate+"','dd/mm/yyyy')  " +
"group by ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME) " +
"group by SHORT_DEPARTMENT_NAME,MEDICALID,NAME, SHORT_DESIGNATION order by SHORT_DEPARTMENT_NAME,SHORT_DESIGNATION ";

			
		     
		 	ps1=con.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				
				TotalBillofMonth pt = new TotalBillofMonth();
                pt.setMedicalID(rs.getString(1));
                pt.setName(rs.getString(2));
                pt.setDesignation(rs.getString(3));
                pt.setDepartment(rs.getString(4));
                pt.setTotalMedicinebill(rs.getString(5));
                pt.setTotalTestbill(rs.getString(6));
				pt.setTotalbill(rs.getString(7));
				
				individualmedCOST=rs.getDouble(5);
				tempmed=individualmedCOST;
				totalmed =totalmed+tempmed;
				
				
				individualtestCOST=rs.getDouble(6);
				temptest=individualtestCOST;
				totaltest =totaltest +temptest;
				
				individualCOST=rs.getDouble(7);
				temp=individualCOST;
				total =total+temp;
				 
				 
				 
			
				totalbillList.add(pt);	
				
		 
			}
			
			
			 System.out.println("TOtal med:"+totalmed);
			 System.out.println("TOtal test:"+totaltest);
			 System.out.println("Grand:"+total);
			
		     
		 
	                
	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}
	
	public String report(String fdate,String tdate ){
		/*HttpServletRequest request = ServletActionContext.getRequest();
		fdate=request.getParameter("fdate");
		tdate=request.getParameter("tdate");*/
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		//PreparedStatement stmt = null;
		//ResultSet r = null;
		try{

			
			System.out.println("From Date:"+fdate);
			System.out.println("TO date:"+tdate);
			
/*			 Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			
		   
		     
String sql1= "select MEDICALID,NAME, SHORT_DESIGNATION, SHORT_DEPARTMENT_NAME, sum(medbill) medbill , sum(tstbill) tstbill, sum(medbill) + sum(tstbill) TotalBill " +
"from " +
"(select ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME,0 as medbill, round(sum(ts.BILLINGAMOUNT)) tstbill " +
"from PATIENTTESTBILL ts, establishment.DESIGNATION deg,establishment.PERSONNEL pp, establishment.DEPARTMENT de " +
"where ts.MEDICALID=pp.OFFICIAL_ID " +
"and pp.CURRENT_DESIGNATION_ID=deg.DESIGNATION_ID " +
"and pp.DEPARTMENT_ID=de.DEPARTMENT_ID " +
"and ts.BILLINGDATE between to_date('"+fdate+"','dd/mm/yyyy') and  to_date('"+tdate+"','dd/mm/yyyy')  " +
"group by ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME " +
"union all " +
"select ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME,round(sum(ts.BILLAMOUNT)) medbill, 0 as tstbill " +
"from PATIENTMEDBILL ts, establishment.DESIGNATION deg,establishment.PERSONNEL pp, establishment.DEPARTMENT de " +
"where ts.MEDICALID=pp.OFFICIAL_ID " +
"and pp.CURRENT_DESIGNATION_ID=deg.DESIGNATION_ID " +
"and pp.DEPARTMENT_ID=de.DEPARTMENT_ID " +
"and ts.BILLDATE between to_date('"+fdate+"','dd/mm/yyyy') and  to_date('"+tdate+"','dd/mm/yyyy')  " +
"group by ts.MEDICALID,pp.NAME, deg.SHORT_DESIGNATION, de.SHORT_DEPARTMENT_NAME) " +
"group by MEDICALID,NAME, SHORT_DESIGNATION, SHORT_DEPARTMENT_NAME ";

			
		     
		 	ps1=con.prepareStatement(sql1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()){
				
				TotalBillofMonth pt = new TotalBillofMonth();
                pt.setMedicalID(rs.getString(1));
                pt.setName(rs.getString(2));
                pt.setDesignation(rs.getString(3));
                pt.setDepartment(rs.getString(4));
                pt.setTotalMedicinebill(rs.getString(5));
                pt.setTotalTestbill(rs.getString(6));
				pt.setTotalbill(rs.getString(7));
				
				individualmedCOST=rs.getDouble(5);
				tempmed=individualmedCOST;
				totalmed =totalmed+tempmed;
				
				
				individualtestCOST=rs.getDouble(6);
				temptest=individualtestCOST;
				totaltest =totaltest +temptest;
				
				individualCOST=rs.getDouble(7);
				temp=individualCOST;
				total =total+temp;
				 
				 
				 
			
				totalbillListreport.add(pt);	
				
		 
			}
			
			
			 System.out.println("TOtal med:"+totalmed);
			 System.out.println("TOtal test:"+totaltest);
			 System.out.println("Grand:"+total);
			
		     
		 
	                
	         con.close();
		}
		catch(Exception e){e.printStackTrace();}
		
			
		return "success";
		
		}
	
	




















}
