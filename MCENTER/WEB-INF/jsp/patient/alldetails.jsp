 <%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link> 

<style type="text/css" media="screen">
   

    </style>

                
                 <table align="center" width="80%" class="display dataTable">

                    <s:iterator value="patientdtl" status="st">

                        <tr>
                            <th>Name</th>
                            <td><s:property value="name"/></td>
                        </tr>
                        <tr>
                            <th>Designation</th>
                            <td><s:property value="designation"/></td>
                        </tr>
                        <tr>
                            <th>Department</th>
                            <td><s:property value="department"/></td>
                        </tr>
                        <tr>
                            <th>Sex</th>
                            <td><s:property value="sex"/></td>
                        </tr>
                        <tr>
                            <th>Patient id</th>
                            <td><s:property value="patientid"/></td>
                        </tr>
                         <tr>
                            <th>prescription id</th>
                            <td><s:property value="prescriptionid"/></td>
                        </tr>
                        <tr >
                            <th rowspan="12">image</th>
                            <td  rowspan="12"> 
							<img src="/mcenter/resources/image/<s:property value="patientid"/>.jpg"  width="150" height="180"  border="1" />
                            
                            </td>
                        </tr>
						
						<tr>
                       
					</tr>

                    </s:iterator>


                </table>
                </br>
                
                
                <form  action="previousprescriptionSHOW" method="post">
                <s:hidden id="name" name='name' value="%{name}"/>
                <s:hidden id="patientid" name='patientid' value="%{patientid}"/>
                <s:hidden id="visitid" name='visitid' value="%{visitid}"/> 
                <s:hidden id="prescriptionid" name='prescriptionid' value="%{prescriptionid}"/> 
                <s:hidden id="doctorid" name='doctorid' value="%{doctorid}"/>
                <input type="submit" class="myButton" style="width: 140px;" value="View Prescription"/>
                </form><!--
                
                
              <div> <s:url action="previousprescriptionSHOW" var="detail">
                            <s:param name="patientid" value="patientid"></s:param>
                            <s:param name="visitid" value="visitid"></s:param>
                            <s:param name="prescriptionid" value="prescriptionid"></s:param>
                            <s:param name="doctorid" value="doctorid"></s:param>                              
                        </s:url>
                        <s:a href="%{detail}"><u><strong>View Prescription</u></strong></s:a></div>
                        
                        --><!--
                <form id="loginForm" action="previousprescriptionSHOW" method="post">
                <s:hidden id="prescriptionid" name='prescriptionid' value="%{patientdtl.prescriptionid}"/>
                <s:hidden id="pid" name='patientid' value="%{patientid}"/> 
                <s:hidden id="vid" name='visitid' value="%{visitid}"/> 
                <input type="submit" value="Click"/>
                </form>
                
            
 --><%@include file="/WEB-INF/jsp/template/footer.jsp"%>
 
    <!--end footer-->


