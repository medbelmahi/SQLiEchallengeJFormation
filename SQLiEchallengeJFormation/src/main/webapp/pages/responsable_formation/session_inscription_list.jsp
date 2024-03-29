<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<link rel="shortcut icon" href="#" type="image/png">
	
	<title>Responsable formation: Gestion des inscriptions</title>
	
	<!--dynamic table-->
  	<link href='<s:url value="/js/advanced-datatable/css/demo_page.css"/>' rel="stylesheet" />
  	<link href='<s:url value="/js/advanced-datatable/css/demo_table.css"/>' rel="stylesheet" />
  	<link rel="stylesheet" href='<s:url value="/js/data-tables/DT_bootstrap.css"/>' />
	
	<!--ios7-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/js/ios-switch/switchery.css"/>' />


    <link href='<s:url value="/js/iCheck/skins/square/square.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/purple.css"/>' rel="stylesheet">


    
	
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
	                Responsable formation <small>Gestion des inscriptions</small>
	            </h3>
	        </div>
	        <!-- page heading end-->
	        
	        <!--body wrapper start-->
	        <div class="wrapper">
	        
		        <div class="row"><!-- present working link Start-->
		            <div class="col-md-12">
		                <!--breadcrumbs start -->
		                <ul class="breadcrumb panel">
		                	<li><a href='<s:url value="/responsableFormation/" />'><i class="fa fa-home"></i> Accueil</a></li>
		                    <li><a href='<s:url value="/responsableFormation/formations/list" />'>liste des formation</a></li>
		                    <li><a href='<s:url action="formations/sessions/list" ><s:param name="idSession">
														<s:property value="idSession"/></s:param><s:param name="idFormation">
														<s:property value="idFormation"/></s:param>
														</s:url>'>Liste des sessions</a></li>
		                    <li class="active">Gestion d'inscription</li>
		                </ul>
		                <!--breadcrumbs end -->
		            </div>
		       	</div><!-- present working link End-->
	       	
		       	<!-- Message action start-->
		        	<s:include value="/pages/administrateur/include/message_action.jsp"></s:include>
		        <!-- Message action end-->
		        
		        <div class="row">
					<div class="col-sm-12">
						
						<section class="panel">
							<header class="panel-heading custom-tab dark-tab">
								<ul class="nav nav-tabs">
									<s:if test='%{sessionFormation.status() != 2}'>
										<li class="">
											<a href="#collaborateruInscrits" data-toggle="tab">Collaborateur inscrits</a>
										</li>
									
										<li class="active">
											<a href="#collaborateruNonInscrits" data-toggle="tab">Collaborateur non inscrits</a>
										</li>
									</s:if>
									<s:else>
										<li class="active">
											<a href="#collaborateruInscrits" data-toggle="tab">Collaborateur inscrits</a>
										</li>
									</s:else>
									
								   
								</ul>
							</header>
							<div class="panel-body">
								<div class="tab-content">
								
									<s:if test='%{sessionFormation.status() != 2}'>
										<div class="tab-pane" id="collaborateruInscrits">
											
											<!-- Data table des collaborateurs inscrits Start -->
												<s:include value="include/data_table_collaborateurs_inscrits.jsp"></s:include>
											<!-- Data table des collaborateurs inscrits End -->
	
										</div>
									
										<div class="tab-pane active" id="collaborateruNonInscrits">
											<s:fielderror></s:fielderror>
											<!-- Data table des collaborateurs non inscrits Start -->
												<s:include value="include/data_table_collaborateurs_non_inscrits.jsp"></s:include>
											<!-- Data table des collaborateurs non inscrits End -->
	
										</div>
									</s:if>
									<s:else>
										<div class="tab-pane active" id="collaborateruInscrits">
											
											<!-- Data table des collaborateurs inscrits Start -->
												<s:include value="include/data_table_collaborateurs_inscrits.jsp"></s:include>
											<!-- Data table des collaborateurs inscrits End -->
	
										</div>
									</s:else>
									
								</div>
							</div>
						</section>
					
					</div>
				</div>
		        
		      	
				
		      	
				
				<!-- Start Show informations d'un collaborateur Modal Form -->
					<s:include value="include/show_collaborateur_info_modal.jsp"></s:include>
				<!-- End Show informations d'un collaborateur Modal Form -->
				
			
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
	
	<!--ios7-->
	<script src='<s:url value="/js/ios-switch/switchery.js"/>' ></script>
	<script src='<s:url value="/js/ios-switch/ios-init.js"/>' ></script>
	
	<!--icheck -->
	<script src='<s:url value="/js/iCheck/jquery.icheck.js"/>'></script>
	<script src='<s:url value="/js/icheck-init.js"/>'></script>

	
	<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>
	
	
	<!-- javascript of inscritption_collaborateur_list page Begin -->
		<s:include value="include/javascript_inscritption_collaborateur_list.jsp"></s:include>
	<!-- javascript of inscritption_collaborateur_list page End -->
	
</body>
</html>