package store.issue;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GetThreeItem extends ActionSupport {

	public String execute() throws Exception {

        
        String medid = (String) ServletActionContext.getRequest().getParameter("medid");
        String rowid = (String) ServletActionContext.getRequest().getParameter("rowid");
        
      
        
        StoreIssueDAO sDAO = new StoreIssueDAO();
       
        String str = sDAO.getThreeItem(medid);

                	

        try {

            ServletActionContext.getResponse().getWriter().write(str);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

	
	
}