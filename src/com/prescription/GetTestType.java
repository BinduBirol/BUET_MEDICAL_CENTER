package com.prescription;


import com.opensymphony.xwork2.ActionSupport;
import com.table.PrescriptionDTO;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;


public class GetTestType extends ActionSupport {


    public String execute() throws Exception {

        String id = (String) ServletActionContext.getRequest().getParameter("id");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionDTO> testlist = pdao.getTestList(id);

        String str = "";


        if (testlist.size() > 0) {


            str = "";
            str += "<select  name='testname' value='testid' id='testid_" + index + "'  onchange='fetchTstPrVt("+index+")' style='width:150px' >";
            str += "<option value='0'>--Select Test-- " +
                    "</option>";
            
            for (PrescriptionDTO o : testlist) {
                str += "<option value='" + o.getTestid() + "'>" + o.getTestname() + "</option>";

            }
            str += "</select>";

        }
        else
        	   	{
	    			str+="<td><input type='hidden' name='testname' value='No Subtype' id='testid_'"+id+"></td>";      	
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
