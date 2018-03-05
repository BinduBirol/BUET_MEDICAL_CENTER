package util.login;

import java.math.BigInteger;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import table.user.UserDAO;
import table.userrole.UserRoleDTO;
import util.encryption.KeyPacket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import util.BaseAction;


public class ChangePassword1  extends BaseAction {
	private String old_password;
	private String new_password;
	private String retypenew_password;
	
	private static final long serialVersionUID = 1911305153650883231L;

	
	public String changePassword(){
		
/*		KeyPacket pack = (KeyPacket) ServletActionContext.getRequest()
				.getSession().getAttribute("kpacket");
		String modulus = pack.getModulus();
		BigInteger biginteger = new BigInteger(pack.getDkey(), 16);
		BigInteger biginteger1 = new BigInteger(modulus, 16);*/
		
   		Map<String, Object> session = ActionContext.getContext().getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
/*		
		System.out.println(user.getUserfullname());
		System.out.println(user.getUserdesignation());
		System.out.println(user.getUsername());
		*/
		EncryptPassword enc = new EncryptPassword();
		String oldpassenc = enc.MyEnc(old_password);
		String newpassenc = enc.MyEnc(new_password);
		UserDAO udao = new UserDAO();
		
		String oldpasswordDB=udao.getPassword(user.getUsername());
/*		DecryptPassword dc = new DecryptPassword();
		String oldpassword=dc.rsadecrypt(oldpasswordDB,biginteger, biginteger1);
		System.out.println(oldpassword);*/
		if((old_password!=null && new_password!=null && retypenew_password!=null) && new_password.equalsIgnoreCase(retypenew_password)){
		if(oldpasswordDB.equalsIgnoreCase(oldpassenc))
		{
			boolean resp=udao.updatePassword1(user.getUsername(), new_password,newpassenc,old_password,ipAddressDTO); 

			
			 if (resp == true) {
					request.setAttribute("message","SUCCESS");
				} 
				else {
					request.setAttribute("message","ERROR1");
				   
				}
		}
		
		else
		{
			request.setAttribute("message","ERROR2");
		}

		}
		
		else
		{
			request.setAttribute("message","ERROR3");
		}
		
	
		
		return "success";
		
		
	}
	

	

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getRetypenew_password() {
		return retypenew_password;
	}

	public void setRetypenew_password(String retypenew_password) {
		this.retypenew_password = retypenew_password;
	}



}
