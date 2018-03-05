<%@include file="/WEB-INF/jsp/template/head.jsp"%>



<script type="text/javascript" src="/MCENTER/resources/javascript/dojolib/dojo/dojo.js"	
djConfig="parseOnLoad: true,isDebug:false">
</script>



<table border="0" width="90%" align="center" cellpadding="0" cellspacing="0">
 <tr>
  <td align="center" colspan="2">
  <%if(((UserRoleDTO) session.getAttribute("user_role")).getHasphoto().equalsIgnoreCase("yes")) {%>
  <img src="/MCENTER/resources/userimages/<%=((UserRoleDTO) session.getAttribute("user_role")).getUsername()%>.jpg"  width="150" height="180"  border="1" />
  <%}else{ %>
  <img src="/MCENTER/resources/images/noimageuser.png" height="150" width="150"  border="1" />
	<%} %>
  
  </td>
 <tr>
  <td height="25px" colspan="2">
  </td>
 </tr>
 <tr>
  <td align="right" width="40%" height="30px"><b>User Name:</b>
  </td >
  <td align="left" width="60%" style="padding-left: 10px">
	<%=((UserRoleDTO) session.getAttribute("user_role")).getUserfullname()%>
  </td>
 </tr>
 
 <tr>
  <td align="right" width="40%" height="30px"><b>Designation:</b>
  </td>
  <td align="left" width="60%" style="padding-left: 10px">
  <%=((UserRoleDTO) session.getAttribute("user_role")).getUserdesignation()%>
  
  </td>
 </tr>
 
</table>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
