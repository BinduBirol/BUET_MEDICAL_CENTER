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
}); */

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
                    	
                    	
  
 



<h1 align= center><font size="5" color="red">Total Bill </font></h1>	
	




<fieldset class="additionForm">
	<br/>
		<legend>Personal Info</legend>
	
	
	

<s:form action="totalbillofmonthaction" theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">
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
<h1 align= center><font size="5" color="green">Total Bill of Month</font></h1>	
<br/>
<center>
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th  >No</th>        
        <th >Medical ID</th>
         <th >Name</th>
        <th >Designation</th>
         <th >Department</th>
         <th > Total Medicine Bill</th>
        <th > Total Test Bill</th>
        <th >Total Bill</th>
        
       
        
    </tr>
    </thead>
    <s:if test="totalbillList.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="totalbillList" status="totalbillListStatus" var="quantity">
    <tr >
        <td><s:property value="#totalbillListStatus.index+1"/></td>        
         <td align= center><s:property   value="medicalID" /></td>
        <td align= center><s:property value="name" /></td>
        <td align= center><s:property value="designation" /></td>
        <td align= center><s:property value="department" /></td>
        <td align= center><s:property value="totalMedicinebill" /></td>
        <td align= center><s:property value="totalTestbill" /></td>
        <td align= center><s:property value="totalbill" /></td>
       </tr>        
     </s:iterator>
         
    <tr>
    <td colspan="5" align="center"> Grand Total:</td>
    <td  align="left">Total:&nbsp;<s:property value="totalmed"/></td>
    <td  align="left">Total:&nbsp;<s:property value="totaltest"/></td>
    <td align="left">Total:&nbsp;<s:property value="total"/></td>
    
    
    </tr> 
     
    
 </tbody>    
    </s:if> 
</table>

<br/>	

 </s:form>
</center>


<center>
<s:form action="totalbillofmonthreportaction">
<s:hidden name="fdate"/>
<s:hidden name="tdate"/>
<s:submit   id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</s:form>

</center>
  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
