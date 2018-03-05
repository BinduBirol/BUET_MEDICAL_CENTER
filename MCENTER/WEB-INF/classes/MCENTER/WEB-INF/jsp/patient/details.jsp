 <%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>


<style type="text/css" media="screen">
.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	-webkit-box-shadow:inset 0px 1px 0px 0px #97c4fe;
	box-shadow:inset 0px 1px 0px 0px #97c4fe;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #3d94f6), color-stop(1, #1e62d0));
	background:-moz-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-webkit-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-o-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:-ms-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
	background:linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#3d94f6', endColorstr='#1e62d0',GradientType=0);
	background-color:#3d94f6;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;
	border-radius:3px;
	border:1px solid #337fed;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:13px;
	padding:6px 18px;
	text-decoration:none;
	text-shadow:0px 1px 0px #1570cd;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #bc3315), color-stop(1, #d0451b));
	background:-moz-linear-gradient(top, #bc3315 5%, #d0451b 100%);
	background:-webkit-linear-gradient(top, #bc3315 5%, #d0451b 100%);
	background:-o-linear-gradient(top, #bc3315 5%, #d0451b 100%);
	background:-ms-linear-gradient(top, #bc3315 5%, #d0451b 100%);
	background:linear-gradient(to bottom, #bc3315 5%, #d0451b 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#bc3315', endColorstr='#d0451b',GradientType=0);
	background-color:#bc3315;
}
.myButton:active {
	position:relative;
	top:1px;
}

</style>

                
                 <table align="center" width="80%" class="display dataTable">

                    <s:iterator value="patientdtl">

                        <tr>
                            <th>Name</th>
                            <td><s:property value="name"/></td>                           
                        </tr>
                        <tr>
                            <th>Designation</th>
                            <td><s:property value="designation"/></td>
                        </tr>
                        <tr>
                            <th>Department</th>
                            <td><s:property value="department"/></td>
                        </tr>
                        <tr>
                            <th>Sex</th>
                            <td><s:property value="sex"/></td>
                        </tr>
                        <tr>
                            <th>Patient id</th>
                            <td><s:property value="patientid"/></td>
                        </tr>
                        <tr >
                            <th rowspan="12">image</th>
                            <td  rowspan="12"> 
							<img src="/mcenter/resources/image/<s:property value="patientid"/>.jpg"  width="150" height="180"  border="1" />
                            
                            </td>
                        </tr>
						
						<tr>
                       
					</tr>

                    </s:iterator>


                </table>
                </br>
               <div> 
              <div style="float: left"> 
              
                <form  action="prescription" method="post">
                <s:hidden id="name" name='name' value="%{name}"/>
                <s:hidden id="patientid" name='patientid' value="%{patientid}"/>
                <s:hidden id="visitid" name='visitid' value="%{visitid}"/> 
                <s:hidden id="visidate" name='visidate' value="%{visidate}"/> 
                <input type="submit" class="myButton" style="width: 140px;" value="Create prescription"/>
                </form>
                
                 
                
              </div> 
              
              
              
               <div style="float: right">  
                   <form action="previouspatienthistorylist" method="post">
                <s:hidden id="patientid" name='patientid' value="%{patientid}"/>
                <s:hidden id="visitid" name='visitid' value="%{visitid}"/> 
                <s:hidden id="visidate" name='visidate' value="%{visidate}"/> 
                <input type="submit" class="myButton" style="width: 140px;" value="Previous History"/>
                </form>
              </div>  
                        </div><!--  
                
                
              <div> 
              <div style="float: left"> 
              <s:url action="prescription.action" var="detail">              				
                            <s:param name="patientid" value="patientid"></s:param>
                            <s:param name="visitid" value="visitid"></s:param>
                            <s:param name="visidate" value="visidate"></s:param>                             
                        </s:url>
                        <s:a href="%{detail}"><u><strong>Create prescription</u></strong></s:a>
                  </div>      
                     <div style="float: right">    
                        <s:url action="previouspatienthistorylist.action" var="previousHistory">              				
                            <s:param name="patientid" value="patientid"></s:param>
                            <s:param name="visitid" value="visitid"></s:param>
                            <s:param name="visidate" value="visidate"></s:param>                             
                        </s:url>
                        <s:a href="%{previousHistory}"><u><strong>Previous History</u></strong></s:a>
                      </div>  
                        </div>
                
             
                --><!--end contentBox-->
            
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
 
    <!--end footer-->


