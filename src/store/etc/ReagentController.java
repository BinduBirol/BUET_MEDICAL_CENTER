package store.etc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

public class ReagentController extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		ReagentDAO reagentDAO= new ReagentDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<Reagent> lstReagent=new ArrayList<Reagent>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
					lstReagent=reagentDAO.getAllReagents();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstReagent, new TypeToken<List<Reagent>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				ServletActionContext.getResponse().getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					ServletActionContext.getResponse().getWriter().print(error);
					ex.printStackTrace();
				}	
								
			}
			else if(action.equals("create") || action.equals("update")){
				Reagent reagent = new Reagent();
				
				if(ServletActionContext.getRequest().getParameter("reagentid")!=null){				   
					   Long reagentid=Long.parseLong(ServletActionContext.getRequest().getParameter("reagentid"));
					   reagent.setReagentid(reagentid);
					}
				if(ServletActionContext.getRequest().getParameter("reagentname")!=null){
					String reagentname=(String)ServletActionContext.getRequest().getParameter("reagentname");
					reagent.setReagentname(reagentname);
				}
										
				
				try{											
					if(action.equals("create")){//Create new record
						reagentDAO.addReagent(reagent);
						lstReagent.add(reagent);
						
						//Convert Java Object to Json				
						String json=gson.toJson(reagent);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						reagentDAO.updateReagent(reagent);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						ServletActionContext.getResponse().getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(ServletActionContext.getRequest().getParameter("reagentid")!=null){
						String reagentid=(String)ServletActionContext.getRequest().getParameter("reagentid");
						reagentDAO.deleteReagent(Long.parseLong(reagentid));						
						String listData="{\"Result\":\"OK\"}";								
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				ServletActionContext.getResponse().getWriter().print(error);
			}				
		}
	 }
		return null;
  }

	public ServletContext getServlet() {
		return servlet;
	}
	public void setServlet(ServletContext servlet) {
		this.servlet = servlet;
	}

	public void setServletContext(ServletContext servlet) {
		this.servlet = servlet;
	}
	

}
