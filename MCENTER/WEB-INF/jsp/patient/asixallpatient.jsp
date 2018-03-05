<%@ taglib prefix="s" uri="/struts-tags"%>



<style type="text/css" media="screen">
    @import url("/mcenter/resources/css/main.css");
    @import url("/mcenter/resources/css/jquery-ui.css");
    @import url("/mcenter/resources/css/tablecss.css");


</style>


<table  class="display dataTable" id="table" width="100%">
    <thead>
    <tr>
        <th>Visiting Date</th>
        <th>Name</th>
        <th>Patient ID</th>
        <th>Prescription ID</th>
        <th>Details</th>

    </tr>
    </thead>
    <s:iterator value="patientpo">
        <tbody>
        <tr>
            <td><s:property value="visidate"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="patientid"/></td>
            <td style="text-align: center"><s:property value="prescriptionid"/></td>
            <td style="display: none;"><s:property value="doctorid"/></td>
            <td><s:url action="ptalldetails.action" var="detail">
                <s:param name="patientid" value="patientid"></s:param>
                <s:param name="visitid" value="visitid"></s:param>
                <s:param name="prescriptionid" value="prescriptionid"></s:param>
                <s:param name="doctorid" value="doctorid"></s:param>
            </s:url>
                <s:a href="%{detail}">Details</s:a></td>
               
        </tr>


        </tbody>
    </s:iterator>
 

</table>
 

