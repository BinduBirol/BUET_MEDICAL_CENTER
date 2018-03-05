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
 

$(function () {
$('#edit').hide();

 $('#update').click(function(){
    $('#edit').toggle();
    
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
            
           
            
            var f1 = document.getElementById('dependentID');
            var f2 = document.getElementById('dependentName');
            var f3 = document.getElementById('dateofbirth');
           
            
            
            f1.value = cells[2].innerHTML;
            f2.value = cells[3].innerHTML;
            f3.value = cells[4].innerHTML;
            
           
            
            
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
                    
                    	<h1 align= center><font size="5" color="red">Dependent List of Employees</font></h1>	
	




<fieldset class="additionForm">
	<br/>
		<legend>ID holder's  Info</legend>
	
	
	

<s:form > 
<table style="border-spacing: 4px;">

<tr>
<td>
<s:textfield label="ID holder Name" id="idholderName"  name="idholderName" readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Department" id="departmentName"  name="departmentName"  readonly="true" theme="xhtml"/>
</td>
</tr>




<tr>
<td>

<s:textfield label="Designation" id="designation" name="designation" readonly="true" theme="xhtml"/>

</td>
</tr>



<tr>
<td>

<s:textfield label="Official Id" id="officialID" name="officialID" readonly="true" theme="xhtml"/>

</td>
</tr>



</table>

</s:form>

	
		
	
		<br/>
	

</fieldset>	


	
	




<br/>
<h1 align= center><font size="5" color="green">Dependent List</font></h1>	
<br/>

<s:form>

   <table class="bordered" >
    <thead style=" font-size: 13px;">

    <tr>
        <th width=5 >No</th> 
        <th width=15>Dependent ID</th>       
         <th width=30>Name</th>
         <th width=15>Date of Birth</th>
         <th width=10>Age</th>       
        <th width=15>Gender</th>
        <th width=15>Relation</th>
        <th width=15>Delete</th>
        
       
        
    </tr>
    </thead>
    <s:if test="dependentList.size()>0">
    <tbody id="tablebody">
    
   
  <s:iterator value="dependentList" status="dependentListStatus" var="quantity">
    <tr >
     <td style="display:none;"><s:property value="officialId" /></td>
        <td><s:property value="#dependentListStatus.index+1"/></td> 
        <td align= center><s:property value="dependentID" /></td>              
         <td align= center><s:property value="dependentname" /></td>
        <td align= center><s:property value="dateofbirth" /></td>
        <td align= center><s:property value="ageStr" /></td>
        <td align= center><s:property value="sex" /></td>
        <td align= center><s:property value="relation" /></td>
         
			
      <td align= center><s:url action="deletedependentaction" var="delete" >
    			<s:param name="dependentID" value="dependentID"></s:param>
    			<s:param name="dependentname" value="dependentname"></s:param>
			 </s:url>
			<s:a href="%{delete}">Delete</s:a></td>    
        
        
    </tr>        
     </s:iterator>
    
    
   
    
    
    
 </tbody>    
    </s:if> 
</table>

<br/>	

 </s:form>

<div style="float:center;">
<div style="float: left;">
<s:form action="addDependent1" method="post" margin="auto" theme="simple">
 <s:submit value="GO Back" align="center" theme="simple" cssClass="btn btn-small"/>
</s:form>

</div>
<div style="float: left;">
&nbsp;
</div>
<div style="float: left;">
<s:submit   id="update" value="Update" cssClass="btn btn-primary btn-large" />
</div>
</div>

<div id="edit">
	<fieldset class="additionForm">
	<br/>
		<legend>Edit</legend>
<s:form action="updatedependentaction" >	
<table align="center" style="border-spacing: 4px;">
<tr>
<td>
<s:textfield label="Dependent ID" id="dependentID" name="dependentID"  readonly="true" theme="xhtml"/>
</td>
</tr>

<%-- <tr>
<td>
<s:textfield label=" New Dependent ID" id="newdependentID" name="newdependentID"   />
</td>
</tr> --%>

<tr>
<td>
<s:textfield label="Dependent Name" id="dependentName" name="dependentName"  theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield label="Date of Birth(dd/mm/yyyy)*" id="dateofbirth"  name="dateofbirth" placeholder="dd/mm/yyyy"  theme="xhtml"/>

</td>
</tr>
<tr>

<td>
<s:select id="gender" list="{'Male','Female'}"  name="gender" label="Gender" theme="xhtml"/>

</td>
</tr>


<tr>

<td>
<s:select theme="xhtml" id="relation" list="{'Father','Mother','Son','Daughter','Husbend','Wife'}" name="relation" label="Relation"/>

</td>
</tr>

<tr>
<td>
&nbsp;
</td>
<td>
<s:submit id="editdependent"  value="Edit"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>

</table>

</s:form>




</fieldset> 
</div>
	
                        
  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
