package store.etc;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;

import store.receive.StoreReceiveDAO;

import com.opensymphony.xwork2.ActionSupport;

public class GetItemList extends ActionSupport {

	public String execute() throws Exception {

        String companyid = (String) ServletActionContext.getRequest().getParameter("companyid");
        String genid = (String) ServletActionContext.getRequest().getParameter("genid");
        String rowid = (String) ServletActionContext.getRequest().getParameter("rowid");
        
        //Integer row = Integer.parseInt(rowid)-1;
        
        
        StoreReceiveDAO sDAO = new StoreReceiveDAO();
        Map<Integer,String> mapmedicine = new TreeMap<Integer,String>();
        
        mapmedicine = sDAO.getSelectMedicine(companyid,genid);

        String str = "";

        
        str += "<select  name='medid'  id='medid_'"+rowid+" style='width: 168px'>";
  	  	str += "<option value='-1'>Select" +
  	  		   "</option>";
        
        for(Map.Entry<Integer,String> entry : mapmedicine.entrySet()) {
        	  
        	  str += "<option value='" + entry.getKey() + "'>" + entry.getValue() + "</option>";
        	  
        	}
        str += "</select>";
        
               	
        	

        try {

            ServletActionContext.getResponse().getWriter().write(str);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

	
	
}
