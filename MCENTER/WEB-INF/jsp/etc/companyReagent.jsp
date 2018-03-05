
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/darkorange/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#ComReagentTableContainer').jtable({
            title: 'Table of Reagent Company',
            actions: {
                listAction: 'ComReagentController?action=list',
                createAction:'ComReagentController?action=create',
                updateAction: 'ComReagentController?action=update',
                deleteAction: 'ComReagentController?action=delete'
                
                
            },
            fields: {
                companyid: {
                	title:'Company Id',
                    key: true,
                    list: true,
                    create:true,
                    width : '25%'
                    
                },               
                companyname: {
                    title: 'Company Name',                    
                    edit: true,
                    width : '75%'                    
                }     
                                
            }
        });
        $('#ComReagentTableContainer').jtable('load');
    });

</script>




<form id="mainform" class="register" >
<h2>Reagent Company Information</h2>
	<fieldset class="row1">
		<legend >
			Entry, Update or Delete
		</legend>
	<p>
	<div id="ComReagentTableContainer" ></div>
	</p>

	</fieldset>
</form>





<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
