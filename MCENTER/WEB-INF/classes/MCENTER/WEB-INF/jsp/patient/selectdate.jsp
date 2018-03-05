
 <%@include file="/WEB-INF/jsp/template/head.jsp"%>
 
 	
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>

<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>

    <script>
        $(function() {
            $("#fdate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();

            $("#tdate").datepicker({
                dateFormat: 'dd/mm/yy',
                changeMonth: true,
     	        changeYear: true
            }).val();
        });
    </script>

<script>

/* 	$(function() {
			$( "#fdate" ).datepicker();
			$( "#tdate" ).datepicker();
			});	 */
				
		
    function fetchallhistory() {


        var fdate = $("#fdate").val();
        var tdate = $("#tdate").val();

        $.get("/MCENTER/fetchalllist.action", {fdate: fdate, tdate: tdate}, popuDetails);
    }


    function popuDetails(html) {

        document.getElementById("s").innerHTML = html;

    }

</script>

<table class="display dataTable" id="table" width="600px" >
	<tr>
	    <td>
	        <label>From Date :</label>
	        <input type="text" id="fdate" name="fdate" />
	
	    </td>
	    <td>
	        <label>To Date :</label>
	        <input type="text" id="tdate" name="tdate" />
	    </td>
	    <td>
	        <input type="button" value="OK" onclick="fetchallhistory()"/><br>
	    </td>
	  </tr>
	  
	  
	  
	  <tr >	
	   <td colspan="3">
          <div id="s">
										
        	</div>
        </td>	
	
	</tr>
</table>
<!-- <tr >

<div id="s">
</div>
</tr> -->
<%@include file="/WEB-INF/jsp/template/footer.jsp"%>