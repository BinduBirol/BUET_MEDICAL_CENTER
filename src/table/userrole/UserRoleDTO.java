package table.userrole;

import java.util.ArrayList;

public class UserRoleDTO
{
	private String username;
	private ArrayList rolelist; //contains RoleOpearationDTO
	private String userfullname;
	private String userdesignation;
	private String officalid;
	
	private String hasphoto;
	
	
	
	public String getOfficalid() {
		return officalid;
	}
	public void setOfficalid(String officalid) {
		this.officalid = officalid;
	}
	public String getHasphoto() {
		return hasphoto;
	}
	public void setHasphoto(String hasphoto) {
		this.hasphoto = hasphoto;
	}
	public String getUserfullname() {
		return userfullname;
	}
	public void setUserfullname(String userfullname) {
		this.userfullname = userfullname;
	}
	public String getUserdesignation() {
		return userdesignation;
	}
	public void setUserdesignation(String userdesignation) {
		this.userdesignation = userdesignation;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public ArrayList getRolelist()
	{
		return rolelist;
	}
	public void setRolelist(ArrayList rolelist)
	{
		this.rolelist = rolelist;
	}
}
