<%@page import="java.util.ArrayList.*"%>
<%@page import="table.userrole.*"%>

<table width="204" border="0" align="center" cellpadding="0"
	cellspacing="0">
	
	<%
	    if(session.getAttribute("user_role") != null)
	    {
		UserRoleDTO urole = (UserRoleDTO) session.getAttribute("user_role");
		for (int i = 0; i < urole.getRolelist().size(); i++)
		{
			RoleOperationDTO rdto = (RoleOperationDTO) urole.getRolelist()
					.get(i);
			for (int j = 0; j < rdto.getOpearationlist().size(); j++)
			{
				OperationDTO opdto = (OperationDTO) rdto
						.getOpearationlist().get(j);
	%>

	<tr>
		<td height="28" background="/BMET/resources/images/button.gif"
			class="activityTd">
			
			<a href="<%=opdto.getLink() %>"> <%=opdto.getOperationdesc()%></a>
		</td>
	</tr>

	<%
		}
		}
		}
	%>
<tr>
		<td height="28" background="/BMET/resources/images/button.gif"
			class="activityTd">
			
			<a href="/BMET/changepassstep1">Change Password</a>
		</td>
</tr>
<tr>		
		<td height="28" background="/BMET/resources/images/button.gif"
			class="activityTd">
			
			<a href="/BMET/changeprofile1">Change Profile</a>
		</td>
	</tr>
</table>