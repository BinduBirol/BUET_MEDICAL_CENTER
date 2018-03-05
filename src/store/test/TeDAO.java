package store.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class TeDAO {

	public void addTest(TestDTO test)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO MCENTER.TESTS ( " +
 		"   TESTTYPEID, TESTID,TESTNAME,  " +
 		"   VAT,RATE,STATUS)  " +
 		" VALUES ( ?, ?, ?, ?, ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setString(1, test.getTestTypeID());			
			statement.setString(2, test.getTestNameID());
			statement.setString(3, test.getTestName());
			statement.setDouble(4, test.getVat());
			statement.setDouble(5, test.getRate());
			statement.setString(6, test.getStatus());
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
	
	public void deleteTest(String testNameID)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from MCENTER.TESTS where TESTID=? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			
			//statement.setString(1,testTypeID);
			statement.setString(1,testNameID);
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
	
	public void updateTest(TestDTO test)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE MCENTER.TESTS " +
 		" SET    TESTNAME      = ?, " +
 		"       RATE        = ?, " +
 		"       VAT    = ?, " +
 		"       STATUS = ? " +
 		" WHERE  TESTTYPEID        = ? " +
 		" and  TESTID        = ?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);	
			statement.setString(1, test.getTestName());
			statement.setDouble(2, test.getRate());
			statement.setDouble(3, test.getVat());
			statement.setString(4, test.getStatus());
			statement.setString(5, test.getTestTypeID());			
			statement.setString(6, test.getTestNameID());
			
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
	
	public List<TestDTO> getAllTests() {		
		ArrayList<TestDTO> testlist=new ArrayList<TestDTO>();
		String sql="SELECT MCENTER.TESTTYPE.TESTTYPEID,TESTTYPENAME,TESTID, " +
				"         TESTNAME, " +
				"         VAT, " +
				"         RATE,STATUS  " +
				"    FROM MCENTER.TESTS, MCENTER.TESTTYPE " +
				"   WHERE MCENTER.TESTS.TESTTYPEID  = MCENTER.TESTTYPE.TESTTYPEID " +
				"GROUP BY MCENTER.TESTTYPE.TESTTYPEID,TESTTYPENAME,TESTID, " +
				"         TESTNAME, " +
				"         VAT, " +
				"         RATE ,STATUS " +
				"ORDER BY MCENTER.TESTTYPE.TESTTYPEID " ;
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet rs = null;
				
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
                TestDTO test=new TestDTO();
				
				test.setTestTypeID(rs.getString(1));
				test.setTestType(rs.getString(2));
				test.setTestNameID(rs.getString(3));
				test.setTestName(rs.getString(4));
				test.setVat(rs.getDouble(5));
				test.setRate(rs.getDouble(6));
				test.setStatus(rs.getString(7));
				testlist.add(test);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return testlist;
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
