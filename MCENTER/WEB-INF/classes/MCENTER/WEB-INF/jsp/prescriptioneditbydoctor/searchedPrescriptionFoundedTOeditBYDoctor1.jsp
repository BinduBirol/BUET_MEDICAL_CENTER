<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<script>
/* $(function () {
  $("#editPrescription").click(function (){
   
   $('#editPrescription').html('');
             
var arr = {serial:$("#SerialNo").val(),medicineeditID:$("#medicineID").val(),mName:$("#medicinename").val(),editedQuantity:$("#quantityEdited").val(),previousQuantity:$("#quantityGiven").val() };
$.ajax({
    url: 'editmedicinequantityBYdoctoraction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alert("Medicine quantity is edited...");
       
    }
});
                      
	       
	       
	  });  
 });  */
 
 

$(function () {
$('#edit').hide();

 $('#update').click(function(){
    $('#edit').toggle();
    
  });


	     });     
        
 

</script>
 
 

 <script>
 /*
 jQuery(function(){
$.getJSON("activedoctor", function (res) {

});
});
 */

            
 (function () {
    if (window.addEventListener) {
        window.addEventListener('load', run, false);
    } else if (window.attachEvent) {
        window.attachEvent('onload', run);
    }

    function run() {
        var t = document.getElementById('tablebody');
        t.onclick = function (event) {
            event = event || window.event; //IE8
            var target = event.target || event.srcElement;
            while (target && target.nodeName != 'TR') { // find TR
                target = target.parentElement;
            }
            //if (!target) { return; } //tr should be always found
            var cells = target.cells; //cell collection - https://developer.mozilla.org/en-US/docs/Web/API/HTMLTableRowElement
           // var cells = target.getElementsByTagName('td'); //alternative
            if (!cells.length || target.parentNode.nodeName == 'THEAD') {
                return;
            }
            
           
            
            var f1 = document.getElementById('no');
            var f2 = document.getElementById('medicineID');
            var f3 = document.getElementById('medicinename');
            var f4 = document.getElementById('quantityGiven');
            var f5 = document.getElementById('rateedit');
            var f6 = document.getElementById('price');
            
            
            f1.value = cells[0].innerHTML;
            f2.value = cells[1].innerHTML;
            f3.value = cells[2].innerHTML;
            f4.value = cells[3].innerHTML;
            f5.value = cells[4].innerHTML;
            f6.value = cells[5].innerHTML;
            
            
            //console.log(target.nodeName, event);
        };
    }

})();

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
                    	
                    	
<h1 align= center><font size="5" color="red">Founded Prescription by Doctor </font></h1>

<fieldset class="additionForm">
	<br/>
		<legend>Patient Info</legend>
	
	
	

<s:form> 
<table align="center" style="border-spacing: 4px;">
<tr>
<td>

<s:textfield theme="xhtml" label="Serial No" id="SerialNo" name="serial" value="%{serialNO}" readonly="true"/>

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
<s:textfield label="Patient Id" id="MedicalId"  value="%{medicalID}" readonly="true" theme="xhtml"/>
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

</s:form>


	
		
	
		<br/>
	

</fieldset>	


<br/>

<br/>
<center>
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>
        <th width=65 style="display: none;">Medicine  ID</th>        
        <th width=65>Medicine  Name</th>
        <th width=65 style="display: none;">Medicine ID</th>
        <th width=10>Quantity</th>
         <th width=10 style="display: none;">Quantity</th>
        <th width=15>Rate</th>
        <th width=5>Price in <br/>Taka</th>
       
        
    </tr>
    </thead>
    <s:if test="editprescriptionList.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="editprescriptionList" status="editprescriptionListStatus" var="quantity">
    <tr >
        <td><s:property value="#editprescriptionListStatus.index+1"/></td> 
        <td style="display: none;"><s:property value="medicineID"/></td>       
        <td><s:property value="medicineName"/></td>
       
         <td align= center ><s:property value="medicineQuantity"/></td>
         
        <%-- <td style="display: none;" align= center><s:property value="medicineQuantity"/></td>  --%>
       <%--   <td align= center style="display: none;"><s:textfield id="medquantity" name="medquantity"  size="2" value="%{#quantity.medicineQuantity}" style="height:12px" theme="simple" /></td>
          --%>
         <td align= center><s:property value="rate" /></td>
          
        <td align= center> <s:property value="medicineQuantity*rate" /></td>
        
    </tr>        
     </s:iterator>
    
    
   
    
    
    
 </tbody>    
    </s:if> 
</table>
<br/>
<div  style=" padding-left:400px;font-size: 14px " >Total:<s:property value="%{total}"/>&nbsp;Taka only</div>

	<br/>

 </s:form>
 
 </center>

 <s:submit  align="center" id="update" value="Update" theme="simple" cssClass="btn btn-primary btn-large"/>    

<div id="edit">
	<fieldset class="additionForm">
	<br/>
		<legend>Edit</legend>
<s:form action="editmedicinequantityBYdoctoraction">	
<table align="center" style="border-spacing: 4px;">
<tr>
<td>
<s:textfield label="Medicine No" id="no" readonly="true" theme="xhtml" />
<s:hidden id="medicineID" name="medicineID"/>
<s:hidden id="serialNO" name="serialNO" value="%{serialNO}"/>
</td>
</tr>

<%-- <tr>
<td>
<s:textfield label="Medicine ID" id="medicineID" readonly="true"  />
</td>
</tr> --%>

<tr>
<td>
<s:textfield label="Medicine Name" id="medicinename"  readonly="true" theme="xhtml" />
</td>
</tr>
<tr>

<td>
<s:textfield label=" Previous Quantity" id="quantityGiven"  name="quantityGiven" readonly="true" theme="xhtml"/>
</td>
</tr>
<tr>

<td>
<s:textfield theme="xhtml" label="New Quantity" id="quantityEdited" name="quantityEdited" onKeyUp="document.getElementById('price').value=this.value*document.getElementById('rateedit').value" />
</td>
</tr>

<tr>

<td>
<s:textfield label="Rate" id="rateedit" name="rateedit" readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>

<td>
<s:textfield label="Price"  id="price" readonly="true" theme="xhtml"/>
</td>
</tr>
</table>
<center>

<s:submit id="editPrescription"  value="Edit"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small" align="center"/>
</center>
</s:form>

</fieldset> 
</div>
                    	
               
 <!--Main content will be here-->  
  <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
                   
