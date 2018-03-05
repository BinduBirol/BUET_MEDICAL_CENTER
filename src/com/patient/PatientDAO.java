package com.patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import table.userrole.UserRoleDTO;
import util.ConnectionUtil.ConnectionManager;
import util.login.ValidateUser;


import com.opensymphony.xwork2.ActionContext;
import com.table.PatientDetailDTO;
import com.table.PatientListDTO;


public class PatientDAO {
	
	
public ArrayList<PatientListDTO> fetchtodaylist()
	{
		
		ArrayList<PatientListDTO> tdlist = new ArrayList<PatientListDTO>();
		
		
		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			Connection conn = ConnectionManager.getConnection();
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
					
			String sql= " select distinct PH.VISITID, temp.name, temp.age,ph.PATIENTID,PH.VISITINGDATE,PH.PATIENTNUMBER "+
             			" from PATIENT_HISTORY ph,TODAYDOCTOR td, "+                      
             			" (select STUDENTID pid,STUDENTNAME name,AGECALCULATE(DATEOFBIRTH) age  from BIIS.STUDENT "+
             			" union "+ 
             			" select OFFICIAL_ID pid, NAME name,AGECALCULATE(DATE_OF_BIRTH) age from ESTABLISHMENT.PERSONNEL "+
             			" union "+ 
             			" select TEMPID pid, NAME name,AGECALCULATE(DATE_OF_BIRTH) age from MCENTER.NONIDPATIENT "+
             			" union "+
             			" select DEPENDENTID pid, DNAME name,AGECALCULATE(DOB) age from DEPENDENCY )temp "+
             			" where PH.VISITINGDATE= to_date(sysdate,'dd/mm/RRRR') "+ 
             			" and PH.PATIENTID=temp.pid and td.SHIFT_SATUS='running' " +
             			" and PH.VISITID NOT IN (select PRESCRIPTION.VISITID from PRESCRIPTION )" +
             			"and PH.REFDOCTORID='"+user.getOfficalid()+"' ORDER BY PH.PATIENTNUMBER ASC  ";
			
			
			stmt = conn.prepareStatement(sql);
			System.out.println("user.getUsername() : " + user.getUsername());
			System.out.println("user.getUserfullname() : " + user.getUserfullname());
			System.out.println("user.getOfficalid() : " + user.getOfficalid());
			r = stmt.executeQuery();
			System.out.println("Response : " + sql);
			
			while (r.next())
			{
				PatientListDTO pt = new PatientListDTO();
				
				pt.setVisitid(r.getString("visitid"));
				pt.setName(r.getString("name")); 
				pt.setPatientid(r.getString("patientid"));
				pt.setVisidate(r.getString("visitingdate"));
				pt.setAge(r.getString("age"));
				
							
				tdlist.add(pt);	
			}
			
			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
	    
	    return tdlist;
	    
	}   

public byte [] getImage(String patientid)
{
	
	 byte [] image= null;
	 
	 PreparedStatement stmt = null;
	   ResultSet r = null;
	   
	   
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			Connection conn = ConnectionManager.getConnection();
			
			
			String sql ="select IMAGE from BIIS.STUDENT where studentid = ? ";
			
			
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, patientid);
			r = stmt.executeQuery();
			if (r.next())
			{
				image=r.getBytes("IMAGE");
			}
			conn.close();
		}catch(Exception e)
		{e.printStackTrace();}
	 
	 return image;
}
public ArrayList<PatientListDTO>fetchPreviousHistorylist(String patientid)
{
	
	ArrayList<PatientListDTO> totallist = new ArrayList<PatientListDTO>();
	//String patientid=(String)ServletActionContext.getRequest().getParameter("patientid");
	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();
				

		
		
	String sql=" select  to_char(PH.VISITINGDATE,'dd/mm/RRRR')Visitingdate,temp.name,ph.PATIENTID,PH.VISITID visitid,PRESCRIPTION.PRESCRIPTIONID prescriptionid,ph.REFDOCTORNAME doctorname"+
		   		   " from PATIENT_HISTORY ph, PRESCRIPTION,  " +					   
		   		   " (select STUDENTID pid,STUDENTNAME name from BIIS.STUDENT " +
		   		   " union " +
		   		   " select OFFICIAL_ID pid, NAME name from ESTABLISHMENT.PERSONNEL " +
		   		   " union "+ 
     			   " select TEMPID pid, NAME name from MCENTER.NONIDPATIENT "+
		   		   " union "+
		   		   " select DEPENDENTID pid, DNAME name from DEPENDENCY )temp "+
		   		   " where PRESCRIPTION. PATIENTID='"+patientid+"'  and PH.PATIENTID=temp.pid and PRESCRIPTION.VISITID=PH.VISITID ";

	    stmt = conn.prepareStatement(sql);		
	    r = stmt.executeQuery();
		
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientListDTO pt = new PatientListDTO();
			
			pt.setVisidate(r.getString("VISITINGDATE"));
			pt.setName(r.getString("name")); 
			pt.setPatientid(r.getString("patientid"));
			pt.setVisitid(r.getString("visitid"));
			pt.setPrescriptionid(r.getString("prescriptionid"));
			pt.setDoctorid(r.getString("doctorname"));
			
			
						
			totallist.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
    
    return totallist;
    
}
public ArrayList<PatientListDTO>fetchAlllist(String fdate, String tdate)
{
	
	ArrayList<PatientListDTO> totallist = new ArrayList<PatientListDTO>();
	
	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();

		
		
	String sql=" select  to_char(PH.VISITINGDATE,'dd/mm/RRRR')Visitingdate,temp.name,ph.PATIENTID,PH.VISITID visitid,PRESCRIPTION.PRESCRIPTIONID prescriptionid,ph.REFDOCTORNAME doctorname"+
		   		   " from PATIENT_HISTORY ph, PRESCRIPTION,  " +					   
		   		   " (select STUDENTID pid,STUDENTNAME name from BIIS.STUDENT " +
		   		   " union " +
		   		   " select OFFICIAL_ID pid, NAME name from ESTABLISHMENT.PERSONNEL " +
		   		   " union " +
		   		   " select TEMPID pid, NAME name from MCENTER.NONIDPATIENT " +
		   		   " union "+
		   		   " select DEPENDENTID pid, DNAME name from DEPENDENCY )temp "+
		   		   " where PH.VISITINGDATE between to_date(?,'dd/mm/RRRR') and to_date(?,'dd/mm/RRRR') "+
		   		   " and PH.PATIENTID=temp.pid and PRESCRIPTION.VISITID=PH.VISITID ";

		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, fdate);
		stmt.setString(2, tdate);	
		
		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientListDTO pt = new PatientListDTO();
			
			pt.setVisidate(r.getString("VISITINGDATE"));
			pt.setName(r.getString("name")); 
			pt.setPatientid(r.getString("patientid"));
			pt.setVisitid(r.getString("visitid"));
			pt.setPrescriptionid(r.getString("prescriptionid"));
			pt.setDoctorid(r.getString("doctorname"));
			
			
						
			totallist.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
    
    return totallist;
    
}  

