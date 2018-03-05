

<%@include file="/WEB-INF/jsp/template/head.jsp"%>	


<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui.css" type="text/css"></link>

<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/tabledata/jquery.dataTables.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/js/jquery.validity.1.2.0/jquery.validity.css" type="text/css"></link>

<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.validity.1.2.0/jQuery.validity.js"></script>


<style type="text/css" media="screen">
    
    .contentBox {
        float: left;
        margin-top: 3px;
        height: 600px;
        width: 400px;
        margin-left: 0px;
    }


</style>


<script>
	
	$(function() {
			$( "#fdate" ).datepicker();
			$( "#tdate" ).datepicker();
			});	
				
	
			
    function fetchtselect() {
        document.getElementById("select");
        {
            document.getElementById("s").innerHTML = "Select any one";
        }
    }


    function fetchtdlist() {
        //alert("Today");
        $.get("/MCENTER/fetchtdlist.action", {}, populateDetails);
    }


    function populateDetails(html) {
        document.getElementById("s").innerHTML = html;

    }


    function fetchall() {

        document.getElementById("second");
        {
            $.get("/MCENTER/selectdate.action", {}, populateDetail);
            //document.getElementById("s").hide();          
        }
        function populateDetail(html) {

            document.getElementById("detailtd").innerHTML = html;

        }

    }

    function fetchallhistory() {
        // alert( "Hello World");
        var fdate = $("#fdate").val();
        var tdate = $("#tdate").val();

        $.get("/MCENTER/fetchalllist.action", {fdate: fdate, tdate: tdate}, popuDetails);
        
    }
    function popuDetails(html) {

        document.getElementById("s").innerHTML = html;

    }
</script>



                    <s:form>
                        <table align="left" class="display dataTable" width="700px">
                            <tr>
                                <td colspan="3">
                                    <h1 align="center"><font color="#FF2222">Patients' List</font></h1>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label><b> Select Patients' lists:</b></label>
                                </td>
                                <td colspan="2">
                                    <select name="module" id="module">
                                        <option selected value="0" id="select" onclick="fetchtselect()">--Select--
                                        </option>
                                        <option value="01" id="first" onclick="fetchtdlist()">Today's Patients</option>
                                        <option value="02" id="second" onclick="fetchall()">All History</option>

                                    </select>
                                </td>
                            </tr>

                            <tr id="detailtd">
								

                            </tr>
                            <tr>
                                <td colspan="3">
                                    <div id="s">
										
                                    </div>
                                </td>
                            </tr>

                        </table>
                    </s:form>


               
   <%@include file="/WEB-INF/jsp/template/footer.jsp"%>
    <!--end footer-->
