<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des habilitations <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addHabilitationModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Habilitation <i class="fa fa-plus"></i>
							</button></a>
						</div>
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info" class="display table table-bordered dataTable" 
								id="dynamic-table">
<!-- 							id="hidden-table-info"> -->
							<thead>
								<tr role="row">
									<th class="text-center">Nom</th>
									<th class="text-center">Desciption</th>
									<th class="text-center">Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="habilitations">
										<tr class="gradeA odd">
											<td class="text-center"><s:property value="nomHabilitation" /></td>
											<td><s:property value="descriptionHabilitation" /></td>
											<td class="text-center">
												<ul style="list-style: none; width: 60px;" class="navbar-nav nav-options">
													
													<li style="padding-left: 15px;">
														<a data-href='<s:url action="habilitations/delete" ><s:param name="idHabilitation"><s:property value="idHabilitation"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
															<i class="fa fa-trash-o"></i>
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