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


 <script >
/* $(function() {
$( "#fromdatepicker" ).datepicker({ dateFormat: 'dd/mm/yy'}).val();

$( "#todatepicker" ).datepicker({ dateFormat: 'dd/mm/yy'}).val();
});
 */

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

 <script lang="javascript">

	 $(function() {
	 
	 $("form").validity(function() {
                       $("#fromdatepicker")
                        .require()
                        .match("date");
                        
                         $("#todatepicker")
                        .require()
                        .match("date");
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
                    	
                    	
  
 



     <h1 align= center><font size="5" color="green">Daily Doctor vs Patient Seial list</font></h1>
     
     
  <fieldset class="additionForm">
	
		<legend>Select date and shift</legend>
	
	
	

<s:form action="DailyDoctorVSpatientFinalListShowaction"> 
<table align="center" style="border-spacing: 4px;">

<%-- <tr>
<td>
<s:select id="shift" name="shift" list="{'9-12 AM','4-6  PM'}" label="Shift" theme="xhtml"/>

</td>
</tr>
 --%>
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
&nbsp;
</td>
<td>
<s:submit   id="search"  value="Search"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small" align="center"/>
</td>
</tr>


</table>

</s:form>
</fieldset>	   
     
  
<br/>

  <table class="bordered">
    <thead>

    <tr>
        <th width=15>Date</th> 
        <th width=5>Patient NO</th> 
        <th width=20>Serial No</th> 
        <th width=30>Patient</th>
        <th width=30>Doctor</th>
			<!-- <th width=30>patientID</th>
			<th width=30>Shift</th>
 -->



		</tr>
    </thead>
    
<tbody id="tableBody">    
    
<s:iterator  value="dailydoctorvspatientlist">
<tr>

<td><s:property value="visitingdate"/></td>
<td><s:property value="patientnumber"/></td>
<td><s:property value="serialNo"/></td>
<td><s:property value="patient"/></td>
<td><s:property value="doctor"/></td>
<%-- <td><s:property value="patientID"/></td>
<td><s:property value="shift"/></td>
 --%>



</tr>
</s:iterator> 
    
   
 </tbody>   
    
 <tfoot>  
   <tr>
        <td>
        
        </td>
        
  </tr> 
</tfoot>    
    </table>


  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
