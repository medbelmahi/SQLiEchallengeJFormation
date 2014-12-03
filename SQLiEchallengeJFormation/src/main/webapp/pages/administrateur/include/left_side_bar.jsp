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
				<img alt="" src='<s:url value="/images/photos/user-avatar.png"/>' class="media-object">
				<div class="media-body">
					<h4>
						<a href="#"><s:property value="%{#session.utilisateur.fullname}" /></a>
					</h4>
					<span>"Hello There..."</span>
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
			<li class="menu-list nav-active"><a href=""><i
					class="fa fa-laptop"></i> <span>Gestion collaborateur</span></a>
				<ul class="sub-menu-list">
					<li class="active"><a href="blank_page.html"> Blank Page</a></li>
					<li><a href="boxed_view.html"> Boxed Page</a></li>
					<li><a href="leftmenu_collapsed_view.html"> Sidebar
							Collapsed</a></li>
					<li><a href="horizontal_menu.html"> Horizontal Menu</a></li>

				</ul></li>
			<li class="menu-list"><a href=""><i class="fa fa-book"></i>
					<span>Gestion profil</span></a>
				<ul class="sub-menu-list">
					<li><a href="general.html"> General</a></li>
					<li><a href="buttons.html"> Buttons</a></li>
					<li><a href="tabs-accordions.html"> Tabs &amp; Accordions</a></li>
					<li><a href="typography.html"> Typography</a></li>
					<li><a href="slider.html"> Slider</a></li>
					<li><a href="panels.html"> Panels</a></li>
				</ul>
			</li>
				
			<li class="menu-list"><a href=""><i class="fa fa-cogs"></i>
					<span>Components</span></a>
				<ul class="sub-menu-list">
					<li><a href="grids.html"> Grids</a></li>
					<li><a href="gallery.html"> Media Gallery</a></li>
					<li><a href="calendar.html"> Calendar</a></li>
					<li><a href="tree_view.html"> Tree View</a></li>
					<li><a href="nestable.html"> Nestable</a></li>

				</ul></li>


			<li class="menu-list"><a href=""><i class="fa fa-envelope"></i>
					<span>Gestion utilisateur</span></a>
				<ul class="sub-menu-list">
					<li><a href="mail.html"> Inbox</a></li>
					<li><a href="mail_compose.html"> Compose Mail</a></li>
					<li><a href="mail_view.html"> View Mail</a></li>
				</ul>
			</li>

		</ul>
		<!--sidebar nav end-->

	</div>
</div>
<!-- left side bar End -->