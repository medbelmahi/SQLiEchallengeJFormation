<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des habilitations <span class="tools pull-right">
					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a> 
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
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

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="dynamic-table">
<!-- 							id="hidden-table-info"> -->
							<thead>
								<tr role="row">
									<th>Nom</th>
									<th>Desciption</th>
									<th>Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="habilitations">
										<tr class="gradeA odd">
											<td><s:property value="nomHabilitation" /></td>
											<td><s:property value="descriptionHabilitation" /></td>
											<td class="center hidden-phone ">
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li style="padding-left: 15px;">
														<a data-href='<s:url action="habilitations/delete" ><s:param name="idHabilitation"><s:property value="idHabilitation"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
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