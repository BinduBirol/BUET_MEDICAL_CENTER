 <%@include file="/WEB-INF/jsp/template/head.jsp"%>	

<link rel="stylesheet" href="/MCENTER/resources/css/style/tablecss.css" type="text/css"></link>	
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
<link href="css/button.css" type="text/css" rel="stylesheet"/>

<!-- bindu -->
<script>
$(function () {
$( "#patientname" ).blur(function() {
 
  
  var patientname= {
                        "patientname": $("#patientname").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "createserialfornonidaction",
                        data: JSON.stringify(patientname),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#serialnonid").val(Adnan.serialNumber);
                             $("#patientlId").val(Adnan.patientID);
                             $("#assignedDoctornonid").val(Adnan.assignedDoctor);
                             $("#assignedDoctornonidhidden").val(Adnan.assignedDoctorofficialID);
                             $("#nonidshifthidden").val(Adnan.shift);
                             
                             
                                         
                             
                         }
                            
                        
                    });
  
  
  
  
});

 }); 

</script>

<script lang="javascript">
 $(function() { 
 
 $("#nonidpatientsave").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                   
                        
                      /*  $("#person")
                        .require(); */
                        
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                     
                        //.lessThanOrEqualTo(new Date(),"Bill Date must less than or equal to Todate");
                           
                       $("#patientname")
                        .require(); 
                        
                         $("#dob")
                        .require();  
                        
                        $("#gender")
                         .equalCheck("-1","Select Patient");

                         $("#noniddepartment")
                        .require(); 
                        
                         $("#noniddesignation")
                        .require();

                        
                            });
                            
                           
            });
   $("#advancesearchsavePatient").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                   
                        
                      /*  $("#person")
                        .require(); */
                        
                        //.lessThanOrEqualTo(new Date(),"Receive Date must less than or equal to Todate");
                        
                     
                        //.lessThanOrEqualTo(new Date(),"Bill Date must less than or equal to Todate");
                           
                       $("#designation")
                        .require(); 
                        
                         $("#officialId")
                        .require();  
                        
                        $("#patientNameadvancesearch")
                         .equalCheck("-1","Select Patient");
                         
                         $("#relationadvancesearch")
                        .require(); 
                        
 
                            });
                            
                           
            });
                      
              $("#savePatient").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                      
                         $("#medicalId")
                        .require(); 
                        
                        
                       /*   $("#patientName")
                         .equalCheck("-1","Select Patient"); 
                         */
                         $("#IdholderName")
                        .require();  
                        
                         $("#relation")
                        .require(); 
        
                });
            });
            
            
            
         $("#recommendedsavePatient").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                      
                         $("#recommendedmedicalId")
                        .require(); 
                        
                        
                         $("#recommendedname")
                         .require(); 
                         
                        
                         $("#recommendedpatientName")
                        .equalCheck("-1","Select Patient");   
                        
                         $("#recommendedrelation")
                        .require(); 

                         $("#recommendeddoctor")
                        .equalCheck("-1","Select Doctor");  
                       
                                    
                        
                        
                });
            });  
            
            
            
         $("#recommendedsavePatientadvance").click(function (){
	 
	 		$.validity.setup({outputMode:"summary"});
	 		
	 		// var table = document.getElementById("medTable");              
	 		
                $("form").validity(function() {
                      
                         $("#designationadvance")
                        .require(); 
                        
                        
                         $("#officialIdadvance")
                         .require(); 
                         
                        
                         $("#recommendedpatientNameadvance")
                        .equalCheck("-1","Select Patient");   
                        
                         $("#recommendedrelationadvance")
                        .require(); 
   
                        
                         $("#recommendeddoctoradvance")
                        .equalCheck("-1","Select Doctor");  
      
                });
            });      
            
            
 
   });
 
 </script> 
 <script>

