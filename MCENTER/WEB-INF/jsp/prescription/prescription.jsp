
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link> 


<style type="text/css" media="screen">
    @import url("/MCENTER/resources/css/main.css");
    @import url("/MCENTER/resources/css/jquery-ui.css");
    @import url("/MCENTER/resources/css/tablecss.css");
    @import url("/MCENTER/resources/css/calcss.css");

    .contentBox {
        float: left;
        margin-top: 3px;
        width: 100%;
        margin-left: 0px;
    }

.fleft {
      float: left;
      width:100%;
      /* background:#C2DFFF; */
  }
.halfDiv {
      float: left;
      width:48%;
      padding: 0 1%;
      padding-bottom: 20px;
      /* background:#C2DFFF; */
  }
.oneThirdDiv {
      float: left;
      width:35%;
      padding: 0 1%;
      padding-bottom: 20px;
      border-right: solid 1px #999999;
}
.twoThirdDiv {
      float: left;
      width:60%;
      padding: 0 1%;
      padding-bottom: 20px;
      
}
.fleft table {
	margin-bottom: 15px;
}
    .fright {
        float: right;
        /*  background:pink; */
        width: 220px;
    }
    
.bDivider {
	float:left;
	margin-bottom:10px;
	border-bottom: solid 1px #777777;
}
</style>




<script type="text/javascript" src="/MCENTER/resources/js/functions.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/caljs.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/tableData/jquery.dataTables.js"></script>
<script>



function printPage(id)
{
   var html="<html>";
   html+= document.getElementById("me").innerHTML;

   html+="</html>";

   var printWin = window.open('','','left=0,top=0,width=600%,height=600%,toolbar=0,scrollbars=0,status  =0');
   printWin.document.write(html);
   printWin.document.close();
   printWin.focus();
   printWin.print();
   printWin.close();
}




 function PrintPreview() {

        var toPrint = document.getElementById("me");

        var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');

        popupWin.document.open();

        popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="Print.css" media="screen"/> </head><body">')
       
           
        popupWin.document.write(toPrint.innerHTML);

        popupWin.document.write('</html>');

        popupWin.document.close();

    }

$(document).ready(function(){
			$('#myTable').dataTable({
				"pagingType": "full_numbers"	
			});
			
		});	
		
		
		
function loadPdf(){
	document.getElementById('loginForm').action; 
	//document.getElementById('printPrescription').action = "pReport.action";
    //document.getElementById('loginForm').submit();
	
}		
function printPdf(){
	var pid  = document.getElementById('prescriptionid').value; 
	var doctorname  = document.getElementById('doctorname').value;
	//document.getElementById('printPrescription')= "pReport.action";
    //document.getElementById('loginForm').submit();
    window.location="pReport.action?prescriptionid="+pid+"&doctorname="+doctorname;
	
}		
		</script>


                <form id="loginForm" action="print" method="post">
                <s:hidden id="prescriptionid" name='prescriptionid' value="%{prescriptionid}"/>
                <s:hidden id="pid" name='patientid' value="%{patientid}"/> 
                <s:hidden id="vid" name='visitid' value="%{visitid}"/>
                <s:hidden id="doctorname" name='doctorname' value="%{doctorname}"/> 
                <h3 align="center"> Prescription for the patient:<s:property value="name"/> (<s:property value="patientid"/>)</h3>
                </br>
                 
                
                
                
 </br>
