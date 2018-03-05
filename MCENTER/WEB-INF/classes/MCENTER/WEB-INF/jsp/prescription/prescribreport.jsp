
<%@ taglib uri="/WEB-INF/pd4ml.tld" prefix="pd4ml"%>


<pd4ml:transform
	screenWidth="950" pageFormat="A4" pageOrientation="LANDSCAPE" 
	pageInsets="10,10,15,10,points"  enableTableBreaks="true" authorName="Toraf"
	fileName="Lager.pdf" inline="false">
	
	
<pd4ml:footer  
    pageNumberTemplate=" "  
    titleAlignment="left"  
    pageNumberAlignment="right"  
    color="#008000"  
    initialPageNumber="1"     
    fontSize="10"  
    areaHeight="12"/> 
	
<pd4ml:page.break htmlwidth="295" />




<html>
<head>
<style type="text/css">
				.tblmed {
					border-collapse: collapse;
					border: 1px solid gray;
					font-size: 12px;
					margin-bottom: 3px;
					margin-left: 30px;
					color: black;
				}
				
				.tblmed th {
					border: 1px solid gray;
					padding: 3px 5px 3px 5px;
					
				}
				
				.tblmed td {
					border: 1px solid gray;
					padding: 15px 15px 15px 15px;
					font-size: 13px;
					
				}
				
				.tblmed th {
					color: black;
					text-align: center;
					margin: 0 auto;
					padding-right: 3px;
				}
				
				.tblcaption{
					border: 0;
					margin-left:50px;
					font-size: 11px;
					font-weight: bold;
					text-align:left;
				}	
				
	</style>

</head>

<%
 
%>


<bean:define id="offname" name="offname" type="java.lang.String"/>
<bean:define id="startdate" name="startdate" type="java.lang.String"/>

<bean:define id="enddate" name="enddate" type="java.lang.String"/>



<table width="100%" align="center"  style="margin-left: 30px;">

<tr>
	<th align="center">
		<img	src="../../../resource/images/blogo.GIF" height="20" width="60" border="0"  alt="" />
		<font size="4">Medical Center,BUET</font>
	</th>
</tr>

<tr>
	<th align="center" >
		<font size="2">Palashi, Dhaka</font>
	</th>
</tr>

<tr>
	<th align="center"  >
		<font size="3"><u>Prescription of </u>   </font>
	</th>
</tr>
</table>
<br>
<br>
<br>


<table  id="tbindv" class="tblmed" width="100%" style="border-collapse: collapse;">

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
                     </s:iterator>
                </table>





<br>
<br>


<table align="center" id="tbindv" class="tblmed" width="100%" style="border-collapse: collapse;">

			<tr>		
				
				<td width="40%">
				<table align="center" id="tbindv" class="tblmed" width="87%" style="border-collapse: collapse;">		
				    <thead>
				    <tr>
				        <td colspan="2">OE</td>		
				    </tr>
				    <tr>
				        <th>OE Name</th>
				        <th>Comments</th>	
				    </tr>
				    </thead>
		    
		<s:iterator value="oeinfo">
		   <tbody>
		      <tr>
	            <td><s:property value="oename"/></td>
	            <td><s:property value="oecomments"/></td>		            
		      </tr>		
		   </tbody>
		</s:iterator>		    
		</table>	
				</td>
				<td width="60%">
					
				</td>			
				
		</tr>	
			
		
		
		
</table>	



</html>
</pd4ml:transform>

    



