
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/brown/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#ReagentTableContainer').jtable({
            title: 'Table of Generic',
            actions: {
                listAction: 'ReagentController?action=list',
                createAction:'ReagentController?action=create',
                updateAction: 'ReagentController?action=update',
                deleteAction: 'ReagentController?action=delete'
                
                
            },
            fields: {
                reagentid: {
                	title:'Reagent Id',
                    key: true,
                    list: true,
                    create:true,
                    width : '20%'
                    
                },               
                reagentname: {
                    title: 'Reagent Name',                    
                    edit: true,
                    width : '75%'                    
                }     
                                
            }
        });
        $('#ReagentTableContainer').jtable('load');
    });

</script>




<form id="mainform" class="register" >
<h1>Reagent Information</h1>
	<fieldset class="row1">
		<legend >
			Entry, Update or Delete
		</legend>
	<p>
	<div id="ReagentTableContainer" ></div>
	</p>

	</fieldset>
</form>





<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