$(function () {

$( "#medicalId" ).blur(function() {
 
  $('#patientName').html('');
  var searchpatient= {
                        "patientmedicalID": $("#medicalId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#IdholderName").val(Adnan.name);
                             $("#serial").val(Adnan.serialNumber);
                             $("#assignedDoctor").val(Adnan.assignedDoctor);
                             $("#assignedDoctorIDhidden").val(Adnan.assignedDoctorofficialID);
                             $("#shifthidden").val(Adnan.shift);
                             
                             
                       
                        }
                            
                        
                    });
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#patientName').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    });                    
                    
                    
  
  
  
  
});

  $("#patientName").click(function (){
   
   //$('#patientName').html('');
             
 var relationwithIDholder= {dependentName:$("#patientName").val(),patientmedicalID: $("#medicalId").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#relation").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  }); 





/*   $("#savePatient").click(function (){
   
   $('#savePatient').html('');
             
var arr = { serialNo:$("#serial").val(),doctorName:$("#assignedDoctor").val(),doctorID:$("#assignedDoctorIDhidden").val(),serialedpatientName:$("#patientName").val() };
$.ajax({
    url: 'saveserialedpatientaction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });   */



$( "#recommendedmedicalId" ).blur(function() {
 
  $('#recommendedpatientName').html('');
  var searchpatient= {
                        "patientmedicalID": $("#recommendedmedicalId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#recommendedname").val(Adnan.name);
                             $("#recommendedserial").val(Adnan.serialNumber);
                             $("#recommendedshiftPatient").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
  
  
   $.ajax({
                    
                        url: "recomendationsearchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#recommendedpatientName').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    }); 
  
  
  
});



  $("#recommendedpatientName").click(function (){
   
   //$('#recommendedpatientName').html('');
             
 var relationwithIDholder= {dependentName:$("#recommendedpatientName").val(),patientmedicalID:$("#recommendedmedicalId").val()};            
             

 $.ajax({
                    
                        url: "recomendedrelationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#recommendedrelation").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  }); 



/*   $("#recommendedsavePatient").click(function (){
   
   $('#recommendedsavePatient').html('');
             
var arr1 = { serialNo:$("#recommendedserial").val(),recDOCTOR:$("#recommendeddoctor").val(),serialedpatientName:$("#recommendedpatientName").val() };
$.ajax({
    url: 'recommenddoctoraction',
    type: 'POST',
    data: JSON.stringify(arr1),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });   */
	  
	  }); 


/* $(document).ready(function() {	  
$(function () {
  $("#recommendedmedicalId").autocomplete({
                source : function(request, response) {
                        $.ajax({
                                url : "searchAction",
                                type : "POST",
                                data : {
                                        patientautocompleteID:request.term
                                },
                                dataType : "json",
                                success : function(jsonResponse) {
                                        
                                         response($.map(jsonResponse.patientIdsearchList, function(e) {
                            return {
                                maxItemsToShow : 5,
                                label : e.patientautocompleteID,
                                value : e.patientautocompleteID
                                
                            };
                        }));
                                        
                                        
                                        
                                }
                        });
                        }
                });

  
	  
   });  
	       
	     });   */      
        
        
        
/*    $(document).ready(function() {	  
$(function () {
  $("#medicalId").autocomplete({
                source : function(request, response) {
                        $.ajax({
                                url : "searchAction",
                                type : "POST",
                                data : {
                                        patientautocompleteID:request.term
                                },
                                dataType : "json",
                                success : function(jsonResponse) {
                                        
                                         response($.map(jsonResponse.patientIdsearchList, function(e) {
                            return {
                                maxItemsToShow : 5,
                                label : e.patientautocompleteID,
                                value : e.patientautocompleteID
                                
                            };
                        }));
                                        
                                        
                                        
                                }
                        });
                        }
                });

  
	  
   });  
	       
	     });   */   
        
 

</script> 
<script>
        $(function () {
            $('#department').html('');
            $('#department').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#department').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#department").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#person').html('');
                    var person = {
                        "departmentID": $("#department").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#person').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#person" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
 $('#patientNameadvancesearch').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#person").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designation").val(Adnan.designation);
                             $("#officialId").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
 /////////////////////////////////////////////////////////////////////////////////////////////////

  var searchpatient= {
                        "patientmedicalID": $("#officialId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                            // $("#IdholderName").val(Adnan.name);
                             $("#serialadvancesearch").val(Adnan.serialNumber);
                             $("#assignedDoctoradvancesearch").val(Adnan.assignedDoctor);
                             $("#assignedDoctorIDadvancesearchhidden").val(Adnan.assignedDoctorofficialID);
                             $("#advancesearchshifthidden").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
                    
                   
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#patientNameadvancesearch').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    }); 
 
 
 
 
 
  
  
  
});       


  $("#patientNameadvancesearch").click(function (){
   
  // $('#patientNameadvancesearch').html('');
             
 var relationwithIDholder= {dependentName:$("#patientNameadvancesearch").val(),patientmedicalID: $("#officialId").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#relationadvancesearch").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  });         
                
   /*   $("#advancesearchsavePatient").click(function (){
   
   $('#advancesearchsavePatient').html('');
             
var arr = { serialNo:$("#serialadvancesearch").val(),doctorName:$("#assignedDoctoradvancesearch").val(),doctorID:$("#assignedDoctorIDadvancesearchhidden").val(),serialedpatientName:$("#patientNameadvancesearch").val() };
$.ajax({
    url: 'saveserialedpatientaction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });    */            
                
                
                
        });
          </script> 
          <script>
        $(function () {
            $('#departmentadvance').html('');
            $('#departmentadvance').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#departmentadvance').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#departmentadvance").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#personadvance').html('');
                    var person = {
                        "departmentID": $("#departmentadvance").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#personadvance').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#personadvance" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
 $('#recommendedpatientNameadvance').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#personadvance").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designationadvance").val(Adnan.designation);
                             $("#officialIdadvance").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
 /////////////////////////////////////////////////////////////////////////////////////////////////

  var searchpatient= {
                        "patientmedicalID": $("#officialIdadvance").val()
                        
                    };
                    
                    

 
  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                           //  $("#recommendedname").val(Adnan.name);
                             $("#recommendedserialadvance").val(Adnan.serialNumber);
                             $("#recommendeshiftadvancehidden").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
                     
                   
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log("res.patients " + res.patients[i].val(res.patients));
                                $('#recommendedpatientNameadvance').append(
                                    '<option value="'+res.patientsidlist[i].val(res.patients)+'" >' + res.patients[i].val(res.patients) +'</option>'); 
                                    
                            }
                        }
                    }); 
 
 
 
 
 
  
  
  
});       


  $("#recommendedpatientNameadvance").click(function (){
   
   //$('#patientNameadvancesearch').html('');
             
 var relationwithIDholder= {dependentName:$("#recommendedpatientNameadvance").val(),patientmedicalID: $("#officialIdadvance").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#recommendedrelationadvance").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  });         
                
/*      $("#recommendedsavePatientadvance").click(function (){
   
   $('#recommendedsavePatientadvance').html('');
             
var arr = {serialNo:$("#recommendedserialadvance").val(),recDOCTOR:$("#recommendeddoctoradvance").val(),serialedpatientName:$("#recommendedpatientNameadvance").val() };
$.ajax({
    url: 'recommenddoctoraction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });  */              
                
                
                
        });
          </script> 

<!-- bindu -->


<script>
      $(function () {
            $('#department').html('');
            $('#department').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#department').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#department").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#person').html('');
                    var person = {
                        "departmentID": $("#department").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#person').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#person" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
 $('#patientNameadvancesearch').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#person").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designation").val(Adnan.designation);
                             $("#officialId").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
 /////////////////////////////////////////////////////////////////////////////////////////////////

  var searchpatient= {
                        "patientmedicalID": $("#officialId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                            // $("#IdholderName").val(Adnan.name);
                             $("#serialadvancesearch").val(Adnan.serialNumber);
                             $("#assignedDoctoradvancesearch").val(Adnan.assignedDoctor);
                             $("#assignedDoctorIDadvancesearchhidden").val(Adnan.assignedDoctorofficialID);
                             $("#advancesearchshifthidden").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
                    
                   
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#patientNameadvancesearch').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    }); 
 
 
 
 
 
  
  
  
});       


  $("#patientNameadvancesearch").click(function (){
   
  // $('#patientNameadvancesearch').html('');
             
 var relationwithIDholder= {dependentName:$("#patientNameadvancesearch").val(),patientmedicalID: $("#officialId").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#relationadvancesearch").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  });         
                
   /*   $("#advancesearchsavePatient").click(function (){
   
   $('#advancesearchsavePatient').html('');
             
var arr = { serialNo:$("#serialadvancesearch").val(),doctorName:$("#assignedDoctoradvancesearch").val(),doctorID:$("#assignedDoctorIDadvancesearchhidden").val(),serialedpatientName:$("#patientNameadvancesearch").val() };
$.ajax({
    url: 'saveserialedpatientaction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });    */            
                
                
                
        });
          </script>
          


<script>
       $(function () {
            $('#departmentadvance').html('');
            $('#departmentadvance').append('<option value>Select Department</option>');
            $.getJSON("dependentdepartmentaction", function (res)
            
            
             {
                for (var i = 0; i < res.departmentIDlist.length; i++) {
                    $('#departmentadvance').append(
                        '<option value='+ res.departmentIDlist[i] +'>' + res.departmentlist[i] + '</option>');
                }
            });
            
            
            
            
            
            
               //'<option value>--Select Anyone--</option>'+
            $("#departmentadvance").click(function (){
            
            //$('#population').replaceWith('<select id="Capital"><option>" Adb "</option></select>');
              //var aa=$("#testtype option:selected").text();
	           //alert(aa);
	       
                    $('#personadvance').html('');
                    var person = {
                        "departmentID": $("#departmentadvance").val()
                        
                    };
                    
                    
                    
                    
                           $.ajax({
                           
                       
                        url: "dependentpersonaction",
                        data: JSON.stringify(person),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                        
                            console.log(res.personNamelist.length);
                            for (var i = 0; i < res.personNamelist.length; i++) {
                                console.log(" " + res.personNamelist[i]);
                                $('#personadvance').append(
                                    '<option value=' + res.officialIDlist[i] + '>' + res.personNamelist[i] + '</option>');
                                    
                                    
                  
                            }
                            
                           
                        }
                        
                       
                    });
                    
                 
                });
                
                
              
 $( "#personadvance" ).click(function() {
 
 /*  var aa=$("#person option:selected").text();
	            alert(aa); */
$('#recommendedpatientNameadvance').html(''); 	            
  var personOfficialID= {
                        "personofficialID": $("#personadvance").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "dependentdesignation+officialIdaction",
                        data: JSON.stringify(personOfficialID),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#designationadvance").val(Adnan.designation);
                             $("#officialIdadvance").val(Adnan.officialID);
                           //  $("#medicalId").val(Adnan.officialID);
                             $("#officialIdsend").val(Adnan.officialID);
                             $("#designationsend").val(Adnan.designation);
                            
                             
                             
                            
                             
                             
                         }
                            
                        
                    });
  
 /////////////////////////////////////////////////////////////////////////////////////////////////

  var searchpatient= {
                        "patientmedicalID": $("#officialIdadvance").val()
                        
                    };
                    
                    

 
  $.ajax({
                    
                        url: "patientsearchaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                           //  $("#recommendedname").val(Adnan.name);
                             $("#recommendedserialadvance").val(Adnan.serialNumber);
                             $("#recommendeshiftadvancehidden").val(Adnan.shift);
                             
                       
                        }
                            
                        
                    });
                     
                   
                    
                    
    $.ajax({
                    
                        url: "searchpatientaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function (res) {
                            console.log(res.patients.length);
                            for (var i = 0; i < res.patientsidlist.length; i++) {
                                console.log(" " + res.patients[i]);
                                $('#recommendedpatientNameadvance').append(
                                    '<option value="'+res.patientsidlist[i]+'" >' + res.patients[i] +'</option>'); 
                                    
                            }
                        }
                    }); 
 
 
 
 
 
  
  
  
});       


  $("#recommendedpatientNameadvance").click(function (){
   
   //$('#patientNameadvancesearch').html('');
             
 var relationwithIDholder= {dependentName:$("#recommendedpatientNameadvance").val(),patientmedicalID: $("#officialIdadvance").val()};            
             

 $.ajax({
                    
                        url: "relationwithIDholderaction",
                        data: JSON.stringify(relationwithIDholder),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#recommendedrelationadvance").val(Adnan.relation);
                            
                       
                        }
                            
                        
                    });
                      
	       
	       
	  });         
                
/*      $("#recommendedsavePatientadvance").click(function (){
   
   $('#recommendedsavePatientadvance').html('');
             
var arr = {serialNo:$("#recommendedserialadvance").val(),recDOCTOR:$("#recommendeddoctoradvance").val(),serialedpatientName:$("#recommendedpatientNameadvance").val() };
$.ajax({
    url: 'recommenddoctoraction',
    type: 'POST',
    data: JSON.stringify(arr),
    contentType: 'application/json; charset=utf-8',
    dataType: 'json',
    async: false,
    success: function(msg){
    alart(msg);
       
    }
});
                      
	       
	       
	  });  */              
                
          });       
                
      
          </script> 



<script>
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("slow");
  });
});
</script>

<script> 
$(document).ready(function(){
  $("#flipemployee").click(function(){
    $("#panelemployee").slideToggle("slow");
  });
});
</script>

<style type="text/css">
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
.button3:hover {
    background-color: #f44336;
    color: white;
}
</style>


  <script>
  $(function () {
  
  $( "#medicalId" ).blur(function() {
 
  $('#patientName').html('');
  var searchpatient= {
                        "medicalID": $("#medicalId").val()
                        
                    };
                    
                    


  $.ajax({
                    
                        url: "medicalfitnesscertificateafterrecovryaction",
                        data: JSON.stringify(searchpatient),
                        dataType: 'json',
                        contentType: 'application/json',
                        type: 'POST',
                        async: true,
                        success: function(Adnan){
                             $("#IdholderName").val(Adnan.medicalIDholderName);
                             $("#department").val(Adnan.department);
                             $("#designation").val(Adnan.designation);
                             
                             
                       
                        }
                            
                        
                    });
  

 });

     
  });            
          
        
        

</script>

 <script>
 
        $(function() {
            $("#expiredate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();


        });
        $(function() {
            $("#expiredate2").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();


        });

</script> 
<script>
console.log($("myselect").val());

// all option's value
$("myselect").find("option").each(function(){
    console.log($(this).text());
    console.log($(this).val());
});

// change event
$("myselect").change(function(){
    console.log($(this).find(":selected").text());
    console.log($(this).find(":selected").val());
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
                    	
                    

<h1 align= center><font size="4" color="green">Death Certificate</font></h1> 
 <br/> 
  <fieldset class="additionForm">  
<legend>Death Certificate</legend> 

<div id="flip"><button id="flip" class="button button3">Student ID holder</button></strong></font></div>
<br>
<div id="panel">

<s:form action="deathcertificateaction" theme="xhtml" > 
 <table  border="0" width="500px" style="border-spacing: 4px;">
	
	


 <tr>
 <td>

 <s:textfield  id="medicalId" name="medicalId" label="Patient Id" theme="xhtml"/>
 </td>
 </tr>
 
 

 <tr>
 
 <td>
  
  <s:textfield label="Id holder Name" id="IdholderName" name="idholderName" readonly="true" theme="xhtml"/>   
  
  
 </td>
 </tr>
 
 	<tr>

 <td>
  <s:textfield label="Department" id="department" name="department" readonly="true" theme="xhtml"/>  
 
 </td>
 </tr>
 

<tr>
 <td>
  <s:textfield label="Designation" id="designation" name="designation" readonly="true" theme="xhtml"/>  
 </td>
 </tr>
<tr>
 <td>
  <s:textfield label="Age (Years)" id="age" name="age"  theme="xhtml"/>  
 </td>
 </tr>
 <tr>
 <td>
   <s:select theme="xhtml" id="gender" name="gender" list="{'Male','Female','Others'}" label="Sex"/>
 </td>
 </tr>

 <tr>
<td>
<s:textfield label="Expired time" id="expiretime"  name="expiretime"  size="8" theme="xhtml"/>

</td>
</tr>

 <tr>
<td>
<s:textfield label="Expired Date" id="expiredate"  name="expiredate" size="8"  theme="xhtml"/>

</td>
</tr>
  
  <tr>
<td>
<s:textarea  label="Probable cause of Death" id="causeOFdeath"  name="causeOFdeath"  cols="30" rows="5" 
            cssStyle="overflow: scroll; resize: none;" />

</td>
</tr>
 

 <tr>
 <td>
  
   
  &nbsp;
  
 </td>
  <td>
  
   <s:submit id="savePatient" value="Press" theme="simple" cssClass="btn btn-primary btn-large" />
   <s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"/>
  
 </td>
 
 </tr>
	
	
</table>
</s:form>


<!--  <s:form action="pdfTest" theme="xhtml" > 
 <s:submit id="savePatient" value="Download" theme="simple" cssClass="btn btn-primary btn-large" />
 </s:form>-->
</div>
<br>
<hr>
<br><br>
<div id="flipemployee"><button id="button2" class="button button3">Employee ID holder</button></div>
<br>
<f2>
	
												<!-- Employee IDholder -->
<div id="panelemployee">
<s:form action="deathcertificateactionE" theme="xhtml"> 

<!--<table style="border-spacing: 4px;" >-->

<table  border="0" width="500px" style="border-spacing: 4px;">
<tr>
<td align="left">
Dept/Office
</td>
<td align="left">
 <select class="myselect" id="departmentadvance" value="%{department}"  name="department" style="width:155px" theme="xhtml" > 
 
 </select>
</td>
</tr>
<tr>
<td align="left">
Person
</td>
<td>
 <select class="myselect" id="personadvance"   name="person" style="width:220px"  theme="xhtml"> 
 
 </select>
</td>
</tr>



<tr>
<td>

<s:textfield label="Designation" id="designationadvance" name="designation" readonly="true" theme="xhtml"/>

</td>
</tr>



<tr>
<td>

<s:textfield label="Official Id" id="officialIdadvance" name="officialId" readonly="true" theme="xhtml"/>

</td>
</tr>


	<tr>
 
 <td>Victim :</td>
 <td>
 <select class="myselect"  id="recommendedpatientNameadvance" name="victim" theme="xhtml"><option >--Select--</option></select>
 
 </td>
 </tr>
 

<tr>
 <td>
 <s:textfield  id="recommendedrelationadvance" name="relation" label="Relation" readonly="true"  theme="xhtml"/>
 </td>
 </tr>

<tr>
<td>
  <s:textfield label="Age (Years)" id="age" name="age"  theme="xhtml"/>  
 </td>
 </tr>
 <tr>
 <td>
   <s:select theme="xhtml" id="gender" name="gender" class="myselect" list="{'Male','Female','Others'}" label="Sex"/>
 </td>
 </tr>

 <tr>
<td>
<s:textfield label="Expired time" id="expiretime"  name="expiretime"  size="8" theme="xhtml"/>

</td>
</tr>

 <tr>
<td>
<s:textfield label="Expired Date" id="expiredate2"  name="expiredate" size="8"  theme="xhtml"/>

</td>
</tr>
  
   <tr>
<td>
<s:textarea  label="Probable cause of Death" id="causeOFdeath"  name="causeOFdeath"  cols="30" rows="5" 
            cssStyle="overflow: scroll; resize: none;" />

</td>
</tr>

 

 <tr>
 <td>
  
   
  &nbsp;
  
 </td>
  <td>
  
   <s:submit id="savePatient" value="Press" theme="simple" cssClass="btn btn-primary btn-large" />
   <s:reset  value="Clear"  theme="simple" cssClass="btn btn-small"/>
  
 </td>
 </tr>

<tr>
<td>
&nbsp;
</td>
</tr>


</table>

</s:form>

</div>
<br/>
	



</f2>

  
     
   
</fieldset>	
 <!--Main content will be here-->    
 <%@include file="/WEB-INF/jsp/template/footer.jsp"%>     
 
