<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<link rel="shortcut icon" href="#" type="image/png">
	
	<title>Administration : Gestion des collaborateurs</title>
	
	<!--dynamic table-->
  	<link href='<s:url value="/js/advanced-datatable/css/demo_page.css"/>' rel="stylesheet" />
  	<link href='<s:url value="/js/advanced-datatable/css/demo_table.css"/>' rel="stylesheet" />
  	<link rel="stylesheet" href='<s:url value="/js/data-tables/DT_bootstrap.css"/>' />
	
	<!--ios7-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/js/ios-switch/switchery.css"/>' />

    <!--icheck-->
    <link href='<s:url value="/js/iCheck/skins/minimal/minimal.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/purple.css"/>' rel="stylesheet">

    <link href='<s:url value="/js/iCheck/skins/square/square.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/purple.css"/>' rel="stylesheet">

    <link href='<s:url value="/js/iCheck/skins/flat/grey.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/purple.css"/>' rel="stylesheet">

    <!--multi-select-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/js/jquery-multi-select/css/multi-select.css"/>' />

    <!--file upload-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/css/bootstrap-fileupload.min.css"/>' />

    <!--tags input-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/js/jquery-tags-input/jquery.tagsinput.css"/>' />
    
	<!--pickers css-->
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-datepicker/css/datepicker-custom.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-timepicker/css/timepicker.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-colorpicker/css/colorpicker.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-daterangepicker/daterangepicker-bs3.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-datetimepicker/css/datetimepicker-custom.css"/>' />
	
	<!-- wysihtml5 -->
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>' />
	
	<!--gritter css-->
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/gritter/css/jquery.gritter.css"/>' />
	
	<!-- initial style -->
	<link href='<s:url value="/css/style.css"/>' rel="stylesheet">
	<link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">
	
	<!-- rating -->
	<link href='<s:url value="/css/jquery.rating.css"/>' rel="stylesheet">
	
	<style type="text/css">
		.ms-selection{
			display: none;
		}
		
		.selectedItem{
			background-color: #65CEA7;
			
		}
	</style>
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	  <script src="js/html5shiv.js"></script>
	  <script src="js/respond.min.js"></script>
	  <![endif]-->
</head>

<body class="sticky-header">

	<section>
	
	    <!-- left side start-->
			<s:include value="include/left_side_bar.jsp"></s:include>
	    <!-- left side end-->
	    
	    <!-- main content start-->
	    <div class="main-content" >
	
	        <!-- header section start-->
	        	<s:include value="include/header_section.jsp"></s:include>
	        <!-- header section end-->
	
	        <!-- page heading start-->
	        <div class="page-heading">
	            <h3>
	                Administration <small>Gestion des collaborateurs</small>
	            </h3>
	        </div>
	        <!-- page heading end-->
	
	        <!--body wrapper start-->
	        <div class="wrapper">
	            
				<div class="row"><!-- present working link Start-->
		            <div class="col-md-12">
		                <!--breadcrumbs start -->
		                <ul class="breadcrumb panel">
		                    <li><a href="#"><i class="fa fa-home"></i> Administrateur</a></li>
