<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<style>
input {
	font-family: Verdana, Geneva, Arial, Helvetica, Sans-Serif;
	font-size: 10px;
	border: 1 solid #000000
}
#changepass td
{
  padding:3px;
} 
</style>

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
      				alert("Query failed");
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
    
    	if(trim(document.getElementById('oldpass').value,"") != "")
    	{
			var message = intonum(document.getElementById('oldpass').value);	
			var e = hexnum(ekey);
			var m = hexnum(modulus);
			ModInverse = modulusinverse(hexnum(modulus),SCnumbersize);
  			document.getElementById('oldpassword').value = tohex1(modpowwithinverse(message,e,m,ModInverse,SCnumbersize),SCnumbersize);
    	} 
		
		if(trim(document.getElementById('newpass').value,"") != "")
    	{
			var message = intonum(document.getElementById('newpass').value);	
			var e = hexnum(ekey);
			var m = hexnum(modulus);
			ModInverse = modulusinverse(hexnum(modulus),SCnumbersize);
  			document.getElementById('newpassword').value = tohex1(modpowwithinverse(message,e,m,ModInverse,SCnumbersize),SCnumbersize);
    	} 
    	
    	if(trim(document.getElementById('retypepass').value,"") != "")
    	{
			var message = intonum(document.getElementById('retypepass').value);	
			var e = hexnum(ekey);
			var m = hexnum(modulus);
			ModInverse = modulusinverse(hexnum(modulus),SCnumbersize);
  			document.getElementById('newpasswordretype').value = tohex1(modpowwithinverse(message,e,m,ModInverse,SCnumbersize),SCnumbersize);
    	} 
		
		document.forms[0].submit();	 
	}


  </script>

<table width="99%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
<td align="left">
<div style="border-left:6px solid #76AE00;padding-left:10px; height: 40px;float: left;padding-top: 5px;margin-top: -5px;">
  <font style="font: normal 24px Times, serif">Change Password</font>	
</div>
</td>
</tr>
</table>
<br/>
<form action="/MCENTER/changepassword" method="post">
	<s:token />
	<input type="hidden" name="password.oldpassword" id="oldpassword"
		value="" />
	<input type="hidden" name="password.newpassword" id="newpassword"
		value="" />
	<input type="hidden" name="password.newpasswordretype"
		id="newpasswordretype" value="" />
</form>
<center>
<fieldset style="width: 350px">
<legend style="font-size: 14px;font-weight: bold;font-family: courier">Change Password</legend>
<table style="width: 100%;padding: 5px" id="changepass">
	<tr>
		<td width="35%" align="right">
			User Name
		</td>
		<td width="35%" align="left">
			:<b><%=((UserRoleDTO) session.getAttribute("user_role"))
							.getUsername()%></b>
		</td>
		<td width="30%">
		</td>
	</tr>
	<tr>
		<td align="right">
			Old Password
		</td>
		<td>
			<input type="password" id='oldpass' />
		</td>
		<td>
			<font color="red"><s:property value="password_err.oldpassword" />
			</font>
		</td>
	</tr>
	<tr>
		<td align="right">
			New Password
		</td>
		<td>
			<input type="password" id="newpass" />
		</td>
		<td>
			<font color="red"><s:property value="password_err.newpassword" />
			</font>
		</td>
	</tr>
	<tr>
		<td align="right">
			Retype password
		</td>
		<td>
			<input type="password" id="retypepass" />
		</td>
		<td>
			<font color="red"><s:property
					value="password_err.newpasswordretype" />
			</font>
		</td>
	</tr>
	<tr style="height: 40px">
		<td colspan="3" style="vertical-align: bottom" align="center" >
			<input type="button"  class="groovybutton" onMouseOver="goLites(this.name)" onMouseOut="goDims(this.name)"  onclick="loadKey()" value="Change Password" name="passwordChangButton">
		</td>
	</tr>
</table>
</fieldset>
</center>

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

