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
            $('#department').html('');
            $('#department').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#department').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#department").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#person').html('');
                    var person = {
                        "departmentID": $("#department").val()
                        
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
                                $('#person').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#person" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
 $('#patientNameadvancesearch').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#person").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designation").val(Adnan.designation);
                             $("#officialId").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
 /////////////////////////////////////////////////////////////////////////////////////////////////

  var searchpatient= {
                        "patientmedicalID": $("#officialId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                            // $("#IdholderName").val(Adnan.name);
                             $("#serialadvancesearch").val(Adnan.serialNumber);
                             $("#assignedDoctoradvancesearch").val(Adnan.assignedDoctor);
                             $("#assignedDoctorIDadvancesearchhidden").val(Adnan.assignedDoctorofficialID);
                             $("#advancesearchshifthidden").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
                    
                   
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#patientNameadvancesearch').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    }); 
 
 
 
 
 
  
  
  
});       


  $("#patientNameadvancesearch").click(function (){
   
  // $('#patientNameadvancesearch').html('');
             
 var relationwithIDholder= {dependentName:$("#patientNameadvancesearch").val(),patientmedicalID: $("#officialId").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#relationadvancesearch").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  });         

                
        });
          </script>
          


 <script>

$(document).ready(function(){

 $("#doctor").blur(function(){
 
 var value1= $("#person").find(":selected").text();
 var value2= $("#patientNameadvancesearch").find(":selected").text();
 
  $("#personName").val(value1);
  $("#patientName").val(value2);
  
 
   $.getJSON("testInsiderForOutDocAction",function(data) {
			    
			 
			  $("#serialNo").val(data.serial);

			  
		  
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
                    <h1 align= center><font size="5" color="green">  Entry of  insider Test Patient</font></h1>	
	



<br/>


<!-- ////////////////////////////////////////////****************************////////////////////////////////// -->
<fieldset class="additionForm">
<s:form action="entry_testInsiderForOutDocAction" theme="xhtml"> 
<table style="border-spacing: 4px;" >
    <tr>
        <td align="left">
Dept/Office
</td>
        <td align="left">
            <select id="department"  name="department" style="width:155px" theme="xhtml" ></select>
        </td>
    </tr>
    <tr>
        <td align="left">
Person
</td>
        <td>
            <select id="person"  name="person" style="width:220px"  theme="xhtml"></select>
        </td>
    </tr>
  
      <tr>
        <td>
            <input type="hidden" id="personName" name="personName" value="English">
        </td>
    </tr>
    
    <tr>
        <td>
            <s:textfield label="Designation" id="designation" name="designation" readonly="true" theme="xhtml"/>
        </td>
    </tr>
    <tr>
        <td>
            <s:textfield label="Official Id" id="officialId" name="officialId" readonly="true" theme="xhtml"/>
        </td>
    </tr>
    <tr>
        <td>Patient :</td>
        <td>
            <select id="patientNameadvancesearch" name="patientNameadvancesearch" theme="xhtml">
                <option value="-1">Select Patient</option>
            </select>
        </td>
    </tr>
     <tr>
        <td>
            <input type="hidden" id="patientName" name="patientName" value="English">
        </td>
    </tr>
    
    <tr>
        <td>
            <s:textfield  id="relationadvancesearch" label="Relation" readonly="true"  theme="xhtml"/>
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
            <s:submit id="advancesearchsavePatient" value="Patient Entry" theme="simple" cssClass="btn btn-primary btn-large" />
            <s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>
        </td>
    </tr>
    
    
</table>

</s:form>
</fieldset>

 <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
