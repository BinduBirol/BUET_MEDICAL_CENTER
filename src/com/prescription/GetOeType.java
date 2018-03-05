package com.prescription;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.table.PrescriptionDTO;

public class GetOeType extends ActionSupport {


    public String execute() throws Exception {

        String id = (String) ServletActionContext.getRequest().getParameter("id");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionDTO> list = pdao.getOetypeList(id);

        String str = "";

        
        if(id.equalsIgnoreCase("50")){
        	str = "";
        	str+="<td><input type='text' name='oetype'  id='oetypeid_" + index + "' style='width:100px'></td>";
        	
        }
        else{     
        

        if (list.size() > 0) 
        	{
            str = "";
            str += "<select  name='oetype' value='oetypeid' id='oetypeid_" + index + "' style='width:100px' >";
            str += "<option value='0'>--Select-- " +
                    "</option>";

            for (PrescriptionDTO o : list) 
	            {
	                str += "<option value='" + o.getOetypeid() + "'>" + o.getOetype() + "</option>";
	            }
            str += "</select>";
        	}
        else        	
		        {
        			str+="<td><input type='hidden' name='oetype'  id='oetypeid_'"+id+"></td>";      	
		        }
        }		
        try {

            ServletActionContext.getResponse().getWriter().write(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}