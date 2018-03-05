<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>

 <script>
 function getMedIdMedQnt(checkValue, value)
  {
  		var medID = "medID_"+value;
  		var medquantity = "medquantity_"+value;
  		var checkedmedicine = "checkedmedicine_"+value;
  
	  var medid = document.getElementById(medID).value;
	  var medquantity = document.getElementById(medquantity).value;
	   
	  
  
   if(checkValue==true)
   {
   //alert(medid+"#"+medquantity+checkedmedicine);
   document.getElementById(checkedmedicine).value=medid+"#"+medquantity;
   
   }
   else{
   
   //document.getElementById(medquantity).readOnly =false;
   
   }
   
   }
 
 
  
		$(function() {

			$("#deactive").click(function() {

				$('#deactive').html('');
				var activeDoctor = {
					"activeDoctorName" : $("#activedoctor").val()

				};

				$.ajax({

					url : "deactivedoctoraction",
					data : JSON.stringify(activeDoctor),
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function() {
						window.alert('Done');
					}

				});

				$.getJSON("jsonactivedoctoraction", function(res) {

				});

			});

			$("#active").click(function() {

				$('#active').html('');
				var deactiveDoctor = {
					"deactiveDoctorName" : $("#deactivedoctor").val()

				};

				$.ajax({

					url : "reactivedoctoraction",
					data : JSON.stringify(deactiveDoctor),
					dataType : 'json',
					contentType : 'application/json',
					type : 'POST',
					async : true,
					success : function() {
						window.alert('Done');
					}

				});

				$.getJSON("jsonactivedoctoraction", function(res) {

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
                    	
                    	
  
<h1 align= center><font size="5" color="red">Founded Prescription by Pharmasist </font></h1>

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
<%-- <center>
<s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center> --%>
</s:form>

	
		
	
		<br/>
	

</fieldset>	


<br/>
<br/>

<s:if test="pharmacyMedicineBilllist.size()>0">
<s:form action="medicinereducefromsubatoreaction">
<center>
   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>        
        <th width=65 >Medicine  Name</th>
        <th width=65 style="display: none;" >Hidden Medicine  ID</th> 
        
        <th width=10>Doctor Quantity</th>
        <th width=10 style="display: none;">Hidden Quantity</th>
        
        <th width=10>Given Quantity</th>
                
        <th width=15>Rate</th>
        <th width=5>Price in <br/>Taka</th>
        <th width=15>Check</th>
       
        
    </tr>
    </thead>
    
    <tbody id="tablebody">
    
   
  <s:iterator value="pharmacyMedicineBilllist" status="pharmacyMedicineBilllistStatus" var="med">
    <tr id="rowcountrx_<s:property value="#pharmacyMedicineBilllistStatus.index+1"/>" >
        <td><s:property value="#pharmacyMedicineBilllistStatus.index+1"/></td>        
        
        <td><s:property value="medicineName"/></td>
        <td align= center style="display: none;" >
        <s:textfield id="medID_%{#pharmacyMedicineBilllistStatus.index+1}" name="medID"  size="2" value="%{#med.medicineID}" style="height:12px" theme="simple" /></td>
        
        <td align= center><s:property value="medicineQuantity"/></td> 
        <td align= center style="display: none;" >
        <s:textfield id="medquantityDC_%{#pharmacyMedicineBilllistStatus.index+1}" name="medquantityDC"  size="2" value="%{#med.medicineQuantity}" style="height:12px" theme="simple" /></td>
         
        
        <td align= center style="display:;" >
        <s:textfield id="medquantity_%{#pharmacyMedicineBilllistStatus.index+1}" name="medquantity"  size="2" 
        value="%{#med.medicineQuantity}" style="height:12px" theme="simple" readonly="false" onkeyup="multyply('%{#pharmacyMedicineBilllistStatus.index+1}')" /></td>
         
        <td align= center><s:property value="rate" />
        <input type="text" id="rate_<s:property value="#pharmacyMedicineBilllistStatus.index+1"/>" value="<s:property value="rate" />" style="display:none;"/>
        </td>
        
          
        <td id="multyplytd_<s:property value="#pharmacyMedicineBilllistStatus.index+1"/>"  align= center> <s:property value="medicineQuantity*rate" /></td> 
        
        <td align= center>	<input type="checkbox" class="boSelect" id="checkedmedicine_<s:property value="#pharmacyMedicineBilllistStatus.index+1"/>" 
        name="checkedmedicine" value="" onclick="getMedIdMedQnt(this.checked,<s:property value="#pharmacyMedicineBilllistStatus.index+1"/>)  "></td>
    </tr>        
     </s:iterator>
    
      <tr>
    <s:hidden id="SerialNo" name="serial" value="%{serialNO}"/>
    <td colspan="7" align="right">Total:&nbsp;<s:property value="%{total}"/>&nbsp;&nbsp;taka only</td>
     
    </tr>
   
    
    
    
 </tbody>    
    
</table>

</center>	
		
<center>
<br/>
<s:submit id="save"  value="Create Bill"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
  </center>

 </s:form>
</s:if>  
<br/>


<script>
function multyply(value){

//medquantityDC_1 medquantity_1 rate_1 multyplytd_3

//var dcq = parseInt(document.getElementById("medquantityDC_"+value).value);
var phq = parseInt(document.getElementById("medquantity_"+value).value);
var rate = parseFloat(document.getElementById("rate_"+value).value);

var price=phq*rate;

//alert(dcq+"-"+phq+"-"+rate);
//alert(price);
document.getElementById("multyplytd_"+value).innerHTML="";
document.getElementById("multyplytd_"+value).innerHTML=price;


}
</script>

                     <!--Main content will be here-->    
  <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 



