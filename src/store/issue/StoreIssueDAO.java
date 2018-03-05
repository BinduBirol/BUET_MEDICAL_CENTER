package store.issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


import util.ConnectionUtil.ConnectionManager;

public class StoreIssueDAO {

	
	public String formatCurrency(Double value){
		DecimalFormat formatter = new DecimalFormat("0.00");
		String formattedValue = formatter.format(value);
		String integral = formattedValue.replaceAll("\\D\\d++", "");
		String fraction = formattedValue.replaceAll("\\d++\\D", "");
		if(integral.length() <= 3) return formattedValue;
		char lastDigitOfIntegral = integral.charAt(integral.length()-1);
		integral = integral.replaceAll("\\d$", "");
		return integral.replaceAll("(?<=.)(?=(?:\\d{2})+$)", ",")+
		lastDigitOfIntegral+"."+fraction;
	}
	
	public long getMaxIssueNo()
    {	       
        long vou=0l;
        Connection conn = ConnectionManager.getConnection();	
        
        String sql =" select nvl(max(issue_no),300000)+1 from CS_ISSUE_SUMMARY";
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
	
	
	public Map<Integer,String> getLotNumber() {
		
		
		String sql="select distinct LOT_NUMBER from CS_STORE where QUANTITY>0 ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		Map<Integer,String> maplotno = new TreeMap<Integer,String>(); 
						
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {
				maplotno.put(Integer.parseInt(r.getString("LOT_NUMBER")), r.getString("LOT_NUMBER"));				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		return maplotno;
	}
	
	
	
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
		
		
		String sql="select mi.med_id,med_name " +
		" from MEDICINE_INFO mi, CS_STORE cs " +
		" where mi.MED_ID=cs.MED_ID " +
		" and LOT_NUMBER=(select min(LOT_NUMBER) from  CS_STORE where med_id=mi.MED_ID and QUANTITY>0) ";
		
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
 
 	
 	public Map<Integer,String> getSelectMedicine(String gen) {
		
		
		String sql="select mi.med_id,med_name " +
		" from MEDICINE_INFO mi, CS_STORE cs " +
		" where mi.MED_ID=cs.MED_ID " +
		" and LOT_NUMBER=(select min(LOT_NUMBER) from  CS_STORE where med_id=mi.MED_ID and QUANTITY>0) ";
		
		if(!gen.equalsIgnoreCase("-1"))
			sql +=" and mi.gen_id='"+gen+"'";
		
		
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
	
 	public String getThreeItem(String med) {
		
		
		String sql="select LOT_NUMBER,QUANTITY,unit_price,to_char(EXPIRE_DATE,'dd/mm/yyyy') EXPIRE_DATE" +
		" from CS_STORE where med_id='"+med+"' " +
		" and LOT_NUMBER=(select min(LOT_NUMBER) from  CS_STORE where med_id='"+med+"' and QUANTITY>0 and TRUNC (SYSDATE)<=EXPIRE_DATE) ";
		
		
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		String threeitem="";
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {				
				
				threeitem = r.getString("LOT_NUMBER")+"@"+ r.getString("QUANTITY")+"@"+ r.getString("unit_price")+"@"+ r.getString("EXPIRE_DATE");
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return threeitem;
	}
 	
 	public boolean insertIssue(Long issueno, String issuedate, String remarks,
 		Long[] genid, Long[] medid,String[] expireDate,String[] lotnumber, double[] unitprice,Long[] stock, Long[] issueqty )
 	{
 		Connection conn = ConnectionManager.getConnection(); 		
 		String sql="INSERT INTO CS_ISSUE_SUMMARY ( " +
 		"   ISSUE_NO, ISSUE_DATE, REMARKs)  " +
 		"VALUES ( ?, to_date(?,'dd/mm/yyyy'), ?) ";

 		PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			statement.setLong(1, issueno);
			statement.setString(2, issuedate);			
			statement.setString(3, remarks);
			statement.executeUpdate();
						
			if(!insertIssueDetails(issueno, genid, medid,expireDate, lotnumber, unitprice, stock, issueqty, conn))
				return false;
			
			if(!updateSubStore(medid,expireDate, issueqty, unitprice, conn))
				return false;
			
			if(!updateCStoreIssue(lotnumber, medid, issueqty, conn))
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
 	
 	
 	public boolean insertIssueDetails(Long issueno, Long[] genid, Long[] medid,String[] expireDate,String[] lotnumber, double[] unitprice, Long[] stock, Long[] issueqty, Connection conn)
 	{
 		String sql = "INSERT INTO CS_ISSUE_DETAIL ( " +
 		"   ISSUE_NO, GEN_ID, MED_ID, LOT_NUMBER, UNIT_PRICE, STOCK, ISSUE_QTY,EXPIRE_DATE)  " +
 		"VALUES ( ?, ?, ?, ?, ?, ?, ?,to_date( ?,'dd/mm/yyyy')) ";
 		PreparedStatement statement = null;
 		
 		try
		{
			statement = conn.prepareStatement(sql);

			for (int i = 0; i < medid.length; i++)
			{
				statement.setLong(1, issueno);
				statement.setLong(2, genid[i]);
				statement.setLong(3, medid[i]);				
				statement.setString(4, lotnumber[i]);
				statement.setDouble(5, unitprice[i]);				
				statement.setLong(6, stock[i]);				
				statement.setLong(7, issueqty[i]);
				statement.setString(8, expireDate[i]);
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
 	
 	
 	public boolean updateSubStore(Long[] medid,String[] expireDate,Long[] issueqty, double[] unitprice, Connection conn)
 	{
 		String sqlI = "INSERT INTO SUB_STORE ( " +
 		"   MED_ID, QUANTITY,  " +
 		"   UNITPRICE,EXPIRE_DATE)  " +
 		"VALUES ( ?, ?, ?, to_date( ?,'dd/mm/yyyy')) ";
 		
 		String sqlU = "UPDATE SUB_STORE " +
 		" SET    QUANTITY   = QUANTITY+? ," +
 		"       UNITPRICE = ? ," +
 		"       EXPIRE_DATE =to_date( ?,'dd/mm/yyyy') " +
 		" where MED_ID     = ? ";
 		
 		PreparedStatement statementI = null;
 		PreparedStatement statementU = null;
 		
 		try
		{
			statementI = conn.prepareStatement(sqlI);
			statementU = conn.prepareStatement(sqlU);

	 		for (int i = 0; i < medid.length; i++)
			{
	 			int cnt = findSubInventory(medid[i]);
	 			
	 			if(cnt==0)
				{	 					 				
	 				statementI.setLong(1, medid[i]);	 				
	 				statementI.setLong(2, issueqty[i]);
	 				statementI.setDouble(3, unitprice[i]);
	 				statementI.setString(4, expireDate[i]);	
	 				statementI.executeUpdate();
				}
	 			else
	 			{	 				
	 				statementU.setLong(1, issueqty[i]);
	 				statementU.setDouble(2, unitprice[i]);	 				
	 				statementU.setString(3, expireDate[i]);
	 				statementU.setLong(4, medid[i]);
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
	static String sSql="select count(*) from SUB_STORE " +
	        			" where MED_ID=? ";
	        			
	
	static PreparedStatement sPs = null;
 	public static synchronized int findSubInventory(Long medid)
	{
		ResultSet r = null;
		int cnt = 0;
		try{
			if(sConn==null || sConn.isClosed())
				sConn=ConnectionManager.getConnection();
			if(sPs==null)
				sPs = sConn.prepareStatement(sSql);
			sPs.setLong(1, medid);			
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
 	
 	
 	public boolean updateCStoreIssue(String[] lotnumber, Long[] medid, Long[] issueqty, Connection conn)
 	{
 		 		
 		String sqlU = "UPDATE CS_STORE " +
 		" SET    QUANTITY   = QUANTITY-? " +
 		" where MED_ID     = ? " +
 		" and   LOT_NUMBER = ? ";
 		
 		PreparedStatement statementU = null;
 		
 		try
		{
			statementU = conn.prepareStatement(sqlU);

	 		for (int i = 0; i < medid.length; i++)
			{	 						
 				statementU.setLong(1, issueqty[i]); 				
 				statementU.setLong(2, medid[i]);
 				statementU.setString(3, lotnumber[i]);	 									
 				statementU.executeUpdate();	 			
			}
		} catch (Exception e)
		{
			try
			{
				e.printStackTrace();				
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
				statementU.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			statementU = null;
		}
	 		
	 	
 		return true;
 	}
 	
 	
 	public ArrayList<StoreIssueDetail> getStoreIssueDetail(Long issueno)
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<StoreIssueDetail> sdList= new ArrayList<StoreIssueDetail>();
				
		String sql="select cd.GEN_ID,gen.GEN_NAME, cd.MED_ID,mi.MED_NAME, " +
		" cd.ISSUE_QTY ,cd.UNIT_PRICE,cd.LOT_NUMBER,cd.STOCK  " +
		" from CS_ISSUE_DETAIL cd,MEDICINE_INFO mi, MC_GENERIC gen  " +
		" where cd.GEN_ID=gen.GEN_ID  " +
		" and cd.MED_ID=mi.MED_ID  " +
		" and cd.ISSUE_NO = "+issueno+" ";

		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				StoreIssueDetail sd = new StoreIssueDetail();				
				sd.setGenid(r.getLong("GEN_ID"));
				sd.setGenname(r.getString("GEN_NAME"));
				sd.setMedid(r.getLong("MED_ID"));
				sd.setMedname(r.getString("MED_NAME"));
				sd.setIssueqty(r.getLong("ISSUE_QTY"));
				sd.setUnitprice(r.getDouble("UNIT_PRICE"));
				sd.setLotnumber(r.getString("LOT_NUMBER"));
				sd.setStock(r.getLong("STOCK"));
				sdList.add(sd);				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
						
		return sdList;
 	}
 	
 	public ArrayList<StoreIssue> getIssueSummaryList()
 	{
 		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<StoreIssue> sdList= new ArrayList<StoreIssue>();
		
		String sql="select issue_no, to_char(issue_date,'dd/mm/yyyy')  issuedate, remarks " +
		" from CS_ISSUE_SUMMARY  order by issue_no desc ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				StoreIssue sd = new StoreIssue();
				sd.setIssueno(r.getLong("issue_no"));
				sd.setIssuedate(r.getString("issuedate"));				
				sd.setRemarks(r.getString("remarks"));	
				sdList.add(sd);
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
			
			
		return sdList;
 	}
 	
 	
	
}
