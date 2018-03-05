package com.prescription;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import util.ConnectionUtil.ConnectionManager;

import com.table.PatientDetailDTO;
import com.table.PrescripDTO;
import com.table.PrescriptionDTO;


public class PrescriptionDAO {


	public Long getMaxPresNo() {
		Long a = 0l;

		ResultSet r = null;
		Statement stmt = null;


		try {
/*			Connection con = ConnectionManager.getConnection();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter")*/;
			Connection conn = ConnectionManager.getConnection();  

			String sql = "  SELECT NVL(MAX(PRESCRIPTIONID), 100000000)+1" +
			"  FROM prescription";


			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {
				a = r.getLong(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}


	//cc	

	public ArrayList<PrescriptionDTO> showCCNames() {
		ArrayList list = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
/*			Connection con = ConnectionManager.getConnection();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			String sql = "select ccid,ccname from cc where ccid!='9999'  order by ccname asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setCcid(r.getString(1));
				pp.setCcname(r.getString(2));
				list.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	public ArrayList<PrescriptionDTO> getCctypeList(String ccid) {
		ArrayList list = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;


		try {
/*			Connection con = ConnectionManager.getConnection();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");*/

			Connection conn = ConnectionManager.getConnection(); 
			String sql = "select cctype.CCTYPEID,trim(cctype.cctype) cctype " +
			" from cc, cctype " +
			" where cctype.ccid=lpad('" + ccid + "',2,'0')" +
			" and cc.ccid=cctype.ccid " +
			" order by CCTYPE.CCTYPEID";


			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				PrescriptionDTO pt = new PrescriptionDTO();


				pt.setCctypeid(r.getString(1));
				pt.setCctype(r.getString(2));
				list.add(pt);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}

	
	
	public ArrayList<String>  getCC(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		//String [] cc =new String[10];
		ArrayList<String> cc=new ArrayList<String>();
		
		String sql= "select ' ' || decode(C.CCNAME,'Others','N',C.CCNAME)|| ' ' || "+
				" decode (CS.CCTYPEID,'No Subtype', '',CCTYPEID) || '  ' || CS.COMMENTS st"+
				" from CCSAVE cs, CC c"+
				" where CS.CCID=C.CCID and CS.PRESCRIPTIONID='"+prescriptionid+"' ";
		
		
		
		/*String sql="SELECT '* ' || DECODE (CC.CCID, '50', '', CC.CCNAME) || ' ' || DECODE (CCTYPE.CCID, '50', CCSAVE.CCTYPEID, CCTYPE.CCTYPE)  || '  ' || CCSAVE.COMMENTS\n" +
                "          st\n" +
                "  FROM CCSAVE, cc, cctype\n" +
                "WHERE     LPAD (CC.CCID, 2, '0') = LPAD (CCSAVE.CCID, 2, '0')\n" +
                "       AND LPAD (CCTYPE.CCID, 2, '0') || LPAD (CCTYPE.CCTYPEID, 2, '0') =\n" +
                "              DECODE (\n" +
                "                 CCSAVE.CCTYPEID,\n" +
                "                 'No Subtype', '9999',\n" +
                "                    LPAD (CCSAVE.CCID, 2, '0')\n" +
                "                 || DECODE (CCSAVE.CCID,\n" +
                "                            '50', '55',\n" +
                "                            LPAD (CCSAVE.CCTYPEID, 2, '0')))\n" +
                "       AND CCSAVE.PRESCRIPTIONID = "+prescriptionid+" ";*/
		
		
/*		String sql="select '* '||CC.CCNAME ||' '||CCTYPE.CCTYPE||'  '||CCSAVE.COMMENTS st  " +
				"	from CCSAVE,cc,cctype  " +
				"	where lpad(CC.CCID,2,'0')=lpad(CCSAVE.CCID,2,'0')  " +
				"	and lpad(CCTYPE.CCID,2,'0')||lpad(CCTYPE.CCTYPEID,2,'0')=decode(CCSAVE.CCTYPEID,'No Subtype','9999',lpad(CCSAVE.CCID,2,'0')||lpad(CCSAVE.CCTYPEID,2,'0'))  " +
				"	and CCSAVE.PRESCRIPTIONID ="+prescriptionid+" " ;*/
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			//int i=0;
			while (r.next()) {				
//				if(r.getString("st")!=null)
//					cc[i]=r.getString("st");
					cc.add(r.getString("st"));
				
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return cc;
	}
	
	
	
	public ArrayList<PrescriptionDTO>ccdisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> ccinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

/*			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/

			Connection conn = ConnectionManager.getConnection(); 
			
			
			
			String sql= "select decode(C.CCNAME,'Others','N',C.CCNAME) CCNAME,"+ 
					" decode (CS.CCTYPEID,'No Subtype', '',CCTYPEID) CCTYPEID, CS.COMMENTS"+
					" from CCSAVE cs, CC c"+
					" where CS.CCID=C.CCID and CS.PRESCRIPTIONID= '"+prescriptionid+"' ";
			
			
			/*String sql="SELECT DECODE (CC.CCID, '50', '', CC.CCNAME) CCNAME,\n" +
	                "       DECODE (CCTYPE.CCID, '50', CCSAVE.CCTYPEID, CCTYPE.CCTYPE) CCTYPE,\n" +
	                "       CCSAVE.COMMENTS COMMENTS\n" +
	                "  FROM CCSAVE, cc, cctype\n" +
	                " WHERE     LPAD (CC.CCID, 2, '0') = LPAD (CCSAVE.CCID, 2, '0')\n" +
	                "       AND LPAD (CCTYPE.CCID, 2, '0') || LPAD (CCTYPE.CCTYPEID, 2, '0') =\n" +
	                "              DECODE (\n" +
	                "                 CCSAVE.CCTYPEID,\n" +
	                "                 'No Subtype', '9999',\n" +
	                "                    LPAD (CCSAVE.CCID, 2, '0')\n" +
	                "                 || DECODE (CCSAVE.CCID,\n" +
	                "                            '50', '55',\n" +
	                "                            LPAD (CCSAVE.CCTYPEID, 2, '0')))\n" +
	                "       AND CCSAVE.PRESCRIPTIONID = "+prescriptionid+" ";*/
			
			
/*			String sql= "select CC.CCNAME CCNAME,CCTYPE.CCTYPE CCTYPE,CCSAVE.COMMENTS COMMENTS "+
					"from CCSAVE,cc,cctype "+
					"where lpad(CC.CCID,2,'0')=lpad(CCSAVE.CCID,2,'0') "+
					"and lpad(CCTYPE.CCID,2,'0')||lpad(CCTYPE.CCTYPEID,2,'0')=decode(CCSAVE.CCTYPEID,'No Subtype','9999',lpad(CCSAVE.CCID,2,'0')||lpad(CCSAVE.CCTYPEID,2,'0')) "+
					"and CCSAVE.PRESCRIPTIONID ="+prescriptionid+" ";*/



			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();

				pt.setCcname(r.getString("CCNAME"));
				pt.setCctype(r.getString("CCTYPEID"));
				pt.setComments(r.getString("COMMENTS"));  			




				ccinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return ccinfo;

	} 
//OE	

	public ArrayList<PrescriptionDTO> getOetypeList(String oeid) {
		ArrayList list = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;


		try {
/*			Connection con = ConnectionManager.getConnection();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");*/

			Connection conn = ConnectionManager.getConnection(); 
			
			String sql = "select OETYPE.OETYPEID,trim(OETYPE.OETYPE) OETYPE " +
			" from MCENTER.OE,MCENTER.OETYPE " +
			" where OETYPE.OEID=lpad('" + oeid + "',2,'0')" +
			" and OE.OEID=OETYPE.OEID " +
			" order by OETYPE.OETYPEID";


			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				PrescriptionDTO pt = new PrescriptionDTO();


				pt.setOetypeid(r.getString(1));
				pt.setOetype(r.getString(2));
				list.add(pt);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}
	

		public ArrayList<PrescriptionDTO> showOENames() {
			ArrayList oelist = new ArrayList();
			ResultSet r = null;
			Statement stmt = null;

			try {
/*				Connection con = ConnectionManager.getConnection();
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");*/
				Connection conn = ConnectionManager.getConnection(); 
				String sql = "select oeid,oename from oe order by oename asc";

				stmt = conn.createStatement();
				r = stmt.executeQuery(sql);

				while (r.next()) {
					PrescriptionDTO pp = new PrescriptionDTO();

					pp.setOeid(r.getString(1));
					pp.setOename(r.getString(2));
					oelist.add(pp);

				}

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return oelist;
		}


		public ArrayList<PrescriptionDTO>oedisplay(Long prescriptionid)
		{

			ArrayList<PrescriptionDTO> oeinfo = new ArrayList<PrescriptionDTO>();


			PreparedStatement stmt = null;
			ResultSet r = null;
			try
			{

/*				Connection con = ConnectionManager.getConnection();  
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
				Connection conn = ConnectionManager.getConnection(); 
				String sql="SELECT DECODE (OE.OEID, '50', '', OE.OENAME) OENAME,\n" +
                        "       OESAVE.OECOMMENTS OECOMMENTS\n" +
                        "  FROM OESAVE, OE\n" +
                        " WHERE     LPAD (OE.OEID, 2, '0') = LPAD (OESAVE.OEID, 2, '0')\n" +
                        "       AND OESAVE.PRESCRIPTIONID ="+prescriptionid+" ";
				
				
			/*	String sql= "select  OE.OENAME OENAME,OETYPE.OETYPE OETYPE,OESAVE.OECOMMENTS OECOMMENTS "+
						"from OESAVE,OE,OETYPE "+
						"where lpad(OE.OEID,2,'0')=lpad(OESAVE.OEID,2,'0') "+
						"and lpad(OETYPE.OEID,2,'0')||lpad(OETYPE.OETYPEID,2,'0')=decode(OESAVE.OETYPEID,'No Subtype','9999',lpad(OESAVE.OEID,2,'0')||lpad(OESAVE.OETYPEID,2,'0')) "+
						"and OESAVE.PRESCRIPTIONID= "+prescriptionid+" ";*/



				stmt = conn.prepareStatement(sql);


				r = stmt.executeQuery();
				System.out.println("Response : " + sql);

				while (r.next())
				{
					PrescriptionDTO pt = new PrescriptionDTO();


					pt.setOename(r.getString("OENAME"));
	//				pt.setOetype(r.getString("OETYPE"));
					pt.setOecomments(r.getString("OECOMMENTS"));    			

					oeinfo.add(pt);	
				}

				conn.close();
			}
			catch(Exception e)
			{e.printStackTrace();}

			return oeinfo;

		}   
		
		public ArrayList<String> getOE(Long prescriptionid)
		{
			
			Connection conn = ConnectionManager.getConnection();		
			Statement stmt = null;
			ResultSet r = null;
			ArrayList<String> oe =new ArrayList<String>();
			
			String sql="SELECT    ''\n" +
                    "       || DECODE (OE.OEID, '50', '', OE.OENAME)\n" +
                    "       || '  '\n" +
                    "       || OESAVE.OECOMMENTS\n" +
                    "          st\n" +
                    "  FROM OESAVE, OE\n" +
                    " WHERE     LPAD (OE.OEID, 2, '0') = LPAD (OESAVE.OEID, 2, '0')\n" +
                    "       AND OESAVE.PRESCRIPTIONID = "+prescriptionid+" ";
			
			
/*			String sql="select  '* '||OE.OENAME ||' '||OETYPE.OETYPE||' '||OESAVE.OECOMMENTS st " +
			"	from OESAVE,OE,OETYPE  " +
			"	where lpad(OE.OEID,2,'0')=lpad(OESAVE.OEID,2,'0')  " +
			"   and lpad(OETYPE.OEID,2,'0')||lpad(OETYPE.OETYPEID,2,'0')=decode(OESAVE.OETYPEID,'No Subtype','9999',lpad(OESAVE.OEID,2,'0')||lpad(OESAVE.OETYPEID,2,'0')) "+
			"	and OESAVE.PRESCRIPTIONID="+prescriptionid+" " ;*/
	
			
			try {
				stmt = conn.createStatement();
				r = stmt.executeQuery(sql);
				
				while (r.next()) {				
					oe.add(r.getString("st"));
				}
			
			} catch (Exception e){e.printStackTrace();}
				finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
			{e.printStackTrace();}stmt = null;conn = null;}
			
			
			
			return oe;
		}
		
		
	public ArrayList<String> getINV(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<String> oe =new ArrayList<String>();
		
		String sql="SELECT    ''\n" +
	              "       || TST.TESTNAME\n" +
	              "       || ' '\n" +
	              "       || tsv.tstcomments\n" +
	              "          str\n" +
	              "  FROM TESTS tst, TESTTYPE tstp, TEST_SAVE tsv\n" +
	              " WHERE    TSTP.TESTTYPEID = TSV.TESTTYPEID \n" +
	              "       AND TST.TESTTYPEID ||TST.TESTID =\n" +
	              "              DECODE (\n" +
	              "                 TSV.TESTID,\n" +
	              "                 'No Subtype', '9999',\n" +
	              "                TSV.TESTTYPEID || TSV.TESTID)\n" +
	              "       AND TSV.PRESCRIPTIONID = "+prescriptionid+" \n" +
	              "UNION\n" +
	              "SELECT (' ' || TEST_ADVICE || '  ' || ' (outside)') str\n" +
	              "  FROM TEST_OUTSIDE_SAVE\n" +
	              " WHERE PRESCRIPTIONID = "+prescriptionid+" ";
		
/*		String sql="SELECT    '* '\n" +
	              "       || TSTP.TESTTYPENAME\n" +
	              "       || ': '\n" +
	              "       || TST.TESTNAME\n" +
	              "       || ' '\n" +
	              "       || tsv.tstcomments\n" +
	              "          str\n" +
	              "  FROM TESTS tst, TESTTYPE tstp, TEST_SAVE tsv\n" +
	              " WHERE     LPAD (TSTP.TESTTYPEID, 2, '0') = LPAD (TSV.TESTTYPEID, 2, '0')\n" +
	              "       AND LPAD (TST.TESTTYPEID, 2, '0') || LPAD (TST.TESTID, 2, '0') =\n" +
	              "              DECODE (\n" +
	              "                 TSV.TESTID,\n" +
	              "                 'No Subtype', '9999',\n" +
	              "                 LPAD (TSV.TESTTYPEID, 2, '0') || LPAD (TSV.TESTID, 2, '0'))\n" +
	              "       AND TSV.PRESCRIPTIONID = "+prescriptionid+" \n" +
	              "UNION\n" +
	              "SELECT ('* ' || TEST_ADVICE || '  ' || ' (##)') str\n" +
	              "  FROM TEST_OUTSIDE_SAVE\n" +
	              " WHERE PRESCRIPTIONID = "+prescriptionid+" ";*/
		
/*		String sql=" select '* '||TSTP.TESTTYPENAME ||': '||TST.TESTNAME ||' '||tsv.tstcomments str " +
		" from TESTS tst,TESTTYPE tstp,TEST_SAVE tsv  " +
		" where lpad(TSTP.TESTTYPEID,2,'0')=lpad(TSV.TESTTYPEID,2,'0')  " +
		" and lpad(TST.TESTTYPEID,2,'0')||lpad(TST.TESTID,2,'0')=decode(TSV.TESTID,'No Subtype','9999',lpad(TSV.TESTTYPEID,2,'0')||lpad(TSV.TESTID,2,'0'))  " +
		" and TSV.PRESCRIPTIONID= "+prescriptionid+" " ;*/
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			
			while (r.next()) {				
				oe.add(r.getString("str"));
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return oe;
	}

	public ArrayList<PrescriptionDTO>invdisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> tstinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

/*			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			
			String sql="SELECT TSTP.TESTTYPENAME testypename,\n" +
		              "       TST.TESTNAME testname,\n" +
		              "       tsv.tstcomments tstcomments\n" +
		              "  FROM TESTS tst, TESTTYPE tstp, TEST_SAVE tsv\n" +
		              " WHERE     TSTP.TESTTYPEID = TSV.TESTTYPEID \n" +
		              "       AND TST.TESTTYPEID || TST.TESTID = \n" +
		              "              DECODE (\n" +
		              "                 TSV.TESTID,\n" +
		              "                 'No Subtype', '9999',\n" +
		              "                 TSV.TESTTYPEID || TSV.TESTID)\n" +
		              "       AND PRESCRIPTIONID ="+prescriptionid+" \n" +
		              "UNION\n" +
		              "SELECT '' testypename,\n" +
		              "       (TEST_ADVICE || '  ' || '(*Out Side Test*)') testname,\n" +
		              "       '' tstcomments\n" +
		              "  FROM TEST_OUTSIDE_SAVE\n" +
		              " WHERE PRESCRIPTIONID ="+prescriptionid+" ";
			
			
/*			String sql= " select TSTP.TESTTYPENAME testypename ,TST.TESTNAME testname,tsv.tstcomments tstcomments"+
					" from TESTS tst,TESTTYPE tstp,TEST_SAVE tsv "+
					" where lpad(TSTP.TESTTYPEID,2,'0')=lpad(TSV.TESTTYPEID,2,'0') "+ 
					" and lpad(TST.TESTTYPEID,2,'0')||lpad(TST.TESTID,2,'0')=decode(TSV.TESTID,'No Subtype','9999',lpad(TSV.TESTTYPEID,2,'0')||lpad(TSV.TESTID,2,'0')) "+
					" and PRESCRIPTIONID= "+prescriptionid+"";
				*/
				
				
				/*"select CC.CCNAME CCNAME,CCTYPE.CCTYPE CCTYPE,CCSAVE.COMMENTS COMMENTS "+
			"from CCSAVE,cc,cctype "+
			"where lpad(CC.CCID,2,'0')=lpad(CCSAVE.CCID,2,'0') "+
			"and lpad(CCTYPE.CCID,2,'0')||lpad(CCTYPE.CCTYPEID,2,'0')=decode(CCSAVE.CCTYPEID,'No Subtype','9999',lpad(CCSAVE.CCID,2,'0')||lpad(CCSAVE.CCTYPEID,2,'0')) "+
			"and CCSAVE.PATIENTID='' ";*/

			

			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();
				
				
				
				pt.setTestypename(r.getString("testypename"));
				pt.setTestname(r.getString("testname"));
				pt.setTstcomments(r.getString("tstcomments"));

				tstinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return tstinfo;

	}  
	
	public ArrayList<String> getPAE(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<String> oe =new ArrayList<String>();
		
		String sql="select ''||PAESAVE.PCOMMENTS st  " +
		"	from paesave  " +
		"	where PAESAVE.PRESCRIPTIONID="+prescriptionid+" " ;
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			
			while (r.next()) {	
				oe.add(r.getString("st"));
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return oe;
	}
	
	
	
	public ArrayList<PrescriptionDTO>paedisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> pinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

/*			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			String sql= "select PAESAVE.PCOMMENTS pcomments "+
			 			"from paesave "+
			 			"where PAESAVE.PRESCRIPTIONID="+prescriptionid+" ";

			 
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();

				pt.setPcomments(r.getString("pcomments"));
				  			

				pinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return pinfo;

	}   
	
	
	
	
	public ArrayList<PrescriptionDTO>advdisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> pinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
/*
			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			String sql= "select ADVSAVE.ADVCOMMENTS advcomments "+
			 			"from ADVSAVE "+
			 			"where ADVSAVE.PRESCRIPTIONID="+prescriptionid+"";

			 
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();
				
				pt.setAdvcomments(r.getString("advcomments"));			
				  			

				pinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return pinfo;

	}  
	
	
	public String getWeight(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		String we ="-";
		
		String sql="select WEIGHT_SAVE.WEIGHT st"+   
				" from WEIGHT_SAVE"+
				" where WEIGHT_SAVE.PRESCRIPTIONID='"+prescriptionid+"' ";
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			
			while (r.next()) {	
				we=(r.getString("st"));
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return we;
	}
	
	
	
	public String weight(Long prescriptionid)
	{

		String weight="N";


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{
/*
			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			String sql= " select WEIGHT_SAVE.WEIGHT WEIGHT "+
                    " from WEIGHT_SAVE "+
                    " where WEIGHT_SAVE.PRESCRIPTIONID='"+prescriptionid+"' ";

			 
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				
				
				weight = r.getString("WEIGHT");			
				  			

					
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return weight;

	}  
		
	
	public ArrayList<String> getDIA(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<String> oe =new ArrayList<String>();
		
		String sql="select ''||DECODE(DIA.DID,'50','',DIA.DNAME) ||' '||DS.COMMENTS str " +
		"	from DIAGNOSISSAVE ds , DIAGNOSIS dia  " +
		"	where lpad(DS.DID ,2,'0')=lpad(DIA.DID ,2,'0')  " +
		"	and DS.PRESCRIPTIONID = "+prescriptionid+" " ;
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			
			while (r.next()) {				
							
				oe.add(r.getString("str"));
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return oe;
	}
	
	
	public ArrayList<PrescriptionDTO>diadisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> dinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

/*			Connection con = ConnectionManager.getConnection();  
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");*/
			Connection conn = ConnectionManager.getConnection(); 
			String sql= "select DECODE(DIA.DID,'50','',DIA.DNAME) DIANAME,DS.COMMENTS DCOMMENTS "+
		    			"from DIAGNOSISSAVE ds , DIAGNOSIS dia "+
		    			"where lpad(DS.DID ,2,'0')=lpad(DIA.DID ,2,'0') "+
		    			"and DS.PRESCRIPTIONID = "+prescriptionid+"";
			
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();
				
				
				pt.setDname(r.getString("DIANAME"));				
				pt.setDcomments(r.getString("DCOMMENTS"));
				

				dinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return dinfo;

	}   
		
		
	//Tests

	public ArrayList<PrescriptionDTO> showTestypeNames() {
		ArrayList testypelist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = " select TESTTYPEID , TESTTYPENAME from TESTTYPE order by TESTTYPENAME asc ";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setTestypeid(r.getString(1));
				pp.setTestypename(r.getString(2));

				testypelist.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testypelist;
	}


	public ArrayList<PrescriptionDTO> getTestList(String testypeid) {
		ArrayList testlist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;


		try {
			Connection conn = ConnectionManager.getConnection();
		//	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");


			String sql = " select TESTS.TESTID ,trim(TESTS.TESTNAME)testname " +
			" from TESTTYPE, TESTS " +
			" where TESTS.TESTTYPEID="+  testypeid  +
			" and TESTS.TESTTYPEID=TESTTYPE.TESTTYPEID " +
			" order by TESTS.TESTID ";


			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				PrescriptionDTO pt = new PrescriptionDTO();


				pt.setTestid(r.getString(1));
				pt.setTestname(r.getString(2));
				testlist.add(pt);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return testlist;
	}

	/*public ArrayList<PrescriptionDTO> getSbTestList(String sbtestid) {
		ArrayList testlist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;


		try {
			Connection con = ConnectionManager.getConnection();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");


			String sql = " select SBTST.SUBTESTID, SBTST.SUBTESTNAME " +
			" from SUBTEST sbtst,tests tst,TESTTYPE tstp " +
			" where SBTST.TESTID=lpad('" + sbtestid + "',2,'0') " +
			" and SBTST.TESTID=TST.TESTID " +
			" and SBTST.TESTTYPEID=TSTP.TESTTYPEID " +
			" and TST.TESTTYPEID=TSTP.TESTTYPEID "+
			" and SBTST.TESTTYPEID= TST.TESTTYPEID ";

			
			System.out.println(sql);
			
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				PrescriptionDTO pt = new PrescriptionDTO();

				pt.setSubtestid(r.getString(1));
				//pt.setSubtestname(r.getString(2));
				testlist.add(pt);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return testlist;
	}
*/

	//medicine


	public ArrayList<PrescriptionDTO> showMedGenNames() {
		ArrayList genericlist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlist.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlist;
	}

	public ArrayList<PrescriptionDTO> showMedGenNamesTablet() {
		ArrayList genericlistTablet = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC WHERE CATAGORY='Antibiotics' order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlistTablet.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlistTablet;
	}
	public ArrayList<PrescriptionDTO> showMedGenNamesCapsul() {
		ArrayList genericlistCapsul = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC WHERE CATAGORY='Alimentary_System_drug' order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlistCapsul.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlistCapsul;
	}
	
	public ArrayList<PrescriptionDTO> showMedGenNamesSyrap() {
		ArrayList genericlistSyrap = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC WHERE CATAGORY='Analgesics_nsaids' order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlistSyrap.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlistSyrap;
	}
	
	public ArrayList<PrescriptionDTO> showMedGenNamesRespiratrySystemdrugs() {
		ArrayList genericlistSyrap = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC WHERE CATAGORY='Respiratry_System_drugs' order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlistSyrap.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlistSyrap;
	}
	
	public ArrayList<PrescriptionDTO> showMedGenNamesOthers() {
		ArrayList genericlistSyrap = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select GEN_ID,GEN_NAME,CATAGORY from  MC_GENERIC WHERE CATAGORY='Others' order by GEN_NAME asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setGenid(r.getString(1));
				pp.setGenname(r.getString(2));
				pp.setGencatagory(r.getString(3));
				genericlistSyrap.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return genericlistSyrap;
	}
	
	
	
	public ArrayList<PrescriptionDTO> getMedicineList(String genid) {
		ArrayList druglist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;


		try {
			Connection conn = ConnectionManager.getConnection();
		//	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");


			String sql = " select sst.MED_ID,MD.MED_NAME"+
						 " from MEDICINE_INFO md, MC_GENERIC mg , SUB_STORE sst "+
						 " where MD.GEN_ID='"+ genid + "' "+
						 " and MD.GEN_ID=MG.GEN_ID "+
						 " and  SST.MED_ID=MD.MED_ID ORDER BY MD.MED_NAME ";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				PrescriptionDTO pt = new PrescriptionDTO();

				pt.setDrugid(r.getString(1));
				pt.setDrugname(r.getString(2));
				

				druglist.add(pt);

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return druglist;
	}

	public ArrayList<String>  getAdvice(Long prescriptionid)
	{
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		ArrayList<String>  oe = new ArrayList<String>();
		
		String sql="select '* '||ADVSAVE.ADVCOMMENTS st " +
		" from ADVSAVE  " +
		" where ADVSAVE.PRESCRIPTIONID= "+prescriptionid+" " ;
		
				
		try {
			
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			
			while (r.next()) {							
				oe.add(r.getString(1));
				
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		
		return oe;
	}

	public PrescripDTO getPrescription(Long prescriptionid)
	{
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		
		Connection conn2 = ConnectionManager.getConnection();		
		Statement stmt2 = null;
		ResultSet r2 = null;
		
		PrescripDTO pDTO = new PrescripDTO();
		
		pDTO.setAdvice(getAdvice(prescriptionid));
		pDTO.setCc(getCC(prescriptionid));
		pDTO.setDiagonasis(getDIA(prescriptionid));
		pDTO.setInvestigation(getINV(prescriptionid));
		pDTO.setOe(getOE(prescriptionid));
		pDTO.setPae(getPAE(prescriptionid));
		pDTO.setWeight(getWeight(prescriptionid));
		
		ArrayList<String> rx =new ArrayList<String>();
		ArrayList<String> rxout =new ArrayList<String>();
		
		
		String sql="SELECT    ' '\n" +
	              "       || MI.MED_NAME\n" +
	              "       || '        '\n" +
	              "       || msv.DRGQTY\n" +
	              "       || ' '\n" +
	              "       || MI.UNIT\n" +
	              "       || '@'\n" +
	              "       || msv.DOSE\n" +
	              "       || '     '\n" +
	              "       || msv.DAYS\n" +
	              "       || ' '\n" +
	              "       || msv.TAKINGTIME\n" +
	              "          rxd\n" +
	              "  FROM MEDICINE_SAVE msv, MEDICINE_INFO mi\n" +
	              " WHERE msv.MED_ID = MI.MED_ID AND msv.PRESCRIPTIONID = "+prescriptionid+" \n" +
	              "UNION\n" +
	              "SELECT (' '|| MEDICINE_ADVICE || '  ' || '@(##)') rxd\n" +
	              "  FROM MED_OUTSIDE_SAVE\n" +
	              " WHERE PRESCRIPTIONID = "+prescriptionid+" ";
		
		String sql2="SELECT  ' '|| Msv.MED_id || '      ' || msv.DRGQTY|| ' '|| '@'|| msv.DOSE  || '     ' || msv.DAYS|| ' '|| msv.TAKINGTIME "+
                " rxdout"+
                " FROM MEDICINE_OUTSIDE_SAVE msv"+
                " WHERE msv.PRESCRIPTIONID = '"+prescriptionid+"' " ;
		
/*		String sql="select '* '||MI.MED_NAME ||'        '||msv.DRGQTY ||' ' ||MI.UNIT ||'@'|| " +
		" msv.DOSE ||'     '||msv.DAYS||' '||msv.TAKINGTIME  rxd " +
		" from MEDICINE_SAVE msv, MEDICINE_INFO mi  " +
		" where msv.MED_ID=MI.MED_ID   " +
		" and msv.PRESCRIPTIONID = "+prescriptionid+" " ;*/
		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			stmt2 = conn2.createStatement();
			r2 = stmt2.executeQuery(sql2);
			
			while (r.next()) {		
					rx.add(r.getString("rxd"));					
					
			}
			
			while (r2.next()) {		
				rxout.add(r2.getString("rxdout"));					
				
		}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{
				stmt.close();
				ConnectionManager.closeConnection(conn);
				stmt2.close();
				ConnectionManager.closeConnection(conn2);
				
			} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		pDTO.setRx(rx);
		pDTO.setRxdout(rxout);
		
		
		return pDTO;
	}
	
	
	public ArrayList<PrescriptionDTO>meddisplay(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> medinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

			Connection conn = ConnectionManager.getConnection();  
	//		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");

			String sql="SELECT MG.GEN_NAME medgroup,\n" +
		              "       MI.MED_NAME medicine,\n" +
		              "       MI.UNIT unit,\n" +
		              "       msv.DRGQTY Givenqty,\n" +
		              "       msv.DOSE Dosage,\n" +
		              "       (msv.DAYS || '  ' || msv.TAKINGTIME) Schedule\n" +
		              "  FROM MEDICINE_SAVE msv, MC_GENERIC mg, MEDICINE_INFO mi\n" +
		              " WHERE     msv.GEN_ID = MG.GEN_ID\n" +
		              "       AND msv.MED_ID = MI.MED_ID\n" +
		              "       AND msv.PRESCRIPTIONID ='"+prescriptionid+"'\n" +
		              "UNION\n" +
		              "SELECT '' medgroup,\n" +
		              "       (MEDICINE_ADVICE || '  ' || '(*Out Side Medicine*)') medicine,\n" +
		              "       NULL unit,\n" +
		              "       NULL Givenqty,\n" +
		              "       '' Dosage,\n" +
		              "       '' Schedule\n" +
		              "  FROM MED_OUTSIDE_SAVE\n" +
		              " WHERE PRESCRIPTIONID ='"+prescriptionid+"'";
			
/*			String sql= " select  MG.GEN_NAME medgroup,MI.MED_NAME medicine,MI.UNIT unit,msv.DRGQTY Givenqty,msv.DOSE Dosage,(msv.DAYS||'  '||msv.TAKINGTIME)Schedule " +
					" from MEDICINE_SAVE msv,MC_GENERIC mg,MEDICINE_INFO mi " +
					" where msv.GEN_ID=MG.GEN_ID " +
					" and msv.MED_ID=MI.MED_ID " +
					" and msv.PRESCRIPTIONID= '"+prescriptionid+"' ";
			*/
			
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();

				pt.setGenname(r.getString("medgroup"));
				pt.setDrugname(r.getString("medicine"));
				pt.setDrgqty(r.getString("Givenqty"));
				pt.setDose(r.getString("Dosage"));
				pt.setUnit(r.getString("unit"));
				pt.setDays(r.getString("Schedule"));
				
				medinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return medinfo;

	}  
	
	
	public ArrayList<PrescriptionDTO>meddisplayout(Long prescriptionid)
	{

		ArrayList<PrescriptionDTO> medinfo = new ArrayList<PrescriptionDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

			Connection conn = ConnectionManager.getConnection();  
	//		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");

			String sql=" SELECT"+
                    " msv.MED_ID medicine,           "+                  
                    " msv.DRGQTY Givenqty,"+
                    " msv.DOSE Dosage,"+
                    " (msv.DAYS || '   ' || msv.TAKINGTIME) Schedule"+
               " FROM MEDICINE_OUTSIDE_SAVE msv   "+
              " WHERE                       "+          
                "     msv.PRESCRIPTIONID = '"+prescriptionid+"' ";
			
/*			String sql= " select  MG.GEN_NAME medgroup,MI.MED_NAME medicine,MI.UNIT unit,msv.DRGQTY Givenqty,msv.DOSE Dosage,(msv.DAYS||'  '||msv.TAKINGTIME)Schedule " +
					" from MEDICINE_SAVE msv,MC_GENERIC mg,MEDICINE_INFO mi " +
					" where msv.GEN_ID=MG.GEN_ID " +
					" and msv.MED_ID=MI.MED_ID " +
					" and msv.PRESCRIPTIONID= '"+prescriptionid+"' ";
			*/
			
			stmt = conn.prepareStatement(sql);


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PrescriptionDTO pt = new PrescriptionDTO();

				
				pt.setDrugname(r.getString("medicine"));
				pt.setDrgqty(r.getString("Givenqty"));
				pt.setDose(r.getString("Dosage"));
				
				pt.setDays(r.getString("Schedule"));
				
				medinfo.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return medinfo;

	}  

	
	//Auto complete


	public ArrayList<PrescriptionAction> showAdvices() {
		ArrayList advlist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
	//		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select ADVID, ADVICES from ADVICELIST order by ADVID asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionAction pp = new PrescriptionAction();

				pp.setAdvid(r.getString(1));
				pp.setAdvicename(r.getString(2));
				advlist.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return advlist;
	}


	public List<Object[]> findAllWOAutoComplete(String cName, String type) {
		List list = new ArrayList();

		String lName = "%" + cName.toLowerCase() + "%";

		try {
			Connection conn = ConnectionManager.getConnection();
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "";

			if (type.equalsIgnoreCase("a")) {
				sql += "SELECT trim(ADVICES)ADVICES " +
				"  		FROM ADVICELIST " +
				"  where LOWER (ADVICES) LIKE '" + lName + "' " +
				"  order by ADVID ";


			}


			ResultSet r = null;
			Statement stmt = null;

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);
			while (r.next()) {

				Object ob = new Object();

				ob = r.getString(1);

				list.add(ob);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return list;
	}

	// diagonosis


	public ArrayList<PrescriptionDTO> showdNames() {
		ArrayList dlist = new ArrayList();
		ResultSet r = null;
		Statement stmt = null;

		try {
			Connection conn = ConnectionManager.getConnection();
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd", "mcenter", "mcenter");

			String sql = "select did,dname from DIAGNOSIS order by dname asc";

			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				PrescriptionDTO pp = new PrescriptionDTO();

				pp.setDid(r.getString(1));
				pp.setDname(r.getString(2));
				dlist.add(pp);

			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dlist;
	}
	//Show prescription




	public boolean insertValue(String[] ccname,String [] cctype, String[]comments, Long prescriptionid,String patientid,
			String[]oename,String [] oecomments, String[] pcomments,String[] genname,String[] drugname,
			String[]drgqty,String[] dose,String[]days,String[] takingtime,String[]tknqty,
			String[] gennameout,String[] drugnameout,String[] drgqtyout,String[] doseout,String[] daysout,String[] takingtimeout,String[] tknqtyout,
			String[]rxstatus,
			String[]dname,String[]dcomments,String[]testypename,String[]testname,String[]tstcomm,String[] advcomments,String 
			visitid,String[] uprice,String[]tstprice,String[]tstvat,String[]medOutSide,String[]testOutSide, String offId, String weight, String[] rxstatusout) throws SQLException

			{
		
			Connection conn = ConnectionManager.getConnection(); 		
			String sql="insert into PRESCRIPTION(PRESCRIPTIONID,PATIENTID,VISITID,DOCTORID,PRESCRIPTIONDATE)values(?,?,?,?,sysdate) ";

			PreparedStatement statement = null;
 		
 		try
		{
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
						
			statement.setLong(1, prescriptionid);
			statement.setString(2, patientid);
			statement.setString(3, visitid);
			statement.setString(4, offId);
			
			statement.executeUpdate();
			
			if(ccname!=null)
			{
			if(!insertCC(ccname,cctype,comments,prescriptionid,patientid,conn))
				return false;	
			}
			
			
			if(oename!=null){
			if(!insertOE(oename,oecomments, prescriptionid,patientid,conn))
				return false;
			}
			
			if(pcomments!=null){
			if(!insertPAE(prescriptionid,pcomments,patientid,conn))
				return false;
			}
			if(dname!=null){
			if(!insertDIA(prescriptionid,dname,dcomments,patientid,conn))
				return false;
			}
			if(testypename!=null&& testname!=null){
			if(!insertINV(prescriptionid,testypename,testname,patientid,tstcomm,tstprice,tstvat,conn))
				return false;
			}
			if(genname!=null && drugname!=null && drgqty!=null && dose!=null && days!=null && takingtime!=null && tknqty!=null){
			if(!insertRx(prescriptionid,patientid,genname,drugname,drgqty,dose,days,takingtime,tknqty,rxstatus,uprice,conn))
				return false;
			}
			
			if(gennameout!=null && drugnameout!=null && drgqtyout!=null && doseout!=null && daysout!=null && takingtimeout!=null && tknqtyout!=null){
				if(!insertRxOut(prescriptionid,patientid,gennameout,drugnameout,drgqtyout,doseout,daysout,takingtimeout,tknqtyout,rxstatusout,uprice,conn))
					return false;
				}
			
			if(advcomments!=null){
			if(!insertAdv(prescriptionid,patientid,advcomments,conn))
				return false;
			}
			
			if(medOutSide!=null){
				if(!insertmedOutSide(prescriptionid,patientid,medOutSide,conn))
					return false;
				}
			
			if(testOutSide!=null){
				if(!inserttestOutSide(prescriptionid,patientid,testOutSide,conn))
					return false;
				}
			
			if(weight!=null || weight!=""){
				if(!insertweight(prescriptionid,patientid,weight,conn))
					return false;
				}
			
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

/*start*/
	
	//cc
public boolean insertCC(String[]ccname,String [] cctype,String[]comments,Long prescriptionid,String patientid,Connection conn)
 	{
		String sql=	" insert into CCSAVE(CCID,CCTYPEID,COMMENTS,PRESCRIPTIONID,PATIENTID)values(?,?,?,?,?) "; 		
 	 		
 		
 		PreparedStatement statement = null;
 		
 		try
		{
			statement = conn.prepareStatement(sql);			
			
			for (int i = 0; i < ccname.length; i++)
			{		
				
				String ctype=cctype[i];
				if(ctype==null|| ctype.equalsIgnoreCase(""))
				{
					ctype="No Subtype";
				    cctype[i]=ctype;
				
				statement.setString(1, ccname[i]);					
				statement.setString(2, cctype[i]);
				statement.setString(3, comments[i]);
				statement.setLong(4, prescriptionid);
				statement.setString(5, patientid);

				statement.executeUpdate();
				}
				else{

						statement.setString(1, ccname[i]);					
						statement.setString(2, cctype[i]);
						statement.setString(3, comments[i]);
						statement.setLong(4, prescriptionid);
						statement.setString(5, patientid);

						statement.executeUpdate();
					
				}
				
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
 		
//OE	
public boolean insertOE(String[]oename,String [] oecomments,Long prescriptionid,String patientid,Connection conn)
 	{
 		String sql=" insert into OESAVE(PRESCRIPTIONID,OEID,OECOMMENTS,PATIENTID)values(?,?,?,?) "; 		
 	 		
 		
 		PreparedStatement statement = null;
 		
 		try
		{
			statement = conn.prepareStatement(sql);

			for (int i = 0; i < oename.length; i++)
			{

				statement.setLong(1, prescriptionid);
				statement.setString(2, oename[i]);
				statement.setString(3, oecomments[i]);
				statement.setString(4, patientid);	
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
 		
//pae

public boolean insertPAE(Long prescriptionid,String [] pcomments,String patientid,Connection conn)
	{
		 		
		String sql="insert into PAESAVE(PRESCRIPTIONID,PCOMMENTS,PATIENTID) values(?,?,?) ";
		
		PreparedStatement statement = null;
		
		try
	{
		statement = conn.prepareStatement(sql);

		for (int i = 0; i < pcomments.length; i++)
		{
			
			
			statement.setLong(1, prescriptionid);
			statement.setString(2, pcomments[i]);
			statement.setString(3, patientid);			
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
		
//dia
public boolean insertDIA(Long prescriptionid,String[]dname,String [] dcomments,String patientid,Connection conn)
{
	 		
	String sql="insert into DIAGNOSISSAVE(PATIENTID,PRESCRIPTIONID,DID,COMMENTS) values(?,?,?,?) ";
	
	
	PreparedStatement statement = null;
	
	try
{
	statement = conn.prepareStatement(sql);

	for (int i = 0; i < dname.length; i++)
	{
		
		
		
		statement.setString(1, patientid);
		statement.setLong(2, prescriptionid);
		statement.setString(3, dname[i]);
		statement.setString(4, dcomments[i]);		
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


//inv
public boolean insertINV(Long prescriptionid,String[]testypename,String [] testname,String patientid,String[]tstcomm,String[]tstprice,String[]tstvat,Connection conn)
{
	 		
	String sql=" insert into TEST_SAVE(PRESCRIPTIONID,TESTTYPEID,TESTID,PATIENTID,TSTCOMMENTS,TEST_RATE,VAT,STATUS)values(?,?,?,?,?,?,?,?) ";
	
	
	PreparedStatement statement = null;
	
	try
{
	statement = conn.prepareStatement(sql);

	for (int i = 0; i < testypename.length; i++)
	{		
		statement.setLong(1, prescriptionid);
		statement.setString(2, testypename[i]);
		statement.setString(3, testname[i]);					
		statement.setString(4, patientid);
		statement.setString(5, tstcomm[i]);
		statement.setDouble(6, Double.valueOf(tstprice[i]));
		statement.setDouble(7, Double.valueOf(tstvat[i]));
		statement.setString(8,"Not Taken");
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

//Rx
public boolean insertRx(Long prescriptionid,String patientid,String[] genname,String[] drugname,
						String[]drgqty,String[] dose,String[]days,String[] takingtime,String[]tknqty,
						String[]rxstatus,String[] uprice,Connection conn)
{
	 		
	String sql=" insert into MEDICINE_SAVE(PATIENTID,PRESCRIPTIONID,GEN_ID,MED_ID,DRGQTY,TKNQTY,DOSE,DAYS,TAKINGTIME,STATUS,MED_RATE)values(?,?,?,?,?,?,?,?,?,?,?) ";
	
	
	PreparedStatement statement = null;
	
	try
{
	statement = conn.prepareStatement(sql);

	for (int i = 0; i < genname.length; i++)
	{		
		statement.setString(1, patientid);
		statement.setLong(2, prescriptionid);
		statement.setString(3, genname[i].toString());
		statement.setString(4, drugname[i].toString());
		statement.setLong(5, Integer.parseInt(drgqty[i]));
		statement.setLong(6, Integer.parseInt(tknqty[i]));
		statement.setString(7, dose[i]);
		statement.setString(8, days[i]);
		statement.setString(9, takingtime[i]);
		statement.setString(10, rxstatus[i]);
		statement.setDouble(11, Double.valueOf(uprice[i]));
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

// Rx medicine outside save
public boolean insertRxOut(Long prescriptionid,String patientid,String[] gennameout,String[] drugnameout,
						String[]drgqtyout,String[] doseout,String[]daysout,String[] takingtimeout,String[]tknqtyout,
						String[]rxstatusout,String[] uprice,Connection conn)
{
	 		
	String sql=" insert into MEDICINE_OUTSIDE_SAVE(PATIENTID,PRESCRIPTIONID,GEN_ID,MED_ID,DRGQTY,TKNQTY,DOSE,DAYS,TAKINGTIME,STATUS,MED_RATE)values(?,?,?,?,?,?,?,?,?,?,?) ";
	
	
	PreparedStatement statement = null;
	
	try
{
	statement = conn.prepareStatement(sql);

	for (int i = 0; i < gennameout.length; i++)
	{		
		statement.setString(1, patientid);
		statement.setLong(2, prescriptionid);
		statement.setString(3, "0");
		statement.setString(4, drugnameout[i].toString());
		statement.setLong(5, Integer.parseInt(drgqtyout[i]));
		statement.setLong(6, 0);
		statement.setString(7, doseout[i]);
		statement.setString(8, daysout[i]);
		statement.setString(9, takingtimeout[i]);
		statement.setString(10, rxstatusout[i]);
		statement.setDouble(11, 0.00);
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
	
public boolean insertAdv(Long prescriptionid,String patientid,String[] advcomments,Connection conn)
		{
	
		String sql=" insert into ADVSAVE(PRESCRIPTIONID,PATIENTID,ADVCOMMENTS)values(?,?,?) ";

	
		PreparedStatement statement = null;
	
		try
		{
		statement = conn.prepareStatement(sql);
		
		for (int i = 0; i < advcomments.length; i++)
			{		
				statement.setLong(1, prescriptionid);
				statement.setString(2, patientid);
				statement.setString(3, advcomments[i]);
	
				statement.executeUpdate();
			}
	
		} 
		catch (Exception e)
			{
				try
					{
					e.printStackTrace();
					statement.close();
					conn.rollback();
					return false;
					}
				catch (Exception e1)
					{
					e1.printStackTrace();
					}
			}	
		finally
			{
			try
				{
				statement.close();
				} 
			catch (Exception e)
				{
				e.printStackTrace();
				}
			statement = null;
			}
	
	return true;
	}


public boolean insertmedOutSide(Long prescriptionid,String patientid,String[] medOutSide,Connection conn)
{

String sql=" insert into MED_OUTSIDE_SAVE(PRESCRIPTIONID,PATIENTID,MEDICINE_ADVICE)values(?,?,?) ";


PreparedStatement statement = null;

try
{
statement = conn.prepareStatement(sql);

for (int i = 0; i < medOutSide.length; i++)
	{		
		statement.setLong(1, prescriptionid);
		statement.setString(2, patientid);
		statement.setString(3, medOutSide[i]);

		statement.executeUpdate();
	}

} 
catch (Exception e)
	{
		try
			{
			e.printStackTrace();
			statement.close();
			conn.rollback();
			return false;
			}
		catch (Exception e1)
			{
			e1.printStackTrace();
			}
	}	
finally
	{
	try
		{
		statement.close();
		} 
	catch (Exception e)
		{
		e.printStackTrace();
		}
	statement = null;
	}

return true;
}


public boolean inserttestOutSide(Long prescriptionid,String patientid,String[] testOutSide,Connection conn)
{

String sql=" insert into TEST_OUTSIDE_SAVE(PRESCRIPTIONID,PATIENTID,TEST_ADVICE)values(?,?,?) ";


PreparedStatement statement = null;

try
{
statement = conn.prepareStatement(sql);

for (int i = 0; i < testOutSide.length; i++)
	{		
		statement.setLong(1, prescriptionid);
		statement.setString(2, patientid);
		statement.setString(3, testOutSide[i]);

		statement.executeUpdate();
	}

} 
catch (Exception e)
	{
		try
			{
			e.printStackTrace();
			statement.close();
			conn.rollback();
			return false;
			}
		catch (Exception e1)
			{
			e1.printStackTrace();
			}
	}	
finally
	{
	try
		{
		statement.close();
		} 
	catch (Exception e)
		{
		e.printStackTrace();
		}
	statement = null;
	}

return true;
}
	
/*End*/	
	


public boolean insertweight(Long prescriptionid,String patientid,String weight,Connection conn)
{

String sql=" insert into WEIGHT_SAVE(PRESCRIPTIONID,PATIENTID,WEIGHT)values(?,?,?) ";

PreparedStatement statement = null;

try
{
statement = conn.prepareStatement(sql);
	
		statement.setLong(1, prescriptionid);
		statement.setString(2, patientid);
		statement.setString(3, weight);

		statement.executeUpdate();
	
} 
catch (Exception e)
	{
		try
			{
			e.printStackTrace();
			statement.close();
			conn.rollback();
			return false;
			}
		catch (Exception e1)
			{
			e1.printStackTrace();
			}
	}	
finally
	{
	try
		{
		statement.close();
		} 
	catch (Exception e)
		{
		e.printStackTrace();
		}
	statement = null;
	}

return true;
}

	public ArrayList<PatientDetailDTO>ptpreslist(String medicalId)
	{

		ArrayList<PatientDetailDTO> ptlist = new ArrayList<PatientDetailDTO>();


		PreparedStatement stmt = null;
		ResultSet r = null;
		try
		{

			Connection conn = ConnectionManager.getConnection();  
		//	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");

			String sql=" select NAME, DEPARTMENT,DESIGNATION, SEX,MEDICALID,PD.IMAGE  "+
			" from PATIENTDETAILS pd  "+
			" where PD.MEDICALID='"+medicalId+"' ";


			stmt = conn.prepareStatement(sql);
			//stmt.setString(1, fdate);
			//stmt.setString(2, tdate);	


			r = stmt.executeQuery();
			System.out.println("Response : " + sql);

			while (r.next())
			{
				PatientDetailDTO pt = new PatientDetailDTO();

				pt.setName(r.getString("name"));
				pt.setDesignation(r.getString("designation"));
				pt.setDepartment(r.getString("department"));
				pt.setSex(r.getString("sex"));
				pt.setPatientid(r.getString("patientid"));

				ptlist.add(pt);	
			}

			conn.close();
		}
		catch(Exception e)
		{e.printStackTrace();}

		return ptlist;

	}
	
	
	
public String getStockBalance(String med) {
		
		
		String sql=	" select SST.QUANTITY Quantity "+
					" from SUB_STORE sst "+
					" where SST.MED_ID='"+med+"' ";
		
		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;
		ResultSet r = null;
		String threeitem="";		
		
		
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) 
			
			{
				
			threeitem = r.getString("Quantity");
			
			}
		
		} catch (Exception e){e.printStackTrace();}
			finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		
		
		return threeitem;
	}	






public String getTwoItemRx(String med) {
	
	
	String sql=	" select SST.QUANTITY Quantity,SST.UNITPRICE price"+
				" from SUB_STORE sst "+
				" where SST.MED_ID='"+med+"' ";
		
		
		
		/*"select LOT_NUMBER,QUANTITY,unit_price " +
	" from CS_STORE where med_id='"+med+"' " +
	" and LOT_NUMBER=(select min(LOT_NUMBER) from  CS_STORE where med_id='"+med+"' and QUANTITY>0) ";*/
	
	
	
	Connection conn = ConnectionManager.getConnection();		
	Statement stmt = null;
	ResultSet r = null;
	String threeitem="";
	
	
	
	try {
		stmt = conn.createStatement();
		r = stmt.executeQuery(sql);

		while (r.next()) {				
			
			threeitem = r.getString("Quantity")+"@"+ r.getString("price");
			
		}
	
	} catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
	{e.printStackTrace();}stmt = null;conn = null;}
	
	
	
	return threeitem;
}
	



public String getTestVat(String tsid,String tstp) {
	
	
	String sql=	"select   nvl(Rate,0) rate, nvl(Vat,0) vat " +
	" from TESTS  " +
	//" where TESTID= lpad('"+tsid+"',2,'0')   " +
	" where TESTID="+ tsid+   
	" and TESTTYPEID= "+tstp ;
		
	
	
	
	Connection conn = ConnectionManager.getConnection();		
	Statement stmt = null;
	ResultSet r = null;
	String threeitem="";
	
	
	try {
		stmt = conn.createStatement();
		r = stmt.executeQuery(sql);

		while (r.next()) 
		{
			threeitem = r.getString("rate")+"@"+ r.getString("vat");
		}
	
	} catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
	{e.printStackTrace();}stmt = null;conn = null;}
	
	
	
	return threeitem;
}
	

public String getVisitID(Long prescriptionid)
{
	String VisitID="";
	
	Connection conn = ConnectionManager.getConnection();	
    
    String sql =" select  VISITID  from PRESCRIPTION where PRESCRIPTIONID ="+prescriptionid+" ";
    ResultSet r = null;
    Statement stmt = null;
    try {
        stmt = conn.createStatement();
        r = stmt.executeQuery(sql);
        while (r.next()) {
        	VisitID=r.getString(1);	            	
        }
    } catch (Exception e){e.printStackTrace();}
		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
	{e.printStackTrace();}stmt = null;conn = null;}
	
	
	return VisitID;
}



public PatientDetailDTO getPInfo(Long prescriptionid)
{	
	PreparedStatement stmt = null;
	ResultSet r = null;
	PatientDetailDTO pt = new PatientDetailDTO();
	try
	{
		
		
		//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.30.100:1521/KDB.buet.ac.bd","mcenter","mcenter");
		Connection conn = ConnectionManager.getConnection();
		
//		
//		String sql= " select tmp.pid Patientid,tmp.Name name, tmp.careof,tmp.Designation Designation,tmp.Department  Department , tmp.sex Sex,tmp.hall, tmp.room , PH.VISITID visitid"+
//					" from PATIENT_HISTORY ph, "+
//					" (select BSTD.STUDENTID pid , BSTD.STUDENTNAME Name ,BSTD.SEX Sex, ' ' careof,'Student' Designation,BSTD.DEPARTMENTID Department ,hl.hall_name hall ,hls.room room "+
//					" from biis.STUDENT bstd,  biis.HALL_LIST hl, biis.HALL_STUDENT hls "+
//					" where BSTD.STUDENTID=hls.STUDENT_ID "+
//					" and hl.HALL_ID=hls.HALL_ID "+
//					" and  BSTD.STUDENTID=(SELECT  PATIENTID FROM PRESCRIPTION where PRESCRIPTIONID="+prescriptionid+") "+
//					" union "+
//					" select ESP.OFFICIAL_ID pid,ESP.NAME name,ESP.SEX sex,' ' careof,    ESD.FULL_DESIGNATION   designation  ,DEP.SHORT_DEPARTMENT_NAME department  ,' ' hallname,' ' room "+
//					" from ESTABLISHMENT.PERSONNEL esp,ESTABLISHMENT.DESIGNATION esd,ESTABLISHMENT.Department dep "+
//					" where ESP.CURRENT_DESIGNATION_ID=ESD.DESIGNATION_ID "+
//					" and ESP.DEPARTMENT_ID=DEP.DEPARTMENT_ID "+
//					" and ESP.OFFICIAL_ID=(SELECT  PATIENTID FROM PRESCRIPTION where PRESCRIPTIONID="+prescriptionid+") "+
//					" union "+
//					" select DP.DEPENDENTID pid,DP.DNAME name,DP.SEX sex,ESP.NAME careof, ' ' designation, ' ' department,' ' hallname,' ' room"+ 
//					" from DEPENDENCY dp,ESTABLISHMENT.PERSONNEL esp "+
//					" where DP.OFFICIALID=ESP.OFFICIAL_ID "+
//					" and  DP.DEPENDENTID   =(SELECT  PATIENTID FROM PRESCRIPTION where PRESCRIPTIONID="+prescriptionid+") )tmp "+
//					" where PH.PATIENTID=tmp.pid ";
//					
		
		
		
		
		
		String sql="SELECT tmp.pid Patientid, " +
		"       tmp.Name name, " +
		"       tmp.careof, " +
		"       tmp.Designation Designation, " +
		"       tmp.Department Department, " +
		"       decode(tmp.sex,'F','Female','M','Male',tmp.sex) Sex, " +
		"       tmp.hall, " +
		"       tmp.room,tmp.age " +
		"  FROM  " +
		"       (SELECT BSTD.STUDENTID pid, " +
		"               BSTD.STUDENTNAME Name, " +
		"               BSTD.SEX Sex, " +
		"               'nil' careof, " +
		"               'Student' Designation, " +
		"               BSTD.DEPARTMENTID Department, " +
		"               hl.hall_name hall, " +
		"               hls.room room, AGECALCULATE(bstd.DATEOFBIRTH) age " +
		"          FROM biis.STUDENT bstd, biis.HALL_LIST hl, biis.HALL_STUDENT hls " +
		"         WHERE     BSTD.STUDENTID = hls.STUDENT_ID " +
		"               AND hl.HALL_ID = hls.HALL_ID " +
		"               AND BSTD.STUDENTID = (SELECT PATIENTID " +
		"                                       FROM PRESCRIPTION " +
		"                                      WHERE PRESCRIPTIONID = "+prescriptionid+") " +
		"        UNION " +
		"        SELECT ESP.OFFICIAL_ID pid, " +
		"               ESP.NAME name, " +
		"               ESP.SEX sex, " +
		"               'nil' careof, " +
		"               ESD.FULL_DESIGNATION designation, " +
		"               DEP.SHORT_DEPARTMENT_NAME department, " +
		"               'nil' hallname, " +
		"               'nil' room, AGECALCULATE(esp.DATE_OF_BIRTH) age " +
		"          FROM ESTABLISHMENT.PERSONNEL esp, " +
		"               ESTABLISHMENT.DESIGNATION esd, " +
		"               ESTABLISHMENT.Department dep " +
		"         WHERE     ESP.CURRENT_DESIGNATION_ID = ESD.DESIGNATION_ID " +
		"               AND ESP.DEPARTMENT_ID = DEP.DEPARTMENT_ID " +
		"               AND ESP.OFFICIAL_ID = (SELECT PATIENTID " +
		"                                        FROM PRESCRIPTION " +
		"                                       WHERE PRESCRIPTIONID = "+prescriptionid+") " +
		"        UNION " +
		"        SELECT TEMPID pid, " +
		"               NAME name, " +
		"               SEX sex, " +
		"               'nil' careof, " +
		"               DESIGNATION designation, " +
		"               DEPT department, " +
		"               'nil' hallname, " +
		"               'nil' room, AGECALCULATE(DATE_OF_BIRTH) age " +
		"          FROM MCENTER.NONIDPATIENT " +
		"               WHERE TEMPID= (SELECT PATIENTID " +
		"                                        FROM PRESCRIPTION " +
		"                                       WHERE PRESCRIPTIONID = "+prescriptionid+") " +
		"        UNION " +
		"        SELECT DP.DEPENDENTID pid, " +
		"               DP.DNAME name, " +
		"               DP.SEX sex, " +
		"               ESP.NAME careof, " +
		"               'nil' designation, " +
		"               'nil' department, " +
		"               'nil' hallname, " +
		"               'nil' room, AGECALCULATE(dp.DOB) age " +
		"          FROM DEPENDENCY dp, ESTABLISHMENT.PERSONNEL esp " +
		"         WHERE DP.OFFICIALID = ESP.OFFICIAL_ID " +
		"               AND DP.DEPENDENTID = (SELECT PATIENTID " +
		"                                       FROM PRESCRIPTION " +
		"                                      WHERE PRESCRIPTIONID = "+prescriptionid+")) tmp ";

		
		
		
		
		
		
				
		stmt = conn.prepareStatement(sql);
		
		
		r = stmt.executeQuery();
		System.out.println("Response : " + sql);
		
		
		
		
		while (r.next())
		{
			pt.setName(r.getString("Name"));
			pt.setCareof(r.getString("careof"));
			pt.setDesignation(r.getString("Designation"));			
			pt.setDepartment(r.getString("Department"));				
			pt.setSex(r.getString("Sex"));
			pt.setPatientid(r.getString("Patientid"));
			pt.setHall(r.getString("hall"));
			pt.setRoomno(r.getString("room"));
			//pt.setVisitid(r.getString("visitid"));	
			pt.setAge(r.getString("age"));
			
		}
		
		conn.close();
	}
	catch(Exception e)
		{e.printStackTrace();}
    
    return pt;
    
} 






}


