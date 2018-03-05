<%@include file="/WEB-INF/jsp/util/template/topAfterLogin.jsp"%>
<script type="text/javascript"
	src="/BMET/resources/javascript/util/util.js"></script>

<script type="text/javascript">
 
 var rlcount = 0;
</script>

<script type="text/javascript"
	src="/BMET/resources/javascript/module/complainmanagement/complainfrom.js"></script>

<table width="95%" align="center">
	<tr>
		<td align="center">
			<b>Complaint Form (Against Recruiting Agent)</b>
		</td>
	</tr>

</table>
<br />

<form action="/BMET/insertComplain.action" method="post" id="mainform"
	title="/BMET/insertComplain.action">
	<fieldset style="width: 95%">
		<legend>
			<b>1. Complain ID</b>
		</legend>
		<br />
		<table width="95%">
			<tr>
				<td width="15%">
					Complain ID
				</td>
				<td width="35%">
					<input name="complainid" type="text" id="complainid" />
				</td>
				<td width="15%">
					Complain Date
				</td>
				<td width="35%">
					<input dojoType="dijit.form.DateTextBox" name="complaindate"
						style="width: 105px; height: 18px; text-align: center; font-size: 14px;"
						constraints="{datePattern:'dd-MMM-yyyy'}" lang="en-us"
						required="true" promptMessage="dd-MMM-yyyy"
						invalidMessage="Invalid date. Please use dd-MMM-yyyy format."
						id="complaindate" isValid="customIsValid" />
				</td>
			</tr>
			<tr>
				<td colspan="4">
					*Complain ID format should be "C MM yyyy serial" containing no
					space.
				</td>
			</tr>
		</table>
	</fieldset>

	<br />
	<br />
	<fieldset style="width: 95%">
		<legend>
			<b>2. Complainant Information</b>
		</legend>
		<br />
		<table width="100%">

			<tr>
				<td width="25%">
					(a) Name of the Complainant
				</td>
				<td width="75%">
					<input type="text" name="complainantname" style="width: 250px"
						id="complainantname" />
				</td>
			</tr>
			<tr>
				<td>
					(b) Father's name&nbsp;
				</td>
				<td width="27%">
					<input type="text" name="complainantfathersname"
						style="width: 250px" id='complainantfathersname' />
				</td>
			</tr>
			<tr>
				<td colspan="1">
					(c) Complainant Address
				</td>
				<td colspan="3">
					<input type="text" name="complainantaddress" style="width: 310px"
						id='complainantaddress' />
				</td>
			</tr>
			<tr>
				<td>
					(d) District
				</td>

				<td>
					<select name="complanaintdistrict"
						onchange="findThana(this.options[this.selectedIndex].value)"
						id="complanaintdistrict">
						<option>
							Select a District
						</option>
						<s:iterator value="district">
							<option value="<s:property value="DIST_ID"/>">
								<s:property value="DIST_NAME" />
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					(e) Thana&nbsp;
				</td>
				<td>
					<select name="complanaintthana" id="complainantthana">
						<option>
							Select a Thana
						</option>

					</select>
				</td>
			</tr>
			<tr>
				<td>
					(f) Mobile/ Phone
				</td>
				<td>
					<input type="text" name="complainantmobile" style="width: 250px"
						id="complainantmobile" />
				</td>
			</tr>
			<tr>
				<td>
					(g) Email&nbsp;
				</td>
				<td>
					<input type="text" name="complainantemail" style="width: 250px" />
				</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<br />

	<fieldset style="width: 95%">
		<legend>
			<b>3. Recruiting Agency Information</b>
		</legend>
		<br />
		<table width="100%">
			<tr>
				<td width="80%" align="right">
					<a href="#" onclick="return addComplainaintRL(this);">(+)Add RA</a>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<table width="80%" bordercolor="#F3DB00;" 
						style="border: 1px solid; color: #F3DB00; background-color: #FEFEFA;">
						<tr>
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td width="20%">
								(a) RL No.
							</td>
							<td width="80%">
								<input type="text" name="rlno" id="rlno0" />
								&nbsp;&nbsp;
								<input type="button"
									onclick="findradetails(document.getElementById('rlno0').value,'0')"
									value="Find RA Details" />
							</td>
						</tr>
						<tr height="30">
							<td>
								(b) RA Name
							</td>
							<td id="raname0">
							</td>
						</tr>
						<tr height="30">
							<td>
								(c) RA Address
							</td>
							<td id="raaddress0"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<br />

	<fieldset style="width: 95%">
		<legend>
			<b>4. Your Complain (please tick the appropriate checkboxes or
				specify in shorts)</b>
		</legend>
		<br />
		<table width="100%">
			<tr>
				<s:iterator value="complain" status="stat">
					<tr>
						<td width="5%">
							<input type="checkbox" name="complaintype"
								value="<s:property value='complaincode'/>"
								onclick="showComplainDetails('<s:property value="#stat.index"/>')">
						</td>
						<td width="25%">
							<s:property value="complainname" />

						</td>
						<td width="60%">
							<div style="display: none; clear: left" name="sidenote">
								<table width="100%">
									<tr>
										<td width="75%" valign="middle">
											<input type="text" name="complaindetails"
												style="width: 300px; display: none">											
										</td>
										<td width="25%">
											<font style="font-size: 10px; color: blue">(Details if
												appropriate)</font>
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</s:iterator>
				<td>
					<input type="checkbox" name="complaintype" value="100"
						id="otherscomplain">
				</td>
				<td>
					Others (Specify in short)&nbsp;&nbsp;

				</td>
				<td>
					&nbsp;<input type="text" name="otherscomplain" style="width: 300px"
						onfocus="document.getElementById('otherscomplain').checked = true;"
						id="other" />
				</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<br />
	<fieldset style="width: 95%;">
		<legend>
			<b>5. Employer/ Sponsor Information</b>
		</legend>
		<br />
		<table width="100%">
			<tr>
				<td width="35%">
					(a) Name Of country/ destination
				</td>
				<td width="65%">
					<select name="employercountry">
						<option>
							Select a Country
						</option>
						<s:iterator value="country">
							<option value="<s:property value='country_code'/>">
								<s:property value="country_name" />
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					(b) Name of the employer/ sponsor
				</td>
				<td>
					<input type="text" name="employername" style="width: 250px" />
				</td>
			</tr>
			<tr>
				<td>
					(c) Adderess of the Employer
				</td>
				<td>
					<input type="text" name="employeraddress" style="width: 350px" />
				</td>
			</tr>
			<tr>
				<td>
					(c) Contact no of the Employer
				</td>
				<td>
					<input type="text" name="employercontactno" style="width: 350px" />
				</td>
			</tr>
		</table>
	</fieldset>

	<br />
	<br />
	<fieldset style="width: 95%">
		<legend>
			<b>6. Information of the affected persons (including the
				applicant if affected)</b>
		</legend>
		<br />
		<table width="100%" class="cust">
			<tr>
				<td align="center" width="14%">
					Passport No.
				</td>
				<td align="center" width="10%">
					Reg No.
				</td>
				<td align="center" width="23%">
					Name
				</td>
				<td align="center" width="23%">
					Father's name
				</td>
				<td align="center" width="26%">
					Address
				</td>
				<td align="center" width="4%">
					<a href="#" onclick="return addAffectedperson(this)">Add</a>
				</td>
			</tr>
		</table>
	</fieldset>
	<br />
	<br />
	<table width="90%">
		<tr>
			<td width="100%" align="center">
				<input type="button" value="Save" onclick="validate();" />
			</td>
		</tr>
	</table>

