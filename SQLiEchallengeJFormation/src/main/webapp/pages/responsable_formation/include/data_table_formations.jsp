<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des formations <span class="tools pull-right">
					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a> 
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addFormationModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Formation <i class="fa fa-plus"></i>
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
									<th class="text-centre">Titre formation</th>
									<th class="text-centre">Desciption</th>
									<th class="text-centre">Date de création</th>
									<th class="text-centre">Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="formations">
										<tr class="gradeA odd">
											<td><s:property value="titreFormation" /></td>
											<td class="description_class"><s:property value="descriptionFormation" /></td>
											<td><s:property value="dateCreationFormation" /></td>
											<td class="td_option_class" style="width : 110px; vertical-align:middle;">
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li style="padding-right: 15px;">
														<a title="Liste des sessions" href='<s:url action="formations/sessions/list" ><s:param name="idFormation"><s:property value="idFormation"/></s:param></s:url>'>
															<i class="fa fa-list"></i>
														</a>
													</li>
													
													<li style="padding-right: 15px;">
														<a href='javascript:void(0);'
														   onclick="jsonGetFormation(<s:property value="idFormation"/>);" 
														   title="Mise à jour">
															<i class="fa fa-pencil"></i>
														</a>
													</li>
													
													<li>
														<a data-href='<s:url action="formations/delete" ><s:param name="idFormation"><s:property value="idFormation"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
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