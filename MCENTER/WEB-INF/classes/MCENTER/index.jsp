<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>BUET Medical Center</title>
    
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    
    
<script type="text/javascript" src="/MCENTER/resources/javascript/dojolib/dojo/dojo.js"	
djConfig="parseOnLoad: true,isDebug:false">
</script>
<link rel="stylesheet" href="/MCENTER/resources/css/main.css" type="text/css" />
    <script type="text/javascript" src="/MCENTER/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/MCENTER/resources/js/functions.js"></script>
    
<SCRIPT src="/MCENTER/resources/javascript/encryption/extended5.js"></SCRIPT>
<SCRIPT	src="/MCENTER/resources/javascript/encryption/fouriermultiply1.js"></SCRIPT>
<SCRIPT src="/MCENTER/resources/javascript/encryption/rsa2.js"></SCRIPT>
<SCRIPT src="/MCENTER/resources/javascript/util/util.js"></SCRIPT>
<script type="text/javascript">
  var SCdofouriermultiply = true;
  var ModInverse=new Array;
  var rsakeylength = null;
  
 function loadKey()
   {
    var i=0;
    var key = ""; 
 	var modulus = "";
 	var keylen = "", data; 
    dojo.xhrGet(
  			{
    			url: '/MCENTER/keyGeneration?date='+new Date(),
    			load: function(response, ioArgs)
    			{
    		     
    	   		 key = response.getElementsByTagName("key")[0].childNodes[0].nodeValue;
            	 modulus = response.getElementsByTagName("modulus")[0].childNodes[0].nodeValue;
            	 keylen = response.getElementsByTagName("keylen")[0].childNodes[0].nodeValue;
				 jsrsaenc(key,modulus,keylen);				      			
      			 return response;
    			},
    			error: function(response, ioArgs)
    			{
    				alert(response);
    				
      				alert("Query failed11");
      				return response;
    			},
    		handleAs: "xml"
  			});  
   }
  
	function jsrsaenc(key,mod,keylen)
	{	
		var ekey = key;
    	var modulus = mod;
    	var rsakeylength =keylen;
    	SCnumbersize = rsakeylength/16;
    
    	if(trim(document.getElementById('password1').value,"") != "")
    	{
			var message = intonum(document.getElementById('password1').value);	
			var e = hexnum(ekey);
			var m = hexnum(modulus);
			ModInverse = modulusinverse(hexnum(modulus),SCnumbersize);
			alert(ModInverse);
  			document.getElementById('password2').value = tohex1(modpowwithinverse(message,e,m,ModInverse,SCnumbersize),SCnumbersize);
  			alert(tohex1(modpowwithinverse(message,e,m,ModInverse,SCnumbersize),SCnumbersize));
    	} 
		
		document.forms[0].submit();	 
	}


</script>
	
</head>	
	<body>
		<%@page import="table.user.UserDTO"%>


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
                   
                </ul>
            </div>
			<div class="mainBody">
            
            <div class="leftMenu">

			</div>
                <!--end leftMenu--> 
               <div class="rightCon" align="center">
                    <div class="contentBox" align="right">
			
<table width="304" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td >
			<strong>User Login</strong>
		</td>
	</tr>
	<tr>
		<td>
			<table width="304" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="10">
					</td>
					<td width="275">
						<table width="175" border="0" cellspacing="5" cellpadding="0">
							<tr>
								<td class="style2">
									<table width="100%" border="0">
										<tr>
											<td width="20%" align="left" valign="middle" height="35px"
												style="font-size: 14px">
												<font color="#004D80">Userid:</font>
											</td>
											<td width="80%" align="left" valign="middle">
												<form action="/MCENTER/checkvalidity.action" method="post">
													<input  type="text" name="username" value='<s:property value="username" />'/>
													<input type="hidden" name="password" value=""
														id="password2">
												</form>
											</td>
										</tr>
										<tr>
											<td align="left" valign="middle" height="35px"
												style="font-size: 14px">
												<font color="#004D80">Password:</font>
											</td>
											<td align="left" valign="middle">
												<input class="loginInput" type="password" name="password"
													id="password1" />
											</td>
										</tr>
										<tr>
											<td height="50px"></td>
											<td>
												<input type="button" class="loginButton" value="Login"
													onclick="loadKey()" />
											</td>
										</tr>
										<tr>
											<td align="left" colspan="2">
												<div style="width: 180px; height: 25px; margin-left: 30px;">
													<font style="color: red; font-size: 11px;"><s:actionerror />
														<s:fielderror /> </font>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
</table>
</div></div></div></div></div>
	
<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
	