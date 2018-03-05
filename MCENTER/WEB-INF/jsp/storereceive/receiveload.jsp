
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>

<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>




<SCRIPT lang="javascript">

	 $(function() { 
	 
	 		//$.validity.setup({outputMode:"summary"});
	 		
	 		var table = document.getElementById("medTable");               
	 		
                $("form").validity(function() {
                    $("#lotnumber")
                        .require()
                        .match("number")
                        .range(1, 999999);
                        
                    $("#receivedate")
                        .require()
                        .match("date");
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                      $("#billdate")
                        .require()
                        .match("date");
                        //.lessThanOrEqualTo(new Date(),"Bill Date must less than or equal to Todate");
                           
                       $("#billno")
                        .require();  
                      
                      for(var i = 1; i < table.rows.length; i++) {  
                        
                        $("#companyid_"+i)
                        	.equalCheck("-1","Select Company Name");  
                        
                        $("#genid_"+i)
                        	.equalCheck("-1","Select Generic Name");
                        
                        $("#medid_"+i)
                        	.equalCheck("-1","Select Medicine Name");
                        	
                        
                        $("#receiveqty_"+i)
	                        .require()
	                        .match("integer")
	                        .range(1, 999999);
                        
                        $("#unitprice_"+i)
	                        .require()
	                        .match("number")
	                        .range(0.5, 99999);
	                        
	                 	$("#expireDate_"+i)
                        .require()
                        .match("date");
	                                        
                        
                      }
                     $('select[name^="medid"]')
                        .distinct("A Medicine Name is repeated.");
                        
                        
                });
            });

					
/*  	$(function() {
	$( "#receivedate" ).datepicker();
	$( "#billdate" ).datepicker();
	});
	 */
	
/* 	$(window).load(function () {
    $(".datepicker").datepicker({
               dateFormat: 'dd/mm/yy',
               changeMonth: true,
     	       changeYear: true
    });
	}); */
	
	
/* 	$(".datepicker").datepicker({
    dateFormat: 'yy/m/d',
    firstDay: 1,
    changeMonth: true,
    changeYear: true,
    showOn: 'both',
    autosize: true,
    buttonText: "Select date",
    buttonImage: '../Content/images/calendar.png',
    buttonImageOnly: true
});
	 */
	 
/* 	 var datePickerOptions = {
  			dateFormat: 'dd/mm/yy',
            changeMonth: true,
     	    changeYear: true
    
	};
	 */
/* 	$(document).ready(function () {
    $(".datepicker").datepicker(datePickerOptions);
 	}); */
 	
