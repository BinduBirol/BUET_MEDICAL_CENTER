package store.etc;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class EtcLoadAction extends ActionSupport {

	private static final long serialVersionUID = 8781563903084693648L;

	
	public String execute()
	{
		String type = (String) ServletActionContext.getRequest().getParameter("type");
		
		
		return type;
	}
		
	
	
	
}