<!-- 		                    <li><a href="#">Gestion des Collaborateur</a></li> -->
		                    <li class="active">Gestion des Collaborateur</li>
		                </ul>
		                <!--breadcrumbs end -->
		            </div>
	        	</div><!-- present working link End-->
	        	
	        	
				<!-- Message action start-->
		        	<s:include value="include/message_action.jsp"></s:include>
		        <!-- Message action end-->
				
				
				<!-- Data table des collaborateurs Start -->
					<s:include value="include/data_table_collaborateurs.jsp"></s:include>
				<!-- Data table des collaborateurs End -->
				
				<%-- <!-- Begin Gestion des habilitations -->
					<s:include value="include/gestion_habilitations.jsp"></s:include>	
				<!-- End Gestion des habilisation --> --%>
				
				<!-- Ajout Collaborateur Modal Form -->
					<s:include value="include/ajout_collaborateur_modal.jsp"></s:include>
				<!-- End Ajout Collaborateur Modal Form -->
				
				<!-- Update Collaborateur Modal Form -->
					<s:include value="include/update_collaborateur_modal.jsp"></s:include>
				<!-- End Update Collaborateur Modal Form -->
				
				<!-- Begin Send Message to collaborateur Modal -->
					<s:include value="include/send_msg_collaborateur_modal.jsp"></s:include>	
				<!-- End Send Message to collaborateur Modal -->
				
	        </div>
	        <!--body wrapper end-->
	
	        <!--footer section start-->
	        <footer class="sticky-footer">
	            2014 &copy; Mouad &amp; Mohamed
	        </footer>
	        <!--footer section end-->
	
	    </div>
	    <!-- main content end-->
	</section>
	
	
	<!-- jquery start -->
	<script src='<s:url value="/js/jquery-1.10.2.min.js"/>'></script>
	<script src='<s:url value="/js/jquery-ui-1.9.2.custom.min.js"/>'></script>
	<script src='<s:url value="/js/jquery-migrate-1.2.1.min.js"/>'></script>
	<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
	<script src='<s:url value="/js/modernizr.min.js"/>'></script>
	<script src='<s:url value="/js/jquery.nicescroll.js"/>'></script>

	
	<!--dynamic table-->
	<script type="text/javascript" src='<s:url value="/js/advanced-datatable/js/jquery.dataTables.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/data-tables/DT_bootstrap.js"/>'></script>
	<!--dynamic table initialization -->
	<script src='<s:url value="/js/dynamic_table_init.js"/>'></script>
	
	<!--ios7-->
	<script src='<s:url value="/js/ios-switch/switchery.js"/>' ></script>
	<script src='<s:url value="/js/ios-switch/ios-init.js"/>' ></script>
	
	<!--icheck -->
	<script src='<s:url value="/js/iCheck/jquery.icheck.js"/>'></script>
	<script src='<s:url value="/js/icheck-init.js"/>'></script>
	<!--multi-select-->
	<script type="text/javascript" src='<s:url value="/js/jquery-multi-select/js/jquery.multi-select.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/jquery-multi-select/js/jquery.quicksearch.js"/>'></script>
	<script src='<s:url value="/js/multi-select-init.js"/>'></script>
	<!--spinner-->
	<script type="text/javascript" src='<s:url value="/js/fuelux/js/spinner.min.js"/>'></script>
	<script src='<s:url value="/js/spinner-init.js"/>'></script>
	<!--file upload-->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-fileupload.min.js"/>'></script>
	<!--tags input-->
	<script src='<s:url value="/js/jquery-tags-input/jquery.tagsinput.js"/>'></script>
	<script src='<s:url value="/js/tagsinput-init.js"/>'></script>
	<!--bootstrap input mask-->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-inputmask/bootstrap-inputmask.min.js"/>'></script>

	
	<!--pickers plugins-->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-datepicker/js/bootstrap-datepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-daterangepicker/moment.min.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-daterangepicker/daterangepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-timepicker/js/bootstrap-timepicker.js"/>'></script>
	
	<!--pickers initialization-->
	<script src='<s:url value="/js/pickers-init.js"/>'></script>
	
	
	<!-- bootstrap-wysihtml5 -->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-wysihtml5/wysihtml5-0.3.0.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-wysihtml5/bootstrap-wysihtml5.js"/>'></script>
	<script>
	    jQuery(document).ready(function(){
	         $('.wysihtml5').wysihtml5();
	         
	    });
	</script>
	<!-- end bootstrap-wysihtml5 -->
	
	<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>
	
	
	<!-- bootstrap confirmation tool -->
		<script src='<s:url value="/lib/BootstrapConfirmation_files/bootstrap-transition.js"/>'></script>
		<script src='<s:url value="/lib/BootstrapConfirmation_files/bootstrap-tooltip.js"/>'></script>
		<script src='<s:url value="/lib/BootstrapConfirmation_files/holder.js"/>'></script>
		<script src='<s:url value="/lib/BootstrapConfirmation_files/prettify.js"/>'></script>
		<script src='<s:url value="/lib/BootstrapConfirmation_files/application.js"/>'></script>
		<script src='<s:url value="/lib/BootstrapConfirmation_files/bootstrap-confirmation.js"/>'></script>
	<!-- end bootstrap confirmation tool -->
	
	
	<!-- Rating -->
	<script src='<s:url value="/js/jquery.rating.pack.js"/>'></script>
	
	
	<!--gritter script-->
	<script type="text/javascript" src='<s:url value="/js/gritter/js/jquery.gritter.js"/>'></script>
	<script src='<s:url value="/js/gritter/js/gritter-init.js"/>' type="text/javascript"></script>
	
	
	<!-- javascript of collaborateur_list page Begin -->
		<s:include value="include/javascript_collaborateur_list.jsp"></s:include>
	<!-- javascript of collaborateur_list page End -->
	
	
	