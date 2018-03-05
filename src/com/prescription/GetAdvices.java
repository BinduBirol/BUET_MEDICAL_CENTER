package com.prescription;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;


public class GetAdvices extends ActionSupport {


    public String execute() throws Exception {

        String id = (String) ServletActionContext.getRequest().getParameter("id");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionAction> list = pdao.getCctypeList(id);

        String str = "";


        if (list.size() > 0) {


            str = "";
            str += "<select  name='cctype' value='cctypeid' id='cctypeid_'" + id + " width='85px' >";
            str += "<option value='0'>--Select-- " +
                    "</option>";

            for (PrescriptionAction o : list) {
                str += "<option value='" + o.getCctypeid() + "'>" + o.getCctype() + "</option>";

            }
            str += "</select>";

        }

		/*str+="<td><input size='15' type='text' name='comments' id='comments_'"+id+"></td>";
		*/

        try {

            ServletActionContext.getResponse().getWriter().write(str);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


}
