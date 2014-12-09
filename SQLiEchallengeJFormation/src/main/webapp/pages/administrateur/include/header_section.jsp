<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Header section Start -->
<div class="header-section">

	<!--toggle button start-->
	<a class="toggle-btn"><i class="fa fa-bars"></i></a>
	<!--toggle button end-->

	<!--notification menu start -->
	<div class="menu-right">
		<ul class="notification-menu">
			
			<li><a href="#" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown"> 
				<img src='<s:property value="%{#session.utilisateur.urlPhotoUtilisateur}" />' alt="" /><s:property value="%{#session.utilisateur.fullname}" /> <span class="caret"></span>
			</a>
				<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
					<li><a href='<s:url value="/profil/display"/>'><i class="fa fa-user"></i> Profile</a></li>
					<li><a href="<s:url value="/logout"/>"><i class="fa fa-sign-out"></i>Se deconnecter</a></li>
				</ul></li>

		</ul>
	</div>
	<!--notification menu end -->
	

</div>
<!-- Header section End -->