<div id="me"> 
<div class="fleft">
	<div class="fleft bDivider"> 
		<table width="100%"  class="" id="dtl">
            <s:iterator value="petientList">
                <tr>
                    <td >
                    <b>Name : </b>
                    <s:property value="name"/>
                    </td>
                    
                    <td>
                    <b>Age : </b>
                    <s:property value="age"/>
                    </td>
                    
                    <td>
                    <b>Sex : </b>
                    <s:property value="sex"/>
                    </td>
                    
                    </s:iterator>
                    
                    
                    
                    <td>
                    <b>Weight(kg) : </b>
                    <s:property value="weight"/>
                    </td>
                    <s:iterator value="petientList">
                </tr>
                <tr>
                    <td>
                    <b>D/O :</b>
                    <s:property value="careof"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <b>Designation :</b>
                    <s:property value="designation"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <b>Department :</b>
                    <s:property value="department"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    <b>Hall :</b>
                    <s:property value="hall"/>
                    </td>
                                                
                    <td>
                    <b>Room no : </b>
                    <s:property value="roomno"/>
                    </td>
                    
                    <td>
                    <b>Patient id :</b>
                    <s:property value="patientid"/>
                    </td>   
                    <td>
                    <b>visit id :</b>
                    <s:property value="visitid"/>
                    </td>            

                </tr>
             </s:iterator>
        </table>
	
	</div>
	
	<div class="oneThirdDiv">
		<div class="fleft">
		
			<table class="data" align="left" id="tablec" width="100%">		
			    <thead>
			    <tr>
			        <th align="left">C/C</th>			
			    </tr>
		    	</thead>		    
			 <s:iterator value="ccinfo">
		        <tbody>
			        <tr>
			            <td> * <s:property value="ccname"/> <s:property value="cctype"/> <s:property value="comments"/></td>			            	            
			        </tr>
		        </tbody>
			 </s:iterator>	    
			</table>
		</div>
		<div class="fleft">
			<table class="data" align="left" id="tableoe" width="100%">		
			    <thead>
			    <tr>
			        <th align="left">O/E</th>		
			    </tr>
			    </thead>
			    
			<s:iterator value="oeinfo">
			   <tbody>
			      <tr>
		            <td>* <s:property value="oename"/>: <s:property value="oecomments"/></td>		            	            
			      </tr>		
			   </tbody>
			</s:iterator>		    
			</table>
		</div>
		
		
		<div class="fleft">
			<table class="data" align="left" id="tabled" width="100%">		
			    <thead>
				    <tr>
				        <th align="left">Diagonosis</th>			
				    </tr>
			    	</thead>		    
			 <s:iterator value="dinfo">
		        <tbody>
			        <tr>
			            <td>* <s:property value="dname"/> <s:property value="dcomments"/></td>		            
			            	            
			        </tr>
		        </tbody>
			 </s:iterator>	    
			</table>
		</div>
		
		<div class="fleft">
			<table class="" align="left" id="tableinv" width="100%">		
			    <thead>
			    <tr>
			        <th colspan="3" align="left">Investigations</th>		
			    </tr>
			   
			    </thead>		    
			<s:iterator value="testinfo">
			   <tbody>
			      <tr>
		            <td>* <s:property value="testypename"/>: <s:property value="testname"/> <s:property value="tstcomments"/> </td>
		            	            
			      </tr>		
			   </tbody>
			</s:iterator>		    
			</table>
		</div>
		<div class="fleft">
			<table class="data" align="left" id="tablep" width="100%">
			    <thead>
			    <tr>
			        <th align="left">P/A/E</th>
			
			    </tr>
			    </thead>
			    
			    <s:iterator value="pinfo">
			        <tbody>
			        <tr>
			            
			            <td>* <s:property value="pcomments"/></td>
			            
			        </tr>
			        </tbody>
			    </s:iterator>   
			    
			</table>
		</div>
	</div>
	<!-- end oneThirdDiv -->
	<div class="twoThirdDiv">
		<div class="fleft"> 
			<table class="data" align="left" id="tablem" width="100%">
			    <thead>
			
			    <tr>
			        <th align="left">Rx</th>
			    </tr>
			
			
			    </thead>
			    
			    <s:iterator value="medicine">
			    <tbody>
			   			
			   			<tr>
				   			<td> * <s:property value="genname"/>- <s:property value="drugname"/>: <s:property value="drgqty"/> <s:property value="unit"/>,  <s:property value="dose"/>,  <s:property value="days"/></td>
			            </tr>
			
			       </tbody>
			 </s:iterator>  
		</table>
		</div>
		
		<div class="fleft"> 
			<table class="data" align="left" id="tablem2" width="100%">
			    <thead>
			
			    <tr>
			        <th align="left">Rx Outside Medicine</th>
			    </tr>
			
			
			    </thead>
			    
			    <s:iterator value="medicineout">
			    <tbody>
			   			
			   			<tr>
				   			<td> * <s:property value="genname"/>- <s:property value="drugname"/>: <s:property value="drgqty"/> <s:property value="unit"/>,  <s:property value="dose"/>,  <s:property value="days"/></td>
			            </tr>
			
			       </tbody>
			 </s:iterator>  
		</table>
		</div>
		
		
		<div class="fleft"> 
			<table class="data" align="left" id="tableadv" width="100%">
			    <thead>
			    <tr>
			        <th align="left">Advice</th>
			
			    </tr>
			   
			    </thead>
			    
			    <s:iterator value="advinfo">
			        <tbody>
			        <tr>
			            
			            <td>* <s:property value="advcomments"/></td>
			            
			        </tr>
			        </tbody>
			    </s:iterator>   
			    
			</table>
		</div>
	</div>
	<!-- end twoThirdDiv   onclick="PrintPreview()"-->
</div>

</div>

</br>
</br>
</br>
</br>
<input type="button" id="printPrescription" class="myButton" style="width: 140px;" value="Print Prescription" onclick="printPdf()"/>

<!--<a href="pReport.action" >
 Print Prescription
</a>

--></form>
 
  <%@include file="/WEB-INF/jsp/template/footer.jsp"%>