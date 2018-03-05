package com.mcenter.patientManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.mcenter.patientManagement.DTO.DoctorPatientChartDTO;

import com.opensymphony.xwork2.ActionSupport;

public class DoctorPatientChartDAO extends ActionSupport {

	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	//get current date time with Date()
	Date date = new Date();
	String Date = dateFormat.format(date);

	private String shift;
	private String fdate;
	private String tdate;



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


	ArrayList < DoctorPatientChartDTO > dailydoctorlist = new ArrayList < DoctorPatientChartDTO > ();

	public ArrayList < DoctorPatientChartDTO > getDailydoctorlist() {
		return dailydoctorlist;
	}

	public void setDailydoctorlist(ArrayList < DoctorPatientChartDTO > dailydoctorlist) {
		this.dailydoctorlist = dailydoctorlist;
	}


	PreparedStatement ps = null;



	/*		String sql1="SELECT REFDOCTORNAME as todayDoctor ,COUNT(REFDOCTORNAME) as PatientNumber FROM  MCENTER.PATIENT_HISTORY  WHERE VISITINGDATE=to_date('"+Date+"','mm/dd/yyyy') GROUP BY REFDOCTORNAME ";*/

	public String dailydoctorVSpatientchart() throws Exception

	{
		//System.out.println("Adnan");
		Connection con = ConnectionManager.getConnection();
		// Connection con = null;

		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			fdate = request.getParameter("fdate");
			tdate = request.getParameter("tdate");

			/*String URL = "jdbc:mysql://localhost/mcenter";
	        Class.forName("com.mysql.jdbc.Driver");
	         con = DriverManager.getConnection(URL, "root", "");*/

			/*  Class.forName("oracle.jdbc.driver.OracleDriver");
		     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");	*/

			con.setAutoCommit(false);
			String sql1 = "SELECT REFDOCTORNAME as todayDoctor ,COUNT(REFDOCTORNAME) as PatientNumber FROM  MCENTER.PATIENT_HISTORY  WHERE   VISITINGDATE between to_date('" + fdate + "','dd/mm/yyyy') and to_date('" + tdate + "','dd/mm/yyyy') GROUP BY REFDOCTORNAME ";
			ps = con.prepareStatement(sql1);


			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DoctorPatientChartDTO dp = new DoctorPatientChartDTO();



				dp.setDoctor(rs.getString("todayDoctor"));

				dp.setPatientNumber(rs.getInt("PatientNumber"));

				dailydoctorlist.add(dp);


			}


			con.commit();


		} catch (Exception e) {
			e.printStackTrace();


			if (con != null) {
				try {
					System.err.println("There is sql exception Mr.Adnan");
					System.out.println(" So...Transaction is being rolled back in DoctorPatientChartDAO ");
					con.rollback();
				} catch (SQLException excep) {

					excep.printStackTrace();
				}
			}


		} finally {
			if (ps != null) {
				ps.close();
			}
		}
		con.setAutoCommit(true);
		con.close();

		return "success";

	}


}