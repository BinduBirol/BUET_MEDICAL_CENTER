package util.interceptor;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.RequestUtils;
import org.apache.struts2.ServletActionContext;
import util.Index;
import util.login.CheckValidity;
import util.login.ValidateUser;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class WebInterceptor implements Interceptor
{

	public void destroy(){}
	public void init(){}
	


	
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{
//		String currentAction=ServletActionContext.getRequest().getServletPath().replace("/", "");
		
		/********************/
		HttpServletRequest request = ServletActionContext.getRequest();
	    String targetUrl = request.getServletPath();
	    if (request.getQueryString() != null) {
	        targetUrl += "?" + request.getQueryString();
	    }
	    targetUrl=targetUrl.replace("/", "");
		/*******************/
		ServletActionContext.getRequest().getSession().setAttribute("currentAction",targetUrl);
		

		
		return actionInvocation.invoke();

	}
	
	
}
