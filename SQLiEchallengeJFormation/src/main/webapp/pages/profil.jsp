<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<link rel="shortcut icon" href="#" type="image/png">
	
	<title>Compte : Votre profil (<s:property value="%{#session.utilisateur.fullname}" />)</title>
	
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

	<!--file upload-->
    <link rel="stylesheet" type="text/css" href='<s:url value="/css/bootstrap-fileupload.min.css"/>' />
    
	<!--pickers css-->
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-datepicker/css/datepicker-custom.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-timepicker/css/timepicker.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-colorpicker/css/colorpicker.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-daterangepicker/daterangepicker-bs3.css"/>' />
	<link rel="stylesheet" type="text/css" href='<s:url value="/js/bootstrap-datetimepicker/css/datetimepicker-custom.css"/>' />
	
	
	<!-- initial style -->
	<link href='<s:url value="/css/style.css"/>' rel="stylesheet">
	<link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">
	
	
	<style type="text/css">
		
		.input-password-valid {
		    color: green;
		}
		.input-password-not-valid {
		    color: red;
		}
		
		.input-validation::before {
		    content: "\2713";
		    color: green;
		    position: relative;
			top: 6px;
		}
		
		input[type="text"]:invalid {
		    color: red;
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
		
		<s:set name="myVarUserProfil" value="%{#session.utilisateur.profil.roleBase}"/>
		 <!-- left side start-->
		<s:if test="%{#myVarUserProfil=='Administrateur'}">
			<s:include value="/pages/administrateur/include/left_side_bar.jsp"></s:include>
		</s:if>
		<s:elseif test="%{#myVarUserProfil=='Responsable de formation'}">
			<s:include value="/pages/responsable_formation/include/left_side_bar.jsp"></s:include>
		</s:elseif>
		<s:else>
			<s:include value="/pages/formateur/include/left_side_bar.jsp"></s:include>
		</s:else>
	    <!-- left side end-->
	    
	    <!-- main content start-->
	    <div class="main-content" >
	
	        <!-- header section start-->
	        	<s:include value="/pages/administrateur/include/header_section.jsp"></s:include>
	        <!-- header section end-->
	
	        <!-- page heading start-->
	        <div class="page-heading">
	            <h3>
	                Bienvenu   <small><s:property value="%{#session.utilisateur.fullname}" /></small>
	            </h3>
	        </div>
	        <!-- page heading end-->
	        <!--body wrapper start-->
	        <div class="wrapper">
	        
		        <div class="row"><!-- present working link Start-->
		            <div class="col-md-12">
		                <!--breadcrumbs start -->
		                <ul class="breadcrumb panel">
		                	<s:if test="%{#myVarUserProfil=='Administrateur'}">
								<li><a href='<s:url value="/administrateur/"/>'><i class="fa fa-home"></i> Accueil</a></li>
							</s:if>
							<s:elseif test="%{#myVarUserProfil=='Responsable de formation'}">
								<li><a href='<s:url value="/responsableFormation/"/>'><i class="fa fa-home"></i> Accueil</a></li>
							</s:elseif>
							<s:else>
								<li><a href='<s:url value="/formateur/"/>'><i class="fa fa-home"></i> Accueil</a></li>
							</s:else>
		                    
		                    <li class="active">Mon profil</li>
		                </ul>
		                <!--breadcrumbs end -->
		            </div>
		       	</div><!-- present working link End-->
	       		
	       		
	       		<!-- Message action start-->
		        	<s:include value="/pages/administrateur/include/message_action.jsp"></s:include>
		        <!-- Message action end-->
	       		
			
			
	       		<!-- Profil start-->
		        	<s:include value="include/compte_profil_info.jsp"></s:include>
		        <!-- Profil end-->
		        
		        
		        <!-- Update profil Modal Form -->
					<s:include value="include/update_compte_profil_modal.jsp"></s:include>
				<!-- End Update profil Modal Form -->
		        
		       	
				
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

	
	<!--ios7-->
	<script src='<s:url value="/js/ios-switch/switchery.js"/>' ></script>
	<script src='<s:url value="/js/ios-switch/ios-init.js"/>' ></script>
	
	<!--icheck -->
	<script src='<s:url value="/js/iCheck/jquery.icheck.js"/>'></script>
	<script src='<s:url value="/js/icheck-init.js"/>'></script>
	<!--file upload-->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-fileupload.min.js"/>'></script>

	
	<!--pickers plugins-->
	<script type="text/javascript" src='<s:url value="/js/bootstrap-datepicker/js/bootstrap-datepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-daterangepicker/moment.min.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-daterangepicker/daterangepicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/bootstrap-timepicker/js/bootstrap-timepicker.js"/>'></script>
	
	<!--pickers initialization-->
	<script src='<s:url value="/js/pickers-init.js"/>'></script>
	
	
	<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>
	
	
	
	<script type="text/javascript">
		$('.password-change').on("input", function() {
			  var password_1 = $('#newPassword_1');
			  var password_2 = $('#newPassword_2');
			  
			  if(password_1.val() == password_2.val()){
				  password_1.removeClass('input-password-not-valid');
				  password_2.removeClass('input-password-not-valid');
				  
				  password_1.addClass('input-password-valid');
				  password_2.addClass('input-password-valid');
				  $('#newPassword_1_valide').addClass('input-validation');
				  $('#newPassword_2_valide').addClass('input-validation');
			  }else{
				  password_1.removeClass('input-password-valid');
				  password_2.removeClass('input-password-valid');
				  $('#newPassword_1_valide').removeClass('input-validation');
				  $('#newPassword_2_valide').removeClass('input-validation');
				  
				  password_1.addClass('input-password-not-valid');
				  password_2.addClass('input-password-not-valid');
			  }
		});
		
		$('#changePassword_').change(function(){
			console.log($(this)[0].checked);
			if($(this)[0].checked){
				$('#newPassword_1').removeAttr("readonly");
				$('#newPassword_2').removeAttr("readonly");
			}else{
				$('#newPassword_1').attr("readonly","readonly");
				$('#newPassword_2').attr("readonly","readonly");
			}
		});
		
		
		
		$(function() {
		    $('#update_utilisateur').submit(function() {
		        
				if($('#changePassword_')[0].checked){
					var password_1 = $('#newPassword_1');
					var password_2 = $('#newPassword_2');
					if(password_1.val() == password_2.val()){
						return true;
					}
					return false;
				}

		        return true;
		    });
		});
	</script>
	
</body>
</html>