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
     
<script>
$(function () {
$( "#medicalID" ).keyup(function() {
 
  
  var searchperson= {
                        "medicalID": $("#medicalID").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "searchemployeeaction",
                        data: JSON.stringify(searchperson),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#name").val(Adnan.name);
                             $("#department").val(Adnan.department);
                             $("#designation").val(Adnan.designation);
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 


/*
 $(function () {

  $("#search").click(function (){
   
   $('#search').html('');
             
var arr = {medicalID:$("#medicalID").val(),fdate:$("#fromdatepicker").val(),tdate:$("#todatepicker").val()};
$.ajax({
    url: 'totalbillofemployeeaction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    
    
       
    }
});
                      
	       
	       
	  }); 


  });
*/
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
                    	
                    	
  
 



<h1 align= center><font size="5" color="red">Total Bill </font></h1>	
	




<fieldset class="additionForm">
	<br/>
		<legend>Personal Info</legend>
	
	
	

<s:form action="totalbillofemployeeaction" theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">
<tr>
<td>
<s:textfield label="Patient Id" id="medicalID" name="medicalID"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Name" id="name"   name="name" readonly="true"/>

</td>
</tr>



<tr>
<td>
<s:textfield label="Department" id="department"  name="department"  readonly="true"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="designation"   name="designation" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="From Date" id="fromdatepicker"  name="fdate" size="8" />

</td>
</tr>

<tr>
<td>
<s:textfield label="To Date" id="todatepicker"  name="tdate"  size="8" />

</td>
</tr>



	





<tr>
<td>
&nbsp;
</td>
<td>
<s:submit   id="search"  value="Search"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>


</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	


	
	




<br/>
<h1 align= center><font size="5" color="green">Medicine Bill</font></h1>	
<br/>
<center>
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>        
        <th width=65>Bill No</th>
        <th width=10>Visit ID</th>
         <th width=15>Date</th>
         <th width=15>Cost in<br/>Taka</th>
        <th width=15>Details</th>
        
       
        
    </tr>
    </thead>
    <s:if test="totalbillList.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="totalbillList" status="totalbillListStatus" var="quantity">
    <tr >
        <td><s:property value="#totalbillListStatus.index+1"/></td>        
        
         <td align= center><s:property value="billNo"/></td>
         <td align= center><s:property   value="visitID" /></td>
        <td align= center><s:property value="date" /></td>
        <td align= center><s:property value="cost" /></td>
         <td align= center><s:url action="medicinebilldetailsaction" var="detail" >
    			<s:param name="visitID" value="visitID"></s:param>
    			<s:param name="billID" value="billNo"></s:param>
			 </s:url>
			<s:a href="%{detail}">Details</s:a></td>
          
        
        
    </tr>        
     </s:iterator>
    
      <tr>
    
    <td colspan="6" align="right">Total:&nbsp;<s:property value="total"/>&nbsp;&nbsp;taka only</td>
    
    </tr>
   
    
    
    
 </tbody>    
    </s:if> 
</table>

<br/>	

 </s:form>
</center>

<br/>
<h1 align= center><font size="5" color="green">Test Bill</font></h1>	
<br/>
<center>
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
       <th width=5 >No</th>        
        <th width=65>Bill No</th>
        <th width=10>Visit ID</th>
         <th width=15>Date</th>
         <th width=15>Cost in<br/>Taka</th>
        <th width=15>Details</th>
        
       
        
    </tr>
    </thead>
    <s:if test="totalTestbillList.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="totalTestbillList" status="totalTestbillListStatus" var="quantity">
    <tr >
        <td><s:property value="#totalTestbillListStatus.index+1"/></td>        
        
         <td align= center><s:property value="testbillNo"/></td>
         <td align= center><s:property value="testvisitID" /></td>
        <td align= center><s:property value="testdate" /></td>
        <td align= center><s:property value="testcost" /></td>
         <td align= center><s:url action="testbilldetailsaction" var="detail" >
    			<s:param name="testvisitID" value="testvisitID"></s:param>
			 </s:url>
			<s:a href="%{detail}">Details</s:a></td>
          
        
        
    </tr>        
     </s:iterator>
    
      <tr>
    
    <td colspan="6" align="right">Total:&nbsp;<s:property value="testtotal"/>&nbsp;&nbsp;taka only</td>
    
    </tr>
   
    
    
    
 </tbody>    
    </s:if> 
</table>

<br/>	

 </s:form>
</center>
<center>
<s:form action="totalbillaction">
<s:hidden name="medicalID"/>
<s:hidden name="fdate"/>
<s:hidden name="tdate"/>
<s:submit   id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</s:form>

</center>
  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