/*  	$(".datepicker").datepicker(datePickerOptions); */
	 
	 $(function() {
            $("#receivedate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

            $("#billdate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();
            
             $("#expireDate_1").datepicker({
          			        dateFormat: 'dd/mm/yy',
                			changeMonth: true,
     	        			changeYear: true
            				}).val();
            				
/*              $("#expdate_2").datepicker({
          			        dateFormat: 'dd/mm/yy',
                			changeMonth: true,
     	        			changeYear: true
            				}).val();
            				 */
/*               for(var i = 1; i <=200; i++) { 
              
                 $("#expdate_"+i).datepicker({
          			        dateFormat: 'dd/mm/yy',
                			changeMonth: true,
     	        			changeYear: true
            				}).val();
              
              }  */ 				
            
          
        });


        function addRow(tableID) 
        {
             
        
        
                var table = document.getElementById(tableID);

                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                var counts = rowCount - 1;

                var cell1 = row.insertCell(0);
                var companyid = document.createElement("select");
                companyid.setAttribute("name", "companyid");
                companyid.setAttribute("id", "companyid_"+rowCount);
                
                try {
				        companyid.addEventListener('change', function(){
				         fetchItem(rowCount)
				        }, false)
				    } 
				    catch (e) {
				        companyid.attachEvent('onchange', function(){
				            fetchItem(rowCount)
				        }, false)
				    }             
                                                
					var opElement=document.createElement("option");
					opElement.setAttribute("value","-1");
					opElement.appendChild(document.createTextNode("Select"));	
					opElement.setAttribute("selected","selected");
					companyid.appendChild(opElement);
				
				<s:iterator value="mapcompany">
					var opElement=document.createElement("option");
					opElement.setAttribute("value",'<s:property value="key"/>');
					opElement.appendChild(document.createTextNode('<s:property value="value" />'));	
					
					companyid.appendChild(opElement);				
				</s:iterator>	
				cell1.appendChild(companyid);	
			
                var cell2 = row.insertCell(1);                
				var genid = document.createElement("select");
                genid.setAttribute("name", "genid");
                genid.setAttribute("id", "genid_"+rowCount);
                
                try {
				        genid.addEventListener('change', function(){
				         fetchItem(rowCount)
				        }, false)
				    } 
				    catch (e) {
				        genid.attachEvent('onchange', function(){
				            fetchItem(rowCount)
				        }, false)
				    }         
                
					var opElement=document.createElement("option");
					opElement.setAttribute("value","-1");
					opElement.appendChild(document.createTextNode("Select"));	
					opElement.setAttribute("selected","selected");
					genid.appendChild(opElement);
				
				<s:iterator value="mapgeneric">
					var opElement=document.createElement("option");
					opElement.setAttribute("value",'<s:property value="key"/>');
					opElement.appendChild(document.createTextNode('<s:property value="value" />'));	
					
					genid.appendChild(opElement);				
				</s:iterator>	
				cell2.appendChild(genid);	



                var cell3 = row.insertCell(2);
                cell3.id = "itemcol_" + rowCount;
				var medid = document.createElement("select");
                medid.setAttribute("name", "medid");
                medid.setAttribute("id", "medid_"+rowCount);
                medid.setAttribute("style", "width: 168px");
                
					var opElement=document.createElement("option");
					opElement.setAttribute("value","-1");
					opElement.appendChild(document.createTextNode("Select"));	
					opElement.setAttribute("selected","selected");
					medid.appendChild(opElement);
				
				<s:iterator value="mapmedicine">
					var opElement=document.createElement("option");
					opElement.setAttribute("value",'<s:property value="key"/>');
					opElement.appendChild(document.createTextNode('<s:property value="value" />'));	
					
					medid.appendChild(opElement);				
				</s:iterator>	
				cell3.appendChild(medid);	
				
				var cell4 = row.insertCell(3);
                var expdate = document.createElement("input");
                expdate.type = "text";
                expdate.name = "expireDate";
                expdate.id = "expireDate_"+rowCount;
                
                expdate.title="Expire Date";
                expdate.setAttribute("class", "datepicker");
                expdate.setAttribute("placeholder", "dd/mm/yyyy");
                expdate.setAttribute("readonly", "true");
                expdate.setAttribute("size", "10");
                $(expdate).datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
                }).val(); 
                cell4.appendChild(expdate);


                var cell5 = row.insertCell(4);
                var receiveqty = document.createElement("input");
                receiveqty.type = "text";
                receiveqty.name = "receiveqty";
                receiveqty.id = "receiveqty_"+rowCount;
                receiveqty.title="Receive Qty"
                receiveqty.setAttribute("class", "short");
                cell5.appendChild(receiveqty);
                
                var cell6 = row.insertCell(5);
                var unitprice = document.createElement("input");
                unitprice.type = "text";
                unitprice.name = "unitprice";  
                unitprice.id = "unitprice_"+rowCount;
                unitprice.title="Unit Price";              
                unitprice.setAttribute("class", "short");
                cell6.appendChild(unitprice);
                 
                var newCell = row.insertCell(6);
				newCell.align = "left";
				a = "<a href=\"#\" onclick=\"return removerow(this)\" ><img src='/MCENTER/resources/images/delete_over.png'></a>";
				newCell.innerHTML = a;
             
        }
        
        function removerow(element) {
		try {
	
		var r = element.parentNode.parentNode;
		var index = r.sectionRowIndex;
		var table2 = r.parentNode;
		table2.deleteRow(index);
		
		return false;
		}
		catch (e) {
			alert(e);
		}
	}
        
        function fetchItem(rowid)
		{
		
		var companyid = $("#companyid_"+rowid).val();
		var genid = $("#genid_"+rowid).val();
		
		
		
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
		     document.getElementById("itemcol_"+rowid).innerHTML=xmlhttp.responseText;
		     
		    }
		  }
		   var url="GetItemList.action?companyid="+companyid+"&genid="+genid+"&rowid="+rowid;
		   xmlhttp.open("GET",url,true);
		   xmlhttp.send();
		}
        
       
        
