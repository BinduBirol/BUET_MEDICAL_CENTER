
<%@include file="/WEB-INF/jsp/template/head.jsp"%>	
<link rel="stylesheet" href="/MCENTER/resources/css/default.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/metro/green/jtable.css" type="text/css"></link>
<link rel="stylesheet" href="/MCENTER/resources/css/jquery-ui-1.10.3.custom.css" type="text/css"></link>


<script type="text/javascript" src="/MCENTER/resources/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="/MCENTER/resources/js/jquery.jtable.js"></script>

<script type="text/javascript">
	 $(document).ready(function () {
        $('#TestTableContainer').jtable({
            title: 'Table of Test',
            actions: {
                listAction: 'TestController?action=list',
                createAction:'TestController?action=create',
                updateAction:'TestController?action=update',
                deleteAction:'TestController?action=delete'
                                
            },
            fields: {
                testTypeID: {
                    title: 'TtypeID',
                    edit: true,
                    width : '5%'
                },
                testType: {
                    title: 'Test Type Name',                    
                    edit:true,
                    create:false,
                    width : '22%'
                },
                
                 testNameID: {
                	title:'TnameID',
                    key: true,
                    list: true,
                    create:true,
                    width : '5%'
                },
                testName: {
                    title: 'Test Name',                    
                    edit: true,
                    width : '18%'
                },
                 vat: {
                    title: 'Vat',                    
                    edit: true,
                    width : '18%'
                } ,
                rate: {
                    title: 'Rate',                    
                    edit:true,
                    width : '5%'
                },
                status: {
                    title: 'Status',                    
                    edit:true,
                    width : '5%'
                }
                            
                                
            }
        });
        $('#TestTableContainer').jtable('load');
    });

</script>



<form id="mainform" class="register" >
<h1>Test Information</h1>
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

     
