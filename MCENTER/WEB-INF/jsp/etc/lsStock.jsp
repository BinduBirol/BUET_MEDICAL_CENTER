
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>

<script>
function printPage(id)
{
   var html="<html>";
   html+= document.getElementById(id).innerHTML;

   html+="</html>";

   var printWin = window.open('','','left=0,top=0,width=600,height=600,toolbar=0,scrollbars=0,status  =0');
   printWin.document.write(html);
   printWin.document.close();
   printWin.focus();
   printWin.print();
   printWin.close();
}
</script>

<form id="mainform" class="register" >
<h1>Local Store</h1>

		
	<fieldset class="row1">
		<legend >
			 Stock Information
		</legend>
	 
	<div  id="blockP">
	<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
	<script type="text/javascript" src="/MCENTER/resources/js/tabledata/jquery.dataTables.js"></script>
	
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" id="myTable" class="display">
                            	<thead>
                                	<tr>
                                            <Th> </Th>
							                <Th>Generic Name</Th>
							                <Th>Medicine</Th>
							                <Th>Company</Th>							                						                
							                <Th>Stock Quantity</Th>
							                <Th>Unit Price</Th>
							                <Th>Expire Date</Th>
                                    </tr>
                                </thead>
                            	<tbody>
                                	<s:iterator value="medicine" status="status">	
									<tr>
										<td> <s:property value="%{#status.count}"/> </td>
										<td> <s:property value="genname"/> </td>
										<td> <s:property value="medname"/> </td>
										<td> <s:property value="companyname"/> </td>										
										<td> <s:property value="quantity"/> </td>
										<td> <s:property value="unitprice"/> </td>
										<td> <s:property value="expireDate"/> </td>										
									</tr>									
									</s:iterator>
                                    
                                </tbody>
                            </table>

                        </div>

</fieldset>
</form>	


<script type="text/javascript">        	
		
		$(document).ready(function(){
			$('#myTable').dataTable({
				"pagingType": "full_numbers",
				"order": [[0,"asc"]],
				"lengthMenu":[[10,50,100,150,200,-1],[10,50,100,150,200,"All"]]	
			});
			
		});
</script>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
