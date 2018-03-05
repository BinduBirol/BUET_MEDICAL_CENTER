 <%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<script type="text/javascript" src="http://jsearchdropdown.sourceforge.net/jquery-1.7.1.min.js"></script>  
<script type="text/javascript" src="http://jsearchdropdown.sourceforge.net//jquery.searchabledropdown.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            $("select").searchable();
            
            $('#html').editableSelect();
        });
  </script>
 
 <link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link> 
<link rel="stylesheet" href="/MCENTER/resources/css/mainR.css" type="text/css"/>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<!-- <script type="text/javascript" src="resources/MCENTER/js/functions.js"></script> -->
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<!-- <script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script> -->
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>


<!-- <script type="text/javascript" src="/MCENTER/resources/js/lib/jquery-1.6.4.min.js"></script> 
<script type="text/javascript" src="/MCENTER/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/caljs.js"></script>
<link href="/MCENTER/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>
<link type="text/css" rel="stylesheet" href="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
-->


<style type="text/css" media="screen">
   
   
    @import url("/MCENTER/resources/css/jquery-ui.css");
	.contentBox {
		float: left;
		width: 100%;
		margin-left: 0;
	}
	.contentBox table table {
		border: solid 1px #999999;
		margin-bottom: 20px;
		border-bottom:none;
		border-right:none;
	}
	.contentBox table table th {
		background:#eeeeee;
	}
	.contentBox table table th:last-child {
		background:#eeeeee;
		border-right: solid 1px #999999;
	}
	.contentBox table table td {
		border-bottom: solid 1px #999999;
		border-right: solid 1px #999999;
		padding: 3px;
	}
    .fleft {
        float: left;
        width: 400px;
        /*background:#C2DFFF;*/ 
    }

    .fright {
        float: right;
        /*  background:pink; */
        height: 60px;
        width: 220px;
    }

    .data select {
        float: left;
        width: 200px;
    }

    .select-editable {
        position: relative;
        background-color: white;
        border: solid grey 1px;
        width: 520px;
        height: 18px;
    }

    .select-editable select {
        position: absolute;
        top: 0px;
        left: 0px;
        font-size: 14px;
        border: none;
        width: 520px;
        margin: 0;
    }

    .select-editable input {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 500px;
        padding: 1px;
        font-size: 12px;
        border: none;
    }

    .select-editable select:focus, .select-editable input:focus {
        outline: none;
    }
    
    
   /* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}






 .select-editable {
     position:relative;
     background-color:white;
     border:solid grey 1px;
     width:120px;
     height:18px;
 }
 .select-editable select {
     position:absolute;
     top:0px;
     left:0px;
     font-size:14px;
     border:none;
     width:120px;
     margin:0;
 }
 .select-editable input {
     position:absolute;
     top:0px;
     left:0px;
     width:100px;
     padding:1px;
     font-size:12px;
     border:none;
 }
 .select-editable select:focus, .select-editable input:focus {
     outline:none;
 }
    
    
</style>




<script type="text/javascript">

//cc
function fetchItem(rowid, id) {

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("cctypecol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
    var url = "GetCcType.action?id=" + id + "&index=" + rowid;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

//validation C/C
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




function validationCC() {
var cc_sub_type_array = [];
var cc_sub_type_array_str="";
var isValid=true;
var table = document.getElementById("table_cc"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      
                      cc_sub_type_array.push($("#cctypeid_"+i).val());
                      cc_sub_type_array_str=cc_sub_type_array.join(",");
                      
                      	//var stock =$("#stock_"+i).val();
                      
                        $("#ccid_"+i).equalCheck("none","Select CC Type");
                       if($("#ccid_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       
                       //$("#cctypeid_"+i).require();                       
                       //$("#cctypeid_"+i).equalCheck("0","Select Sub Type");
                       //if(($("#cctypeid_"+i).val()=="0")||($("#cctypeid_"+i).val()=="")){
						//	alert("adnan");return;
                        //isValid=false;
                       //}
                       }
                       
                       
                  //     cc_sub_type_array.shift();
                    //   alert(cc_sub_type_array.length);
                       
                       $('select[name^="cctype"]').distinct("A C/C Subtype is repeated.");
                       
				        var a = 0;
				    	while (a < cc_sub_type_array.length)
				        if (typeof cc_sub_type_array[a] ==="undefined")
				            cc_sub_type_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(cc_sub_type_array);
                      console.log(cc_sub_type_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      /* if(cc_sub_type_array.length>1){
					   var isUnique=checkIfArrayIsUnique(cc_sub_type_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate C/C Subtype Selection..!!!");
                       }
                       } */
                       


return isValid;                      
}

