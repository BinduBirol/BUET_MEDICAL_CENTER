
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
	                                        
                        
                      }
                     $('select[name^="medid"]')
                        .distinct("A Medicine Name is repeated.");
                        
                        
                });
            });

					
 	$(function() {
	$( "#receivedate" ).datepicker();
	$( "#billdate" ).datepicker();
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
                var receiveqty = document.createElement("input");
                receiveqty.type = "text";
                receiveqty.name = "receiveqty";
                receiveqty.id = "receiveqty_"+rowCount;
                receiveqty.title="Receive Qty"
                receiveqty.setAttribute("class", "short");
                cell4.appendChild(receiveqty);
                
                var cell5 = row.insertCell(4);
                var unitprice = document.createElement("input");
                unitprice.type = "text";
                unitprice.name = "unitprice";  
                unitprice.id = "unitprice_"+rowCount;
                unitprice.title="Unit Price"              
                unitprice.setAttribute("class", "short");
                cell5.appendChild(unitprice);
                 
                var newCell = row.insertCell(5);
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
        
function setSelectedIndex(s, v) {
    for ( var i = 0; i < s.options.length; i++ ) {
        if ( s.options[i].value == v ) {
            s.options[i].selected = true;
            return;
        }
    }
}       
        
</SCRIPT>


<form id="mainform" class="register" method="post" action="editReceive.action">
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
            <input type="text" id="receivedate" name="receivedate" value='<s:property value="receivedate" />'/>
		
		</p>
		<p>
			<label>Bill No.#
            </label>
            <input type="text" id="billno" name="billno" title="Bill No." value='<s:property value="billno" />'/>
            
            <label>Bill Date
            </label>
            <input type="text" id="billdate" name="billdate" value='<s:property value="billdate" />'/>
		</p>

		<p>
		<label>Lot Number
            </label>
            <input type="text" id="lotnumber" name="lotnumber" maxlength="10" value='<s:property value="lotnumber" />'/>
		
		</p>
		<p>
		<label>Remarks
            </label>
            <input type="text" id="remarks" name="remarks" maxlength="200" class="long" value='<s:property value="remarks" />'/>
		
		</p>

</fieldset>
	
	
	<fieldset class="row1">
		<legend >
			Receive Detail
		</legend>
	

	<TABLE class="display dataTable" id="medTable" width="90%" align="center">

        <TR>
                <Th>Company</Th>
                <Th>Generic Name</Th>
                <Th>Medicine</Th>
                <Th>Receive Quantity</Th>
                <Th>Unit Price</Th>
                <th> &nbsp;&nbsp;&nbsp; </th>
        </TR>
        
        
        <% int rowcount=1; %>
        
         <s:iterator value="sdList">
        <TR>
        
                <TD>
                <s:select headerKey="-1" headerValue="Select" onchange="fetchItem(<%=rowcount %>)"
                list="mapcompany" listKey="key" listValue="value" name="companyid" id="companyid_<%=rowcount %>"/>
                </TD>
                <TD>
                 <s:select headerKey="-1" headerValue="Select" onchange="fetchItem(<%=rowcount %>)"
                 list="mapgeneric" listKey="key" listValue="value" name="genid" id="genid_<%=rowcount %>" />
                </TD>
                <TD id="itemcol_<%=rowcount %>">
                <s:select headerKey="-1" headerValue="Select"
                list="mapmedicine" listKey="key" listValue="value" name="medid" id="medid_<%=rowcount %>" style="width: 168px"/>
                </TD>
                <TD> <INPUT  type="text" name="receiveqty" id="receiveqty_<%=rowcount %>" title="Receive Qty" class="short" value='<s:property value="receiveqty" />'/>  </TD>
                <TD> <INPUT type="text" name="unitprice" id="unitprice_<%=rowcount %>" title="Unit Price" class="short" value='<s:property value="unitprice" />' /> </TD>
                <td>
				<a href="#" onclick='javascript:removerow(this);'> <img src="/MCENTER/resources/images/delete_over.png"></img> </a>
				</td> 
									
        </TR>
        <script type="text/javascript"> 			                  
             setSelectedIndex(document.getElementById('companyid_<%=rowcount %>'),<s:property value="companyid" />);  
             setSelectedIndex(document.getElementById('genid_<%=rowcount %>'),<s:property value="genid" />);  
             setSelectedIndex(document.getElementById('medid_<%=rowcount %>'),<s:property value="medid" />);             
	    </script>
                
        <% rowcount++; %>
        
       </s:iterator>
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

     
