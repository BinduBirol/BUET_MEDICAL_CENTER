package store.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class ReagentDAO {
	
	public void addReagent(Reagent reagent)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO REAGENT_INFO ( " +
 		"   REAGENT_ID, REAGENT_NAME  )" + 		
 		" VALUES ( ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);			
			statement.setLong(1, reagent.getReagentid());			
			statement.setString(2, reagent.getReagentname());
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
	
	public void deleteReagent(Long reagentid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from REAGENT_INFO where REAGENT_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, reagentid);				
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
	
	public void updateReagent(Reagent reagent)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE REAGENT_INFO " +
 		" SET    REAGENT_NAME      = ? " +
 		" WHERE  REAGENT_ID      = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);						
			statement.setString(1, reagent.getReagentname() );
			statement.setLong(2, reagent.getReagentid());			
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
	
	public List<Reagent> getAllReagents() {		
		List<Reagent> reagents = new ArrayList<Reagent>();
		String sql="select  REAGENT_ID, REAGENT_NAME " +
		" from REAGENT_INFO order by REAGENT_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				Reagent reagent = new Reagent();				
				reagent.setReagentid(r.getLong("REAGENT_ID"));
				reagent.setReagentname(r.getString("REAGENT_NAME"));				
				reagents.add(reagent);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return reagents;
	}
	
	
	public Reagent getReagentById(Long reagentid) {		
		
		String sql="select REAGENT_ID, REAGENT_NAME " +
		" from REAGENT_INFO  " +
		" where REAGENT_ID="+reagentid+" ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Reagent reagent = new Reagent();		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {			
				reagent.setReagentid(r.getLong("REAGENT_ID"));
				reagent.setReagentname(r.getString("REAGENT_NAME"));				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return reagent;
	}
	
}