function addRow(element) {

	var valid=validationCC();
if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountc").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
  //  document.getElementById("rowcountc").value = lastRow + 1;
    document.getElementById("rowcountc").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "ccid_" + (rowid + 1);
    el.name = "ccname";
	//el.class = "removecc";

    try {
        el.addEventListener('change', function () {
            fetchItem(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchItem(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='cctypecol_" + (rowid + 1) + "' align='left' style='width:100px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='comments'  id='com_" + (rowid + 1) + "' align='center' style='width:100px;'/>";
   // a = "<input type='text' name='comments' class='remove' id='com_" + (rowid + 1) + "' align='center' style='width:100px;'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(3);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadCC(rowid + 1);


    return false;
}
}


function loadCC(rowcount) {
    var k = 1;
    var ind = document.getElementById("ccid_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");

    <s:iterator  value="strList">
    ind.options[k] = new Option("<s:property value="ccname"/>", <s:property value="ccid" />);
    k = k + 1;
    </s:iterator>


}

function removerow(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountc").value) || 1;
        document.getElementById("rowcountc").value = rowid - 1;
	//	functionSuffleCC();
        
        return false;
    }
    catch (e) {
        alert(e);
    }
}

var functionSuffleCC =function(){
	arr = $('#table_cc .remove').map(function(){ /// to catch existing textbox id
	return this.id;
	});


for(i=0; i < arr.length; i++)
{

 $("#"+arr[i]).attr("id","com_"+(i+1)); // set new  id
 

}

alert(i);
counter=i+1;

	 
	 };
/* function removerowoe(element){

   var row_id = parseInt(document.getElementById("rowcountc").value) || 1;
   alert(row_id);
   
   var priority=$("#ccid_"+row_id).val();
	
   var $rows = $("#table_cc tr").each(function(index) {
		 
		 if(index>0 && isInteger($("#ccid_"+index).val())){
			 
			 if($("#ccid_"+index).val()>priority)
			    $("#ccid_"+index).val($("#ccid_"+index).val()-1);
		 }
	});
	
	$("table#table_cc tr#ccid_"+row_id).remove();
	
	//orderSerialAndCorrectHtmlElementNames(from_where);
	
} */


 //OE



function validationOE() {
var oe_array = [];
var oe_array_str="";
var oe_array_others_array = [];
var oe_array_others_array_str="";
var isValid=true;
var table = document.getElementById("tableoe"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      if($("#oeid_"+i).val()!="50")
                      {
                      oe_array.push($("#oeid_"+i).val());
                      oe_array_str=oe_array.join(",");
                      }
                      
                     else if($("#oeid_"+i).val()=="50")
                      {
                      oe_array_others_array.push($("#oecom_"+i).val());
                      oe_array_others_array_str=oe_array_others_array.join(",");
                      
                      $("#oecom_"+i).require();
                       
                      if($("#oecom_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                      
                      
                      }

                      
                        $("#oeid_"+i).equalCheck("none","Select an O/E");
                       if($("#oeid_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       
                       

             //          $('select[name^="dname"]').distinct("A Clinical Diagnosis is repeated.");
                       
				        var a = 0;
				    	while (a < oe_array.length)
				        if (typeof oe_array[a] ==="undefined")
				            oe_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(oe_array);
                      console.log(oe_array_str);
                
                      
                      
                      if(oe_array.length>1){
					   var isUnique=checkIfArrayIsUnique(oe_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate O/E Selection..!!!");
                       }
                       }
                       
                       
                       ///////////////////////////////////////////
                       
                       
                       var a = 0;
				       while (a < oe_array_others_array.length)
				       if (typeof oe_array_others_array[a] ==="undefined")
				       oe_array_others_array.splice(a,1);
				       else
				       a++;
                       
                       console.log(oe_array_others_array);
                       console.log(oe_array_others_array_str);
                
                      
                      
                      if(oe_array_others_array.length>1){
					   var isUnique=checkIfArrayIsUnique(oe_array_others_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate O/E Selection..!!!");
                       }
                       }
                       


return isValid;                      
}
   
    ///////////////////
/*     function fetchItemOE(rowid, id) {

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("oetypecol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
    var url = "GetOeType.action?id=" + id + "&index=" + rowid;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
} */
/* function addRowD(element) {

	var valid=validationDiagnosis();
	if(valid==true){

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountd").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountd").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "did_" + (rowid + 1);
    el.name = "dname";


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<input type='text' name='dcomments' id='dcom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadD(rowid + 1);

}
    return false;
} */
function addRowOE(element) {
	var valid=validationOE();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountoe").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "oeid_" + (rowid + 1);
    el.name = "oename";


/*     try {
        el.addEventListener('change', function () {
            fetchItemOE(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchItemOE(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }


    newCell.appendChild(el); 

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='oetypecol_" + (rowid + 1) + "' align='left' style='width:100px;'>	</div>";
    newCell.innerHTML = a; */

	newCell.appendChild(el); 
    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<input type='text' name='oecomments' id='oecom_" + (rowid + 1) + "' align='center' style='width:200px;'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadOE(rowid + 1);

}
    return false;
}




function loadOE(rowcountoe) {
     var k = 1;
    var ind = document.getElementById("oeid_" + rowcountoe);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");

    <s:iterator  value="oeList">
    ind.options[k] = new Option("<s:property value="oename"/>", <s:property value="oeid" />);
    k = k + 1;
    </s:iterator>

}

 function removerowoe(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;
        document.getElementById("rowcountoe").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
    
    ////////////////////
}
/*
function validationOE() {
var oe_array = [];
var oe_array_str="";
var oe_type_array = [];
var oe_type_array_str="";
var isValid=true;
var table = document.getElementById("tableoe"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      if($("#oeid_"+i).val()!="50"){
                      oe_array.push($("#oeid_"+i).val());
                      oe_array_str=oe_array.join(",");
                      }
                      
                      else if($("#oeid_"+i).val()=="50"){
                      oe_type_array.push($("#oetypeid_"+i).val());
                      oe_type_array_str=oe_type_array.join(",");
                      }
                      
                      	//var stock =$("#stock_"+i).val();
                      
                       $("#oeid_"+i).equalCheck("none","Select a O/E Type");
                       if($("#oeid_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                      
					   $("#oetypeid_"+i).require();
                       $("#oetypeid_"+i).equalCheck("0","Select O/E Sub Type");
                       if($("#oetypeid_"+i).val()=="0" || $("#oetypeid_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       }
                       
                       
                    //   cc_sub_type_array.shift();
                    //   alert(cc_sub_type_array.length);
                       
                   //    $('select[name^="oename"]').distinct("An O/E is repeated.");
                       
				        var a = 0;
				    	while (a < oe_array.length)
				        if (typeof oe_array[a] ==="undefined")
				            oe_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(oe_array);
                      console.log(oe_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      if(oe_array.length>1){
					   var isUnique=checkIfArrayIsUnique(oe_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate O/E Selection..!!!");
                       }
                       }
                       
                  /////////////////////////////////////////////////////////////     
                       
                        var a = 0;
				    	while (a < oe_type_array.length)
				        if (typeof oe_type_array[a] ==="undefined")
				            oe_type_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(oe_type_array);
                      console.log(oe_type_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      if(oe_type_array.length>1){
					   var isUnique=checkIfArrayIsUnique(oe_type_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate O/E Selection..!!!");
                       }
                       }
                       


return isValid;                      
}


function fetchItemOE(rowid, id) {

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("oetypecol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
    var url = "GetOeType.action?id=" + id + "&index=" + rowid;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function addRowOE(element) {
	var valid=validationOE();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountoe").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "oeid_" + (rowid + 1);
    el.name = "oename";


    try {
        el.addEventListener('change', function () {
            fetchItemOE(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchItemOE(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='oetypecol_" + (rowid + 1) + "' align='left' style='width:100px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='oecomments' id='oecom_" + (rowid + 1) + "' align='center' style='width:100px;'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(3);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadOE(rowid + 1);

}
    return false;
}


function loadOE(rowcountoe) {
     var k = 1;
    var ind = document.getElementById("oeid_" + rowcountoe);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");

    <s:iterator  value="oeList">
    ind.options[k] = new Option("<s:property value="oename"/>", <s:property value="oeid" />);
    k = k + 1;
    </s:iterator>

}

 function removerowoe(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;
        document.getElementById("rowcountoe").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}  */


/* function addRowOE(element) {

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountoe").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "oeid_" + (rowid + 1);
    el.name = "oename";


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<input type='text' style='width:250px;' name='oecomments' id='oecom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowoe(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadOE(rowid + 1);


    return false;
}


function loadOE(rowcountoe) {
    var k = 1;
    var ind = document.getElementById("oeid_" + rowcountoe);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

    <s:iterator  value="oeList">
    ind.options[k] = new Option("<s:property value="oename"/>", <s:property value="oeid" />);
    k = k + 1;
    </s:iterator>


}


function removerowoe(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountoe").value) || 1;
        document.getElementById("rowcountoe").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}
 */
//pae

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


//adv

function validationADV() {
var isValid=true;
var table = document.getElementById("tableadv"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
  
                       $("#advcom_"+i).require();
                       if($("#advcom_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       

return isValid;                      
}

function addRowAdv(element) {
	var valid=validationADV();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountadv").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountadv").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "center";
    a = "<input type='text' style='width:350px;' name='advcomments' id='advcom_" + (rowid + 1) + "' align='center' />";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowadv(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;

}
    return false;
}


function removerowadv(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountadv").value) || 1;
        document.getElementById("rowcountadv").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}






//Rx
function validationMed() {
var medicine_array = [];
var medicine_array_str="";
var isValid=true;
var table = document.getElementById("tablefd"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      
                      medicine_array.push($("#drugid_"+i).val());
                      medicine_array_str=medicine_array.join(",");
                      
                      	//var stock =$("#stock_"+i).val();
                      
                        $("#gen_"+i).equalCheck("none","Select Medicine Group");
                       if($("#gen_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       
                       $("#drugid_"+i).equalCheck("0","Select a Medicine");
                       if($("#drugid_"+i).val()=="0"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       
                       		$("#qty_"+i)
	                        .require()
	                        .match("integer");
	                        
	                        if($("#qty_"+i).val()=="")
	                        {
	                        isValid=false;
	                        }
                           
                           $("#tqty_"+i)
	                        .require()
	                        .match("integer");
	                        
	                        if($("#tqty_"+i).val()==""||$("#tqty_"+i).val()>$("#qty_"+i).val())
	                        {
	                        isValid=false;
	                        }
                       
/*                          $("#dose_"+i).require();
	                    	                        
 						 	if($("#dose_"+i).val()=="")
	                        {
	                        isValid=false;
	                        } 
	                         */
	                        
	                        $("#when_"+i).equalCheck("none","Select Medicine Taking Time");
	                        if($("#when_"+i).val()=="none")
                       		{
                        	isValid=false;
                       		}
	                        
/* 	                        $("#days_"+i).require();
	                        if($("#days_"+i).val()=="")
	                        {
	                        isValid=false;
	                        } */
                       
                       		
                       
                       
                       }
                       
                       
                  //     cc_sub_type_array.shift();
                    //   alert(cc_sub_type_array.length);
                       
                       $('select[name^="drugname"]').distinct("A Medicine is repeated.");
                       
				        var a = 0;
				    	while (a < medicine_array.length)
				        if (typeof medicine_array[a] ==="undefined")
				            medicine_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(medicine_array);
                      console.log(medicine_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      if(medicine_array.length>1){
					   var isUnique=checkIfArrayIsUnique(medicine_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate Medicine Selection..!!!");
                       }
                       }
                       


return isValid;                      
}
// medicine outside validation
function validationMedOutside() {
var medicine_array = [];
var medicine_array_str="";
var isValid=true;
var table = document.getElementById("tablefdout"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      
                      medicine_array.push($("#drugid_out_"+i).val());
                      medicine_array_str=medicine_array.join(",");
                      
                      	//var stock =$("#stock_"+i).val();
                      
                        /* $("#gen_out_"+i).equalCheck("none","Select Medicine Group");
                       if($("#gen_out_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       } */
                       
                       $("#drugid_out_"+i).equalCheck("0","Select a Medicine");
                       if($("#drugid_out_"+i).val()=="0"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       
                       		$("#qty_out_"+i)
	                        .require()
	                        .match("integer");
	                        
	                        if($("#qty_out_"+i).val()=="")
	                        {
	                        isValid=false;
	                        }
                           
                           /* $("#tqty_out_"+i)
	                        .require()
	                        .match("integer");
	                        
	                        if($("#tqty_out_"+i).val()==""||$("#tqty_out_"+i).val()>$("#qty_out_"+i).val())
	                        {
	                        isValid=false;
	                        } */
                       
/*                          $("#dose_"+i).require();
	                    	                        
 						 	if($("#dose_"+i).val()=="")
	                        {
	                        isValid=false;
	                        } 
	                         */
	                        
	                        $("#when_out_"+i).equalCheck("none","Select Medicine Taking Time");
	                        if($("#when_out_"+i).val()=="none")
                       		{
                        	isValid=false;
                       		}
	                        
/* 	                        $("#days_"+i).require();
	                        if($("#days_"+i).val()=="")
	                        {
	                        isValid=false;
	                        } */
                       
                       		
                       
                       
                       }
                       
                       
                  //     cc_sub_type_array.shift();
                    //   alert(cc_sub_type_array.length);
                       
                       $('select[name^="drugname"]').distinct("A Medicine is repeated.");
                       
				        var a = 0;
				    	while (a < medicine_array.length)
				        if (typeof medicine_array[a] ==="undefined")
				            medicine_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(medicine_array);
                      console.log(medicine_array_str);
                //      alert(cc_sub_type_array_str);
                      
                      
                      if(medicine_array.length>1){
					   var isUnique=checkIfArrayIsUnique(medicine_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate Medicine Selection..!!!");
                       }
                       }
                       


return isValid;                      
}







    function checkInput(ob) {
        var invalidChars = /[^0-9]/gi
        if(invalidChars.test(ob.value)) {
            ob.value = ob.value.replace(invalidChars,"");
        }
        
    }
    
   function isNumberKey(evt)
       {
          var charCode = (evt.which) ? evt.which : evt.keyCode;
          if (charCode != 46 && charCode > 31 && charCode != 48
            && (charCode < 49 || charCode > 57))
             return false;
			
          return true;
       }

function fetchMed(rowid, id) {
    //alert(id);
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("med_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
    var url = "GetMedList.action?id=" + id + "&index=" + rowid;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function addRowRx(element) {

	var valid=validationMed();
	if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountrx").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountrx").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "gen_" + (rowid + 1);
    el.name = "genname";


    try {
        el.addEventListener('change', function () {
            fetchMed(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchMed(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }


    newCell.appendChild(el);


    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='med_" + (rowid + 1) + "' align='left' style='width: 180px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='drgqty' id='qty_" + (rowid + 1) + "'  onkeypress='return isNumberKey(event)' onkeyup='myFunction("+rowid+")' align='center' size='5'/>";
    newCell.innerHTML = a;
    
    newCell = newRow.insertCell(3);
    newCell.align = "center";
    a = "<input type='text' name='tknqty' id='tqty_" + (rowid + 1) + "' onkeypress='return isNumberKey(event)' align='center' size='5'/>";
    newCell.innerHTML = a;
    
    newCell = newRow.insertCell(4);
    newCell.align = "center";
    a = "<input type='text' name='stock' id='stk_" + (rowid + 1) + "' readonly='readonly'  align='center' size='5'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(5);
    newCell.align = "center";
    a = "<input type='text' name='dose' id='dose_" + (rowid + 1) + "' style='font-size: 14px;width: 60px;' align='center' />";
    newCell.innerHTML = a;


    
 	/*newCell = newRow.insertCell(6);
    newCell.align = "center";
    a = "<select name='dose' id='dose_" + (rowid + 1) + "' style='font-size: 14px;width: 80px;'>" +
            "<option value=''>Please Select</option>" +
            "<option value='Times'>Times</option>" +
            "<option value='Hourly'>Hourly</option>" +
            "<option value='Daily'>Daily</option>" +
            "</select>";
    newCell.innerHTML = a;*/

	    newCell = newRow.insertCell(6);
    newCell.align = "center";
    a = "<select size='1' name='takingtime' id='when_" + (rowid + 1) + "' style='font-size: 14px;width:150px;'>" +
            "<option value='none'>Please Select</option>" +
            "<option value='  '>not required</option>" +
            "<option value='before Meal'>before Meal</option>" +
            "<option value='after meal'>after meal</option>" +            
            "<option value='Any time in a day'>Any time in a day</option>" +
            "</select>";
    newCell.innerHTML = a; 
    
    newCell = newRow.insertCell(7);
    newCell.align = "center";
    a = "<input type='text' name='days' id='days_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;


	newCell = newRow.insertCell(8);
    newCell.align = "center";
    a = "<input type='hidden' name='uprice' id='upr_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;

	newCell = newRow.insertCell(9);
    newCell.align = "center";
    a = "<input type='hidden' name='rxstatus' value='Not Taken' id='rxst_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;
	
    newCell = newRow.insertCell(10);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadGen(rowid + 1);


    return false;
}
}

function addRowRxOut(element) {
//alert(element);

	var valid=validationMedOutside();
	if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountrxout").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountrxout").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "gen_out_" + (rowid + 1);
    el.name = "gennameout";
    el.style="display: none";
   


    /* try {
        el.addEventListener('change', function () {
            fetchMed(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    }
    catch (e) {
        el.attachEvent('onchange', function () {
            fetchMed(rowid + 1, this.options[this.selectedIndex].value)
        }, false)
    } */


    newCell.appendChild(el);


   /*  newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<div id='med_out_" + (rowid + 1) + "' align='left' style='width: 180px;'>	</div>";
    newCell.innerHTML = a; */
    
    // write drug
    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<input type='text' name='drugnameout' id='drugid_out_" + (rowid + 1) + "' align='center' style='width:250px'/>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='drgqtyout' id='qty_out_" + (rowid + 1) + "'  onkeypress='return isNumberKey(event)' onkeyup='myFunction("+rowid+")' align='center' size='5'/>";
    newCell.innerHTML = a;
    
    newCell = newRow.insertCell(3);
    newCell.align = "center";
    a = "<input type='text' name='tknqtyout' id='tqty_out_" + (rowid + 1) + "' onkeypress='return isNumberKey(event)' align='center' size='5' style='display:none'/>";
    newCell.innerHTML = a;
    
    newCell = newRow.insertCell(4);
    newCell.align = "center";
    a = "<input type='text' name='stockout' id='stk_out_" + (rowid + 1) + "' readonly='readonly'  value='0' align='center' size='5' style='display:none'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(5);
    newCell.align = "center";
    a = "<input type='text' name='doseout' id='dose_out_" + (rowid + 1) + "' style='font-size: 14px;width: 100px;' align='center' />";
    newCell.innerHTML = a;


    
 	/*newCell = newRow.insertCell(6);
    newCell.align = "center";
    a = "<select name='dose' id='dose_" + (rowid + 1) + "' style='font-size: 14px;width: 80px;'>" +
            "<option value=''>Please Select</option>" +
            "<option value='Times'>Times</option>" +
            "<option value='Hourly'>Hourly</option>" +
            "<option value='Daily'>Daily</option>" +
            "</select>";
    newCell.innerHTML = a;*/

	    newCell = newRow.insertCell(6);
    newCell.align = "center";
    a = "<select size='1' name='takingtimeout' id='when_out_" + (rowid + 1) + "' style='font-size: 14px;width:150px;'>" +
            "<option value='none'>Please Select</option>" +
            "<option value='  '>not required</option>" +
            "<option value='before Meal'>before Meal</option>" +
            "<option value='after meal'>after meal</option>" +            
            "<option value='Any time in a day'>Any time in a day</option>" +
            "</select>";
    newCell.innerHTML = a; 
    
    newCell = newRow.insertCell(7);
    newCell.align = "center";
    a = "<input type='text' name='daysout' id='days_out_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;


	newCell = newRow.insertCell(8);
    newCell.align = "center";
    a = "<input type='hidden' name='upriceout' id='upr_out_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;

	newCell = newRow.insertCell(9);
    newCell.align = "center";
    a = "<input type='hidden' name='rxstatusout' value='Not Taken' id='rxst_out_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;
	
    newCell = newRow.insertCell(10);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadGenOut(rowid + 1);


    return false;
}
}




function loadGen(rowcount) {
    var k = 1;
    var ind = document.getElementById("gen_" + rowcount);
    if (ind == null) return;
	
    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");
    
/*     var optGroup1  = document.createElement("OPTGROUP");
	optGroup1.label = "Test1";
	ind.appendChild(optGroup1);
	
	var optGroup2  = document.createElement("OPTGROUP");
	optGroup2.label = "Test2";
	ind.appendChild(optGroup2);  */
	for (var i =1; i<6 ; i++)
    {   
    var optGroup  = document.createElement("OPTGROUP");

   		
   	if(i==1)
   	{
   	optGroup.label = "Antibiotics";
	ind.appendChild(optGroup);
   	 <s:iterator  value="genericlistTablet">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }	
   
    else if(i==2)
    {  
    optGroup.label = "Alimentary System drug";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistCapsul">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }
    
    else if(i==3)
    {  
    optGroup.label = "Analgesics/NSAIDS";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistSyrap">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }
    
    else if(i==4)
    {  
    optGroup.label = "Respiratry System drugs";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistRespiratrySystemdrugs">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }
    
    else if(i==5)
    {  
    optGroup.label = "Others";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistOthers">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }
    
   
	}
	 
	

	
       
    
/*    for (var i = 1; i< ind.length ; i++)
    {   
   		                    
        optGroup.appendChild(ind[i]);       

    }  

    ind.selectedIndex = ind.options.length - 1; */

}


function loadGenOut(rowcount) {
    var k = 1;
    var ind = document.getElementById("gen_out_" + rowcount);
    if (ind == null) return;
	
    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");
    
/*     var optGroup1  = document.createElement("OPTGROUP");
	optGroup1.label = "Test1";
	ind.appendChild(optGroup1);
	
	var optGroup2  = document.createElement("OPTGROUP");
	optGroup2.label = "Test2";
	ind.appendChild(optGroup2);  */
	for (var i =1; i<4 ; i++)
    {   
    var optGroup  = document.createElement("OPTGROUP");

   		
   	if(i==1)
   	{
   	optGroup.label = "Tablet";
	ind.appendChild(optGroup);
   	 <s:iterator  value="genericlistTablet">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }	
   
    else if(i==2)
    {  
    optGroup.label = "Capsul";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistCapsul">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }
    
    else if(i==3)
    {  
    optGroup.label = "Syrap";
	ind.appendChild(optGroup);  
    <s:iterator  value="genericlistSyrap">     
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>
    }


	}
	 
	

	
       
    
/*    for (var i = 1; i< ind.length ; i++)
    {   
   		                    
        optGroup.appendChild(ind[i]);       

    }  

    ind.selectedIndex = ind.options.length - 1; */

}

	
		
function fetchTwoRx(rowid)
		{			
		var medid = $("#drugid_"+rowid).val();		
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		     //document.getElementById("itemcol_"+rowid).innerHTML=xmlhttp.responseText;
		     
		     var str = xmlhttp.responseText;
		     var fields = str.split('@');
			 var stock = fields[0];
			 var unitprice = fields[1];
			// alert (unitprice);
			 
			 $("#stk_"+rowid).val(fields[0]);
		     $("#upr_"+rowid).val(fields[1]);
		   
		     
		     		     
		    }
		  }
		   //var url="GetThreeItem.action?medid="+medid+"&rowid="+rowid;
		    var url="GetStock.action?medid="+medid+"&rowid="+rowid;
		   xmlhttp.open("GET",url,true);
		   xmlhttp.send();
		}
		
function myFunction(rowid) {

var medid = $("#drugid_"+rowid).val();	
    var count = rowid + 1;
    var x = document.getElementById("qty_"+count).value;
    $("#tqty_"+count).val(x); 
    //var y = document.getElementById("stk_"+count).value;
    /*if(x<y)
    	{	
    	$("#tqty_"+count).val(x); 	
    	
    	}
    else{
    	alert("Error");   	
    	x=0;
    	 }   
    */
}
function removerowrx(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountrx").value) || 1;
        document.getElementById("rowcountrx").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}
//Dia

function validationDiagnosis() {
var clinical_diagnosis_array = [];
var clinical_diagnosis_array_str="";
var clinical_diagnosis_others_array = [];
var clinical_diagnosis_others_array_str="";
var isValid=true;
var table = document.getElementById("tabled"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
                      
                      if($("#did_"+i).val()!="50")
                      {
                      clinical_diagnosis_array.push($("#did_"+i).val());
                      clinical_diagnosis_array_str=clinical_diagnosis_array.join(",");
                      }
                      
                     else if($("#did_"+i).val()=="50")
                      {
                      clinical_diagnosis_others_array.push($("#dcom_"+i).val());
                      clinical_diagnosis_others_array_str=clinical_diagnosis_others_array.join(",");
                      
                      $("#dcom_"+i).require();
                       
                      if($("#dcom_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                      
                      
                      }
                      	//var stock =$("#stock_"+i).val();
                      
                        $("#did_"+i).equalCheck("none","Select a Clinical Diagnosis");
                       if($("#did_"+i).val()=="none"){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       
                       

             //          $('select[name^="dname"]').distinct("A Clinical Diagnosis is repeated.");
                       
				        var a = 0;
				    	while (a < clinical_diagnosis_array.length)
				        if (typeof clinical_diagnosis_array[a] ==="undefined")
				            clinical_diagnosis_array.splice(a,1);
				        else
				        a++;
                       
                      console.log(clinical_diagnosis_array);
                      console.log(clinical_diagnosis_array_str);
                
                      
                      
                      if(clinical_diagnosis_array.length>1){
					   var isUnique=checkIfArrayIsUnique(clinical_diagnosis_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate Clinical Diagnosis Selection..!!!");
                       }
                       }
                       
                       
                       ///////////////////////////////////////////
                       
                       
                       var a = 0;
				       while (a < clinical_diagnosis_others_array.length)
				       if (typeof clinical_diagnosis_others_array[a] ==="undefined")
				       clinical_diagnosis_others_array.splice(a,1);
				       else
				       a++;
                       
                       console.log(clinical_diagnosis_others_array);
                       console.log(clinical_diagnosis_others_array_str);
                
                      
                      
                      if(clinical_diagnosis_others_array.length>1){
					   var isUnique=checkIfArrayIsUnique(clinical_diagnosis_others_array);
                       if(isUnique==false){
                       
                       isValid=false;
                       alert("Duplicate Clinical Diagnosis Selection..!!!");
                       }
                       }
                       


return isValid;                      
}
function addRowD(element) {

	var valid=validationDiagnosis();
	if(valid==true){

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountd").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountd").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "did_" + (rowid + 1);
    el.name = "dname";


    newCell.appendChild(el);

    newCell = newRow.insertCell(1);
    newCell.align = "center";
    a = "<input type='text' name='dcomments' id='dcom_" + (rowid + 1) + "' align='center' size='25'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadD(rowid + 1);

}
    return false;
}


function loadD(rowcountd) {
    var k = 1;
    var ind = document.getElementById("did_" + rowcountd);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "none");

    <s:iterator  value="dlist">
    ind.options[k] = new Option("<s:property value="dname"/>", <s:property value="did" />);
    k = k + 1;
    </s:iterator>


}


function removerowd(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountd").value) || 1;
        document.getElementById("rowcountd").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}

//inv
function validationTest() {
var test_sub_type_array = [];
var test_sub_type_array_str="";
var isValid=true;
var table = document.getElementById("tabletest"); 
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
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("testypecol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
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
    a = "<div id='testypecol_" + (rowid + 1) + "' align='left' style='width:150px;'>	</div>";
    newCell.innerHTML = a;    
    
    
    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' name='tstcomm' id='tstcom_" + (rowid + 1) + "' align='center' size='15' style='width:50px;'/>";
    newCell.innerHTML = a;
    
	newCell = newRow.insertCell(3);
    newCell.align = "center";
    a = "<input type='hidden' name='tstprice' id='tstpr_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;


	newCell = newRow.insertCell(4);
    newCell.align = "center";
    a = "<input type='hidden' name='tstvat' id='tstvt_" + (rowid + 1) + "' />";
    newCell.innerHTML = a;
    
    newCell = newRow.insertCell(5);
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
    ind.options[k] = new Option("<s:property value="testypename"/>", "<s:property value="testypeid" />");
    k = k + 1;
    </s:iterator>
}



function fetchTstPrVt(rowid)
		{			
		var tstp = $("#testype_"+rowid).val();	
		var tsid = $("#testid_"+rowid).val();	
			
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		     //document.getElementById("itemcol_"+rowid).innerHTML=xmlhttp.responseText;
		     
		     var str = xmlhttp.responseText;
		     var fields = str.split('@');
			 //var price = fields[0];
			 //var vat = fields[1];
			
			 $("#tstpr_"+rowid).val(fields[0]);
		     $("#tstvt_"+rowid).val(fields[1]);
		   
		     
		     		     
		    }
		  }
		   //var url="GetThreeItem.action?medid="+medid+"&rowid="+rowid;
		    var url="GetTstPriceVat.action?tsid="+tsid+"&tstp="+tstp+"&rowid="+rowid;
		   xmlhttp.open("GET",url,true);
		   xmlhttp.send();
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



//medicine Out Side

function validationMedOut() {
var isValid=true;
var table = document.getElementById("tablemedout"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
  
                       $("#medout_"+i).require();
                       if($("#medout_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       

return isValid;                      
}

function addRowMedout(element) {
	var valid=validationMedOutside();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountmedout").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountmedout").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "center";
    a = "<input type='text' style='width:350px;' name='medOutSide' id='medout_" + (rowid + 1) + "' align='center' />";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowMedout(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;

}
    return false;
}


function removerowMedout(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcountmedout").value) || 1;
        document.getElementById("rowcountmedout").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}



//Test Out Side

function validationTestOut() {
var isValid=true;
var table = document.getElementById("tabletestout"); 
//alert(table.rows.length);

                      for(var i = 1; i < table.rows.length+100; i++) 
                      { 
  
                       $("#testout_"+i).require();
                       if($("#testout_"+i).val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
                       

                       }
                       

return isValid;                      
}

function validationWeight() {
var isValid=true;

                       $("#weight").require();
                       if($("#weight").val()==""){
						//	alert("adnan");return;
                        isValid=false;
                       }
return isValid;                      
}



function addRowTestout(element) {
	var valid=validationTestOut();
    if(valid==true){
    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcounttestout").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcounttestout").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "center";
    a = "<input type='text' style='width:350px;' name='testOutSide' id='testout_" + (rowid + 1) + "' align='center' />";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowTestout(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;

}
    return false;
}


function removerowTestout(element) {
    try {


        var r = element.parentNode.parentNode;
        var index = r.sectionRowIndex;
        var table2 = r.parentNode;
        table2.deleteRow(index);

        var rowid = parseInt(document.getElementById("rowcounttestout").value) || 1;
        document.getElementById("rowcounttestout").value = rowid - 1;

        return false;
    }
    catch (e) {
        alert(e);
    }
}





</script>

<!-- for preview prescription start DIV-->

<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content" style="background-color: white; background: white;">
    <span class="close">&times;</span>
    <div style="background-color: white; background: white;">
    <center><b>Prescription Preview</b></center>
    
    <center>Prescription of:<s:property value="name"></s:property> (<s:property value="patientid"></s:property>)</center>
    </br>
					<table  width="100%" border="0" cellpadding="0" cellspacing="0" valign="top">
					
					<tr>
					<td><b>C/C:</b> <label id="prv_cc"></label></td>
					
					<td><b>Rx:</b> <label id="prv_rx"></label></td>
					</tr>
					
					<tr>
					<td><b>O/E:</b> <label id="prv_oe"></label></td>				
					
										
					</tr>
					
					<tr>
					<td><b>Diagonosis:</b> <label id="prv_diagonosis"></label></td>
					
					<td><b>Rx Out:</b> <label id="prv_rxout"></label></td>				
					
										
					</tr>
					
					<tr>
					<td><b>P/A/E:</b> <label id="prv_pae"></label></td>				
					
					<td><b>Advice to be followed:</b> <label id="prv_advice"></label></td>
					</tr>
					
					<tr>
					<td><b>Investigation:</b> <label id="prv_investigation"></label></td>				
					
					<td><b>weight:</b> <label id="prv_weight"></label></td>				
					</tr>
					
					</table>
    
    
    </div>
    
  </div>

</div>

<!-- for preview prescription end DIV-->





				<form action="savecc"  name="prescriptionSaveForm" id="prescriptionSaveForm" method="post">
					<s:hidden id="pid" name="patientid" value="%{patientid}"> </s:hidden>
					<s:hidden id="vid" name="visitid" value="%{visitid}"> </s:hidden>
					<center><h3>Prescription of:<s:property value="name"></s:property> (<s:property value="patientid"></s:property>)</h3></center>
					</br>
					<table  width="100%" border="0" cellpadding="0" cellspacing="0" valign="top">
						<tr>
							<td style="width:49%;" valign="top" >				
							<table style="width:100%" class="data" align="center" id="table_cc" border="0" cellpadding="0" cellspacing="0">
							
							    <thead>
							    <tr>
							        <th colspan="4"><big>C/C</big></th>
							
							    </tr>
							    <tr>
							        <th class="bottomHeader" width="30"> Chief Complains</th>
							        <th class="bottomHeader" width="25"></th>
							        <th class="bottomHeader" width="30">Duration</th>
							        <th class="bottomHeader" width="20"></th>
							    </tr>
							    </thead>
							    <tbody>
							    <tr><input type="hidden" id="rowcountc" name="rowcountc"  value="1"/></tr>	    
							    <tr>		        
							        <td colspan="4" align="center">
							            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRow(this);setTimeout(scrolltoBottom, 10);">Add More</a>
							        </td>
							    </tr>
							    </tbody>
							</table>
							</td>	
							<td style="width:2%"></td>
							<td style="width:49%;" valign="top">
							<table style="width:100%;" class="data" align="center" id="tabled" border="0" cellpadding="0" cellspacing="0">
						        <thead>
						        <tr>
						            <th colspan="3"><big>Clinical Diagonosis</big></th>
						
						        </tr>
						        <tr>
						            <th class="bottomHeader" width="35">Type</th>
						            <th class="bottomHeader" width="45">Comments</th>
						            <th class="bottomHeader" width="20"></th>
						        </tr>
						        </thead>
					
						        <tbody>
						        <tr><input type="hidden" id="rowcountd" name="rowcountd" value="1"/></tr>	        
						        <tr>	
						            <td colspan="3" align="center">
						                <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowD(this);setTimeout(scrolltoBottom, 10);">Add More</a>
						            </td>
						        </tr>
						        </tbody>
					    	</table>		
							</td>
						</tr>
						<tr>
							<td style="width:49%;" valign="top">
							<table style="width:100%;" class="data" align="center" id="tableoe" border="0" cellpadding="0" cellspacing="0">
						    	<thead>
						   		   	<tr>
						        	  	<th colspan="3"><big>O/E</big></th>	
						    		</tr>
						    		<tr>
						        		 <th class="bottomHeader" width="30" >O/E Name</th>						        		 
							             <th class="bottomHeader" width="50">Findings</th>
							             <th class="bottomHeader" width="20"></th>
						        		
						    		</tr>
						    	</thead>
						    	<tbody>
						    		<tr><input type="hidden" id="rowcountoe" name="rowcountoe" value="1"/></tr>	   
						    		<tr>
						        		<td colspan="4" align="center">
						            	<a class="addMore" href="javascript:void(0);" onclick="javascript:addRowOE(this);setTimeout(scrolltoBottom, 10);">Add More</a>
						        		</td>
						    		</tr>
						    	</tbody>
							</table>
							</td>
							<td style="width:2%;"></td>
							<td style="width:49%;" valign="top">
							<table style="width:100%;" class="data" align="center" id="tabletest" border="0" cellpadding="0" cellspacing="0">
						        <thead>
						        <thead>
						        <tr>
						            <th colspan="6"><big>Investigations</big></th>
						        </tr>
						        </thead>
						        <tr>
						            <th class="bottomHeader" width="20">Test Type</th>
						            <th class="bottomHeader" width="20">Test Name</th>
						            <th class="bottomHeader" width="30"></th>
						            <th class="bottomHeader" width="30" colspan="2"></th>
						            <th class="bottomHeader" width="15"></th>
						        </tr>
						        </thead>
						
						        <tbody>
						        <tr><input type="hidden" id="rowcountinv" name="rowcountinv" value="1"/></tr>
						
						        <tr>
						
						            <td colspan="6" align="center">
						                <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowinv(this);setTimeout(scrolltoBottom, 10);">Add More</a>
						            </td>
						        </tr>
						
						
						        </tbody>
						
						
						    </table>
							</td>
						</tr>
						<tr>
							<td style="width:49%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tablepae" border="0" cellpadding="0" cellspacing="0">
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
							</td>
							<td style="width:2%;"></td>
							
							<!-- dummy -->
							<td style="width:49%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tableadv" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th class="bottomHeader" colspan="2"><big>Advice to be followed</big></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr><input type="hidden" id="rowcountadv" name="rowcountadv" value="1"/></tr>
								    <tr>
								        <td colspan="2" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowAdv(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr>
								    </tbody>
								</table>
							</td>
							<!-- dummy end -->
						</tr>
						<tr>
							<td colspan="3" style="width:100%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tablefd" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th colspan="11"><big>Rx</big></th>
								    </tr>
								    <tr>
								        <th  class="bottomHeader" width="30" > Medicine Group</th>
								        <th  class="bottomHeader" width="40"> Medicine Name</th>
								        <th  class="bottomHeader" width="5" > Given Quantity</th>
								        <th  class="bottomHeader" width="5" > Taken Quantity</th>
								        <th  class="bottomHeader" width="5" > Stock</th>
								        <th  class="bottomHeader" width="15" > Dosages</th>
								        <th  class="bottomHeader" width="25" > Time</th>
								        <th  class="bottomHeader" width="15" > Days</th>
								         
								        <th  class="bottomHeader" width="10" colspan="5"></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr><input type="hidden" id="rowcountrx" name="rowcountrx" value="1"/></tr> 
								    <tr>
								        <td colspan="11" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowRx(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr>
								    </tbody>
								</table>
							</td>
						</tr>
						
						
						<!-- outside medicine start -->
						
						<tr>
							<td colspan="3" style="width:100%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tablefdout" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th colspan="11"><big>Outside Medicine</big></th>
								    </tr>
								    <tr>
								        <th  class="bottomHeader" width="30" style="display:"></th>
								        <th  class="bottomHeader" width="40"> Medicine Name</th>
								        <th  class="bottomHeader" width="5" > Given Quantity</th>
								        <th  class="bottomHeader" width="5" ></th>
								        <th  class="bottomHeader" width="5" ></th>
								        <th  class="bottomHeader" width="15" > Dosages</th>
								        <th  class="bottomHeader" width="25" > Time</th>
								        <th  class="bottomHeader" width="15" > Days</th>
								         
								        <th  class="bottomHeader" width="10" colspan="5"></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr><input type="hidden" id="rowcountrxout" name="rowcountrxout" value="1"/></tr> 
								    <tr>
								        <td colspan="11" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowRxOut(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr>
								    </tbody>
								</table>
							</td>
						</tr>
						
						<!-- outside medicine end -->
						
						
	<!-- out side store -->
						
						<tr>
							<td style="width:49%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tableweight" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th class="bottomHeader"><big>Pateint Weight Entry</big></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr>
								    <td align="center">
								    <input type="text" id="weight" name="weight" value=""/>
								    </td>
								    </tr>
								    <!-- <tr>
								        <td colspan="2" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowMedout(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr> -->
								    </tbody>
								</table>
							</td>
							<td style="width:2%;"></td>
							
							<!-- dummy -->
							<td style="width:49%;" valign="top">
								<table style="width:100%;" class="data" align="center" id="tabletestout" border="0" cellpadding="0" cellspacing="0">
								    <thead>
								    <tr>
								        <th class="bottomHeader" colspan="2"><big>Out Side Test</big></th>
								    </tr>
								    </thead>
								    <tbody>
								    <tr><input type="hidden" id="rowcounttestout" name="rowcounttestout" value="1"/></tr>
								    <tr>
								        <td colspan="2" align="center">
								            <a class="addMore" href="javascript:void(0);" onclick="javascript:addRowTestout(this);setTimeout(scrolltoBottom, 10);">Add More</a>
								        </td>
								    </tr>
								    </tbody>
								</table>
							</td>
							<!-- dummy end -->
						</tr>
						
			<!-- out side store -->
						
						
						<tr>
							<td colspan="3">
							
							<!-- <input type="submit" value="Save" /> -->
<button  onclick="ConfirmFormSubmit()"  class="myButton" style="width: 160px;" type="button">Save Prescription</button>
<!-- <button  onclick="preview()" id="myBtn" class="myButton" style="width: 140px;" type="button">Preview</button> -->							
							
							</td>
						</tr>
					</table>
				</form>
				
				

				
				
				
				
<script type="text/javascript">	


function preview(){
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
    document.getElementById("prv_weight").innerHTML=document.getElementById("weight").value;
    
    // for CC --------------------------------
    var ccarray = [];
    var cc1="";
    var cc2="";
    var cc3="";
    var i;
    for ( i=0 ; i < 100; i++) {     
    var c1 = document.getElementById("ccid_"+i);        
    var c2 = document.getElementById("cctypeid_"+i); 
    var c3 = document.getElementById("com_"+i);
    if(c1==null){
    continue;
    } 
    
    if(c2==null){
    cc1= c1.options[c1.selectedIndex].text;
    cc3= c3.value;  
    ccarray.push(cc1+"-"+cc3+" ");  
    } 
    else{
    cc1= c1.options[c1.selectedIndex].text;
    cc2= c2.value;
    cc3= c3.value;
    ccarray.push(cc1+"-"+cc2+"-"+cc3+" ");
    }     
     
     //alert(cc);	 
	 //alert(ccarray); 
	}
	document.getElementById("prv_cc").innerHTML = ccarray;
	
	
	// for OE --------------------------------
    var oearray = [];
    var oe1="";
    var oe2="";
    var i;
    for ( i=0 ; i < 100; i++) {     
    var o1 = document.getElementById("oeid_"+i); 
    var o2 = document.getElementById("oecom_"+i);   
    if(o1==null){
    continue;
    }    
    oe1= o1.options[o1.selectedIndex].text;
    oe2= o2.value;
     //alert(cc);
	 oearray.push(oe1+"-"+oe2+" ");
	 //alert(ccarray); 
	}
	document.getElementById("prv_oe").innerHTML = oearray;
	
	
	// for Clinical Diagonosis --------------------------------
	
	var cdarray = [];
    var cd1="";
    var cd2="";
    var i;
    for ( i=0 ; i < 100; i++) {     
    var d1 = document.getElementById("did_"+i); 
    var d2 = document.getElementById("dcom_"+i);   
    if(d1==null){
    continue;
    }    
    cd1= d1.options[d1.selectedIndex].text;
    cd2= d2.value;
     //alert(cc);
	 cdarray.push(cd1+"-"+cd2+" ");
	 //alert(ccarray); 
	}
	document.getElementById("prv_diagonosis").innerHTML = cdarray;
	
	
	
	
	
	// for Rx Medicine --------------------------------
	
	var rxarray = [];
    var rx1="";
    var rx2="";
    var rx3="";
    var rx4="";
    var rx5="";
    var rx6="";
    
    var i;
    for ( i=0 ; i < 100; i++) {     
    var r1 = document.getElementById("did_"+i); 
    var d2 = document.getElementById("dcom_"+i);
    var d1 = document.getElementById("did_"+i);
    var d1 = document.getElementById("did_"+i);
    var d1 = document.getElementById("did_"+i);
    var d1 = document.getElementById("did_"+i);  
    if(d1==null){
    continue;
    }    
    cd1= d1.options[d1.selectedIndex].text;
    cd2= d2.value;
     //alert(cc);
	 cdarray.push(cd1+"-"+cd2+" ");
	 //alert(ccarray); 
	}
	document.getElementById("prv_diagonosis").innerHTML = cdarray;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
   }
    
   // When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
} 
    
}






  
   function ConfirmFormSubmit()
    {
      var x = confirm("Are you sure you want to save Prescription..?");
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
      var validCC=validationCC();
      	if(validCC==false){
      	alert("C/C Validation Problem");
      	return;
      	}
      
      var validMed=validationMed();
      	if(validMed==false){
      	alert("Medicine Validation Problem");
      	return;
      	}
      var validDiagnosis=validationDiagnosis();
 		if(validDiagnosis==false){
 		alert("Diagnosis Validation Problem");
      	return;
      	}
      var validTest=validationTest();
      	if(validTest==false){
      	alert("Test Validation Problem");
      	return;
      	}
      	
      	var validOE=validationOE();
      	if(validOE==false){
      	alert("O/E Validation Problem");
      	return;
      	}
      	
      	var validPAE=validationPAE();
      	if(validPAE==false){
      	alert("P/A/E Validation Problem");
      	return;
      	}
      	
      	var validADV=validationADV();
      	if(validADV==false){
      	alert("Advice Validation Problem");
      	return;
      	}
      	
      	var validMedOut=validationMedOutside();
      	if(validMedOut==false){
      	alert("Out Side Medicine Validation Problem");
      	return;
      	}
      	
      	var validTestOut=validationTestOut();
      	if(validTestOut==false){
      	alert("Out Side Test Validation Problem");
      	return;
      	}
      	
      	var validWeight=validationWeight();
      	if(validWeight==false){
      	alert("Patient weight Problem");
      	return;
      	}
      	
      	
  
      document.forms["prescriptionSaveForm"].submit();
      
    }
    </script>
				<%@include file="/WEB-INF/jsp/template/footer.jsp"%>