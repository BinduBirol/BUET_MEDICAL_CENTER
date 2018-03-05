
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
	


<form id="mainform" class="register"  action="loadReceive.action">
	<h1>Medicine Receive Information</h1>
	<fieldset class="row1">
		<legend >
			Receive Summary
		</legend>

		<p>
			<label>Receive No.:
            </label>
            <label class="view"> <s:property value="receiveno" /> </label>
            
            <label>Receive Date:
            </label>
            <label class="view"> <s:property value="receivedate" /> </label>
            
		</p>
		<p>
			<label>Bill No.:
            </label>
            
            <label class="view"> <s:property value="billno" /> </label>
            
            <label>Bill Date:
            </label>
            
            <label class="view"> <s:property value="billdate" /> </label>
		</p>

		<p>
		<label>Lot Number:
            </label>
            
            <label class="view"> <s:property value="lotnumber" /> </label>
		
		</p>
		<p>
		<label>Remarks:
            </label>            
            <label class="view"> <s:property value="remarks" /> </label>
		
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
                
        </TR>
       
        <tbody>
        <s:iterator value="sdList">
        <TR>
                <TD>  <s:property value="companyname"/>  </TD>
                <TD>  <s:property value="genname"/>  </TD>
                <TD>  <s:property value="medname"/>  </TD>
                <TD>  <s:property value="receiveqty"/>  </TD>
                <TD>  <s:property value="unitprice"/>  </TD>               
					
        </TR>
        </s:iterator>
        </tbody>
        
        
</TABLE>
<br>

</fieldset>


<div ><button class="button" >Ok &raquo;</button></div>

<div ><button class="button" >Edit &raquo;</button></div>


</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
