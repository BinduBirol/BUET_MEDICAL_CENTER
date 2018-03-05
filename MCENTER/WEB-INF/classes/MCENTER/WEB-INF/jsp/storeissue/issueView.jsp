
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>

	


<form id="mainform" class="register"  action="loadIssue.action">
	<h1>Medicine Issue Information</h1>
	<fieldset class="row1">
		<legend >
			Issue Summary
		</legend>

		<p>
			<label>Issue No.:
            </label>
            <label class="view"> <s:property value="issueno" /> </label>
            <input type="hidden" name="issueno" id="issueno" value='<s:property value="issueno" />'>
            <label>Issue Date:
            </label>
            <label class="view"> <s:property value="issuedate" /> </label>
            <input type="hidden" name="issuedate" id="issuedate" value='<s:property value="issuedate" />'>
		</p>		
		<p>
		<label>Remarks:
            </label>            
            <label class="view"> <s:property value="remarks" /> </label>
			<input type="hidden" name="remarks" id="remarks" value='<s:property value="remarks" />'>
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
                <Th>Lot Number</Th>                
                <Th>Unit Price</Th>
                <Th>Stock</Th>
                <Th>Issue Quantity</Th>
                
        </TR>
        
        <tbody>
        <s:iterator value="sdList">
        <TR>
                <TD>  <s:property value="genname"/>  </TD>
                <TD>  <s:property value="medname"/>  </TD>
                <TD>  <s:property value="lotnumber"/>  </TD>
                <TD>  <s:property value="unitprice"/>  </TD> 
                <TD>  <s:property value="stock"/>  </TD> 
                <TD>  <s:property value="issueqty"/>  </TD>
                              
					
        </TR>
        </s:iterator>
        </tbody>
        
        
</TABLE>
<br>

</fieldset>

<div ><button class="button" >Ok &raquo;</button></div>

</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
