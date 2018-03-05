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
<h1 align= center><font size="5" color="green"> Test for outsider Patient </font></h1>	
	




<fieldset class="additionForm">
	<br/>
		<legend>Outsider Test Patient Info</legend>
	
	
	

<%--  <s:form action="saveTestforOthersaction" theme="xhtml">  --%>
<s:form  theme="xhtml"> 
<table style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="serialNo" name="serialNo" value="%{visitID}"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Referenced Doctor" id="doctor" name="doctor" value="%{refDoctor}" readonly="true"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Patient Id" id="patientlId"  name="patientlId" value="%{patientID}" />
</td>
</tr>

<tr>
<td>
<s:textfield label="Patient Name" id="patientname"  name="patientname" value="%{patientname}" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Age " id="age"  name="age" value="%{ageStr}" readonly="true"/>
</td>
</tr>
<tr>

<td>
<s:textfield label="Gender " id="gender"  name="gender" value="%{gender}" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Designation" id="designation"  name="designation" value="%{designation}" readonly="true"/>
</td>
</tr>
</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	

<br/>




<h1 align= center><font size="5" color="green">Details</font></h1>	
<br/>

<s:form >

   <table class="bordered" >
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>       
        <th width=65>Test type</th>
        <th width=10>Test Name</th>
         <th width=15>Rate</th>
         <th width=15>Vat</th>
        <th width=15>Cost in Taka</th>
        
       
        
    </tr>
    </thead>
    <s:if test="TestBillforOtherslist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="TestBillforOtherslist" status="TestBillforOtherslistStatus" var="quantity">
    <tr >
        
         <td><s:property value="#TestBillforOtherslistStatus.index+1"/></td>        
         <td  style="display:none;"><s:property   value="visitID" /></td>
         <td style="display:none;"><s:param name="visitID" value="visitID" ></s:param></td> 
        
<%--          <td align= center><s:url action="reportTestforOthersaction" var="detail" >
    			<s:param name="visitID" value="visitID"></s:param>
			 </s:url>
			<s:a href="%{detail}">Details</s:a></td>
         --%>
         
         <td align= center><s:property value="testType"/></td>
         <td align= center><s:property value="testName" /></td>
        <td align= center><s:property value="rate" /></td>
        <td align= center><s:property value="vat" /></td>
         <td align= center><s:property value="cost" /></td>
          
       
        
    </tr>        
     </s:iterator>
    
      <tr>
    
    <td colspan="6" align="right">Total:&nbsp;<s:property value="total"/>&nbsp;&nbsp;taka only</td>
    
     </tr>
   
   
    
    
 </tbody>    
    </s:if> 
</table>

<br/> 
<center>


	
		

</center>	
 </s:form>


 <center> 
<s:form>

<table align="center" style="width: 50%">
<tr>
<td style="float: right;">
<s:url action="reportTestforOthersaction" var="testbill" >
    			<s:param name="visitID" value="visitID"></s:param>
			 </s:url>
			<s:a href="%{testbill}" theme="simple" align="center"  cssClass="btn btn-primary btn-large"> Test Bill</s:a>
</td>	
<td>&nbsp;</td>
<td>
<s:a href="testforOthers1.action" id="Newpatient"    theme="simple" align="center"  cssClass="btn btn-small"> New Patient</s:a>
<%-- <s:submit   onclick="testforOthers1.jsp" id="Newpatient"  value="New Patient"   theme="simple" align="center"  cssClass="btn btn-small" /> --%> 
</td>		
</tr>			
</table>

</s:form>
 </center>


<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
