
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
<h1>Test Information</h1>

		
	<fieldset class="row1">
		<legend >
			 Information
		</legend>
	 
	<div  id="blockP">
	<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
	<script type="text/javascript" src="/MCENTER/resources/js/tabledata/jquery.dataTables.js"></script>
	
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" id="myTable" class="display">
                            	<thead>
                                	<tr>
                                         
							                <Th>Test Type ID</Th>
							                <Th>Test Type Name</Th>
							                <Th>Test Name ID</Th>							                						                
							                <Th>Test Name</Th>
							                <Th>Vat</Th>
							                <Th>Rate</Th>
                                    </tr>
                                </thead>
                            	<tbody>
                                	<s:iterator value="testlist">	
									<tr>
										<td> <s:property value="testTypeID"/> </td>
										<td> <s:property value="testType"/> </td>
										<td> <s:property value="testNameID"/> </td>										
										<td> <s:property value="testName"/> </td>
										<td> <s:property value="vat"/> </td>
										<td> <s:property value="rate"/> </td>											
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
				"lengthMenu":[[100,150,200,-1],[100,150,200,"All"]]	
			});
			
		});
</script>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
