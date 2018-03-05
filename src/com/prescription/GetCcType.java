package com.prescription;


import com.opensymphony.xwork2.ActionSupport;
import com.table.PrescriptionDTO;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;


public class GetCcType extends ActionSupport {


    public String execute() throws Exception {

        String id = (String) ServletActionContext.getRequest().getParameter("id");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionDTO> list = pdao.getCctypeList(id);

        String str = "";

if(id.equalsIgnoreCase("50")){
	str = "";
	str+="<td><input type='text' name='cctype'  id='cctypeid_" + index + "' style='width:100px'></td>";
	
}

else{
	
	str = "";
	str+="<td><input type='text' name='cctype'  id='cctypeid_" + index + "' style='width:100px'></td>";
	
}
/*else{
        if (list.size() > 0) 
        	{
            str = "";
            str += "<select  name='cctype' value='cctypeid' id='cctypeid_" + index + "' style='width:100px' >";
            str += "<option value='0'>--Select-- " +
                    "</option>";

            for (PrescriptionDTO o : list) 
	            {
	                str += "<option value='" + o.getCctypeid() + "'>" + o.getCctype() + "</option>";
	            }
            str += "</select>";
        	}
        else        	
		        {
        			str+="<td><input type='hidden' name='cctype'  id='cctypeid_'"+id+"></td>";      	
		        }
}	*/	
        try {

            ServletActionContext.getResponse().getWriter().write(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
