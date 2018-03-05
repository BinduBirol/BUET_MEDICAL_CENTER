 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Patients's List</title>
<link type="image/x-icon" rel="icon" href="resource/img/logo.png"/>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="resource/css/main.css" type="text/css"/>


<style type="text/css" media="screen">
    @import url("/mcenter/resources/css/main.css");
    @import url("/mcenter/resources/css/jquery-ui.css");
    @import url("/mcenter/resources/css/tablecss.css");
    @import url("/mcenter/resources/css/calcss.css");

    .contentBox {
        float: left;
        margin-top: 3px;
        height: 600px;
        width: 400px;
        margin-left: 0px;
    }


</style>
<script type="text/javascript" src="resource/js/functions.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/lib/jquery.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/lib/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="/mcenter/resources/js/caljs.js"></script>


 
 <div class="wrap">
    <div class="wrapper">
        <jsp:include page="/WEB-INF/layout/header.jsp"/>
        <jsp:include page="/WEB-INF/layout/menu.jsp"/>
        <div class="mainBody">
            <jsp:include page="/WEB-INF/layout/sidebar.jsp"/>
            <div class="rightCon">
                <div class="contentBox">
 
 
 
 <table class="bordered" align="center" id="table" width="500px">
	 <tr>
		 
		 	<th>Name of Patient</th>
		 	<th>Age(yrs)</th>
		 	<th>Sex</th>
		 	<th>Weight</th>
		 
			 <td>Name of Patient: </td>
	 
	 
	 
	 
	 </tr>
 
 
 
 
 </table>

 
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