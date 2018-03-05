
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/darkgray/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#TestTableContainer').jtable({
            title: 'Table of Test',
            actions: {
                listAction: 'TestTypeController?action=list',
                createAction:'TestTypeController?action=create',
                updateAction:'TestTypeController?action=update',
                deleteAction:'TestTypeController?action=delete'
                                
            },
            fields: {
                testTypeID: {
                  key: true,
                    list: true,
                    create:true,
                    width : '5%'
                },
                testType: {
                    title: 'Test Type Name',                    
                    edit:true,
                    width : '22%'
                }
                            
                                
            }
        });
        $('#TestTableContainer').jtable('load');
    });

</script>



<form id="mainform" class="register" >
<h1>Test Type Information</h1>
	<fieldset class="row1">
		<legend >
			Entry, Update or Delete
		</legend>
		
	<p>
	
	<div id="TestTableContainer" style="min-width: 890px; margin: 0 auto"></div>
	
	</p>

	</fieldset>
</form>


<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

     
