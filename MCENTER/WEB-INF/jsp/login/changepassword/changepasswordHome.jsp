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
						                          		
		 <button style="width:150px;" class="btn btn-info" data-color="rgb(255, 255, 255)" data-color-format="hex"  data-colorpicker-guid="4" onclick="FormSubmit()"  type="button">Change Password</button>		    			
		</td>
	</tr>
</table>
<center>
</fieldset>
</center>

<div id="successMessage"></div>
</center>
<script type='text/javascript' src="/MCENTER/resources/javascript/util/jquery.min.js"></script>
	
<script type="text/javascript">

    function FormSubmit() {

       if($("#oldpass").val()==""){
            alert("Please give old password");return false;
        }

        if($("#newpass").val()==""){
            alert("Please give new password");return false;
        }
        

        
/*          if(($("#gpa").val()=="")||parseFloat($("#gpa").val())>5.00||parseFloat($("#gpa").val())<1.00){
            alert("Give Valid SSC/Equivalent GPA.");return false;
        }
 */
        
         if($("#retypepass").val()==""){
            alert("Please give retype password.");return false;
        }
        
        if($("#retypepass").val()!=$("#newpass").val()){
            alert("New Password and Retype Password doesn't match.");return false;
        }
        

      //	alert($("#groupName").val());
        
        
             $('#successMessage').prepend($('<img>',{id:'theImg',src:'/MCENTER/resources/images/loading1.gif'}));

        $.ajax({
            type    : "POST",
            url     : "changePassword",
            dataType: 'text',
            async   : false,
            data    : {old_password: $("#oldpass").val().trim(),new_password: $("#newpass").val(),retypenew_password: $("#retypepass").val()}

        }).done(function (msg) {
                  $("#oldpass").val()=="";
                  $ ("#newpass").val()=="";
                  $ ("#retypepass").val()=="";

                  $('#successMessage').html('');
                   $("#successMessage").html(msg);
                })
                .always(function () {
                    //$('#sw-val-step-3').unmask();
                })
                .fail(function (data) {
                    if (data.responseCode)
                        alert(data.responseCode);
                });
        
                
      }
      

      

</script>	

<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

