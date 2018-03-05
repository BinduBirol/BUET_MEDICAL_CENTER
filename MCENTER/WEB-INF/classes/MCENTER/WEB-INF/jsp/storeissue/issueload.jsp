
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
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
                                         
                    $("#issuedate")
                        .require()
                        .match("date");
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                                            
                      for(var i = 1; i < table.rows.length; i++) { 
                      
                      	//var stock =$("#stock_"+i).val();
                      
                        $("#genid_"+i)
                        	.equalCheck("-1","Select Generic Name");
                        
                        $("#medid_"+i)
                        	.equalCheck("-1","Select Medicine Name");                        	
                        
                        $("#issueqty_"+i)
	                        .require()
	                        .match("integer")
	                        .range(1, $("#stock_"+i).val());
	                        //.lessThan( $("#stock_"+i).val());                        
                      
                      }
                     $('select[name^="medid"]')
                        .distinct("A Medicine Name is repeated.");
                        
                        
                });
            });

					
 $(function() {
            $("#issuedate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

        });

        function addRow(tableID) 
        {
                var table = document.getElementById(tableID);

                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                var counts = rowCount - 1;

                			
                var cell1 = row.insertCell(0);                
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
				cell1.appendChild(genid);	



                var cell2 = row.insertCell(1);
                cell2.id = "itemcol_" + rowCount;
				var medid = document.createElement("select");
                medid.setAttribute("name", "medid");
                medid.setAttribute("id", "medid_"+rowCount);
                medid.setAttribute("style", "width: 168px");               
                try {
				        medid.addEventListener('change', function(){
				         fetchThree(rowCount)
				        }, false)
				    } 
				    catch (e) {
				        medid.attachEvent('onchange', function(){
				            fetchThree(rowCount)
				        }, false)
				    } 
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
				cell2.appendChild(medid);	


				var cell3 = row.insertCell(2);
				cell3.id = "expiredatecol_" + rowCount;
                var expiredate = document.createElement("input");
                expiredate.type = "text";
                expiredate.name = "expireDate";
                expiredate.id = "expireDate_"+rowCount;
                expiredate.title="Expire Date"
                expiredate.setAttribute("class", "short");
                expiredate.readOnly=true; 
                cell3.appendChild(expiredate);


				var cell4 = row.insertCell(3);
				cell4.id = "lotcol_" + rowCount;
                var lot = document.createElement("input");
                lot.type = "text";
                lot.name = "lotnumber";
                lot.id = "lotnumber_"+rowCount;
                lot.title="Lot Number"
                lot.setAttribute("class", "short");
               
                lot.readOnly=true; 
                cell4.appendChild(lot);


				var cell5 = row.insertCell(4);
				cell5.id = "unitcol_" + rowCount;
                var unitprice = document.createElement("input");
                unitprice.type = "text";
                unitprice.name = "unitprice";  
                unitprice.id = "unitprice_"+rowCount;
                unitprice.title="Unit Price"              
                unitprice.setAttribute("class", "short");
                unitprice.readOnly=true; 
                cell5.appendChild(unitprice);
                

				var cell6 = row.insertCell(5);
				cell6.id = "stockcol_" + rowCount;
                var stock = document.createElement("input");
                stock.type = "text";
                stock.name = "stock";
                stock.id = "stock_"+rowCount;
                stock.title="Stock"
                stock.setAttribute("class", "short");
                stock.readOnly=true; 
                cell6.appendChild(stock);


                var cell7 = row.insertCell(6);
                var issueqty = document.createElement("input");
                issueqty.type = "text";
                issueqty.name = "issueqty";
                issueqty.id = "issueqty_"+rowCount;
                issueqty.title="Issue Qty"
                issueqty.setAttribute("class", "short");
                cell7.appendChild(issueqty);
                
                
                
                 
                var newCell = row.insertCell(7);
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
		     $("#lotnumber_"+rowid).val('');
		     $("#unitprice_"+rowid).val('');
		     $("#stock_"+rowid).val('');
		     $("#expireDate_"+rowid).val('');
		     
		     
		    }
		  }
		   var url="GetIssueItemList.action?genid="+genid+"&rowid="+rowid;
		   xmlhttp.open("GET",url,true);
		   xmlhttp.send();
		}
        
       function fetchThree(rowid)
		{		
		
		var medid = $("#medid_"+rowid).val();		
		
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
			 var lotnumber = fields[0];
			 var stock = fields[1];
			 var unitprice = fields[2];
			 var expireDate = fields[3];
			 
			 $("#lotnumber_"+rowid).val(fields[0]);
		     $("#unitprice_"+rowid).val(fields[2]);
		     $("#stock_"+rowid).val(fields[1]);
		     $("#expireDate_"+rowid).val(fields[3]);
		     
		     		     
		    }
		  }
		   var url="GetThreeItem.action?medid="+medid+"&rowid="+rowid;
		   xmlhttp.open("GET",url,true);
		   xmlhttp.send();
		}
        
</SCRIPT>


<form id="mainform" class="register" method="post" action="saveIssue.action">
	<h1>Medicine Issue Information</h1>
	<fieldset class="row1">
		<legend >
			Issue Summary
		</legend>

		<p>
			<label>Issue No.
            </label>
            <label class="idp"> ##### </label>
            <input type="hidden" name="issueno" value='<s:property value="issueno" />'/>
            <label>Issue Date
            </label>
            <input type="text" id="issuedate" name="issuedate"/>
		
		</p>		
		<p>
		<label>Remarks
            </label>
            <input type="text" id="remarks" name="remarks" maxlength="200" class="long"/>
		
		</p>

</fieldset>
	
	
	<fieldset class="row1">
		<legend >
			Issue Detail
		</legend>
	

	<TABLE class="display dataTable" id="medTable" width="90%" align="center">
		
        <TR>
                <Th>Generic Name</Th>
                <Th>Medicine</Th>
                <Th>Expire Date</Th>
                <Th>Lot Number</Th>                
                <Th>Unit Price</Th>
                <Th>Stock</Th>
                <Th>Issue Quantity</Th>
                <th> &nbsp;&nbsp;&nbsp; </th>
        </TR>
       
        <tbody>
        <TR>
                
                <TD>
                 <s:select headerKey="-1" headerValue="Select" onchange="fetchItem(1)"
                 list="mapgeneric" listKey="key" listValue="value" name="genid" id="genid_1" />
                </TD>
                <TD id="itemcol_1">
                <s:select headerKey="-1" headerValue="Select" onchange="fetchThree(1)"
                list="mapmedicine" listKey="key" listValue="value" name="medid" id="medid_1" style="width: 168px"/>
                </TD>
                <TD id="expiredatecol_1"> 
                <INPUT  type="text" name="expireDate" id="expireDate_1" title="Expire Date" class="short" readonly/> </TD>
                <TD id="lotcol_1"> 
                <INPUT  type="text" name="lotnumber" size="5" id="lotnumber_1" title="Lot Number" class="short" readonly/> </TD>
                <TD id="unitcol_1"> 
                <INPUT type="text" name="unitprice" size="5" id="unitprice_1" title="Unit Price" class="short" readonly/> </TD>
                <TD id="stockcol_1"> 
                <INPUT type="text" name="stock" id="stock_1" size="5" title="Stock" class="short" readonly/> </TD>
                <TD> <INPUT  type="text" name="issueqty" id="issueqty_1" size="5" title="Issue Qty" class="short"/> </TD>
                
                <td>
				<a href="#" onclick='javascript:removerow(this);'> <img src="/MCENTER/resources/images/delete_over.png"></img> </a>
				</td> 
					
        </TR>
        </tbody>
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

     
