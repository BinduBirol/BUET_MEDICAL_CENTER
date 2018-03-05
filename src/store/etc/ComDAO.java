package store.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class ComDAO {

	
	public void addCompany(Company com)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO MC_COMPANY ( " +
 		"   COMPANY_ID, COMPANY_NAME  )" + 		
 		" VALUES ( ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);			
			statement.setLong(1, com.getCompanyid());			
			statement.setString(2, com.getCompanyname());
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	
	public void addReagentCompany(Company com)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO REAGENT_COMPANY ( " +
 		"   COMPANY_ID, COMPANY_NAME  )" + 		
 		" VALUES ( ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);			
			statement.setLong(1, com.getCompanyid());			
			statement.setString(2, com.getCompanyname());
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	public void deleteCompany(Long companyid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from MC_COMPANY where COMPANY_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, companyid);				
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	
	public void deleteReagentCompany(Long companyid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from REAGENT_COMPANY where COMPANY_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, companyid);				
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	public void updateCompany(Company com)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE MC_COMPANY " +
 		" SET    COMPANY_NAME      = ? " +
 		" WHERE  COMPANY_ID      = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);						
			statement.setString(1, com.getCompanyname());
			statement.setLong(2, com.getCompanyid());			
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	public void updateReagentCompany(Company com)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE REAGENT_COMPANY " +
 		" SET    COMPANY_NAME      = ? " +
 		" WHERE  COMPANY_ID      = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);						
			statement.setString(1, com.getCompanyname());
			statement.setLong(2, com.getCompanyid());			
			statement.executeUpdate();					
			
			conn.setAutoCommit(true);
			conn.commit();
		} catch (Exception e)
		{
			try
			{
				statement.close();
				conn.rollback();
				ConnectionManager.closeConnection(conn);
				e.printStackTrace();
				
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		} 				
		
	}
	
	public List<Company> getAllCompanies() {		
		List<Company> companies = new ArrayList<Company>();
		String sql="select  COMPANY_ID, COMPANY_NAME " +
		" from MC_COMPANY order by COMPANY_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				Company med = new Company();				
				med.setCompanyid(r.getLong("COMPANY_ID"));
				med.setCompanyname(r.getString("COMPANY_NAME"));				
				companies.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return companies;
	}
	
	public List<Company> getAllReagentCompanies() {		
		List<Company> companies = new ArrayList<Company>();
		String sql="select  COMPANY_ID, COMPANY_NAME " +
		" from REAGENT_COMPANY order by COMPANY_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				Company med = new Company();				
				med.setCompanyid(r.getLong("COMPANY_ID"));
				med.setCompanyname(r.getString("COMPANY_NAME"));				
				companies.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return companies;
	}
	
	
	public Company getCompanyById(Long companyid) {		
		
		String sql="select COMPANY_ID, COMPANY_NAME " +
		" from MC_COMPANY  " +
		" where COMPANY_ID="+companyid+" ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Company med = new Company();		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {			
				med.setCompanyid(r.getLong("COMPANY_ID"));
				med.setCompanyname(r.getString("COMPANY_NAME"));				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return med;
	}
	
	
	
}
