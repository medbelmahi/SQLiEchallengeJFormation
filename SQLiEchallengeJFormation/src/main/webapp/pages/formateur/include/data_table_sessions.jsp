<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des Sessions <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<!-- <div class="btn-group">
							<a href="#addSessionModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Session <i class="fa fa-plus"></i>
							</button></a>
						</div> -->
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="dynamic-table">
<!-- 							id="hidden-table-info"> -->
							<thead>
								<tr role="row">
									<th class="text-center sorting">Titre Session</th>
									<th class="text-center">Formation</th>
									<th style="display : none;" class="text-center">Desciption</th>
									<th class="text-center">Lieu</th>
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
											<td><s:property value="formation.titreFormation" /></td>
											<td style="display : none;"><s:property value="desciptionSessionFormation" /></td>
											<td><s:property value="lieuSessionFormation" /></td>
											
											<td class="text-center"><s:property value="dateDebutSessionFormation" /></td>
											<td class="text-center"><s:property value="dateFinSessionFormation" /></td>
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
											<td class="text-center">
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li style="padding-right: 15px;">
														<a title="Liste des documents" href='<s:url action="sessions/documents/list" >
														<s:param name="idSession"><s:property value="idSessionFormation"/></s:param>
														
														</s:url>'>
															<i class="fa fa-folder-open"></i>
														</a>
													</li>
													
													<li style="padding-right: 15px;">
														<a title="Liste des séances" href='<s:url action="sessions/seances/list" >
														<s:param name="idSession"><s:property value="idSessionFormation"/></s:param>
														
														</s:url>'>
															<i class="fa fa-table"></i>
														</a>
													</li>
													
													<li >
														<a title="Gestion d'absence" href='<s:url action="sessions/collaborateurs/list" >
														<s:param name="idSession"><s:property value="idSessionFormation"/></s:param>
														
														</s:url>'>
															<i class="fa fa-user"></i>
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