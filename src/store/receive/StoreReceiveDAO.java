package store.receive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import util.ConnectionUtil.ConnectionManager;



public class StoreReceiveDAO {
	
	
	public Map<Integer,String> getAllCompany() {
		
		
		String sql="select company_id, company_name from MC_COMPANY order by company_id";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Map<Integer,String> mapcompany = new TreeMap<Integer,String>(); 
		
		//Map<Integer,String> mapcompany = new TreeMap<Integer,String>(Collections.reverseOrder()); 
		
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				mapcompany.put(r.getInt("company_id"), r.getString("company_name"));		
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		//Map<Integer, String> treeMap = new TreeMap<Integer, String>(mapcompany);
		return mapcompany;
	}

	
 public Map<Integer,String> getAllGeneric() {
		
		
		String sql="select gen_id, gen_name from MC_GENERIC order by gen_id";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Map<Integer,String> mapgeneric = new TreeMap<Integer,String>(); 
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				mapgeneric.put(r.getInt("gen_id"), r.getString("gen_name"));		
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return mapgeneric;
	}
	
	
 	public Map<Integer,String> getAllMedicine() {
		
		
		String sql="select med_id,med_name from MEDICINE_INFO order by med_id";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Map<Integer,String> mapmedicine = new TreeMap<Integer,String>(); 
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				mapmedicine.put(r.getInt("med_id"), r.getString("med_name"));		
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return mapmedicine;
	}
 
 	
 	public Map<Integer,String> getSelectMedicine(String comp, String gen) {
		
		
		String sql="select med_id,med_name from MEDICINE_INFO " +
				"  where 1=1 ";
		if(!comp.equalsIgnoreCase("-1"))
			sql +=" and company_id='"+comp+"'";
		
		if(!gen.equalsIgnoreCase("-1"))
			sql +=" and gen_id='"+gen+"'";
		
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Map<Integer,String> mapmedicine = new TreeMap<Integer,String>(); 
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				mapmedicine.put(r.getInt("med_id"), r.getString("med_name"));		
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return mapmedicine;
	}

