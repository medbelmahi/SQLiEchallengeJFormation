<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="col-sm-12">
	<!-- <form action="">
	<div class="row">
		<div class="col-sm-5">Selectionner tout les élement du tableau</div>
		<div class="col-sm-3"><input type="checkbox" class="js-switch" checked/></div>
		<div class="col-sm-4"><button type="submit" class="btn btn-primary">Inscrir les collaborateur</button></div>
	</div> -->

	<div class="row">
		<div id="hidden-table-info_wrapper"
			class="dataTables_wrapper form-inline" role="grid">
		
			<table aria-describedby="hidden-table-info_info"
				class="display table table-bordered dataTable"
				id="dynamic-table_2">
		<!-- 	id="hidden-table-info"> -->
		
				<thead>
					<tr role="row">
<!-- 						<th>Choisir</th> -->
						<th>Prènom &amp; Nom</th>
						<th>Telphone</th>
						<th>Email</th>
						<th>Sexe</th>
						<th>Status</th>
						<th>Options</th>
						<!-- <th style="display: none;">Actions</th> -->
					</tr>
				</thead>
		
				<tbody aria-relevant="all" aria-live="polite" role="alert">
					<s:iterator value="collaborateurInscrit">
							<tr class="gradeA odd">
<!-- 								<td><input type="checkbox" class="js-switch"/></td> -->
								<td><s:property value="collaborateur.fullname" /></td>
								<td><s:property value="collaborateur.telephoneCollaborateur" /></td>
								<td><s:property value="collaborateur.emailCollaborateur" /></td>
								<td><s:property value="collaborateur.sexeCollaborateur" /></td>
								<s:if test='%{status==1}'>  
									<td>confirmé</td>
								</s:if>
								<s:elseif test='%{status==0}'>
									<td>non confirmé</td>
								</s:elseif>
								<s:else>
									<td>non traité (<s:property value="status" />)</td>
								</s:else>
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
	</div>
<!-- 	</form> -->
</div>