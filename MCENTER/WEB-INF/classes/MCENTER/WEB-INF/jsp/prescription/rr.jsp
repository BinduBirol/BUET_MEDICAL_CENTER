<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>BUET</title>
<link type="image/x-icon" rel="icon" href="resource/img/logo.png"/>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resource/css/main.css" type="text/css"/>

<script type="text/javascript" src="resource/js/functions.js"></script>


<%-- <link rel="stylesheet" href="/mcenter/resources/jqwidget/jqwidgets/styles/jqx.base.css" type="text/css" />
  <script type="text/javascript" src="/mcenter/resources/jqwidget/scripts/jquery-2.0.2.min.js"></script>
   <script type="text/javascript" src="/mcenter/resources/jqwidget/jqwidgets/jqxcore.js"></script>
   <script type="text/javascript" src="/mcenter/resources/jqwidget/jqwidgets/jqxbuttons.js"></script>
   <script type="text/javascript" src="/mcenter/resources/jqwidget/jqwidgets/jqxscrollbar.js"></script>
   <script type="text/javascript" src="/mcenter/resources/jqwidget/jqwidgets/jqxlistbox.js"></script>
   <script type="text/javascript" src="/mcenter/resources/jqwidget/jqwidgets/jqxcombobox.js"></script> --%>


<style type="text/css" media="screen">
    @import url("/mcenter/resources/css/main.css");
    @import url("/mcenter/resources/css/jquery-ui.css");
    @import url("/mcenter/resources/css/tablecss.css");

    .contentBox {

        width: 600px;
        margin-left: 0px;
    }

    .fleft {
        float: left;
        width: 140px;
        /* background:#C2DFFF; */
        height: 600px;
    }

    .fright {
        float: right;
        /*  background:pink; */
        height: 600px;
        width: 220px;
    }

    .data select {
        float: left;
        width: 90px;
    }


</style>

<script type="text/javascript" src="/mcenter/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/util.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/util.js"></script>
<link type="text/css" rel="stylesheet" href="/mcenter/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/mcenter/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/caljs.js"></script>

<link href="/mcenter/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>


<style>
    .select-editable {
        position: relative;
        background-color: white;
        border: solid grey 1px;
        width: 120px;
        height: 18px;
    }

    .select-editable select {
        position: absolute;
        top: 0px;
        left: 0px;
        font-size: 14px;
        border: none;
        width: 120px;
        margin: 0;
    }

    .select-editable input {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100px;
        padding: 1px;
        font-size: 12px;
        border: none;
    }

    .select-editable select:focus, .select-editable input:focus {
        outline: none;
    }
</style>

<h1 align= center><font size="5" color="red">Founded Prescription by Pharmasist </font></h1>

<fieldset style="background-color:#F0F5F4; width:300px">
	<br/>
		<legend>Patient Info</legend>
	
	
	

<s:form> 
<table>
<tr>
<td>

<s:textfield label="Serial No" id="SerialNo" name="serial" value="%{serialNO}" readonly="true"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Assigned Doctor" id="Doctor" value="%{doctorName}" readonly="true"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Visiting Date" id="VisitingDate"  value="%{prescriptionDate}" readonly="true"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Medical Id" id="MedicalId"  value="%{medicalID}" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="ID holder Name" id="IDholderName"  value="%{medicalIDholderName}" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Department" id="Department"  value="%{department}" readonly="true"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Designation" id="Designation"  value="%{designation}" readonly="true"/>
</td>
</tr>


<tr>
<td>
<s:textfield label="Patient" id="Patient" value="%{patientName}" readonly="true"/>
</td>
</tr>



<tr>
<td>
<s:textfield label="Relation" id="Relation"  value="%{patientRelationWithIDholder}" readonly="true"/>
</td>
</tr>


</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	


<br/>
<br/>
<div style="width: 600px">
<s:form>

   <table class="bordered" align="center" id="table" width="500px">
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>        
        <th width=65>Medicine  Name</th>
        <th width=10>Quantity</th>
         
        <th width=15>Rate</th>
        <th width=5>Price in <br/>Taka</th>
       
        
    </tr>
    </thead>
    <s:if test="pharmacyMedicineBilllist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="pharmacyMedicineBilllist" status="pharmacyMedicineBilllistStatus" var="quantity">
    <tr >
        <td><s:property value="#pharmacyMedicineBilllistStatus.index+1"/></td>        
        <td><s:property value="medicineName"/></td>
         <td align= center><s:property value="medicineQuantity"/></td>
         
        
         <td align= center><s:property value="rate" /></td>
          
        <td align= center> <s:property value="medicineQuantity*rate" /></td>
        
    </tr>        
     </s:iterator>
    
      <tr>
    
    <td colspan="5" align="right">Total:&nbsp;<s:property value="%{total}"/>&nbsp;&nbsp;taka only</td>
    
    </tr>
   
    
    
    
 </tbody>    
    </s:if> 
</table>

	
		


 </s:form>

</div>
<s:submit id="save"  value="Save"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:submit id="print"  value="Print"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
 
 
  
<jsp:include page="layout/footer.jsp"/>
	  
	  
  


</html>

