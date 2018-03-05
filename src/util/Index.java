package util;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport
{
	

	public String execute() throws Exception {
		
		ServletActionContext.getRequest().getSession().setAttribute("currentpage", "home");
		
		//SiteTextDAO stdao=new SiteTextDAO();
		//SiteNewsDAO snpdao=new SiteNewsDAO();
		
		String language="";
//		if(ServletActionContext.getRequest().getSession().getAttribute("web_language")!=null)
//		 language=(String)ServletActionContext.getRequest().getSession().getAttribute("web_language");
//		else
		 language="english";
		
	    //String hometop=stdao.getSavedText("home","1",language);
	    //String newsleft=stdao.getSavedText("news","1",language);
	    //String newstop=stdao.getSavedText("news","2",language);
	    //sitenewsList=snpdao.getSavedNews(language,ServletActionContext.getServletContext().getRealPath(""));
	    
	    Map session = ActionContext.getContext().getSession();
	    
	    ///session.put("currentpage", "home");
	    //session.put("hometop", hometop);
	    //session.put("newsleft", newsleft);
	    //session.put("newstop", newstop);
	    //session.put("sitenewsList",sitenewsList);
	    session.put("web_language",language);
	    
	    
	    ///ServletActionContext.getRequest().getSession().setAttribute("currentpage", "home");
	    //ServletActionContext.getRequest().getSession().setAttribute("hometop", hometop);
	    //ServletActionContext.getRequest().getSession().setAttribute("newsleft", newsleft);
	    //ServletActionContext.getRequest().getSession().setAttribute("newstop", newstop);
	    //ServletActionContext.getRequest().getSession().setAttribute("sitenewsList", sitenewsList);
	    
	    ServletActionContext.getRequest().getSession().setAttribute("web_language",language);
	    
        return SUCCESS;
    }
  }
	
