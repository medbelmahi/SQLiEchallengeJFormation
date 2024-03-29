<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<link rel="shortcut icon" href="#" type="image/png">
	
	<title>Formateur: Gestion des sessions</title>
	
	<!--dynamic table-->
  	<link href='<s:url value="/js/advanced-datatable/css/demo_page.css"/>' rel="stylesheet" />
  	<link href='<s:url value="/js/advanced-datatable/css/demo_table.css"/>' rel="stylesheet" />
  	<link rel="stylesheet" href='<s:url value="/js/data-tables/DT_bootstrap.css"/>' />

	
	<!-- initial style -->
	<link href='<s:url value="/css/style.css"/>' rel="stylesheet">
	<link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">
	
	
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
	        	<s:include value="/pages/administrateur/include/header_section.jsp"></s:include>
	        <!-- header section end-->
	
	        <!-- page heading start-->
	        <div class="page-heading">
	            <h3>
	                Formateur<small>Gestion des sessions</small>
	            </h3>
	        </div>
	        <!-- page heading end-->
	        <!--body wrapper start-->
	        <div class="wrapper">
	        
		        <div class="row"><!-- present working link Start-->
		            <div class="col-md-12">
		                <!--breadcrumbs start -->
		                <ul class="breadcrumb panel">
		                    <li><a href='<s:url value="/formateur/"/>'><i class="fa fa-home"></i> Accueil</a></li>
		                    <li><a href='<s:url value="/formateur/sessions/"/>'>Gestions des sessions</a></li>
		                    <li class="active">Liste des sessions</li>
		                </ul>
		                <!--breadcrumbs end -->
		            </div>
		       	</div><!-- present working link End-->
	       	
		       	<!-- Message action start-->
		        	<s:include value="/pages/administrateur/include/message_action.jsp"></s:include>
		        <!-- Message action end-->
		        
		      	<!-- Data table des sessions Start -->
					<s:include value="include/data_table_sessions.jsp"></s:include>
				<!-- Data table des sessions End -->
				
				
	        </div>
	        <!--body wrapper end-->
	
	        <!--footer section start-->
	        	<s:include value="/pages/include/footer.jsp"></s:include>
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
	
	
	<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>
	
	
</body>
</html>