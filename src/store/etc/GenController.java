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

public class GenController extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		GenDAO mDAO= new GenDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<Generic> lstGeneric=new ArrayList<Generic>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstGeneric=mDAO.getAllGenerics();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstGeneric, new TypeToken<List<Generic>>() {}.getType());
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
				Generic generic=new Generic();
				
				if(ServletActionContext.getRequest().getParameter("genid")!=null){				   
					   Long genid=Long.parseLong(ServletActionContext.getRequest().getParameter("genid"));
					   generic.setGenid(genid);
					}
				if(ServletActionContext.getRequest().getParameter("genname")!=null){
					String genname=(String)ServletActionContext.getRequest().getParameter("genname");
					generic.setGenname(genname);
				}
										
				
				try{											
					if(action.equals("create")){//Create new record
						mDAO.addGeneric(generic);
						lstGeneric.add(generic);
						
						//Convert Java Object to Json				
						String json=gson.toJson(generic);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						mDAO.updateGeneric(generic);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						ServletActionContext.getResponse().getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(ServletActionContext.getRequest().getParameter("genid")!=null){
						String genid=(String)ServletActionContext.getRequest().getParameter("genid");
						mDAO.deleteGeneric(Long.parseLong(genid));						
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
