<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Les Profils <span class="tools pull-right">
					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a> 
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<button href="#addProfilModal" data-toggle="modal" class="btn btn-primary">
								Ajouter Profil <i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="hidden-table-info">
							<thead>
								<tr role="row">
									<th>Nom</th>
									<th>Role de Base</th>
									<th>Desciption</th>
									<th>Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="profils">
									<s:if test="isElementaire()">
										<tr style="background-color:#eee;">
											<td><s:property value="nomProfil" /></td>
											<td><s:property value="roleBase" /></td>
											<td><s:property value="description" /></td>
											<td>
												<!-- Le profil est elementaire (n'est pas besoin de se modifier) -->
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
														<li style="padding-left: 15px;">
															<a href='javascript:void(0);'
															   onclick='jsonGetProfil_pourAffectation(<s:property value="idProfil"/>);' 
															   title="Affectation des actions">
																<i class="fa fa-bolt"></i>
															</a>
														</li>
													</ul>
												
											</td>
											
											<%-- <td style="display: none;">
												<ul>
													<s:iterator value="actions">
														<li><s:property value="nomAction" /></li>
													</s:iterator>
												</ul>
											</td> --%>
										</tr>
									</s:if>
									<s:else>
										<tr class="gradeA odd">
											<td><s:property value="nomProfil" /></td>
											<td><s:property value="roleBase" /></td>
											<td><s:property value="description" /></td>
											
												<td class="center hidden-phone ">
													<ul style="list-style: none;" class="navbar-nav nav-options">
														
														<%-- <li style="padding-left: 15px;">
															<a href='javascript:void(0);'
															   onclick="jsonGetProfil(<s:property value="idProfil"/>);" 
															   title="Mise à jour">
																<i class="fa fa-pencil"></i>
															</a>
														</li> --%>
														
														<li style="padding-left: 15px;">
															<a data-href='<s:url action="profils/delete" ><s:param name="idProfil"><s:property value="idProfil"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
																<i class="fa fa-times"></i>
															</a>
														</li>
														<li style="padding-left: 15px;">
															<a href='javascript:void(0);'
															   onclick='jsonGetProfil_pourAffectation(<s:property value="idProfil"/>);' 
															   title="Affectation des actions">
																<i class="fa fa-bolt"></i>
															</a>
														</li>
													</ul>
												</td>
												
												<%-- <td style="display: none;">
													<ul>
														<s:iterator value="actions">
															<li><s:property value="nomAction" /></li>
														</s:iterator>
													</ul>
												</td> --%>
										</tr>
									</s:else>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>