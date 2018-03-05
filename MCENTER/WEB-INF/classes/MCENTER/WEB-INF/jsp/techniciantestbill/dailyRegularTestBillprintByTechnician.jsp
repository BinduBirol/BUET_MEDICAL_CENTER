<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>

 <script>
  $(function () {
  
  

 
 
      $("#deactive").click(function (){
      
      
            
	       
                $('#deactive').html('');
                    var activeDoctor = {
                        "activeDoctorName": $("#activedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "deactivedoctoraction",
                        data: JSON.stringify(activeDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(){window.alert('Done');}
                            
                        
                    });
                    
                    $.getJSON("jsonactivedoctoraction", function (res) {

                                        });  
                    
             });   
             
             
             
              $("#active").click(function (){
      
      
            
	       
                $('#active').html('');
                    var deactiveDoctor = {
                        "deactiveDoctorName": $("#deactivedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "reactivedoctoraction",
                        data: JSON.stringify(deactiveDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(){window.alert('Done');}
                            
                        
                    });
                    
                    $.getJSON("jsonactivedoctoraction", function (res) {

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
                    	
                    	
  
<h1 align= center><font size="5" color="red">Founded Prescription by Technician </font></h1>

<fieldset class="additionForm">
	<br/>
		<legend>Patient Info</legend>
	
	
	

<s:form action="printmedinebillaction"> 
<table style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="SerialNo" name="serial" value="%{serialNO}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Assigned Doctor" id="Doctor" value="%{doctorName}" readonly="true" theme="xhtml"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Visiting Date" id="VisitingDate"  value="%{prescriptionDate}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Medical Id" id="MedicalId"  value="%{medicalID}" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="ID holder Name" id="IDholderName"  value="%{medicalIDholderName}" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Department" id="Department"  value="%{department}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="Designation"  value="%{designation}" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Patient" id="Patient" value="%{patientName}" readonly="true" theme="xhtml"/>
</td>
</tr>



<tr>
<td>
<s:textfield label="Relation" id="Relation"  value="%{patientRelationWithIDholder}" readonly="true" theme="xhtml"/>
</td>
</tr>


</table>
<center>
<%-- <s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" /> --%>
</center>
</s:form>

	
		
	
		<br/>
	

</fieldset>	


<br/>


<br/>
<h1 align= center><font size="5" color="green">TEST BILL</font></h1>	
<br/>
<center>
<s:if test="totalbillList.size()>0">
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>        
        <th width=65>Bill No</th>
        <th width=10>Visit ID</th>
         <th width=15>Date</th>
         <th width=15>Cost in<br/>Taka</th>
        <th width=15>Print</th>
        
       
        
    </tr>
    </thead>
    
    <tbody id="tablebody">
    
   
	  <s:iterator value="totalbillList" status="totalbillListStatus" var="quantity">
	    <tr >
		 <td><s:property value="#totalbillListStatus.index+1"/></td>        
        
		 <td align= center><s:property value="billNo"/></td>
	 	 <td align= center><s:property   value="visitID" /></td>
 	     <td align= center><s:property value="date" /></td>
         <td align= center><s:property value="cost" /></td>
         <td align= center><s:url action="printTestBillAction" var="detail" >
    			<s:param name="visitID" value="visitID"></s:param>
				<s:param name="billID" value="billNo"></s:param>
			 </s:url>
			<s:a href="%{detail}" cssClass="btn btn-primary btn-large">Print</s:a></td>
          
        
        
    </tr>        
     </s:iterator>
    
    
 </tbody>    
    
</table>

<br/>	

 </s:form>
</s:if> 

 <s:if test="totalbillList.size()==0">
 
 <h1 align= center><font size="5" color="red">There is no test.</font></h1>
 </s:if> 
</center>

<%-- <br/>

<s:form action="medicinereducefromsubatoreaction">

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>        
        <th width=65>Medicine  Name</th>
        <th width=65 >Hidden Medicine  ID</th> 
        <th width=10>Quantity</th>
        <th width=10>Hidden Quantity</th>
        <th width=15>Rate</th>
        <th width=5>Price in <br/>Taka</th>
       
        
    </tr>
    </thead>
    <s:if test="pharmacyMedicineBilllist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="pharmacyMedicineBilllist" status="pharmacyMedicineBilllistStatus" var="med">
    <tr >
        <td><s:property value="#pharmacyMedicineBilllistStatus.index+1"/></td>        
        <td><s:property value="medicineName"/></td>
        <td align= center ><s:textfield id="medID" name="medID"  size="2" value="%{#med.medicineID}" style="height:12px" theme="simple" /></td>
        <td align= center><s:property value="medicineQuantity"/></td> 
        <td align= center ><s:textfield id="medquantity" name="medquantity"  size="2" value="%{#med.medicineQuantity}" style="height:12px" theme="simple" /></td>
         <td align= center><s:property value="rate" /></td>
          
        <td align= center> <s:property value="medicineQuantity*rate" /></td>
        
    </tr>        
     </s:iterator>
    
      <tr>
    <s:hidden id="SerialNo" name="serial" value="%{serialNO}"/>
    <td colspan="5" align="right">Total:&nbsp;<s:property value="%{total}"/>&nbsp;&nbsp;taka only</td>
    
    </tr>
   
    
    
    
 </tbody>    
    </s:if> 
</table>

	
		
<center>
<br/>
<s:submit id="save"  value="Save"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
  </center>

 </s:form>
<br/> --%>
                    <!--Main content will be here-->    
    <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
 




  
	

                    	
                    
                    
                        
                        
                        
                        
                        

