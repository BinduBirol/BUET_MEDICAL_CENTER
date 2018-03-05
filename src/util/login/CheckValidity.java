package util.login;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;



import org.apache.struts2.ServletActionContext;

import table.user.UserDAO;
import table.userrole.UserRoleDAO;
import table.userrole.UserRoleDTO;
import util.encryption.KeyPacket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckValidity extends ActionSupport
{
	private String username;
	private String password;


	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String execute() throws Exception
	{
				
		UserDAO userdao = new UserDAO();	
			

		
		KeyPacket pack = (KeyPacket)ServletActionContext.getRequest().getSession().getAttribute("kpacket");	
		String modulus = pack.getModulus();
		BigInteger biginteger = new BigInteger(pack.getDkey(), 16);
		BigInteger biginteger1 = new BigInteger(modulus, 16);
		DecryptPassword dc = new DecryptPassword();
		password = dc.rsadecrypt(password, biginteger, biginteger1);
		
		EncryptPassword enc = new EncryptPassword();
		String encpass = enc.MyEnc(password);
		
		if (getUsername()!=null && getUsername().equals(""))
		{
			addActionError("Blank user name ! Please try again!");
			return ERROR;
		} else if (getPassword()!=null && getPassword().equals(""))
		{

			setUsername(username);
			addActionError("Blank password! Please try again!");
			return ERROR;
		}
		else if (userdao.checkPassword(getUsername(),encpass)!=1)
//		else if (userdao.checkPassword(getUsername(),getPassword())!=1)
		{
			addActionError("Invalid user name or password! Please try again!");
			return ERROR;
		} 
		else
		{
			
			Map session1 = ActionContext.getContext().getSession();
			ServletActionContext.getRequest().getSession().setAttribute("web_language","english");
			UserRoleDAO urole = new UserRoleDAO(); 
			UserRoleDTO udto = urole.getUserRole(username) ;
			String filename = "/resources/userimages/"+ getUsername()+ ".jpg";
			File f = new File(ServletActionContext.getServletContext().getRealPath("")+filename);
			if(f.exists())
				udto.setHasphoto("yes");
			else
				udto.setHasphoto("no");
			
			session1.put("user_role", udto);
			session1.put("user_id", username);
			/************/
			
			
			
			return SUCCESS;
		}
	}
}
