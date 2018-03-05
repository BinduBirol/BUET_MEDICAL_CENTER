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

<%--  <script language="javascript">
 
  $(function() { 
	 
	 		//$.validity.setup({outputMode:"summary"});
	 		
	 		/* var table = document.getElementById("medTable");    */            
	 		
                $("form").validity(function() {
                   
                        
                    $("#dateofbirth")
                        .require()
                        .match("date");
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                     
                        //.lessThanOrEqualTo(new Date(),"Bill Date must less than or equal to Todate");
                           
                       $("#name")
                        .require();  
                      
                     
                  
                        
                        
                });
            });
 
 
 
 </script> --%>

   <script language="javascript">
        function addRow(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var colCount = table.rows[0].cells.length;
 
            for(var i=0; i<colCount; i++) {
 
                var newcell = row.insertCell(i);
 
                newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
        }
 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 
    </script>

    

<script>
        $(function () {
            $('#department').html('');
            $('#department').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#department').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#department").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#person').html('');
                    var person = {
                        "departmentID": $("#department").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#person').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#person" ).click(function() {
 
  
  var personOfficialID= {
                        "personofficialID": $("#person").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designation").val(Adnan.designation);
                             $("#officialId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
  
  
  
});               
                
                
                
                
                
        });
          </script>
        
       
     
<script>



 $(function () {

  $("#savedependent").click(function (){
   
   $('#savedependent').html('');
             
var arr = {departmentID:$("#department").val(),designation:$("#designation").val(),officialID:$("#officialId").val(),name:$("#name").val(),dateofbirth:$("#dateofbirth").val(),relation:$("#relation").val(),sex:$("#sex").val()};

$.ajax({
    url: 'savedependentaction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alert("Successfully Saved...");
    
    $("#name").empty();
    
    
       
    }
});
                      
	       
	       
	  }); 


  });




</script>

	
<%--  <script>
$(function() {
$( "#dateofbirth" ).datepicker();
format:dd-mm-yyyy;
});
</script>  --%>

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
                    	
                    	
                    	
                    	

<h1 align= center><font size="5" color="green"> Dependent Entry Form </font></h1>	
<br/>
<fieldset class="additionForm">
	
		<legend>ID Holder</legend>	
<span> 		
		
<s:form action="showdependentlistsaction" > 
<table style="border-spacing: 4px;" >




<tr>
<td align="left">
Dept/Office
</td>
<td align="left">
 <select id="department"  name="department" style="width:155px" theme="xhtml"> 
 
 </select>
</td>
</tr>





<tr>
<td align="left">
Person
</td>
<td>
 <select id="person"  name="person" style="width:220px" theme="xhtml"> 
 
 </select>
</td>
</tr>



<tr>
<td>

<s:textfield label="Designation" id="designation" name="designation" readonly="true" theme="xhtml"/>

</td>
</tr>



<tr>
<td>

<s:textfield label="Official Id" id="officialId" name="officialId" readonly="true" theme="xhtml"/>

</td>
</tr>









<tr>
<td>
&nbsp;
</td>
<td>
<s:submit id="searchDependent"  value="Search"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</td>
</tr>


</table>

</s:form>
</span>

		<br/>
	

</fieldset>	

<br/>
<h1 align= center><font size="5" color="green"> Add Dependent </font></h1>	
<center>
<s:form action="insertdependentaction" method="post">

<s:hidden id="officialIdsend" name="officialIdsend" value="%{officialIdsend}" > </s:hidden>
<s:hidden id="designationsend" name="designationsend" value="%{designationsend}" > </s:hidden>
<center>
	<input type="button" value="Add Row" onclick="addRow('dataTable')"  />
	<input type="button" value="Delete Row" onclick="deleteRow('dataTable')"  />
</center>

     <table   class="bordered">
     <thead style=" font-size: 13px;">
     <tr>
<th> Delete </th>
 <th> Name </th>
<th> Date Of Birth </th>
<th> Relation </th>
<th> Sex </th>


     
     </tr>
     
     </thead>
     <tbody id="dataTable">
        <tr>
            <td ><input type="checkbox" name="chk" /></td>
            <td ><input type="text" style="width:220px" name="name" id="name" placeholder="Name" /></td>
            <td ><input type="text" name="dateofbirth" id="dateofbirth"  placeholder="dd/mm/yyyy" class="dateofbirth" /></td>
            
          <td >
<select id="relation" name="relation">
<option value="nullRelation"> --Select Relation-- </option>
<option value="Father"> Father </option>
<option value="Mother"> Mother </option>
<option value="Husband"> Husband </option>
<option value="Wife"> Wife </option>
<option value="Son"> Son </option>
<option value="Daughter"> Daughter </option>
</select>
</td>
           <td >
<select id="sex" name="sex">
<option value="nullSex"> --Select Sex-- </option>
<option value="Male">Male</option>
<option value="Female">Female</option>
</select>
</td>
        </tr>

        
        </tbody>
    </table>
    <br/>
<center>
<s:submit value="insert" id="insert"  theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

</center>	    

</s:form>
</center>



<!--  
<input type="submit" value="Save" id="savedependent">	
-->		

  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 