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

import com.opensymphony.xwork2.ActionSupport;

public class AddDependent  extends ActionSupport {
	
	private String name;
	private String duplicateName;
	private String dateofbirth;
	private String relation;
	private String sex;	
	private String ageStr;
		
	private String departmentID;
	private String departmentName;
	private String idholderName;
	private String personofficialID;
	private String designation;
	private String officialID;
	private String dependentID;
	private int count;
	private String dependentname;
	
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	PreparedStatement ps3 = null;
	PreparedStatement ps4 = null;
	PreparedStatement ps5 = null;
	PreparedStatement ps6 = null;
	
	   private ArrayList<String>departmentlist= new ArrayList<String>();
	   private ArrayList<String>departmentIDlist= new ArrayList<String>();
	   private ArrayList<String>personNamelist= new ArrayList<String>();
	   private ArrayList<String>officialIDlist= new ArrayList<String>();
	   private ArrayList<AddDependent> dependentList=new ArrayList<AddDependent>();
	
	   
	   
	

	
	public ArrayList<AddDependent> getDependentList() {
		return dependentList;
	}

	public void setDependentList(ArrayList<AddDependent> dependentList) {
		this.dependentList = dependentList;
	}

	public String getDependentname() {
		return dependentname;
	}

	public void setDependentname(String dependentname) {
		this.dependentname = dependentname;
	}

	public String getAgeStr() {
		return ageStr;
	}

