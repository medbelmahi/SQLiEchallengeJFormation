<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des questions <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addQuestionModal" data-toggle="modal" ><button class="btn btn-primary">
								Ajouter Question <i class="fa fa-plus"></i>
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
									<th>Question</th>
									<th class="text-center">Options</th>
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="questions">
										<tr class="gradeA odd">
											<td><s:property value="question" /></td>
											<td class="center text-center">
												
												<ul style="list-style: none; width: 60px;" class="navbar-nav nav-options">
													
													<li style="padding-left: 15px;">
														<a data-href='<s:url action="formations/evaluation/questions/delete" ><s:param name="idQuestion"><s:property value="idEvaluationQuestion"/></s:param></s:url>' data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
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