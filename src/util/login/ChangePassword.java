package util.login;

import java.math.BigInteger;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import table.user.UserDAO;
import table.userrole.UserRoleDTO;
import util.encryption.KeyPacket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePassword extends ActionSupport {
	private Password password;
	private Password password_err;

	public Password getPassword_err() {
		return password_err;
	}

	public void setPassword_err(Password password_err) {
		this.password_err = password_err;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public String execute() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserRoleDTO user = (UserRoleDTO) session.get(ValidateUser.validate_value);
		EncryptPassword enc = new EncryptPassword();
		String newpassenc = enc.MyEnc(password.getNewpassword());
		UserDAO udao = new UserDAO();
		if (!udao.updatePassword(user.getUsername(), password.getNewpassword(),
				newpassenc,password.getOldpassword())) {
			return "failure";
		}

		return SUCCESS;
	}

	public void decrypt() {
		KeyPacket pack = (KeyPacket) ServletActionContext.getRequest()
				.getSession().getAttribute("kpacket");
		String modulus = pack.getModulus();
		BigInteger biginteger = new BigInteger(pack.getDkey(), 16);
		BigInteger biginteger1 = new BigInteger(modulus, 16);
		DecryptPassword dc = new DecryptPassword();
		password.setOldpassword(dc.rsadecrypt(password.getOldpassword(),
				biginteger, biginteger1));
		password.setNewpassword(dc.rsadecrypt(password.getNewpassword(),
				biginteger, biginteger1));
		password.setNewpasswordretype(dc.rsadecrypt(password
				.getNewpasswordretype(), biginteger, biginteger1));
	}

	public void validate() {
		password_err = new Password();
		decrypt();
		boolean flag = false;
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		UserRoleDTO user = (UserRoleDTO) session
				.get(ValidateUser.validate_value);
		UserDAO udao = new UserDAO();
		String oldpass = udao.getPassword(user.getUsername());

		if (password.getOldpassword().equalsIgnoreCase("")) {
			flag = true;
			password_err.setOldpassword("Insert old password");
		}
		EncryptPassword enc = new EncryptPassword();
		
		if (!oldpass.equals(enc.MyEnc(password.getOldpassword()))) {
			flag = true;
			password_err.setOldpassword("Password not mathced");
		}
		if (password.getNewpassword().equals("")) {
			flag = true;
			password_err.setNewpassword("Insert new password");
		}
		if(password.getNewpassword().length() < 8)
		{
			flag = true;
			password_err.setNewpassword("Password must be at least 8 character long.");
		}
		if(password.getNewpassword().length() > 20)
		{
			flag = true;
			password_err.setNewpassword("Password can be at most 20 character long.");
		}
		if (password.getNewpasswordretype().equals("")) {
			flag = true;
			password_err.setNewpasswordretype("Retype new password");
		}

		if (!password.getNewpassword().equals(password.getNewpasswordretype())) {
			flag = true;
			password_err.setNewpassword("Password not matched");
		}

		if (flag)
			addActionError("Please correct the following validations");
	}

}
