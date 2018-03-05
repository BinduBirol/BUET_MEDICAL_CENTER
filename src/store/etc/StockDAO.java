package store.etc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionUtil.ConnectionManager;

public class StockDAO {
	
	
	public List<Medicine> getAllMedicineStock() {		
		List<Medicine> medicines = new ArrayList<Medicine>();
		String sql="select com.COMPANY_ID,com.COMPANY_NAME,gen.GEN_ID,gen.GEN_NAME,  " +
		" cd.MED_ID,mi.MED_NAME,cd.QUANTITY,cd.UNIT_PRICE, cd.LOT_NUMBER,to_char(cd.EXPIRE_DATE,'dd/mm/yyyy') EXPIRE_DATE  " +
		" from CS_STORE cd,MEDICINE_INFO mi,  " +
		" MC_COMPANY com,MC_GENERIC gen  " +
		" where mi.COMPANY_ID=com.COMPANY_ID  " +
		" and mi.GEN_ID=gen.GEN_ID  " +
		" and cd.MED_ID=mi.MED_ID  " +
		" and cd.QUANTITY>0 " +
		" order by gen_id,cd.MED_ID,com.COMPANY_ID,cd.LOT_NUMBER ";
		
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
				med.setLotnumber(r.getString("LOT_NUMBER"));
				med.setQuantity(r.getLong("QUANTITY"));
				med.setUnitprice(r.getDouble("UNIT_PRICE"));
				med.setExpireDate(r.getString("EXPIRE_DATE"));
				medicines.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return medicines;
	}
	
	public List<Medicine> getAllExpiredMedicineStock() {		
		List<Medicine> medicines = new ArrayList<Medicine>();
		String sql="select com.COMPANY_ID,com.COMPANY_NAME,gen.GEN_ID,gen.GEN_NAME,  " +
		" cd.MED_ID,mi.MED_NAME,cd.QUANTITY,cd.UNIT_PRICE, cd.LOT_NUMBER,to_char(cd.EXPIRE_DATE,'dd/mm/yyyy') EXPIRE_DATE  " +
		" from CS_STORE cd,MEDICINE_INFO mi,  " +
		" MC_COMPANY com,MC_GENERIC gen  " +
		" where mi.COMPANY_ID=com.COMPANY_ID  " +
		" and mi.GEN_ID=gen.GEN_ID  " +
		" and cd.MED_ID=mi.MED_ID  " +
		" and cd.QUANTITY>0 and TRUNC (SYSDATE)>cd.EXPIRE_DATE  " +
		" order by gen_id,cd.MED_ID,com.COMPANY_ID,cd.LOT_NUMBER ";
		
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
				med.setLotnumber(r.getString("LOT_NUMBER"));
				med.setQuantity(r.getLong("QUANTITY"));
				med.setUnitprice(r.getDouble("UNIT_PRICE"));
				med.setExpireDate(r.getString("EXPIRE_DATE"));
				medicines.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return medicines;
	}
	
	
	
	public List<Medicine> getAllMedicineLocalStock() {		
		List<Medicine> medicines = new ArrayList<Medicine>();
		String sql="select com.COMPANY_ID,com.COMPANY_NAME,gen.GEN_ID,gen.GEN_NAME,   " +
				" cd.MED_ID,mi.MED_NAME,cd.QUANTITY,CD.UNITPRICE,to_char(cd.EXPIRE_DATE,'dd/mm/yyyy') EXPIRE_DATE " +
				" from Sub_STORE cd,MEDICINE_INFO mi,   " +
				" MC_COMPANY com,MC_GENERIC gen   " +
				" where mi.COMPANY_ID=com.COMPANY_ID   " +
				" and mi.GEN_ID=gen.GEN_ID   " +
				" and cd.MED_ID=mi.MED_ID   " +
				" and cd.QUANTITY>0  " +
				" order by gen_id,cd.MED_ID,com.COMPANY_ID " ;
		
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
				med.setQuantity(r.getLong("QUANTITY"));
				med.setUnitprice(r.getDouble("UNITPRICE"));
				med.setExpireDate(r.getString("EXPIRE_DATE"));
				medicines.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return medicines;
	}
	
	
	public List<Medicine> getAllExpiredMedicineLocalStock() {		
		List<Medicine> medicines = new ArrayList<Medicine>();
		String sql="select com.COMPANY_ID,com.COMPANY_NAME,gen.GEN_ID,gen.GEN_NAME,   " +
				" cd.MED_ID,mi.MED_NAME,cd.QUANTITY,CD.UNITPRICE,to_char(cd.EXPIRE_DATE,'dd/mm/yyyy') EXPIRE_DATE " +
				" from Sub_STORE cd,MEDICINE_INFO mi,   " +
				" MC_COMPANY com,MC_GENERIC gen   " +
				" where mi.COMPANY_ID=com.COMPANY_ID   " +
				" and mi.GEN_ID=gen.GEN_ID   " +
				" and cd.MED_ID=mi.MED_ID   " +
				" and cd.QUANTITY>0 and TRUNC (SYSDATE)>cd.EXPIRE_DATE " +
				" order by gen_id,cd.MED_ID,com.COMPANY_ID " ;
		
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
				med.setQuantity(r.getLong("QUANTITY"));
				med.setUnitprice(r.getDouble("UNITPRICE"));
				med.setExpireDate(r.getString("EXPIRE_DATE"));
				medicines.add(med);
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return medicines;
	}
	
}
