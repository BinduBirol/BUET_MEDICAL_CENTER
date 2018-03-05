<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
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
<center>
<s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large"  />
</center>
</s:form>


	
		
	
		<br/>
	

</fieldset>	


<br/>

<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
