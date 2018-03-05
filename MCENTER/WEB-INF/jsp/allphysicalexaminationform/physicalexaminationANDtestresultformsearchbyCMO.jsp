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


<script lang="javascript">

	 $(function() { 
	 
	 		//$.validity.setup({outputMode:"summary"});
	 		
	 		var table = document.getElementById("testtable");               
	 		
                $("form").validity(function() {
                                         
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                                            
                      for(var i = 1; i < table.rows.length; i++) { 
                      
                      	//var stock =$("#stock_"+i).val();
                       testype =$("#testype_"+i).val();
                       alert(testype);
                       testype.equalCheck("-1","Select Generic Name");
                       
                       testid =$("#testid_"+i).val();
                       testid.equalCheck("0","Select Generic Name");
                       
                    /*     $("#testype_"+i)
                        	.equalCheck("-1","Select Generic Name");
                        
                        $("#testid_"+i)
                        	.equalCheck("0","Select Medicine Name");   */                      	
                        
                        $("#issueqty_"+i)
	                        .require()
	                        .match("integer")
	                        .range(1, $("#stock_"+i).val());
	                        //.lessThan( $("#stock_"+i).val());                        
                      
                      }
                     $('select[name^="testname"]')
                        .distinct("A Medicine Name is repeated.");
                        
                        
                });
            });

</script>

<script>
$(function () {
$( "#receiptNO" ).keyup(function() {
 
  
  var receiptNO= {
                        "receiptNUMBER": $("#receiptNO").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "searchpersonformedicalcheckupaction",
                        data: JSON.stringify(receiptNO),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#purpose").val(Adnan.purpose);
                             $("#receiptNOhidden").val(Adnan.receiptNUMBER);
                             $("#name").val(Adnan.name);
                              $("#designation").val(Adnan.designation);
                              $("#office").val(Adnan.department);
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 


$(function () {
$('#testlist').hide();

 $('#ok').click(function(){
 var txt = $('#receiptNO');
if (txt.val() != null && txt.val() != '') {
   $('#testlist').show();
  } 
 if (txt.val()==null && txt.val()=='') {
   $('#testlist').hide();
  } 
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
                    	
   <h1 align= center><font size="5" color="green">Search</font></h1>	
<fieldset class="additionForm">
	<br/>
		<legend>Medical Check up</legend>	
<s:form action="physicalexaminationANDtestresultfoundbyCMOaction" theme="xhtml"> 
<table align="center" style="border-spacing: 4px;">


<tr>
<td>
<s:textfield label="Receipt N0" id="receiptNO" name="receiptNO"/>

</td>
</tr>

<tr>
<td>
<s:textfield label="Purpose" id="purpose"/>

</td>
</tr>

 <tr>
<td>
<s:textfield label=" Name" id="name"   />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Designation" id="designation"  />
</td>
</tr>

<tr>
<td>
<s:textfield  label="Office" id="office" readonly="true"/>
</td>
</tr>

</table>
<center>
<s:submit id="ok"  value="OK"   theme="simple" align="center"  cssClass="btn btn-primary btn-large" />
</center>
</s:form>

		<br/>
	

</fieldset>	

<br/>                 	
 
 

  <!--Main content will be here--> 
                    
                      
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%> 
