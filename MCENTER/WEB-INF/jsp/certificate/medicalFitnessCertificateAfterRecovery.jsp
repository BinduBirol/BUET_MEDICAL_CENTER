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
  
  $( "#medicalId" ).blur(function() {
 
  $('#patientName').html('');
  var searchpatient= {
                        "medicalID": $("#medicalId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "medicalfitnesscertificateafterrecovryaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#IdholderName").val(Adnan.medicalIDholderName);
                             $("#department").val(Adnan.department);
                             $("#designation").val(Adnan.designation);
                             
                             
                       
                        }
                            
                        
                    });
  

 });

     
  });            
          
        
        

</script>

 <script>

        $(function() {
            $("#fromdatepicker").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

            $("#todatepicker").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();
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
                    	
                    

<h1 align= center><font size="4" color="green">Medical  Fitness Certificate after recovery from disease</font></h1> 
 <br/> 
  <fieldset class="additionForm">  
<legend>Recovery Certificate</legend> 
 
   <s:form action="medicalfitnesscertificatrecoveryeaction" > 
 <table  border="0" width="500px" style="border-spacing: 4px;">
	
	


 <tr>
 <td>

 <s:textfield  id="medicalId" name="medicalId" label="Patient Id" theme="xhtml"/>
 </td>
 </tr>
 
 

 <tr>
 
 <td>
  
  <s:textfield label="Id holder Name" id="IdholderName" name="idholderName" readonly="true" theme="xhtml"/>   
  
  
 </td>
 </tr>
 
 	<tr>

 <td>
  <s:textfield label="Department" id="department" name="department" readonly="true" theme="xhtml"/>  
 
 </td>
 </tr>
 

<tr>
 <td>
  <s:textfield label="Designation" id="designation" name="designation" readonly="true" theme="xhtml"/>  
 </td>
 </tr>

 <tr>
<td>
<s:textfield label="From Date" id="fromdatepicker"  name="fdate" size="8" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="To Date" id="todatepicker"  name="tdate"  size="8" theme="xhtml"/>

</td>
</tr>
 
 <tr>
<td>
<s:textfield label="Rest time" id="restday"  name="restday"  size="8" theme="xhtml"/>

</td>
</tr>


  
 
 

 <tr>
 <td>
  
   
  &nbsp;
  
 </td>
  <td>
  
   <s:submit id="savePatient" value="Press" theme="simple" cssClass="btn btn-primary btn-large" />
   <s:reset  value="Clear"  theme="simple" cssClass="btn btn-small" />
  
 </td>
 
 </tr>
	
	
</table>
</s:form>
    
</fieldset>	

 <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
