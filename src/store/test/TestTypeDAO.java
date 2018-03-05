package store.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class TestTypeDAO {

	public void addTestType(TestTypeDTO test)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO MCENTER.TESTTYPE ( " +
 		"   TESTTYPEID, TESTTYPENAME)" +
 		" VALUES ( ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setString(1, test.getTestTypeID());			
			statement.setString(2, test.getTestType());
			
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
	
	public void deleteTestType(String testTypeID)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from MCENTER.TESTTYPE where TESTTYPEID=? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setString(1,testTypeID);
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
	
	public void updateTestType(TestTypeDTO test)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE MCENTER.TESTTYPE " +
 		" SET    TESTTYPENAME      = ? " +
 		" WHERE TESTTYPEID        = ?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);	
			statement.setString(1, test.getTestType());
			statement.setString(2, test.getTestTypeID());
			
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
	
	public List<TestTypeDTO> getAllTestTypes() {		
		ArrayList<TestTypeDTO> testTypelist=new ArrayList<TestTypeDTO>();
		String sql="SELECT TESTTYPEID, TESTTYPENAME " +
				"    FROM MCENTER.TESTTYPE " +
				"ORDER BY TESTTYPEID ASC " ;
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				TestTypeDTO test=new TestTypeDTO();
				
				test.setTestTypeID(rs.getString(1));
				test.setTestType(rs.getString(2));
				
				testTypelist.add(test);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return testTypelist;
	}
	
	
	/*public Medicine getMedicineById(Long medid) {		
		
		String sql="select mi.MED_ID,mi.MED_NAME,mi.GEN_ID,gen.GEN_NAME,mi.COMPANY_ID,com.COMPANY_NAME,mi.REORDER_LEVEL,mi.UNIT " +
		" from MC_COMPANY com, MC_GENERIC gen, MEDICINE_INFO mi " +
		" where mi.COMPANY_ID=com.COMPANY_ID " +
		" and mi.GEN_ID=gen.GEN_ID " +
		" and mi.med_id="+medid+"";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Medicine med = new Medicine();		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {				
				med.setMedid(r.getLong("MED_ID"));
				med.setMedname(r.getString("MED_NAME"));
				med.setGenid(r.getLong("GEN_ID"));
				med.setGenname(r.getString("GEN_NAME"));
				med.setCompanyid(r.getLong("COMPANY_ID"));
				med.setCompanyname(r.getString("COMPANY_NAME"));
				med.setReorder(r.getLong("REORDER_LEVEL"));
				med.setUnit(r.getString("UNIT"));
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return med;
	}*/
	
	
}
