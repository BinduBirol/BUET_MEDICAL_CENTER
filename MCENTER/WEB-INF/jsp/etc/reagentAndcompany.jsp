
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/purple/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#ReagentTableContainer').jtable({
            title: 'Table of Reagent and Company',
            actions: {
                listAction: 'ReagentComController?action=list',
                createAction:'ReagentComController?action=create',
                updateAction: 'ReagentComController?action=update',
                deleteAction: 'ReagentComController?action=delete'
                                
            },
            fields: {
                reagentid: {
                	title:'RId',
                    key: true,
                    list: true,
                    create:true,
                    width : '5%'
                },
                reagentname: {
                    title: 'Reagent Name',                    
                    edit:true,
                    width : '22%'
                },
                companyid: {
                    title: 'CId',                    
                    edit:true,
                    width : '5%'
                },
                companyname: {
                    title: 'Company Name',
                    create:false,                    
                    edit: false,
                    width : '18%'
                },
                reorder: {
                    title: 'Reorder Level',                    
                    edit:true,
                    width : '8%'
                },
                unit: {
                    title: 'Unit',                   
                    edit: true,
                    width : '8%'
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
	<div id="ReagentTableContainer" style="min-width: 890px; margin: 0 auto"></div>
	</p>

	</fieldset>
</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
