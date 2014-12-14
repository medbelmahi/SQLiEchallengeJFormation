<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des seances<span class="tools pull-right"> 
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table editable-table ">
					<div class="clearfix">
						<div class="btn-group">
						</div>
						<div class="btn-group pull-right">
						</div>
					</div>
					<div class="space15"></div>
					<table class="table table-striped table-hover table-bordered"
						id="editable-sample">
						<thead>
							<tr>
								<th class="text-center" style="display:none;">id</th>
								<th class="text-center">Titre</th>
								<th class="text-center">Description</th>
		                        <th class="text-center">Date</th>
		                        <th class="text-center">Heure dèbut</th>
		                        <th class="text-center">Heure fin</th>
		                        <th class="text-center">Mise à jour</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="sessionFormation.sceances" >
							<tr class="">
								<td style="display: none;" ><s:property value="idSeance" /></td>
								<td class="text-center"><s:property value="titreSeance" /></td>
								<td class="text-center"><s:property value="descriptionSeance" /></td>
								<td class="text-center"><s:property value="dateSeance" /></td>
		                        <td class="text-center"><s:property value="heureDebut" /></td>
		                        <td class="text-center"><s:property value="heureFin" /></td>
								<td class="text-center"><a class="edit" href="javascript:;"><button class="btn btn-danger btn-xs" type="button">Mise à jour</button></a></td>
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