package store.test;


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

public class TestTypeController  extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		TestTypeDAO tDAO= new TestTypeDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<TestTypeDTO> lstTest=new ArrayList<TestTypeDTO>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
					lstTest=tDAO.getAllTestTypes();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstTest, new TypeToken<List<TestTypeDTO>>() {}.getType());
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
				TestTypeDTO test=new TestTypeDTO();
				if(ServletActionContext.getRequest().getParameter("testTypeID")!=null){				   
					String testTypeID=(String)ServletActionContext.getRequest().getParameter("testTypeID");
				   test.setTestTypeID(testTypeID);
				}
				if(ServletActionContext.getRequest().getParameter("testType")!=null){
					String testType=(String)ServletActionContext.getRequest().getParameter("testType");
					test.setTestType(testType);
				}
				
				try{											
					if(action.equals("create")){//Create new record
						tDAO.addTestType(test);
						lstTest.add(test);
						
						//Convert Java Object to Json				
						String json=gson.toJson(test);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						tDAO.updateTestType(test);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					   }
					
					//////////////////////
					
					/*else if(action.equals("delete")){//Update existing record
						tDAO.deleteTest(test);
						String listData="{\"Result\":\"OK\"}";									
						ServletActionContext.getResponse().getWriter().print(listData);
					   }*/
					/////////////////////////////////
				      }
				
				catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						ServletActionContext.getResponse().getWriter().print(error);
				}
			}
			
			///////////////////////////////////
			else if(action.equals("delete")){//Delete record
				try{
					if(ServletActionContext.getRequest().getParameter("testTypeID")!=null){
						//String testTypeID=(String)ServletActionContext.getRequest().getParameter("testTypeID");
						String testTypeID=(String)ServletActionContext.getRequest().getParameter("testTypeID");
						tDAO.deleteTestType(testTypeID);						
						String listData="{\"Result\":\"OK\"}";								
						ServletActionContext.getResponse().getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				ServletActionContext.getResponse().getWriter().print(error);
			}				
		}
	//////////////////////////////////////////////		
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

