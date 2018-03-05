package table.userrole;

import java.util.ArrayList;

public class RoleOperationDTO
{
	private int roleid;
	private String rolename;
	private String roledesc;
	private ArrayList<OperationDTO> opearationlist; //contains OperationDTO
	public int getRoleid()
	{
		return roleid;
	}
	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}
	public String getRolename()
	{
		return rolename;
	}
	public void setRolename(String rolename)
	{
		this.rolename = rolename;
	}
	public String getRoledesc()
	{
		return roledesc;
	}
	public void setRoledesc(String roledesc)
	{
		this.roledesc = roledesc;
	}
	public ArrayList<OperationDTO> getOpearationlist()
	{
		return opearationlist;
	}
	public void setOpearationlist(ArrayList<OperationDTO> opearationlist)
	{
		this.opearationlist = opearationlist;
	}
}
