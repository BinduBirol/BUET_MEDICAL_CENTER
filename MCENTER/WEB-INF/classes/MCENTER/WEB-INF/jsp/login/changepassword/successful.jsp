<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Arrays"%>


<c:if test="${requestScope.message=='SUCCESS'}">
<font size="4" color="Green">
	<center> 
		 Password Successfully set....!!!
	</center>
</font>


<br/><br/> 
</c:if>

<c:if test="${requestScope.message=='ERROR1'}">
<font size="4" color="red">
<center> 
Something wrong try again ......!!!!
</center>
</font> 
<br/><br/><br/>  
</c:if>

<c:if test="${requestScope.message=='ERROR2'}">
<font size="4" color="red">
<center> 
Your given old password and previously saved password doesn't match ......!!!!
</center>
</font> 
<br/><br/><br/>  
</c:if>

<c:if test="${requestScope.message=='ERROR3'}">
<font size="4" color="red">
<center> 
Please fillup all password fields and give same new & retype password......!!!!
</center>
</font> 
<br/><br/><br/>  
</c:if>
