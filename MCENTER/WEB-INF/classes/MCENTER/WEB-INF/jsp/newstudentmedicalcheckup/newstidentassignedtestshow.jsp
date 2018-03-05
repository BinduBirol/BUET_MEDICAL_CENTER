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
/* $(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
}); */
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
	width:800px; 
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}

.additionForm2{
	background-color:#F0F5F4; 
	width:600px; 
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
}
</style>  

    

                    	<!--Main content will be here-->
                    	
                    	
  
<h1 align= center><font size="5" color="red">Assigned Test</font></h1>
  <fieldset class="additionForm">
	
		<legend>Medical Check up</legend>	
<s:form  theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">


<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO" name="receiptNUMBER" readonly="true" />

</td>
</tr>


<tr>
<td>
<s:textfield label=" Name" id="name" name="studentname" readonly="true"  />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Academic Session" id="session" name="acadenicsession" readonly="true" />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Merit Position" id="meritPosition"  name="meritPosition" readonly="true"/>
</td>
</tr>

</table>

</s:form>

		
	

</fieldset>	
<br/>


<div id="panel">

<s:form action="testlistreportofnewstudentaction" >  
 <s:hidden name="receiptNUMBER" />

     
 <h1 align= center><font size="5" color="red">Test List </font></h1>        

<center>
<fieldset class="additionForm2">
	
		<legend>Test List </legend>
<table class="bordered" align="center" id="table" width="500px"   >
    <thead style=" font-size: 12px;">

    <tr>
        <th width=10>No</th>        
        <th width=20>Test Type</th>
        <th width=20>Test Name</th>
        
       
       
        
    </tr>
    </thead>
    <s:if test="assignedTestlist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="assignedTestlist" status="assignedTestlistStatus" var="adnan">
       
<tr> 
       <td style="padding:10px;"><s:property value="#assignedTestlistStatus.index+1"/></td>        
        <td style="padding:10px;"><s:property  value="testType"/></td>
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testTypeID" name="testTypeID"  size="2" value="%{#adnan.testTypeID}" style="height:12px" theme="simple" /></td>
        <td align= center style="padding:10px;"><s:property value="testName"/></td>
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testNameID" name="testNameID"  size="2" value="%{#adnan.testNameID}" style="height:12px" theme="simple" /></td>
       
</tr>
    
     </s:iterator>
     
  
      
 </tbody>    
    </s:if> 
</table>
<br/>
</fieldset>	
<br/>

<s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center>
</s:form>


</div>

<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 

