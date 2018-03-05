<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>		


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

    

                    	<!--Main content will be here-->
                    	
                    	
  
 




<h1 align= center><font size="5" color="red">Founded Prescription by Technician</font></h1>

<fieldset class="additionForm">
	<br/>
		<legend>Patient Info</legend>
	
	
	

<s:form action="printtestbillaction"> 
<table style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="SerialNo" name="serial" value="%{serialNO}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Assigned Doctor" id="Doctor" value="%{doctorName}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Visiting Date" id="VisitingDate"  value="%{prescriptionDate}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Medical Id" id="MedicalId"  value="%{medicalID}" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="ID holder Name" id="IDholderName"  value="%{medicalIDholderName}" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Department" id="Department"  value="%{department}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="Designation"  value="%{designation}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Patient" id="Patient" value="%{patientName}" readonly="true" theme="xhtml"/>
</td>
</tr>



<tr>
<td>
<s:textfield label="Relation" id="Relation"  value="%{patientRelationWithIDholder}" readonly="true" theme="xhtml"/>
</td>
</tr>


</table>
<%-- <center>
<s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center> --%>
</s:form>


	
		
	
		<br/>
	

</fieldset>	


<br/>
<br/>
<center>
<s:form action="testReduceFromStore">

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=10>No</th>        
        <th width=30>Test Type</th>
        <th width=30>Test Name</th>
        <th width=30>Rate</th>
        <th width=30>vat</th>
        <th width=30>Cost in <br/>Taka</th>
        <th width=15>Bill Status</th>
        <th width=15>Check</th>
       
        
    </tr>
    </thead>
    <s:if test="dailyRegularTestBilllist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="dailyRegularTestBilllist" status="dailyRegularTestBilllistStatus" var="adnan">
       
<tr> 
       <td><s:property value="#dailyRegularTestBilllistStatus.index+1"/></td>        
        <td><s:property  value="testType"/></td>
         <td align= center><s:property value="testName"/></td>
         <td align= center><s:property value="rate" /></td>
         <td align= center><s:property value="vat"/></td>
         <td align= center><s:property value="cost"/></td>
         
         <s:if test="%{#adnan.billStatus=='Not Taken'}">
         <td align= center><div style="color: green;"> Not Completed</div></td>
         </s:if> 
         
         <s:if test="%{#adnan.billStatus=='Taken'}">
         <td align= center><div style="color: red;">Complted</div></td>
         </s:if>
         
         <td align= center>	<input type="checkbox" class="boSelect" checked="checked" name="checkedtest" value="<s:property value="testTypeID"/>#<s:property value="testNameID"/>"></td>

</tr>
    
     </s:iterator>
     
      <tr>
    <s:hidden id="SerialNo" name="serial" value="%{serialNO}"/>
<%--     <td colspan="7" align="right">Total:&nbsp;<s:property value="%{total}"/>&nbsp;&nbsp;taka only</td>
    <td align= center style="display: none;" ><s:textfield id="totalcost" name="totalcost"  size="2" value="%{total}" style="height:12px" theme="simple" /></td> --%>
    </tr>
      
 </tbody>    
    </s:if> 
</table>

<br/>
<center>
<s:submit id="save"  value="Create Bill"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center>
</s:form>
</center>
<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 