 	public long getMaxReceiveNo()
    {	       
        long vou=0l;
        Connection conn = ConnectionManager.getConnection();	
        
        String sql =" select nvl(max(recive_no),100000)+1 from CS_RECEIVE_SUMMARY";
        ResultSet r = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            r = stmt.executeQuery(sql);
            while (r.next()) {
            	vou=r.getLong(1);	            	
            }
        } catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
        return vou;
    }  
 	
 	
 	public boolean insertReceive(Long receiveno, String receivedate, String billno, String billdate, String lotnumber, String remarks,
 			Long[] companyid, Long[] genid, Long[] medid,String expireDate[], Long[] receiveqty, double[] unitprice)
 	{
 		Connection conn = ConnectionManager.getConnection();
 		String sql="INSERT INTO CS_RECEIVE_SUMMARY ( " +
 		"   RECIVE_NO, RECIVE_DATE, BILL_NO,  " +
 		"   BILL_DATE, LOT_NUMBER, REMARKS)  " +
 		" VALUES ( ?, to_date(?,'dd/mm/yyyy'), ?, to_date(?,'dd/mm/yyyy'), ?, ?)";
 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, receiveno);
			statement.setString(2, receivedate);
			statement.setString(3, billno);
			statement.setString(4, billdate);
			statement.setString(5, lotnumber);
			statement.setString(6, remarks);
			statement.executeUpdate();
						
			if(!insertReceiveDetails(receiveno,lotnumber, companyid, genid, medid,expireDate,receiveqty, unitprice, conn))
				return false;
			
			if(!updateCStore(lotnumber, medid,expireDate,receiveqty, unitprice, conn))
				return false;
			
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
				return false;
			} catch (Exception e1){	e1.printStackTrace(); }
		}
		finally
		{
			try{statement.close(); ConnectionManager.closeConnection(conn);
			} catch (Exception e){ e.printStackTrace();	}
			statement = null;
		}
 		
 		return true;
 	}
 	
 	
 	public boolean insertReceiveDetails(Long receiveno,String lotnumber, Long[] companyid, Long[] genid, Long[] medid,String expireDate[], Long[] receiveqty, double[] unitprice, Connection conn)
 	{
 		String sql = "INSERT INTO CS_RECEIVE_DETAIL ( " +
 		"   RECEIVE_NO, LOT_NUMBER, COMPANY_ID,  " +
 		"   GEN_ID, MED_ID,EXPIRE_DATE, RECEIVE_QTY,  " +
 		"   UNIT_PRICE)  " +
 		" VALUES ( ?, ?, ?, ?, ?,to_date( ?,'dd/mm/yyyy'), ?, ?) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			statement = conn.prepareStatement(sql);

			for (int i = 0; i < medid.length; i++)
			{
				statement.setLong(1, receiveno);
				statement.setString(2, lotnumber);
				statement.setLong(3, companyid[i]);
				statement.setLong(4, genid[i]);
				statement.setLong(5, medid[i]);
				statement.setString(6, expireDate[i]);
				statement.setLong(7, receiveqty[i]);
				statement.setDouble(8, unitprice[i]);
				
				statement.executeUpdate();
			}

		} catch (Exception e)
		{
			try
			{
				e.printStackTrace();
				statement.close();
				conn.rollback();
				return false;
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}

		finally
		{
			try
			{
				statement.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			statement = null;
		}
 		
 		return true;
 	}
 	
 	
 	
 	
 	public boolean updateCStore(String lotnumber, Long[] medid,String expireDate[], Long[] receiveqty, double[] unitprice, Connection conn)
 	{
 		String sqlI = "INSERT INTO CS_STORE ( " +
 		"   MED_ID,EXPIRE_DATE, LOT_NUMBER, QUANTITY,  " +
 		"   UNIT_PRICE)  " +
 		"VALUES ( ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?) ";
 		
 		String sqlU = "UPDATE CS_STORE " +
 		" SET    QUANTITY   = QUANTITY+? ," +
 		"       EXPIRE_DATE = to_date(?,'dd/mm/yyyy')," +
 		"       UNIT_PRICE = ? " +
 		" where MED_ID     = ? " +
 		" and   LOT_NUMBER = ? ";
 		PreparedStatement statementI = null;
 		PreparedStatement statementU = null;
 		
 		try
		{
			statementI = conn.prepareStatement(sqlI);
			statementU = conn.prepareStatement(sqlU);

	 		for (int i = 0; i < medid.length; i++)
			{
	 			int cnt = findInventory(lotnumber,medid[i]);
	 			
	 			if(cnt==0)
				{	 					 				
	 				statementI.setLong(1, medid[i]);
	 				statementI.setString(2, expireDate[i]);
	 				statementI.setString(3, lotnumber);
	 				statementI.setLong(4, receiveqty[i]);
	 				statementI.setDouble(5, unitprice[i]);					
	 				statementI.executeUpdate();
				}
	 			else
	 			{	 				
	 				statementU.setLong(1, receiveqty[i]);
	 				statementU.setString(2, expireDate[i]);
	 				statementU.setDouble(3, unitprice[i]);
	 				statementU.setLong(4, medid[i]);
	 				statementU.setString(5, lotnumber);	 									
	 				statementU.executeUpdate();
	 			}
	 			
			}
		} catch (Exception e)
		{
			try
			{
				e.printStackTrace();
				statementI.close();
				statementU.close();
				conn.rollback();
				return false;
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}

		finally
		{
			try
			{
				statementI.close();
				statementU.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			statementI = null;
			statementU = null;
		}
	 		
	 	
 		return true;
 	}
 	
 	
 	
 	
 	static ConnectionManager sManager = null;
	static Connection sConn = null;
	static String sSql="select count(*) from CS_STORE " +
	        			" where MED_ID=? " +
	        			" and LOT_NUMBER=? ";
	
	static PreparedStatement sPs = null;
 	public static synchronized int findInventory(String lotnumber, Long medid)
	{
		ResultSet r = null;
		int cnt = 0;
		try{
			if(sConn==null || sConn.isClosed())
				sConn=ConnectionManager.getConnection();
			if(sPs==null)
				sPs = sConn.prepareStatement(sSql);
			sPs.setLong(1, medid);			
			sPs.setString(2, lotnumber);
			sPs.execute();
			sPs.clearParameters();
			
			r=sPs.getResultSet();
			if(r.next()){
				cnt=r.getInt(1);
			}
		}catch (SQLException e) {
			System.out.println(e.toString());
		}
		return cnt ;
	}
 		
 	
 	
 	public ArrayList<StoreReceiveDetail> getStoreDetail(Long receiveno)
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<StoreReceiveDetail> sdList= new ArrayList<StoreReceiveDetail>();
		String sql="select cd.COMPANY_ID,com.COMPANY_NAME,cd.GEN_ID,gen.GEN_NAME, " +
				" cd.MED_ID,mi.MED_NAME,cd.RECEIVE_QTY,cd.UNIT_PRICE " +
				" from CS_RECEIVE_DETAIL cd,MEDICINE_INFO mi, " +
				" MC_COMPANY com,MC_GENERIC gen " +
				" where cd.COMPANY_ID=com.COMPANY_ID " +
				" and cd.GEN_ID=gen.GEN_ID " +
				" and cd.MED_ID=mi.MED_ID " +
				" and cd.RECEIVE_NO="+receiveno+" ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				StoreReceiveDetail sd = new StoreReceiveDetail();
				sd.setCompanyid(r.getLong("COMPANY_ID"));
				sd.setCompanyname(r.getString("COMPANY_NAME"));
				sd.setGenid(r.getLong("GEN_ID"));
				sd.setGenname(r.getString("GEN_NAME"));
				sd.setMedid(r.getLong("MED_ID"));
				sd.setMedname(r.getString("MED_NAME"));
				sd.setReceiveqty(r.getLong("RECEIVE_QTY"));
				sd.setUnitprice(r.getDouble("UNIT_PRICE"));
				sdList.add(sd);
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	public StoreReceive getReceiveSummary(Long receiveno)
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		StoreReceive sd = new StoreReceive();
 		String sql="SELECT RECIVE_NO, to_char(RECIVE_DATE,'dd/mm/yyyy') RECIVE_DATE, BILL_NO,  " +
 		"   to_char(BILL_DATE,'dd/mm/yyyy') BILL_DATE, LOT_NUMBER, REMARKS " +
 		" FROM CS_RECEIVE_SUMMARY where RECIVE_NO="+receiveno+" ";
 		
 		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				
				sd.setReceiveno(r.getLong("RECIVE_NO"));
				sd.setReceivedate(r.getString("RECIVE_DATE"));				
				sd.setBillno(r.getString("BILL_NO"));			
				sd.setBilldate(r.getString("BILL_DATE"));
				sd.setLotnumber(r.getString("LOT_NUMBER"));
				sd.setRemarks(r.getString("REMARKS"));			
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return sd;
 	}

 	public ArrayList<StoreReceive> getReceiveSummaryList()
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<StoreReceive> sdList= new ArrayList<StoreReceive>();
		String sql="SELECT RECIVE_NO, to_char(RECIVE_DATE,'dd/mm/yyyy') RECIVE_DATE, BILL_NO,  " +
 		"   to_char(BILL_DATE,'dd/mm/yyyy') BILL_DATE, LOT_NUMBER, REMARKS " +
 		" FROM CS_RECEIVE_SUMMARY order by RECIVE_NO desc ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				StoreReceive sd = new StoreReceive();
				sd.setReceiveno(r.getLong("RECIVE_NO"));
				sd.setReceivedate(r.getString("RECIVE_DATE"));				
				sd.setBillno(r.getString("BILL_NO"));			
				sd.setBilldate(r.getString("BILL_DATE"));
				sd.setLotnumber(r.getString("LOT_NUMBER"));
				sd.setRemarks(r.getString("REMARKS"));	
				sdList.add(sd);
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	
 	
 	
}
