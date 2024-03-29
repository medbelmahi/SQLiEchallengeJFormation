<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>JFormation : Login</title>

    <link href='<s:url value="/css/style.css"/>' rel="stylesheet">
    <link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

	<div class="container">
		
	    <s:form cssClass="form-signin" action="login" method="post">
	        <div class="form-signin-heading text-center">
<!-- 	            <h1 class="sign-title">Se connecter</h1> -->
	            <img src="images/login-logo.png" alt=""/>
	        </div>
	        <div class="login-wrap">
	
				<!-- Message d'erreur -->
				<s:if test="isSessionActionError()">
					<h5 class="text-danger">
						<s:property value="sessionActionErrorText" />
					</h5>
				</s:if>
				<s:if test="isSessionActionMessage()">
					<h5 class="text-success">
						<s:property value="sessionActionMessageText" />
					</h5>
				</s:if>
				
				
				<s:textfield tautocomplete="on" ype="text" cssClass="form-control" placeholder="Email" autofocus="true" name="email" required="true" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" />
	            <s:textfield autocomplete="on" type="password" cssClass="form-control" placeholder="Mot de passe" required="true" name="password" />
	
	            <button class="btn btn-lg btn-login btn-block" type="submit" style="font-size: 19px;" >Se connecter
<!-- 	                <i class="fa fa-check"></i> -->
	            </button>
				
				<div style="margin-top: 15px; padding-right: 15px;" class="row">
					<span class="pull-right">
	                    <a data-toggle="modal" href="#myModal"  style="color: #D9534F;"> Mot de passe oublié ?</a>
	
	                </span>
				</div>
				
	
	        </div>
	    </s:form>
		
		<!-- Modal -->
	        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
	            <div class="modal-dialog">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                        <h4 class="modal-title">Mot de passe oublié ?</h4>
	                    </div>
	                    <form action="resetpassword" id="reset_password" method="post">
		                    <div class="modal-body">
		                        <p>Entrez votre adresse e-mail ci-dessous pour réinitialiser votre mot de passe.</p>
		                        <input type="email" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$">
		
		                    </div>
		                    <div class="modal-footer">
		                        <button data-dismiss="modal" class="btn btn-default" type="button">Annuler</button>
		                        <button class="btn btn-primary" type="submit">Envoyer</button>
		                    </div>
		                </form>
	                </div>
	            </div>
	        </div>
	     <!-- modal -->
	
	</div>
	
	<script src='<s:url value="/js/jquery-1.10.2.min.js"/>'></script>
	<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
	<script src='<s:url value="/js/modernizr.min.js"/>'></script>

</body>
</html>