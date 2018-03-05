package store.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class ReagentComDAO {

	public void addReagentandCompany(ReagentCom reagentCom)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO REAGENT_COMPANY_INFO ( " +
 		"   REAGENT_ID, REAGENT_NAME," +
 		"   COMPANY_ID, REORDER_LEVEL, UNIT)  " +
 		" VALUES ( ?, ?, ?, ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			
			int parameterIndex = 1;
			
			statement.setLong(parameterIndex++, reagentCom.getReagentid());			
			statement.setString(parameterIndex++, reagentCom.getReagentname());
			statement.setLong(parameterIndex++, reagentCom.getCompanyid());
			statement.setLong(parameterIndex++, reagentCom.getReorder());
			statement.setString(parameterIndex++, reagentCom.getUnit());
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
	
	public void deleteReagentandCompany(Long reagentid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from REAGENT_COMPANY_INFO where REAGENT_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			int parameterIndex = 1;
			statement.setLong(parameterIndex++, reagentid);				
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
	
	public void updateReagentandCompany(ReagentCom reagentCom)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE REAGENT_COMPANY_INFO " +
 		" SET    REAGENT_NAME      = ?, " +
 		"       COMPANY_ID    = ?, " +
 		"       REORDER_LEVEL = ?, " +
 		"       UNIT          = ? " +
 		" WHERE  REAGENT_ID        = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);	
			int parameterIndex = 1;
			statement.setString(parameterIndex++, reagentCom.getReagentname());
			statement.setLong(parameterIndex++, reagentCom.getCompanyid());
			statement.setLong(parameterIndex++, reagentCom.getReorder());
			statement.setString(parameterIndex++, reagentCom.getUnit());
			statement.setLong(parameterIndex++, reagentCom.getReagentid());
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
	
	public List<ReagentCom> getAllReagentandCompanies() {		
		List<ReagentCom> reagentCompanies = new ArrayList<ReagentCom>();
		String sql="select reagent.REAGENT_ID,reagent.REAGENT_NAME,reagent.COMPANY_ID,com.COMPANY_NAME,reagent.REORDER_LEVEL,reagent.UNIT " +
		" from REAGENT_COMPANY com, REAGENT_COMPANY_INFO reagent " +
		" where reagent.COMPANY_ID=com.COMPANY_ID " +
		" order by reagent.REAGENT_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				ReagentCom reagentCom = new ReagentCom();
				reagentCom.setReagentid(r.getLong("REAGENT_ID"));
				reagentCom.setReagentname(r.getString("REAGENT_NAME"));
				reagentCom.setCompanyid(r.getLong("COMPANY_ID"));
				reagentCom.setCompanyname(r.getString("COMPANY_NAME"));
				reagentCom.setReorder(r.getLong("REORDER_LEVEL"));
				reagentCom.setUnit(r.getString("UNIT"));
				reagentCompanies.add(reagentCom);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return reagentCompanies;
	}
	
	
	public ReagentCom getReagentById(Long reagentid) {		
		
		String sql="select reagent.REAGENT_ID,reagent.REAGENT_NAME,reagent.COMPANY_ID,com.COMPANY_NAME,reagent.REORDER_LEVEL,reagent.UNIT " +
		" from REAGENT_COMPANY com, REAGENT_COMPANY_INFO reagent " +
		" where reagent.COMPANY_ID=com.COMPANY_ID " +
		" and reagent.REAGENT_ID="+reagentid+"";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ReagentCom reagentCom = new ReagentCom();		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {				
				reagentCom.setReagentid(r.getLong("REAGENT_ID"));
				reagentCom.setReagentname(r.getString("REAGENT_NAME"));
				reagentCom.setCompanyid(r.getLong("COMPANY_ID"));
				reagentCom.setCompanyname(r.getString("COMPANY_NAME"));
				reagentCom.setReorder(r.getLong("REORDER_LEVEL"));
				reagentCom.setUnit(r.getString("UNIT"));
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return reagentCom;
	}
	
	
}