public ArrayList<PatientListDTO>fetchAlllistforAdoctor(String fdate, String tdate,String officialID)
{
	
	ArrayList<PatientListDTO> totallist = new ArrayList<PatientListDTO>();
	
	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();

		
		
	String sql=" select  to_char(PH.VISITINGDATE,'dd/mm/RRRR')Visitingdate,temp.name,ph.PATIENTID,PH.VISITID visitid,PRESCRIPTION.PRESCRIPTIONID prescriptionid,ph.REFDOCTORNAME doctorname"+
		   		   " from PATIENT_HISTORY ph, PRESCRIPTION,  " +					   
		   		   " (select STUDENTID pid,STUDENTNAME name from BIIS.STUDENT " +
		   		   " union " +
		   		   " select OFFICIAL_ID pid, NAME name from ESTABLISHMENT.PERSONNEL " +
		   		   " union " +
		   		   " select TEMPID pid, NAME name from MCENTER.NONIDPATIENT " +
		   		   " union "+
		   		   " select DEPENDENTID pid, DNAME name from DEPENDENCY )temp "+
		   		   " where PH.VISITINGDATE between to_date(?,'dd/mm/RRRR') and to_date(?,'dd/mm/RRRR') "+
		   		   " and PH.PATIENTID=temp.pid and PRESCRIPTION.VISITID=PH.VISITID and PRESCRIPTION.DOCTORID=? order by PH.VISITINGDATE,PRESCRIPTION.PRESCRIPTIONID";

		
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, fdate);
		stmt.setString(2, tdate);
		stmt.setString(3, officialID);
		
		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientListDTO pt = new PatientListDTO();
			
			pt.setVisidate(r.getString("VISITINGDATE"));
			pt.setName(r.getString("name")); 
			pt.setPatientid(r.getString("patientid"));
			pt.setVisitid(r.getString("visitid"));
			pt.setPrescriptionid(r.getString("prescriptionid"));
			pt.setDoctorid(r.getString("doctorname"));
			
			
						
			totallist.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
    
    return totallist;
    
} 





