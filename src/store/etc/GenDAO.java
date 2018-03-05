package store.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class GenDAO {
	
	public void addGeneric(Generic gen)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO MC_GENERIC ( " +
 		"   GEN_ID, GEN_NAME  )" + 		
 		" VALUES ( ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);			
			statement.setLong(1, gen.getGenid());			
			statement.setString(2, gen.getGenname());
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
	
	public void deleteGeneric(Long genid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from MC_GENERIC where GEN_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, genid);				
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
	
	public void updateGeneric(Generic gen)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE MC_GENERIC " +
 		" SET    GEN_NAME      = ? " +
 		" WHERE  GEN_ID      = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);						
			statement.setString(1, gen.getGenname() );
			statement.setLong(2, gen.getGenid());			
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
	
	public List<Generic> getAllGenerics() {		
		List<Generic> generics = new ArrayList<Generic>();
		String sql="select  GEN_ID, GEN_NAME " +
		" from MC_GENERIC order by GEN_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				Generic med = new Generic();				
				med.setGenid(r.getLong("GEN_ID"));
				med.setGenname(r.getString("GEN_NAME"));				
				generics.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return generics;
	}
	
	
	public Generic getGenericById(Long genid) {		
		
		String sql="select GEN_ID, GEN_NAME " +
		" from MC_GENERIC  " +
		" where GEN_ID="+genid+" ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Generic med = new Generic();		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {			
				med.setGenid(r.getLong("GEN_ID"));
				med.setGenname(r.getString("GEN_NAME"));				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return med;
	}
	
}
