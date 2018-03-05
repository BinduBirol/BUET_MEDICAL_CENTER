package table.user;

import java.beans.Statement;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BLOB;

import org.apache.struts2.ServletActionContext;
import util.IpAddressDTO;
import util.ConnectionUtil.ConnectionManager;

public class UserDAO {
	public int checkPassword(String userID, String password) {
		String encrypted = password;// MyEnc(password);
		System.out.println("logging  <" + userID + "> <" + password + ">");

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select IMAGE photo,us.* from biis.userinfo us,establishment.PERSONNEL ps where us.USERID=ps.LOGIN_ID and userid = ?";
		System.out.println("sql :: " + sql);

		String filename = "/resources/userimages/Departure_"+ Integer.toString((int) (Math.random() * 2100000000))+ ".jpeg";
		
		ResultSet r = null;
		UserDTO dto = null;
		int i = 1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			r = pstmt.executeQuery();	 
			if (r != null && r.next()) {
				filename = "/resources/userimages/"+ r.getString("userid")+ ".jpg";
				dto = new UserDTO();
				dto.setUsername(r.getString("userid"));
				dto.setPassword(r.getString("PASSWORD"));
				dto.setEncryption(r.getString("ENCRYPTED"));
				if (encrypted != null && encrypted.equals(dto.getEncryption()) == false) {
					i = 0;
				}
				Blob blob = r.getBlob("photo");
				if (blob != null)
				{
					try
					{
						RandomAccessFile raf = new RandomAccessFile(ServletActionContext.getServletContext().getRealPath("") + filename,"rw");
						int length = (int) blob.length();
						byte[] _blob = blob.getBytes(1, length);
						raf.write(_blob);
						raf.close();
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			} else {
				i = 0;
			}
		} catch (Exception e){e.printStackTrace();}
 		finally{try{ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}conn = null;}
		return i;
	}

//	public String getDemoName(String username) {
//		Connection conn = ConnectionManager.getConnection();
//		PreparedStatement stmt = null;
//		String demo = "";
//		String sql = "select demoname from demo_user where username = ?";
//		System.out.println("sql: " + sql);
//		try {
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, username);
//
//			ResultSet r = stmt.executeQuery();
//
//			while (r.next()) {
//				demo = r.getString("demoname");
//			}
//		} catch (Exception e){e.printStackTrace();}
// 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
//		{e.printStackTrace();}stmt = null;conn = null;}
//		return demo;
//	}

	public String getPassword(String username) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String password = "";
		String sql = "select ENCRYPTED from biis.userinfo where userid =?";
		System.out.println("sql: " + sql);
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);

			ResultSet r = stmt.executeQuery();

			while (r.next()) {
				password = r.getString("ENCRYPTED");
			}
		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return password;
	}
	
	
	public boolean updatePassword1(String username, String newpass,
			String newpassenc, String oldpass,IpAddressDTO ipAddressDTO) {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = null;
			String password = "";
			String sql = "update BIIS.USERINFO set PASSWORD = ?,ENCRYPTED = ? where USERID = ?";
			System.out.println("sql: " + sql);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, newpass);
				stmt.setString(2, newpassenc);
				stmt.setString(3, username);
				stmt.executeUpdate();
			//	stmt.close();

				sql = "insert into MCENTER.log_changepass(user_id,OLDPASS,CHANGE_TIME,REMOTE_ADDRESS,VIA,XFORWARD) values(?,?,sysdate,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, username);
				stmt.setString(2, oldpass);
	            stmt.setString(3, ipAddressDTO.getRemoteAddress());
				stmt.setString(4, ipAddressDTO.getVia());
				stmt.setString(5, ipAddressDTO.getxForward());
				stmt.executeUpdate();

			} 
			catch (Exception e)
			{
				
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("ERROR:"+e1.toString());
				}
				e.printStackTrace();
			//	System.out.println("ERROR:"+e.toString());
					
			return Boolean.FALSE;}
	 				    
				finally{
					try{
						stmt.close();
						conn.close();
						} 
					catch (Exception e){
							e.printStackTrace();
						}
					stmt = null;
					conn = null;
				}
				
				return Boolean.TRUE;
		}

	
	public boolean updatePassword(String username, String newpass,
			String newpassenc, String oldpass) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String password = "";
		String sql = "update user_tbl set password = ?,encryptedpass = ? where user_name = ?";
		System.out.println("sql: " + sql);
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newpass);
			stmt.setString(2, newpassenc);
			stmt.setString(3, username);
			stmt.executeUpdate();
			stmt.close();

			sql = "insert into log_changepass(user_id,OLDPASS,CHANGE_TIME) values(?,?,sysdate)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, oldpass);
			stmt.executeUpdate();

		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return true;
	}
	
	
	public boolean updateProfile(String user_name,String fname, String udesig,FileInputStream inputFileInputStream) 
	{
		Connection conn = ConnectionManager.getConnection();
		OutputStream        blobOutputStream        = null;
		PreparedStatement stmt = null;
		ResultSet           rset                    = null;
		BLOB                image                   = null;
		int                 bufferSize;
		byte[]              byteBuffer;
		int                 bytesRead               = 0;
		int                 bytesWritten            = 0;
		int                 totBytesRead            = 0;
		int                 totBytesWritten         = 0;
		
		String sql = "update user_tbl set USER_FULL_NAME=?,USER_DESIGNATION=?,photo= EMPTY_BLOB() where USER_NAME=?";
		System.out.println("sql: " + sql);
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, fname);
			stmt.setString(2, udesig);
			stmt.setString(3, user_name);
			stmt.executeUpdate();
			stmt.close();

			sql = "SELECT photo FROM   user_tbl WHERE  USER_NAME=? FOR UPDATE";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user_name);
			rset = stmt.executeQuery();
			rset.next();
			image = ((OracleResultSet) rset).getBLOB("PHOTO");
			bufferSize = image.getBufferSize();
			byteBuffer = new byte[bufferSize];
			blobOutputStream = image.getBinaryOutputStream();
			while ((bytesRead = inputFileInputStream.read(byteBuffer)) != -1) {
				blobOutputStream.write(byteBuffer, 0, bytesRead);
				totBytesRead += bytesRead;
				totBytesWritten += bytesRead;
			}
			inputFileInputStream.close();
			blobOutputStream.close();
			conn.commit();
			
			

		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return true;
	}	

	public boolean isValidUser(String username) {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String demo = "";
		String sql = "select userid from biis.userinfo where userid = ?";
		System.out.println("sql: " + sql);
		if(username.trim().equalsIgnoreCase(""))
			return false;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username.trim());

			ResultSet r = stmt.executeQuery();

			if (r.next()) {
					return false;
			}
		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return true;
	}
}
