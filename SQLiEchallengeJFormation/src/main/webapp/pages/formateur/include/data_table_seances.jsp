<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des seances<span class="tools pull-right"> <a
					href="javascript:;" class="fa fa-chevron-down"></a> 
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table editable-table ">
					<div class="clearfix">
						<div class="btn-group">
							<!-- <button id="editable-sample_new" class="btn btn-primary">
								Add New <i class="fa fa-plus"></i>
							</button> -->
						</div>
						<div class="btn-group pull-right">
							<!-- <button class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								Tools <i class="fa fa-angle-down"></i>
							</button>
							<ul class="dropdown-menu pull-right">
								<li><a href="#">Print</a></li>
								<li><a href="#">Save as PDF</a></li>
								<li><a href="#">Export to Excel</a></li>
							</ul> -->
						</div>
					</div>
					<div class="space15"></div>
					<table class="table table-striped table-hover table-bordered"
						id="editable-sample">
						<thead>
							<tr>
								<th style="display:none;">id</th>
								<th>Titre</th>
								<th>Description</th>
		                        <th class="text-center">Date</th>
		                        <th class="text-center">Heure dèbut</th>
		                        <th class="text-center">Heure fin</th>
		                        <th>Mise à jour</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="sessionFormation.sceances" >
							<tr class="">
<%-- 								<input type="hidden" id='theIdSeance_<s:property value="idSeance" />' value='<s:property value="idSeance" />' /> --%>
								<td style="display: none;" ><s:property value="idSeance" /></td>
								<td class="text-center"><s:property value="titreSeance" /></td>
								<td class="text-center"><s:property value="descriptionSeance" /></td>
								<td class="text-center"><s:property value="dateSeance" /></td>
		                        <td class="text-center"><s:property value="heureDebut" /></td>
		                        <td class="text-center"><s:property value="heureFin" /></td>
								<td class="text-center"><a class="edit" href="javascript:;">Mise à jour</a></td>
<!-- 								<td><a class="delete" href="javascript:;">Delete</a></td> -->
							</tr>
						</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>
</div>