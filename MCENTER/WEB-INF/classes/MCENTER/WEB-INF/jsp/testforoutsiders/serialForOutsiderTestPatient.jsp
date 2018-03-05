<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>


<!--   
For Date Picker		
 -->     

<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>



 <link href="css/button.css" type="text/css" rel="stylesheet"/>	    
<script>
$(function () {
$( "#patientname" ).keyup(function() {
 
  
  var patientname= {
                        "patientname": $("#patientname").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "createserialTestforOthersaction",
                        data: JSON.stringify(patientname),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#serialNo").val(Adnan.serial);
                             $("#patientlId").val(Adnan.patientID);
                          
                             
                            
                             
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 

</script>

 <script>
 
        $(function() {
            $("#dob").datepicker({
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
                    <h1 align= center><font size="5" color="green">  Entry of  outsider Test Patient</font></h1>	
	



<br/>
<fieldset class="additionForm">
	<br/>
		<legend>Outsider  Patient  Entry for Test</legend>
	
	
	

<s:form action="entryTestforOthersaction" theme="xhtml"> 
<table style="border-spacing: 4px;">

<tr>
<td>
<s:textfield label="Patient Name" id="patientname" name="patientname"  />
</td>
</tr>

<tr>
<td>
<s:select list="{'Male','Female'}" label="Gender" id="gender" name="gender"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Date of birth" id="dob" name="dob"  />
</td>
</tr>


<tr>
<td>
<s:textfield label="Patient Id" id="patientlId" name="patientlId"  />
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="designation" name="designation"  />
</td>
</tr>
<tr>
<td>
<s:textfield label="Referenced Doctor" id="doctor" name="doctor" />

</td>
</tr>


<tr>
<td>

<s:textfield label="Serial No" id="serialNo" name="serialNo" />

</td>
</tr>




<tr>
<td>
&nbsp;
</td>
<td>
<s:submit   id="entrytestforoutsiders"  value=" Save"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>


</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	

 <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
