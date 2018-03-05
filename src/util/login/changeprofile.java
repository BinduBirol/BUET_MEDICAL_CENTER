package util.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import table.user.UserDAO;
import table.userrole.UserRoleDTO;
import util.encryption.KeyPacket;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class changeprofile extends ActionSupport {
	private ServletContext servlet;
	private String user_name;
	private String fname;
	private String udesig;


	public ServletContext getServletContext()
	{
		return servlet;
	}

	public void setServletContext(ServletContext servlet)
	{
		this.servlet = servlet;
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUdesig() {
		return udesig;
	}

	public void setUdesig(String udesig) {
		this.udesig = udesig;
	}

	public String execute() {
		if(ServletActionContext.getRequest().getSession().getAttribute("uploadImageRand")==null)
			return "input";
		String realpath = ServletActionContext.getServletContext().getRealPath("");
		String filepath = "/resources/userimages/"+ServletActionContext.getRequest().getSession().getId()+ServletActionContext.getRequest().getSession().getAttribute("uploadImageRand")+".jpeg";
		UserDAO udao = new UserDAO();
		FileInputStream     inputFileInputStream    = null;
		OutputStream        blobOutputStream        = null;
		File            inputBinaryFile         = null;
		try
		{
			inputBinaryFile         = new File(realpath+filepath);
			inputFileInputStream    = new FileInputStream(inputBinaryFile);
			udao.updateProfile(user_name, fname, udesig, inputFileInputStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        

		return SUCCESS;
	}


	public void validate() {

	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
