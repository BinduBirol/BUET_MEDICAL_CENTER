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

<script lang="javascript">
 $(function() { 
 
         
              $("#save").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                
                      
                
                   $("#identificationMark")
                        .require(); 
                      
                        $("#Height")
                        .require(); 
                        
                         $("#weight")
                        .require();  
                        
                        $("#chestnormal")
                        .require(); 
                      
                        $("#chesttb")
                        .require(); 
                        
                         $("#chestlb")
                        .require();  
                     
                         $("#eyesightR")
                        .require();
                        
                          $("#eyesightL")
                        .require();
                       
                         $("#normalHealthCondition")
                        .require();
                         
                         $("#pulseRate")
                        .require(); 
                        
                         $("#bloodpressureSystolic")
                        .require(); 
                        
                        $("#bloodpressureDiastolic")
                        .require(); 
                                               
                        $("#lungs")
                        .require(); 
                                               
                        $("#heart")
                        .require(); 
                                              
						$("#liver")
                        .require();  
                                                
                        $("#splees")
                        .require(); 
                        
                        $("#anaemia")
                        .require(); 
                        
                                              
                        $("#hernia")
                        .require(); 
                        
                        $("#anyPhysicalDisability")
                        .require(); 
                        
                        $("#skinDisease")
                        .require();
                         
                        $("#ear")
                        .require(); 
                        
                        $("#nose")
                        .require();
                        
                        $("#throat")
                        .require();
                        
                        $("#colourblindness")
                        .require();
                        
                       /*  $("#others")
                        .require();  */
 
                        
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

.additionForm1{
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

    

                    	<!--Main content will be here-->
                    	
                    	
  
<h1 align= center><font size="5" color="red">Physical Examination Info. Save</font></h1>
  <fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form  theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">

<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO" name="receiptNO"/>

</td>
</tr>


<tr>
<td>
<s:textfield label="Name" id="name" name="studentname" readonly="true"  />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Academic Session" id="session"  name="acadenicsession" readonly="true" />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Merit Position" id="meritPosition"  name="meritPosition" readonly="true"/>
</td>
</tr>

</table>

</s:form>

		<br/>
	

</fieldset>	

<br/> 
<div id="flip"><font size="4" color="blue">Click for Physical Examination Save</font></div>
<div id="panel">

<h1 align= center><font size="5" color="red">Physical Examination </font></h1>
 <s:form action="newStudentphysicalexaminationANDtestresultsaveaction" >  
 <s:hidden name="receiptNO" />

<fieldset class="additionForm1">
	<br/>
		<legend>Physical Examination</legend>
<div>
<label class="label" >1. Identification Mark:</label>&nbsp;&nbsp;
<input id="identificationMark" type="text" name="identificationMark">
</div>
<br/>
<div>
<label class="label" for="Height">2. Height:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="Height" type="text" name="height">

<%-- <s:textfield label="Height" id="Height" name="height"  theme="xhtml"/>&nbsp;&nbsp;&nbsp;&nbsp; --%>
<%-- <s:textfield label="Weight" id="Weight" name="weight"  theme="xhtml"/> --%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" for="Weight">3. Weight:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="weight" type="text" name="weight">kg
</div>
<br/>
<hr>
<br/>

<h1 align= left><font size="2" color="black">4. Chest Measurement </font></h1>
<div>
<div>
<label class="label" >a. Normal :</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="chestnormal" size="4" type="text" name="chestnormal">" (inch)
</div>
<br/>
<div>
<label class="label" >b.Takeing breath:</label>&nbsp;&nbsp;
<input id="chesttb"  size="4" type="text" name="chesttb">" (inch)
</div>
<br/>
<div>
<label class="label" >c. Leaving breath:</label>&nbsp;&nbsp;
<input id="chestlb" size="4"  type="text" name="chestlb">" (inch)
</div>
</div>
<br/>
<hr>
<br/>

<h1 align= left><font size="2" color="black">5. Eye sight </font></h1>
<div>
<label class="label" >a. Right eye:</label>&nbsp;&nbsp;&nbsp;&nbsp;
<input id="eyesightR" size="5"  type="text" name="eyesightR">
<s:select theme="xhtml" id="eyesightRGLLASS"  name="eyesightRGLLASS" list="{'Without Glasses','With Glasses'}" />
</div>
<br/>
<div>
<label class="label" >b. Left eye:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="eyesightL" size="5" type="text" name="eyesightL">
<s:select theme="xhtml" id="eyesightLGLLASS"  name="eyesightLGLLASS" list="{'Without Glasses','With Glasses'}" />
</div>
<br/>
<hr>
<br/> 

<div>
<label class="label" >6. Normal Health Condition:</label>&nbsp;&nbsp;
<input id="normalHealthCondition" type="text" name="normalHealthCondition">
</div>
<br/>
<hr>
<br/>
<div>
<label class="label" >7. Pulse Rate:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="pulseRate" type="text" name="pulseRate">/min
<s:select theme="xhtml" id="pulserateCONDITION" name="pulserateCONDITION" list="{'regular','irregular'}" />
<%-- <s:textfield label="Pulse Rate" id="pulseRate"  name="pulseRate"  theme="xhtml"/> --%>
</div>
<br/>
<div>
<label class="label" >8. Anaemia:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="anaemia" type="text" name="anaemia">
</div>
<br/>
<hr>
<br/>
<h1 align= left><font size="2" color="black">9. Blood Pressure </font></h1>
<div>
<label class="label" >a. Systolic:</label>&nbsp;&nbsp;
<input id="bloodpressureSystolic" type="text" name="bloodpressureSystolic">mmHg
</div>
<br/>
<div>
<label class="label" >b. Diastolic:</label>
<input id="bloodpressureDiastolic" type="text" name="bloodpressureDiastolic">mmHg
<%-- <s:textfield  label="Blood Pressure" id="bloodPressure" name="bloodPressure" theme="xhtml"/> --%>
</div>
<br/>
<hr>
<br/>

<div>
<label class="label" >10. Heart:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="heart" type="text" name="heart">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" >11. Lungs:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="lungs" type="text" name="lungs">
</div>
<br/>
<div>
<label class="label" >12. Liver:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="liver" type="text" name="liver">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" >13. Splees:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="splees" type="text" name="splees">
</div>
<br/>
<hr>
<br/>

<div>
<label class="label" >14. Hernia:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="hernia" type="text" name="hernia">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" >15. Any Physical Disability:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="anyPhysicalDisability" type="text" name="anyPhysicalDisability">
</div>
<br/>
<div>
<label class="label" >16. Skin Disease:</label>&nbsp;&nbsp;&nbsp;&nbsp;
<input id="skinDisease" type="text" name="skinDisease">
<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label class="label" >12. Splees:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="heart" type="text" name="heart"> -->
</div>
<br/>
<hr>
<br/>

<h1 align= left><font size="2" color="black">17. Nose-Ear-Throat [NET]</font></h1>
<div>
<div>
<label class="label" >b. Nose:</label>&nbsp;&nbsp;&nbsp;
<input id="nose"   type="text" name="nose">
</div>
<br/>
<div>
<label class="label" >a. Ear:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="ear"  type="text" name="ear">
</div>
<br/>
<div>
<label class="label" >c. Throat:</label>&nbsp;
<input id="throat"   type="text" name="throat">
</div>
<br/>
<hr>
<br/>
<div>
<s:select theme="xhtml" id="colourblindness"  name="colourblindness" list="{'Absent','Present'}" label="18. Colour Blindness"/>
</div>
<br/>
<div>
<label class="label" >19 . Others</label>&nbsp;&nbsp;
<input id="others" type="text" name="others">
</div>
<br/>
<hr>
<br/>
<%-- <div>
<s:select theme="xhtml" id="colourblindness"  name="colourblindness" list="{'Absent','Present'}" label="Colour Blindness"/>
</div>
<br/>
<div>

<s:select theme="xhtml" id="hearing" name="hearing"  list="{'Normal','Impaired'}" label="Hearing"/>
<s:select theme="xhtml" id="speech"  name="speech" list="{'Normal','Impaired'}" label="Speech"/>
</div>
<br/> --%>


</div>
<br/>
	

</fieldset>	


<br/>
<center>
<s:submit id="save"  value="Save"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center>
</s:form>


</div>

<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 

