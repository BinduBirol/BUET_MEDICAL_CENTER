<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<link href="css/button.css" type="text/css" rel="stylesheet"/>	
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>

<script type="text/javascript" src="resources/MCENTER/js/functions.js"></script>

 <script type="text/javascript" src="/MCENTER/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/util/util.js"></script>
<link type="text/css" rel="stylesheet" href="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/MCENTER/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/caljs.js"></script>

<link href="/MCENTER/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css"/>


<script>
 /*
 jQuery(function(){
$.getJSON("activedoctor", function (res) {

});
});
 */
 $(function () {
 
 
 
      /*
           
            $.getJSON("dailydoctorinputaction", function(data){
        //data is an object.
        //data.data[0].uid
 
          });
           
           */
            
 
   $("#closeshift").click(function (){
           
                    var shift = {
                        "shift": $("#dutyHour").val()
                        
                    };              
                  
                    
                         $.ajax({
                   
                        url: "closeshiftaction",
                        data: JSON.stringify(shift),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: false,
                         error: function (msg) {
                         alert("Error");
                        // Error occurred in sending request
                      /*   showNotification({
                            message: "Oops! an error occurred.",
                            type: "error" ,// type of notification is error
                           // autoClose: true, // auto close to true
                           // duration: 5 // display duration
                        }); */
                    },
                    success: function (msg) {
                    var shiftclose=msg.shift;
                    alert("Shift"+" "+shiftclose+" "+" is successfully Closed");
                       /*  showNotification({
                            message: "Show Ajax result message here!",
                            type: "success", // type of notification is error/success/warning/information,
                           // autoClose: true, // auto close to true
                           // duration: 5 // message display duration
                        }); */
                    }
                            
                        
                    });
                       /*  error:function(XMLHttpRequest, textStatus, errorThrown){
                          alert("error="+XMLHttpRequest+" error2="+textStatus+" error3="+errorThrown);
                          }  */
                       
                            
                        
                    });
                    
                   
                    
               
        
       });
 
 
 
 
 
 
 

</script>

    
<style type="text/css" media="screen">
.additionForm {
	background-color:#F0F5F4; 
	width:300px;
	padding:10px 30px;
	font-family:arial;
	font-size:12px;
	border-color: #999999;
	margin:0 auto;
}
</style>  

                    	<!--Main content will be here-->
                    	
   <h1 align= center><font size="5" color="green">Close Current Shift</font></h1>	
<fieldset class="additionForm">
	<br/>
<!-- 		<legend>Close Shift</legend> -->	


<s:form theme="xhtml">
<table align="center" style="border-spacing: 4px;">
 <tr>
<td>

 <s:textfield theme="xhtml" label="Date" name="mediaBean.acquireDate" disabled="true"  type="text">
  <s:param name="value">
    <s:date name="new java.util.Date()" format="dd/MM/yyyy"/>
  </s:param>
</s:textfield>
</td>
 </tr> 
 

 <tr>
 <td>
  <s:select theme="xhtml" id="dutyHour" list="#{'9-12 AM':'Morning','3.30-5.30  PM':'Evening'}" label="Shift"/>
 </td>
 </tr>
 
 <tr>
 <td>
 &nbsp;
 </td>
 <td>
<s:submit id="closeshift"  value="Close Shift"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</td>
 </tr>

</table>


 </s:form>



		<br/>
	

</fieldset>	

<br/>                 	
 
 

  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
