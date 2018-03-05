<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<script type="text/javascript" src="http://jsearchdropdown.sourceforge.net/jquery-1.7.1.min.js"></script>  
<script type="text/javascript" src="http://jsearchdropdown.sourceforge.net//jquery.searchabledropdown.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            $("select").searchable();
        });
  </script>

<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

    <title>BUET Medical Center</title>
    <link type="image/x-icon"  rel="icon"href="resource/img/logo.png" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="resource/css/main.css" type="text/css" />
<!--     <script type="text/javascript" src="resource/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resource/js/functions.js"></script>
    
    <link rel="stylesheet" href="css/table1.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />

<script src="js/jQuery.js" type="text/javascript"></script>
 <script src="js/jquery1.4.4min.js"></script>
<script src="js/jquery.min.js"></script> 
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery-ui.js"></script>
<link rel="stylesheet" href="js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="js/jquery_v_1.4.js"></script>
<script type="text/javascript" src="js/jquery_notification_v.1.js"></script>	
<link href="css/jquery_notification.css" type="text/css" rel="stylesheet"/>	
-->
<link href="css/button.css" type="text/css" rel="stylesheet"/>	 




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
            
 
   $("#save").click(function (){
              //  var aa=$("#doctor option:selected").text();
	            //alert(aa);
	      
				   
           
	       
               $('#save').html(''); 
                
                    var arr = {activeDoctorName:$("#doctor").val(),dutyHour:$("#dutyHour").val()};               
                  
                    //alert ($("#dutyHour").val());
                         $.ajax({
                   
                        url: "saveActiveDoctoraction",
                        data: JSON.stringify(arr),
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
                    var doctor=msg.doctorName;
                    if(doctor==null){
                    alert(msg.message);
                    }
                    else{
                    alert(doctor+" "+" is successfully activated");
                    
                    }
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
                    	
                    	
  <br/>  
   <h1 align= center><font size="5" color="green">Daily Doctor Duty Confirmation</font></h1>
  <br/> 
<fieldset class="additionForm">  
<legend>&nbsp Activate Doctors &nbsp</legend>
<s:form >
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

 <s:select theme="xhtml" id="doctor" name="doctorsName"  label=" Available Doctors" list="list" headerKey="-1" headerValue="Select Doctor" listKey="doctorId"  listValue="doctorName"/>


 </td>
 </tr>
 
 
 <tr>
 <td>
   
 
   <s:select theme="xhtml" id="dutyHour" list="#{'9-12 AM':'Morning','3.30-5.30  PM':'Evening'}" label="Duty Hour"/> 
   <!-- <label for="dutyHour" class="xhtml">
       Duty Hour
   </label>
   <select name="dutyHour" id="dutyHour">    
    <option value="9-12 AM">Morning</option>
    <option value="3.30-5.30  PM">Evening</option>    
   </select> -->
   
   
 </td>
 </tr>
 
 <br/>
 <tr>
 <td>
  <label for="first_name"></label>
 </td>
 <td>
 <s:submit id="save" value="Active" theme="simple" cssClass="btn btn-primary btn-large" />
 <s:submit action="activedoctoraction" value="See Active Doctors" theme="simple" cssClass="btn btn-small" />

 </td>
 </tr>

</table>


 </s:form>
 </fieldset>
 
 <div>
 <s:property  value="message"  />
 </div>
                 	
 <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  