public ArrayList<PatientDetailDTO>ptdetail(String patientid,String visitid,Long prescriptionid,String doctorid)
{
	
	ArrayList<PatientDetailDTO> ptlist = new ArrayList<PatientDetailDTO>();
	
	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();
		
		String sql= " select tmp.Name name, tmp.Designation Designation,tmp.Department  Department, tmp.sex Sex, tmp.pid Patientid,to_char(PH.VISITINGDATE,'dd/mm/RRRR')VISITINGDATE" +
					" from PATIENT_HISTORY ph, " + 
					" (select  BSTD.STUDENTNAME Name,'Student' Designation, BSTD.DEPARTMENTID Department ,DECODE (BSTD.SEX ,'M','Male','F','Female',BSTD.SEX)sex ,BSTD.STUDENTID pid " +
					" from biis.STUDENT bstd " +
					" where BSTD.STUDENTID='"+patientid+"' " + 
					" union "+
					" select ESP.NAME name, ESD.FULL_DESIGNATION  designation,DEP.SHORT_DEPARTMENT_NAME department,DECODE (ESP.SEX ,'M','Male','F','Female',ESP.SEX)sex, ESP.OFFICIAL_ID pid " +
					" from ESTABLISHMENT.PERSONNEL esp,ESTABLISHMENT.DESIGNATION esd,ESTABLISHMENT.Department dep " + 
					" where ESP.CURRENT_DESIGNATION_ID=ESD.DESIGNATION_ID " +
					" and ESP.DEPARTMENT_ID=DEP.DEPARTMENT_ID " +
					" and ESP.OFFICIAL_ID='"+patientid+"' " +
					" union "+
					" select NAME name,DESIGNATION  designation,DEPT department,SEX sex,TEMPID pid " +
					" from MCENTER.NONIDPATIENT " + 
					" where MCENTER.NONIDPATIENT.TEMPID='"+patientid+"' " +
					" union " +
					" select DP.DNAME name,' ' designation, ' ' department, DP.SEX sex, DP.DEPENDENTID pid " +
					" from DEPENDENCY dp,ESTABLISHMENT.PERSONNEL esp " +
					" where DP.OFFICIALID=ESP.OFFICIAL_ID " +
					" and  DP.DEPENDENTID   ='"+patientid+"')tmp " +
					" where PH.PATIENTID=tmp.pid " +
					" and PH.VISITID = '"+visitid+"'";
		
		
		stmt = conn.prepareStatement(sql);		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientDetailDTO pt = new PatientDetailDTO();
			
			pt.setName(r.getString("Name"));
			pt.setDepartment(r.getString("Department"));
			pt.setDesignation(r.getString("Designation"));			
			pt.setSex(r.getString("Sex"));
			pt.setPatientid(r.getString("Patientid"));
			pt.setVisidate(r.getString("visitingdate"));
			pt.setPrescriptionid(prescriptionid);
			pt.setDoctotid(doctorid);
			ptlist.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
    
    return ptlist;
    
} 

public ArrayList<PatientDetailDTO>ptdetail(String patientid,String visitid)
{
	
	ArrayList<PatientDetailDTO> ptlist = new ArrayList<PatientDetailDTO>();
	
	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();
		
		String sql= " select tmp.Name name, tmp.Designation Designation,tmp.Department  Department, tmp.sex Sex, tmp.pid Patientid,to_char(PH.VISITINGDATE,'dd/mm/RRRR')VISITINGDATE" +
					" from PATIENT_HISTORY ph, " + 
					" (select  BSTD.STUDENTNAME Name,'Student' Designation, BSTD.DEPARTMENTID Department ,DECODE (BSTD.SEX ,'M','Male','F','Female',BSTD.SEX)sex ,BSTD.STUDENTID pid " +
					" from biis.STUDENT bstd " +
					" where BSTD.STUDENTID='"+patientid+"' " + 
					" union "+
					" select ESP.NAME name, ESD.FULL_DESIGNATION  designation,DEP.SHORT_DEPARTMENT_NAME department, DECODE (ESP.SEX ,'M','Male','F','Female',ESP.SEX)sex, ESP.OFFICIAL_ID pid " +
					" from ESTABLISHMENT.PERSONNEL esp,ESTABLISHMENT.DESIGNATION esd,ESTABLISHMENT.Department dep " + 
					" where ESP.CURRENT_DESIGNATION_ID=ESD.DESIGNATION_ID " +
					" and ESP.DEPARTMENT_ID=DEP.DEPARTMENT_ID " +
					" and ESP.OFFICIAL_ID='"+patientid+"' " +
					" union "+
					" select NAME name,DESIGNATION  designation,DEPT department,SEX sex,TEMPID pid " +
					" from MCENTER.NONIDPATIENT " + 
					" where MCENTER.NONIDPATIENT.TEMPID='"+patientid+"' " +
					" union " +
					" select DP.DNAME name,' ' designation, ' ' department, DP.SEX sex, DP.DEPENDENTID pid " +
					" from DEPENDENCY dp,ESTABLISHMENT.PERSONNEL esp " +
					" where DP.OFFICIALID=ESP.OFFICIAL_ID " +
					" and  DP.DEPENDENTID   ='"+patientid+"')tmp " +
					" where PH.PATIENTID=tmp.pid " +
					" and PH.VISITID = '"+visitid+"'";
		
		
		stmt = conn.prepareStatement(sql);		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientDetailDTO pt = new PatientDetailDTO();
			
			pt.setName(r.getString("Name"));
			pt.setDepartment(r.getString("Department"));
			pt.setDesignation(r.getString("Designation"));			
			pt.setSex(r.getString("Sex"));
			pt.setPatientid(r.getString("Patientid"));
			pt.setVisidate(r.getString("visitingdate"));
						
			ptlist.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
	{e.printStackTrace();}
    
    return ptlist;
    
} 


