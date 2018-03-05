<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	
	
	
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Karnaphuli Gas Distribution Company Limited</title>
    <link type="image/x-icon"  rel="icon"href="/MCENTER/resources/img/logo.png" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
  
    <link rel="stylesheet" href="/MCENTER/resources/css/prescription.css" type="text/css" />
    <script>
    function PrintPreview() {

        var toPrint = document.getElementById("me");

        var popupWin = window.open('', '_blank', 'width=350,height=150,location=no,left=200px');

        popupWin.document.open();

        popupWin.document.write('<html><title>::Print Preview::</title><link rel="stylesheet" type="text/css" href="/MCENTER/resources/css/prescription.css" media="screen"/> </head>')
       
           
        popupWin.document.write(toPrint.innerHTML);

        popupWin.document.write('</html>');

        popupWin.document.close();

    }
    </script>
</head>
<body>
<div id="me">
    <div class="wrap">
        <div class="wrapper">
        <div class="header">
            <center>
                <div class="logoCon">
                    <img src="/MCENTER/resources/img/logo.png" alt="" />
                </div>
                <div class="padCon">
                    <h2>Medical Center</h2>
                    <h3>Bangladesh University of Engineering &amp; Technology</h3>
                    <p>Dhaka-1000, Bangladesh</p>
                    <p>Tel:9665625, PABX: 9665650-80, 8614640-44, Ext:7344, Fax:880-8613026.</p>
                </div>
                <!--end padCon-->
            </center>
        </div>
        <!--end header-->
        <div class="mainBody">
         
            <h3 class="presCriptionHeading">Prescription </h3>
            <div class="flowrow borderB">
            	<table width="100%"  class="" id="dtl">
                <!--<s:iterator value="petientList">-->
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
                        
                        <td>
                        <b>Weight : </b>
                        <s:property value="Weight"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        <b>C/O :</b>
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
                 <!--</s:iterator>-->
            </table>
            </div>
            <!--end flowrow-->
            <div class="flowrow">
                <div class="oneThirdRow">
                	<table class="data" align="left" id="tablec" width="100%">		
                        <thead>
                        <tr>
                            <th align="left">C/C</th>			
                        </tr>
                        </thead>		    
                    <!-- <s:iterator value="ccinfo">-->
                        <tbody>
                            <tr>
                                <td> * <s:property value="ccname"/> <s:property value="cctype"/> <s:property value="comments"/></td>			            	            
                            </tr>
                        </tbody>
                     <!--</s:iterator>-->	    
                    </table>
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
                    <table class="data" align="left" id="tableoe" width="100%">		
                        <thead>
                        <tr>
                            <th align="left">OE</th>		
                        </tr>
                        </thead>
                        
                    <!--<s:iterator value="oeinfo">-->
                       <tbody>
                          <tr>
                            <td>* <s:property value="oename"/>: <s:property value="oecomments"/></td>		            	            
                          </tr>		
                       </tbody>
                    <!--</s:iterator>-->	    
                    </table>
                    <table class="" align="left" id="tableinv" width="100%">		
                        <thead>
                        <tr>
                            <th colspan="3" align="left">Investigations</th>		
                        </tr>
                       
                        </thead>		    
                    <!--<s:iterator value="testinfo">-->
                       <tbody>
                          <tr>
                            <td>* <s:property value="testypename"/>: <s:property value="testname"/> <s:property value="tstcomments"/> </td>
                                            
                          </tr>		
                       </tbody>
                    <!--</s:iterator>	-->	    
                    </table>
                    <table class="data" align="left" id="tablep" width="100%">
                        <thead>
                        <tr>
                            <th align="left">P/A/E</th>
                    
                        </tr>
                        </thead>
                        
                        <!--<s:iterator value="pinfo">-->
                            <tbody>
                            <tr>
                                
                                <td>* <s:property value="pcomments"/></td>
                                
                            </tr>
                            </tbody>
                        <!--</s:iterator>-->   
                        
                    </table>
                </div>
                <!--end oneThirdRow-->
                <div class="twoThirdRow">
                	<table class="data" align="left" id="tablem" width="100%">
                        <thead>
                    
                            <tr>
                                <th align="left">Rx</th>
                            </tr>
                    
                    
                        </thead>
                        
                        <s:iterator value="medicine">
                        <tbody> 
                            <tr>
                            <td><s:property value="genname"/></td>
                            <td><s:property value="drugname"/></td>
                            <td><s:property value="drgqty"/></td>
                            <td><s:property value="dose"/></td>
                            <td><s:property value="days"/></td>
                            </tr>
                    	</tbody>
                      	</s:iterator>  
                	</table>
                    <table class="data" align="left" id="tableadv" width="100%">
                        <thead>
                        <tr>
                            <th align="left">Advice</th>
                    
                        </tr>
                       
                        </thead>
                        
                        <s:iterator value="advinfo">
                            <tbody>
                            <tr>
                                
                                <td><s:property value="advcomments"/></td>
                                
                            </tr>
                            </tbody>
                        </s:iterator>   
                        
                    </table>
                </div>
                <!--end twoThirdRow-->
            </div>
            <!--end flowrow-->
        </div>
        <!--end mainBody--> 
        </div>
        <!--end wrapper-->
        <div class="footer">
        	<p>2014 &copy; BUET All rights reserved</p>
        </div>
        <!--end footer-->
    </div> 
    <!--end wrap-->
</div>
    
    <div>
    <input type="Button" value="print preview" onclick="PrintPreview()"/>
    </div>
                        
</body>
</html>
