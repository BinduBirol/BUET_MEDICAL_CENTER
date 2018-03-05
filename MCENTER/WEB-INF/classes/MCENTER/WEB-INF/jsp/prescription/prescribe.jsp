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

function addRow(element) {

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountc").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountc").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "left";
    el = document.createElement("select");
    el.id = "ccid_" + (rowid + 1);
    el.name = "ccname";


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
    a = "<div id='cctypecol_" + (rowid + 1) + "' align='left' style='width: 85px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' id='comments_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(3);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerow(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadCC(rowid + 1);


    return false;
}


function loadCC(rowcount) {
    var k = 1;
    var ind = document.getElementById("ccid_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

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

        return false;
    }
    catch (e) {
        alert(e);
    }
}


//OE

function addRowOE(element) {

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
    a = "<input type='text' id='oecom_" + (rowid + 1) + "' align='center' size='15'/>";
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

// p/a/e

function addRowP(element) {

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountp").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountp").value = rowid + 1;


    var newCell = newRow.insertCell(0);
    newCell.align = "center";
    a = "<input type='text' id='pcom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowp(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


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


//investigation

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


function fetchSbTest(rowid, id) {

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("testcol_" + rowid).innerHTML = xmlhttp.responseText;
        }
    }
    var url = "GetTestSbType.action?id=" + id + "&index=" + rowid;
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
    a = "<div id='testypecol_" + (rowid + 1) + "' align='left' style='width: 85px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<div id='testcol_" + (rowid + 1) + "' align='left' style='width: 85px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(3);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowinv(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadTest(rowid + 1);
    loadSbTest(rowid + 1);


    return false;
}


