<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
	
<script>
$(function () {
$( "#SerialNo" ).blur(function() {
 
  
  var patientMedicineBill= {
                        "visitID": $("#SerialNo").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "editPrescriptionaction",
                        data: JSON.stringify(patientMedicineBill),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                                    
                             $("#Doctor").val(Adnan.doctorName);
                             $("#VisitingDate").val(Adnan.prescriptionDate);
                             $("#MedicalId").val(Adnan.medicalID);
                             $("#Patient").val(Adnan.patientName);
                             $("#Department").val(Adnan.department);
                             $("#Designation").val(Adnan.designation);
                             $("#IDholderName").val(Adnan.medicalIDholderName);
                             $("#relation").val(Adnan.patientRelationWithIDholder);
                             
                             alert(Adnan.message);
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 

</script>
<script lang="javascript">
 $(function() { 
 
         
              $("#searchPrescription").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                      
                         $("#SerialNo")
                        .require(); 
                      
                         $("#Doctor")
                        .require();  
                        
                         $("#VisitingDate")
                        .require(); 
                        
                         $("#MedicalId")
                        .require(); 
                        
                         $("#IDholderName")
                        .require();
                      
                         $("#Department")
                        .require(); 
                        
                         $("#Designation")
                        .require(); 
                        
                         $("#Patient")
                        .require();
                                    
                         $("#relation")
                        .require();
                        
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
                    	
                    	
  
 <br/><br/>
<h1 align= center><font size="5" color="green"> Search Prescription by Doctor</font></h1>	
<fieldset class="additionForm">
	
		<legend>Search Prescription by Doctor</legend>		

<s:form action="searchprescriptionaction"> 
<table align="center" style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="SerialNo" name="serial" theme="xhtml">
 <s:param name="value">
    <s:date name="new java.util.Date()" format="dd-MM-yyyy"/>-P-
  </s:param>
</s:textfield>

</td>
</tr>

<tr>
<td>
<s:textfield label="Assigned Doctor" id="Doctor" value="" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Visiting Date" id="VisitingDate"  value="" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Patient Id" id="MedicalId"  value="" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="ID holder Name" id="IDholderName"  value="" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Department" id="Department"  value="" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="Designation"  value="" readonly="true" theme="xhtml"/>
</td>
</tr>



<tr>
<td>
<s:textfield label="Patient Name" id="Patient" value="" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Relation" id="relation" value="" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
&nbsp;
</td>
<td>
<s:submit id="searchPrescription"  value="Search"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small" align="center"/>

</td>
</tr>


</table>

</s:form>
</fieldset>
	
		<br/>
            
                        
                    <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
                   