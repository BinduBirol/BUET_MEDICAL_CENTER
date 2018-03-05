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

public class TestController  extends ActionSupport implements ServletContextAware{
	private static final long serialVersionUID = 7804988860793303415L;
	private ServletContext servlet;
	
	public String execute() throws Exception {
			
		TeDAO tDAO= new TeDAO();
		ServletActionContext.getRequest().getParameter("action");
		if(ServletActionContext.getRequest().getParameter("action")!=null){
			List<TestDTO> lstTest=new ArrayList<TestDTO>();
			String action=(String)ServletActionContext.getRequest().getParameter("action");
			Gson gson = new Gson();
			//response.setContentType("application/json");
			
			ServletActionContext.getResponse().setContentType("application/json");
			
						
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
					lstTest=tDAO.getAllTests();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstTest, new TypeToken<List<TestDTO>>() {}.getType());
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
				TestDTO test=new TestDTO();
				if(ServletActionContext.getRequest().getParameter("testTypeID")!=null){				   
					String testTypeID=(String)ServletActionContext.getRequest().getParameter("testTypeID");
				   test.setTestTypeID(testTypeID);
				}
				if(ServletActionContext.getRequest().getParameter("testNameID")!=null){
					String testNameID=(String)ServletActionContext.getRequest().getParameter("testNameID");
					test.setTestNameID(testNameID);
				}
				if(ServletActionContext.getRequest().getParameter("testName")!=null){				   
					String testName=(String)ServletActionContext.getRequest().getParameter("testName");
					   test.setTestName(testName);
					}
				if(ServletActionContext.getRequest().getParameter("vat")!=null){
					Double vat=Double.parseDouble(ServletActionContext.getRequest().getParameter("vat"));
					test.setVat(vat);
				}
				if(ServletActionContext.getRequest().getParameter("rate")!=null){				   
					Double rate=Double.parseDouble(ServletActionContext.getRequest().getParameter("rate"));
					   test.setRate(rate);
					}
				if(ServletActionContext.getRequest().getParameter("status")!=null){
					String status=(String)ServletActionContext.getRequest().getParameter("status");
					test.setStatus(status);
				}
				
						
				
				try{											
					if(action.equals("create")){//Create new record
						tDAO.addTest(test);
						lstTest.add(test);
						
						//Convert Java Object to Json				
						String json=gson.toJson(test);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						ServletActionContext.getResponse().getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						tDAO.updateTest(test);
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
					if(ServletActionContext.getRequest().getParameter("testNameID")!=null){
						//String testTypeID=(String)ServletActionContext.getRequest().getParameter("testTypeID");
						String testNameID=(String)ServletActionContext.getRequest().getParameter("testNameID");
						tDAO.deleteTest(testNameID);						
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

