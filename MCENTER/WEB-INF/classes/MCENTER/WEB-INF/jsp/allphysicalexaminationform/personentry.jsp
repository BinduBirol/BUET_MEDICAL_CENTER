<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>

<script type="text/javascript" src="resources/MCENTER/js/functions.js"></script>

 <script type="text/javascript" src="/MCENTER/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<link type="text/css" rel="stylesheet" href="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/caljs.js"></script>

<link href="/MCENTER/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<!--  <script>
$(function() {
$( "#dob" ).datepicker({ dateFormat: 'dd/mm/yy'}).val();

});

</script> --> 

    <script>
        $(function() {
            $("#dob").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

        });
    </script>

<script>
$(function () {
$( "#purpose" ).click(function() {
 
  
  var purpose= {
                        "purpose": $("#purpose").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "createreceiptofmedicalcheckupaction",
                        data: JSON.stringify(purpose),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#receiptNO").val(Adnan.receiptNO);
                             
                             
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
                    	
   <h1 align= center><font size="5" color="green">Person Entry form</font></h1>	
<fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form action="savepersonformedicalcheckupaction" theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">


 <tr>
<td>
<s:select  id="purpose"  name="purpose" list="{'New Appoinment','Going abroad','Re Joinning','Extention'}" label="Purpose"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO" name="receiptNO"  />
</td>
</tr>

 <tr>
<td>
<s:textfield label="Name" id="name"  name="name"  />
</td>
</tr>

 <tr>
<td>
<s:select  id="sex" list="{'Male','Female','Others'}" label="Gender" name="sex" />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Date of birth" id="dob" name="dob"/>
</td>
</tr>

<tr>
<td>
<s:textfield  label="Designation" id="designation" name="designation"  />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Office" id="office"  name="office"  />
</td>
</tr>

 <tr>
<td>
&nbsp;
</td>
<td>
<s:submit id="ok"  value="OK"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr> 


</table>

</s:form>

		<br/>
	

</fieldset>	



  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
