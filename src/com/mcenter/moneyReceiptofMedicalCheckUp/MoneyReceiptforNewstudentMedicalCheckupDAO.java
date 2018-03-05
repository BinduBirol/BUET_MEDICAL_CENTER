package com.mcenter.moneyReceiptofMedicalCheckUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;



import util.ConnectionUtil.ConnectionManager;

public class MoneyReceiptforNewstudentMedicalCheckupDAO {

 	

 	public ArrayList<MoneyReceiptforNewstudentMedicalCheckup> getreceiptList()
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<MoneyReceiptforNewstudentMedicalCheckup> sdList= new ArrayList<MoneyReceiptforNewstudentMedicalCheckup>();
		
		String sql="select SESSIONN,RECIPSNO,GROUP_ID,MERITPOSITION,STUDENTNAME,SEX,to_char(DOB,'dd/mm/yyyy') DATE_OF_BIRTH,FATHER_NAME,REFDOCTOR_NAME,AMOUNT from MCENTER.NEWSTDCHECKUPMONEYRECIPT order by GROUP_ID,MERITPOSITION ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				MoneyReceiptforNewstudentMedicalCheckup sd = new MoneyReceiptforNewstudentMedicalCheckup();				
				sd.setAcadenicsession(r.getString("SESSIONN"));
				sd.setReceiptNO(r.getString("RECIPSNO"));
				sd.setGroup_id(r.getString("GROUP_ID"));
				sd.setMeritPosition(r.getString("MERITPOSITION"));
				sd.setStudentname(r.getString("STUDENTNAME"));
				sd.setGender(r.getString("SEX"));
				sd.setFatherName(r.getString("FATHER_NAME"));
				sd.setDoctorName(r.getString("REFDOCTOR_NAME"));
				sd.setDob(r.getString("DATE_OF_BIRTH"));
				sd.setAmount(r.getString("AMOUNT"));
				sdList.add(sd);				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	public ArrayList<MoneyReceiptforNewstudentMedicalCheckup> getassignedtestList()
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<MoneyReceiptforNewstudentMedicalCheckup> sdList= new ArrayList<MoneyReceiptforNewstudentMedicalCheckup>();
		
		String sql="select distinct SESSIONN,RECIPSNO,AMOUNT,GROUP_ID,MERITPOSITION,STUDENTNAME,SEX,FATHER_NAME,REFDOCTOR_NAME,to_char(DOB,'dd/mm/yyyy') DATE_OF_BIRTH from MCENTER.NEWSTDCHECKUPMONEYRECIPT a,MCENTER.TEST_SAVE_FOR_NEW_STUDENT b\n" +
				"where a.RECIPSNO=b.RECEIPTNO order by GROUP_ID,MERITPOSITION ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				MoneyReceiptforNewstudentMedicalCheckup sd = new MoneyReceiptforNewstudentMedicalCheckup();				
				sd.setAcadenicsession(r.getString("SESSIONN"));
				sd.setReceiptNO(r.getString("RECIPSNO"));
				sd.setGroup_id(r.getString("GROUP_ID"));
				sd.setMeritPosition(r.getString("MERITPOSITION"));
				sd.setStudentname(r.getString("STUDENTNAME"));
				sd.setGender(r.getString("SEX"));
				sd.setFatherName(r.getString("FATHER_NAME"));
				sd.setDoctorName(r.getString("REFDOCTOR_NAME"));
				sd.setDob(r.getString("DATE_OF_BIRTH"));
				sd.setAmount(r.getString("AMOUNT"));
				sdList.add(sd);				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	public ArrayList<MoneyReceiptforNewstudentMedicalCheckup> getphysicalexaminationList()
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<MoneyReceiptforNewstudentMedicalCheckup> sdList= new ArrayList<MoneyReceiptforNewstudentMedicalCheckup>();
		
		String sql="select distinct SESSIONN,RECIPSNO,GROUP_ID,MERITPOSITION,STUDENTNAME,SEX,FATHER_NAME,REFDOCTOR_NAME from MCENTER.NEWSTDCHECKUPMONEYRECIPT a,MCENTER.PHYSICALEXAMINATION_SAVE b\n" +
				"where a.RECIPSNO=b.RECEIPTNO order by GROUP_ID,MERITPOSITION ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				MoneyReceiptforNewstudentMedicalCheckup sd = new MoneyReceiptforNewstudentMedicalCheckup();				
				sd.setAcadenicsession(r.getString("SESSIONN"));
				sd.setReceiptNO(r.getString("RECIPSNO"));
				sd.setGroup_id(r.getString("GROUP_ID"));
				sd.setMeritPosition(r.getString("MERITPOSITION"));
				sd.setStudentname(r.getString("STUDENTNAME"));
				sd.setGender(r.getString("SEX"));
				sd.setFatherName(r.getString("FATHER_NAME"));
				sd.setDoctorName(r.getString("REFDOCTOR_NAME"));
				sdList.add(sd);				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	public NewstudentMedicalCheckupDTO gettestReportShowNewAdmission(String receiptNO) {

 		Connection con = ConnectionManager.getConnection();	
 		PreparedStatement ps2= null;
 		NewstudentMedicalCheckupDTO dto= null;
 		try{
 			 	         
 	      
 	         con.setAutoCommit(false);
 	         
 	           dto= new NewstudentMedicalCheckupDTO();
 	         
 	          String sql2="select \n" +
 	                 "  max(case when TESTID = '14' then RESULT end) as BLOOD_GROUP,\n" +
 	                "  max(case when TESTID = '51' then RESULT end) as HBsAg\n" +
 	                "from MCENTER.TEST_SAVE_FOR_NEW_STUDENT\n" +
 	                "where RECEIPTNO='"+receiptNO+"'";
 	           
 	           /*String sql2="Select RESULT from MCENTER.TEST_SAVE_FOR_NEW_STUDENT where RECEIPTNO='"+receiptNO+"'";*/
 	           ps2 = con.prepareStatement(sql2);
 	          
 	        
 	 		   ResultSet rs2=ps2.executeQuery();
 	 		   while(rs2.next()){
 	 		 	 			
 	 			String  testResult_bloodGroup=rs2.getString("BLOOD_GROUP");
 	 			 String[] parts = testResult_bloodGroup.split("#");
                 String bloodGroup_ABO = parts[0];
                 String bloodGroup_Rh_D = parts[1];
 	 			
 	 			
 	 			dto.setTestResult_bloodGroup_ABO(bloodGroup_ABO);
 	 			dto.setTestResult_bloodGroup_Rh_D(bloodGroup_Rh_D);
 	 			dto.setTestResult_HBsAg_Screening(rs2.getString("HBsAg"));
 	 			dto.setReceiptNO(receiptNO);

 	 							 
 	 			}
 	 		   
 				
 			
 			con.commit();
 			
 			
 		}
 		
 		
 		catch (Exception e){
 			e.printStackTrace();
 			}
		finally{
			try{
				ps2.close();
				con.setAutoCommit(true);
				ConnectionManager.closeConnection(con);
				} 
			catch (Exception e)
				{
				e.printStackTrace();
				}
			ps2 = null;
			con = null;

				}		
 		

 		return dto;

 	}


 	
	
}
