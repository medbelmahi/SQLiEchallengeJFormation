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
	        	
	        	<!-- success message Start -->
	        	<s:if test="isSessionMessageError()">
		        	<div class="row">
		        		<div class="col-md-12">
		        			<div class="alert alert-info fade in">
		                         <button type="button" class="close close-sm" data-dismiss="alert">
		                             <i class="fa fa-times"></i>
		                         </button>
		                         <strong>Message : </strong>  <s:property value="sessionActionMessageText" />
		                     </div>
		        		</div>
		        	</div>
		        </s:if>
				<!-- success message End -->
				
				
				<!-- Error message Start -->
				<s:if test="isSessionActionError()">
					<div class="row">
			        		<div class="col-md-12">
			        			<div class="alert alert-block alert-danger fade in">
		                            <button type="button" class="close close-sm" data-dismiss="alert">
		                                <i class="fa fa-times"></i>
		                            </button>
		                            <strong>Erreur ! </strong> <s:property value="sessionActionErrorText" />
		                        </div>
			        		</div>
			        </div>
			    </s:if>
				<!-- Error message End -->
				
				<!-- Data table des collaborateurs Start -->
					<s:include value="include/data_table_collaborateurs.jsp"></s:include>
				<!-- Data table des collaborateurs End -->
				
				
				<!-- Update Collaborateur Modal Form -->
					<s:include value="include/update_collaborateur_modal.jsp"></s:include>
				<!-- End Update Collaborateur Modal Form -->
				
				
				<!-- Ajout Collaborateur Modal Form -->
					<s:include value="include/ajout_collaborateur_modal.jsp"></s:include>
				<!-- End Ajout Collaborateur Modal Form -->
			
				<!-- Begin Send Message to collaborateur Modal -->
					<s:include value="include/send_msg_collaborateur_modal.jsp"></s:include>	
				<!-- End Send Message to collaborateur Modal -->
				
				<!-- Begin Gestion des habilitations -->
					<s:include value="include/gestion_habilitations.jsp"></s:include>	
				<!-- End Gestion des habilisation -->
				
	        </div>
	        <!--body wrapper end-->
	
	        <!--footer section start-->
	        <footer class="sticky-footer">
	            2014 &copy; Mouad & Mohamed
	        </footer>
	        <!--footer section end-->
	
	
	    </div>
	    <!-- main content end-->
	</section>