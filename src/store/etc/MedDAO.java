package store.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class MedDAO {

	public void addMedicine(Medicine med)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO MEDICINE_INFO ( " +
 		"   MED_ID, MED_NAME, GEN_ID,  " +
 		"   COMPANY_ID, REORDER_LEVEL, UNIT)  " +
 		" VALUES ( ?, ?, ?, ?, ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, med.getMedid());			
			statement.setString(2, med.getMedname());
			statement.setLong(3, med.getGenid());
			statement.setLong(4, med.getCompanyid());
			statement.setLong(5, med.getReorder());
			statement.setString(6, med.getUnit());
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
	
	public void deleteMedicine(Long medid)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="delete from MEDICINE_INFO where MED_ID=?";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, medid);				
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
	
	public void updateMedicine(Medicine med)
	{
		Connection conn = ConnectionManager.getConnection();
 		String sql="UPDATE MEDICINE_INFO " +
 		" SET    MED_NAME      = ?, " +
 		"       GEN_ID        = ?, " +
 		"       COMPANY_ID    = ?, " +
 		"       REORDER_LEVEL = ?, " +
 		"       UNIT          = ? " +
 		" WHERE  MED_ID        = ? ";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);						
			statement.setString(1, med.getMedname());
			statement.setLong(2, med.getGenid());
			statement.setLong(3, med.getCompanyid());
			statement.setLong(4, med.getReorder());
			statement.setString(5, med.getUnit());
			statement.setLong(6, med.getMedid());
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
	
	public List<Medicine> getAllMedicines() {		
		List<Medicine> medicines = new ArrayList<Medicine>();
		String sql="select mi.MED_ID,mi.MED_NAME,mi.GEN_ID,gen.GEN_NAME,mi.COMPANY_ID,com.COMPANY_NAME,mi.REORDER_LEVEL,mi.UNIT " +
		" from MC_COMPANY com, MC_GENERIC gen, MEDICINE_INFO mi " +
		" where mi.COMPANY_ID=com.COMPANY_ID " +
		" and mi.GEN_ID=gen.GEN_ID " +
		" order by mi.MED_ID ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
				
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				Medicine med = new Medicine();
				med.setMedid(r.getLong("MED_ID"));
				med.setMedname(r.getString("MED_NAME"));
				med.setGenid(r.getLong("GEN_ID"));
				med.setGenname(r.getString("GEN_NAME"));
				med.setCompanyid(r.getLong("COMPANY_ID"));
				med.setCompanyname(r.getString("COMPANY_NAME"));
				med.setReorder(r.getLong("REORDER_LEVEL"));
				med.setUnit(r.getString("UNIT"));
				medicines.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return medicines;
	}
	
	
	public Medicine getMedicineById(Long medid) {		
		
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
	}
	
	
}
