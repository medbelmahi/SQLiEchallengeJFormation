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
					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a> 
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						
						
							<div class="row" style="margin-top: 10px; margin-left: 20px; margin-right: 20px;">
							
								<input type="hidden" name="idSession" value='<s:property value="idSession" />'>
								<div class="row">
								<div class="col-sm-5">Choisir une seance</div>
									<div class="col-sm-7">
										<select name="idSeance" class="form-control m-bot15">
							                <s:iterator value="sessionFormation.sceances" >
							                	<option value='<s:property value="idSeance" />'><s:property value="titreSeance" /> ( De :  <s:property value="heureDebut" /> -> à : <s:property value="heureFin" /> )</option>
							                </s:iterator>
							            </select>
							        </div>
								</div>
								<div class="row" style="margin-left: 20px; margin-right: 20px; margin-bottom: 10px;">
									<div class="col-sm-5">Selectionner tout les élement du tableau</div>
									<div class="col-sm-2"><input id="selectAll" type="checkbox" class="js-switch" checked /></div>
									<div class="col-sm-5"><button type="submit" class="btn btn-primary">Marquer comme absence</button></div>
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
									<th>Cocher</th>
									<th>Prénom &amp; Nom</th>
									<th>Email</th>
									<th>Telephone</th>
									<th>Sexe</th>
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
										<td><input name="idCollaborateurs" value='<s:property value="collaborateur.idCollaborateur" />' type="checkbox" class="js-switch"/></td>
										<td class="  sorting_1"><s:property value="collaborateur.fullname" /></td>
										<td class=" "><s:property value="collaborateur.emailCollaborateur" /></td>
										<td class="hidden-phone "><s:property value="collaborateur.telephoneCollaborateur" /></td>
										<td class="center hidden-phone "><s:property value="collaborateur.sexeCollaborateur" /></td>
										
										<%-- <td class="center hidden-phone ">
											<ul style="list-style: none;" class="navbar-nav nav-options">
												<li style="padding-left: 15px;">
													<a title="Habilitations" href='<s:url action="collaborateurs/habilitations" ><s:param name="idCollaborateur"><s:property value="idCollaborateur"/></s:param></s:url>'>
														<i class="fa fa-list"></i>
													</a>
												</li>
												
												<li style="padding-left: 15px;">
													<a href='javascript:void(0);'
													   onclick="jsonGetCollaborateur(<s:property value="idCollaborateur"/>);" 
													   title="Mise à jour">
														<i class="fa fa-pencil"></i>
													</a>
												</li>
												
												<li style="padding-left: 15px;">
													<a data-href=<s:url action="collaborateurs/delete" ><s:param name="idCollaborateur"><s:property value="idCollaborateur"/></s:param></s:url> data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
														<i class="fa fa-times"></i>
													</a>
												</li>
												
												<li style="padding-left: 15px;">
													<a href='javascript:void(0);'
													   onclick="jsonGetCollaborateur_forSendEmail(<s:property value="idCollaborateur"/>);" 
													   title="Envoyer un email">
														<i class="fa fa-envelope"></i>
													</a>
												</li>
											</ul>
										</td> --%>
										
										<td style="display: none;"><s:property value="collaborateur.adresseCollaborateur" /></td>
										<td><s:property value="collaborateur.dateNaissanceCollaborateur" /></td>
										
										<td style="display: none;">
											<ul>
												<s:iterator value="collaborateur.habilitations">
													<li><s:property value="nomHabilitation" /></li>
												</s:iterator>
											</ul>
										</td>
										<td style="display: none;"><s:property value="collaborateur.urlPhotoCollaborateur" /></td>
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