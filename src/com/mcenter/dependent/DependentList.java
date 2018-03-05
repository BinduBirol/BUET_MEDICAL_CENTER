package com.mcenter.dependent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;





public class DependentList {
	
	private String departmentID;
	private String department;
	private String person;
	private String designation;
	
	
	private String officialId;
	private String dateofbirth;
	
	private String dependentname;
	private String dependentID;
	private String relation;
	private String sex;
	private String ageStr;
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	
	ArrayList<DependentList> dependentList=new ArrayList<DependentList>();
	
	
	public String getDependentID() {
		return dependentID;
	}


	public void setDependentID(String dependentID) {
		this.dependentID = dependentID;
	}


	public String getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPerson() {
		return person;
	}


	public void setPerson(String person) {
		this.person = person;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getAgeStr() {
		return ageStr;
	}


	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}


	public String getOfficialId() {
		return officialId;
	}


	public void setOfficialId(String officialId) {
		this.officialId = officialId;
	}


	public String getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getDependentname() {
		return dependentname;
	}


	public void setDependentname(String dependentname) {
		this.dependentname = dependentname;
	}


	public String getRelation() {
		return relation;
	}


	public void setRelation(String relation) {
		this.relation = relation;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public ArrayList<DependentList> getDependentList() {
		return dependentList;
	}


	public void setDependentList(ArrayList<DependentList> dependentList) {
		this.dependentList = dependentList;
	}


	public String dependentlist() throws Exception{
		
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession(true);
        
        officialId=request.getParameter("officialId");
       // department=request.getParameter("department");
       // person=request.getParameter("person");
        designation=request.getParameter("designation");
		
		//System.out.println("Age is :"+ageStr);
		
		
		System.out.println("officialId :"+officialId);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
             String sql1="Select * from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+officialId+"'";
 	        ps1 = con.prepareStatement(sql1);
 	         
 	         
 			 ResultSet rs1=ps1.executeQuery();
 			 while(rs1.next()){
 				
 				departmentID=rs1.getString(26);
 				person=rs1.getString(3);
 				 
 			 }  
             
             
 			 String sql3="Select * from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID='"+departmentID+"'";
  	        ps3 = con.prepareStatement(sql3);
  	         
  	         
  			 ResultSet rs3=ps3.executeQuery();
  			 while(rs3.next()){
  				
  				department=rs3.getString(4);
  				
  				 
  			 }  
 			 
 			 
		
			String sql2="Select TO_CHAR(DOB, 'dd/mm/yyyy') AS DOB,DNAME,RELATION,SEX,DEPENDENTID from MCENTER.DEPENDENCY where OFFICIALID='"+officialId+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				 
				 DependentList dep = new DependentList();
				 
						  dateofbirth=rs2.getString("DOB");
						 
						  System.out.println("dateofbirth :"+dateofbirth);
				 
						  if(dateofbirth!=null){
				 org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
					
					org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dateofbirth);
					org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
					org.joda.time.DateTime now = new org.joda.time.DateTime();
					org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
					 ageStr = java.lang.String.valueOf (age.getYears());			
				
					System.out.println("Age is :"+ageStr);
						  }
						  
						  
						  if(dateofbirth==null){
		 					
		 					dateofbirth="N/A";
		 					ageStr="N/A";
		 					
		 				}
	//officialIDlist.add(rs2.getString(2));
				 dep.setDateofbirth(dateofbirth);
			     dep.setAgeStr(ageStr);			 
				 dep.setDependentname(rs2.getString("DNAME"));
				 dep.setRelation(rs2.getString("RELATION"));
				 dep.setSex(rs2.getString("SEX"));
				 dep.setDependentID(rs2.getString("DEPENDENTID"));
				 dependentList.add(dep);	
				
				 
				}
			 
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		      
		        if (ps2!= null) {
		        	ps2.close();
		        }
		       
		        
		        con.setAutoCommit(true);
		        con.close();
		        session.invalidate();
		    }
		
		return "success";
   
   }	   		

	