</form>
<br />
<br />


<div dojoType="dijit.Dialog" id="dialog1"
	title="<font style='font-size: 13px;color: blue;'>Successful</font>"
	execute="dijit.byId('dialog1').hide(); window.location = '/BMET/complainlistforupdate.action';"
	style="width: 400px">

	<table class="cust" width="100%" id="deleteheir"
		style="border-color: red; border: 1">
		<tr>
			<td align="center">
				<font style="font-size: 13px; color: red;">
					<div id='successmsg'></div> </font>
			</td>
		</tr>
	</table>
	<br>
	<table width="100%">
		<tr>

			<td colspan=2 align="center" width="100%">

				<button dojoType="dijit.form.Button" type="submit">
					Ok
				</button>

				<button dojoType="dijit.form.Button" type="button"
					onclick="window.location='/BMET/complainstep1.action'">
					Enter another Complain
				</button>
			</td>
		</tr>
	</table>

</div>

<div dojoType="dijit.Dialog" id="dialog2"
	title="<font style='font-size: 13px;color: red;'>Error</font>"
	execute="dijit.byId('dialog2').hide()" style="width: 400px">

	<table class="cust" width="100%" id="deleteheir"
		style="border-color: red; border: 1">
		<tr>
			<td align="center">
				<font style="font-size: 13px; color: red;">
					<div id='alertmsg' align="center"></div> </font>
			</td>
		</tr>
	</table>
	<br>
	<table width="100%">
		<tr>

			<td colspan=2 align="center" width="100%">

				<button dojoType="dijit.form.Button" type="submit">
					Ok
				</button>

			</td>
		</tr>
	</table>
</div>

<script type="text/javascript">
 dojo.require("dijit.form.DateTextBox");
 dojo.require("dijit.Dialog");
 dojo.require("dijit.form.Button");
</script> 
<%@include file="/WEB-INF/jsp/util/template/footer.jsp"%>