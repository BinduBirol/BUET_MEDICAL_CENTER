<%
if( session.getAttribute("userType")==null || ((String)session.getAttribute("userType")).equalsIgnoreCase("") ) {%>

<%}else{ %>
<%@include file="/WEB-INF/jsp/template/head.jsp"%>
<%}%>


<br/><br/><br/><br/>

<center>
  <font color="red" style="font-size: 12pt;font-weight: bold;"> 
  	An error has occured.
  	<br/><br/> Be Patience and wait a moment.
  </font>  
  <br/></br/><br/></br/>
  <div style="text-align: left;width: 620px;border: 1px solid black;padding: 10px;overflow: auto;height: 400px;">
	<font size="2"><b>Exception Name:</b></font> <font color="maroon"><b><s:property value="exception" /></b></font>
	<br/>
	<font size="2"><b>Technical Details:</b></font><s:property value="exceptionStack" />   
  </div>
</center>

<br/><br/>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
