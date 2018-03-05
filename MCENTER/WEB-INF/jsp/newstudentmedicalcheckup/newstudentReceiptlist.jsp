
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/resources/js/tabledata/jquery.dataTables.js"></script>
<style>
.button {
	display: inline-block;
	border-radius: 4px;
	background-color: #006400;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 18px;
	padding: 0px;
	width: 120px;
	height: 25px; transition : all 0.5s;
	cursor: pointer;
	margin: 5px;
	transition: all 0.5s;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: ' >>';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}
.button:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0,255,0, 0.10);
}
</style>


<form action="rePrintNewStudentMoneyReceiptReportAction"
						name="rePrintNewStudentMoneyReceip" id="rePrintNewStudentMoneyReceip" method="post">
<input type="hidden" id="dataString" name="dataString" />
	<fieldset class="row1">
		<legend >
			 Summary Information
		</legend>
	
	<div>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" id="myTable" class="display">
                            	<thead>
                                	<tr>                                      
							                
							                <Th>Session</Th>
							                <Th>Receipt No</Th>
							                <Th>Group</Th>							                						                
							                <Th>Merit Position</Th>
							                <Th>Name</Th>
							                <Th>Gender</Th>
							                <Th>Father Name</Th>
							                <Th>Assigned Doctor</Th>
							               <Th>Print</Th> 								                
                                    </tr>
                                </thead>
                            	<tbody>
                                	<s:iterator value="sdList">	
									<tr>
									    <td><s:property value="acadenicsession"/></td>
										<td><s:property value="receiptNO"/></td>
										<td> <s:property value="group_id"/> </td>										
										<td> <s:property value="meritPosition"/> </td>	
										<td> <s:property value="studentname"/> </td>
										<td> <s:property value="gender"/> </td>
										<td> <s:property value="fatherName"/> </td>
										<td> <s:property value="doctorName"/> </td>	
										 <td>  
										 <button type="submit" class="button" style="vertical-align:middle"
onclick="return downloadReceipt('<s:property value="receiptNO"/>###<s:property value="studentname"/>###<s:property value="acadenicsession"/>###<s:property value="meritPosition"/>###<s:property value="amount"/>###<s:property value="group_id"/>###<s:property value="gender"/>###<s:property value="dob"/>###<s:property value="fatherName"/>###<s:property value="doctorName"/>')" 
									>
									<span>Print</span>
									</button>
										 </td> 									
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
				"lengthMenu":[[10,25,50,100,150,200,-1],[10,25,50,100,150,200,"All"]]	
			});
			
		});
</script>
<script type="text/javascript">
	function downloadReceipt(a) {
	$("#dataString").val(a);
			//alert($("#dataString").val());
			//return false;
		}

	</script>
<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
