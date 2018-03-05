
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/brown/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#GenTableContainer').jtable({
            title: 'Table of Generic',
            actions: {
                listAction: 'GenController?action=list',
                createAction:'GenController?action=create',
                updateAction: 'GenController?action=update',
                deleteAction: 'GenController?action=delete'
                
                
            },
            fields: {
                genid: {
                	title:'Generic Id',
                    key: true,
                    list: true,
                    create:true,
                    width : '20%'
                    
                },               
                genname: {
                    title: 'Generic Name',                    
                    edit: true,
                    width : '75%'                    
                }     
                                
            }
        });
        $('#GenTableContainer').jtable('load');
    });

</script>




<form id="mainform" class="register" >
<h1>Generic Information</h1>
	<fieldset class="row1">
		<legend >
			Entry, Update or Delete
		</legend>
	<p>
	<div id="GenTableContainer" ></div>
	</p>

	</fieldset>
</form>





<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
