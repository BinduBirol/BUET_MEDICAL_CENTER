<%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/css/table1.css" type="text/css"></link>	
<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>
<script type="text/javascript" src="/MCENTER/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

    <title>BUET Medical Center</title>
    <link type="image/x-icon"  rel="icon"href="resource/img/logo.png" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="resource/css/main.css" type="text/css" />
    <script type="text/javascript" src="resource/js/jquery-1.9.1.min.js"></script>
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
<link href="css/button.css" type="text/css" rel="stylesheet"/>	

<!-- <script lang="javascript">
function showNotification(){
                            message= "Show Ajax result message here!",
                            type="success"; // type of notification is error/success/warning/information,
                           autoClose= true; // auto close to true
                           duration= 5000 ;// message display duration
                        };
</script>
 -->
 <script>
  $(function () {
   $("#deactive").click(function (){
      
      
            
	       
              //  $('#deactive').html('');
                    var activeDoctor = {
                        "activeDoctorName": $("#activedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "deactivedoctoraction",
                        data: JSON.stringify(activeDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: false, 
                        success: function (msg) {
                    var doctor=msg.doctorName;
                    if(doctor==null){
                    alert(msg.message);
                    }
                    else{
                    alert(doctor+" "+" is successfully deactivated");
                    
                    }
                        
                        
                        /* showNotification({
                            message: "Show Ajax result message here!",
                            type: "success", // type of notification is error/success/warning/information,
                           autoClose: true, // auto close to true
                           duration: 5000 // message display duration
                        }); */ 
                    }
                    
               /*      $.getJSON("jsonactivedoctoraction", function (res) {

                                        });   */ 
                    
             });   
             }); 
         });

</script>
 <script>
  $(function () {
  
  


 
    /*   $("#deactive").click(function (){
      
      
            
	       
              //  $('#deactive').html('');
                    var activeDoctor = {
                        "activeDoctorName": $("#activedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "deactivedoctoraction",
                        data: JSON.stringify(activeDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: false,
                        success: function (msg) {
                        showNotification({
                            message: "Show Ajax result message here!",
                            type: "success" // type of notification is error/success/warning/information,
                           //autoClose: true, // auto close to true
                           // duration: 5 // message display duration
                        });
                    }
                    
               /*      $.getJSON("jsonactivedoctoraction", function (res) {

                                        });   
                    
             });   
             });   */
             
             
              $("#active").click(function (){
      
      
            
	       
                $('#active').html('');
                    var deactiveDoctor = {
                        "deactiveDoctorName": $("#deactivedoctor").val()
                        
                    };
                    
                         $.ajax({
                    
                        url: "reactivedoctoraction",
                        data: JSON.stringify(deactiveDoctor),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async:false,
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
                            type: "success" ,// type of notification is error/success/warning/information,
                            autoClose: true, // auto close to true
                            duration:10000 // message display duration
                        }); */ 
                    }
                            
                        
                    });
                    
                 /*    $.getJSON("jsonactivedoctoraction", function (res) {

                                        });   */
                    
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
                    	
                    	
  
 




   <h1 align= center><font size="5" color="green">Active Doctors</font></h1>
   <br/>
  <fieldset class="additionForm">
	
		<legend>Available Dictors</legend>	
<br/>		
<s:form >
<table align="center" style="border-spacing: 4px;" >
<tr>
<td>

 <s:textfield  label="Date" name="mediaBean.acquireDate" disabled="true"  type="text" theme="xhtml">
  <s:param name="value">
    <s:date name="new java.util.Date()" format="dd/MM/yyyy"/>
  </s:param>
</s:textfield>
</td>
 </tr>
 
 
 <tr>
<td>

 <s:select theme="xhtml" id="activedoctor" name="doctorsName"  label="Active Doctor" list="list" headerKey="-1" headerValue="Select Doctor" listKey="doctorId" listValue="doctorName"/>
 

 </td>
 </tr>
 
 <tr>
<td>
  &nbsp;
 </td>
 
<td>
<s:submit   id="deactive" value="Deactive" theme="simple" cssClass="btn btn-primary btn-large" />
 </td>
 </tr>
 
  <tr>
 <td>

 
 <s:select  theme="xhtml" id="deactivedoctor" name="deactivedoctorsName"  label="Deactive Doctor" list="deactivedoctorlist" headerKey="-1" headerValue="Select Doctor" listKey="deactivedoctordoctorId" listValue="deactivedoctordoctorName"/>

 </td>
</tr>
 
  <tr>
<td>
  &nbsp;
 </td>
 
<td>
<s:submit  id="active" value="Active" onclick="showNotification()" theme="simple" cssClass="btn btn-primary btn-large" />
 </td>
 </tr>
  
</table>



 </s:form>
 </fieldset>       	
                    	
                 	
 <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%>  

