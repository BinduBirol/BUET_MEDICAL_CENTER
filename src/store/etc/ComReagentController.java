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

public class ComReagentController extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		ComDAO mDAO= new ComDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<Company> lstCompany=new ArrayList<Company>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstCompany=mDAO.getAllReagentCompanies();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstCompany, new TypeToken<List<Company>>() {}.getType());
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
				Company company=new Company();
				
				if(ServletActionContext.getRequest().getParameter("companyid")!=null){				   
					   Long companyid=Long.parseLong(ServletActionContext.getRequest().getParameter("companyid"));
					   company.setCompanyid(companyid);
					}
				if(ServletActionContext.getRequest().getParameter("companyname")!=null){
					String companyname=(String)ServletActionContext.getRequest().getParameter("companyname");
					company.setCompanyname(companyname);
				}
										
				
				try{											
					if(action.equals("create")){//Create new record
						mDAO.addReagentCompany(company);
						lstCompany.add(company);
						
						//Convert Java Object to Json				
						String json=gson.toJson(company);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						mDAO.updateReagentCompany(company);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						ServletActionContext.getResponse().getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(ServletActionContext.getRequest().getParameter("companyid")!=null){
						String companyid=(String)ServletActionContext.getRequest().getParameter("companyid");
						mDAO.deleteReagentCompany(Long.parseLong(companyid));						
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

