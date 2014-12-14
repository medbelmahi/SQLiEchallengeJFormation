<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des Documents <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addDocumentModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Document <i class="fa fa-plus"></i>
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
									<th class="text-centre">Titre du document</th>
									<th class="text-centre">Desciption</th>
									<th class="text-centre">Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="documents">
										<tr class="gradeA odd">
											<td><s:property value="nomDocument" /></td>
											<td><s:property value="descriptionDocument" /></td>
											<td style="width-min : 60px">
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li style="padding-right: 15px;">
														<a title="Telecharger le document" target="_blank" href='<s:url namespace="/" action="download" >
														<s:param name="file"><s:property value="urlDocument" /></s:param></s:url>'>
															<i class="fa fa-download"></i>
														</a>
													</li>
													
													
													<li>
														<a data-href='<s:url action="sessions/documents/delete">
														<s:param name="idDocument"><s:property value="idDocument"/></s:param>
														<s:param name="idSession"><s:property value="idSession"/></s:param>
														</s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
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