</SCRIPT>


<form id="mainform" class="register" method="post" action="saveReceive.action">
	<h1>Medicine Receive Information</h1>
	<fieldset class="row1">
		<legend >
			Receive Summary
		</legend>

		<p>
			<label>Receive No.#
            </label>
            <label class="idp"> <s:property value="receiveno" /> </label>
            <input type="hidden" name="receiveno" value='<s:property value="receiveno" />'/>
            <label>Receive Date
            </label>
            <input type="text" id="receivedate" name="receivedate"/>
		
		</p>
		<p>
			<label>Bill No.#
            </label>
            <input type="text" id="billno" name="billno" title="Bill No."/>
            
            <label>Bill Date
            </label>
            <input type="text" id="billdate" name="billdate"/>
		</p>

		<p>
		<label>Lot Number
            </label>
            <input type="text" id="lotnumber" name="lotnumber" maxlength="10"/>
		
		</p>
		<p>
		<label>Remarks
            </label>
            <input type="text" id="remarks" name="remarks" maxlength="200" class="long"/>
		
		</p>

</fieldset>
	
	
	<fieldset class="row1">
		<legend >
			Receive Detail
		</legend>
	

	<TABLE class="display dataTable" id="medTable" width="90%" align="center">

        <TR>
                <TD>Company</TD>
                <TD>Generic Name</TD>
                <TD>Medicine</TD>
                <TD>Expire Date</TD>
                <TD>Receive Quantity</TD>
                <TD>Unit Price</TD>
                <td> &nbsp;&nbsp;&nbsp; </td>
        </TR>
        <TR>
                <TD>
                <s:select headerKey="-1" headerValue="Select" onchange="fetchItem(1)"
                list="mapcompany" listKey="key" listValue="value" name="companyid" id="companyid_1"/>
                </TD>
                <TD>
                 <s:select headerKey="-1" headerValue="Select" onchange="fetchItem(1)"
                 list="mapgeneric" listKey="key" listValue="value" name="genid" id="genid_1" />
                </TD>
                <TD id="itemcol_1">
                <s:select headerKey="-1" headerValue="Select"
                list="mapmedicine" listKey="key" listValue="value" name="medid" id="medid_1" style="width: 168px"/>
                </TD>
                <TD> <INPUT  type="text" readonly="true" name="expireDate" id="expireDate_1" title="Expire Date" placeholder="dd/mm/yyyy"/> </TD>
                <TD> <INPUT  type="text" name="receiveqty" id="receiveqty_1" title="Receive Qty" class="short"/> </TD>
                <TD> <INPUT type="text" name="unitprice" id="unitprice_1" title="Unit Price" class="short" /> </TD>
                <td>
				<a href="#" onclick='javascript:removerow(this);'> <img src="/MCENTER/resources/images/delete_over.png"></img> </a>
				</td> 
					
        </TR>
</TABLE>
<br>
<INPUT type="button" value="Add More" onclick="addRow('medTable')" class="short"/> 

</fieldset>


<div class="validity-summary-container">

<ul></ul>

</div>


<div ><button class="button" >Submit &raquo;</button></div>

</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
