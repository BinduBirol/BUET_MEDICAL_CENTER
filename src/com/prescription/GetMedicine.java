package com.prescription;


import com.opensymphony.xwork2.ActionSupport;
import com.table.PrescriptionDTO;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;


public class GetMedicine extends ActionSupport {


    /**
	 * 
	 */
	private static final long serialVersionUID = -3224479660297139450L;

	public String execute() throws Exception {

        String id = (String) ServletActionContext.getRequest().getParameter("id");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionDTO> medicinelist = pdao.getMedicineList(id);

        String str = "";


        if (medicinelist.size() > 0) {


            str = "";
            str += "<select  name='drugname' value='drugid' id='drugid_" + index + "' onchange='fetchTwoRx("+index+")' style='width:180px'>";
            str += "<option value='0'>--Select Medicine -- " +
                    "</option>";

            for (PrescriptionDTO o : medicinelist) {
                str += "<option value='" + o.getDrugid() + "'>" + o.getDrugname() + "</option>";

            }
            str += "</select>";

        }

		
		
		
		
		
		
		
		
		/*String str="<select name='drugname' value='drugid' id='drugid_"+index+"' style='width: 95px'>";
			   str+="<option value='0'selected='selected'>--Select Item-- &nbsp;"+ "</option>";
			   
			   
			   
			   for(PrescriptionAction o:medicinelist)
				{
				   str+="<option value='"+ o.getDrugid()+"'>"+ o.getDrugname()+"</option>";
				}
				str+="</select>"; */


        try {

            ServletActionContext.getResponse().getWriter().write(str);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
