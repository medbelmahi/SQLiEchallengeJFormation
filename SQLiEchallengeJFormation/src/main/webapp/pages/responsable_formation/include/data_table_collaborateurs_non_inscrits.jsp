<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="hidden-table-info_wrapper"
	class="dataTables_wrapper form-inline" role="grid">

	<table aria-describedby="hidden-table-info_info"
		class="display table table-bordered dataTable"
		id="dynamic-table">
<!-- 	id="hidden-table-info"> -->

		<thead>
			<tr role="row">
				<th><input type="checkbox" class="js-switch" checked/></th>
				<th>Prènom & Nom</th>
				<th>Telphone</th>
				<th>Email</th>
				<th>Sexe</th>
				<th>Options</th>
				<!-- <th style="display: none;">Actions</th> -->
			</tr>
		</thead>

		<tbody aria-relevant="all" aria-live="polite" role="alert">
			<s:iterator value="collaborateurNonInscrit">
					<tr class="gradeA odd">
						<td>coucou</td>
						<td><s:property value="fullname" /></td>
						<td><s:property value="telephoneCollaborateur" /></td>
						<td><s:property value="emailCollaborateur" /></td>
						<td><s:property value="sexeCollaborateur" /></td>
						<td class="center hidden-phone ">
							
							<ul style="list-style: none;" class="navbar-nav nav-options">
								
								<%-- <li style="padding-left: 15px;">
									<a title="Liste des sessions" href='<s:url action="formations/sessions/list" ><s:param name="idFormation"><s:property value="idFormation"/></s:param></s:url>'>
										<i class="fa fa-list"></i>
									</a>
								</li>
								
								<li style="padding-left: 15px;">
									<a href='javascript:void(0);'
									   onclick="jsonGetFormation(<s:property value="idFormation"/>);" 
									   title="Mise à jour">
										<i class="fa fa-pencil"></i>
									</a>
								</li>
								
								<li style="padding-left: 15px;">
									<a data-href='<s:url action="formations/delete" ><s:param name="idFormation"><s:property value="idFormation"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
										<i class="fa fa-times"></i>
									</a>
								</li> --%>
							</ul>
						</td>
					</tr>
			</s:iterator>
		</tbody>
	</table>
</div>