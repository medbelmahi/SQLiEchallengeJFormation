<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Tableau des collaborateurs Start -->
<div class="row">
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
						<div class="btn-group">
							<a href="#addCollaborateurModal" data-toggle="modal">
								<button  class="btn btn-primary" >
									Ajouter Collaborateur <i class="fa fa-plus"></i>
								</button>
							</a>
						</div>
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="hidden-table-info">
							<thead>
								<tr role="row">
									<th class="text-centre">Prénom &amp; Nom</th>
									<th class="text-centre">Email</th>
									<th class="text-centre">Telephone</th>
									<th class="text-centre">Sexe</th>
									<th class="text-centre">Options</th>
									<th style="display: none;">Adresse</th>
									<th style="display: none;">Date de naissance</th>
									<th style="display: none;">habilitations</th>
									<th style="display: none;">image</th>
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="collaborateurs">
									<tr class="gradeA odd">
										<td class="  sorting_1"><s:property value="fullname" /></td>
										<td class=" "><s:property value="emailCollaborateur" /></td>
										<td class=""><s:property value="telephoneCollaborateur" /></td>
										<td class="text-center"><s:property value="sexeCollaborateur" /></td>
										
										<td class="center hidden-phone ">
											<ul style="list-style: none;" class="navbar-nav nav-options">
												<li style="padding-right: 15px;">
													<a title="Habilitations" href='<s:url action="collaborateurs/habilitations" ><s:param name="idCollaborateur"><s:property value="idCollaborateur"/></s:param></s:url>'>
														<i class="fa fa-ban"></i>
													</a>
												</li>
												
												<li style="padding-right: 15px;">
													<a href='javascript:void(0);'
													   onclick="jsonGetCollaborateur(<s:property value="idCollaborateur"/>);" 
													   title="Mise à jour">
														<i class="fa fa-pencil"></i>
													</a>
												</li>
												
												<li style="padding-right: 15px;">
													<a data-href=<s:url action="collaborateurs/delete" ><s:param name="idCollaborateur"><s:property value="idCollaborateur"/></s:param></s:url> data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
														<i class="fa fa-trash-o"></i>
													</a>
												</li>
												
												<li>
													<a href='javascript:void(0);'
													   onclick="jsonGetCollaborateur_forSendEmail(<s:property value="idCollaborateur"/>);" 
													   title="Envoyer un email">
														<i class="fa fa-envelope-o"></i>
													</a>
												</li>
											</ul>
										</td>
										
										<td style="display: none;"><s:property value="adresseCollaborateur" /></td>
										<td style="display: none;"><s:property value="dateNaissanceCollaborateur" /></td>
										
										<td style="display: none;">
											<ul>
												<s:iterator value="habilitations">
													<li><s:property value="nomHabilitation" /></li>
												</s:iterator>
											</ul>
										</td>
										<td style="display: none;"><s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="urlPhotoCollaborateur" />
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
</div>
<!-- Tableau des collaborateurs End -->