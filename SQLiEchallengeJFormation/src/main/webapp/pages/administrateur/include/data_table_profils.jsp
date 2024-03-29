<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des profils <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addProfilModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Profil <i class="fa fa-plus"></i>
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
									<th class="text-center">Nom</th>
									<th class="text-center">Role de Base</th>
									<th class="text-center">Desciption</th>
									<th class="text-center">Options</th>
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
											<td class="text-center">
												<!-- Le profil est elementaire (n'est pas besoin de se modifier) -->
												
												<ul style="list-style: none; width: 70px;" class="navbar-nav nav-options td_option_class">
														<li>
															<a href='javascript:void(0);'
															   onclick='jsonGetProfil_pourAffectation(<s:property value="idProfil"/>);' 
															   title="Affectation des actions">
																<i class="fa fa-bolt"></i>
															</a>
														</li>
													</ul>
												
											</td>
											
										</tr>
									</s:if>
									<s:else>
										<tr class="gradeA odd">
											<td><s:property value="nomProfil" /></td>
											<td><s:property value="roleBase" /></td>
											<td><s:property value="description" /></td>
											
												<td class="text-center">
													<ul style="list-style: none;" class="navbar-nav nav-options">
														
														<li style="padding-right: 15px;">
															<a data-href='<s:url action="profils/delete" ><s:param name="idProfil"><s:property value="idProfil"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
																<i class="fa fa-trash-o"></i>
															</a>
														</li>
														<li>
															<a href='javascript:void(0);'
															   onclick='jsonGetProfil_pourAffectation(<s:property value="idProfil"/>);' 
															   title="Affectation des actions">
																<i class="fa fa-bolt"></i>
															</a>
														</li>
													</ul>
												</td>
												
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