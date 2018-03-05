<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.ArrayList.*"%>
<%@page import="table.userrole.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>BUET Medical Center</title>
    
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="/MCENTER/resources/css/main.css" type="text/css" />
    <script type="text/javascript" src="/MCENTER/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/MCENTER/resources/js/functions.js"></script> 
</head>
<body>
    <div class="wrap">
        <div class="wrapper">
            <div class="header">
            	<a href="http://www.buet.ac.bd" target="_blank"><img class="headerLogo" src="/MCENTER/resources/img/logo.png" width="110" alt="" /></a>
                <big class="caption">Medical Center, BUET</big>
                <img class="stethoscope" src="/MCENTER/resources/img/stethoscope.png" width="120" alt="" />
            </div>
            <!--end header--> 
            
            <div class="horizonMenu">
                <ul>
                	<li>
                    	<a href="http://www.buet.ac.bd/">BUET Home</a>
                    </li>
                    <li class="marginL145">
                    	<a href="#">Home</a>
                    </li>
                    <li>
                    	<a href="#">Contact Us</a>
                    </li>
                    <li>
                    	<a href="changepassstep1.action">Change Password</a>
                    </li>
                    <li>
                    	<a href="logout.action">Log Out</a>
                    </li>
                </ul>
            </div>
            <!--end horizonMenu--> 
            
            <div class="mainBody">
            
             <div class="leftMenu">
             	   <ul>
             
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
                              
                        <li><a href="<%=opdto.getLink() %>"> <%=opdto.getOperationdesc()%></a></li>
                       
<%
		}
		}
		}
%>               
                                          
                    </ul>
                    
                </div>
                <!--end leftMenu--> 
               <div class="rightCon">
                    <div class="contentBox">
                    
                    
                    
                    
                    
                    
                    
                    
                    
                 