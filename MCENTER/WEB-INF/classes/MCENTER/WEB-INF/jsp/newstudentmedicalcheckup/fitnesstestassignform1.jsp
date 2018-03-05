<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>

<script type="text/javascript" src="resources/MCENTER/js/functions.js"></script>

 <script type="text/javascript" src="/MCENTER/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<link type="text/css" rel="stylesheet" href="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/caljs.js"></script>

<link href="/MCENTER/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>


<script lang="javascript">

	 $(function() { 
	 
	 		//$.validity.setup({outputMode:"summary"});
	 		
	 		var table = document.getElementById("testtable");               
	 		
                $("form").validity(function() {
                                         
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                                            
                      for(var i = 1; i < table.rows.length; i++) { 
                      
                      	//var stock =$("#stock_"+i).val();
                       testype =$("#testype_"+i).val();
                       alert(testype);
                       testype.equalCheck("-1","Select Generic Name");
                       
                       testid =$("#testid_"+i).val();
                       testid.equalCheck("0","Select Generic Name");
                       
                    /*     $("#testype_"+i)
                        	.equalCheck("-1","Select Generic Name");
                        
                        $("#testid_"+i)
                        	.equalCheck("0","Select Medicine Name");   */                      	
                        
                        $("#issueqty_"+i)
	                        .require()
	                        .match("integer")
	                        .range(1, $("#stock_"+i).val());
	                        //.lessThan( $("#stock_"+i).val());                        
                      
                      }
                     $('select[name^="testname"]')
                        .distinct("A Medicine Name is repeated.");
                        
                        
                });
            });

</script>

<script>
$(function () {
$( "#receiptNO" ).keyup(function() {
 
  
  var receiptNO= {
                        "receiptNO": $("#receiptNO").val()
                        
                    };
                    
                   

  $.ajax({
                    
                        url: "searchnewstudentaction",
                        data: JSON.stringify(receiptNO),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#academicsession").val(Adnan.acadenicsession);
                             $("#studentName").val(Adnan.studentname);
                             $("#meritposition").val(Adnan.meritPosition);
                              $("#receiptNOhidden").val(Adnan.receiptNO);
                             
                                                         
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 


$(function () {
$('#testlist').hide();

 $('#ok').click(function(){
 var txt = $('#academicsession');
if (txt.val() != null && txt.val() != '') {
   $('#testlist').show();
  } 
 if (txt.val()==null && txt.val()=='') {
   $('#testlist').hide();
  } 
  });


	     }); 
</script>
<script type="text/javascript">


//inv
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
    a = "<a href=\"#\" onclick=\"return removerowinv(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadTest(rowid + 1);
    //loadSbTest(rowid + 1);


    return false;
}


function loadTest(rowcount) {
    var k = 1;
    var ind = document.getElementById("testype_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "-1");

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
                    	
   <h1 align= center><font size="5" color="green"> Test list for  New student Medical checkup </font></h1>	
<fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form > 
<table align="center" style="border-spacing: 4px;">


<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO"   theme="xhtml">
<s:param name="value">
ADM-RECPT NO:
</s:param>
</s:textfield>
</td>
</tr>



 <tr>
<td>
<s:textfield label="Academic Session" id="academicsession"   readonly="true" theme="xhtml"/>
</td>
</tr>

<tr>
<td>
<s:textfield  label="Merit Position" id="meritposition"  readonly="true" theme="xhtml" />
</td>
</tr>


 <tr>
<td>
<s:textfield label="Student Name" id="studentName"  readonly="true" theme="xhtml"/>
</td>
</tr>


<tr>
<td>
&nbsp;
</td>
<td>

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
                    	
             	
 	<form action="savetestlistofnewstudentaction" method="post">
	<s:hidden id="receiptNOhidden" name="receiptNO" value="%{receiptNO}"> </s:hidden>
	
	
	<table class="bordered" align="center" id="table" width="500px"   >
    <thead style=" font-size: 12px;">

    <tr>
        <th width=10>No</th>        
        <th width=20>Test Name</th>
    
    </tr>
    </thead>
    
    <tbody id="tablebody">
    
   
  
<tr> 
       <td style="padding:10px;">01</td>        
       
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testTypeID" name="testTypeID"  size="2" value="04" style="height:12px" theme="simple" /></td>
        <td align= center style="padding:10px;">Blood Group</td>
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testNameID" name="testNameID"  size="2" value="14" style="height:12px" theme="simple" /></td>
       
</tr>

<tr> 
       <td style="padding:10px;">02</td>        
        
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testTypeID" name="testTypeID"  size="2" value="04" style="height:12px" theme="simple" /></td>
        <td align= center style="padding:10px;">HBsAg(Screening)</td>
        <td align= center style="display: none; padding:10px;" ><s:textfield id="testNameID" name="testNameID"  size="2" value="51" style="height:12px" theme="simple" /></td>
       
</tr>
    
   
     
  
      
 </tbody>    
 
</table>


	    
						        <br/>

<s:submit value="Save" id="insert"  theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
<s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"  align="center"/>

	 
					
				</form>                   	
  
 </div>
  </center>
  
  
  
  

  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
