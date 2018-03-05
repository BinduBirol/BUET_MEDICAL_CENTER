
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/resources/js/tabledata/jquery.dataTables.js"></script>



<form id="mainform" class="register" >
<h1>Store Receive</h1>
	<fieldset class="row1">
		<legend >
			 Summary Information
		</legend>
	
	<div>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" id="myTable" class="display">
                            	<thead>
                                	<tr>                                      
							                <Th>Receive No</Th>
							                <Th>Receive Date</Th>
							                <Th>Bill No</Th>
							                <Th>Bill Date</Th>
							                <Th>Lot Number</Th>							                
							                <Th>Remarks</Th>							                
                                    </tr>
                                </thead>
                            	<tbody>
                                	<s:iterator value="sdList">	
									<tr>
										<td> 		
										
										<a href="viewReceive.action?receiveno=<s:property value="receiveno"/>"><s:property value="receiveno"/></a>
										
										</td>
										<td> <s:property value="receivedate"/> </td>
										<td> <s:property value="billno"/> </td>
										<td> <s:property value="billdate"/> </td>
										<td> <s:property value="lotnumber"/> </td>
										<td> <s:property value="remarks"/> </td>										
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
				"order": [[0,"desc"]],
				"lengthMenu":[[100,150,200,-1],[100,150,200,"All"]]	
			});
			
		});
</script>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