public ArrayList<PatientDetailDTO>ptdisplay(String patientid, String visitid)
{
	
	ArrayList<PatientDetailDTO> ptdisplay = new ArrayList<PatientDetailDTO>();

	
	PreparedStatement stmt = null;
	ResultSet r = null;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();
		
		
		String sql= " select tmp.pid Patientid,tmp.age age,tmp.Name name,tmp.careof,tmp.Designation Designation,tmp.Department  Department , tmp.sex Sex,tmp.hall, tmp.room , PH.VISITID visitid"+
					" from PATIENT_HISTORY ph, "+
					" (select BSTD.STUDENTID pid , BSTD.STUDENTNAME Name ,AGECALCULATE(bstd.DATEOFBIRTH) age,DECODE (BSTD.SEX ,'M','Male','F','Female',BSTD.SEX)sex , ' ' careof,'Student' Designation,BSTD.DEPARTMENTID Department ,hl.hall_name hall ,hls.room room "+
					" from biis.STUDENT bstd,  biis.HALL_LIST hl, biis.HALL_STUDENT hls "+
					" where BSTD.STUDENTID=hls.STUDENT_ID "+
					" and hl.HALL_ID=hls.HALL_ID "+
					" and  BSTD.STUDENTID='"+patientid+"' "+
					" union "+
					" select ESP.OFFICIAL_ID pid,ESP.NAME name,AGECALCULATE(esp.DATE_OF_BIRTH) age, DECODE (ESP.SEX ,'M','Male','F','Female',ESP.SEX)sex,' ' careof,    ESD.FULL_DESIGNATION   designation  ,DEP.SHORT_DEPARTMENT_NAME department  ,' ' hallname,' ' room "+
					" from ESTABLISHMENT.PERSONNEL esp,ESTABLISHMENT.DESIGNATION esd,ESTABLISHMENT.Department dep "+
					" where ESP.CURRENT_DESIGNATION_ID=ESD.DESIGNATION_ID "+
					" and ESP.DEPARTMENT_ID=DEP.DEPARTMENT_ID "+
					" and ESP.OFFICIAL_ID='"+patientid+"' "+
					" union "+
					" select TEMPID pid,NAME name,AGECALCULATE(DATE_OF_BIRTH) age,SEX sex,' ' careof,DESIGNATION  designation,DEPT department,' ' hallname,' ' room  " +
					" from MCENTER.NONIDPATIENT " + 
					" where MCENTER.NONIDPATIENT.TEMPID='"+patientid+"' " +
					" union "+
					" select DP.DEPENDENTID pid,DP.DNAME name,AGECALCULATE(dp.DOB) age,DP.SEX sex,ESP.NAME careof, ' ' designation, ' ' department,' ' hallname,' ' room"+ 
					" from DEPENDENCY dp,ESTABLISHMENT.PERSONNEL esp "+
					" where DP.OFFICIALID=ESP.OFFICIAL_ID "+
					" and  DP.DEPENDENTID   ='"+patientid+"')tmp "+
					" where PH.PATIENTID=tmp.pid "+
					" and PH.VISITID = '"+visitid+"'";
		
				
		stmt = conn.prepareStatement(sql);
		
		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		while (r.next())
		{
			PatientDetailDTO pt = new PatientDetailDTO();
			
			pt.setName(r.getString("Name"));
			pt.setCareof(r.getString("careof"));
			pt.setDesignation(r.getString("Designation"));			
			pt.setDepartment(r.getString("Department"));				
			pt.setSex(r.getString("Sex"));
			pt.setPatientid(r.getString("Patientid"));
			pt.setHall(r.getString("hall"));
			pt.setRoomno(r.getString("room"));
			pt.setVisitid(r.getString("visitid"));
			pt.setAge(r.getString("age"));
						
			ptdisplay.add(pt);	
		}
		
		conn.close();
	}
	catch(Exception e)
		{e.printStackTrace();}
    
    return ptdisplay;
    
}   



}
