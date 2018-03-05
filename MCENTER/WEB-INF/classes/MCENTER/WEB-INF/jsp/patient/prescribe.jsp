<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Karnaphuli Gas Distribution Company Limited</title>
<link type="image/x-icon" rel="icon" href="resource/img/logo.png"/>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resource/css/main.css" type="text/css"/>
<script type="text/javascript" src="resource/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="resource/js/functions.js"></script>


<style type="text/css" media="screen">
    @import url("/mcenter/resources/css/main.css");
    @import url("/mcenter/resources/css/jquery-ui.css");
    @import url("/mcenter/resources/css/tablecss.css");

    .contentBox {
        margin-top: 0px;
        width: 600px;
        margin-left: 0px;
    }

    .data select {
        float: left;
        width: 90px;
    }


</style>

<script type="text/javascript" src="/mcenter/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/util.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/numeric.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/util/util.js"></script>
<link type="text/css" rel="stylesheet" href="/mcenter/resources/js/lib/jquery.validity.1.2.0/jquery.validity.css"/>
<script type="text/javascript" src="/mcenter/resources/js/lib/jquery.validity.1.2.0/jQuery.validity.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/jquery.autocomplete.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/caljs.js"></script>

<script>


    function fetchtselect() {
        document.getElementById("select");
        {
            document.getElementById("detailtd").innerHTML = "Select any one";


        }
    }


    function fetchtdlist() {
        alert("Today");
        $.get("/bmc/fetchtdlist.action", {}, populateDetails);
    }


    function populateDetails(html) {
        document.getElementById("detailtd").innerHTML = html;

    }


    function fetchall() {

        document.getElementById("second");
        {
            $.get("/bmc/selectdate.action", {}, populateDetail);
        }
        function populateDetail(html) {

            document.getElementById("detailtd").innerHTML = html;

        }

    }

    function fetchallhistory() {
        // alert( "Hello World");
        var fdate = $("#fdate").val();
        var tdate = $("#tdate").val();

        $.get("/bmc/fetchalllist.action", {fdate: fdate, tdate: tdate}, popuDetails);
    }
    function popuDetails(html) {

        document.getElementById("s").innerHTML = html;

    }
</script>

<div class="wrap">
    <div class="wrapper">
        <jsp:include page="/WEB-INF/layout/header.jsp"/>
        <jsp:include page="/WEB-INF/layout/menu.jsp"/>
        <div class="mainBody">
            <jsp:include page="/WEB-INF/layout/sidebar.jsp"/>
            <div class="rightCon">
                <div class="contentBox">
                    <center>
                        <s:form>
                            <h1>Patients' List</h1>
                            <table>
                                <tr>
                                    <div id="today">
                                        <label><b> Select Patients' lists:</b></label>
                                        <select name="module" id="module">
                                            <option selected value="0" id="select" onclick="fetchtselect()">--Select--
                                            </option>
                                            <option value="01" id="first" onclick="fetchtdlist()">Today's Patients
                                            </option>
                                            <option value="02" id="second" onclick="fetchall()">All History</option>

                                        </select>
                                    </div>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="detailtd">

                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                    </center>
                </div>
                <!--end contentBox-->
            </div>
            <!--end rightCon-->
        </div>
        <!--end mainBody-->
    </div>
    <!--end wrapper-->
    <jsp:include page="/WEB-INF/layout/footer.jsp"/>
    <!--end footer-->
</div>
<!--end wrap-->
</div>
</html>