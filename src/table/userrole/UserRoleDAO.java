package table.userrole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import table.user.UserDTO;
import util.ConnectionUtil.ConnectionManager;

public class UserRoleDAO
{
	public UserRoleDTO getUserRole(String username)
	{
		String sql = "";


		sql="SELECT  us.USERID,ps.NAME,dg.FULL_DESIGNATION ,11 rolei,us.ROLEID, activityname, " +
		"      jsppage,serialno, link,  maingroupid  ,PS.OFFICIAL_ID      " +
		"  FROM biis.USERINFO us, biis.activity ac, establishment.PERSONNEL ps, establishment.DESIGNATION dg " +
		"  WHERE   us.userid = '" + username + "' and us.ROLEID=ac.ROLEID " +
		"  and us.USERID=ps.LOGIN_ID " +
		"  and ps.CURRENT_DESIGNATION_ID=dg.DESIGNATION_ID " +
		"  ORDER BY maingroupid, serialno ";

		
		Connection conn = ConnectionManager.getConnection();
		Statement stmt = null;

		System.out.println("sql :: " + sql);

		ResultSet r = null;
		UserRoleDTO rdto = null;
		RoleOperationDTO roleop = null;
		OperationDTO op = null;
		String roleid = "";
		String operatiid = "";
		String role = "";
		String opearation = "";

		try
		{
			stmt = conn.createStatement();
			r = stmt.executeQuery(sql);

			while (r.next())
			{
				if (rdto == null)
				{
					rdto = new UserRoleDTO();
					rdto.setUsername(username);
					rdto.setUserfullname(r.getString("NAME"));
					rdto.setUserdesignation(r.getString("FULL_DESIGNATION"));
					rdto.setOfficalid(r.getString("OFFICIAL_ID"));
					ArrayList<RoleOperationDTO> rlst = new ArrayList<RoleOperationDTO>();
					rdto.setRolelist(rlst);
				}

				op = new OperationDTO();
				op.setOperationid(r.getInt("serialno"));
				op.setOperationname(r.getString("activityname"));
				op.setOperationdesc(r.getString("activityname"));
				op.setLink(r.getString("jsppage"));
				role = r.getString("rolei");
				if (!roleid.equalsIgnoreCase(role))
				{
					if (roleop != null)
					{
						ArrayList<RoleOperationDTO> tmplst = rdto.getRolelist();
						tmplst.add(roleop);
						rdto.setRolelist(tmplst);
					}
					roleop = new RoleOperationDTO();
					roleop.setRoleid(r.getInt("rolei"));
					roleop.setRolename(r.getString("ROLEID"));
					roleop.setRoledesc("description");
					ArrayList<OperationDTO> lst = new ArrayList<OperationDTO>();
					roleop.setOpearationlist(lst);
				}

				ArrayList<OperationDTO> alist = roleop.getOpearationlist();
				alist.add(op);
				roleop.setOpearationlist(alist);
			}

			if (rdto != null && roleop != null)
			{
				ArrayList<RoleOperationDTO> tmplst = rdto.getRolelist();
				tmplst.add(roleop);
				rdto.setRolelist(tmplst);
			}
		} catch (Exception e){e.printStackTrace();}
 		finally{try{stmt.close();ConnectionManager.closeConnection(conn);} catch (Exception e)
		{e.printStackTrace();}stmt = null;conn = null;}

		return rdto;
	}
}
