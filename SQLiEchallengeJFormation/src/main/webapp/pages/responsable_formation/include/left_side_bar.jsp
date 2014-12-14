<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- left side bar Start -->
<div class="left-side sticky-left-side">

	<!--logo and iconic logo start-->
	<div class="logo">
		<a href="index.html"><img src='<s:url value="/images/logo.png"/>' alt=""></a>
	</div>

	<div class="logo-icon text-center">
		<a href="index.html"><img src='<s:url value="/images/logo_icon.png"/>' alt=""></a>
	</div>
	<!--logo and iconic logo end-->


	<div class="left-side-inner">

		<!-- visible to small devices only -->
		<div class="visible-xs hidden-sm hidden-md hidden-lg">
			<div class="media logged-user">
				<img alt="" src='<s:property value="%{#session.utilisateur.urlPhotoUtilisateur}" />' class="media-object">
				<div class="media-body">
					<h4>
						<a href="#"><s:property value="%{#session.utilisateur.fullname}" /></a>
					</h4>
					<span>"Hello There..."</span>
				</div>
			</div>

			<h5 class="left-nav-title">Mon Compte</h5>
			<ul class="nav nav-pills nav-stacked custom-nav">
				<li><a href='<s:url value="/profil/display"/>'><i class="fa fa-user"></i> <span>Profile</span></a></li>
				<li><a href='<s:url value="/logout"/>'><i class="fa fa-sign-out"></i>Se deconnecter</a></li>
			</ul>
		</div>

		<!--sidebar nav start-->
		<ul class="nav nav-pills nav-stacked custom-nav">
		
			
			<li class="menu-list nav-active"><a href='<s:url value="/responsableFormation/formations/list"/>'><i
					class="fa fa-laptop"></i> <span>Gestion Formation</span></a>
				<ul class="sub-menu-list">
					<li class="active"><a href='<s:url value="/responsableFormation/formations/list"/>'>Liste des formations</a></li>
					<li><a href='<s:url value="/responsableFormation/formations/evaluation/questions/list"/>' > Evaluation des sessions</a></li>
				</ul></li>
			<li><a href='<s:url value="/responsableFormation/dashboard"/>'><i class="fa fa-bar-chart-o"></i> <span>Tableau de Bord</span></a></li>
			<li><a href='<s:url value="/profil/display"/>'><i class="fa fa-wrench"></i> <span>Compte</span></a></li>
			<li><a href='<s:url value="/logout"/>'><i class="fa fa-sign-out"></i> <span>Se déconnecter</span></a></li>

		</ul>
		<!--sidebar nav end-->

	</div>
</div>
<!-- left side bar End -->