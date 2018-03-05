package com.prescription;


import com.opensymphony.xwork2.ActionSupport;
import com.table.PrescriptionDTO;

import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.ArrayList;


public class GetTestSb extends ActionSupport {


    public String execute() throws Exception {

        String sid = (String) ServletActionContext.getRequest().getParameter("sid");
        String index = (String) ServletActionContext.getRequest().getParameter("index");

        String tid = (String) ServletActionContext.getRequest().getParameter("tid") == null ? "null" : (String) ServletActionContext.getRequest().getParameter("tid");

        PrescriptionDAO pdao = new PrescriptionDAO();

        ArrayList<PrescriptionDTO> sbtestlist = pdao.getSbTestList(sid);

        String str = "";


        if (sbtestlist.size() > 0) {


            str = "";
            str += "<select  name='subtestname' value='subtestid' id='sbtestid_1' style='width: 100px' >";
            str += "<option value='0'>--Select-- " +
                    "</option>";

            for (PrescriptionDTO o : sbtestlist) {
                str += "<option value='" + o.getSubtestid() + "'>" + o.getSubtestname() + "</option>";

            }
            str += "</select>";

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
