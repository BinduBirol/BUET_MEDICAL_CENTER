
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/purple/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#MedTableContainer').jtable({
            title: 'Table of Medicine',
            actions: {
                listAction: 'MedController?action=list',
                createAction:'MedController?action=create',
                updateAction: 'MedController?action=update',
                deleteAction: 'MedController?action=delete'
                                
            },
            fields: {
                medid: {
                	title:'MId',
                    key: true,
                    list: true,
                    create:true,
                    width : '5%'
                },
                medname: {
                    title: 'Medicine Name',                    
                    edit:true,
                    width : '22%'
                },
                genid: {
                    title: 'GId',                    
                    edit:true,
                    width : '5%'
                },
                genname: {
                    title: 'Generic Name', 
                    create:false,                   
                    edit: false,
                    width : '18%'
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
        $('#MedTableContainer').jtable('load');
    });

</script>


<form id="mainform" class="register" >
<h1>Medicine Information</h1>
	<fieldset class="row1">
		<legend >
			Entry, Update or Delete
		</legend>
	<p>
	<div id="MedTableContainer" style="min-width: 890px; margin: 0 auto"></div>
	</p>

	</fieldset>
</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