public String deletedependent() throws Exception{
		
        HttpServletRequest request = ServletActionContext.getRequest();
		
        dependentID=request.getParameter("dependentID");
        dependentname=request.getParameter("dependentname");
       
		
		//System.out.println("Age is :"+ageStr);
		
		
		System.out.println("dependentID :"+dependentID);
		Connection con = ConnectionManager.getConnection();	
	//	Connection con = null;
		try{
			
		/* Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
              
      ////////////////////////////////////////////////////////
               
             String sql1="Select * from MCENTER.DEPENDENCY where DEPENDENTID='"+dependentID+"'";
 	        ps1 = con.prepareStatement(sql1);
 	         
 	         
 			 ResultSet rs1=ps1.executeQuery();
 			 while(rs1.next()){
 				officialId=rs1.getString(9);
 				department=rs1.getString(2);
 				person=rs1.getString(3);
 				designation=rs1.getString(4);
 				 
 			 }  
             
 			String sql5="DELETE  from  MCENTER.DEPENDENCY  WHERE DEPENDENTID='"+dependentID+"' and DNAME='"+dependentname+"' ";
 	   	      
            //Statement stmt=con.createStatement();
            //stmt.execute(sql1);

            	ps5 = con.prepareStatement(sql5);
                ps5.executeQuery();          
 			
			String sql2="Select TO_CHAR(DOB, 'dd/mm/yyyy') AS DOB,DNAME,RELATION,SEX,DEPENDENTID from MCENTER.DEPENDENCY where OFFICIALID='"+officialId+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				 
				 DependentList dep = new DependentList();
				 
						  dateofbirth=rs2.getString("DOB");
						 
						  System.out.println("dateofbirth :"+dateofbirth);
				 
						  if(dateofbirth!=null){
				 org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
					
					org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dateofbirth);
					org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
					org.joda.time.DateTime now = new org.joda.time.DateTime();
					org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
					 ageStr = java.lang.String.valueOf (age.getYears());			
				
					System.out.println("Age is :"+ageStr);
						  }	
						  
						  if(dateofbirth==null){
			 					
			 					dateofbirth="N/A";
			 					ageStr="N/A";
			 					
			 				}
	//officialIDlist.add(rs2.getString(2));
				 dep.setDateofbirth(dateofbirth);
			     dep.setAgeStr(ageStr);			 
				 dep.setDependentname(rs2.getString("DNAME"));
				 dep.setRelation(rs2.getString("RELATION"));
				 dep.setSex(rs2.getString("SEX"));
				 dep.setDependentID(rs2.getString("DEPENDENTID"));
				 dependentList.add(dep);	
				
				 
				}
			 
			
			
			
			con.commit();
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	                con.rollback();
	            } catch(SQLException excep) {
	                
	                excep.printStackTrace();
	                }
	            
		 }
		 
		}
		
		    finally {
		      
		        if (ps2!= null) {
		        	ps2.close();
		        }
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	   		


public String updatedependent() throws Exception{
	
    HttpServletRequest request = ServletActionContext.getRequest();
	
    dependentID=request.getParameter("dependentID");
  /*String  newdependentID=request.getParameter("newdependentID");*/
  String  dependentName=request.getParameter("dependentName");
  String  dob=request.getParameter("dateofbirth");
  String  gender=request.getParameter("gender");
  String  relation=request.getParameter("relation");
   
   
	
	
	
	
	System.out.println("dependentID :"+dependentID);
	System.out.println("dependentName :"+dependentName);
	System.out.println("dob :"+dob);
	System.out.println("gender :"+gender);
	System.out.println("relation :"+relation);
	
	Connection con = ConnectionManager.getConnection();	
	//Connection con = null;
	try{
		
/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
         
      
         con.setAutoCommit(false);
          
  ////////////////////////////////////////////////////////
           
         String sql1="Select * from MCENTER.DEPENDENCY where DEPENDENTID='"+dependentID+"'";
	        ps1 = con.prepareStatement(sql1);
	         
	         
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next()){
				officialId=rs1.getString(9);
				department=rs1.getString(2);
				person=rs1.getString(3);
				designation=rs1.getString(4);
				 
						 }  
         
			 if(dependentName!=null && dob!=null)
				{			 
String sql5="UPDATE MCENTER.DEPENDENCY SET DNAME ='"+dependentName+"',RELATION ='"+relation+"',SEX ='"+gender+"',DOB =to_date('"+dob+"','dd/mm/yyyy')  WHERE DEPENDENTID='"+dependentID+"'";
	   	      
        //Statement stmt=con.createStatement();to_date('"+dateofbirth+"','mm/dd/yyyy')
        //stmt.execute(sql1);

        	ps5 = con.prepareStatement(sql5);
            ps5.executeQuery();          
				}			
		String sql2="Select TO_CHAR(DOB, 'dd/mm/yyyy') AS DOB,DNAME,RELATION,SEX,DEPENDENTID from MCENTER.DEPENDENCY where OFFICIALID='"+officialId+"'";
        ps2 = con.prepareStatement(sql2);
         
         
		 ResultSet rs2=ps2.executeQuery();
		 while(rs2.next()){
			 
			 DependentList dep = new DependentList();
			 
					  dateofbirth=rs2.getString("DOB");
					 
					  System.out.println("dateofbirth :"+dateofbirth);
			 
					  if(dateofbirth!=null){
			    org.joda.time.format.DateTimeFormatter formatter =  org.joda.time.format.DateTimeFormat.forPattern("dd/mm/yyyy");
				
				org.joda.time.DateTime birthdateDate = formatter.parseDateTime(dateofbirth);
				org.joda.time.DateMidnight birthdate = new         org.joda.time.DateMidnight(birthdateDate.getYear(), birthdateDate.getMonthOfYear(), birthdateDate.getDayOfMonth() );
				org.joda.time.DateTime now = new org.joda.time.DateTime();
				org.joda.time.Years age = org.joda.time.Years.yearsBetween(birthdate, now);
				 ageStr = java.lang.String.valueOf (age.getYears());			
			
				System.out.println("Age is :"+ageStr);
					  }	
					  
					  if(dateofbirth==null){
		 					
		 					dateofbirth="N/A";
		 					ageStr="N/A";
		 					
		 				}
//officialIDlist.add(rs2.getString(2));
			 dep.setDateofbirth(dateofbirth);
		     dep.setAgeStr(ageStr);			 
			 dep.setDependentname(rs2.getString("DNAME"));
			 dep.setRelation(rs2.getString("RELATION"));
			 dep.setSex(rs2.getString("SEX"));
			 dep.setDependentID(rs2.getString("DEPENDENTID"));
			 dependentList.add(dep);	
			
			 
			}
		 
		
		
		
		con.commit();
		
		
	}
	
	catch(Exception e){
		e.printStackTrace();
	
	
	
	 if (con != null) {
            try {
            	System.err.println("There is sql exception Mr.Adnan");
                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
                con.rollback();
            } catch(SQLException excep) {
                
                excep.printStackTrace();
                }
            
	 }
	 
	}
	
	    finally {
	      
	        if (ps2!= null) {
	        	ps2.close();
	        }
	       
	       
	        con.setAutoCommit(true);
	        con.close();
	    }
	
	return "success";

}	   		


}
