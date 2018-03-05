package util.login;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class Logout extends ActionSupport
{


	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
		    try {
		        ((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
		    } catch (IllegalStateException e) {
		        //logger.error(msg, e);
		    }
		}
		
		
		ServletActionContext.getRequest().getSession().setAttribute("currentpage", "home");
		
		
	    session.put("currentpage", "home");	    
	    ServletActionContext.getRequest().getSession().setAttribute("currentAction","index");
	    
	    
		return SUCCESS;
	}
}
