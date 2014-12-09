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
					<span>"Bienvenu..."</span>
				</div>
			</div>

			<h5 class="left-nav-title">Account Information</h5>
			<ul class="nav nav-pills nav-stacked custom-nav">
				<li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
				<li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
				<li><a href="<s:url value="/logout"/>"><i class="fa fa-sign-out"></i>Se deconnecter</a></li>
			</ul>
		</div>

		<!--sidebar nav start-->
		<ul class="nav nav-pills nav-stacked custom-nav">
		
			<li><a href="index.html"><i class="fa fa-home"></i> <span>Profil</span></a></li>
			<li class="menu-list nav-active"><a href='<s:url value="/administrateur/collaborateurs/list"/>'><i
					class="fa fa-laptop"></i> <span>Gestion collaborateur</span></a>
				<ul class="sub-menu-list">
					<li class="active"><a href='<s:url value="/administrateur/collaborateurs/list"/>'>Liste des collaborateurs</a></li>
					<li><a href='<s:url value="/administrateur/habilitations/list"/>'> Gestion des habilitations</a></li>
				</ul></li>
			<li class="menu-list"><a href='<s:url value="/administrateur/profils/list"/>'><i class="fa fa-book"></i>
					<span>Gestion profil</span></a>
				<ul class="sub-menu-list">
					<li><a href='<s:url value="/administrateur/profils/list"/>' > Listes des profils</a></li>
				</ul>
			</li>
				

			<li class="menu-list"><a href='<s:url value="/administrateur/utilitateurs/list"/>'><i class="fa fa-envelope"></i>
					<span>Gestion utilisateur</span></a>
				<ul class="sub-menu-list">
					<li><a href='<s:url value="/administrateur/utilitateurs/list"/>'> Liste des utilisateurs</a></li>
				</ul>
			</li>

		</ul>
		<!--sidebar nav end-->

	</div>
</div>
<!-- left side bar End -->