function loadTest(rowcount) {
    var k = 1;
    var ind = document.getElementById("testype_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

    <s:iterator  value="testypelist">
    ind.options[k] = new Option("<s:property value="testypename"/>", <s:property value="testypeid" />);
    k = k + 1;
    </s:iterator>


}

function loadSbTest(rowcount) {
    var k = 1;
    var ind = document.getElementById("sbtestid_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

    <s:iterator  value="sbtestlist">
    ind.options[k] = new Option("<s:property value="subtestname"/>", <s:property value="subtestid" />);
    k = k + 1;
    </s:iterator>


}


//rx 

function fetchMed(rowid, id) {
    alert(id);
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
    a = "<div id='med_" + (rowid + 1) + "' align='left' style='width: 85px;'>	</div>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(2);
    newCell.align = "center";
    a = "<input type='text' id='qty_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(3);
    newCell.align = "center";
    a = "<input type='text' id='times_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(4);
    newCell.align = "center";
    a = "<select size='1' name='dose' id='dose_" + (rowid + 1) + "' style='font-size: 14px;width: 80px;'>" +
            "<option value='00'>Please Select</option>" +
            "<option value='01'>Times</option>" +
            "<option value='02'>Hourly</option>" +
            "<option value='03'>Daily</option>" +
            "</select>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(5);
    newCell.align = "center";
    a = "<input type='text' id='days_" + (rowid + 1) + "' align='center' size='10'/>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(6);
    newCell.align = "center";
    a = "<select size='1' name='dose' id='when_" + (rowid + 1) + "' style='font-size: 14px;width: 80px;'>" +
            "<option value='00'>Please Select</option>" +
            "<option value='01'>before Meal</option>" +
            "<option value='02'>after meal</option>" +
            "<option value='03'>Any time in a day</option>" +
            "</select>";
    newCell.innerHTML = a;


    newCell = newRow.insertCell(7);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowrx(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadGen(rowid + 1);


    return false;
}


function loadGen(rowcount) {
    var k = 1;
    var ind = document.getElementById("gen_" + rowcount);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

    <s:iterator  value="genericlist">
    ind.options[k] = new Option("<s:property value="genname"/>", <s:property value="genid" />);
    k = k + 1;
    </s:iterator>


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

//dia
function addRowD(element) {

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
    a = "<input type='text' id='dcom_" + (rowid + 1) + "' align='center' size='15'/>";
    newCell.innerHTML = a;

    newCell = newRow.insertCell(2);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowd(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;


    loadD(rowid + 1);


    return false;
}


function loadD(rowcountd) {
    var k = 1;
    var ind = document.getElementById("did_" + rowcountd);
    if (ind == null) return;


    ind.options.length = 0;
    ind.options[0] = new Option("Please Select", "");

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

//Adv
function addRowAdv(element) {

    var r = element.parentNode.parentNode;
    var table2 = r.parentNode;
    var lastRow = table2.rows.length - 2;
    var rowid = parseInt(document.getElementById("rowcountadv").value) || 1;

    var newRow = table2.insertRow(lastRow);
    newRow.id = rowid + 1;
    document.getElementById("rowcountadv").value = rowid + 1;

    
    var newCell = newRow.insertCell(0);
    newCell.align = "center";
     	
    	
   a="<select name='advicename' id='adn_" + (rowid + 1) + "' style='font-size: 14px;width: 80px;' onchange='this.nextElementSibling.value=this.value'> ";
   <s:iterator  value="advlist">
   a+="<option value=<s:property value='advicename'/> > <s:property value='advicename' /> </option>";
     
   </s:iterator>
   	a+="</select>";
  	a+= "<input type='text'  name='advicename' id='txt_" + (rowid + 1) + "' align='center'/>";
   //<input width="500px" id="txt_1" name="advicename" type="text" value=""/>
   //alert(a);
   
    newCell.innerHTML = a;
    
       
    
    newCell = newRow.insertCell(1);
    newCell.align = "left";
    a = "<a href=\"#\" onclick=\"return removerowadv(this)\" style='color:red;font-weight: bold;font-size: 12px'> Delete </a>";
    newCell.innerHTML = a;

	
    //loadAdv(rowid+1);


    return false;
}




</script>

<div class="wrap">
<div class="wrapper">
<div class="header">
    <a href="http://www.buet.ac.bd" target="_blank"><img class="headerLogo" src="resources/img/logo.png" width="110"
                                                         alt=""/></a>
    <big class="caption">Medical Center, BUET</big>
    <img class="stethoscope" src="resources/img/stethoscope.png" width="120" alt=""/>
</div>
<!--end header-->
<!--<a href="http://www.kgdcl.gov.bd/" class="header"></a>-->
<div class="horizonMenu">
    <ul>
        <li>
            <a href="http://www.buet.ac.bd/">BUET Home</a>
        </li>
        <li class="marginL145">
            <a href="#">Home</a>
        </li>
        <li>
            <a href="#">Contact Us</a>
        </li>
        <li>
            <a href="login.html">Log Out</a>
        </li>
    </ul>
</div>
<!--end horizonMenu-->

<div class="mainBody">
<div class="leftMenu">
    <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Reception</a></li>
        <li><a href="#">Doctor</a></li>
        <li><a href="#">Pharmacy</a></li>
        <li><a href="#">Tests</a></li>
        <li><a href="#">Bill</a></li>
        <li><a href="#">Report</a></li>
        <li><a href="#">User</a></li>
        <li><a href="#">Help</a></li>
    </ul>
</div>
<!--end leftMenu-->
<div class="rightCon">
<div class="contentBox" style="height: 800px;">

<p align="center">Prescription No : <s:property value="prescriptionid"/></p>


<s:hidden id="pid" name='prescriptionid' value="%{prescriptionid}"> </s:hidden>

<div class="fleft">

<form action="savecc" method="post">
<s:hidden id="pid" name='prescriptionid' value="%{prescriptionid}"> </s:hidden>
<table class="data" align="center" id="tablec" width="60px">

    <thead>
    <tr>
        <td>C/C</td>

    </tr>
    <tr>
        <th size="3"> Chief Complains</th>
        <th size="3"></th>
        <th size="3"> Comments</th>
        <th size="3"></th>

    </tr>
    </thead>
    <tbody>
    <tr><input type="hidden" id="rowcountc" name="rowcountc" value="1"/></tr>
    <tr id="1">
        <td size="5"><select size="1" name="ccname" id="ccid_1"
                             onchange="fetchItem(1,this.options[this.selectedIndex].value)"
                             style="font-size: 14px;width: 90px;">
            <option value="">Please Select</option>
            <s:iterator value="strList">
                <option value="<s:property value="ccid" />"><s:property value="ccname"/></option>
            </s:iterator>
        </select>
        </td>
        <td size="5">
            <div id="cctypecol_1" align="left" style="width: 90px; ">

            </div>
        </td>
        <td><input size="10" type="text" name="comments" id="comments_1"></td>
        <td>
            <a href="#" style='color:red;font-weight: bold;font-size: 12px' onclick='javascript:removerow(this);'>
                Delete </a>
        </td>
    </tr>
    <tr>
        <td colspan="4" align="center">
            <a href="#" onclick="javascript:addRow(this);setTimeout(scrolltoBottom, 10);">Add More</a>
        </td>
    </tr>
    </tbody>
</table>
<!--  </form>  -->


<!-- <form action="saveoe" method="post"> -->
<table class="data" align="center" id="tableoe" width="60px">

    <thead>
    <tr>
        <td>OE</td>

    </tr>
    <tr>
        <th>OE Name</th>
        <th>Comments</th>
        <th></th>
    </tr>
    </thead>

    <tbody>
    <tr><input type="hidden" id="rowcountoe" name="rowcountoe" value="1"/></tr>
    <tr>
         <td> <select size="1" name="oename" id="oeid_1"  style="font-size: 14px;width: 90px;">
             <option value="">Please Select</option>
             <s:iterator  value="oeList">
             <option value="<s:property value="oeid" />"><s:property value="oename"/></option>
             </s:iterator>
              </select>
          </td> 
        <td>
            <input name="oecomments" size="15"  id="oecom_1" type="text" width="90px">
         </td>
        <td>
        <a href="#" style='color:red;font-weight: bold;font-size: 12px' onclick='javascript:removerowoe(this);'> Delete </a>
       </td>

    </tr>
    <tr>
        <!-- <td colspan="2" align="left">
            <input type="submit" value="Save"   />
        </td> -->
        <td colspan="3" align="center">
            <a href="#" onclick="javascript:addRowOE(this);setTimeout(scrolltoBottom, 10);">Add More</a>
        </td>
    </tr>
    </tbody>
</table>


<div>
            <input type="submit" value="Save"   /></div>
        
 </form>  

<!--  
<table class="data" align="center" id="tableoe" width="60px">

    <thead>

    <tr>
        <td>P/A/E</td>

    </tr>
    </thead>
    <tbody>

    <tr><input type="hidden" id="rowcountp" name="rowcountp" value="1"/></tr>
    <tr>

        <td>
            <input name="pcomments" size="15" id="pcom_1" type="text" width="90px">
        </td>
        <td>
            <a href="#" style='color:red;font-weight: bold;font-size: 12px' onclick='javascript:removerowp(this);'>
                Delete </a>
        </td>

    </tr>
    <tr>

        <td colspan="2" align="center">
            <a href="#" onclick="javascript:addRowP(this);setTimeout(scrolltoBottom, 10);">Add More</a>
        </td>
    </tr>
    </tbody>
</table>-->
<!-- </form>  -->

<!--  
<table class="data" align="center" id="table">
    <thead>

    <tr>
        <td>Rx</td>
    </tr>


    <tr>
        <th> Medicine Group</th>
        <th width="5"> Medicine Name</th>
        <th> Quantity</th>
        <th colspan="2"> Dosages</th>
        <th colspan="2"> Days</th>
        <th></th>


    </tr>
    </thead>
    <tbody>
    <tr><input type="hidden" id="rowcountrx" name="rowcountrx" value="1"/></tr>

    <tr>

        <td size="5"><select size="1" name="genname" id="gen_1"
                             onchange="fetchMed(1,this.options[this.selectedIndex].value)"
                             style="font-size: 14px;width: 90px;">
            <option value="">Please Select</option>
            <s:iterator value="genericlist">
                <option value="<s:property value="genid" />"><s:property value="genname"/></option>
            </s:iterator>
        </select>
        </td>
        <td size="5">
            <div id="med_1" align="left" style="width: 90px; ">

            </div>
        </td>

        <td align="center">
            <input name="drgqty" size="5" id="qty_1" type="text">
        </td>

        <td align="center">
            <input name="times" size="1" id="times_1" type="text">
        </td>
        <td align="center">
            <select size="1" name="dose" id="dose_1" style="font-size: 14px;width: 90px;">
                <option value="00">Please Select</option>
                <option value="01">Times</option>
                <option value="02">Hourly</option>
                <option value="03">Daily</option>
            </select>


        </td>

        <td align="center">
            <input name="days" size="1" id="days_1" type="text">
        </td>

        <td align="center">
            <select size="1" name="when" id="when_1" style="font-size: 14px;width: 90px;">
                <option value="00">Please Select</option>
                <option value="01">before Meal</option>
                <option value="02">after meal</option>
                <option value="03">Any time in a day</option>


            </select>


        </td>

        <td>
            <a href="#" style='color:red;font-weight: bold;font-size: 12px' onclick='javascript:removerowrx(this);'>
                Delete </a>
        </td>

    </tr>


    <tr>

        <td colspan="8" align="center">
            <a href="#" onclick="javascript:addRowRx(this);setTimeout(scrolltoBottom, 10);">Add More</a>
        </td>
    </tr>


    </tbody>


</table>


<table class="data" align="center" id="auto">
    <thead>

    <tr>
        <td colspan="2">Advice to be followed</td>

    </tr>


    </thead>

    <tbody>
    <tr><input type="hidden" id="rowcountadv" name="rowcountadv" value="1"/></tr>
    <tr>
        <td width="500px">


            <div id="adv_1" class="select-editable">

                <select width="500px" id="adn_1" name="advicename" onchange="this.nextElementSibling.value=this.value">

                    <option value=" ">Please Select</option>
                    <s:iterator value="advlist">
                        <option value="<s:property value="advicename" />"> <s:property value="advicename"/> </option>
                    
                    </s:iterator>

                </select>
                <input width="500px" id="txt_1" name="advicename" type="text" value=""/>
            </div>


        </td>


        <td>

        </td>


    </tr>


    <tr>

        <td colspan="2">
            <a href="#" onclick="javascript:addRowAdv(this);setTimeout(scrolltoBottom, 10);">Add More</a>
        </td>


    </tr>


    </tbody>


</table>


</div>


<div class="fright">

    <table class="data" align="center" id="tabletest" width="60px">
        <thead>
        <thead>

        <tr>
            <td>Investigations</td>

        </tr>
        </thead>
        <tr>
            <th>Test Type</th>
            <th>Test Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <tr><input type="hidden" id="rowcountinv" name="rowcountinv" value="1"/></tr>
        <tr>
            <td><select size="1" name="testypename" id="testype_1"
                        onchange="fetchTest(1,this.options[this.selectedIndex].value)"
                        style="font-size: 14px;width: 103px;">
                <option value="">Please Select</option>
                <s:iterator value="testypelist">
                    <option value="<s:property value="testypeid" />"><s:property value="testypename"/></option>
                </s:iterator>
            </select>

            </td>
            <td>
                <div id="testypecol_1" align="left" style="width: 103px; ">

                </div>
            </td>
            <td>
                <div id="testcol_1" align="left" style="width: 103px; ">

                </div>
            </td>

            <td>
                <a href="#" style='color:red;font-weight: bold;font-size: 12px'
                   onclick='javascript:removerowinv(this);'> Delete </a>
            </td>

        </tr>

        <tr>

            <td colspan="4" align="center">
                <a href="#" onclick="javascript:addRowinv(this);setTimeout(scrolltoBottom, 10);">Add More</a>
            </td>
        </tr>


        </tbody>


    </table>


    <table class="data" align="center" id="tabled" width="60px">

        <thead>
        <tr>
            <td>Diagonosis</td>

        </tr>
        <tr>
            <th>Type</th>
            <th>Comments</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <tr><input type="hidden" id="rowcountd" name="rowcountd" value="1"/></tr>
        <tr>
            <td><select size="1" name="dname" id="did_1" style="font-size: 14px;width: 90px;">
                <option value="">Please Select</option>
                <s:iterator value="dlist">
                    <option value="<s:property value="did" />"><s:property value="dname"/></option>
                </s:iterator>
            </select>
            </td>
            <td>
                <input name="dcomments" size="15" id="dcom_1" type="text" width="90px">
            </td>
            <td>
                <a href="#" style='color:red;font-weight: bold;font-size: 12px' onclick='javascript:removerowd(this);'>
                    Delete </a>
            </td>

        </tr>
        <tr>

            <td colspan="3" align="center">
                <a href="#" onclick="javascript:addRowD(this);setTimeout(scrolltoBottom, 10);">Add More</a>
            </td>
        </tr>
        </tbody>
    </table>

</div>
</form >

-->
<!--end contentBox-->
</div>
<!--end rightCon-->
</div>
<!--end mainBody-->
</div>
<!--end wrapper-->
<div class="footer">
    <p>2014 &copy; BUET All rights reserved</p>
</div>
<!--end footer-->
</div>
<!--end wrap-->


</html>