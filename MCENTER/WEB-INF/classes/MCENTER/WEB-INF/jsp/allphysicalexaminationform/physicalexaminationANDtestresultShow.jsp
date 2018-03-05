<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>		

<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

    <title>BUET Medical Center</title>
    <link type="image/x-icon"  rel="icon"href="resource/img/logo.png" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="resource/css/main.css" type="text/css" />
    <script type="text/javascript" src="resource/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resource/js/functions.js"></script>
    
    <link rel="stylesheet" href="css/table1.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />

<script src="js/jQuery.js" type="text/javascript"></script>
 <script src="js/jquery1.4.4min.js"></script>
<script src="js/jquery.min.js"></script> 
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	

 <script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
});
</script>


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

.additionForm1{
	background-color:#F0F5F4; 
	width:400px; 
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}

.additionForm2{
	background-color:#F0F5F4; 
	width:800px; 
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}



#panel,#flip
{
padding:0px;

background-color:#e5eecc;
border:solid 1px #c3c3c3;
}
#panel
{
padding:10px;
display:none;
}
</style>  

    

                    	
                    	
                    	
  
<h1 align="center"><font size="5" color="red">Physical Examination and Test Result Save</font></h1>
  <fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">


<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO" name="receiptNUMBER" readonly="true"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Purpose" id="purpose" name="purpose" readonly="true"/>

</td>
</tr>

 <tr>
<td>
<s:textfield label=" Name" id="name"  name="name" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield  label="Designation" id="designation" name="designation" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield  label="Office" id="office" name="department" readonly="true"/>
</td>
</tr>

</table>

</s:form>

		<br/>
	

</fieldset>	

<br/> 
<h1 align="center"><font size="5" color="red">Physical Examination </font></h1>

  <fieldset class="additionForm1">
	<br/>
		<legend>Physical Examination Result</legend>	
<s:form theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">

<tr>
<td>
<s:textfield label="Height" id="globalheight" name="globalheight" readonly="true"/>

</td>
</tr>


<tr>
<td>
<s:textfield label="Weight" id="globalweight" name="globalweight" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Pulse Rate" id="globalpulserate" name="globalpulserate" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Blood Pressure(Systolic)" id="globalbloodpressureSystolic" name="globalbloodpressureSystolic" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Blood Pressure(Diastolic)" id="globalbloodpressureDiastolic" name="globalbloodpressureDiastolic" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Eyesight(R)" id="globaleyesightR" name="globaleyesightR" readonly="true"/>
</td>
</tr>
<tr>
<td>
<s:textfield label="Eyesight(L)" id="globaleyesightL" name="globaleyesightL" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Colour Blindness" id="globalcolourblindness" name="globalcolourblindness" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Hearing" id="globalhearing" name="globalhearing" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Speech" id="globalspeech" name="globalspeech" readonly="true"/>
</td>
</tr>
<tr>
<td>
<s:textfield label="Lungs" id="globallungs" name="globallungs" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Heart" id="globalheart" name="globalheart" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="P/A/E" id="globalpae" name="globalpae" readonly="true"/>
</td>
</tr>
</table>

</s:form>

		<br/>
	

</fieldset>	

<br/> 

<div id="flip"><font size="4" color="blue">Click for  Test Result and Print Report</font></div>
<div id="panel">

<%-- <s:form action="physicalexaminationANDtestresultPRINTaction">  --%>
 <s:form>  
 <s:hidden name="receiptNO"/>



<br/>       
 <h1 align="center"><font size="5" color="red">Test Result Show</font></h1>        
<br/>
<center>
<fieldset class="additionForm2">
	<br/>
		<legend>Test Result Save</legend>
<table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width="10">No</th>        
        <th width="20">Test Type</th>
        <th width="20">Test Name</th>
        <th width="50">Result</th>
       
       
        
    </tr>
    </thead>
    <s:if test="assignedTestlist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="assignedTestlist" status="assignedTestlistStatus" var="adnan">
       
<tr> 
       <td style="padding:10px;"><s:property value="#assignedTestlistStatus.index+1"/></td>        
        <td style="padding:10px;"><s:property value="testType"/></td>
        <td align="center" style="display: none; padding:10px;"><s:textfield id="testTypeID" name="testTypeID" size="2" value="%{#adnan.testTypeID}" style="height:12px" theme="simple"/></td>
        <td align="center" style="padding:10px;"><s:property value="testName"/></td>
        <td align="center" style="display: none; padding:10px;"><s:textfield id="testNameID" name="testNameID" size="2" value="%{#adnan.testNameID}" style="height:12px" theme="simple"/></td>
        <td align="center" style="padding:10px;"><s:property value="testResult"/></td>
</tr>
    
     </s:iterator>
     
  
      
 </tbody>    
    </s:if> 
</table>
<br/>
</fieldset>	
<br/>

<%-- <s:submit id="print" value="Print" theme="simple" align="center" cssClass="btn btn-primary btn-large"/> --%>
</center>
</s:form>


</div>

 
<%--   <fieldset class="additionForm1">
	<br/>
		<legend>Physical Examination</legend>
		
				
<div>
<div>
<label class="label" for="Height">Height:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="Height" type="text" name="globalheihgt">

<s:textfield label="Height" id="Height" name="height"  theme="xhtml"/>&nbsp;&nbsp;&nbsp;&nbsp;
<s:textfield label="Weight" id="Weight" name="weight"  theme="xhtml"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" for="Weight">Weight:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="weight" type="text" name="globalweight">
</div>
<br/>
<div>
<label class="label" >Pulse Rate:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="pulseRate" type="text" name="globalpulseRate">

<s:textfield label="Pulse Rate" id="pulseRate"  name="pulseRate"  theme="xhtml"/>
</div>
<br/>
<div>
<label class="label" >Blood Pressure(Systolic):</label>&nbsp;&nbsp;
<input id="bloodpressure" type="text" name="globalbloodpressureSystolic">
</div>
<br/>
<div>
<label class="label" >Blood Pressure(Diastolic):</label>
<input id="bloodpressure" type="text" name="globalbloodpressureDiastolic">
<s:textfield  label="Blood Pressure" id="bloodPressure" name="bloodPressure" theme="xhtml"/>
</div>
<br/>
<div>
<label class="label" >Eyesight(R):</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="eyesightR" type="text" name="globaleyesightR">

</div>
<br/>
<s:textfield label="Eyesight(R)" id="pulseRate"  name="pulseRate"  theme="xhtml"/>
<s:textfield  label="Eyesight(L)" id="bloodPressure" name="bloodPressure" theme="xhtml"/>
<div>
<label class="label" >Eyesight(L):</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="eyesightL" type="text" name="globaleyesightL">

</div>
<br/>
<div>
<label class="label" >Eyesight(L):</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="eyesightL" type="text" name="globaleyesightL">

<label class="label" >Colour Blindness:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="colourblindness" type="text" name="globalcolourblindness">

</div>
<br/>
<div>
<label class="label" >Hearing:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="hearing" type="text" name="globalhearing">

<label class="label" >Speech:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="speech" type="text" name="globalspeech">


</div>
<br/>
<div>
<label class="label" >Lungs:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="lungs" type="text" name="globallungs">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" >Heart:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="heart" type="text" name="globalheart">
</div>
<br/>
<div>
<label class="label" >P/A/E:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="pae" type="text" name="globalpae">

</div>
</div>
<br/>
	

</fieldset>	  --%>                 
                      
   <jsp:directive.include file="/WEB-INF/jsp/template/footer.jsp"/> 

