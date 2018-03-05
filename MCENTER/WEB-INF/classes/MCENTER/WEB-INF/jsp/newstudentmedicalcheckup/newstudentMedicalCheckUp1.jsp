<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
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
$( "#meritposition" ).blur(function() {
 
  var arr = {group_id:$("#group").val(),academic_session:$("#session").val(),merit_position:$("#meritposition").val()};

                    
  $.ajax({
                    
                        url: "searchnewstudent",
                        data: JSON.stringify(arr),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#studentName").val(Adnan.studentname);
                             $("#gender").val(Adnan.gender);
                             $("#dob").val(Adnan.dob);
                             $("#father_name").val(Adnan.father_name);
                             
                                                        
                         }
                            
                        
                    });
  
  
  
  
});

 }); 
 
</script>

<script lang="javascript">
 $(function() { 
 
         
              $("#save").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
/*                       $("#serialNo")
                        .require();  */
                      
                        $("#meritposition")
                        .require(); 
                        
                         $("#dob")
                        .require();  
                        
                        $("#doctor")
                         .equalCheck("-1","Select a Doctor");

                         $("#studentName")
                        .require(); 
                        
                         $("#gender")
                        .require();
                        
                          $("#gender")
                        .require();
                        
                          $("#father_name")
                        .require();
                        
                });
            });
      
           
   });
 
 </script> 

<style type="text/css" media="screen">
.additionForm {
	background-color:#F0F5F4; 
	width:400px;
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}
</style>  

                    	<!--Main content will be here-->
                    	
                    	
  
 





<h1 align= center><font size="5" color="green"> Money Receipt of New student Medical checkup </font></h1>	
<fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form action="newstudentmedicalcheckupmoneyreceiptaction"> 
<table align="center" style="border-spacing: 4px;">
<%-- <tr>
<td>

<s:textfield label="Serial No" id="serialNo" name="serial" theme="xhtml">
 <s:param name="value">
    <s:date name="new java.util.Date()" format="dd-MM-yyyy"/>-N.S.-
  </s:param>

</s:textfield>

</td>
</tr>
 --%>
 <tr>
<td>

 <s:select theme="xhtml" id="doctor" name="doctorsName"  label=" Available Doctors" list="list" headerKey="-1" headerValue="Select Doctor" listKey="doctorId"  listValue="doctorName"/>


 </td>
 </tr>



<tr>
<td>
<s:select theme="xhtml" id="group"  name="group"  list="{'ka','kha'}" style="width:155px" label="Group"/>
<%-- <s:select theme="xhtml" id="session"  name="acadenicsession" headerKey="-1" headerValue="Academic Session" list="{'2013-1014','2014-2015'}" style="width:155px" label="Session"/> --%>

</td>
</tr>

<tr>
<td>
<s:select theme="xhtml" id="session"  name="acadenicsession"  list="{'2016-2017'}" style="width:155px" label="Session"/>
<%-- <s:select theme="xhtml" id="session"  name="acadenicsession" headerKey="-1" headerValue="Academic Session" list="{'2013-1014','2014-2015'}" style="width:155px" label="Session"/> --%>

</td>
</tr>

<tr>
<td>
<s:textfield label="Merit Position" id="meritposition"  name="meritposition"  theme="xhtml" />
</td>
</tr>

 <tr>
<td>
<s:textfield label="Student Name" id="studentName"  name="studentName" readonly="true" theme="xhtml"/>
</td>
</tr>
 <tr>
<td>
<s:textfield label="Gender" id="gender"  name="gender" readonly="true" theme="xhtml"/>
</td>
</tr>

 <tr>
<td>
<s:textfield label="Date of Birth" id="dob"  name="dob"  readonly="true" theme="xhtml"/>
</td>
</tr>

 <tr>
<td>
<s:textfield label="Father Name" id="father_name"  name="father_name"  readonly="true" theme="xhtml"/>
</td>
</tr>





<tr>
<td>
<s:textfield theme="xhtml" label="Amount(in Taka)" id="amount" readonly="true" value="500" name="amount"  />
</td>
</tr>




<tr>
<td>
&nbsp;
</td>
<td>
<s:submit id="save"  value="Save"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>


</table>

</s:form>


		<br/>
	

</fieldset>	
  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
