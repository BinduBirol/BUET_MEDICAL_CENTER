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

public class MedController extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		MedDAO mDAO= new MedDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<Medicine> lstMedicine=new ArrayList<Medicine>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
				lstMedicine=mDAO.getAllMedicines();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstMedicine, new TypeToken<List<Medicine>>() {}.getType());
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
				Medicine medicine=new Medicine();
				if(ServletActionContext.getRequest().getParameter("medid")!=null){				   
				   Long medid=Long.parseLong(ServletActionContext.getRequest().getParameter("medid"));
				   medicine.setMedid(medid);
				}
				if(ServletActionContext.getRequest().getParameter("medname")!=null){
					String medname=(String)ServletActionContext.getRequest().getParameter("medname");
					medicine.setMedname(medname);
				}
				if(ServletActionContext.getRequest().getParameter("companyid")!=null){				   
					   Long companyid=Long.parseLong(ServletActionContext.getRequest().getParameter("companyid"));
					   medicine.setCompanyid(companyid);
					}
				if(ServletActionContext.getRequest().getParameter("companyname")!=null){
					String companyname=(String)ServletActionContext.getRequest().getParameter("companyname");
					medicine.setCompanyname(companyname);
				}
				if(ServletActionContext.getRequest().getParameter("genid")!=null){				   
					   Long genid=Long.parseLong(ServletActionContext.getRequest().getParameter("genid"));
					   medicine.setGenid(genid);
					}
				if(ServletActionContext.getRequest().getParameter("genname")!=null){
					String genname=(String)ServletActionContext.getRequest().getParameter("genname");
					medicine.setGenname(genname);
				}
				if(ServletActionContext.getRequest().getParameter("reorder")!=null){				   
					   Long reorder=Long.parseLong(ServletActionContext.getRequest().getParameter("reorder"));
					   medicine.setReorder(reorder);
					}
				if(ServletActionContext.getRequest().getParameter("unit")!=null){
					String unit=(String)ServletActionContext.getRequest().getParameter("unit");
					medicine.setUnit(unit);
				}
						
				
				try{											
					if(action.equals("create")){//Create new record
						mDAO.addMedicine(medicine);
						lstMedicine.add(medicine);
						
						//Convert Java Object to Json				
						String json=gson.toJson(medicine);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						mDAO.updateMedicine(medicine);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						ServletActionContext.getResponse().getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(ServletActionContext.getRequest().getParameter("medid")!=null){
						String medid=(String)ServletActionContext.getRequest().getParameter("medid");
						mDAO.deleteMedicine(Long.parseLong(medid));						
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

