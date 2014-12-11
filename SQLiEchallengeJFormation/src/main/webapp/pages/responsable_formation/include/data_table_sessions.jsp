<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des Sessions <span class="tools pull-right">
					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a> 
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addSessionModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Session <i class="fa fa-plus"></i>
							</button></a>
						</div>
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="dynamic-table">
<!-- 							id="hidden-table-info"> -->
							<thead>
								<tr role="row">
									<th class="text-center">Titre Session</th>
									<th class="text-center">Desciption</th>
									<th class="text-center">Lieu</th>
<!-- 									<th class="text-center">Formateur</th> -->
									<th class="text-center">Date de debut</th>
									<th class="text-center">Date de fin</th>
									<th class="text-center">Status</th>
									<th class="text-center">Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="sessions">
										<tr class="gradeA odd">
											<td><s:property value="titreSessionFormation" /></td>
											<td class="description_class"><s:property value="desciptionSessionFormation" /></td>
											<td><s:property value="lieuSessionFormation" /></td>
<%-- 											<td><s:property value="formateur.fullname" /></td> --%>
											<td><s:property value="dateDebutSessionFormation" /></td>
											<td><s:property value="dateFinSessionFormation" /></td>
											<td class="text-center">
												<s:if test='%{status() == 0}'>
													<span class="label label-sm btn-danger">Pas en cours</span>
												</s:if>
												<s:elseif test='%{status() == 1}'>
													<span class="label label-sm btn-success">En cours</span>
												</s:elseif>
												<s:else>
													<span class="label label-sm btn-warning">Terminée</span>
												</s:else>
											</td>
											<td style="width: 100px; vertical-align:middle;">
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li style="padding-right: 15px;">
														<a title="Liste des collaborateurs" href='<s:url action="formations/sessions/inscriptions/list" ><s:param name="idSession">
														<s:property value="idSessionFormation"/></s:param><s:param name="idFormation">
														<s:property value="idFormation"/></s:param>
														</s:url>'>
															<i class="fa fa-user"></i>
														</a>
													</li>
													
													<li style="padding-right: 15px;">
														<a href='javascript:void(0);'
														   onclick="jsonGetSession(<s:property value="idSessionFormation"/>);" 
														   title="Mise à jour">
															<i class="fa fa-pencil"></i>
														</a>
													</li>
													
													<li>
														<a data-href='<s:url action="formations/sessions/delete" ><s:param name="idSession">
														<s:property value="idSessionFormation"/></s:param><s:param name="idFormation">
														<s:property value="idFormation"/></s:param>
														</s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
															<i class="fa fa-times"></i>
														</a>
													</li>
												</ul>
											</td>
										</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>