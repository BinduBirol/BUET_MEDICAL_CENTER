package table.userrole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.ConnectionUtil.ConnectionManager;

public class RoleDAO {

	public ArrayList<RoleOperationDTO> getAllValidRoleOperation(String userid) {
		return null;
	}

	public ArrayList<RoleOperationDTO> getAllRoleOperation() {
		String sql = "SELECT DISTINCT role_tbl.roleid, role_tbl.NAME rolename, "
				+ "role_tbl.description, "
				+ "operation_tbl.opcode, operation_tbl.NAME, "
				+ "operation_tbl.description operationdescription "
				+ "FROM role_tbl, "
				+ "role_operation_tbl, "
				+ "operation_tbl, "
				+ "activity_link "
				+ "WHERE activity_link.opcode = operation_tbl.opcode "
				+ "AND operation_tbl.opcode = role_operation_tbl.opcode "
				+ "AND role_operation_tbl.roleid = role_tbl.roleid "
				+ "ORDER BY roleid desc";

		Connection conn = ConnectionManager.getConnection();		
		Statement stmt = null;

		System.out.println("sql :: " + sql);

		ResultSet r = null;
		RoleOperationDTO roleop = null;
		OperationDTO op = null;
		String roleid = "";
		ArrayList<RoleOperationDTO> rolelist = new ArrayList<RoleOperationDTO>();
		try {
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next()) {
				if (!roleid.equalsIgnoreCase(r.getString("roleid"))) {
					roleid = r.getString("roleid");
					roleop = new RoleOperationDTO();
					roleop.setRoleid(r.getInt("roleid"));
					roleop.setRoledesc(r.getString("description"));
					roleop.setOpearationlist(new ArrayList<OperationDTO>());
					rolelist.add(roleop);
				}

				op = new OperationDTO();
				op.setOperationid(r.getInt("opcode"));
				op.setOperationdesc(r.getString("operationdescription"));
				roleop.getOpearationlist().add(op);
			}
		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return rolelist;
	}

	public boolean insertUserRole(ArrayList<String> roleid, String username,
			String password, String passwordenc) {
		String sql = "Select max(user_id) user_id from user_tbl";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;

		System.out.println("sql :: " + sql);
		ResultSet r = null;
		int userid = 0;

		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			r = stmt.executeQuery();
			if (r.next()) {
				userid = r.getInt("user_id");
				userid++;
			}
			stmt.close();
			
			if(roleid != null)
			{
			sql = "insert into user_role_tbl_new(user_id,roleid) values(?,?)";
			stmt = conn.prepareStatement(sql);

			for (int i = 0; i < roleid.size(); i++) {
				stmt.setInt(1, userid);
				stmt.setInt(2, Integer.parseInt(roleid.get(i)));
				stmt.executeUpdate();
				stmt.clearParameters();
			}

			stmt.close();
			}

			sql = "insert into user_tbl(USER_NAME,PASSWORD,USER_ID,ENCRYPTEDPASS) values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, userid);
			stmt.setString(4, passwordenc);
			stmt.executeUpdate();
			stmt.close();
			conn.commit();
			return true;

		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}
		return true;
	}

}
