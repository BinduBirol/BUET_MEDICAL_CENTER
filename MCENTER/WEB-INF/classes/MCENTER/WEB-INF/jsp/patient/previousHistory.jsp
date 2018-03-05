<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
 <link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>

<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

<table  class="display dataTable" id="table" width="600px" >
    <thead>
    <tr><!--
        <th>Name</th>
        --><th>Visiting Date</th>
        <!--
        <th>Patient ID</th>
        --><th>Visit ID</th>
        <th>Prescription ID</th>
        <th>Details</th>

    </tr>
    </thead>
    <s:iterator value="patienthistory">
        <tbody>
        <tr><!--
            <td><s:property value="name"/></td>
            --><td><s:property value="visidate"/></td>
            <!--<td><s:property value="patientid"/></td>
            --><td><s:property value="visitid"/></td>
            <td style="text-align: center"><s:property value="prescriptionid"/></td>
            <td style="display: none;"><s:property value="doctorid"/></td>
            <td><s:url action="ptalldetails.action" var="detail">
            	<s:param name="name" value="name"></s:param>
                <s:param name="patientid" value="patientid"></s:param>
                <s:param name="visitid" value="visitid"></s:param>
                <s:param name="prescriptionid" value="prescriptionid"></s:param>
                <s:param name="doctorid" value="doctorid"></s:param>
            </s:url>
                <s:a href="%{detail}"><u><strong>Details </u></strong></s:a></td>
               
        </tr>


        </tbody>
    </s:iterator>
 

</table>
 
<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
