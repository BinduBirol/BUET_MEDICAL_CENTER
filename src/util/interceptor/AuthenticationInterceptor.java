package util.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import util.Index;
import util.login.CheckValidity;
import util.login.ValidateUser;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor
{
	
	private String token;
	private String tokenname;
	
	
	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getTokenname()
	{
		return tokenname;
	}

	public void setTokenname(String tokenname)
	{
		this.tokenname = tokenname;
	}

	public void destroy()
	{
	}

	public void init()
	{
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception
	{

		HttpServletRequest request = ServletActionContext.getRequest();
		if(!request.isRequestedSessionIdValid())
			return "sessiontimeout";	
		
		Map session = actionInvocation.getInvocationContext().getSession();
		Object user = (Object) session.get(ValidateUser.validate_value);
		Object action = actionInvocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.getSession(true);
//		if(action instanceof PathRouter)return actionInvocation.invoke();
		 token = request.getParameter("struts.token");
		 tokenname = request.getParameter("struts.token.name");
		 boolean hello=request.isRequestedSessionIdValid();
	 
		if (action instanceof CheckValidity)
		{

			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			
			((CheckValidity) action).setUsername(username);
			((CheckValidity) action).setPassword(pass);

			return actionInvocation.invoke();

		}

		else if (user == null)
		{
			if (action instanceof Index)
				return actionInvocation.invoke();
			if (action instanceof ValidationAware)
			{
				((ValidationAware) action)
						.addActionError("You have to login first");
			}

			return ValidateUser.time_out;
		}

		
		
		return actionInvocation.invoke();

	}
	
	
}
