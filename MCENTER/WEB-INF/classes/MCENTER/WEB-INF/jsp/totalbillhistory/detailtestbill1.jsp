<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

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
  $(function () {
  
  

 
 
      $("#deactive").click(function (){
      
      
            
	       
                $('#deactive').html('');
                    var activeDoctor = {
                        "activeDoctorName": $("#activedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "deactivedoctoraction",
                        data: JSON.stringify(activeDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(){window.alert('Done');}
                            
                        
                    });
                    
                    $.getJSON("jsonactivedoctoraction", function (res) {

                                        });  
                    
             });   
             
             
             
              $("#active").click(function (){
      
      
            
	       
                $('#active').html('');
                    var deactiveDoctor = {
                        "deactiveDoctorName": $("#deactivedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "reactivedoctoraction",
                        data: JSON.stringify(deactiveDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(){window.alert('Done');}
                            
                        
                    });
                    
                    $.getJSON("jsonactivedoctoraction", function (res) {

                                        });  
                    
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
</style>  

                    	<!--Main content will be here-->
                    	
                    	
  
 




<h1 align= center><font size="5" color="red">Details Test Bill</font></h1>

<fieldset class="additionForm">
	<br/>
		<legend>Patient Info</legend>
	
	
	

<s:form> 
<table align="center" style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="SerialNo" name="serial" value="%{serialNumber}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Assigned Doctor" id="Doctor" value="%{doctorName}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Visiting Date" id="VisitingDate"  value="%{prescriptionDate}" readonly="true" theme="xhtml" />
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

</s:form>


	
		
	
		<br/>
	

</fieldset>	


<br/>
<br/>
<center>
<s:form action="savetestbillaction">

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=10>No</th>        
        <th width=30>Test Type</th>
        <th width=30>Test Name</th>
        <th width=30>Rate</th>
        <th width=30>vat</th>
        <th width=30>Cost in <br/>Taka</th>
       
        
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

</tr>
    
     </s:iterator>
     
      <tr>
    
    <td colspan="6" align="right">Total:&nbsp;<s:property value="%{total}"/>&nbsp;&nbsp;taka only</td>
    
    </tr>
    

    
    
    
 </tbody>    
    </s:if> 
</table>
</s:form>
</center>
<br/>
<center>
<s:form action="totalBill">
<s:submit id="goBack"  value="Go Back"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</s:form>
</center>	
  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 