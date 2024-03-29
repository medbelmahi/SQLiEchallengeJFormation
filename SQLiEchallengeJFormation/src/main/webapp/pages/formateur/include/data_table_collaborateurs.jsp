<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Tableau des collaborateurs Start -->
<div class="row">
	<form action="absence"  method="post">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				Liste des collaborateurs <span class="tools pull-right">
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						
						
							<div class="row" style="margin-top: 10px; margin-left: 20px; margin-right: 20px;">
							
								<input type="hidden" name="idSession" value='<s:property value="idSession" />'>
								<div class="row">
								<div class="col-sm-4">
									<select name="idSeance" class="form-control m-bot15">
						                <s:iterator value="sessionFormation.sceances" >
						                	<option value='<s:property value="idSeance" />'><s:property value="titreSeance" /> [De <s:property value="heureDebut" /> à <s:property value="heureFin" />]</option>
						                </s:iterator>
						            </select>
						        </div>
								<div class="col-sm-3" ><h4 style="margin-bottom: 0; margin-top: 8px; text-align: left;">Choisir une seance </h4></div>
									
							    <div class="col-sm-5"></div>
								</div>
								<div class="row" style="margin-bottom: 10px; margin-top: 10px;">
									<div class="col-sm-1"><input id="selectAll" type="checkbox" class="js-switch-red" checked /></div>
									<div class="col-sm-3"><h4 style="margin-bottom: 0; margin-top: 6px; text-align: left;">Selectionner tout</h4></div>
									<div class="col-sm-5"></div>
									<div class="col-sm-3"><button type="submit" class="btn btn-block btn-primary">Marquer l'absence</button></div>
								</div>
							</div>
						
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="hidden-table-info">
							<thead>
								<tr role="row">
									<th class="text-center" >Cocher</th>
									<th class="text-center sorting">Prénom &amp; Nom</th>
									<th class="text-center">Email</th>
									<th class="text-center">Telephone</th>
									<th class="text-center">Sexe</th>
<!-- 									<th>Options</th> -->
									<th style="display: none;">Adresse</th>
									<th>Date de naissance</th>
									<th style="display: none;">habilitations</th>
									<th style="display: none;">image</th>
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="inscriptions">
									<tr class="gradeA odd">
										<td><input name="idCollaborateurs" value='<s:property value="collaborateur.idCollaborateur" />' type="checkbox" class="js-switch-red"/></td>
										<td class="text-center sorting_1"><s:property value="collaborateur.fullname" /></td>
										<td class=" "><s:property value="collaborateur.emailCollaborateur" /></td>
										<td class=""><s:property value="collaborateur.telephoneCollaborateur" /></td>
										<td class="text-center"><s:property value="collaborateur.sexeCollaborateur" /></td>
										
										<td style="display: none;"><s:property value="collaborateur.adresseCollaborateur" /></td>
										<td class="text-center"><s:property value="collaborateur.dateNaissanceCollaborateur" /></td>
										
										<td style="display: none;">
											<ul>
												<s:iterator value="collaborateur.habilitations">
													<li><s:property value="nomHabilitation" /></li>
												</s:iterator>
											</ul>
										</td>
										<td style="display: none;"><s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="collaborateur.urlPhotoCollaborateur" />
																	</s:param></s:url></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</div>
	</form>
</div>
<!-- Tableau des collaborateurs End -->