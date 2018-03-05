<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
 
 
 
 <link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link> 
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>

<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>



 


<style type="text/css" media="screen">
.additionForm {
	background-color:#F0F5F4; 
	width:300px;
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}
</style>  

<h1>Patients' List</h1>
<table class="display dataTable" id="table" width="600px"  >
    <thead>
    <tr>
        <th align="center">Visiting Id</th>
        <th align="center">Name</th>
        <th align="center">Pattient ID</th>
        <th align="center">Details</th>

    </tr>
    </thead>


     <s:iterator value="patientoo">
        <tbody>
        <tr>
            <td align="center"><s:property value="visitid"/></td>
            <td align="center"><s:property value="name"/></td>
            <td align="center"><s:property value="patientid"/></td>
            <td align="center"><s:url action="ptdetails.action" var="detail">
                <s:param name="name" value="name"></s:param>
                <s:param name="patientid" value="patientid"></s:param>
                <s:param name="visitid" value="visitid"></s:param>
                <s:param name="visidate" value="visidate"></s:param>
            </s:url>
                <s:a href="%{detail}"><u><strong>Details</u></strong></s:a></td>
                
        </tr>
        </tbody>
    </s:iterator>


</table>
 

 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

