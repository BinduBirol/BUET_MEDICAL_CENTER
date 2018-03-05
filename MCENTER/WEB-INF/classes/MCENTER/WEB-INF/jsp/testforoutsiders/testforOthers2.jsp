<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<script>
        $(function () {
            $('#testtype').html('');
            $('#testtype').append('<option value>Select Test Type</option>');
            $.getJSON("testtypeaction", function (res)
            
            
             {
                for (var i = 0; i < res.testtypeNamelist.length; i++) {
                    $('#testtype').append(
                        '<option value='+ res.testtypeIDlist[i] +'>' + res.testtypeNamelist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#testtype").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#test').html('');
                    var testtypeID = {
                        "testType": $("#testtype").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                        cache: false,
                        url: "testaction",
                        data: JSON.stringify(testtypeID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.testNamelist.length);
                            for (var i = 0; i < res.testNamelist.length; i++) {
                                console.log(" " + res.testNamelist[i]);
                                $('#test').append(
                                    '<option value=' + res.testIDlist[i] + '>' + res.testNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
                
                
                
                
                
                
        });
          </script>
        
       
     
<script>
$(function () {
$( "#serialNo" ).keyup(function() {
 
  
  var patientsearch= {
                        "visitID": $("#serialNo").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "Search_patient_for_insider_out_doc",
                        data: JSON.stringify(patientsearch),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#doctor").val(Adnan.refDoctor);
                             $("#patientId").val(Adnan.patientID);
                             $("#patientname").val(Adnan.patientname);
 /*                          $("#age").val(Adnan.ageStr);
                             $("#gender").val(Adnan.gender); 
                             $("#designation").val(Adnan.designation);*/
                             $("#patientIdhidden").val(Adnan.patientID);
                             $("#personIdhidden").val(Adnan.personID);
                             $("#visitIDhidden").val(Adnan.visitID);
                                                          
                             
                         }
                            
                        
                    });
  
  
  
  
});



  $("#print").click(function (){
   
   $('#print').html('');
     var visitid = {
                        "visitID": $("#serialNo").val()
                        
                    };
             


$.ajax({
    url: 'demoreportTestforOthersaction',
    type: 'POST',
    data: JSON.stringify(visitid),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  }); 



 }); 

</script>
<script type="text/javascript">

$(function () {
$('#testlist').hide();

 $('#ok').click(function(){
 var txt = $('#patientId');
if (txt.val() != null && txt.val() != '') {
   $('#testlist').show();
  } 
 if (txt.val()==null && txt.val()=='') {
   $('#testlist').hide();
  } 
  });


	     }); 

//inv

 						function checkIfArrayIsUnique(array) 
					    {
					      isUnique=true;
					
					        for (var i = 0; i < array.length; i++) 
					        {
					            for (var j = 0; j < array.length; j++) 
					            {
					                if (i != j) 
					                {
					                    if (array[i] == array[j]) 
					                    {
					                        isUnique=false;
					                    }
					                }
					            }
					        }
					        return isUnique;
					    }


function validationTest() {
var test_sub_type_array = [];
var test_sub_type_array_str="";
var isValid=true;
var table = document.getElementById("testtable"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      
                      test_sub_type_array.push($("#testid_"+i).val());
                      test_sub_type_array_str=test_sub_type_array.join(",");
                      
                      	//var stock =$("#stock_"+i).val();
                      
                        $("#testype_"+i).equalCheck("none","Select a Test Type");
                       if($("#testype_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       
                       $("#testid_"+i).equalCheck("0","Select a Test");
                       if($("#testid_"+i).val()=="0"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       }
                       
                       
                  //     cc_sub_type_array.shift();
                    //   alert(cc_sub_type_array.length);
                       
                       $('select[name^="testname"]').distinct("A Test is repeated.");
                       
				        var a = 0;
				    	while (a < test_sub_type_array.length)
				        if (typeof test_sub_type_array[a] ==="undefined")
				            test_sub_type_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(test_sub_type_array);
                      console.log(test_sub_type_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      if(test_sub_type_array.length>1){
					   var isUnique=checkIfArrayIsUnique(test_sub_type_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate Test Selection..!!!");
                       }
                       }
                       


return isValid;                      
}
function fetchTest(rowid, id) {

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState ==4 && xmlhttp.status == 200) {
            document.getElementById("testypecol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    };
    var url = "GetTestType.action?id=" + id + "&index=" + rowid;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function addRowinv(element) {
	var valid=validationTest();
	if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountinv").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountinv").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "testype_" + (rowid + 1);
    el.name = "testypename";


    try {
        el.addEventListener('change', function () {
            fetchTest(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchTest(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='testypecol_" + (rowid + 1) + "' align='left' style='width: 100px;'>	</div>";
    newCell.innerHTML = a;    
    
    
/*     newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='tstcomm' id='tstcom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a; */


    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadTest(rowid + 1);
    //loadSbTest(rowid + 1);

}
    return false;
}


function loadTest(rowcount) {
    var k = 1;
    var ind = document.getElementById("testype_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");

    <s:iterator  value="testypelist">
    ind.options[k] = new Option("<s:property value="testypename"/>", <s:property value="testypeid" />);
    k = k + 1;
    </s:iterator>
}


function removerowinv(element) {
    try {

        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountinv").value) || 1;
        document.getElementById("rowcountinv").value = rowid - 1;

        return false;
    	}
    	catch (e) {
        alert(e);
    }
}



function validationPAE() {
var isValid=true;
var table = document.getElementById("tablepae"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
  
                       $("#pcom_"+i).require();
                       if($("#pcom_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       

return isValid;                      
}



function addRowP(element) {
	var valid=validationPAE();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountp").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountp").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "center";
    a = "<input type='text' style='width:350px;'  name='pcomments' id='pcom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;

}
    return false;
}


function removerowp(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountp").value) || 1;
        document.getElementById("rowcountp").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}
    
        
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
                    <h1 align= center><font size="5" color="green"> Test for Insider Patient </font></h1>	
	




<fieldset class="additionForm">
	<br/>
		<legend>Outsider Test Patient Info</legend>
	
	
	

<%--  <s:form action="saveTestforOthersaction" theme="xhtml">  --%>
<s:form  theme="xhtml"> 
<table style="border-spacing: 4px;">
<tr>
<td>

<s:textfield label="Serial No" id="serialNo" name="serialNo" value="%{visitID}"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Referenced Doctor" id="doctor" name="doctor" value="%{refDoctor}" readonly="true"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Patient Id" id="patientId"  name="patientId" value="%{patientID}" />
</td>
</tr>

<tr>
<td>
<s:textfield label="Patient Name" id="patientname"  name="patientname" value="%{patientname}" readonly="true"/>
</td>
</tr>

<%-- <tr>
<td>
<s:textfield label="Age " id="age"  name="age" value="%{ageStr}" readonly="true"/>
</td>
</tr>
<tr>

<td>
<s:textfield label="Gender " id="gender"  name="gender" value="%{gender}" readonly="true"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Designation" id="designation"  name="designation" value="%{designation}" readonly="true"/>
</td>
</tr> --%>


<!-- <tr>
<td>Test Type :</td>
<td>
 <select id="testtype" name="b" style="width:155px" ></select>
</td>
</tr>

<tr>
<td>Test :</td>
<td>
 <select id="test"  name="c" style="width:155px" > 
 
 </select>
</td>
</tr> -->



<tr>
<td>
&nbsp;
</td>
<td>
<%-- <s:submit id="ok"  value="OK"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:submit   id="saveTestforOthers"  value="Test for Others"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" /> --%>
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>


</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	

<center>
<s:submit id="ok"  value="OK"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center>

<br/>

<center>                     	
<div style="width:700px" id="testlist">                    	
                    	
        
   <!--   <form action="saveTestforOthersaction" method="post">   -->   	
 	<form action="save_Test_insider_out_doc" name="saveTestforOthersForm" id="saveTestforOthersForm" method="post">
	<s:hidden id="visitIDhidden" name="visitID" value="%{visitID}"> </s:hidden>
	<s:hidden id="patientIdhidden" name="patientId" value="%{patientId}"> </s:hidden>
	<s:hidden id="personIdhidden" name="personID" value="%{personID}"> </s:hidden>
	<table  class="bordered" id="testtable" align="center"  border="0" cellpadding="0" cellspacing="0">
						        <thead>
						        <thead>
						        <tr>
						            <th colspan="3"><big>Investigation Required</big></th>
						        </tr>
						        </thead>
						        <tr>
						            <th class="bottomHeader" style="width:250px">Test Type</th>
						            <th class="bottomHeader"  style="width:320px">Test Name</th>
						            <th class="bottomHeader" style="width:120px"></th>
						           
						        </tr>
						        </thead>
						
						        <tbody>
						        <tr><input type="hidden" id="rowcountinv" name="rowcountinv" value="1"/></tr>
						
						        <tr>
						
						            <td colspan="3" align="center">
						                <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowinv(this);setTimeout(scrolltoBottom, 10);">Add More</a>
						            </td>
						        </tr>
						
						
						        </tbody>
						
						
						    </table>
						   	
						    
						        <br/>
<button  onclick="ConfirmFormSubmit()"     type="button">Save Test</button>
<%-- <s:submit value="insert" id="insert"  theme="simple" align="center"  cssClass="btn btn-primary btn-large" /> --%>
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

	 
					
				</form>                   	
  
 </div>
  </center>

								<table style="width:100%; display: none;"   class="data" align="center" id="tablepae" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th class="bottomHeader" colspan="2"><big>P/A/E</big></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr><input type="hidden" id="rowcountp" name="rowcountp" value="1"/></tr>
								    <tr>
								        <td colspan="2" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowP(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr>
								    </tbody>
								</table>

<script type="text/javascript">	
  
   function ConfirmFormSubmit()
    {
      var x = confirm("Are you sure you want to save Test information..?");
      if (x)
      {
          FormSubmit();
          return true;
      }
      else
        return false;
    }
    
    
			
    function FormSubmit()
    {

      var validTest=validationTest();
      	if(validTest==false){
      	alert("Test Validation Problem");
      	return;
      	}
      	


      	
      	
  
      document.forms["saveTestforOthersForm"].submit();
      
    }
    </script>

<%-- <h1 align= center><font size="5" color="green">Details</font></h1>	
<br/>

<s:form >

   <table class="bordered" >
    <thead style=" font-size: 12px;">

    <tr>
        <th width=5 >No</th>       
        <th width=65>Test type</th>
        <th width=10>Test Name</th>
         <th width=15>Rate</th>
         <th width=15>Vat</th>
        <th width=15>Cost in Taka</th>
        
       
        
    </tr>
    </thead>
    <s:if test="TestBillforOtherslist.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="TestBillforOtherslist" status="TestBillforOtherslistStatus" var="quantity">
    <tr >
        
        <td><s:property value="#TestBillforOtherslistStatus.index+1"/></td>        
         <td  style="display:none;"><s:property   value="visitID" /></td>
        <td style="display:none;"><s:param name="visitID" value="visitID" ></s:param></td> 
        
         <td align= center><s:url action="reportTestforOthersaction" var="detail" >
    			<s:param name="visitID" value="visitID"></s:param>
			 </s:url>
			<s:a href="%{detail}">Details</s:a></td>
        
         
         <td align= center><s:property value="testType"/></td>
         <td align= center><s:property value="testName" /></td>
        <td align= center><s:property value="rate" /></td>
        <td align= center><s:property value="vat" /></td>
         <td align= center><s:property value="cost" /></td>
          
       
        
    </tr>        
     </s:iterator>
    
      <tr>
    
    <td colspan="6" align="right">Total:&nbsp;<s:property value="total"/>&nbsp;&nbsp;taka only</td>
    
     </tr>
   
   
    
    
 </tbody>    
    </s:if> 
</table>

<br/> 
<center>


	
		

</center>	
 </s:form>


 <center> 
<s:form>

<table align="center">
<tr>
<td>
<s:url action="reportTestforOthersaction" var="testbill" >
    			<s:param name="visitID" value="visitID"></s:param>
			 </s:url>
			<s:a href="%{testbill}"> Test Bill</s:a>
</td>	

<td>
<s:submit   onclick="testforOthers1.jsp" id="Newpatient"  value="New Patient"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" /> 
</td>		
</tr>			
</table>

</s:form>
 </center>
--%>
<!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