	public void setAgeStr(String ageStr) {
		this.ageStr = ageStr;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIdholderName() {
		return idholderName;
	}

	public void setIdholderName(String idholderName) {
		this.idholderName = idholderName;
	}

	public String getDependentID() {
		return dependentID;
	}

	public void setDependentID(String dependentID) {
		this.dependentID = dependentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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

	public String getPersonofficialID() {
		return personofficialID;
	}

	public void setPersonofficialID(String personofficialID) {
		this.personofficialID = personofficialID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOfficialID() {
		return officialID;
	}

	public void setOfficialID(String officialID) {
		this.officialID = officialID;
	}

	public ArrayList<String> getPersonNamelist() {
		return personNamelist;
	}

	public void setPersonNamelist(ArrayList<String> personNamelist) {
		this.personNamelist = personNamelist;
	}

	public ArrayList<String> getOfficialIDlist() {
		return officialIDlist;
	}

	public void setOfficialIDlist(ArrayList<String> officialIDlist) {
		this.officialIDlist = officialIDlist;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public ArrayList<String> getDepartmentlist() {
		return departmentlist;
	}

	public void setDepartmentlist(ArrayList<String> departmentlist) {
		this.departmentlist = departmentlist;
	}

	public ArrayList<String> getDepartmentIDlist() {
		return departmentIDlist;
	}

	public void setDepartmentIDlist(ArrayList<String> departmentIDlist) {
		this.departmentIDlist = departmentIDlist;
	}

	public String department() throws Exception{
		System.out.println("Hit department:");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
	/*	 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
				
			String sql1="Select * from ESTABLISHMENT.DEPARTMENT";
	        ps1 = con.prepareStatement(sql1);
	         
	         
			 ResultSet rs1=ps1.executeQuery();
			 while(rs1.next()){
				
				
				

						
departmentIDlist.add(rs1.getString(1));
departmentlist.add(rs1.getString(4));

				 
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
		      
		        if (ps1!= null) {
		        	ps1.close();
		        }
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	
	
	public String person() throws Exception{
		System.out.println("Hit  person :");
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
				
			String sql2="Select * from ESTABLISHMENT.PERSONNEL where DEPARTMENT_ID='"+departmentID+"'";
	        ps2 = con.prepareStatement(sql2);
	         
	         
			 ResultSet rs2=ps2.executeQuery();
			 while(rs2.next()){
				
				
				

						
officialIDlist.add(rs2.getString(2));
personNamelist.add(rs2.getString(3));

				 
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
	
	public String designation_officialID() throws Exception{
		System.out.println("Hit  designation_officialID  :"+personofficialID);
		Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
/*		 Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
				
			String sql3="Select * from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+personofficialID+"'";
	        ps3 = con.prepareStatement(sql3);
	         
	         
			 ResultSet rs3=ps3.executeQuery();
			 while(rs3.next()){
				
				
				
				String  designationID=rs3.getString(16);
				  
				  String sql4="Select * from ESTABLISHMENT.DESIGNATION where DESIGNATION_ID='"+designationID+"'";
			        ps4 = con.prepareStatement(sql4);
			         
			         
					 ResultSet rs4=ps4.executeQuery();
					 while(rs4.next()){
						
						
						
						  designation=rs4.getString(2);
						  
						  
						  
						  
						  
						  
								


						 
						}
				  
				  
				  
				  officialID=rs3.getString(2);
						


				 
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
		      
		        if (ps3!= null) {
		        	ps3.close();
		        }
		       
		       
		        con.setAutoCommit(true);
		        con.close();
		    }
		
		return "success";
   
   }	   	
		
	public String saveDependent() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession(true);
	
	
		
	officialID=request.getParameter("officialIdsend");
	designation=request.getParameter("designationsend");
	String	name[] =request.getParameterValues("name");
	String doblist[]=request.getParameterValues("dateofbirth");
	String relation[]=request.getParameterValues("relation");
	String sex[]=request.getParameterValues("sex");
	
	if(name!=null) { 
		for(int i=0;i<name.length;i++) { 
		System.out.println(name[i]); 
		System.out.println(doblist[i]); 
		System.out.println(relation[i]); 
		System.out.println(sex[i]); 
		} 
		} 
	
	System.out.println(officialID);
	System.out.println(designation);
	
	/*
		departmentID=request.getParameter("department");
		designation=request.getParameter("designation");
		officialID=request.getParameter("officialId");
		name=request.getParameter("name");
		dateofbirth=request.getParameter("dateofbirth");
		relation=request.getParameter("relation");
		sex=request.getParameter("sex");
	*/
	Connection con = ConnectionManager.getConnection();	
		//Connection con = null;
		try{
			
		 /*Class.forName("oracle.jdbc.driver.OracleDriver");
	     con = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
	         
	      
             con.setAutoCommit(false);
             
      
             String sql1="Select * from ESTABLISHMENT.PERSONNEL where OFFICIAL_ID='"+officialID+"'";
  	        ps1 = con.prepareStatement(sql1);
  	         
  	         
  			 ResultSet rs1=ps1.executeQuery();
  			 while(rs1.next()){
  				
  				departmentID=rs1.getString(26);
  				idholderName=rs1.getString(3);
  				 
  			 }  
              
              
  			
             
             
             
             
     		
 			String sql2="Select * from ESTABLISHMENT.DEPARTMENT where DEPARTMENT_ID='"+departmentID+"' ";
 	        ps2 = con.prepareStatement(sql2);
 	         
 	         
 			 ResultSet rs2=ps2.executeQuery();
 			 while(rs2.next()){
 				
 				
 				departmentName=	rs2.getString(4);	

 						
 

 				 
 				}             
             
 		          
             
 			
 						
 

 				 
 				          
 
 			
 			for(int i=0;i<name.length;i++) { 
             if(name!=null && doblist!=null &&  officialID!=null && !relation[i].equals("nullRelation") && !sex[i].equals("nullSex"))
             { 
         		
         			
         			String sql3="Select count(*) from MCENTER.DEPENDENCY where OFFICIALID='"+officialID+"'";
         	        ps4 = con.prepareStatement(sql3);
         	         
         	         
         			 ResultSet rs3=ps4.executeQuery();
         			 while(rs3.next()){
         				
         				
         				count=rs3.getInt(1);	

         						
         

         				 
         				}  			 
         			 
         			 if(count==0){
                     count=count+1;
                     
                     dependentID=officialID+"-DEP:"+count;    			
         			 }
         			 
         			 
         			 else{
         				 
         				String sql4="Select max(DEPENDENTID) from MCENTER.DEPENDENCY where OFFICIALID='"+officialID+"' ";
             	        ps6 = con.prepareStatement(sql4);
             	         
             	         
             			 ResultSet rs6=ps6.executeQuery();
             			 while(rs6.next()){
             				
             				
             			String	dependentlastID=rs6.getString(1);
             			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
                        String depID[]=new String[dependentlastID.length()];
                        
                        depID=dependentlastID.split(":");
                        String number=depID[1];
                        
                        int lastnumber = Integer.parseInt(number);
                        count=lastnumber+1;

                        dependentID=officialID+"-DEP:"+count;	 
             				} 
         				 
         				  				 
         				 
         			 }
         			
               			
 ps3=con.prepareStatement("INSERT INTO MCENTER.DEPENDENCY VALUES('"+departmentID+"','"+departmentName+"','"+idholderName+"','"+designation+"','"+name[i]+"','"+relation[i]+"','"+sex[i]+"',to_date('"+doblist[i]+"','dd/mm/yyyy'),'"+officialID+"','"+dependentID+"')");
 ps3.executeUpdate(); 
        
	         
             }
		}	 
			
		////////////////////////////////////
             
             
         
 			    
             
             String sql5="Select TO_CHAR(DOB, 'dd/mm/yyyy') AS DOB,DNAME,RELATION,SEX,DEPENDENTID from MCENTER.DEPENDENCY where OFFICIALID='"+officialID+"'";
 	        ps5 = con.prepareStatement(sql5);
 	         
 	         
 			 ResultSet rs5=ps5.executeQuery();
 			 while(rs5.next()){
 				 
 				AddDependent dep = new AddDependent();
 				 
 						  dateofbirth=rs5.getString("DOB");
 						 
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
 				
 				/*if(dateofbirth==null){
 					
 					dateofbirth="N/A";
 					//ageStr="N/A";
 					
 				}*/
 	//officialIDlist.add(rs2.getString(2));
 				 dep.setDateofbirth(dateofbirth);
 			     dep.setAgeStr(ageStr);			 
 				 dep.setDependentname(rs5.getString("DNAME"));
 				 dep.setRelation(rs5.getString("RELATION"));
 				 dep.setSex(rs5.getString("SEX"));
 				 dep.setDependentID(rs5.getString("DEPENDENTID"));
 				 dependentList.add(dep);	
 				
 				 
 				 
 			 }
 				            
 			con.commit();
			
 		return "adnan";		
			
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		
		
		
		 if (con != null) {
	            try {
	            	System.err.println("There is sql exception Mr.Adnan");
	                System.out.println(" So...Transaction is being rolled back in PharmacyMedicineBill at execute()");
	               // con.rollback();
	                
	                return "error";
	            } catch(Exception ee) {
	                
	                ee.printStackTrace();
	                }
	            
		 }
		 
		}
		
		

		
		    finally {
		      
		        if (ps1!= null) {
		        	ps1.close();
		        }
		        if (ps2!= null) {
		        	ps2.close();
		        }
		        
		        if (ps3!= null) {
		        	ps3.close();
		        }
		        if (ps4!= null) {
		        	ps4.close();
		        }
		        if (ps5!= null) {
		        	ps5.close();
		        }
		        if (ps6!= null) {
		        	ps6.close();
		        } 
		        
		        con.setAutoCommit(true);
		        con.close();
		        session.invalidate();
		        //request.getParameterValues("officialIdsend")[0] = null;
		        
		    }
		
		
		
		
		
		
		
		
		
		return "s";
		
   }
}
