<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
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
  
  $('#departmentadvance').html('');
            $('#departmentadvance').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#departmentadvance').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#departmentadvance").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#personadvance').html('');
                    var person = {
                        "departmentID": $("#departmentadvance").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#personadvance').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#personadvance" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
 $('#recommendedpatientNameadvance').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#personadvance").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designationadvance").val(Adnan.designation);
                             $("#officialIdadvance").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
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
                    	
                    	
  
 




   <h1 align= center><font size="5" color="green">Medical  Fitness Certificate</font></h1>
   <br/>
  <fieldset class="additionForm">
	
		<legend>Medical Fitness Certificate</legend>	
<br/>		

<span> 		
		
<s:form action="medicalfitnesscertificateaction" > 
<table style="border-spacing: 4px;" >




<tr>
<td align="left">
Dept/Office
</td>
<td align="left">
 <select id="departmentadvance"  name="department" style="width:155px" theme="xhtml"> 
 
 </select>
</td>
</tr>





<tr>
<td align="left">
Person
</td>
<td>
 <select id="personadvance"  name="person" style="width:220px" theme="xhtml"> 
 
 </select>
</td>
</tr>



<tr>
<td>

<s:textfield label="Designation" id="designationadvance" name="designation" readonly="true" theme="xhtml"/>

</td>
</tr>



<tr>
<td>

<s:textfield label="Official Id" id="officialIdadvance" name="officialId" readonly="true" theme="xhtml"/>

</td>
</tr>
 
  	<tr>
 


	
<tr>
<td>
&nbsp;
</td>
<td>

<s:submit id="advancesearchsavePatient" value="Press" theme="simple" cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small" align="center"/>

</td>
</tr>


</table>

</s:form>
</span>



 </fieldset>       	
                    	
 <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
